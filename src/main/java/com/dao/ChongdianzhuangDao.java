package com.dao;

import com.entity.ChongdianzhuangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChongdianzhuangVO;
import com.entity.view.ChongdianzhuangView;


/**
 * 充电桩
 * 
 * @author 
 * @email 
 * @date 2023-03-20 21:37:55
 */
public interface ChongdianzhuangDao extends BaseMapper<ChongdianzhuangEntity> {
	
	List<ChongdianzhuangVO> selectListVO(@Param("ew") Wrapper<ChongdianzhuangEntity> wrapper);
	
	ChongdianzhuangVO selectVO(@Param("ew") Wrapper<ChongdianzhuangEntity> wrapper);
	
	List<ChongdianzhuangView> selectListView(@Param("ew") Wrapper<ChongdianzhuangEntity> wrapper);

	List<ChongdianzhuangView> selectListView(Pagination page,@Param("ew") Wrapper<ChongdianzhuangEntity> wrapper);
	
	ChongdianzhuangView selectView(@Param("ew") Wrapper<ChongdianzhuangEntity> wrapper);
	

}
