package com.otrip.domain.trip;

import java.io.Serializable;

import javax.persistence.*;

import com.otrip.domain.system.SysUser;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ot_acti_problem_discuss database table.
 * 
 */
@Entity
@Table(name="ot_acti_problem_discuss")
@NamedQuery(name="OtActiProblemDiscuss.findAll", query="SELECT o FROM OtActiProblemDiscuss o")
public class OtActiProblemDiscuss extends com.otrip.domain.Entity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="fs_id")
	private String fsId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fd_time")
	private Date fdTime;

	@Column(name="fs_content")
	private String fsContent;

	@Column(name="fs_status")
	private int fsStatus;

	//bi-directional many-to-one association to OtActiInfo
	@ManyToOne
	@JoinColumn(name="fs_acti_id")
	private OtActiInfo otActiInfo;

	//bi-directional many-to-one association to OtActiProblemDiscuss
	@ManyToOne
	@JoinColumn(name="fs_proplem_id")
	private OtActiProblemDiscuss otActiProblemDiscuss;

	//bi-directional many-to-one association to OtActiProblemDiscuss
	@OneToMany(mappedBy="otActiProblemDiscuss")
	private List<OtActiProblemDiscuss> otActiProblemDiscusses;

	//bi-directional many-to-one association to SysUser
	@ManyToOne
	@JoinColumn(name="fs_user_id")
	private SysUser sysUser;

	public OtActiProblemDiscuss() {
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

	public int getFsStatus() {
		return this.fsStatus;
	}

	public void setFsStatus(int fsStatus) {
		this.fsStatus = fsStatus;
	}

	public OtActiInfo getOtActiInfo() {
		return this.otActiInfo;
	}

	public void setOtActiInfo(OtActiInfo otActiInfo) {
		this.otActiInfo = otActiInfo;
	}

	public OtActiProblemDiscuss getOtActiProblemDiscuss() {
		return this.otActiProblemDiscuss;
	}

	public void setOtActiProblemDiscuss(OtActiProblemDiscuss otActiProblemDiscuss) {
		this.otActiProblemDiscuss = otActiProblemDiscuss;
	}

	public List<OtActiProblemDiscuss> getOtActiProblemDiscusses() {
		return this.otActiProblemDiscusses;
	}
	
	public void setOtActiProblemDiscusses(List<OtActiProblemDiscuss> otActiProblemDiscusses) {
		this.otActiProblemDiscusses = otActiProblemDiscusses;
	}

	public OtActiProblemDiscuss addOtActiProblemDiscuss(OtActiProblemDiscuss otActiProblemDiscuss) {
		getOtActiProblemDiscusses().add(otActiProblemDiscuss);
		otActiProblemDiscuss.setOtActiProblemDiscuss(this);

		return otActiProblemDiscuss;
	}

	public OtActiProblemDiscuss removeOtActiProblemDiscuss(OtActiProblemDiscuss otActiProblemDiscuss) {
		getOtActiProblemDiscusses().remove(otActiProblemDiscuss);
		otActiProblemDiscuss.setOtActiProblemDiscuss(null);

		return otActiProblemDiscuss;
	}
	
	public SysUser getSysUser() {
		return this.sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	
	
}