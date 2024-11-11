package com.entity.model;

import com.entity.FangwuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 房屋信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-03-20 21:37:54
 */
public class FangwuxinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 身份证
	 */
	
	private String shenfenzheng;
		
	/**
	 * 手机号
	 */
	
	private String shoujihao;
		
	/**
	 * 小区名称
	 */
	
	private String xiaoqumingcheng;
		
	/**
	 * 楼栋
	 */
	
	private String loudong;
		
	/**
	 * 单元
	 */
	
	private String danyuan;
		
	/**
	 * 户型
	 */
	
	private String huxing;
		
	/**
	 * 面积
	 */
	
	private String mianji;
		
	/**
	 * 家庭成员
	 */
	
	private String jiatingchengyuan;
				
	
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
	 * 设置：手机号
	 */
	 
	public void setShoujihao(String shoujihao) {
		this.shoujihao = shoujihao;
	}
	
	/**
	 * 获取：手机号
	 */
	public String getShoujihao() {
		return shoujihao;
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
	 * 设置：户型
	 */
	 
	public void setHuxing(String huxing) {
		this.huxing = huxing;
	}
	
	/**
	 * 获取：户型
	 */
	public String getHuxing() {
		return huxing;
	}
				
	
	/**
	 * 设置：面积
	 */
	 
	public void setMianji(String mianji) {
		this.mianji = mianji;
	}
	
	/**
	 * 获取：面积
	 */
	public String getMianji() {
		return mianji;
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
