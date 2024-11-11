package com.dao;

import com.entity.WuyejiaofeiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.WuyejiaofeiVO;
import com.entity.view.WuyejiaofeiView;


/**
 * 物业缴费
 * 
 * @author 
 * @email 
 * @date 2023-03-20 21:37:55
 */
public interface WuyejiaofeiDao extends BaseMapper<WuyejiaofeiEntity> {
	
	List<WuyejiaofeiVO> selectListVO(@Param("ew") Wrapper<WuyejiaofeiEntity> wrapper);
	
	WuyejiaofeiVO selectVO(@Param("ew") Wrapper<WuyejiaofeiEntity> wrapper);
	
	List<WuyejiaofeiView> selectListView(@Param("ew") Wrapper<WuyejiaofeiEntity> wrapper);

	List<WuyejiaofeiView> selectListView(Pagination page,@Param("ew") Wrapper<WuyejiaofeiEntity> wrapper);
	
	WuyejiaofeiView selectView(@Param("ew") Wrapper<WuyejiaofeiEntity> wrapper);
	

}
