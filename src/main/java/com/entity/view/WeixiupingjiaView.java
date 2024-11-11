package com.entity.view;

import com.entity.WeixiupingjiaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 维修评价
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-03-20 21:37:55
 */
@TableName("weixiupingjia")
public class WeixiupingjiaView  extends WeixiupingjiaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public WeixiupingjiaView(){
	}
 
 	public WeixiupingjiaView(WeixiupingjiaEntity weixiupingjiaEntity){
 	try {
			BeanUtils.copyProperties(this, weixiupingjiaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
