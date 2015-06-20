package com.otrip.domain.system;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the sys_contacts_person database table.
 * 
 */
@Entity
@Table(name="sys_contacts_person")
@NamedQuery(name="SysContactsPerson.findAll", query="SELECT s FROM SysContactsPerson s")
public class SysContactsPerson extends com.otrip.domain.Entity implements Serializable {
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

	@Column(name="fs_certificates_code")
	private String fsCertificatesCode;

	@Column(name="fs_certificates_type")
	private String fsCertificatesType;

	@Column(name="fs_email")
	private String fsEmail;

	@Column(name="fs_name")
	private String fsName;

	@Column(name="fs_phone")
	private String fsPhone;

	//bi-directional many-to-one association to SysUser
	@ManyToOne
	@JoinColumn(name="fs_user_id")
	private SysUser sysUser;

	public SysContactsPerson() {
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

	public String getFsCertificatesCode() {
		return this.fsCertificatesCode;
	}

	public void setFsCertificatesCode(String fsCertificatesCode) {
		this.fsCertificatesCode = fsCertificatesCode;
	}

	public String getFsCertificatesType() {
		return this.fsCertificatesType;
	}

	public void setFsCertificatesType(String fsCertificatesType) {
		this.fsCertificatesType = fsCertificatesType;
	}

	public String getFsEmail() {
		return this.fsEmail;
	}

	public void setFsEmail(String fsEmail) {
		this.fsEmail = fsEmail;
	}

	public String getFsName() {
		return this.fsName;
	}

	public void setFsName(String fsName) {
		this.fsName = fsName;
	}

	public String getFsPhone() {
		return this.fsPhone;
	}

	public void setFsPhone(String fsPhone) {
		this.fsPhone = fsPhone;
	}

	public SysUser getSysUser() {
		return this.sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

}