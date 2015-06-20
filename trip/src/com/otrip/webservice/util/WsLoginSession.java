package com.otrip.webservice.util;

import java.io.Serializable;

import com.otrip.domain.system.SysUser;
/**
 * @see ws登入session
 * @author Administrator
 *
 */
public class WsLoginSession implements Serializable {

	private static final long serialVersionUID = -5529929116283543332L;
	
	private SysUser sysUser=null;
	private String	session_id_key="";
	public SysUser getSysUser() {
		return sysUser;
	}
	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}
	public String getSession_id_key() {
		return session_id_key;
	}
	public void setSession_id_key(String session_id_key) {
		this.session_id_key = session_id_key;
	}
	
	/***********************************************
	 * @see 登入session的id
	 ***********************************************/
	private String		loginUserId="";
	private String 		account="";
	private String		password="";
	private String  	phone="";
	private String		email="";
	private String		userName="";
	public String getLoginUserId() {
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	private String wsLogLoginId="";
	public void setWsLogLoginId(String wsLogLoginId) {
		this.wsLogLoginId = wsLogLoginId;
	}
	public String getWsLogLoginId() {
		return wsLogLoginId;
	}
	
	
	
}
