package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.WeixiuqingdanDao;
import com.entity.WeixiuqingdanEntity;
import com.service.WeixiuqingdanService;
import com.entity.vo.WeixiuqingdanVO;
import com.entity.view.WeixiuqingdanView;

@Service("weixiuqingdanService")
public class WeixiuqingdanServiceImpl extends ServiceImpl<WeixiuqingdanDao, WeixiuqingdanEntity> implements WeixiuqingdanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WeixiuqingdanEntity> page = this.selectPage(
                new Query<WeixiuqingdanEntity>(params).getPage(),
                new EntityWrapper<WeixiuqingdanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WeixiuqingdanEntity> wrapper) {
		  Page<WeixiuqingdanView> page =new Query<WeixiuqingdanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<WeixiuqingdanVO> selectListVO(Wrapper<WeixiuqingdanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WeixiuqingdanVO selectVO(Wrapper<WeixiuqingdanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WeixiuqingdanView> selectListView(Wrapper<WeixiuqingdanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WeixiuqingdanView selectView(Wrapper<WeixiuqingdanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
