package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WeixiupingjiaEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WeixiupingjiaVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WeixiupingjiaView;


/**
 * 维修评价
 *
 * @author 
 * @email 
 * @date 2023-03-20 21:37:55
 */
public interface WeixiupingjiaService extends IService<WeixiupingjiaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WeixiupingjiaVO> selectListVO(Wrapper<WeixiupingjiaEntity> wrapper);
   	
   	WeixiupingjiaVO selectVO(@Param("ew") Wrapper<WeixiupingjiaEntity> wrapper);
   	
   	List<WeixiupingjiaView> selectListView(Wrapper<WeixiupingjiaEntity> wrapper);
   	
   	WeixiupingjiaView selectView(@Param("ew") Wrapper<WeixiupingjiaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WeixiupingjiaEntity> wrapper);
   	

}

