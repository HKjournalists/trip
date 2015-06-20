package com.otrip.domain.system;

import java.io.Serializable;

import javax.persistence.*;

import com.otrip.domain.airport.OtMeetAirportDiscuss;
import com.otrip.domain.airport.OtMeetAirportOrder;
import com.otrip.domain.order.OtOwnerCoupon;
import com.otrip.domain.trip.OtActiClickPraise;
import com.otrip.domain.trip.OtActiDiscuss;
import com.otrip.domain.trip.OtActiFavorite;
import com.otrip.domain.trip.OtActiOrder;
import com.otrip.domain.trip.OtActiOrderCoupon;
import com.otrip.domain.trip.OtActiProblemDiscuss;
import com.otrip.domain.ws.WsLogLogin;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the sys_user database table.
 * 
 */
@Entity
@Table(name="sys_user")
@NamedQuery(name="SysUser.findAll", query="SELECT s FROM SysUser s")
public class SysUser extends com.otrip.domain.Entity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="fs_id")
	private String fsId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fd_create_time")
	private Date fdCreateTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fd_register_date")
	private Date fdRegisterDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fd_update_time")
	private Date fdUpdateTime;

	@Column(name="fs_account")
	private String fsAccount;

	@Column(name="fs_description")
	private String fsDescription;

	@Column(name="fs_email")
	private String fsEmail;

	@Lob
	@Column(name="fs_image")
	private byte[] fsImage;

	@Column(name="fs_name")
	private String fsName;

	@Column(name="fs_password")
	private String fsPassword;

	@Column(name="fs_phone")
	private String fsPhone;

	@Column(name="fs_status")
	private String fsStatus;

	@Column(name="fs_type_sign")
	private String fsTypeSign;

	//bi-directional many-to-one association to OtActiClickPraise
	@OneToMany(mappedBy="sysUser")
	private List<OtActiClickPraise> otActiClickPraises;

	//bi-directional many-to-one association to OtActiDiscuss
	@OneToMany(mappedBy="sysUser")
	private List<OtActiDiscuss> otActiDiscusses;

	//bi-directional many-to-one association to OtActiFavorite
	@OneToMany(mappedBy="sysUser")
	private List<OtActiFavorite> otActiFavorites;

	//bi-directional many-to-one association to OtActiOrder
	@OneToMany(mappedBy="sysUser")
	private List<OtActiOrder> otActiOrders;

	//bi-directional many-to-one association to OtActiOrderCoupon
	@OneToMany(mappedBy="sysUser")
	private List<OtActiOrderCoupon> otActiOrderCoupons;

	//bi-directional many-to-one association to OtActiProblemDiscuss
	@OneToMany(mappedBy="sysUser")
	private List<OtActiProblemDiscuss> otActiProblemDiscusses;

	//bi-directional many-to-one association to OtMeetAirportDiscuss
	@OneToMany(mappedBy="sysUser")
	private List<OtMeetAirportDiscuss> otMeetAirportDiscusses;

	//bi-directional many-to-one association to OtMeetAirportOrder
	@OneToMany(mappedBy="sysUser")
	private List<OtMeetAirportOrder> otMeetAirportOrders;

	//bi-directional many-to-one association to OtOwnerCoupon
	@OneToMany(mappedBy="sysUser")
	private List<OtOwnerCoupon> otOwnerCoupons;

	//bi-directional many-to-one association to SysContactsPerson
	@OneToMany(mappedBy="sysUser")
	private List<SysContactsPerson> sysContactsPersons;

	//bi-directional many-to-one association to SysLoginHistory
	@OneToMany(mappedBy="sysUser")
	private List<SysLoginHistory> sysLoginHistories;

	//bi-directional many-to-one association to SysUserRole
	@OneToMany(mappedBy="sysUser")
	private List<SysUserRole> sysUserRoles;

	//bi-directional many-to-one association to WsLogLogin
	@OneToMany(mappedBy="sysUser")
	private List<WsLogLogin> wsLogLogins;

	public SysUser() {
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

	public Date getFdRegisterDate() {
		return this.fdRegisterDate;
	}

	public void setFdRegisterDate(Date fdRegisterDate) {
		this.fdRegisterDate = fdRegisterDate;
	}

	public Date getFdUpdateTime() {
		return this.fdUpdateTime;
	}

	public void setFdUpdateTime(Date fdUpdateTime) {
		this.fdUpdateTime = fdUpdateTime;
	}

	public String getFsAccount() {
		return this.fsAccount;
	}

	public void setFsAccount(String fsAccount) {
		this.fsAccount = fsAccount;
	}

	public String getFsDescription() {
		return this.fsDescription;
	}

	public void setFsDescription(String fsDescription) {
		this.fsDescription = fsDescription;
	}

	public String getFsEmail() {
		return this.fsEmail;
	}

	public void setFsEmail(String fsEmail) {
		this.fsEmail = fsEmail;
	}

	public byte[] getFsImage() {
		return this.fsImage;
	}

	public void setFsImage(byte[] fsImage) {
		this.fsImage = fsImage;
	}

	public String getFsName() {
		return this.fsName;
	}

	public void setFsName(String fsName) {
		this.fsName = fsName;
	}

	public String getFsPassword() {
		return this.fsPassword;
	}

	public void setFsPassword(String fsPassword) {
		this.fsPassword = fsPassword;
	}

	public String getFsPhone() {
		return this.fsPhone;
	}

	public void setFsPhone(String fsPhone) {
		this.fsPhone = fsPhone;
	}

	public String getFsStatus() {
		return this.fsStatus;
	}

	public void setFsStatus(String fsStatus) {
		this.fsStatus = fsStatus;
	}

	public String getFsTypeSign() {
		return this.fsTypeSign;
	}

	public void setFsTypeSign(String fsTypeSign) {
		this.fsTypeSign = fsTypeSign;
	}

	public List<OtActiClickPraise> getOtActiClickPraises() {
		return this.otActiClickPraises;
	}

	public void setOtActiClickPraises(List<OtActiClickPraise> otActiClickPraises) {
		this.otActiClickPraises = otActiClickPraises;
	}

	public OtActiClickPraise addOtActiClickPrais(OtActiClickPraise otActiClickPrais) {
		getOtActiClickPraises().add(otActiClickPrais);
		otActiClickPrais.setSysUser(this);

		return otActiClickPrais;
	}

	public OtActiClickPraise removeOtActiClickPrais(OtActiClickPraise otActiClickPrais) {
		getOtActiClickPraises().remove(otActiClickPrais);
		otActiClickPrais.setSysUser(null);

		return otActiClickPrais;
	}

	public List<OtActiDiscuss> getOtActiDiscusses() {
		return this.otActiDiscusses;
	}

	public void setOtActiDiscusses(List<OtActiDiscuss> otActiDiscusses) {
		this.otActiDiscusses = otActiDiscusses;
	}

	public OtActiDiscuss addOtActiDiscuss(OtActiDiscuss otActiDiscuss) {
		getOtActiDiscusses().add(otActiDiscuss);
		otActiDiscuss.setSysUser(this);

		return otActiDiscuss;
	}

	public OtActiDiscuss removeOtActiDiscuss(OtActiDiscuss otActiDiscuss) {
		getOtActiDiscusses().remove(otActiDiscuss);
		otActiDiscuss.setSysUser(null);

		return otActiDiscuss;
	}

	public List<OtActiFavorite> getOtActiFavorites() {
		return this.otActiFavorites;
	}

	public void setOtActiFavorites(List<OtActiFavorite> otActiFavorites) {
		this.otActiFavorites = otActiFavorites;
	}

	public OtActiFavorite addOtActiFavorite(OtActiFavorite otActiFavorite) {
		getOtActiFavorites().add(otActiFavorite);
		otActiFavorite.setSysUser(this);

		return otActiFavorite;
	}

	public OtActiFavorite removeOtActiFavorite(OtActiFavorite otActiFavorite) {
		getOtActiFavorites().remove(otActiFavorite);
		otActiFavorite.setSysUser(null);

		return otActiFavorite;
	}

	public List<OtActiOrder> getOtActiOrders() {
		return this.otActiOrders;
	}

	public void setOtActiOrders(List<OtActiOrder> otActiOrders) {
		this.otActiOrders = otActiOrders;
	}

	public OtActiOrder addOtActiOrder(OtActiOrder otActiOrder) {
		getOtActiOrders().add(otActiOrder);
		otActiOrder.setSysUser(this);

		return otActiOrder;
	}

	public OtActiOrder removeOtActiOrder(OtActiOrder otActiOrder) {
		getOtActiOrders().remove(otActiOrder);
		otActiOrder.setSysUser(null);

		return otActiOrder;
	}

	public List<OtActiOrderCoupon> getOtActiOrderCoupons() {
		return this.otActiOrderCoupons;
	}

	public void setOtActiOrderCoupons(List<OtActiOrderCoupon> otActiOrderCoupons) {
		this.otActiOrderCoupons = otActiOrderCoupons;
	}

	public OtActiOrderCoupon addOtActiOrderCoupon(OtActiOrderCoupon otActiOrderCoupon) {
		getOtActiOrderCoupons().add(otActiOrderCoupon);
		otActiOrderCoupon.setSysUser(this);

		return otActiOrderCoupon;
	}

	public OtActiOrderCoupon removeOtActiOrderCoupon(OtActiOrderCoupon otActiOrderCoupon) {
		getOtActiOrderCoupons().remove(otActiOrderCoupon);
		otActiOrderCoupon.setSysUser(null);

		return otActiOrderCoupon;
	}

	public List<OtActiProblemDiscuss> getOtActiProblemDiscusses() {
		return this.otActiProblemDiscusses;
	}

	public void setOtActiProblemDiscusses(List<OtActiProblemDiscuss> otActiProblemDiscusses) {
		this.otActiProblemDiscusses = otActiProblemDiscusses;
	}

	public OtActiProblemDiscuss addOtActiProblemDiscuss(OtActiProblemDiscuss otActiProblemDiscuss) {
		getOtActiProblemDiscusses().add(otActiProblemDiscuss);
		otActiProblemDiscuss.setSysUser(this);

		return otActiProblemDiscuss;
	}

	public OtActiProblemDiscuss removeOtActiProblemDiscuss(OtActiProblemDiscuss otActiProblemDiscuss) {
		getOtActiProblemDiscusses().remove(otActiProblemDiscuss);
		otActiProblemDiscuss.setSysUser(null);

		return otActiProblemDiscuss;
	}

	public List<OtMeetAirportDiscuss> getOtMeetAirportDiscusses() {
		return this.otMeetAirportDiscusses;
	}

	public void setOtMeetAirportDiscusses(List<OtMeetAirportDiscuss> otMeetAirportDiscusses) {
		this.otMeetAirportDiscusses = otMeetAirportDiscusses;
	}

	public OtMeetAirportDiscuss addOtMeetAirportDiscuss(OtMeetAirportDiscuss otMeetAirportDiscuss) {
		getOtMeetAirportDiscusses().add(otMeetAirportDiscuss);
		otMeetAirportDiscuss.setSysUser(this);

		return otMeetAirportDiscuss;
	}

	public OtMeetAirportDiscuss removeOtMeetAirportDiscuss(OtMeetAirportDiscuss otMeetAirportDiscuss) {
		getOtMeetAirportDiscusses().remove(otMeetAirportDiscuss);
		otMeetAirportDiscuss.setSysUser(null);

		return otMeetAirportDiscuss;
	}

	public List<OtMeetAirportOrder> getOtMeetAirportOrders() {
		return this.otMeetAirportOrders;
	}

	public void setOtMeetAirportOrders(List<OtMeetAirportOrder> otMeetAirportOrders) {
		this.otMeetAirportOrders = otMeetAirportOrders;
	}

	public OtMeetAirportOrder addOtMeetAirportOrder(OtMeetAirportOrder otMeetAirportOrder) {
		getOtMeetAirportOrders().add(otMeetAirportOrder);
		otMeetAirportOrder.setSysUser(this);

		return otMeetAirportOrder;
	}

	public OtMeetAirportOrder removeOtMeetAirportOrder(OtMeetAirportOrder otMeetAirportOrder) {
		getOtMeetAirportOrders().remove(otMeetAirportOrder);
		otMeetAirportOrder.setSysUser(null);

		return otMeetAirportOrder;
	}

	public List<OtOwnerCoupon> getOtOwnerCoupons() {
		return this.otOwnerCoupons;
	}

	public void setOtOwnerCoupons(List<OtOwnerCoupon> otOwnerCoupons) {
		this.otOwnerCoupons = otOwnerCoupons;
	}

	public OtOwnerCoupon addOtOwnerCoupon(OtOwnerCoupon otOwnerCoupon) {
		getOtOwnerCoupons().add(otOwnerCoupon);
		otOwnerCoupon.setSysUser(this);

		return otOwnerCoupon;
	}

	public OtOwnerCoupon removeOtOwnerCoupon(OtOwnerCoupon otOwnerCoupon) {
		getOtOwnerCoupons().remove(otOwnerCoupon);
		otOwnerCoupon.setSysUser(null);

		return otOwnerCoupon;
	}

	public List<SysContactsPerson> getSysContactsPersons() {
		return this.sysContactsPersons;
	}

	public void setSysContactsPersons(List<SysContactsPerson> sysContactsPersons) {
		this.sysContactsPersons = sysContactsPersons;
	}

	public SysContactsPerson addSysContactsPerson(SysContactsPerson sysContactsPerson) {
		getSysContactsPersons().add(sysContactsPerson);
		sysContactsPerson.setSysUser(this);

		return sysContactsPerson;
	}

	public SysContactsPerson removeSysContactsPerson(SysContactsPerson sysContactsPerson) {
		getSysContactsPersons().remove(sysContactsPerson);
		sysContactsPerson.setSysUser(null);

		return sysContactsPerson;
	}

	public List<SysLoginHistory> getSysLoginHistories() {
		return this.sysLoginHistories;
	}

	public void setSysLoginHistories(List<SysLoginHistory> sysLoginHistories) {
		this.sysLoginHistories = sysLoginHistories;
	}

	public SysLoginHistory addSysLoginHistory(SysLoginHistory sysLoginHistory) {
		getSysLoginHistories().add(sysLoginHistory);
		sysLoginHistory.setSysUser(this);

		return sysLoginHistory;
	}

	public SysLoginHistory removeSysLoginHistory(SysLoginHistory sysLoginHistory) {
		getSysLoginHistories().remove(sysLoginHistory);
		sysLoginHistory.setSysUser(null);

		return sysLoginHistory;
	}

	public List<SysUserRole> getSysUserRoles() {
		return this.sysUserRoles;
	}

	public void setSysUserRoles(List<SysUserRole> sysUserRoles) {
		this.sysUserRoles = sysUserRoles;
	}

	public SysUserRole addSysUserRole(SysUserRole sysUserRole) {
		getSysUserRoles().add(sysUserRole);
		sysUserRole.setSysUser(this);

		return sysUserRole;
	}

	public SysUserRole removeSysUserRole(SysUserRole sysUserRole) {
		getSysUserRoles().remove(sysUserRole);
		sysUserRole.setSysUser(null);

		return sysUserRole;
	}

	public List<WsLogLogin> getWsLogLogins() {
		return this.wsLogLogins;
	}

	public void setWsLogLogins(List<WsLogLogin> wsLogLogins) {
		this.wsLogLogins = wsLogLogins;
	}

	public WsLogLogin addWsLogLogin(WsLogLogin wsLogLogin) {
		getWsLogLogins().add(wsLogLogin);
		wsLogLogin.setSysUser(this);

		return wsLogLogin;
	}

	public WsLogLogin removeWsLogLogin(WsLogLogin wsLogLogin) {
		getWsLogLogins().remove(wsLogLogin);
		wsLogLogin.setSysUser(null);

		return wsLogLogin;
	}

}