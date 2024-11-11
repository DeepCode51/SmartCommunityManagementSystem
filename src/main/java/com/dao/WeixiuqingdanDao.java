package com.dao;

import com.entity.WeixiuqingdanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.WeixiuqingdanVO;
import com.entity.view.WeixiuqingdanView;


/**
 * 维修清单
 * 
 * @author 
 * @email 
 * @date 2023-03-20 21:37:55
 */
public interface WeixiuqingdanDao extends BaseMapper<WeixiuqingdanEntity> {
	
	List<WeixiuqingdanVO> selectListVO(@Param("ew") Wrapper<WeixiuqingdanEntity> wrapper);
	
	WeixiuqingdanVO selectVO(@Param("ew") Wrapper<WeixiuqingdanEntity> wrapper);
	
	List<WeixiuqingdanView> selectListView(@Param("ew") Wrapper<WeixiuqingdanEntity> wrapper);

	List<WeixiuqingdanView> selectListView(Pagination page,@Param("ew") Wrapper<WeixiuqingdanEntity> wrapper);
	
	WeixiuqingdanView selectView(@Param("ew") Wrapper<WeixiuqingdanEntity> wrapper);
	

}
