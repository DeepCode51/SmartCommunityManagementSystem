package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JuminxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JuminxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JuminxinxiView;


/**
 * 居民信息
 *
 * @author 
 * @email 
 * @date 2023-03-20 21:37:55
 */
public interface JuminxinxiService extends IService<JuminxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JuminxinxiVO> selectListVO(Wrapper<JuminxinxiEntity> wrapper);
   	
   	JuminxinxiVO selectVO(@Param("ew") Wrapper<JuminxinxiEntity> wrapper);
   	
   	List<JuminxinxiView> selectListView(Wrapper<JuminxinxiEntity> wrapper);
   	
   	JuminxinxiView selectView(@Param("ew") Wrapper<JuminxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JuminxinxiEntity> wrapper);
   	

}

