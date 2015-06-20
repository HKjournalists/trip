package com.otrip.domain.system;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the sys_login_history database table.
 * 
 */
@Entity
@Table(name="sys_login_history")
@NamedQuery(name="SysLoginHistory.findAll", query="SELECT s FROM SysLoginHistory s")
public class SysLoginHistory extends com.otrip.domain.Entity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="fs_id")
	private String fsId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fd_login_time")
	private Date fdLoginTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fd_logout_time")
	private Date fdLogoutTime;

	@Column(name="fs_ip")
	private String fsIp;

	//bi-directional many-to-one association to SysUser
	@ManyToOne
	@JoinColumn(name="fs_user_id")
	private SysUser sysUser;

	public SysLoginHistory() {
	}

	public String getFsId() {
		return this.fsId;
	}

	public void setFsId(String fsId) {
		this.fsId = fsId;
	}

	public Date getFdLoginTime() {
		return this.fdLoginTime;
	}

	public void setFdLoginTime(Date fdLoginTime) {
		this.fdLoginTime = fdLoginTime;
	}

	public Date getFdLogoutTime() {
		return this.fdLogoutTime;
	}

	public void setFdLogoutTime(Date fdLogoutTime) {
		this.fdLogoutTime = fdLogoutTime;
	}

	public String getFsIp() {
		return this.fsIp;
	}

	public void setFsIp(String fsIp) {
		this.fsIp = fsIp;
	}

	public SysUser getSysUser() {
		return this.sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

}