package com.otrip.domain.airport;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ot_meet_airport database table.
 * 
 */
@Entity
@Table(name="ot_meet_airport")
@NamedQuery(name="OtMeetAirport.findAll", query="SELECT o FROM OtMeetAirport o")
public class OtMeetAirport extends com.otrip.domain.Entity implements Serializable {
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

	@Column(name="fs_airport")
	private String fsAirport;

	@Column(name="fs_city")
	private String fsCity;

	@Column(name="fs_continent")
	private String fsContinent;

	@Column(name="fs_country")
	private String fsCountry;

	@Column(name="fs_latitude")
	private Double fsLatitude;

	@Column(name="fs_longitude")
	private Double fsLongitude;

	@Column(name="fs_province")
	private String fsProvince;

	//bi-directional many-to-one association to OtMeetAirportDiscuss
	@OneToMany(mappedBy="otMeetAirport")
	private List<OtMeetAirportDiscuss> otMeetAirportDiscusses;

	//bi-directional many-to-one association to OtMeetAirportOrder
	@OneToMany(mappedBy="otMeetAirport1")
	private List<OtMeetAirportOrder> otMeetAirportOrders1;

	//bi-directional many-to-one association to OtMeetAirportOrder
	@OneToMany(mappedBy="otMeetAirport2")
	private List<OtMeetAirportOrder> otMeetAirportOrders2;

	public OtMeetAirport() {
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

	public String getFsAirport() {
		return this.fsAirport;
	}

	public void setFsAirport(String fsAirport) {
		this.fsAirport = fsAirport;
	}

	public String getFsCity() {
		return this.fsCity;
	}

	public void setFsCity(String fsCity) {
		this.fsCity = fsCity;
	}

	public String getFsContinent() {
		return this.fsContinent;
	}

	public void setFsContinent(String fsContinent) {
		this.fsContinent = fsContinent;
	}

	public String getFsCountry() {
		return this.fsCountry;
	}

	public void setFsCountry(String fsCountry) {
		this.fsCountry = fsCountry;
	}

	

	public Double getFsLatitude() {
		return fsLatitude;
	}

	public void setFsLatitude(Double fsLatitude) {
		this.fsLatitude = fsLatitude;
	}

	public Double getFsLongitude() {
		return fsLongitude;
	}

	public void setFsLongitude(Double fsLongitude) {
		this.fsLongitude = fsLongitude;
	}

	public String getFsProvince() {
		return this.fsProvince;
	}

	public void setFsProvince(String fsProvince) {
		this.fsProvince = fsProvince;
	}

	public List<OtMeetAirportDiscuss> getOtMeetAirportDiscusses() {
		return this.otMeetAirportDiscusses;
	}

	public void setOtMeetAirportDiscusses(List<OtMeetAirportDiscuss> otMeetAirportDiscusses) {
		this.otMeetAirportDiscusses = otMeetAirportDiscusses;
	}

	public OtMeetAirportDiscuss addOtMeetAirportDiscuss(OtMeetAirportDiscuss otMeetAirportDiscuss) {
		getOtMeetAirportDiscusses().add(otMeetAirportDiscuss);
		otMeetAirportDiscuss.setOtMeetAirport(this);

		return otMeetAirportDiscuss;
	}

	public OtMeetAirportDiscuss removeOtMeetAirportDiscuss(OtMeetAirportDiscuss otMeetAirportDiscuss) {
		getOtMeetAirportDiscusses().remove(otMeetAirportDiscuss);
		otMeetAirportDiscuss.setOtMeetAirport(null);

		return otMeetAirportDiscuss;
	}

	public List<OtMeetAirportOrder> getOtMeetAirportOrders1() {
		return this.otMeetAirportOrders1;
	}

	public void setOtMeetAirportOrders1(List<OtMeetAirportOrder> otMeetAirportOrders1) {
		this.otMeetAirportOrders1 = otMeetAirportOrders1;
	}

	public OtMeetAirportOrder addOtMeetAirportOrders1(OtMeetAirportOrder otMeetAirportOrders1) {
		getOtMeetAirportOrders1().add(otMeetAirportOrders1);
		otMeetAirportOrders1.setOtMeetAirport1(this);

		return otMeetAirportOrders1;
	}

	public OtMeetAirportOrder removeOtMeetAirportOrders1(OtMeetAirportOrder otMeetAirportOrders1) {
		getOtMeetAirportOrders1().remove(otMeetAirportOrders1);
		otMeetAirportOrders1.setOtMeetAirport1(null);

		return otMeetAirportOrders1;
	}

	public List<OtMeetAirportOrder> getOtMeetAirportOrders2() {
		return this.otMeetAirportOrders2;
	}

	public void setOtMeetAirportOrders2(List<OtMeetAirportOrder> otMeetAirportOrders2) {
		this.otMeetAirportOrders2 = otMeetAirportOrders2;
	}

	public OtMeetAirportOrder addOtMeetAirportOrders2(OtMeetAirportOrder otMeetAirportOrders2) {
		getOtMeetAirportOrders2().add(otMeetAirportOrders2);
		otMeetAirportOrders2.setOtMeetAirport2(this);

		return otMeetAirportOrders2;
	}

	public OtMeetAirportOrder removeOtMeetAirportOrders2(OtMeetAirportOrder otMeetAirportOrders2) {
		getOtMeetAirportOrders2().remove(otMeetAirportOrders2);
		otMeetAirportOrders2.setOtMeetAirport2(null);

		return otMeetAirportOrders2;
	}

}