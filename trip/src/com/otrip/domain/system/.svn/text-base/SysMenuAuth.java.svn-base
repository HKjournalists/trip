package com.otrip.domain.system;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the sys_menu_auth database table.
 * 
 */
@Entity
@Table(name="sys_menu_auth")
@NamedQuery(name="SysMenuAuth.findAll", query="SELECT s FROM SysMenuAuth s")
public class SysMenuAuth extends com.otrip.domain.Entity implements Serializable {
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

	@Column(name="fs_description")
	private String fsDescription;

	@Column(name="fs_name")
	private String fsName;

	@Column(name="fs_parent_id")
	private String fsParentId;

	@Column(name="fs_status")
	private String fsStatus;

	//bi-directional many-to-one association to SysMenuType
	@ManyToOne
	@JoinColumn(name="fs_menu_type")
	private SysMenuType sysMenuType;

	//bi-directional many-to-one association to SysResource
	@ManyToOne
	@JoinColumn(name="fs_resources_id")
	private SysResource sysResource;

	//bi-directional many-to-one association to SysRoleAuth
	@OneToMany(mappedBy="sysMenuAuth")
	private List<SysRoleAuth> sysRoleAuths;

	public SysMenuAuth() {
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

	public String getFsDescription() {
		return this.fsDescription;
	}

	public void setFsDescription(String fsDescription) {
		this.fsDescription = fsDescription;
	}

	public String getFsName() {
		return this.fsName;
	}

	public void setFsName(String fsName) {
		this.fsName = fsName;
	}

	public String getFsParentId() {
		return this.fsParentId;
	}

	public void setFsParentId(String fsParentId) {
		this.fsParentId = fsParentId;
	}

	public String getFsStatus() {
		return this.fsStatus;
	}

	public void setFsStatus(String fsStatus) {
		this.fsStatus = fsStatus;
	}

	public SysMenuType getSysMenuType() {
		return this.sysMenuType;
	}

	public void setSysMenuType(SysMenuType sysMenuType) {
		this.sysMenuType = sysMenuType;
	}

	public SysResource getSysResource() {
		return this.sysResource;
	}

	public void setSysResource(SysResource sysResource) {
		this.sysResource = sysResource;
	}

	public List<SysRoleAuth> getSysRoleAuths() {
		return this.sysRoleAuths;
	}

	public void setSysRoleAuths(List<SysRoleAuth> sysRoleAuths) {
		this.sysRoleAuths = sysRoleAuths;
	}

	public SysRoleAuth addSysRoleAuth(SysRoleAuth sysRoleAuth) {
		getSysRoleAuths().add(sysRoleAuth);
		sysRoleAuth.setSysMenuAuth(this);

		return sysRoleAuth;
	}

	public SysRoleAuth removeSysRoleAuth(SysRoleAuth sysRoleAuth) {
		getSysRoleAuths().remove(sysRoleAuth);
		sysRoleAuth.setSysMenuAuth(null);

		return sysRoleAuth;
	}

}