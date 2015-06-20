package com.otrip.domain.trip;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.LazyToOne;

import com.otrip.domain.system.SysUser;

import java.util.Date;


/**
 * The persistent class for the ot_acti_click_praise database table.
 * 
 */
@Entity
@Table(name="ot_acti_click_praise")
@NamedQuery(name="OtActiClickPraise.findAll", query="SELECT o FROM OtActiClickPraise o")
public class OtActiClickPraise extends com.otrip.domain.Entity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="fs_id")
	private String fsId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fd_praise_time")
	private Date fdPraiseTime;

	@Lob
	@Column(name="fn_long")
	private String fnLong;

	//bi-directional many-to-one association to OtActiInfo
	@ManyToOne
	@JoinColumn(name="fs_acti_id")
	
	private OtActiInfo otActiInfo;

	//bi-directional many-to-one association to SysUser
	@ManyToOne
	@JoinColumn(name="fs_user_id")
	private SysUser sysUser;

	@Column(name="state")
	private boolean state;
	
	public OtActiClickPraise() {
	}

	public String getFsId() {
		return this.fsId;
	}

	public void setFsId(String fsId) {
		this.fsId = fsId;
	}

	public Date getFdPraiseTime() {
		return this.fdPraiseTime;
	}

	public void setFdPraiseTime(Date fdPraiseTime) {
		this.fdPraiseTime = fdPraiseTime;
	}

	public String getFnLong() {
		return this.fnLong;
	}

	public void setFnLong(String fnLong) {
		this.fnLong = fnLong;
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