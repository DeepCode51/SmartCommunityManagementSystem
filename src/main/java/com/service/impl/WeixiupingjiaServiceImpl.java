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


import com.dao.WeixiupingjiaDao;
import com.entity.WeixiupingjiaEntity;
import com.service.WeixiupingjiaService;
import com.entity.vo.WeixiupingjiaVO;
import com.entity.view.WeixiupingjiaView;

@Service("weixiupingjiaService")
public class WeixiupingjiaServiceImpl extends ServiceImpl<WeixiupingjiaDao, WeixiupingjiaEntity> implements WeixiupingjiaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WeixiupingjiaEntity> page = this.selectPage(
                new Query<WeixiupingjiaEntity>(params).getPage(),
                new EntityWrapper<WeixiupingjiaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WeixiupingjiaEntity> wrapper) {
		  Page<WeixiupingjiaView> page =new Query<WeixiupingjiaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<WeixiupingjiaVO> selectListVO(Wrapper<WeixiupingjiaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WeixiupingjiaVO selectVO(Wrapper<WeixiupingjiaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WeixiupingjiaView> selectListView(Wrapper<WeixiupingjiaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WeixiupingjiaView selectView(Wrapper<WeixiupingjiaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
