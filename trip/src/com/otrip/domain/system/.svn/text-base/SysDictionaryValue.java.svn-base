package com.otrip.domain.system;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the sys_dictionary_value database table.
 * 
 */
@Entity
@Table(name="sys_dictionary_value")
@NamedQuery(name="SysDictionaryValue.findAll", query="SELECT s FROM SysDictionaryValue s")
public class SysDictionaryValue extends com.otrip.domain.Entity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="fs_id")
	private String fsId;

	@Lob
	@Column(name="fb_image")
	private byte[] fbImage;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fd_create_time")
	private Date fdCreateTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fd_update_time")
	private Date fdUpdateTime;

	@Column(name="fn_sort")
	private int fnSort;

	@Column(name="fs_name")
	private String fsName;

	@Column(name="fs_parent_id")
	private String fsParentId;

	@Column(name="fs_value")
	private String fsValue;

	//bi-directional many-to-one association to SysDictionaryType
	@ManyToOne
	@JoinColumn(name="fs_dictionary_type")
	private SysDictionaryType sysDictionaryType;

	public SysDictionaryValue() {
	}

	public String getFsId() {
		return this.fsId;
	}

	public void setFsId(String fsId) {
		this.fsId = fsId;
	}

	public byte[] getFbImage() {
		return this.fbImage;
	}

	public void setFbImage(byte[] fbImage) {
		this.fbImage = fbImage;
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

	public int getFnSort() {
		return this.fnSort;
	}

	public void setFnSort(int fnSort) {
		this.fnSort = fnSort;
	}

	public String getFsName() {
		return this.fsName;
	}

	public void setFsName(String fsName) {
		this.fsName = fsName;
	}

	public String getFsParentId() {
		return this.fsParentId;
	}

	public void setFsParentId(String fsParentId) {
		this.fsParentId = fsParentId;
	}

	public String getFsValue() {
		return this.fsValue;
	}

	public void setFsValue(String fsValue) {
		this.fsValue = fsValue;
	}

	public SysDictionaryType getSysDictionaryType() {
		return this.sysDictionaryType;
	}

	public void setSysDictionaryType(SysDictionaryType sysDictionaryType) {
		this.sysDictionaryType = sysDictionaryType;
	}

}