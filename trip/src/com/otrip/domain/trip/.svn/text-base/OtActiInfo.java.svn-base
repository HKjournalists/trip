package com.otrip.domain.trip;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ot_acti_info database table.
 * 
 */
@Entity
@Table(name="ot_acti_info")
@NamedQuery(name="OtActiInfo.findAll", query="SELECT o FROM OtActiInfo o")
public class OtActiInfo extends com.otrip.domain.Entity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="fs_id")
	private String fsId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fd_create_time")
	private Date fdCreateTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fd_under_time")
	private Date fdUnderTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fd_update_time")
	private Date fdUpdateTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fd_upper_time")
	private Date fdUpperTime;

	@Column(name="fn_day")
	private int fnDay;

	@Lob
	@Column(name="fn_discuss_num")
	private String fnDiscussNum;

	@Lob
	@Column(name="fn_favorite_num")
	private String fnFavoriteNum;

	@Lob
	@Column(name="fn_praise_num")
	private String fnPraiseNum;

	@Column(name="fn_trip_distance")
	private BigDecimal fnTripDistance;

	@Column(name="fs_cost_notes")
	private String fsCostNotes;

	@Column(name="fs_create_user_id")
	private String fsCreateUserId;

	@Column(name="fs_equip_list")
	private String fsEquipList;

	@Column(name="fs_holiday")
	private String fsHoliday;

	@Column(name="fs_line_road")
	private String fsLineRoad;

	@Column(name="fs_no")
	private String fsNo;

	@Column(name="fs_physical_strength")
	private String fsPhysicalStrength;

	@Column(name="fs_refund_notes")
	private String fsRefundNotes;

	@Column(name="fs_season")
	private String fsSeason;

	@Column(name="fs_title")
	private String fsTitle;

	@Column(name="fs_update_user_id")
	private String fsUpdateUserId;
	
	@Column(name="fs_acti_flag")
	private boolean fsActiFlag;
	
	@Column(name="fs_prompt")
	private String fsPrompt;
	
	

	//bi-directional many-to-one association to OtActiClickPraise
	@OneToMany(mappedBy="otActiInfo")
	private List<OtActiClickPraise> otActiClickPraises;

	//bi-directional many-to-one association to OtActiDay
	@OneToMany(mappedBy="otActiInfo")
	private List<OtActiDay> otActiDays;

	//bi-directional many-to-one association to OtActiDiscuss
	@OneToMany(mappedBy="otActiInfo")
	private List<OtActiDiscuss> otActiDiscusses;

	//bi-directional many-to-one association to OtActiFavorite
	@OneToMany(mappedBy="otActiInfo")
	private List<OtActiFavorite> otActiFavorites;
	
	
	

	//bi-directional many-to-one association to OtActiDestination
	@ManyToOne
	@JoinColumn(name="fs_destination_city")
	private OtActiDestination fsDestinationCity;

	//bi-directional many-to-one association to OtActiDestination
	@ManyToOne
	@JoinColumn(name="fs_destination_scenic")
	private OtActiDestination fsDestinationScenic;

	//bi-directional many-to-one association to OtActiDestination
	@ManyToOne
	@JoinColumn(name="fs_destination_country")
	private OtActiDestination fsDestinationCountry;

	//bi-directional many-to-one association to OtActiDestination
	@ManyToOne
	@JoinColumn(name="fs_destination_province")
	private OtActiDestination fsDestinationProvince;

	//bi-directional many-to-one association to OtActiType
	@ManyToOne
	@JoinColumn(name="fs_outdoors_type")
	private OtActiType otActiType;

	//bi-directional many-to-one association to OtActiTimePrice
	@ManyToOne
	@JoinColumn(name="fs_acti_time_price_id")
	private OtActiTimePrice otActiTimePrice;

	//bi-directional many-to-one association to OtActiDestinationType
	@ManyToOne
	@JoinColumn(name="fs_destination_type")
	private OtActiDestinationType otActiDestinationType;

	//bi-directional many-to-one association to OtActiDestination
	@ManyToOne
	@JoinColumn(name="fs_destination_continent")
	private OtActiDestination fsDestinationContinent;

	//bi-directional many-to-one association to OtActiOrder
	@OneToMany(mappedBy="otActiInfo")
	private List<OtActiOrder> otActiOrders;

	//bi-directional many-to-one association to OtActiProblemDiscuss
	@OneToMany(mappedBy="otActiInfo")
	private List<OtActiProblemDiscuss> otActiProblemDiscusses;

	//bi-directional many-to-one association to OtActiTimePrice
	@OneToMany(mappedBy="otActiInfo")
	private List<OtActiTimePrice> otActiTimePrices;

	public OtActiInfo() {
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

	public Date getFdUnderTime() {
		return this.fdUnderTime;
	}

	public void setFdUnderTime(Date fdUnderTime) {
		this.fdUnderTime = fdUnderTime;
	}

	public Date getFdUpdateTime() {
		return this.fdUpdateTime;
	}

	public void setFdUpdateTime(Date fdUpdateTime) {
		this.fdUpdateTime = fdUpdateTime;
	}

	public Date getFdUpperTime() {
		return this.fdUpperTime;
	}

	public void setFdUpperTime(Date fdUpperTime) {
		this.fdUpperTime = fdUpperTime;
	}

	public int getFnDay() {
		return this.fnDay;
	}

	public void setFnDay(int fnDay) {
		this.fnDay = fnDay;
	}

	public String getFnDiscussNum() {
		return this.fnDiscussNum;
	}

	public void setFnDiscussNum(String fnDiscussNum) {
		this.fnDiscussNum = fnDiscussNum;
	}

	public String getFnFavoriteNum() {
		return this.fnFavoriteNum;
	}

	public void setFnFavoriteNum(String fnFavoriteNum) {
		this.fnFavoriteNum = fnFavoriteNum;
	}

	public String getFnPraiseNum() {
		return this.fnPraiseNum;
	}

	public void setFnPraiseNum(String fnPraiseNum) {
		this.fnPraiseNum = fnPraiseNum;
	}

	public BigDecimal getFnTripDistance() {
		return this.fnTripDistance;
	}

	public void setFnTripDistance(BigDecimal fnTripDistance) {
		this.fnTripDistance = fnTripDistance;
	}

	public String getFsCostNotes() {
		return this.fsCostNotes;
	}

	public void setFsCostNotes(String fsCostNotes) {
		this.fsCostNotes = fsCostNotes;
	}

	public String getFsCreateUserId() {
		return this.fsCreateUserId;
	}

	public void setFsCreateUserId(String fsCreateUserId) {
		this.fsCreateUserId = fsCreateUserId;
	}

	public String getFsEquipList() {
		return this.fsEquipList;
	}

	public void setFsEquipList(String fsEquipList) {
		this.fsEquipList = fsEquipList;
	}

	public String getFsHoliday() {
		return this.fsHoliday;
	}

	public void setFsHoliday(String fsHoliday) {
		this.fsHoliday = fsHoliday;
	}

	public String getFsLineRoad() {
		return this.fsLineRoad;
	}

	public void setFsLineRoad(String fsLineRoad) {
		this.fsLineRoad = fsLineRoad;
	}

	public String getFsNo() {
		return this.fsNo;
	}

	public void setFsNo(String fsNo) {
		this.fsNo = fsNo;
	}

	public String getFsPhysicalStrength() {
		return this.fsPhysicalStrength;
	}

	public void setFsPhysicalStrength(String fsPhysicalStrength) {
		this.fsPhysicalStrength = fsPhysicalStrength;
	}

	public String getFsRefundNotes() {
		return this.fsRefundNotes;
	}

	public void setFsRefundNotes(String fsRefundNotes) {
		this.fsRefundNotes = fsRefundNotes;
	}

	public String getFsSeason() {
		return this.fsSeason;
	}

	public void setFsSeason(String fsSeason) {
		this.fsSeason = fsSeason;
	}

	public String getFsTitle() {
		return this.fsTitle;
	}

	public void setFsTitle(String fsTitle) {
		this.fsTitle = fsTitle;
	}

	public String getFsUpdateUserId() {
		return this.fsUpdateUserId;
	}

	public void setFsUpdateUserId(String fsUpdateUserId) {
		this.fsUpdateUserId = fsUpdateUserId;
	}

	public List<OtActiClickPraise> getOtActiClickPraises() {
		return this.otActiClickPraises;
	}

	public void setOtActiClickPraises(List<OtActiClickPraise> otActiClickPraises) {
		this.otActiClickPraises = otActiClickPraises;
	}

	public OtActiClickPraise addOtActiClickPrais(OtActiClickPraise otActiClickPrais) {
		getOtActiClickPraises().add(otActiClickPrais);
		otActiClickPrais.setOtActiInfo(this);

		return otActiClickPrais;
	}

	public OtActiClickPraise removeOtActiClickPrais(OtActiClickPraise otActiClickPrais) {
		getOtActiClickPraises().remove(otActiClickPrais);
		otActiClickPrais.setOtActiInfo(null);

		return otActiClickPrais;
	}

	public List<OtActiDay> getOtActiDays() {
		return this.otActiDays;
	}

	public void setOtActiDays(List<OtActiDay> otActiDays) {
		this.otActiDays = otActiDays;
	}

	public OtActiDay addOtActiDay(OtActiDay otActiDay) {
		getOtActiDays().add(otActiDay);
		otActiDay.setOtActiInfo(this);

		return otActiDay;
	}

	public OtActiDay removeOtActiDay(OtActiDay otActiDay) {
		getOtActiDays().remove(otActiDay);
		otActiDay.setOtActiInfo(null);

		return otActiDay;
	}

	public List<OtActiDiscuss> getOtActiDiscusses() {
		return this.otActiDiscusses;
	}

	public void setOtActiDiscusses(List<OtActiDiscuss> otActiDiscusses) {
		this.otActiDiscusses = otActiDiscusses;
	}

	public OtActiDiscuss addOtActiDiscuss(OtActiDiscuss otActiDiscuss) {
		getOtActiDiscusses().add(otActiDiscuss);
		otActiDiscuss.setOtActiInfo(this);

		return otActiDiscuss;
	}

	public OtActiDiscuss removeOtActiDiscuss(OtActiDiscuss otActiDiscuss) {
		getOtActiDiscusses().remove(otActiDiscuss);
		otActiDiscuss.setOtActiInfo(null);

		return otActiDiscuss;
	}

	public List<OtActiFavorite> getOtActiFavorites() {
		return this.otActiFavorites;
	}

	public void setOtActiFavorites(List<OtActiFavorite> otActiFavorites) {
		this.otActiFavorites = otActiFavorites;
	}

	public OtActiFavorite addOtActiFavorite(OtActiFavorite otActiFavorite) {
		getOtActiFavorites().add(otActiFavorite);
		otActiFavorite.setOtActiInfo(this);

		return otActiFavorite;
	}

	public OtActiFavorite removeOtActiFavorite(OtActiFavorite otActiFavorite) {
		getOtActiFavorites().remove(otActiFavorite);
		otActiFavorite.setOtActiInfo(null);

		return otActiFavorite;
	}

	public OtActiDestination getFsDestinationCity() {
		return fsDestinationCity;
	}

	public void setFsDestinationCity(OtActiDestination fsDestinationCity) {
		this.fsDestinationCity = fsDestinationCity;
	}

	public OtActiDestination getFsDestinationScenic() {
		return fsDestinationScenic;
	}

	public void setFsDestinationScenic(OtActiDestination fsDestinationScenic) {
		this.fsDestinationScenic = fsDestinationScenic;
	}

	public OtActiDestination getFsDestinationCountry() {
		return fsDestinationCountry;
	}

	public void setFsDestinationCountry(OtActiDestination fsDestinationCountry) {
		this.fsDestinationCountry = fsDestinationCountry;
	}

	public OtActiDestination getFsDestinationProvince() {
		return fsDestinationProvince;
	}

	public void setFsDestinationProvince(OtActiDestination fsDestinationProvince) {
		this.fsDestinationProvince = fsDestinationProvince;
	}

	public OtActiType getOtActiType() {
		return this.otActiType;
	}

	public void setOtActiType(OtActiType otActiType) {
		this.otActiType = otActiType;
	}

	public OtActiTimePrice getOtActiTimePrice() {
		return this.otActiTimePrice;
	}

	public void setOtActiTimePrice(OtActiTimePrice otActiTimePrice) {
		this.otActiTimePrice = otActiTimePrice;
	}

	public OtActiDestinationType getOtActiDestinationType() {
		return this.otActiDestinationType;
	}

	public void setOtActiDestinationType(OtActiDestinationType otActiDestinationType) {
		this.otActiDestinationType = otActiDestinationType;
	}

	public OtActiDestination getFsDestinationContinent() {
		return fsDestinationContinent;
	}

	public void setFsDestinationContinent(OtActiDestination fsDestinationContinent) {
		this.fsDestinationContinent = fsDestinationContinent;
	}

	public List<OtActiOrder> getOtActiOrders() {
		return this.otActiOrders;
	}

	public void setOtActiOrders(List<OtActiOrder> otActiOrders) {
		this.otActiOrders = otActiOrders;
	}

	public OtActiOrder addOtActiOrder(OtActiOrder otActiOrder) {
		getOtActiOrders().add(otActiOrder);
		otActiOrder.setOtActiInfo(this);

		return otActiOrder;
	}

	public OtActiOrder removeOtActiOrder(OtActiOrder otActiOrder) {
		getOtActiOrders().remove(otActiOrder);
		otActiOrder.setOtActiInfo(null);

		return otActiOrder;
	}

	public List<OtActiProblemDiscuss> getOtActiProblemDiscusses() {
		return this.otActiProblemDiscusses;
	}

	public void setOtActiProblemDiscusses(List<OtActiProblemDiscuss> otActiProblemDiscusses) {
		this.otActiProblemDiscusses = otActiProblemDiscusses;
	}

	public OtActiProblemDiscuss addOtActiProblemDiscuss(OtActiProblemDiscuss otActiProblemDiscuss) {
		getOtActiProblemDiscusses().add(otActiProblemDiscuss);
		otActiProblemDiscuss.setOtActiInfo(this);

		return otActiProblemDiscuss;
	}

	public OtActiProblemDiscuss removeOtActiProblemDiscuss(OtActiProblemDiscuss otActiProblemDiscuss) {
		getOtActiProblemDiscusses().remove(otActiProblemDiscuss);
		otActiProblemDiscuss.setOtActiInfo(null);

		return otActiProblemDiscuss;
	}

	public List<OtActiTimePrice> getOtActiTimePrices() {
		return this.otActiTimePrices;
	}

	public void setOtActiTimePrices(List<OtActiTimePrice> otActiTimePrices) {
		this.otActiTimePrices = otActiTimePrices;
	}

	public OtActiTimePrice addOtActiTimePrice(OtActiTimePrice otActiTimePrice) {
		getOtActiTimePrices().add(otActiTimePrice);
		otActiTimePrice.setOtActiInfo(this);

		return otActiTimePrice;
	}

	public OtActiTimePrice removeOtActiTimePrice(OtActiTimePrice otActiTimePrice) {
		getOtActiTimePrices().remove(otActiTimePrice);
		otActiTimePrice.setOtActiInfo(null);

		return otActiTimePrice;
	}

	
	public String getFormatFdUnderTime()
	{
		return this.getFormateDate(this.fdUnderTime, "yyyy-MM-dd HH:mm:ss");
	}
	
	public String getFormatFdUpperTime()
	{
		return this.getFormateDate(this.fdUpperTime, "yyyy-MM-dd HH:mm:ss");
	}
	
	private String getFormateDate(Date date,String format)
	{
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		
		return sdf.format(date);
	}

	public boolean isFsActiFlag() {
		return fsActiFlag;
	}

	public void setFsActiFlag(boolean fsActiFlag) {
		this.fsActiFlag = fsActiFlag;
	}
	
	public String getFsPrompt() {
		return fsPrompt;
	}

	public void setFsPrompt(String fsPrompt) {
		this.fsPrompt = fsPrompt;
	}
	
}