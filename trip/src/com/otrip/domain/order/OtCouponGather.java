package com.otrip.domain.order;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ot_coupon_gather database table.
 * 
 */
@Entity
@Table(name="ot_coupon_gather")
@NamedQuery(name="OtCouponGather.findAll", query="SELECT o FROM OtCouponGather o")
public class OtCouponGather extends com.otrip.domain.Entity implements Serializable {
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
	@Column(name="fn_sheet_number")
	private String fnSheetNumber;

	@Column(name="fn_total_money")
	private BigDecimal fnTotalMoney;

	@Column(name="fs_type")
	private String fsType;

	//bi-directional many-to-one association to OtCouponPart
	@OneToMany(mappedBy="otCouponGather")
	private List<OtCouponPart> otCouponParts;

	public OtCouponGather() {
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

	public String getFnSheetNumber() {
		return this.fnSheetNumber;
	}

	public void setFnSheetNumber(String fnSheetNumber) {
		this.fnSheetNumber = fnSheetNumber;
	}

	public BigDecimal getFnTotalMoney() {
		return this.fnTotalMoney;
	}

	public void setFnTotalMoney(BigDecimal fnTotalMoney) {
		this.fnTotalMoney = fnTotalMoney;
	}

	public String getFsType() {
		return this.fsType;
	}

	public void setFsType(String fsType) {
		this.fsType = fsType;
	}

	public List<OtCouponPart> getOtCouponParts() {
		return this.otCouponParts;
	}

	public void setOtCouponParts(List<OtCouponPart> otCouponParts) {
		this.otCouponParts = otCouponParts;
	}

	public OtCouponPart addOtCouponPart(OtCouponPart otCouponPart) {
		getOtCouponParts().add(otCouponPart);
		otCouponPart.setOtCouponGather(this);

		return otCouponPart;
	}

	public OtCouponPart removeOtCouponPart(OtCouponPart otCouponPart) {
		getOtCouponParts().remove(otCouponPart);
		otCouponPart.setOtCouponGather(null);

		return otCouponPart;
	}

}