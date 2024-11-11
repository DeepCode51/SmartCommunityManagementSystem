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
 * 充电桩
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-03-20 21:37:55
 */
@TableName("chongdianzhuang")
public class ChongdianzhuangEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ChongdianzhuangEntity() {
		
	}
	
	public ChongdianzhuangEntity(T t) {
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
	 * 电桩编号
	 */
					
	private String dianzhuangbianhao;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
	/**
	 * 电桩状态
	 */
					
	private String dianzhuangzhuangtai;
	
	/**
	 * 电桩分类
	 */
					
	private String dianzhuangfenlei;
	
	/**
	 * 输入电压
	 */
					
	private String shurudianya;
	
	/**
	 * 输出功率
	 */
					
	private String shuchugonglv;
	
	/**
	 * 使用方式
	 */
					
	private String shiyongfangshi;
	
	/**
	 * 小时单价
	 */
					
	private Integer xiaoshidanjia;
	
	/**
	 * 位置
	 */
					
	private String weizhi;
	
	/**
	 * 注意事项
	 */
					
	private String zhuyishixiang;
	
	
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
	 * 设置：电桩编号
	 */
	public void setDianzhuangbianhao(String dianzhuangbianhao) {
		this.dianzhuangbianhao = dianzhuangbianhao;
	}
	/**
	 * 获取：电桩编号
	 */
	public String getDianzhuangbianhao() {
		return dianzhuangbianhao;
	}
	/**
	 * 设置：图片
	 */
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
	/**
	 * 设置：电桩状态
	 */
	public void setDianzhuangzhuangtai(String dianzhuangzhuangtai) {
		this.dianzhuangzhuangtai = dianzhuangzhuangtai;
	}
	/**
	 * 获取：电桩状态
	 */
	public String getDianzhuangzhuangtai() {
		return dianzhuangzhuangtai;
	}
	/**
	 * 设置：电桩分类
	 */
	public void setDianzhuangfenlei(String dianzhuangfenlei) {
		this.dianzhuangfenlei = dianzhuangfenlei;
	}
	/**
	 * 获取：电桩分类
	 */
	public String getDianzhuangfenlei() {
		return dianzhuangfenlei;
	}
	/**
	 * 设置：输入电压
	 */
	public void setShurudianya(String shurudianya) {
		this.shurudianya = shurudianya;
	}
	/**
	 * 获取：输入电压
	 */
	public String getShurudianya() {
		return shurudianya;
	}
	/**
	 * 设置：输出功率
	 */
	public void setShuchugonglv(String shuchugonglv) {
		this.shuchugonglv = shuchugonglv;
	}
	/**
	 * 获取：输出功率
	 */
	public String getShuchugonglv() {
		return shuchugonglv;
	}
	/**
	 * 设置：使用方式
	 */
	public void setShiyongfangshi(String shiyongfangshi) {
		this.shiyongfangshi = shiyongfangshi;
	}
	/**
	 * 获取：使用方式
	 */
	public String getShiyongfangshi() {
		return shiyongfangshi;
	}
	/**
	 * 设置：小时单价
	 */
	public void setXiaoshidanjia(Integer xiaoshidanjia) {
		this.xiaoshidanjia = xiaoshidanjia;
	}
	/**
	 * 获取：小时单价
	 */
	public Integer getXiaoshidanjia() {
		return xiaoshidanjia;
	}
	/**
	 * 设置：位置
	 */
	public void setWeizhi(String weizhi) {
		this.weizhi = weizhi;
	}
	/**
	 * 获取：位置
	 */
	public String getWeizhi() {
		return weizhi;
	}
	/**
	 * 设置：注意事项
	 */
	public void setZhuyishixiang(String zhuyishixiang) {
		this.zhuyishixiang = zhuyishixiang;
	}
	/**
	 * 获取：注意事项
	 */
	public String getZhuyishixiang() {
		return zhuyishixiang;
	}

}
