package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WeixiuqingdanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WeixiuqingdanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WeixiuqingdanView;


/**
 * 维修清单
 *
 * @author 
 * @email 
 * @date 2023-03-20 21:37:55
 */
public interface WeixiuqingdanService extends IService<WeixiuqingdanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WeixiuqingdanVO> selectListVO(Wrapper<WeixiuqingdanEntity> wrapper);
   	
   	WeixiuqingdanVO selectVO(@Param("ew") Wrapper<WeixiuqingdanEntity> wrapper);
   	
   	List<WeixiuqingdanView> selectListView(Wrapper<WeixiuqingdanEntity> wrapper);
   	
   	WeixiuqingdanView selectView(@Param("ew") Wrapper<WeixiuqingdanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WeixiuqingdanEntity> wrapper);
   	

}

