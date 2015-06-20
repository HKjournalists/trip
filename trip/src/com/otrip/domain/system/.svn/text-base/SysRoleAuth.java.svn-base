package com.otrip.domain.system;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sys_role_auth database table.
 * 
 */
@Entity
@Table(name="sys_role_auth")
@NamedQuery(name="SysRoleAuth.findAll", query="SELECT s FROM SysRoleAuth s")
public class SysRoleAuth extends com.otrip.domain.Entity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="fs_id")
	private String fsId;

	//bi-directional many-to-one association to SysMenuAuth
	@ManyToOne
	@JoinColumn(name="fs_menu_auth_id")
	private SysMenuAuth sysMenuAuth;

	//bi-directional many-to-one association to SysRole
	@ManyToOne
	@JoinColumn(name="fs_role_id")
	private SysRole sysRole;

	public SysRoleAuth() {
	}

	public String getFsId() {
		return this.fsId;
	}

	public void setFsId(String fsId) {
		this.fsId = fsId;
	}

	public SysMenuAuth getSysMenuAuth() {
		return this.sysMenuAuth;
	}

	public void setSysMenuAuth(SysMenuAuth sysMenuAuth) {
		this.sysMenuAuth = sysMenuAuth;
	}

	public SysRole getSysRole() {
		return this.sysRole;
	}

	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}

}