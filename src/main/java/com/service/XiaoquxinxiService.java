package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XiaoquxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XiaoquxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XiaoquxinxiView;


/**
 * 小区信息
 *
 * @author 
 * @email 
 * @date 2023-03-20 21:37:55
 */
public interface XiaoquxinxiService extends IService<XiaoquxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XiaoquxinxiVO> selectListVO(Wrapper<XiaoquxinxiEntity> wrapper);
   	
   	XiaoquxinxiVO selectVO(@Param("ew") Wrapper<XiaoquxinxiEntity> wrapper);
   	
   	List<XiaoquxinxiView> selectListView(Wrapper<XiaoquxinxiEntity> wrapper);
   	
   	XiaoquxinxiView selectView(@Param("ew") Wrapper<XiaoquxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XiaoquxinxiEntity> wrapper);
   	

}

