package com.otrip.domain.order;

import java.io.Serializable;

import javax.persistence.*;

import com.otrip.domain.trip.OtActiOrderCoupon;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ot_coupon_part database table.
 * 
 */
@Entity
@Table(name="ot_coupon_part")
@NamedQuery(name="OtCouponPart.findAll", query="SELECT o FROM OtCouponPart o")
public class OtCouponPart extends com.otrip.domain.Entity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="fs_id")
	private String fsId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fd_create_time")
	private Date fdCreateTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fd_effective_end_time")
	private Date fdEffectiveEndTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fd_effective_start_time")
	private Date fdEffectiveStartTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fd_update_time")
	private Date fdUpdateTime;

	@Column(name="fn_per_money")
	private BigDecimal fnPerMoney;

	@Column(name="fs_code")
	private String fsCode;

	@Column(name="fs_description")
	private String fsDescription;

	@Column(name="fs_name")
	private String fsName;

	@Column(name="fs_status")
	private String fsStatus;

	//bi-directional many-to-one association to OtActiOrderCoupon
	@OneToMany(mappedBy="otCouponPart")
	private List<OtActiOrderCoupon> otActiOrderCoupons;

	//bi-directional many-to-one association to OtCouponGather
	@ManyToOne
	@JoinColumn(name="fs_coupon_gather_id")
	private OtCouponGather otCouponGather;

	//bi-directional many-to-one association to OtOwnerCoupon
	@OneToMany(mappedBy="otCouponPart")
	private List<OtOwnerCoupon> otOwnerCoupons;

	public OtCouponPart() {
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

	public Date getFdEffectiveEndTime() {
		return this.fdEffectiveEndTime;
	}

	public void setFdEffectiveEndTime(Date fdEffectiveEndTime) {
		this.fdEffectiveEndTime = fdEffectiveEndTime;
	}

	public Date getFdEffectiveStartTime() {
		return this.fdEffectiveStartTime;
	}

	public void setFdEffectiveStartTime(Date fdEffectiveStartTime) {
		this.fdEffectiveStartTime = fdEffectiveStartTime;
	}

	public Date getFdUpdateTime() {
		return this.fdUpdateTime;
	}

	public void setFdUpdateTime(Date fdUpdateTime) {
		this.fdUpdateTime = fdUpdateTime;
	}

	public BigDecimal getFnPerMoney() {
		return this.fnPerMoney;
	}

	public void setFnPerMoney(BigDecimal fnPerMoney) {
		this.fnPerMoney = fnPerMoney;
	}

	public String getFsCode() {
		return this.fsCode;
	}

	public void setFsCode(String fsCode) {
		this.fsCode = fsCode;
	}

	public String getFsDescription() {
		return this.fsDescription;
	}

	public void setFsDescription(String fsDescription) {
		this.fsDescription = fsDescription;
	}

	public String getFsName() {
		return this.fsName;
	}

	public void setFsName(String fsName) {
		this.fsName = fsName;
	}

	public String getFsStatus() {
		return this.fsStatus;
	}

	public void setFsStatus(String fsStatus) {
		this.fsStatus = fsStatus;
	}

	public List<OtActiOrderCoupon> getOtActiOrderCoupons() {
		return this.otActiOrderCoupons;
	}

	public void setOtActiOrderCoupons(List<OtActiOrderCoupon> otActiOrderCoupons) {
		this.otActiOrderCoupons = otActiOrderCoupons;
	}

	public OtActiOrderCoupon addOtActiOrderCoupon(OtActiOrderCoupon otActiOrderCoupon) {
		getOtActiOrderCoupons().add(otActiOrderCoupon);
		otActiOrderCoupon.setOtCouponPart(this);

		return otActiOrderCoupon;
	}

	public OtActiOrderCoupon removeOtActiOrderCoupon(OtActiOrderCoupon otActiOrderCoupon) {
		getOtActiOrderCoupons().remove(otActiOrderCoupon);
		otActiOrderCoupon.setOtCouponPart(null);

		return otActiOrderCoupon;
	}

	public OtCouponGather getOtCouponGather() {
		return this.otCouponGather;
	}

	public void setOtCouponGather(OtCouponGather otCouponGather) {
		this.otCouponGather = otCouponGather;
	}

	public List<OtOwnerCoupon> getOtOwnerCoupons() {
		return this.otOwnerCoupons;
	}

	public void setOtOwnerCoupons(List<OtOwnerCoupon> otOwnerCoupons) {
		this.otOwnerCoupons = otOwnerCoupons;
	}

	public OtOwnerCoupon addOtOwnerCoupon(OtOwnerCoupon otOwnerCoupon) {
		getOtOwnerCoupons().add(otOwnerCoupon);
		otOwnerCoupon.setOtCouponPart(this);

		return otOwnerCoupon;
	}

	public OtOwnerCoupon removeOtOwnerCoupon(OtOwnerCoupon otOwnerCoupon) {
		getOtOwnerCoupons().remove(otOwnerCoupon);
		otOwnerCoupon.setOtCouponPart(null);

		return otOwnerCoupon;
	}

}