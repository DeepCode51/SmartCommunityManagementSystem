package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.YezhuxinxiEntity;
import com.entity.view.YezhuxinxiView;

import com.service.YezhuxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 业主信息
 * 后端接口
 * @author 
 * @email 
 * @date 2023-03-20 21:37:54
 */
@RestController
@RequestMapping("/yezhuxinxi")
public class YezhuxinxiController {
    @Autowired
    private YezhuxinxiService yezhuxinxiService;


    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		YezhuxinxiEntity u = yezhuxinxiService.selectOne(new EntityWrapper<YezhuxinxiEntity>().eq("yezhuzhanghao", username));
		if(u==null || !u.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		
		String token = tokenService.generateToken(u.getId(), username,"yezhuxinxi",  "业主信息" );
		return R.ok().put("token", token);
	}

	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody YezhuxinxiEntity yezhuxinxi){
    	//ValidatorUtils.validateEntity(yezhuxinxi);
    	YezhuxinxiEntity u = yezhuxinxiService.selectOne(new EntityWrapper<YezhuxinxiEntity>().eq("yezhuzhanghao", yezhuxinxi.getYezhuzhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		yezhuxinxi.setId(uId);
        yezhuxinxiService.insert(yezhuxinxi);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        YezhuxinxiEntity u = yezhuxinxiService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	YezhuxinxiEntity u = yezhuxinxiService.selectOne(new EntityWrapper<YezhuxinxiEntity>().eq("yezhuzhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        yezhuxinxiService.updateById(u);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YezhuxinxiEntity yezhuxinxi,
		HttpServletRequest request){
        EntityWrapper<YezhuxinxiEntity> ew = new EntityWrapper<YezhuxinxiEntity>();

		PageUtils page = yezhuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yezhuxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YezhuxinxiEntity yezhuxinxi, 
		HttpServletRequest request){
        EntityWrapper<YezhuxinxiEntity> ew = new EntityWrapper<YezhuxinxiEntity>();

		PageUtils page = yezhuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yezhuxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YezhuxinxiEntity yezhuxinxi){
       	EntityWrapper<YezhuxinxiEntity> ew = new EntityWrapper<YezhuxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yezhuxinxi, "yezhuxinxi")); 
        return R.ok().put("data", yezhuxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YezhuxinxiEntity yezhuxinxi){
        EntityWrapper< YezhuxinxiEntity> ew = new EntityWrapper< YezhuxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yezhuxinxi, "yezhuxinxi")); 
		YezhuxinxiView yezhuxinxiView =  yezhuxinxiService.selectView(ew);
		return R.ok("查询业主信息成功").put("data", yezhuxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YezhuxinxiEntity yezhuxinxi = yezhuxinxiService.selectById(id);
        return R.ok().put("data", yezhuxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YezhuxinxiEntity yezhuxinxi = yezhuxinxiService.selectById(id);
        return R.ok().put("data", yezhuxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YezhuxinxiEntity yezhuxinxi, HttpServletRequest request){
    	yezhuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yezhuxinxi);
    	YezhuxinxiEntity u = yezhuxinxiService.selectOne(new EntityWrapper<YezhuxinxiEntity>().eq("yezhuzhanghao", yezhuxinxi.getYezhuzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		yezhuxinxi.setId(new Date().getTime());
        yezhuxinxiService.insert(yezhuxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YezhuxinxiEntity yezhuxinxi, HttpServletRequest request){
    	yezhuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yezhuxinxi);
    	YezhuxinxiEntity u = yezhuxinxiService.selectOne(new EntityWrapper<YezhuxinxiEntity>().eq("yezhuzhanghao", yezhuxinxi.getYezhuzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		yezhuxinxi.setId(new Date().getTime());
        yezhuxinxiService.insert(yezhuxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YezhuxinxiEntity yezhuxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yezhuxinxi);
        yezhuxinxiService.updateById(yezhuxinxi);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yezhuxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<YezhuxinxiEntity> wrapper = new EntityWrapper<YezhuxinxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = yezhuxinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
