package com.dao;

import com.entity.WuyebaoxiuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.WuyebaoxiuVO;
import com.entity.view.WuyebaoxiuView;


/**
 * 物业报修
 * 
 * @author 
 * @email 
 * @date 2023-03-20 21:37:55
 */
public interface WuyebaoxiuDao extends BaseMapper<WuyebaoxiuEntity> {
	
	List<WuyebaoxiuVO> selectListVO(@Param("ew") Wrapper<WuyebaoxiuEntity> wrapper);
	
	WuyebaoxiuVO selectVO(@Param("ew") Wrapper<WuyebaoxiuEntity> wrapper);
	
	List<WuyebaoxiuView> selectListView(@Param("ew") Wrapper<WuyebaoxiuEntity> wrapper);

	List<WuyebaoxiuView> selectListView(Pagination page,@Param("ew") Wrapper<WuyebaoxiuEntity> wrapper);
	
	WuyebaoxiuView selectView(@Param("ew") Wrapper<WuyebaoxiuEntity> wrapper);
	

}
