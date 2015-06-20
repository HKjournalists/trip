package com.otrip.domain.system;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the sys_resources database table.
 * 
 */
@Entity
@Table(name="sys_resources")
@NamedQuery(name="SysResource.findAll", query="SELECT s FROM SysResource s")
public class SysResource extends com.otrip.domain.Entity implements Serializable {
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

	@Column(name="fs_description")
	private String fsDescription;

	@Column(name="fs_key")
	private String fsKey;

	@Column(name="fs_name")
	private String fsName;

	@Column(name="fs_url")
	private String fsUrl;

	//bi-directional many-to-one association to SysMenuAuth
	@OneToMany(mappedBy="sysResource")
	private List<SysMenuAuth> sysMenuAuths;

	public SysResource() {
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

	public String getFsDescription() {
		return this.fsDescription;
	}

	public void setFsDescription(String fsDescription) {
		this.fsDescription = fsDescription;
	}

	public String getFsKey() {
		return this.fsKey;
	}

	public void setFsKey(String fsKey) {
		this.fsKey = fsKey;
	}

	public String getFsName() {
		return this.fsName;
	}

	public void setFsName(String fsName) {
		this.fsName = fsName;
	}

	public String getFsUrl() {
		return this.fsUrl;
	}

	public void setFsUrl(String fsUrl) {
		this.fsUrl = fsUrl;
	}

	public List<SysMenuAuth> getSysMenuAuths() {
		return this.sysMenuAuths;
	}

	public void setSysMenuAuths(List<SysMenuAuth> sysMenuAuths) {
		this.sysMenuAuths = sysMenuAuths;
	}

	public SysMenuAuth addSysMenuAuth(SysMenuAuth sysMenuAuth) {
		getSysMenuAuths().add(sysMenuAuth);
		sysMenuAuth.setSysResource(this);

		return sysMenuAuth;
	}

	public SysMenuAuth removeSysMenuAuth(SysMenuAuth sysMenuAuth) {
		getSysMenuAuths().remove(sysMenuAuth);
		sysMenuAuth.setSysResource(null);

		return sysMenuAuth;
	}

}