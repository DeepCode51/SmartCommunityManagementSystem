package com.dao;

import com.entity.YezhuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YezhuxinxiVO;
import com.entity.view.YezhuxinxiView;


/**
 * 业主信息
 * 
 * @author 
 * @email 
 * @date 2023-03-20 21:37:54
 */
public interface YezhuxinxiDao extends BaseMapper<YezhuxinxiEntity> {
	
	List<YezhuxinxiVO> selectListVO(@Param("ew") Wrapper<YezhuxinxiEntity> wrapper);
	
	YezhuxinxiVO selectVO(@Param("ew") Wrapper<YezhuxinxiEntity> wrapper);
	
	List<YezhuxinxiView> selectListView(@Param("ew") Wrapper<YezhuxinxiEntity> wrapper);

	List<YezhuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<YezhuxinxiEntity> wrapper);
	
	YezhuxinxiView selectView(@Param("ew") Wrapper<YezhuxinxiEntity> wrapper);
	

}
