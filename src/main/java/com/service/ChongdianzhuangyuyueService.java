package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChongdianzhuangyuyueEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChongdianzhuangyuyueVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChongdianzhuangyuyueView;


/**
 * 充电桩预约
 *
 * @author 
 * @email 
 * @date 2023-03-20 21:37:55
 */
public interface ChongdianzhuangyuyueService extends IService<ChongdianzhuangyuyueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChongdianzhuangyuyueVO> selectListVO(Wrapper<ChongdianzhuangyuyueEntity> wrapper);
   	
   	ChongdianzhuangyuyueVO selectVO(@Param("ew") Wrapper<ChongdianzhuangyuyueEntity> wrapper);
   	
   	List<ChongdianzhuangyuyueView> selectListView(Wrapper<ChongdianzhuangyuyueEntity> wrapper);
   	
   	ChongdianzhuangyuyueView selectView(@Param("ew") Wrapper<ChongdianzhuangyuyueEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChongdianzhuangyuyueEntity> wrapper);
   	

}

