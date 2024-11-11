package com.entity.vo;

import com.entity.LaifangdengjiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 来访登记
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-03-20 21:37:55
 */
public class LaifangdengjiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 访客姓名
	 */
	
	private String fangkexingming;
		
	/**
	 * 来访人数
	 */
	
	private Integer laifangrenshu;
		
	/**
	 * 来访业主
	 */
	
	private String laifangyezhu;
		
	/**
	 * 业主姓名
	 */
	
	private String yezhuxingming;
		
	/**
	 * 楼栋
	 */
	
	private String loudong;
		
	/**
	 * 来访目的
	 */
	
	private String laifangmude;
		
	/**
	 * 来访时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date laifangshijian;
		
	/**
	 * 离开时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date likaishijian;
				
	
	/**
	 * 设置：访客姓名
	 */
	 
	public void setFangkexingming(String fangkexingming) {
		this.fangkexingming = fangkexingming;
	}
	
	/**
	 * 获取：访客姓名
	 */
	public String getFangkexingming() {
		return fangkexingming;
	}
				
	
	/**
	 * 设置：来访人数
	 */
	 
	public void setLaifangrenshu(Integer laifangrenshu) {
		this.laifangrenshu = laifangrenshu;
	}
	
	/**
	 * 获取：来访人数
	 */
	public Integer getLaifangrenshu() {
		return laifangrenshu;
	}
				
	
	/**
	 * 设置：来访业主
	 */
	 
	public void setLaifangyezhu(String laifangyezhu) {
		this.laifangyezhu = laifangyezhu;
	}
	
	/**
	 * 获取：来访业主
	 */
	public String getLaifangyezhu() {
		return laifangyezhu;
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
	 * 设置：楼栋
	 */
	 
	public void setLoudong(String loudong) {
		this.loudong = loudong;
	}
	
	/**
	 * 获取：楼栋
	 */
	public String getLoudong() {
		return loudong;
	}
				
	
	/**
	 * 设置：来访目的
	 */
	 
	public void setLaifangmude(String laifangmude) {
		this.laifangmude = laifangmude;
	}
	
	/**
	 * 获取：来访目的
	 */
	public String getLaifangmude() {
		return laifangmude;
	}
				
	
	/**
	 * 设置：来访时间
	 */
	 
	public void setLaifangshijian(Date laifangshijian) {
		this.laifangshijian = laifangshijian;
	}
	
	/**
	 * 获取：来访时间
	 */
	public Date getLaifangshijian() {
		return laifangshijian;
	}
				
	
	/**
	 * 设置：离开时间
	 */
	 
	public void setLikaishijian(Date likaishijian) {
		this.likaishijian = likaishijian;
	}
	
	/**
	 * 获取：离开时间
	 */
	public Date getLikaishijian() {
		return likaishijian;
	}
			
}
