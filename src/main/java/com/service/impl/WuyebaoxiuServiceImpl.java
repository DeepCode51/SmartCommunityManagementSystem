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


import com.dao.WuyebaoxiuDao;
import com.entity.WuyebaoxiuEntity;
import com.service.WuyebaoxiuService;
import com.entity.vo.WuyebaoxiuVO;
import com.entity.view.WuyebaoxiuView;

@Service("wuyebaoxiuService")
public class WuyebaoxiuServiceImpl extends ServiceImpl<WuyebaoxiuDao, WuyebaoxiuEntity> implements WuyebaoxiuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WuyebaoxiuEntity> page = this.selectPage(
                new Query<WuyebaoxiuEntity>(params).getPage(),
                new EntityWrapper<WuyebaoxiuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WuyebaoxiuEntity> wrapper) {
		  Page<WuyebaoxiuView> page =new Query<WuyebaoxiuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<WuyebaoxiuVO> selectListVO(Wrapper<WuyebaoxiuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WuyebaoxiuVO selectVO(Wrapper<WuyebaoxiuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WuyebaoxiuView> selectListView(Wrapper<WuyebaoxiuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WuyebaoxiuView selectView(Wrapper<WuyebaoxiuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
