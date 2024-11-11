package com.dao;

import com.entity.WeixiupingjiaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.WeixiupingjiaVO;
import com.entity.view.WeixiupingjiaView;


/**
 * 维修评价
 * 
 * @author 
 * @email 
 * @date 2023-03-20 21:37:55
 */
public interface WeixiupingjiaDao extends BaseMapper<WeixiupingjiaEntity> {
	
	List<WeixiupingjiaVO> selectListVO(@Param("ew") Wrapper<WeixiupingjiaEntity> wrapper);
	
	WeixiupingjiaVO selectVO(@Param("ew") Wrapper<WeixiupingjiaEntity> wrapper);
	
	List<WeixiupingjiaView> selectListView(@Param("ew") Wrapper<WeixiupingjiaEntity> wrapper);

	List<WeixiupingjiaView> selectListView(Pagination page,@Param("ew") Wrapper<WeixiupingjiaEntity> wrapper);
	
	WeixiupingjiaView selectView(@Param("ew") Wrapper<WeixiupingjiaEntity> wrapper);
	

}
