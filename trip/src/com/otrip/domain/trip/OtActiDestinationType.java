package com.otrip.domain.trip;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ot_acti_destination_type database table.
 * 
 */
@Entity
@Table(name="ot_acti_destination_type")
@NamedQuery(name="OtActiDestinationType.findAll", query="SELECT o FROM OtActiDestinationType o")
public class OtActiDestinationType extends com.otrip.domain.Entity implements Serializable {
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

	//bi-directional many-to-one association to OtActiDestination
	@OneToMany(mappedBy="otActiDestinationType")
	private List<OtActiDestination> otActiDestinations;

	//bi-directional many-to-one association to OtActiInfo
	@OneToMany(mappedBy="otActiDestinationType")
	private List<OtActiInfo> otActiInfos;

	public OtActiDestinationType() {
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

	public List<OtActiDestination> getOtActiDestinations() {
		return this.otActiDestinations;
	}

	public void setOtActiDestinations(List<OtActiDestination> otActiDestinations) {
		this.otActiDestinations = otActiDestinations;
	}

	public OtActiDestination addOtActiDestination(OtActiDestination otActiDestination) {
		getOtActiDestinations().add(otActiDestination);
		otActiDestination.setOtActiDestinationType(this);

		return otActiDestination;
	}

	public OtActiDestination removeOtActiDestination(OtActiDestination otActiDestination) {
		getOtActiDestinations().remove(otActiDestination);
		otActiDestination.setOtActiDestinationType(null);

		return otActiDestination;
	}

	public List<OtActiInfo> getOtActiInfos() {
		return this.otActiInfos;
	}

	public void setOtActiInfos(List<OtActiInfo> otActiInfos) {
		this.otActiInfos = otActiInfos;
	}

	public OtActiInfo addOtActiInfo(OtActiInfo otActiInfo) {
		getOtActiInfos().add(otActiInfo);
		otActiInfo.setOtActiDestinationType(this);

		return otActiInfo;
	}

	public OtActiInfo removeOtActiInfo(OtActiInfo otActiInfo) {
		getOtActiInfos().remove(otActiInfo);
		otActiInfo.setOtActiDestinationType(null);

		return otActiInfo;
	}

}