package com.otrip.domain.trip;

import java.io.Serializable;

import javax.persistence.*;

import com.otrip.domain.system.SysUser;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ot_acti_order database table.
 * 
 */
@Entity
@Table(name="ot_acti_order")
@NamedQuery(name="OtActiOrder.findAll", query="SELECT o FROM OtActiOrder o")
public class OtActiOrder extends com.otrip.domain.Entity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="fs_id")
	private String fsId;

	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fd_create_time")
	private Date fdCreateTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fd_order_time")
	private Date fdOrderTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fd_trip_time")
	private Date fdTripTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fd_update_time")
	private Date fdUpdateTime;

	@Column(name="fn_coupon_money")
	private BigDecimal fnCouponMoney;

	@Column(name="fn_order_money")
	private BigDecimal fnOrderMoney;

	@Column(name="fn_pay_money")
	private BigDecimal fnPayMoney;

	
	@Column(name="fn_travel_adult_num")
	private int fnTravelAdultNum;

	
	@Column(name="fn_travel_children_num")
	private int fnTravelChildrenNum;

	@Column(name="fs_contact_email")
	private String fsContactEmail;

	@Column(name="fs_contact_name")
	private String fsContactName;

	@Column(name="fs_contact_phone")
	private String fsContactPhone;

	@Column(name="fs_main_travel_person_name")
	private String fsMainTravelPersonName;

	@Column(name="fs_main_travel_person_name_py")
	private String fsMainTravelPersonNamePy;

	@Column(name="fs_pay_way")
	private String fsPayWay;

	@Column(name="fs_status")
	private int fsStatus;

	
	@Column(name="fs_flag")
	private int fsFlag;
	//bi-directional many-to-one association to SysUser
	@ManyToOne
	@JoinColumn(name="fs_user_id")
	private SysUser sysUser;

	//bi-directional many-to-one association to OtActiInfo
	@ManyToOne
	@JoinColumn(name="fs_acti_id")
	private OtActiInfo otActiInfo;

	//bi-directional many-to-one association to OtActiOrderCoupon
	@OneToMany(mappedBy="otActiOrder")
	private List<OtActiOrderCoupon> otActiOrderCoupons;

	//bi-directional many-to-one association to OtActiOrderUserList
	@OneToMany(mappedBy="otActiOrder")
	private List<OtActiOrderUserList> otActiOrderUserLists;

	public OtActiOrder() {
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

	public Date getFdOrderTime() {
		return this.fdOrderTime;
	}

	public void setFdOrderTime(Date fdOrderTime) {
		this.fdOrderTime = fdOrderTime;
	}

	public Date getFdTripTime() {
		return this.fdTripTime;
	}

	public void setFdTripTime(Date fdTripTime) {
		this.fdTripTime = fdTripTime;
	}

	public Date getFdUpdateTime() {
		return this.fdUpdateTime;
	}

	public void setFdUpdateTime(Date fdUpdateTime) {
		this.fdUpdateTime = fdUpdateTime;
	}

	public BigDecimal getFnCouponMoney() {
		return this.fnCouponMoney;
	}

	public void setFnCouponMoney(BigDecimal fnCouponMoney) {
		this.fnCouponMoney = fnCouponMoney;
	}

	public BigDecimal getFnOrderMoney() {
		return this.fnOrderMoney;
	}

	public void setFnOrderMoney(BigDecimal fnOrderMoney) {
		this.fnOrderMoney = fnOrderMoney;
	}

	public BigDecimal getFnPayMoney() {
		return this.fnPayMoney;
	}

	public void setFnPayMoney(BigDecimal fnPayMoney) {
		this.fnPayMoney = fnPayMoney;
	}

	public int getFnTravelAdultNum() {
		return this.fnTravelAdultNum;
	}

	public void setFnTravelAdultNum(int fnTravelAdultNum) {
		this.fnTravelAdultNum = fnTravelAdultNum;
	}

	public int getFnTravelChildrenNum() {
		return this.fnTravelChildrenNum;
	}

	public void setFnTravelChildrenNum(int fnTravelChildrenNum) {
		this.fnTravelChildrenNum = fnTravelChildrenNum;
	}

	public String getFsContactEmail() {
		return this.fsContactEmail;
	}

	public void setFsContactEmail(String fsContactEmail) {
		this.fsContactEmail = fsContactEmail;
	}

	public String getFsContactName() {
		return this.fsContactName;
	}

	public void setFsContactName(String fsContactName) {
		this.fsContactName = fsContactName;
	}

	public String getFsContactPhone() {
		return this.fsContactPhone;
	}

	public void setFsContactPhone(String fsContactPhone) {
		this.fsContactPhone = fsContactPhone;
	}

	public String getFsMainTravelPersonName() {
		return this.fsMainTravelPersonName;
	}

	public void setFsMainTravelPersonName(String fsMainTravelPersonName) {
		this.fsMainTravelPersonName = fsMainTravelPersonName;
	}

	public String getFsMainTravelPersonNamePy() {
		return this.fsMainTravelPersonNamePy;
	}

	public void setFsMainTravelPersonNamePy(String fsMainTravelPersonNamePy) {
		this.fsMainTravelPersonNamePy = fsMainTravelPersonNamePy;
	}

	public String getFsPayWay() {
		return this.fsPayWay;
	}

	public void setFsPayWay(String fsPayWay) {
		this.fsPayWay = fsPayWay;
	}

	
	public int getFsStatus() {
		return fsStatus;
	}

	public void setFsStatus(int fsStatus) {
		this.fsStatus = fsStatus;
	}

	public SysUser getSysUser() {
		return this.sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public OtActiInfo getOtActiInfo() {
		return this.otActiInfo;
	}

	public void setOtActiInfo(OtActiInfo otActiInfo) {
		this.otActiInfo = otActiInfo;
	}

	public List<OtActiOrderCoupon> getOtActiOrderCoupons() {
		return this.otActiOrderCoupons;
	}

	public void setOtActiOrderCoupons(List<OtActiOrderCoupon> otActiOrderCoupons) {
		this.otActiOrderCoupons = otActiOrderCoupons;
	}

	public OtActiOrderCoupon addOtActiOrderCoupon(OtActiOrderCoupon otActiOrderCoupon) {
		getOtActiOrderCoupons().add(otActiOrderCoupon);
		otActiOrderCoupon.setOtActiOrder(this);

		return otActiOrderCoupon;
	}

	public OtActiOrderCoupon removeOtActiOrderCoupon(OtActiOrderCoupon otActiOrderCoupon) {
		getOtActiOrderCoupons().remove(otActiOrderCoupon);
		otActiOrderCoupon.setOtActiOrder(null);

		return otActiOrderCoupon;
	}

	public List<OtActiOrderUserList> getOtActiOrderUserLists() {
		return this.otActiOrderUserLists;
	}

	public void setOtActiOrderUserLists(List<OtActiOrderUserList> otActiOrderUserLists) {
		this.otActiOrderUserLists = otActiOrderUserLists;
	}

	public OtActiOrderUserList addOtActiOrderUserList(OtActiOrderUserList otActiOrderUserList) {
		getOtActiOrderUserLists().add(otActiOrderUserList);
		otActiOrderUserList.setOtActiOrder(this);

		return otActiOrderUserList;
	}

	public OtActiOrderUserList removeOtActiOrderUserList(OtActiOrderUserList otActiOrderUserList) {
		getOtActiOrderUserLists().remove(otActiOrderUserList);
		otActiOrderUserList.setOtActiOrder(null);

		return otActiOrderUserList;
	}

	public int getFsFlag() {
		return fsFlag;
	}

	public void setFsFlag(int fsFlag) {
		this.fsFlag = fsFlag;
	}

	

	
	
}