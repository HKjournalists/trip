package com.otrip.domain.airport;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ot_order_passenger database table.
 * 
 */
@Entity
@Table(name="ot_order_passenger")
@NamedQuery(name="OtOrderPassenger.findAll", query="SELECT o FROM OtOrderPassenger o")
public class OtOrderPassenger extends com.otrip.domain.Entity implements Serializable {
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

	@Column(name="fs_credentials_no")
	private String fsCredentialsNo;

	@Column(name="fs_credentials_type")
	private String fsCredentialsType;

	@Column(name="fs_email")
	private String fsEmail;

	@Column(name="fs_name")
	private String fsName;

	@Column(name="fs_person_pinyin")
	private String fsPersonPinyin;

	@Column(name="fs_person_type")
	private String fsPersonType;

	@Column(name="fs_phone")
	private String fsPhone;

	//bi-directional many-to-one association to OtMeetAirportOrder
	@ManyToOne
	@JoinColumn(name="fs_order_id")
	private OtMeetAirportOrder otMeetAirportOrder;

	public OtOrderPassenger() {
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

	public String getFsCredentialsNo() {
		return this.fsCredentialsNo;
	}

	public void setFsCredentialsNo(String fsCredentialsNo) {
		this.fsCredentialsNo = fsCredentialsNo;
	}

	public String getFsCredentialsType() {
		return this.fsCredentialsType;
	}

	public void setFsCredentialsType(String fsCredentialsType) {
		this.fsCredentialsType = fsCredentialsType;
	}

	public String getFsEmail() {
		return this.fsEmail;
	}

	public void setFsEmail(String fsEmail) {
		this.fsEmail = fsEmail;
	}

	public String getFsName() {
		return this.fsName;
	}

	public void setFsName(String fsName) {
		this.fsName = fsName;
	}

	public String getFsPersonPinyin() {
		return this.fsPersonPinyin;
	}

	public void setFsPersonPinyin(String fsPersonPinyin) {
		this.fsPersonPinyin = fsPersonPinyin;
	}

	public String getFsPersonType() {
		return this.fsPersonType;
	}

	public void setFsPersonType(String fsPersonType) {
		this.fsPersonType = fsPersonType;
	}

	public String getFsPhone() {
		return this.fsPhone;
	}

	public void setFsPhone(String fsPhone) {
		this.fsPhone = fsPhone;
	}

	public OtMeetAirportOrder getOtMeetAirportOrder() {
		return this.otMeetAirportOrder;
	}

	public void setOtMeetAirportOrder(OtMeetAirportOrder otMeetAirportOrder) {
		this.otMeetAirportOrder = otMeetAirportOrder;
	}

}