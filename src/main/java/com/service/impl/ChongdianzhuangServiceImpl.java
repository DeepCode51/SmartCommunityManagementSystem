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


import com.dao.ChongdianzhuangDao;
import com.entity.ChongdianzhuangEntity;
import com.service.ChongdianzhuangService;
import com.entity.vo.ChongdianzhuangVO;
import com.entity.view.ChongdianzhuangView;

@Service("chongdianzhuangService")
public class ChongdianzhuangServiceImpl extends ServiceImpl<ChongdianzhuangDao, ChongdianzhuangEntity> implements ChongdianzhuangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChongdianzhuangEntity> page = this.selectPage(
                new Query<ChongdianzhuangEntity>(params).getPage(),
                new EntityWrapper<ChongdianzhuangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChongdianzhuangEntity> wrapper) {
		  Page<ChongdianzhuangView> page =new Query<ChongdianzhuangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ChongdianzhuangVO> selectListVO(Wrapper<ChongdianzhuangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChongdianzhuangVO selectVO(Wrapper<ChongdianzhuangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChongdianzhuangView> selectListView(Wrapper<ChongdianzhuangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChongdianzhuangView selectView(Wrapper<ChongdianzhuangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
