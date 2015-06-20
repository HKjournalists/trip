package com.otrip.domain.trip;

import java.io.Serializable;

import javax.persistence.*;

import com.otrip.domain.order.OtCouponPart;
import com.otrip.domain.system.SysUser;

import java.util.Date;


/**
 * The persistent class for the ot_acti_order_coupon database table.
 * 
 */
@Entity
@Table(name="ot_acti_order_coupon")
@NamedQuery(name="OtActiOrderCoupon.findAll", query="SELECT o FROM OtActiOrderCoupon o")
public class OtActiOrderCoupon extends com.otrip.domain.Entity implements Serializable {
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

	//bi-directional many-to-one association to OtActiOrder
	@ManyToOne
	@JoinColumn(name="fs_order_id")
	private OtActiOrder otActiOrder;

	//bi-directional many-to-one association to OtCouponPart
	@ManyToOne
	@JoinColumn(name="fs_coupon_id")
	private OtCouponPart otCouponPart;

	//bi-directional many-to-one association to SysUser
	@ManyToOne
	@JoinColumn(name="fs_user_id")
	private SysUser sysUser;

	public OtActiOrderCoupon() {
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

	public OtActiOrder getOtActiOrder() {
		return this.otActiOrder;
	}

	public void setOtActiOrder(OtActiOrder otActiOrder) {
		this.otActiOrder = otActiOrder;
	}

	public OtCouponPart getOtCouponPart() {
		return this.otCouponPart;
	}

	public void setOtCouponPart(OtCouponPart otCouponPart) {
		this.otCouponPart = otCouponPart;
	}

	public SysUser getSysUser() {
		return this.sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

}