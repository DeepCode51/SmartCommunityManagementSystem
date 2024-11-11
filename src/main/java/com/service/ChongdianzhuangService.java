package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChongdianzhuangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChongdianzhuangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChongdianzhuangView;


/**
 * 充电桩
 *
 * @author 
 * @email 
 * @date 2023-03-20 21:37:55
 */
public interface ChongdianzhuangService extends IService<ChongdianzhuangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChongdianzhuangVO> selectListVO(Wrapper<ChongdianzhuangEntity> wrapper);
   	
   	ChongdianzhuangVO selectVO(@Param("ew") Wrapper<ChongdianzhuangEntity> wrapper);
   	
   	List<ChongdianzhuangView> selectListView(Wrapper<ChongdianzhuangEntity> wrapper);
   	
   	ChongdianzhuangView selectView(@Param("ew") Wrapper<ChongdianzhuangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChongdianzhuangEntity> wrapper);
   	

}

