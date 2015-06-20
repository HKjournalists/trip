package com.otrip.pojo;

import org.apache.commons.lang3.StringUtils;

public class OrdeqpVo {
	private String flag;
	private String state;
	private String minDate;
	private String maxDate;
	private String minNum;
	private String maxNum;
	private String minPrice;
	private String maxPrice;
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getMinDate() {
		if(!StringUtils.isNotBlank(minDate))
			return 0;
		else
			return Integer.valueOf(minDate);
	}
	public void setMinDate(String minDate) {
		this.minDate = minDate;
	}
	public int getMaxDate() {
		if(!StringUtils.isNotBlank(maxDate))
			return 0;
		else
			return Integer.valueOf(maxDate);
	}
	public void setMaxDate(String maxDate) {
		this.maxDate = maxDate;
	}
	public int getMinNum() {
		if(!StringUtils.isNotBlank(minNum))
			return 0;
		else
			return Integer.valueOf(minNum);
	}
	public void setMinNum(String minNum) {
		this.minNum = minNum;
	}
	public int getMaxNum() {
		if(!StringUtils.isNotBlank(maxNum))
			return 0;
		else
			return Integer.valueOf(maxNum);
	}
	public void setMaxNum(String maxNum) {
		
		this.maxNum = maxNum;
	}
	public double getMinPrice() {
		if(!StringUtils.isNotBlank(minPrice))
			return 0;
		else
			return Double.valueOf(minPrice);
	}
	public void setMinPrice(String minPrice) {
		this.minPrice = minPrice;
	}
	public double getMaxPrice() {
		if(!StringUtils.isNotBlank(maxPrice))
			return 0;
		else 
			return Double.valueOf(maxPrice);
	}
	public void setMaxPrice(String maxPrice) {
		this.maxPrice = maxPrice;
	}
	
	
	
	
	
}
