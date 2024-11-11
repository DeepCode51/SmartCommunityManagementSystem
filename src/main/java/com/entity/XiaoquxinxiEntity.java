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
 * 小区信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-03-20 21:37:55
 */
@TableName("xiaoquxinxi")
public class XiaoquxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public XiaoquxinxiEntity() {
		
	}
	
	public XiaoquxinxiEntity(T t) {
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
	 * 小区名称
	 */
					
	private String xiaoqumingcheng;
	
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
	 * 设置：小区名称
	 */
	public void setXiaoqumingcheng(String xiaoqumingcheng) {
		this.xiaoqumingcheng = xiaoqumingcheng;
	}
	/**
	 * 获取：小区名称
	 */
	public String getXiaoqumingcheng() {
		return xiaoqumingcheng;
	}
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
