package com.otrip.domain.airport;

import java.io.Serializable;

import javax.persistence.*;

import com.otrip.domain.system.SysUser;

import java.util.Date;


/**
 * The persistent class for the ot_meet_airport_discuss database table.
 * 
 */
@Entity
@Table(name="ot_meet_airport_discuss")
@NamedQuery(name="OtMeetAirportDiscuss.findAll", query="SELECT o FROM OtMeetAirportDiscuss o")
public class OtMeetAirportDiscuss extends com.otrip.domain.Entity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="fs_id")
	private String fsId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fd_create_time")
	private Date fdCreateTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fd_discuss_time")
	private Date fdDiscussTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fd_update_time")
	private Date fdUpdateTime;

	@Lob
	@Column(name="fn_star_level")
	private String fnStarLevel;

	@Column(name="fs_discuss_content")
	private String fsDiscussContent;

	//bi-directional many-to-one association to SysUser
	@ManyToOne
	@JoinColumn(name="fs_user_id")
	private SysUser sysUser;

	//bi-directional many-to-one association to OtMeetAirport
	@ManyToOne
	@JoinColumn(name="fs_airport_id")
	private OtMeetAirport otMeetAirport;

	public OtMeetAirportDiscuss() {
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

	public Date getFdDiscussTime() {
		return this.fdDiscussTime;
	}

	public void setFdDiscussTime(Date fdDiscussTime) {
		this.fdDiscussTime = fdDiscussTime;
	}

	public Date getFdUpdateTime() {
		return this.fdUpdateTime;
	}

	public void setFdUpdateTime(Date fdUpdateTime) {
		this.fdUpdateTime = fdUpdateTime;
	}

	public String getFnStarLevel() {
		return this.fnStarLevel;
	}

	public void setFnStarLevel(String fnStarLevel) {
		this.fnStarLevel = fnStarLevel;
	}

	public String getFsDiscussContent() {
		return this.fsDiscussContent;
	}

	public void setFsDiscussContent(String fsDiscussContent) {
		this.fsDiscussContent = fsDiscussContent;
	}

	public SysUser getSysUser() {
		return this.sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public OtMeetAirport getOtMeetAirport() {
		return this.otMeetAirport;
	}

	public void setOtMeetAirport(OtMeetAirport otMeetAirport) {
		this.otMeetAirport = otMeetAirport;
	}

}