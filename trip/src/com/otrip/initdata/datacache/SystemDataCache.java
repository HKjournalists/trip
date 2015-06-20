package com.otrip.initdata.datacache;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.otrip.domain.system.SysMenuAuth;

/**
 * @see 系统数据缓存
 * @author zhongJc
 */
public class SystemDataCache implements Serializable {

	private static final long serialVersionUID = 5318663045530593900L;
	
	static Logger log=Logger.getLogger(SystemDataCache.class);
	
	/*************************************
	 * @see 跟系统父id
	 *************************************/
	private static String rootSystemParentId="root";		//跟表示
	private static String mainSystemId="0";					//主系统Id
	private static String menuTypeMainSystem="0";			//主系统
	private static String menuTypeChildSystem="1";			//表示自系统
	private static String menuTypeLink="5";					//链接
	private static String menuTypeButton="4";				//按钮
	
	
	public static String getRootSystemParentId() {
		return rootSystemParentId;
	}
	
	public static String getMainSystemId() {
		return mainSystemId;
	}
	
	public static String getMenuTypeMainSystem() {
		return menuTypeMainSystem;
	}
	
	public static String getMenuTypeChildSystem() {
		return menuTypeChildSystem;
	}
	
	public static String getMenuTypeLink() {
		return menuTypeLink;
	}
	public static String getMenuTypeButton() {
		return menuTypeButton;
	}
	
	private static final List<SysMenuAuth> sys_child=new ArrayList<SysMenuAuth>();
	public static List<SysMenuAuth> getSysChild(){
		return sys_child;
	}
	
	private static final List<SysMenuAuth> sys_main=new ArrayList<SysMenuAuth>();
	public static List<SysMenuAuth> getSysMain() {
		return sys_main;
	}
	
	
	/***************************************
	 * @see 职位根
	 ***************************************/
	private static final String sysOrgRootId="1";
	public static String getSysorgrootid() {
		return sysOrgRootId;
	}
	
	/***************************************************
	 * @see 角色相关表示
	 **************************************************/
	private static final String role_root_sign="ROLE_ROOT";		//根证书标示
	public static String getRoleRootSign(){
		return role_root_sign;
	}
	
	private static String rootDestinationParentId="root";		//跟表示
	private static String rootDestinationId="0";					//主系统Id
	public static final String getRootDestinationParentId(){
		return rootDestinationParentId;
	}
	public static String getRootDestinationId() {
		return rootDestinationId;
	}
	
}
