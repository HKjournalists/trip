package com.otrip.domain.trip;

import java.io.Serializable;

import javax.persistence.*;

import com.otrip.domain.system.SysUser;

import java.util.Date;


/**
 * The persistent class for the ot_acti_discuss database table.
 * 
 */
@Entity
@Table(name="ot_acti_discuss")
@NamedQuery(name="OtActiDiscuss.findAll", query="SELECT o FROM OtActiDiscuss o")
public class OtActiDiscuss extends com.otrip.domain.Entity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="fs_id")
	private String fsId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fd_time")
	private Date fdTime;

	@Column(name="fs_content")
	private String fsContent;

	@Column(name="fs_grade_level")
	private int fsGradeLevel;

	//bi-directional many-to-one association to OtActiInfo
	@ManyToOne
	@JoinColumn(name="fs_acti_id")
	private OtActiInfo otActiInfo;

	//bi-directional many-to-one association to SysUser
	@ManyToOne
	@JoinColumn(name="fs_user_id")
	private SysUser sysUser;

	public OtActiDiscuss() {
	}

	public String getFsId() {
		return this.fsId;
	}

	public void setFsId(String fsId) {
		this.fsId = fsId;
	}

	public Date getFdTime() {
		return this.fdTime;
	}

	public void setFdTime(Date fdTime) {
		this.fdTime = fdTime;
	}

	public String getFsContent() {
		return this.fsContent;
	}

	public void setFsContent(String fsContent) {
		this.fsContent = fsContent;
	}

	public int getFsGradeLevel() {
		return this.fsGradeLevel;
	}

	public void setFsGradeLevel(int fsGradeLevel) {
		this.fsGradeLevel = fsGradeLevel;
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

}