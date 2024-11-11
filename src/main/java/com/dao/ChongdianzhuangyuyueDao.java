package com.dao;

import com.entity.ChongdianzhuangyuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChongdianzhuangyuyueVO;
import com.entity.view.ChongdianzhuangyuyueView;


/**
 * 充电桩预约
 * 
 * @author 
 * @email 
 * @date 2023-03-20 21:37:55
 */
public interface ChongdianzhuangyuyueDao extends BaseMapper<ChongdianzhuangyuyueEntity> {
	
	List<ChongdianzhuangyuyueVO> selectListVO(@Param("ew") Wrapper<ChongdianzhuangyuyueEntity> wrapper);
	
	ChongdianzhuangyuyueVO selectVO(@Param("ew") Wrapper<ChongdianzhuangyuyueEntity> wrapper);
	
	List<ChongdianzhuangyuyueView> selectListView(@Param("ew") Wrapper<ChongdianzhuangyuyueEntity> wrapper);

	List<ChongdianzhuangyuyueView> selectListView(Pagination page,@Param("ew") Wrapper<ChongdianzhuangyuyueEntity> wrapper);
	
	ChongdianzhuangyuyueView selectView(@Param("ew") Wrapper<ChongdianzhuangyuyueEntity> wrapper);
	

}
