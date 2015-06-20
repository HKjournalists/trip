package org.ztree.utils;

import java.io.Serializable;

/**
 * @see 节点菜单
 * @author Administrator
 *
 */
public class NodeMenu implements Serializable {

	private static final long serialVersionUID = -2159245454580824631L;
	
	private String 			id;
	private String			pId;
	private String			name;
	private String 			open="false";
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOpen() {
		return open;
	}
	public void setOpen(String open) {
		this.open = open;
	}
	public String toJsonString() {
		// TODO Auto-generated method stub
		String str = "{id:'" +id + "', pId:'"+pId+"', name:\""+name+"\" }";//封装ztree需要格式的字符串
		return str;
	}
	

}
