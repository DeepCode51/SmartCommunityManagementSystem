package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhihuimenjinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhihuimenjinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhihuimenjinView;


/**
 * 智慧门禁
 *
 * @author 
 * @email 
 * @date 2023-03-20 21:37:55
 */
public interface ZhihuimenjinService extends IService<ZhihuimenjinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhihuimenjinVO> selectListVO(Wrapper<ZhihuimenjinEntity> wrapper);
   	
   	ZhihuimenjinVO selectVO(@Param("ew") Wrapper<ZhihuimenjinEntity> wrapper);
   	
   	List<ZhihuimenjinView> selectListView(Wrapper<ZhihuimenjinEntity> wrapper);
   	
   	ZhihuimenjinView selectView(@Param("ew") Wrapper<ZhihuimenjinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhihuimenjinEntity> wrapper);
   	

}

