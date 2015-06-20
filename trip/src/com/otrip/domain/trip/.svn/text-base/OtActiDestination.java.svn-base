package com.otrip.domain.trip;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ot_acti_destination database table.
 * 
 */
@Entity
@Table(name="ot_acti_destination")
@NamedQuery(name="OtActiDestination.findAll", query="SELECT o FROM OtActiDestination o")
public class OtActiDestination extends com.otrip.domain.Entity implements Serializable {
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

	@Column(name="fs_latitude")
	private double fsLatitude;

	@Column(name="fs_longitudel")
	private double fsLongitudel;

	@Column(name="fs_name")
	private String fsName;

	@Column(name="fs_parent_id")
	private String fsParentId;

	@Column(name="fs_value")
	private String fsValue;

	//bi-directional many-to-one association to OtActiDestinationType
	@ManyToOne
	@JoinColumn(name="fs_type_id")
	private OtActiDestinationType otActiDestinationType;

	//bi-directional many-to-one association to OtActiInfo
	@OneToMany(mappedBy="fsDestinationContinent")
	private List<OtActiInfo> otActiInfos1;

	//bi-directional many-to-one association to OtActiInfo
	@OneToMany(mappedBy="fsDestinationCountry")
	private List<OtActiInfo> otActiInfos2;

	//bi-directional many-to-one association to OtActiInfo
	@OneToMany(mappedBy="fsDestinationProvince")
	private List<OtActiInfo> otActiInfos3;

	//bi-directional many-to-one association to OtActiInfo
	@OneToMany(mappedBy="fsDestinationCity")
	private List<OtActiInfo> otActiInfos4;

	//bi-directional many-to-one association to OtActiInfo
	@OneToMany(mappedBy="fsDestinationScenic")
	private List<OtActiInfo> otActiInfos5;

	public OtActiDestination() {
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

	

	public double getFsLatitude() {
		return fsLatitude;
	}

	public void setFsLatitude(double fsLatitude) {
		this.fsLatitude = fsLatitude;
	}

	
	

	public double getFsLongitudel() {
		return fsLongitudel;
	}

	public void setFsLongitudel(double fsLongitudel) {
		this.fsLongitudel = fsLongitudel;
	}

	public String getFsName() {
		return this.fsName;
	}

	public void setFsName(String fsName) {
		this.fsName = fsName;
	}

	public String getFsParentId() {
		return this.fsParentId;
	}

	public void setFsParentId(String fsParentId) {
		this.fsParentId = fsParentId;
	}

	public String getFsValue() {
		return this.fsValue;
	}

	public void setFsValue(String fsValue) {
		this.fsValue = fsValue;
	}

	public OtActiDestinationType getOtActiDestinationType() {
		return this.otActiDestinationType;
	}

	public void setOtActiDestinationType(OtActiDestinationType otActiDestinationType) {
		this.otActiDestinationType = otActiDestinationType;
	}

	public List<OtActiInfo> getOtActiInfos1() {
		return this.otActiInfos1;
	}

	public void setOtActiInfos1(List<OtActiInfo> otActiInfos1) {
		this.otActiInfos1 = otActiInfos1;
	}

	public OtActiInfo addOtActiInfos1(OtActiInfo otActiInfos1) {
		getOtActiInfos1().add(otActiInfos1);
		otActiInfos1.setFsDestinationContinent(this);;

		return otActiInfos1;
	}

	public OtActiInfo removeOtActiInfos1(OtActiInfo otActiInfos1) {
		getOtActiInfos1().remove(otActiInfos1);
		otActiInfos1.setFsDestinationContinent(null);

		return otActiInfos1;
	}

	public List<OtActiInfo> getOtActiInfos2() {
		return this.otActiInfos2;
	}

	public void setOtActiInfos2(List<OtActiInfo> otActiInfos2) {
		this.otActiInfos2 = otActiInfos2;
	}

	public OtActiInfo addOtActiInfos2(OtActiInfo otActiInfos2) {
		getOtActiInfos2().add(otActiInfos2);
		otActiInfos2.setFsDestinationCountry(this);;

		return otActiInfos2;
	}

	public OtActiInfo removeOtActiInfos2(OtActiInfo otActiInfos2) {
		getOtActiInfos2().remove(otActiInfos2);
		otActiInfos2.setFsDestinationCountry(null);

		return otActiInfos2;
	}

	public List<OtActiInfo> getOtActiInfos3() {
		return this.otActiInfos3;
	}

	public void setOtActiInfos3(List<OtActiInfo> otActiInfos3) {
		this.otActiInfos3 = otActiInfos3;
	}

	public OtActiInfo addOtActiInfos3(OtActiInfo otActiInfos3) {
		getOtActiInfos3().add(otActiInfos3);
		otActiInfos3.setFsDestinationProvince(this);

		return otActiInfos3;
	}

	public OtActiInfo removeOtActiInfos3(OtActiInfo otActiInfos3) {
		getOtActiInfos3().remove(otActiInfos3);
		otActiInfos3.setFsDestinationProvince(null);

		return otActiInfos3;
	}

	public List<OtActiInfo> getOtActiInfos4() {
		return this.otActiInfos4;
	}

	public void setOtActiInfos4(List<OtActiInfo> otActiInfos4) {
		this.otActiInfos4 = otActiInfos4;
	}

	public OtActiInfo addOtActiInfos4(OtActiInfo otActiInfos4) {
		getOtActiInfos4().add(otActiInfos4);
		otActiInfos4.setFsDestinationCity(this);

		return otActiInfos4;
	}

	public OtActiInfo removeOtActiInfos4(OtActiInfo otActiInfos4) {
		getOtActiInfos4().remove(otActiInfos4);
		otActiInfos4.setFsDestinationCity(null);

		return otActiInfos4;
	}

	public List<OtActiInfo> getOtActiInfos5() {
		return this.otActiInfos5;
	}

	public void setOtActiInfos5(List<OtActiInfo> otActiInfos5) {
		this.otActiInfos5 = otActiInfos5;
	}

	public OtActiInfo addOtActiInfos5(OtActiInfo otActiInfos5) {
		getOtActiInfos5().add(otActiInfos5);
		otActiInfos5.setFsDestinationScenic(this);

		return otActiInfos5;
	}

	public OtActiInfo removeOtActiInfos5(OtActiInfo otActiInfos5) {
		getOtActiInfos5().remove(otActiInfos5);
		otActiInfos5.setFsDestinationScenic(null);

		return otActiInfos5;
	}

}