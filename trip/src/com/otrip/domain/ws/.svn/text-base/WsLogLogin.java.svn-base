package com.otrip.domain.ws;

import java.io.Serializable;

import javax.persistence.*;

import com.otrip.domain.system.SysUser;

import java.util.Date;


/**
 * The persistent class for the ws_log_login database table.
 * 
 */
@Entity
@Table(name="ws_log_login")
@NamedQuery(name="WsLogLogin.findAll", query="SELECT w FROM WsLogLogin w")
public class WsLogLogin extends com.otrip.domain.Entity implements Serializable {
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

	public WsLogLogin() {
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