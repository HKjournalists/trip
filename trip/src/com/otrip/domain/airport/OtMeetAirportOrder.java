package com.otrip.domain.airport;

import java.io.Serializable;

import javax.persistence.*;
import com.otrip.domain.system.SysUser;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ot_meet_airport_order database table.
 * 
 */
@Entity
@Table(name="ot_meet_airport_order")
@NamedQuery(name="OtMeetAirportOrder.findAll", query="SELECT o FROM OtMeetAirportOrder o")
public class OtMeetAirportOrder extends com.otrip.domain.Entity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="fs_id")
	private String fsId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fd_create_time")
	private Date fdCreateTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fd_meet_time")
	private Date fdMeetTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fd_order_time")
	private Date fdOrderTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fd_pay_time")
	private Date fdPayTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fd_start_time")
	private Date fdStartTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fd_update_time")
	private Date fdUpdateTime;

	@Column(name="fn_order_money")
	private BigDecimal fnOrderMoney;

	@Lob
	@Column(name="fn_passenger_adult")
	private String fnPassengerAdult;

	@Lob
	@Column(name="fn_passenger_children")
	private String fnPassengerChildren;

	@Column(name="fs_contact_phone")
	private String fsContactPhone;

	@Column(name="fs_contacts_user")
	private String fsContactsUser;

	@Column(name="fs_description")
	private String fsDescription;

	@Column(name="fs_order_no")
	private String fsOrderNo;

	@Column(name="fs_pay_way")
	private String fsPayWay;

	@Column(name="fs_status")
	private String fsStatus;

	//bi-directional many-to-one association to OtMeetAirport
	@ManyToOne
	@JoinColumn(name="fs_start_airport_id")
	private OtMeetAirport otMeetAirport1;

	//bi-directional many-to-one association to OtMeetAirport
	@ManyToOne
	@JoinColumn(name="fs_meet_airport_id")
	private OtMeetAirport otMeetAirport2;

	//bi-directional many-to-one association to SysUser
	@ManyToOne
	@JoinColumn(name="fs_order_user")
	private SysUser sysUser;

	//bi-directional many-to-one association to OtOrderPassenger
	@OneToMany(mappedBy="otMeetAirportOrder")
	private List<OtOrderPassenger> otOrderPassengers;

	public OtMeetAirportOrder() {
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

	public Date getFdMeetTime() {
		return this.fdMeetTime;
	}

	public void setFdMeetTime(Date fdMeetTime) {
		this.fdMeetTime = fdMeetTime;
	}

	public Date getFdOrderTime() {
		return this.fdOrderTime;
	}

	public void setFdOrderTime(Date fdOrderTime) {
		this.fdOrderTime = fdOrderTime;
	}

	public Date getFdPayTime() {
		return this.fdPayTime;
	}

	public void setFdPayTime(Date fdPayTime) {
		this.fdPayTime = fdPayTime;
	}

	public Date getFdStartTime() {
		return this.fdStartTime;
	}

	public void setFdStartTime(Date fdStartTime) {
		this.fdStartTime = fdStartTime;
	}

	public Date getFdUpdateTime() {
		return this.fdUpdateTime;
	}

	public void setFdUpdateTime(Date fdUpdateTime) {
		this.fdUpdateTime = fdUpdateTime;
	}

	public BigDecimal getFnOrderMoney() {
		return this.fnOrderMoney;
	}

	public void setFnOrderMoney(BigDecimal fnOrderMoney) {
		this.fnOrderMoney = fnOrderMoney;
	}

	public String getFnPassengerAdult() {
		return this.fnPassengerAdult;
	}

	public void setFnPassengerAdult(String fnPassengerAdult) {
		this.fnPassengerAdult = fnPassengerAdult;
	}

	public String getFnPassengerChildren() {
		return this.fnPassengerChildren;
	}

	public void setFnPassengerChildren(String fnPassengerChildren) {
		this.fnPassengerChildren = fnPassengerChildren;
	}

	public String getFsContactPhone() {
		return this.fsContactPhone;
	}

	public void setFsContactPhone(String fsContactPhone) {
		this.fsContactPhone = fsContactPhone;
	}

	public String getFsContactsUser() {
		return this.fsContactsUser;
	}

	public void setFsContactsUser(String fsContactsUser) {
		this.fsContactsUser = fsContactsUser;
	}

	public String getFsDescription() {
		return this.fsDescription;
	}

	public void setFsDescription(String fsDescription) {
		this.fsDescription = fsDescription;
	}

	public String getFsOrderNo() {
		return this.fsOrderNo;
	}

	public void setFsOrderNo(String fsOrderNo) {
		this.fsOrderNo = fsOrderNo;
	}

	public String getFsPayWay() {
		return this.fsPayWay;
	}

	public void setFsPayWay(String fsPayWay) {
		this.fsPayWay = fsPayWay;
	}

	public String getFsStatus() {
		return this.fsStatus;
	}

	public void setFsStatus(String fsStatus) {
		this.fsStatus = fsStatus;
	}

	public OtMeetAirport getOtMeetAirport1() {
		return this.otMeetAirport1;
	}

	public void setOtMeetAirport1(OtMeetAirport otMeetAirport1) {
		this.otMeetAirport1 = otMeetAirport1;
	}

	public OtMeetAirport getOtMeetAirport2() {
		return this.otMeetAirport2;
	}

	public void setOtMeetAirport2(OtMeetAirport otMeetAirport2) {
		this.otMeetAirport2 = otMeetAirport2;
	}

	public SysUser getSysUser() {
		return this.sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public List<OtOrderPassenger> getOtOrderPassengers() {
		return this.otOrderPassengers;
	}

	public void setOtOrderPassengers(List<OtOrderPassenger> otOrderPassengers) {
		this.otOrderPassengers = otOrderPassengers;
	}

	public OtOrderPassenger addOtOrderPassenger(OtOrderPassenger otOrderPassenger) {
		getOtOrderPassengers().add(otOrderPassenger);
		otOrderPassenger.setOtMeetAirportOrder(this);

		return otOrderPassenger;
	}

	public OtOrderPassenger removeOtOrderPassenger(OtOrderPassenger otOrderPassenger) {
		getOtOrderPassengers().remove(otOrderPassenger);
		otOrderPassenger.setOtMeetAirportOrder(null);

		return otOrderPassenger;
	}

}