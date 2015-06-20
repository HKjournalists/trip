package com.otrip.domain.trip;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ot_acti_order_user_list database table.
 * 
 */
@Entity
@Table(name="ot_acti_order_user_list")
@NamedQuery(name="OtActiOrderUserList.findAll", query="SELECT o FROM OtActiOrderUserList o")
public class OtActiOrderUserList extends com.otrip.domain.Entity implements Serializable {
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

	@Column(name="fs_name_pinyin")
	private String fsNamePinyin;

	@Column(name="fs_travel_user_name")
	private String fsTravelUserName;

	@Column(name="fs_travel_user_phone")
	private String fsTravelUserPhone;

	//bi-directional many-to-one association to OtActiOrder
	@ManyToOne
	@JoinColumn(name="fs_acti_id")
	private OtActiOrder otActiOrder;

	public OtActiOrderUserList() {
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

	public String getFsNamePinyin() {
		return this.fsNamePinyin;
	}

	public void setFsNamePinyin(String fsNamePinyin) {
		this.fsNamePinyin = fsNamePinyin;
	}

	public String getFsTravelUserName() {
		return this.fsTravelUserName;
	}

	public void setFsTravelUserName(String fsTravelUserName) {
		this.fsTravelUserName = fsTravelUserName;
	}

	public String getFsTravelUserPhone() {
		return this.fsTravelUserPhone;
	}

	public void setFsTravelUserPhone(String fsTravelUserPhone) {
		this.fsTravelUserPhone = fsTravelUserPhone;
	}

	public OtActiOrder getOtActiOrder() {
		return this.otActiOrder;
	}

	public void setOtActiOrder(OtActiOrder otActiOrder) {
		this.otActiOrder = otActiOrder;
	}

}