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

import com.entity.ChongdianzhuangEntity;
import com.entity.view.ChongdianzhuangView;

import com.service.ChongdianzhuangService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 充电桩
 * 后端接口
 * @author 
 * @email 
 * @date 2023-03-20 21:37:55
 */
@RestController
@RequestMapping("/chongdianzhuang")
public class ChongdianzhuangController {
    @Autowired
    private ChongdianzhuangService chongdianzhuangService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChongdianzhuangEntity chongdianzhuang,
                @RequestParam(required = false) Double xiaoshidanjiastart,
                @RequestParam(required = false) Double xiaoshidanjiaend,
		HttpServletRequest request){
        EntityWrapper<ChongdianzhuangEntity> ew = new EntityWrapper<ChongdianzhuangEntity>();
                if(xiaoshidanjiastart!=null) ew.ge("xiaoshidanjia", xiaoshidanjiastart);
                if(xiaoshidanjiaend!=null) ew.le("xiaoshidanjia", xiaoshidanjiaend);

		PageUtils page = chongdianzhuangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chongdianzhuang), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChongdianzhuangEntity chongdianzhuang, 
                @RequestParam(required = false) Double xiaoshidanjiastart,
                @RequestParam(required = false) Double xiaoshidanjiaend,
		HttpServletRequest request){
        EntityWrapper<ChongdianzhuangEntity> ew = new EntityWrapper<ChongdianzhuangEntity>();
                if(xiaoshidanjiastart!=null) ew.ge("xiaoshidanjia", xiaoshidanjiastart);
                if(xiaoshidanjiaend!=null) ew.le("xiaoshidanjia", xiaoshidanjiaend);

		PageUtils page = chongdianzhuangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chongdianzhuang), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChongdianzhuangEntity chongdianzhuang){
       	EntityWrapper<ChongdianzhuangEntity> ew = new EntityWrapper<ChongdianzhuangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( chongdianzhuang, "chongdianzhuang")); 
        return R.ok().put("data", chongdianzhuangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChongdianzhuangEntity chongdianzhuang){
        EntityWrapper< ChongdianzhuangEntity> ew = new EntityWrapper< ChongdianzhuangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( chongdianzhuang, "chongdianzhuang")); 
		ChongdianzhuangView chongdianzhuangView =  chongdianzhuangService.selectView(ew);
		return R.ok("查询充电桩成功").put("data", chongdianzhuangView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChongdianzhuangEntity chongdianzhuang = chongdianzhuangService.selectById(id);
        return R.ok().put("data", chongdianzhuang);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChongdianzhuangEntity chongdianzhuang = chongdianzhuangService.selectById(id);
        return R.ok().put("data", chongdianzhuang);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChongdianzhuangEntity chongdianzhuang, HttpServletRequest request){
    	chongdianzhuang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chongdianzhuang);
        chongdianzhuangService.insert(chongdianzhuang);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChongdianzhuangEntity chongdianzhuang, HttpServletRequest request){
    	chongdianzhuang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chongdianzhuang);
        chongdianzhuangService.insert(chongdianzhuang);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChongdianzhuangEntity chongdianzhuang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chongdianzhuang);
        chongdianzhuangService.updateById(chongdianzhuang);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        chongdianzhuangService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<ChongdianzhuangEntity> wrapper = new EntityWrapper<ChongdianzhuangEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = chongdianzhuangService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
