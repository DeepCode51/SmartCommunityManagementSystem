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


import com.dao.ZhihuimenjinDao;
import com.entity.ZhihuimenjinEntity;
import com.service.ZhihuimenjinService;
import com.entity.vo.ZhihuimenjinVO;
import com.entity.view.ZhihuimenjinView;

@Service("zhihuimenjinService")
public class ZhihuimenjinServiceImpl extends ServiceImpl<ZhihuimenjinDao, ZhihuimenjinEntity> implements ZhihuimenjinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhihuimenjinEntity> page = this.selectPage(
                new Query<ZhihuimenjinEntity>(params).getPage(),
                new EntityWrapper<ZhihuimenjinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhihuimenjinEntity> wrapper) {
		  Page<ZhihuimenjinView> page =new Query<ZhihuimenjinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhihuimenjinVO> selectListVO(Wrapper<ZhihuimenjinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhihuimenjinVO selectVO(Wrapper<ZhihuimenjinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhihuimenjinView> selectListView(Wrapper<ZhihuimenjinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhihuimenjinView selectView(Wrapper<ZhihuimenjinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
