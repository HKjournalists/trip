package com.otrip.domain.trip;

import java.io.Serializable;

import javax.persistence.*;

import com.otrip.domain.system.SysUser;

import java.util.Date;


/**
 * The persistent class for the ot_acti_favorite database table.
 * 
 */
@Entity
@Table(name="ot_acti_favorite")
@NamedQuery(name="OtActiFavorite.findAll", query="SELECT o FROM OtActiFavorite o")
public class OtActiFavorite extends com.otrip.domain.Entity implements Serializable {
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

	@Column(name="state")
	private boolean state;
	//bi-directional many-to-one association to OtActiInfo
	@ManyToOne
	@JoinColumn(name="fs_acti_id")
	private OtActiInfo otActiInfo;

	//bi-directional many-to-one association to SysUser
	@ManyToOne
	@JoinColumn(name="fs_user_id")
	private SysUser sysUser;

	
	public OtActiFavorite() {
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

	public OtActiInfo getOtActiInfo() {
		return this.otActiInfo;
	}

	public void setOtActiInfo(OtActiInfo otActiInfo) {
		this.otActiInfo = otActiInfo;
	}

	public SysUser getSysUser() {
		return this.sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	
	
}