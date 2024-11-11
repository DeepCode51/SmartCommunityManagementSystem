package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 居民信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-03-20 21:37:55
 */
@TableName("juminxinxi")
public class JuminxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JuminxinxiEntity() {
		
	}
	
	public JuminxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 居民姓名
	 */
					
	private String juminxingming;
	
	/**
	 * 性别
	 */
					
	private String xingbie;
	
	/**
	 * 楼栋
	 */
					
	private String loudong;
	
	/**
	 * 单元
	 */
					
	private String danyuan;
	
	/**
	 * 门牌号
	 */
					
	private String menpaihao;
	
	/**
	 * 身份证
	 */
					
	private String shenfenzheng;
	
	/**
	 * 联系方式
	 */
					
	private String lianxifangshi;
	
	/**
	 * 人员类型
	 */
					
	private String renyuanleixing;
	
	/**
	 * 家庭成员
	 */
					
	private String jiatingchengyuan;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：居民姓名
	 */
	public void setJuminxingming(String juminxingming) {
		this.juminxingming = juminxingming;
	}
	/**
	 * 获取：居民姓名
	 */
	public String getJuminxingming() {
		return juminxingming;
	}
	/**
	 * 设置：性别
	 */
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	/**
	 * 获取：性别
	 */
	public String getXingbie() {
		return xingbie;
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
	 * 设置：单元
	 */
	public void setDanyuan(String danyuan) {
		this.danyuan = danyuan;
	}
	/**
	 * 获取：单元
	 */
	public String getDanyuan() {
		return danyuan;
	}
	/**
	 * 设置：门牌号
	 */
	public void setMenpaihao(String menpaihao) {
		this.menpaihao = menpaihao;
	}
	/**
	 * 获取：门牌号
	 */
	public String getMenpaihao() {
		return menpaihao;
	}
	/**
	 * 设置：身份证
	 */
	public void setShenfenzheng(String shenfenzheng) {
		this.shenfenzheng = shenfenzheng;
	}
	/**
	 * 获取：身份证
	 */
	public String getShenfenzheng() {
		return shenfenzheng;
	}
	/**
	 * 设置：联系方式
	 */
	public void setLianxifangshi(String lianxifangshi) {
		this.lianxifangshi = lianxifangshi;
	}
	/**
	 * 获取：联系方式
	 */
	public String getLianxifangshi() {
		return lianxifangshi;
	}
	/**
	 * 设置：人员类型
	 */
	public void setRenyuanleixing(String renyuanleixing) {
		this.renyuanleixing = renyuanleixing;
	}
	/**
	 * 获取：人员类型
	 */
	public String getRenyuanleixing() {
		return renyuanleixing;
	}
	/**
	 * 设置：家庭成员
	 */
	public void setJiatingchengyuan(String jiatingchengyuan) {
		this.jiatingchengyuan = jiatingchengyuan;
	}
	/**
	 * 获取：家庭成员
	 */
	public String getJiatingchengyuan() {
		return jiatingchengyuan;
	}

}
