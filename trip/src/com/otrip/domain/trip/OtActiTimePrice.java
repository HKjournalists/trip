package com.otrip.domain.trip;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ot_acti_time_price database table.
 * 
 */
@Entity
@Table(name="ot_acti_time_price")
@NamedQuery(name="OtActiTimePrice.findAll", query="SELECT o FROM OtActiTimePrice o")
public class OtActiTimePrice extends com.otrip.domain.Entity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="fs_id")
	private String fsId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fd_create_time")
	private Date fdCreateTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fd_end_time")
	private Date fdEndTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fd_start_time")
	private Date fdStartTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fd_update_time")
	private Date fdUpdateTime;

	@Column(name="fn_deposit_rate")
	private BigDecimal fnDepositRate;

	@Column(name="fn_original_price")
	private BigDecimal fnOriginalPrice;

	@Column(name="fn_special_price")
	private BigDecimal fnSpecialPrice;

	@Column(name="fs_flag")
	private boolean fsFlag;
	
	
	//bi-directional many-to-one association to OtActiInfo
	@OneToMany(mappedBy="otActiTimePrice")
	private List<OtActiInfo> otActiInfos;

	//bi-directional many-to-one association to OtActiInfo
	@ManyToOne
	@JoinColumn(name="fs_acti_id")
	private OtActiInfo otActiInfo;

	public OtActiTimePrice() {
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

	public Date getFdEndTime() {
		return this.fdEndTime;
	}

	public void setFdEndTime(Date fdEndTime) {
		this.fdEndTime = fdEndTime;
	}

	public Date getFdStartTime() {
		return this.fdStartTime;
	}

	public void setFdStartTime(Date fdStartTime) {
		this.fdStartTime = fdStartTime;
	}

	public Date getFdUpdateTime() {
		return this.fdUpdateTime;
	}

	public void setFdUpdateTime(Date fdUpdateTime) {
		this.fdUpdateTime = fdUpdateTime;
	}

	public BigDecimal getFnDepositRate() {
		return this.fnDepositRate;
	}

	public void setFnDepositRate(BigDecimal fnDepositRate) {
		this.fnDepositRate = fnDepositRate;
	}

	public BigDecimal getFnOriginalPrice() {
		return this.fnOriginalPrice;
	}

	public void setFnOriginalPrice(BigDecimal fnOriginalPrice) {
		this.fnOriginalPrice = fnOriginalPrice;
	}

	public BigDecimal getFnSpecialPrice() {
		return this.fnSpecialPrice;
	}

	public void setFnSpecialPrice(BigDecimal fnSpecialPrice) {
		this.fnSpecialPrice = fnSpecialPrice;
	}

	public List<OtActiInfo> getOtActiInfos() {
		return this.otActiInfos;
	}

	public void setOtActiInfos(List<OtActiInfo> otActiInfos) {
		this.otActiInfos = otActiInfos;
	}

	public OtActiInfo addOtActiInfo(OtActiInfo otActiInfo) {
		getOtActiInfos().add(otActiInfo);
		otActiInfo.setOtActiTimePrice(this);

		return otActiInfo;
	}

	public OtActiInfo removeOtActiInfo(OtActiInfo otActiInfo) {
		getOtActiInfos().remove(otActiInfo);
		otActiInfo.setOtActiTimePrice(null);

		return otActiInfo;
	}

	public OtActiInfo getOtActiInfo() {
		return this.otActiInfo;
	}

	public void setOtActiInfo(OtActiInfo otActiInfo) {
		this.otActiInfo = otActiInfo;
	}

	public boolean isFsFlag() {
		return fsFlag;
	}

	public void setFsFlag(boolean fsFlag) {
		this.fsFlag = fsFlag;
	}

	public String getFormatUpdateTime()
	{
		return this.getFormateDate(this.fdUpdateTime, "yyyy-MM-dd HH:mm:ss");
	}
	
	public String getFormatEndTime()
	{
		return this.getFormateDate(this.fdEndTime, "yyyy-MM-dd HH:mm:ss");
	}
	
	public String getFormatStartTime()
	{
		return this.getFormateDate(this.fdStartTime, "yyyy-MM-dd HH:mm:ss");
	}
	
	
	
	private String getFormateDate(Date date,String format)
	{
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		
		return sdf.format(date);
	}
}