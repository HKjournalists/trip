package com.otrip.domain.system;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the sys_menu_type database table.
 * 
 */
@Entity
@Table(name="sys_menu_type")
@NamedQuery(name="SysMenuType.findAll", query="SELECT s FROM SysMenuType s")
public class SysMenuType extends com.otrip.domain.Entity implements Serializable {
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

	@Column(name="fs_name")
	private String fsName;

	@Column(name="fs_sign")
	private String fsSign;

	//bi-directional many-to-one association to SysMenuAuth
	@OneToMany(mappedBy="sysMenuType")
	private List<SysMenuAuth> sysMenuAuths;

	public SysMenuType() {
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

	public List<SysMenuAuth> getSysMenuAuths() {
		return this.sysMenuAuths;
	}

	public void setSysMenuAuths(List<SysMenuAuth> sysMenuAuths) {
		this.sysMenuAuths = sysMenuAuths;
	}

	public SysMenuAuth addSysMenuAuth(SysMenuAuth sysMenuAuth) {
		getSysMenuAuths().add(sysMenuAuth);
		sysMenuAuth.setSysMenuType(this);

		return sysMenuAuth;
	}

	public SysMenuAuth removeSysMenuAuth(SysMenuAuth sysMenuAuth) {
		getSysMenuAuths().remove(sysMenuAuth);
		sysMenuAuth.setSysMenuType(null);

		return sysMenuAuth;
	}

}