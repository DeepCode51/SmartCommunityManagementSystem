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


import com.dao.WuyejiaofeiDao;
import com.entity.WuyejiaofeiEntity;
import com.service.WuyejiaofeiService;
import com.entity.vo.WuyejiaofeiVO;
import com.entity.view.WuyejiaofeiView;

@Service("wuyejiaofeiService")
public class WuyejiaofeiServiceImpl extends ServiceImpl<WuyejiaofeiDao, WuyejiaofeiEntity> implements WuyejiaofeiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WuyejiaofeiEntity> page = this.selectPage(
                new Query<WuyejiaofeiEntity>(params).getPage(),
                new EntityWrapper<WuyejiaofeiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WuyejiaofeiEntity> wrapper) {
		  Page<WuyejiaofeiView> page =new Query<WuyejiaofeiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<WuyejiaofeiVO> selectListVO(Wrapper<WuyejiaofeiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WuyejiaofeiVO selectVO(Wrapper<WuyejiaofeiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WuyejiaofeiView> selectListView(Wrapper<WuyejiaofeiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WuyejiaofeiView selectView(Wrapper<WuyejiaofeiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
