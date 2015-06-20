package com.otrip.domain.trip;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ot_acti_type database table.
 * 
 */
@Entity
@Table(name="ot_acti_type")
@NamedQuery(name="OtActiType.findAll", query="SELECT o FROM OtActiType o")
public class OtActiType extends com.otrip.domain.Entity implements Serializable {
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

	//bi-directional many-to-one association to OtActiInfo
	@OneToMany(mappedBy="otActiType")
	private List<OtActiInfo> otActiInfos;

	public OtActiType() {
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

	public List<OtActiInfo> getOtActiInfos() {
		return this.otActiInfos;
	}

	public void setOtActiInfos(List<OtActiInfo> otActiInfos) {
		this.otActiInfos = otActiInfos;
	}

	public OtActiInfo addOtActiInfo(OtActiInfo otActiInfo) {
		getOtActiInfos().add(otActiInfo);
		otActiInfo.setOtActiType(this);

		return otActiInfo;
	}

	public OtActiInfo removeOtActiInfo(OtActiInfo otActiInfo) {
		getOtActiInfos().remove(otActiInfo);
		otActiInfo.setOtActiType(null);

		return otActiInfo;
	}

}