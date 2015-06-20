package com.otrip.domain.system;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the sys_role database table.
 * 
 */
@Entity
@Table(name="sys_role")
@NamedQuery(name="SysRole.findAll", query="SELECT s FROM SysRole s")
public class SysRole extends com.otrip.domain.Entity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="fs_id")
	private String fsId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fd_create_time")
	private Date fdCreateTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fd_update_time")
	private Date fdUpdateTime;

	@Column(name="fn_order")
	private int fnOrder;

	@Column(name="fs_name")
	private String fsName;

	@Column(name="fs_sign")
	private String fsSign;

	@Column(name="fs_status")
	private String fsStatus;

	//bi-directional many-to-one association to SysRole
	@ManyToOne
	@JoinColumn(name="fs_parent_id")
	private SysRole sysRole;

	//bi-directional many-to-one association to SysRole
	@OneToMany(mappedBy="sysRole")
	private List<SysRole> sysRoles;

	//bi-directional many-to-one association to SysRoleAuth
	@OneToMany(mappedBy="sysRole")
	private List<SysRoleAuth> sysRoleAuths;

	//bi-directional many-to-one association to SysUserRole
	@OneToMany(mappedBy="sysRole")
	private List<SysUserRole> sysUserRoles;

	public SysRole() {
	}

	public String getFsId() {
		return this.fsId;
	}

	public void setFsId(String fsId) {
		this.fsId = fsId;
	}

	public Date getFdCreateTime() {
		return this.fdCreateTime;
	}

	public void setFdCreateTime(Date fdCreateTime) {
		this.fdCreateTime = fdCreateTime;
	}

	public Date getFdUpdateTime() {
		return this.fdUpdateTime;
	}

	public void setFdUpdateTime(Date fdUpdateTime) {
		this.fdUpdateTime = fdUpdateTime;
	}

	public int getFnOrder() {
		return this.fnOrder;
	}

	public void setFnOrder(int fnOrder) {
		this.fnOrder = fnOrder;
	}

	public String getFsName() {
		return this.fsName;
	}

	public void setFsName(String fsName) {
		this.fsName = fsName;
	}

	public String getFsSign() {
		return this.fsSign;
	}

	public void setFsSign(String fsSign) {
		this.fsSign = fsSign;
	}

	public String getFsStatus() {
		return this.fsStatus;
	}

	public void setFsStatus(String fsStatus) {
		this.fsStatus = fsStatus;
	}

	public SysRole getSysRole() {
		return this.sysRole;
	}

	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}

	public List<SysRole> getSysRoles() {
		return this.sysRoles;
	}

	public void setSysRoles(List<SysRole> sysRoles) {
		this.sysRoles = sysRoles;
	}

	public SysRole addSysRole(SysRole sysRole) {
		getSysRoles().add(sysRole);
		sysRole.setSysRole(this);

		return sysRole;
	}

	public SysRole removeSysRole(SysRole sysRole) {
		getSysRoles().remove(sysRole);
		sysRole.setSysRole(null);

		return sysRole;
	}

	public List<SysRoleAuth> getSysRoleAuths() {
		return this.sysRoleAuths;
	}

	public void setSysRoleAuths(List<SysRoleAuth> sysRoleAuths) {
		this.sysRoleAuths = sysRoleAuths;
	}

	public SysRoleAuth addSysRoleAuth(SysRoleAuth sysRoleAuth) {
		getSysRoleAuths().add(sysRoleAuth);
		sysRoleAuth.setSysRole(this);

		return sysRoleAuth;
	}

	public SysRoleAuth removeSysRoleAuth(SysRoleAuth sysRoleAuth) {
		getSysRoleAuths().remove(sysRoleAuth);
		sysRoleAuth.setSysRole(null);

		return sysRoleAuth;
	}

	public List<SysUserRole> getSysUserRoles() {
		return this.sysUserRoles;
	}

	public void setSysUserRoles(List<SysUserRole> sysUserRoles) {
		this.sysUserRoles = sysUserRoles;
	}

	public SysUserRole addSysUserRole(SysUserRole sysUserRole) {
		getSysUserRoles().add(sysUserRole);
		sysUserRole.setSysRole(this);

		return sysUserRole;
	}

	public SysUserRole removeSysUserRole(SysUserRole sysUserRole) {
		getSysUserRoles().remove(sysUserRole);
		sysUserRole.setSysRole(null);

		return sysUserRole;
	}

}