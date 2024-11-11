package com.dao;

import com.entity.JuminxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JuminxinxiVO;
import com.entity.view.JuminxinxiView;


/**
 * 居民信息
 * 
 * @author 
 * @email 
 * @date 2023-03-20 21:37:55
 */
public interface JuminxinxiDao extends BaseMapper<JuminxinxiEntity> {
	
	List<JuminxinxiVO> selectListVO(@Param("ew") Wrapper<JuminxinxiEntity> wrapper);
	
	JuminxinxiVO selectVO(@Param("ew") Wrapper<JuminxinxiEntity> wrapper);
	
	List<JuminxinxiView> selectListView(@Param("ew") Wrapper<JuminxinxiEntity> wrapper);

	List<JuminxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<JuminxinxiEntity> wrapper);
	
	JuminxinxiView selectView(@Param("ew") Wrapper<JuminxinxiEntity> wrapper);
	

}
