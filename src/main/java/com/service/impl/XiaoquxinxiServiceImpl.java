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


import com.dao.XiaoquxinxiDao;
import com.entity.XiaoquxinxiEntity;
import com.service.XiaoquxinxiService;
import com.entity.vo.XiaoquxinxiVO;
import com.entity.view.XiaoquxinxiView;

@Service("xiaoquxinxiService")
public class XiaoquxinxiServiceImpl extends ServiceImpl<XiaoquxinxiDao, XiaoquxinxiEntity> implements XiaoquxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XiaoquxinxiEntity> page = this.selectPage(
                new Query<XiaoquxinxiEntity>(params).getPage(),
                new EntityWrapper<XiaoquxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XiaoquxinxiEntity> wrapper) {
		  Page<XiaoquxinxiView> page =new Query<XiaoquxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XiaoquxinxiVO> selectListVO(Wrapper<XiaoquxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XiaoquxinxiVO selectVO(Wrapper<XiaoquxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XiaoquxinxiView> selectListView(Wrapper<XiaoquxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XiaoquxinxiView selectView(Wrapper<XiaoquxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
