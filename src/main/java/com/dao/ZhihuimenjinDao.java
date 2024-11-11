package com.dao;

import com.entity.ZhihuimenjinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhihuimenjinVO;
import com.entity.view.ZhihuimenjinView;


/**
 * 智慧门禁
 * 
 * @author 
 * @email 
 * @date 2023-03-20 21:37:55
 */
public interface ZhihuimenjinDao extends BaseMapper<ZhihuimenjinEntity> {
	
	List<ZhihuimenjinVO> selectListVO(@Param("ew") Wrapper<ZhihuimenjinEntity> wrapper);
	
	ZhihuimenjinVO selectVO(@Param("ew") Wrapper<ZhihuimenjinEntity> wrapper);
	
	List<ZhihuimenjinView> selectListView(@Param("ew") Wrapper<ZhihuimenjinEntity> wrapper);

	List<ZhihuimenjinView> selectListView(Pagination page,@Param("ew") Wrapper<ZhihuimenjinEntity> wrapper);
	
	ZhihuimenjinView selectView(@Param("ew") Wrapper<ZhihuimenjinEntity> wrapper);
	

}
