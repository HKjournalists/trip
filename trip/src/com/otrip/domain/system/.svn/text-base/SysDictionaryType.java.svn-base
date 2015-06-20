package com.otrip.domain.system;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the sys_dictionary_type database table.
 * 
 */
@Entity
@Table(name="sys_dictionary_type")
@NamedQuery(name="SysDictionaryType.findAll", query="SELECT s FROM SysDictionaryType s")
public class SysDictionaryType extends com.otrip.domain.Entity implements Serializable {
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

	@Column(name="fs_status")
	private String fsStatus;

	//bi-directional many-to-one association to SysDictionaryValue
	@OneToMany(mappedBy="sysDictionaryType")
	private List<SysDictionaryValue> sysDictionaryValues;

	public SysDictionaryType() {
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

	public String getFsStatus() {
		return this.fsStatus;
	}

	public void setFsStatus(String fsStatus) {
		this.fsStatus = fsStatus;
	}

	public List<SysDictionaryValue> getSysDictionaryValues() {
		return this.sysDictionaryValues;
	}

	public void setSysDictionaryValues(List<SysDictionaryValue> sysDictionaryValues) {
		this.sysDictionaryValues = sysDictionaryValues;
	}

	public SysDictionaryValue addSysDictionaryValue(SysDictionaryValue sysDictionaryValue) {
		getSysDictionaryValues().add(sysDictionaryValue);
		sysDictionaryValue.setSysDictionaryType(this);

		return sysDictionaryValue;
	}

	public SysDictionaryValue removeSysDictionaryValue(SysDictionaryValue sysDictionaryValue) {
		getSysDictionaryValues().remove(sysDictionaryValue);
		sysDictionaryValue.setSysDictionaryType(null);

		return sysDictionaryValue;
	}

}