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


import com.dao.YezhuxinxiDao;
import com.entity.YezhuxinxiEntity;
import com.service.YezhuxinxiService;
import com.entity.vo.YezhuxinxiVO;
import com.entity.view.YezhuxinxiView;

@Service("yezhuxinxiService")
public class YezhuxinxiServiceImpl extends ServiceImpl<YezhuxinxiDao, YezhuxinxiEntity> implements YezhuxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YezhuxinxiEntity> page = this.selectPage(
                new Query<YezhuxinxiEntity>(params).getPage(),
                new EntityWrapper<YezhuxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YezhuxinxiEntity> wrapper) {
		  Page<YezhuxinxiView> page =new Query<YezhuxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YezhuxinxiVO> selectListVO(Wrapper<YezhuxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YezhuxinxiVO selectVO(Wrapper<YezhuxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YezhuxinxiView> selectListView(Wrapper<YezhuxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YezhuxinxiView selectView(Wrapper<YezhuxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
