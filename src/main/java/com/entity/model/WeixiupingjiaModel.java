package com.entity.model;

import com.entity.WeixiupingjiaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 维修评价
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-03-20 21:37:55
 */
public class WeixiupingjiaModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 维修水平
	 */
	
	private String weixiushuiping;
		
	/**
	 * 整体评价
	 */
	
	private String zhengtipingjia;
		
	/**
	 * 评价日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date pingjiariqi;
		
	/**
	 * 业主账号
	 */
	
	private String yezhuzhanghao;
		
	/**
	 * 业主姓名
	 */
	
	private String yezhuxingming;
				
	
	/**
	 * 设置：维修水平
	 */
	 
	public void setWeixiushuiping(String weixiushuiping) {
		this.weixiushuiping = weixiushuiping;
	}
	
	/**
	 * 获取：维修水平
	 */
	public String getWeixiushuiping() {
		return weixiushuiping;
	}
				
	
	/**
	 * 设置：整体评价
	 */
	 
	public void setZhengtipingjia(String zhengtipingjia) {
		this.zhengtipingjia = zhengtipingjia;
	}
	
	/**
	 * 获取：整体评价
	 */
	public String getZhengtipingjia() {
		return zhengtipingjia;
	}
				
	
	/**
	 * 设置：评价日期
	 */
	 
	public void setPingjiariqi(Date pingjiariqi) {
		this.pingjiariqi = pingjiariqi;
	}
	
	/**
	 * 获取：评价日期
	 */
	public Date getPingjiariqi() {
		return pingjiariqi;
	}
				
	
	/**
	 * 设置：业主账号
	 */
	 
	public void setYezhuzhanghao(String yezhuzhanghao) {
		this.yezhuzhanghao = yezhuzhanghao;
	}
	
	/**
	 * 获取：业主账号
	 */
	public String getYezhuzhanghao() {
		return yezhuzhanghao;
	}
				
	
	/**
	 * 设置：业主姓名
	 */
	 
	public void setYezhuxingming(String yezhuxingming) {
		this.yezhuxingming = yezhuxingming;
	}
	
	/**
	 * 获取：业主姓名
	 */
	public String getYezhuxingming() {
		return yezhuxingming;
	}
			
}
