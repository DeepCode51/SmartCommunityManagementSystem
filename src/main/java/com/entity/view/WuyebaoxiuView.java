package com.entity.view;

import com.entity.WuyebaoxiuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 物业报修
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-03-20 21:37:55
 */
@TableName("wuyebaoxiu")
public class WuyebaoxiuView  extends WuyebaoxiuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public WuyebaoxiuView(){
	}
 
 	public WuyebaoxiuView(WuyebaoxiuEntity wuyebaoxiuEntity){
 	try {
			BeanUtils.copyProperties(this, wuyebaoxiuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
