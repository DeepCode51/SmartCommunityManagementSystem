package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YezhuxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YezhuxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YezhuxinxiView;


/**
 * 业主信息
 *
 * @author 
 * @email 
 * @date 2023-03-20 21:37:54
 */
public interface YezhuxinxiService extends IService<YezhuxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YezhuxinxiVO> selectListVO(Wrapper<YezhuxinxiEntity> wrapper);
   	
   	YezhuxinxiVO selectVO(@Param("ew") Wrapper<YezhuxinxiEntity> wrapper);
   	
   	List<YezhuxinxiView> selectListView(Wrapper<YezhuxinxiEntity> wrapper);
   	
   	YezhuxinxiView selectView(@Param("ew") Wrapper<YezhuxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YezhuxinxiEntity> wrapper);
   	

}

