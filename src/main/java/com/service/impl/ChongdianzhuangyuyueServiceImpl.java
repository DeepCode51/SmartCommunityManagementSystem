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


import com.dao.ChongdianzhuangyuyueDao;
import com.entity.ChongdianzhuangyuyueEntity;
import com.service.ChongdianzhuangyuyueService;
import com.entity.vo.ChongdianzhuangyuyueVO;
import com.entity.view.ChongdianzhuangyuyueView;

@Service("chongdianzhuangyuyueService")
public class ChongdianzhuangyuyueServiceImpl extends ServiceImpl<ChongdianzhuangyuyueDao, ChongdianzhuangyuyueEntity> implements ChongdianzhuangyuyueService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChongdianzhuangyuyueEntity> page = this.selectPage(
                new Query<ChongdianzhuangyuyueEntity>(params).getPage(),
                new EntityWrapper<ChongdianzhuangyuyueEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChongdianzhuangyuyueEntity> wrapper) {
		  Page<ChongdianzhuangyuyueView> page =new Query<ChongdianzhuangyuyueView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ChongdianzhuangyuyueVO> selectListVO(Wrapper<ChongdianzhuangyuyueEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChongdianzhuangyuyueVO selectVO(Wrapper<ChongdianzhuangyuyueEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChongdianzhuangyuyueView> selectListView(Wrapper<ChongdianzhuangyuyueEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChongdianzhuangyuyueView selectView(Wrapper<ChongdianzhuangyuyueEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
