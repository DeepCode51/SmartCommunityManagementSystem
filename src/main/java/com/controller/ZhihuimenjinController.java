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

import com.entity.ZhihuimenjinEntity;
import com.entity.view.ZhihuimenjinView;

import com.service.ZhihuimenjinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 智慧门禁
 * 后端接口
 * @author 
 * @email 
 * @date 2023-03-20 21:37:55
 */
@RestController
@RequestMapping("/zhihuimenjin")
public class ZhihuimenjinController {
    @Autowired
    private ZhihuimenjinService zhihuimenjinService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhihuimenjinEntity zhihuimenjin,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yezhuxinxi")) {
			zhihuimenjin.setYezhuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZhihuimenjinEntity> ew = new EntityWrapper<ZhihuimenjinEntity>();

		PageUtils page = zhihuimenjinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhihuimenjin), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhihuimenjinEntity zhihuimenjin, 
		HttpServletRequest request){
        EntityWrapper<ZhihuimenjinEntity> ew = new EntityWrapper<ZhihuimenjinEntity>();

		PageUtils page = zhihuimenjinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhihuimenjin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhihuimenjinEntity zhihuimenjin){
       	EntityWrapper<ZhihuimenjinEntity> ew = new EntityWrapper<ZhihuimenjinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhihuimenjin, "zhihuimenjin")); 
        return R.ok().put("data", zhihuimenjinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhihuimenjinEntity zhihuimenjin){
        EntityWrapper< ZhihuimenjinEntity> ew = new EntityWrapper< ZhihuimenjinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhihuimenjin, "zhihuimenjin")); 
		ZhihuimenjinView zhihuimenjinView =  zhihuimenjinService.selectView(ew);
		return R.ok("查询智慧门禁成功").put("data", zhihuimenjinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhihuimenjinEntity zhihuimenjin = zhihuimenjinService.selectById(id);
        return R.ok().put("data", zhihuimenjin);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhihuimenjinEntity zhihuimenjin = zhihuimenjinService.selectById(id);
        return R.ok().put("data", zhihuimenjin);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhihuimenjinEntity zhihuimenjin, HttpServletRequest request){
    	zhihuimenjin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhihuimenjin);
        zhihuimenjinService.insert(zhihuimenjin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
	@IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody ZhihuimenjinEntity zhihuimenjin, HttpServletRequest request){
    	zhihuimenjin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhihuimenjin);
        zhihuimenjinService.insert(zhihuimenjin);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhihuimenjinEntity zhihuimenjin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhihuimenjin);
        zhihuimenjinService.updateById(zhihuimenjin);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhihuimenjinService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<ZhihuimenjinEntity> wrapper = new EntityWrapper<ZhihuimenjinEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yezhuxinxi")) {
			wrapper.eq("yezhuzhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = zhihuimenjinService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
