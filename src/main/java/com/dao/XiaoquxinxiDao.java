package com.dao;

import com.entity.XiaoquxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XiaoquxinxiVO;
import com.entity.view.XiaoquxinxiView;


/**
 * 小区信息
 * 
 * @author 
 * @email 
 * @date 2023-03-20 21:37:55
 */
public interface XiaoquxinxiDao extends BaseMapper<XiaoquxinxiEntity> {
	
	List<XiaoquxinxiVO> selectListVO(@Param("ew") Wrapper<XiaoquxinxiEntity> wrapper);
	
	XiaoquxinxiVO selectVO(@Param("ew") Wrapper<XiaoquxinxiEntity> wrapper);
	
	List<XiaoquxinxiView> selectListView(@Param("ew") Wrapper<XiaoquxinxiEntity> wrapper);

	List<XiaoquxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<XiaoquxinxiEntity> wrapper);
	
	XiaoquxinxiView selectView(@Param("ew") Wrapper<XiaoquxinxiEntity> wrapper);
	

}
