package com.otrip.domain.order;

import java.io.Serializable;

import javax.persistence.*;

import com.otrip.domain.system.SysUser;

import java.util.Date;


/**
 * The persistent class for the ot_owner_coupon database table.
 * 
 */
@Entity
@Table(name="ot_owner_coupon")
@NamedQuery(name="OtOwnerCoupon.findAll", query="SELECT o FROM OtOwnerCoupon o")
public class OtOwnerCoupon extends com.otrip.domain.Entity implements Serializable {
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

	@Lob
	@Column(name="fn_number")
	private String fnNumber;

	@Column(name="fs_status")
	private String fsStatus;

	//bi-directional many-to-one association to SysUser
	@ManyToOne
	@JoinColumn(name="fs_user_id")
	private SysUser sysUser;

	//bi-directional many-to-one association to OtCouponPart
	@ManyToOne
	@JoinColumn(name="fs_coupon_id")
	private OtCouponPart otCouponPart;

	public OtOwnerCoupon() {
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

	public String getFnNumber() {
		return this.fnNumber;
	}

	public void setFnNumber(String fnNumber) {
		this.fnNumber = fnNumber;
	}

	public String getFsStatus() {
		return this.fsStatus;
	}

	public void setFsStatus(String fsStatus) {
		this.fsStatus = fsStatus;
	}

	public SysUser getSysUser() {
		return this.sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public OtCouponPart getOtCouponPart() {
		return this.otCouponPart;
	}

	public void setOtCouponPart(OtCouponPart otCouponPart) {
		this.otCouponPart = otCouponPart;
	}

}