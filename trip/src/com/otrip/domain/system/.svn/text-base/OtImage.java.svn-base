package com.otrip.domain.system;

import java.io.Serializable;

import javax.persistence.*;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * The persistent class for the ot_image database table.
 * 
 */
@Entity
@Table(name="ot_image")
@NamedQuery(name="OtImage.findAll", query="SELECT o FROM OtImage o")
public class OtImage extends com.otrip.domain.Entity implements Serializable {
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

	@Column(name="fs_content_type")
	private String fsContentType;

	@Column(name="fs_name")
	private String fsName;

	@Column(name="fs_obj_id")
	private String fsObjId;

	@Column(name="fs_obj_sign")
	private String fsObjSign;

	@Column(name="fs_obj_tab_name")
	private String fsObjTabName;

	@Lob
	@Column(name="fs_path")
	private String fsPath;
	
	@Column(name="fs_url")
	private String fsUrl;
	
	public OtImage() {
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

	public String getFsContentType() {
		return this.fsContentType;
	}

	public void setFsContentType(String fsContentType) {
		this.fsContentType = fsContentType;
	}

	public String getFsName() {
		return this.fsName;
	}

	public void setFsName(String fsName) {
		this.fsName = fsName;
	}

	public String getFsObjId() {
		return this.fsObjId;
	}

	public void setFsObjId(String fsObjId) {
		this.fsObjId = fsObjId;
	}

	public String getFsObjSign() {
		return this.fsObjSign;
	}

	public void setFsObjSign(String fsObjSign) {
		this.fsObjSign = fsObjSign;
	}

	public String getFsObjTabName() {
		return this.fsObjTabName;
	}

	public void setFsObjTabName(String fsObjTabName) {
		this.fsObjTabName = fsObjTabName;
	}

	public String getFsPath() {
		return this.fsPath;
	}

	public void setFsPath(String fsPath) {
		this.fsPath = fsPath;
	}

	public String getFsUrl() {
		return fsUrl;
	}

	public void setFsUrl(String fsUrl) {
		this.fsUrl = fsUrl;
	}
	
	public String getFormateFdCreateTime()
	{
		return this.getFormateDate(this.fdCreateTime, "yyyy-MM-dd HH:mm:ss");
	}
	
	private String getFormateDate(Date date,String format)
	{
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		return sdf.format(date);
	}
	
}