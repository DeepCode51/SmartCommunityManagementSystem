package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WuyebaoxiuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WuyebaoxiuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WuyebaoxiuView;


/**
 * 物业报修
 *
 * @author 
 * @email 
 * @date 2023-03-20 21:37:55
 */
public interface WuyebaoxiuService extends IService<WuyebaoxiuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WuyebaoxiuVO> selectListVO(Wrapper<WuyebaoxiuEntity> wrapper);
   	
   	WuyebaoxiuVO selectVO(@Param("ew") Wrapper<WuyebaoxiuEntity> wrapper);
   	
   	List<WuyebaoxiuView> selectListView(Wrapper<WuyebaoxiuEntity> wrapper);
   	
   	WuyebaoxiuView selectView(@Param("ew") Wrapper<WuyebaoxiuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WuyebaoxiuEntity> wrapper);
   	

}

