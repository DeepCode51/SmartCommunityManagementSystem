package com.entity.model;

import com.entity.WeixiuqingdanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 维修清单
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-03-20 21:37:55
 */
public class WeixiuqingdanModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 报修标题
	 */
	
	private String baoxiubiaoti;
		
	/**
	 * 施工图片
	 */
	
	private String shigongtupian;
		
	/**
	 * 维修金额
	 */
	
	private Integer weixiujine;
		
	/**
	 * 故障报告
	 */
	
	private String guzhangbaogao;
		
	/**
	 * 维修详情
	 */
	
	private String weixiuxiangqing;
		
	/**
	 * 完工时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date wangongshijian;
		
	/**
	 * 业主账号
	 */
	
	private String yezhuzhanghao;
		
	/**
	 * 业主姓名
	 */
	
	private String yezhuxingming;
		
	/**
	 * 是否审核
	 */
	
	private String sfsh;
		
	/**
	 * 审核回复
	 */
	
	private String shhf;
		
	/**
	 * 是否支付
	 */
	
	private String ispay;
				
	
	/**
	 * 设置：报修标题
	 */
	 
	public void setBaoxiubiaoti(String baoxiubiaoti) {
		this.baoxiubiaoti = baoxiubiaoti;
	}
	
	/**
	 * 获取：报修标题
	 */
	public String getBaoxiubiaoti() {
		return baoxiubiaoti;
	}
				
	
	/**
	 * 设置：施工图片
	 */
	 
	public void setShigongtupian(String shigongtupian) {
		this.shigongtupian = shigongtupian;
	}
	
	/**
	 * 获取：施工图片
	 */
	public String getShigongtupian() {
		return shigongtupian;
	}
				
	
	/**
	 * 设置：维修金额
	 */
	 
	public void setWeixiujine(Integer weixiujine) {
		this.weixiujine = weixiujine;
	}
	
	/**
	 * 获取：维修金额
	 */
	public Integer getWeixiujine() {
		return weixiujine;
	}
				
	
	/**
	 * 设置：故障报告
	 */
	 
	public void setGuzhangbaogao(String guzhangbaogao) {
		this.guzhangbaogao = guzhangbaogao;
	}
	
	/**
	 * 获取：故障报告
	 */
	public String getGuzhangbaogao() {
		return guzhangbaogao;
	}
				
	
	/**
	 * 设置：维修详情
	 */
	 
	public void setWeixiuxiangqing(String weixiuxiangqing) {
		this.weixiuxiangqing = weixiuxiangqing;
	}
	
	/**
	 * 获取：维修详情
	 */
	public String getWeixiuxiangqing() {
		return weixiuxiangqing;
	}
				
	
	/**
	 * 设置：完工时间
	 */
	 
	public void setWangongshijian(Date wangongshijian) {
		this.wangongshijian = wangongshijian;
	}
	
	/**
	 * 获取：完工时间
	 */
	public Date getWangongshijian() {
		return wangongshijian;
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
				
	
	/**
	 * 设置：是否审核
	 */
	 
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
				
	
	/**
	 * 设置：审核回复
	 */
	 
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}
				
	
	/**
	 * 设置：是否支付
	 */
	 
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	
	/**
	 * 获取：是否支付
	 */
	public String getIspay() {
		return ispay;
	}
			
}
