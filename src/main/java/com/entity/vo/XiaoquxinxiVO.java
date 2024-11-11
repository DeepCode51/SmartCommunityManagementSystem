package com.entity.vo;

import com.entity.XiaoquxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 小区信息
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-03-20 21:37:55
 */
public class XiaoquxinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 封面
	 */
	
	private String fengmian;
		
	/**
	 * 楼栋
	 */
	
	private String loudong;
		
	/**
	 * 户数
	 */
	
	private String hushu;
		
	/**
	 * 居住人口
	 */
	
	private String juzhurenkou;
		
	/**
	 * 具体位置
	 */
	
	private String jutiweizhi;
		
	/**
	 * 小区介绍
	 */
	
	private String xiaoqujieshao;
				
	
	/**
	 * 设置：封面
	 */
	 
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
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
	 * 设置：户数
	 */
	 
	public void setHushu(String hushu) {
		this.hushu = hushu;
	}
	
	/**
	 * 获取：户数
	 */
	public String getHushu() {
		return hushu;
	}
				
	
	/**
	 * 设置：居住人口
	 */
	 
	public void setJuzhurenkou(String juzhurenkou) {
		this.juzhurenkou = juzhurenkou;
	}
	
	/**
	 * 获取：居住人口
	 */
	public String getJuzhurenkou() {
		return juzhurenkou;
	}
				
	
	/**
	 * 设置：具体位置
	 */
	 
	public void setJutiweizhi(String jutiweizhi) {
		this.jutiweizhi = jutiweizhi;
	}
	
	/**
	 * 获取：具体位置
	 */
	public String getJutiweizhi() {
		return jutiweizhi;
	}
				
	
	/**
	 * 设置：小区介绍
	 */
	 
	public void setXiaoqujieshao(String xiaoqujieshao) {
		this.xiaoqujieshao = xiaoqujieshao;
	}
	
	/**
	 * 获取：小区介绍
	 */
	public String getXiaoqujieshao() {
		return xiaoqujieshao;
	}
			
}
