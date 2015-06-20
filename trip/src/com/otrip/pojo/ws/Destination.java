package com.otrip.pojo.ws;

/**
 * 用于向客户端传送JSON数据
 * @author mac
 *
 */
public class Destination {
	
	private String destiId;
	private String destiName;
	private String actiNum;
	private String destiImg;
	public String getDestiId() {
		return destiId;
	}
	public void setDestiId(String destiId) {
		this.destiId = destiId;
	}
	public String getDestiName() {
		return destiName;
	}
	public void setDestiName(String destiName) {
		this.destiName = destiName;
	}
	public String getActiNum() {
		return actiNum;
	}
	public void setActiNum(String actiNum) {
		this.actiNum = actiNum;
	}
	public String getDestiImg() {
		return destiImg;
	}
	public void setDestiImg(String destiImg) {
		this.destiImg = destiImg;
	}

}
