package com.otrip.domain.trip;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.LazyToOne;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * The persistent class for the ot_acti_day database table.
 * 
 */
@Entity
@Table(name="ot_acti_day")
@NamedQuery(name="OtActiDay.findAll", query="SELECT o FROM OtActiDay o")
public class OtActiDay extends com.otrip.domain.Entity implements Serializable {
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

	@Column(name="fn_days")
	private int fnDays;

	@Column(name="fs_description")
	private String fsDescription;

	@Column(name="fs_latitude")
	private String fsLatitude;

	@Column(name="fs_longitude")
	private String fsLongitude;

	@Column(name="fs_name")
	private String fsName;

	@Column(name="fs_flag")
	private boolean fsFlag;
	//bi-directional many-to-one association to OtActiInfo
	@ManyToOne
	@JoinColumn(name="fs_acti_id")
	private OtActiInfo otActiInfo;

	public OtActiDay() {
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

	public int getFnDays() {
		return this.fnDays;
	}

	public void setFnDays(int fnDays) {
		this.fnDays = fnDays;
	}

	public String getFsDescription() {
		return this.fsDescription;
	}

	public void setFsDescription(String fsDescription) {
		this.fsDescription = fsDescription;
	}

	public String getFsLatitude() {
		return this.fsLatitude;
	}

	public void setFsLatitude(String fsLatitude) {
		this.fsLatitude = fsLatitude;
	}

	public String getFsLongitude() {
		return this.fsLongitude;
	}

	public void setFsLongitude(String fsLongitude) {
		this.fsLongitude = fsLongitude;
	}

	public String getFsName() {
		return this.fsName;
	}

	public void setFsName(String fsName) {
		this.fsName = fsName;
	}

	public OtActiInfo getOtActiInfo() {
		return this.otActiInfo;
	}

	public void setOtActiInfo(OtActiInfo otActiInfo) {
		this.otActiInfo = otActiInfo;
	}


	public String getFormateFdCreateTime()
	{
		return this.getFormateDate(this.fdCreateTime, "yyyy-MM-dd HH:mm:ss");
	}
	
	public String getFormateFdUpdateTime()
	{
		return this.getFormateDate(this.fdUpdateTime, "yyyy-MM-dd HH:mm:ss");
	}
	
	private String getFormateDate(Date date,String format)
	{
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		return sdf.format(date);
	}

	public boolean isFsFlag() {
		return fsFlag;
	}

	public void setFsFlag(boolean fsFlag) {
		this.fsFlag = fsFlag;
	}

	
	
}