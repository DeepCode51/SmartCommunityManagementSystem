package com.entity.vo;

import com.entity.ChongdianzhuangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 充电桩
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-03-20 21:37:55
 */
public class ChongdianzhuangVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
