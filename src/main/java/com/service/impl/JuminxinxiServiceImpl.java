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


import com.dao.JuminxinxiDao;
import com.entity.JuminxinxiEntity;
import com.service.JuminxinxiService;
import com.entity.vo.JuminxinxiVO;
import com.entity.view.JuminxinxiView;

@Service("juminxinxiService")
public class JuminxinxiServiceImpl extends ServiceImpl<JuminxinxiDao, JuminxinxiEntity> implements JuminxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JuminxinxiEntity> page = this.selectPage(
                new Query<JuminxinxiEntity>(params).getPage(),
                new EntityWrapper<JuminxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JuminxinxiEntity> wrapper) {
		  Page<JuminxinxiView> page =new Query<JuminxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JuminxinxiVO> selectListVO(Wrapper<JuminxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JuminxinxiVO selectVO(Wrapper<JuminxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JuminxinxiView> selectListView(Wrapper<JuminxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JuminxinxiView selectView(Wrapper<JuminxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
