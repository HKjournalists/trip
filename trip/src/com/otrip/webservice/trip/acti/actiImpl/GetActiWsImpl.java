package com.otrip.webservice.trip.acti.actiImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.jws.WebParam;
import javax.ws.rs.QueryParam;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otrip.dao.util.ConvertDataUtil;
import com.otrip.dao.ws.WsActiClickPraiseDao;
import com.otrip.dao.ws.WsDestinationDao;
import com.otrip.dao.ws.WsDiscussDao;
import com.otrip.dao.ws.WsFavoriteDao;
import com.otrip.dao.ws.WsProblemDao;
import com.otrip.domain.trip.OtActiDiscuss;
import com.otrip.domain.trip.OtActiInfo;
import com.otrip.domain.trip.OtActiProblemDiscuss;
import com.otrip.pojo.ws.ActiCountry;
import com.otrip.pojo.ws.ActiDays;
import com.otrip.pojo.ws.ActiDetailInfo;
import com.otrip.pojo.ws.ActiInfo;
import com.otrip.pojo.ws.ActiPosition;
import com.otrip.pojo.ws.ActiScenic;
import com.otrip.pojo.ws.ActiType;
import com.otrip.pojo.ws.CountryAndType;
import com.otrip.pojo.ws.Discuss;
import com.otrip.pojo.ws.MapCountry;
import com.otrip.pojo.ws.PraiseUsers;
import com.otrip.pojo.ws.Problems;
import com.otrip.webservice.BaseWsService;
import com.otrip.webservice.trip.acti.GetActiWs;
import com.otrip.webservice.util.ResultJsonUtil;

@Service("getActiWsImpl")
public class GetActiWsImpl extends BaseWsService implements GetActiWs {

	Logger log=Logger.getLogger(GetActiWsImpl.class);
	
	@Autowired
	private WsDestinationDao wsDesti;
	@Autowired
	private WsProblemDao wsPro;
	@Autowired
	private WsDiscussDao wsDis;
	@Autowired
	private WsActiClickPraiseDao praise;
	@Autowired
	private WsFavoriteDao fav; 
	
	
	public void setWsFavoriteDao(WsFavoriteDao fav)
	{
		this.fav=fav;
	}
	public void setWsDiscussDao(WsDiscussDao wsDis) {
		this.wsDis = wsDis;
	}

	public void setWsDestinationDao(WsDestinationDao wsDesti)
	{
		this.wsDesti=wsDesti;
	}
	
	public void setWsProblemDao(WsProblemDao wsPro)
	{
		this.wsPro=wsPro;
	}
	
	public void setWsActiClickPraiseDao(WsActiClickPraiseDao praise) {
		this.praise = praise;
	}

	/**
	 * 加载活动主页所需信息
	 * 若没有找到附近的城市信息则返回加载失败信息，若只找到附近的城市信息，每有找到热门活动信息，则返回城市信息。
	 */
	
	public String getIndexActi(String longitude, String latitude)
			throws Exception {
		
		double a=Double.valueOf(latitude);
		double b=Double.valueOf(latitude);
		List<?> cityList=null;
		List<ActiInfo> actiJsonList=new ArrayList<ActiInfo>();
		//获取活动城市的JSON数组
		cityList=wsDesti.findOtActiDestinationByPosition(113.324334, 30.270059, "城市");
		log.info("getIndexActi cityList:"+cityList.size());
		if(cityList!=null)
		{
			JSONArray cityJson=JSONArray.fromObject(cityList);
			String destionJSON=cityJson.toString();
			
			
			//获取活动信息的JSON数组
			List<?> actiList=wsDesti.findOtActiByPraiseNum();
			if(actiList!=null)
			{
				
				for(int i=0;i<actiList.size();i++)
				{
					Map actiMap=(Map) actiList.get(i);
					Map staMap=(Map)actiMap.get("static");
					Map dyaMap=(Map)actiMap.get("dynamic");
					log.info("find actiInfo num: "+actiList.size());
					if(staMap==null)
					{
						log.info("not find the actiInfo static info");
						continue;
					}
					ActiInfo actiInfo=new ActiInfo();
					actiInfo.setActiId((staMap.get("fs_id")+""));
					List imageList=wsDesti.findImageUrl((staMap.get("fs_id")+""));
					if(imageList==null)
					{
						actiInfo.setActiImage(null);
					}
					else
						actiInfo.setActiImage(imageList);
					actiInfo.setActiTitle((staMap.get("fs_title")+""));
					actiInfo.setActiType((staMap.get("actiType")+""));
					actiInfo.setDays(staMap.get("actiType")+"");
					actiInfo.setDiscussNum(staMap.get("fn_day")+"");
					actiInfo.setOrigPrice(staMap.get("fn_original_price")+"");
					actiInfo.setSpecialPrice(staMap.get("fn_special_price")+"");
					actiInfo.setTripDistance(staMap.get("fn_trip_distance")+"");
					if(dyaMap==null)
					{
						actiInfo.setPraiseNum("0");
						log.info(actiInfo.getActiId()+" the praiseNum is 0");
					}
					else
						actiInfo.setPraiseNum( dyaMap.get("praiseNum")+"");
					actiInfo.setPhysicalStrength(staMap.get("fs_physical_strength")+"");
					actiJsonList.add(actiInfo);
					log.info("find actiInfo id: "+staMap.get("fs_id")+"");
				}
				JSONArray actiInfoJson=JSONArray.fromObject(actiJsonList);
				String actiJson=actiInfoJson.toString();
				return ResultJsonUtil.returnJSON(new String[]{"destination","acti"},new String[]{destionJSON,actiJson}, "200", "null");
			}
			else
			{
				return ResultJsonUtil.returnJSON(new String[]{"destination"}, new String[]{destionJSON}, super.return_status_success, "只找到目的地城市");
			}
		}
		else
		{
			return ResultJsonUtil.returnErrorJson("404", "没找到活动", "false");
		}
	}

	//点击活动进入详情页
	@Override
	public String getActiInfo(String paramjson) {
		final JSONObject JsonObj=JSONObject.fromObject(paramjson);
		String actiId=JsonObj.getString("actiId");
		Map<String, Map> acti=wsDesti.getactiInfoByActiId(actiId);
		
		//获取活动信息
		if(acti!=null)
		{
			Map staticInfo=(Map)acti.get("static");
			Map dyMap=(Map)acti.get("dynamic");
				ActiDetailInfo returnActi=new ActiDetailInfo();
				String fsId=staticInfo.get("fs_id")+"";
				returnActi.setActiId(fsId);
				returnActi.setActiDesc(staticInfo.get("fs_line_road")+"");
				returnActi.setActiImg(wsDesti.findImageUrl(fsId));
				if(dyMap!=null)
				{
					returnActi.setActiLevel(dyMap.get("actiLevel")!=null?dyMap.get("actiLevel")+"":null);//获取活动评级
					returnActi.setActiNum(dyMap.get("praiseNum")!=null?dyMap.get("praiseNum")+"":null);
					returnActi.setDissNum(dyMap.get("disNum")!=null?dyMap.get("disNum")+"":null);//活动评论数
				}
				returnActi.setActiPrice(staticInfo.get("fn_special_price")+"");
				returnActi.setActiTitle(staticInfo.get("fs_title")+"");
				returnActi.setActiType(staticInfo.get("actiType")+"");
				returnActi.setCostNotes(staticInfo.get("fs_cost_notes")+"");
				returnActi.setCountry(staticInfo.get("country")+"");
				returnActi.setDays(String.valueOf(staticInfo.get("fn_day")));
				returnActi.setDistance(staticInfo.get("fn_trip_distance")+"");
				returnActi.setEquips(staticInfo.get("fs_equip_list")+"");
				returnActi.setPhysicalStrength(staticInfo.get("fs_physical_strength")+"");
				returnActi.setRefundNotes(staticInfo.get("fs_refund_notes")+"");
				
				List scenList=wsDesti.getActiScenicByActiId(actiId);
				List praiseList=wsDesti.getPraiseUsers(actiId);
				List dayList=wsDesti.getActiDays(actiId);
				if(scenList==null)
				{
					log.info("getActiInfo dayList is null");
					returnActi.setScenic(null);
				}
				else
				{
					//装入景点经纬度信息
					List actiScen =new ArrayList();
					for(int i=0;i<scenList.size();i++)
					{
						Map secnMap=(Map)scenList.get(i);
						ActiScenic scen=new ActiScenic();
						scen.setLatitude(secnMap.get("latitude")+"");
						scen.setLongitude(secnMap.get("longitude")+"");
						actiScen.add(scen);
					}
					returnActi.setScenic(actiScen);
				}
				if(praiseList==null)
				{
					log.info("getActiInfo dayList is null");
					returnActi.setPraUser(null);
				}
				else
				{
					//装入点赞用户信息
					List userList=new ArrayList();
					for(int i=0;i<praiseList.size();i++)
					{
						Map userMap=(Map)praiseList.get(i);
						PraiseUsers pu=new PraiseUsers();
						pu.setUserId(userMap.get("userId")+"");
						pu.setUserName(userMap.get("fs_name")+"");
						List imList=wsDesti.findImageUrl(actiId);
						
						if(imList==null)
						{
							log.info("find praiseUser image: 0");
							pu.setUserImg(null);
						}
						else
							pu.setUserImg(imList.get(0)+"");
						userList.add(pu);
					}
					returnActi.setPraUser(userList);
				}
				if(dayList==null)
				{
					log.info("getActiInfo dayList is null");
					returnActi.setActiDay(null);
				}
				else
				{
					//装入活动日程信息
					List dList=new ArrayList();
					for(int i=0;i<dList.size();i++)
					{
						Map dMap=(Map)dList.get(i);
						ActiDays ad=new ActiDays();
						ad.setSecnicName(dMap.get("fs_name ")+"");
						ad.setSecnicDesc(dMap.get("fs_description")+"");
						ad.setDays(dMap.get("fn_days")+"");
						List imList=wsDesti.findImageUrl(actiId);
						log.info("find actiDays image: "+imList.size());
						if(imList==null)
							ad.setSecnicImg(null);
						else
							ad.setSecnicImg(imList);
					}
				}
				JSONObject actiJson=JSONObject.fromObject(returnActi);
				String json=actiJson.toString();
				return ResultJsonUtil.returnJSON(new String[]{super.return_actiInfo},new String[]{json}, super.return_status_success, "null");
			
		}
		
		return ResultJsonUtil.returnErrorJson(super.return_status_fail, "没找到活动详情", "false");
	}

	@Override
	public String getActiBydesti(String paramjson) {
		// 
		final JSONObject jsonObj=JSONObject.fromObject(paramjson);
		final String desctiId=jsonObj.getString("desctiId");
		List actiList=wsDesti.findOtActisByCity(desctiId);
		if(actiList!=null)
		{
			List<ActiInfo> actiJsonList=new ArrayList<ActiInfo>();
			for(int i=0;i<actiList.size();i++)
			{
				ActiInfo actiInfo=new ActiInfo();
				OtActiInfo ac=(OtActiInfo)actiList.get(i);
				actiInfo.setActiId(ac.getFsId());
				actiInfo.setActiImage(wsDesti.findImageUrl(ac.getFsId()));
				actiInfo.setActiTitle(ac.getFsTitle());
				actiInfo.setActiType(ac.getOtActiType().getFsName());
				actiInfo.setDays(String.valueOf(ac.getFnDay()));
				actiInfo.setDiscussNum(ac.getFnDiscussNum());
				actiInfo.setOrigPrice(ac.getOtActiTimePrice().getFnOriginalPrice().toString());
				actiInfo.setSpecialPrice(ac.getOtActiTimePrice().getFnSpecialPrice().toString());
				actiInfo.setTripDistance(ac.getFnTripDistance().toString());
				actiInfo.setPraiseNum(ac.getFnPraiseNum());
				actiInfo.setPhysicalStrength(ac.getFsPhysicalStrength());
				actiJsonList.add(actiInfo);
			}
			JSONArray actiInfoJson=JSONArray.fromObject(actiJsonList);
			String actiJson=actiInfoJson.toString();
			return ResultJsonUtil.returnJSON(new String[]{"acti"},new String[]{actiJson}, "200", "null");
		}
		else
			return ResultJsonUtil.returnErrorJson("404", "没找到活动", "false");
	
	}

	@Override
	public String getPriceBydate(String actiId, String month) {
		// TODO Auto-generated method stub
		return null;
	}


	public String getDiscusses(String actiId, String page, String num) {
		List disList=wsDis.getActiDiscusses(actiId, page, num);
		List disJsonList=new ArrayList();
		if(disList!=null)
		{
			for(int i=0;i<disList.size();i++)
			{
				OtActiDiscuss dis=(OtActiDiscuss)disList.get(i);
				Discuss discuss=new Discuss();
				discuss.setDissContent(dis.getFsContent());
				discuss.setDissDate(ConvertDataUtil.formatDate(dis.getFdTime()));
				discuss.setLevel(String.valueOf(dis.getFsGradeLevel()));
				discuss.setUserId(dis.getSysUser().getFsId());
				discuss.setUserName(dis.getSysUser().getFsName());
				disJsonList.add(discuss);
			}
			JSONArray disJson=JSONArray.fromObject(disJsonList);
			String json=disJson.toString();
			return ResultJsonUtil.returnJSON(new String[]{"acti"},new String[]{json}, "200", "null");
		}
		return ResultJsonUtil.returnErrorJson("404", "没找到评论", "false");
	}


	public String addDiscuss(String loginUesrId, String actiId, String level,String context) {
		if(wsDis.addDiscuss(loginUesrId, actiId, level, context))
		{
			return ResultJsonUtil.returnErrorJson("200", "添加成功", "true");
		}
		return ResultJsonUtil.returnErrorJson("404", "添加失败", "false");
	}

	
	public String getProblems(String actiId, String page, String num) {
		// TODO Auto-generated method stub
		
		List list=wsPro.getActiProblems(actiId, page, num);
		if(list!=null)
		{
			List jsonList=new ArrayList();
			for(int i=0;i<list.size();i++)
			{
				Map opd=(Map) list.get(i);
				Problems pro=new Problems();
				pro.setProId(opd.get("id")+"");
				pro.setProblemContent(opd.get("content")+"");
				pro.setProblemDate(opd.get("proTime")+"");
				pro.setUserName(opd.get("userName")+"");
				pro.setStatus(Integer.valueOf(opd.get("fsStatus")+""));
				//加载回复
				if(pro.getStatus()==1)
				{
					List replyList=wsPro.getReply(pro.getProId());
					if(replyList!=null)
					{
						for(int j=0;j<replyList.size();j++)
						{
							Map rep=(Map)replyList.get(j);
							pro.setReplyContent(rep.get("reply")+"");
							pro.setReplyDate(rep.get("time")+"");
						}
						
					}
					
				}
				jsonList.add(pro);
			}
			JSONArray proJson=JSONArray.fromObject(jsonList);
			String json=proJson.toString();
			return ResultJsonUtil.returnJSON(new String[]{"problems"},new String[]{json}, "200", "null");
		}
		else
			return ResultJsonUtil.returnErrorJson("404", "加载问题失败", "false");
	}



	
	public String addfavoriteActi(String loginUserId, String actiId) {
		
		if(fav.addFavoite(loginUserId, actiId))
		{
			return ResultJsonUtil.returnErrorJson("200", "success", "true");
		}
		else
			return ResultJsonUtil.returnErrorJson("404", "添加收藏失败", "false");
	}


	public String addProblem(String loginUserId, String programContent,
			String actiId) {
		if(wsPro.addActiProblem(loginUserId, programContent, actiId))
		{
			return ResultJsonUtil.returnErrorJson("200", "success", "true");
		}
		else
		{
			return ResultJsonUtil.returnErrorJson("404", "添加问题失败", "false");
		}
	}
	@Override
	public String findActiByName(String keyWord) {
		List list=wsDesti.findActiByNameOrDesci(keyWord);
		List jsonList=new ArrayList();
		if(list!=null)
		{
			for(int i=0;i<list.size();i++)
			{
				Map actiMap=(Map)list.get(i);
				Map staMap=(Map)actiMap.get("static");
				Map dyMap=(Map)actiMap.get("dynamic");
				ActiInfo acIn=new ActiInfo();
				if(dyMap!=null)
				{
					acIn.setDiscussNum(dyMap.get("disNum")+"");
					acIn.setPraiseNum(dyMap.get("praiseNum")+"");
				}
				else
				{
					acIn.setDiscussNum("0");
					acIn.setPraiseNum("0");
				}
				if(staMap==null)
				{
					continue;
				}
				String fsId=staMap.get("fs_id")+"";
				acIn.setActiId(fsId);
				acIn.setActiImage(wsDesti.findImageUrl(fsId));
				acIn.setActiTitle(staMap.get("fs_title")+"");
				acIn.setActiType(staMap.get("actiType")+"");
				acIn.setDays(staMap.get("fn_day")+"");
				acIn.setOrigPrice(staMap.get("fn_special_price")+"");
				acIn.setPhysicalStrength(staMap.get("fs_physical_strength")+"");
				acIn.setSpecialPrice(staMap.get("fn_special_price")+"");
				acIn.setTripDistance(staMap.get("fn_trip_distance")+"");
				jsonList.add(acIn);
			}
			JSONArray returnArray=JSONArray.fromObject(jsonList);
			String json=returnArray.toString();
			return ResultJsonUtil.returnJSON(new String[]{"acti"},new String[]{json}, "200", "null");
		}
		else
			return ResultJsonUtil.returnErrorJson("404", "搜索活动失败", "false");
	}
	
	
	
	@Override
	public String findActiByType(String paramjson) {
		// TODO Auto-generated method stub
		final JSONObject jsonObj=JSONObject.fromObject(paramjson);
		final String actiType=jsonObj.getString("actiType");
		List list=wsDesti.findActiByType(actiType);
		List jsonList=new ArrayList();
		if(list!=null)
		{
			for(int i=0;i<list.size();i++)
			{
				Map actiMap=(Map)list.get(i);
				Map staMap=(Map)actiMap.get("static");
				Map dyMap=(Map)actiMap.get("dynamic");
				ActiInfo acIn=new ActiInfo();
				if(dyMap!=null)
				{
					acIn.setDiscussNum(dyMap.get("disNum")+"");
					acIn.setPraiseNum(dyMap.get("praiseNum")+"");
				}
				else
				{
					acIn.setDiscussNum("0");
					acIn.setPraiseNum("0");
				}
				if(staMap==null)
				{
					continue;
				}
				String fsId=staMap.get("fs_id")+"";
				acIn.setActiId(fsId);
				acIn.setActiImage(wsDesti.findImageUrl(fsId));
				acIn.setActiTitle(staMap.get("fs_title")+"");
				acIn.setActiType(staMap.get("actiType")+"");
				acIn.setDays(staMap.get("fn_day")+"");
				acIn.setOrigPrice(staMap.get("fn_special_price")+"");
				acIn.setPhysicalStrength(staMap.get("fs_physical_strength")+"");
				acIn.setSpecialPrice(staMap.get("fn_special_price")+"");
				acIn.setTripDistance(staMap.get("fn_trip_distance")+"");
				jsonList.add(acIn);
			}
			JSONArray returnArray=JSONArray.fromObject(jsonList);
			String json=returnArray.toString();
			return ResultJsonUtil.returnJSON(new String[]{"acti"},new String[]{json}, "200", "null");
		}
		else
			return ResultJsonUtil.returnErrorJson("404", "搜索活动失败", "false");
	}

	public String findActiByPraise() {
		List list=wsDesti.findOtActiByPraiseNum();
		List jsonList=new ArrayList();
		if(list!=null)
		{
			for(int i=0;i<list.size();i++)
			{
				Map actiMap=(Map)list.get(i);
				Map staMap=(Map)actiMap.get("static");
				Map dyMap=(Map)actiMap.get("dynamic");
				ActiInfo acIn=new ActiInfo();
				if(dyMap!=null)
				{
					acIn.setDiscussNum(dyMap.get("disNum")+"");
					acIn.setPraiseNum(dyMap.get("praiseNum")+"");
				}
				else
				{
					acIn.setDiscussNum("0");
					acIn.setPraiseNum("0");
				}
				if(staMap==null)
				{
					continue;
				}
				String fsId=staMap.get("fs_id")+"";
				acIn.setActiId(fsId);
				acIn.setActiImage(wsDesti.findImageUrl(fsId));
				acIn.setActiTitle(staMap.get("fs_title")+"");
				acIn.setActiType(staMap.get("actiType")+"");
				acIn.setDays(staMap.get("fn_day")+"");
				acIn.setOrigPrice(staMap.get("fn_special_price")+"");
				acIn.setPhysicalStrength(staMap.get("fs_physical_strength")+"");
				acIn.setSpecialPrice(staMap.get("fn_special_price")+"");
				acIn.setTripDistance(staMap.get("fn_trip_distance")+"");
				jsonList.add(acIn);
			}
			JSONArray returnArray=JSONArray.fromObject(jsonList);
			String json=returnArray.toString();
			return ResultJsonUtil.returnJSON(new String[]{"acti"},new String[]{json}, "200", "null");
		}
		else
			return ResultJsonUtil.returnErrorJson("404", "搜索活动失败", "false");
	}
	
	
	@Override
	public String findActiByPraiseAndType(String actiType) {
		List list=wsDesti.getActiByPraiseAndType(actiType);
		List jsonList=new ArrayList();
		if(list!=null)
		{
			for(int i=0;i<list.size();i++)
			{
				Map actiMap=(Map)list.get(i);
				Map staMap=(Map)actiMap.get("static");
				Map dyMap=(Map)actiMap.get("dynamic");
				ActiInfo acIn=new ActiInfo();
				if(dyMap!=null)
				{
					acIn.setDiscussNum(dyMap.get("disNum")+"");
					acIn.setPraiseNum(dyMap.get("praiseNum")+"");
				}
				else
				{
					acIn.setDiscussNum("0");
					acIn.setPraiseNum("0");
				}
				if(staMap==null)
				{
					continue;
				}
				String fsId=staMap.get("fs_id")+"";
				acIn.setActiId(fsId);
				acIn.setActiImage(wsDesti.findImageUrl(fsId));
				acIn.setActiTitle(staMap.get("fs_title")+"");
				acIn.setActiType(staMap.get("actiType")+"");
				acIn.setDays(staMap.get("fn_day")+"");
				acIn.setOrigPrice(staMap.get("fn_special_price")+"");
				acIn.setPhysicalStrength(staMap.get("fs_physical_strength")+"");
				acIn.setSpecialPrice(staMap.get("fn_special_price")+"");
				acIn.setTripDistance(staMap.get("fn_trip_distance")+"");
				jsonList.add(acIn);
			}
			JSONArray returnArray=JSONArray.fromObject(jsonList);
			String json=returnArray.toString();
			return ResultJsonUtil.returnJSON(new String[]{"acti"},new String[]{json}, "200", "null");
		}
		else
			return ResultJsonUtil.returnErrorJson("404", "搜索活动失败", "false");
	
	}
	@Override
	public String findActiByPraiseAndDestinName(String actiDestinName) {
		// TODO Auto-generated method stub
		List list=wsDesti.getActiByPraiseAndDesti(actiDestinName);
		List jsonList=new ArrayList();
		if(list!=null)
		{
			for(int i=0;i<list.size();i++)
			{
				Map actiMap=(Map)list.get(i);
				Map staMap=(Map)actiMap.get("static");
				Map dyMap=(Map)actiMap.get("dynamic");
				ActiInfo acIn=new ActiInfo();
				if(dyMap!=null)
				{
					acIn.setDiscussNum(dyMap.get("disNum")+"");
					acIn.setPraiseNum(dyMap.get("praiseNum")+"");
				}
				else
				{
					acIn.setDiscussNum("0");
					acIn.setPraiseNum("0");
				}
				if(staMap==null)
				{
					continue;
				}
				String fsId=staMap.get("fs_id")+"";
				acIn.setActiId(fsId);
				acIn.setActiImage(wsDesti.findImageUrl(fsId));
				acIn.setActiTitle(staMap.get("fs_title")+"");
				acIn.setActiType(staMap.get("actiType")+"");
				acIn.setDays(staMap.get("fn_day")+"");
				acIn.setOrigPrice(staMap.get("fn_special_price")+"");
				acIn.setPhysicalStrength(staMap.get("fs_physical_strength")+"");
				acIn.setSpecialPrice(staMap.get("fn_special_price")+"");
				acIn.setTripDistance(staMap.get("fn_trip_distance")+"");
				jsonList.add(acIn);
			}
			JSONArray returnArray=JSONArray.fromObject(jsonList);
			String json=returnArray.toString();
			return ResultJsonUtil.returnJSON(new String[]{"acti"},new String[]{json}, "200", "null");
		}
		else
			return ResultJsonUtil.returnErrorJson("404", "搜索活动失败", "false");
	}

	
	public String getMapDestinations(String longitude, String latitude) {
		List list=wsDesti.getDestinations(longitude, latitude);
		List jsonList =new ArrayList();
		if(list!=null)
		{
			for(int i=0;i<list.size();i++)
			{
				Map map=(Map)list.get(i);
				MapCountry mc=new MapCountry();
				mc.setCountryId(map.get("fs_id")+"");
				mc.setCountryName(map.get("fs_name")+"");
				mc.setLatitude(map.get("fs_latitude")+"");
				mc.setLongitude(map.get("fs_longitudel")+"");
				List imageList=wsDesti.findImageUrl( map.get("fs_id")+"");
				log.info("find country Image :"+imageList);
				if(imageList!=null&&imageList.size()!=0)
					mc.setImgUrl(imageList.get(0)+"");
				else
				{
					log.info("find country Image : 0 return null");
					mc.setImgUrl(null);
				}
				jsonList.add(mc);
			}
			JSONArray jsonArray=JSONArray.fromObject(jsonList);
			String json=jsonArray.toString();
			return ResultJsonUtil.returnJSON(new String[]{"country"},new String[]{json}, "200", "null");
		}
		else
		 return ResultJsonUtil.returnErrorJson("404", "加载地图失败", "false");
	}
	@Override
	public String findActiByCountry(String countryId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	/**
	 * web发布的方法实现
	 */
	public String findActiByCountryName(String paramjson)
	{
		final JSONObject loginFormJsonObj=JSONObject.fromObject(paramjson);
		 String countryName=loginFormJsonObj.getString("countryName");
		 log.info(countryName);
		countryName="中国";
		List list=wsDesti.getActiIdByCountryName(countryName);
		List jsonList =new ArrayList();
		if(list!=null)
		{
			for(int i=0;i<list.size();i++)
			{
				Map actiMap=(Map)list.get(i);
				Map staMap=(Map)actiMap.get("static");
				Map dyMap=(Map)actiMap.get("dynamic");
				ActiInfo acIn=new ActiInfo();
				if(dyMap!=null)
				{
					acIn.setDiscussNum(dyMap.get("disNum")+"");
					acIn.setPraiseNum(dyMap.get("praiseNum")+"");
				}
				else
				{
					acIn.setDiscussNum("0");
					acIn.setPraiseNum("0");
				}
				if(staMap==null)
				{
					continue;
				}
				String fsId=staMap.get("fs_id")+"";
				log.info("fs_id"+fsId);
				acIn.setActiId(fsId);
				acIn.setActiImage(wsDesti.findImageUrl(fsId));				
				acIn.setActiTitle(staMap.get("fs_title")+"");
				acIn.setActiType(staMap.get("actiType")+"");
				acIn.setDays(staMap.get("fn_day")+"");
				acIn.setOrigPrice(staMap.get("fn_special_price")+"");
				acIn.setPhysicalStrength(staMap.get("fs_physical_strength")+"");
				acIn.setSpecialPrice(staMap.get("fn_special_price")+"");
				acIn.setTripDistance(staMap.get("fn_trip_distance")+"");
				jsonList.add(acIn);
			}
			JSONArray returnArray=JSONArray.fromObject(jsonList);
			String json=returnArray.toString();
			return ResultJsonUtil.returnJSON(new String[]{"acti"},new String[]{json}, "200", "null");
		}
		else
			return ResultJsonUtil.returnErrorJson("404", "搜索活动失败", "false");
	}
	
	
	@Override
	public String getIndexActi(String paramjson) {
		final JSONObject loginFormJsonObj=JSONObject.fromObject(paramjson);
		final String longitude=loginFormJsonObj.getString("longitude");
		final String latitude=loginFormJsonObj.getString("latitude");
		String result=ResultJsonUtil.returnErrorJson(super.return_status_fail, "没找到活动", "false");;
		try {
			result=this.getIndexActi(longitude, latitude);
		} catch (Exception e) {
			log.debug("login is error!"+e.getStackTrace());
			e.printStackTrace();
		}
		finally
		{
			return result;
		}
	}
	@Override
	public String getMapDestinations(String paramjson) {
		final JSONObject jsonObj=JSONObject.fromObject(paramjson);
		 String longitude=jsonObj.getString("longitude");
		 String latitude=jsonObj.getString("latitude");
		latitude="30.270059";
		longitude="113.324334";
		return this.getMapDestinations(longitude, latitude);
	}
	@Override
	public String getDiscusses(String paramjson) {
		// TODO Auto-generated method stub
		final JSONObject jsonObj=JSONObject.fromObject(paramjson);
		final String actiId=jsonObj.getString("actiId");
		final String page=jsonObj.getString("page");
		final String num=jsonObj.getString("num");
		return this.getDiscusses(actiId, page, num);
		
	}
	@Override
	public String addfavoriteActi(String paramjson) {
		final JSONObject jsonObj=JSONObject.fromObject(paramjson);
		final String loginUserId=jsonObj.getString("loginUserId");
		final String actiId=jsonObj.getString("actiId");
		return this.addfavoriteActi(loginUserId, actiId);
	}
	@Override
	public String addDiscuss(String paramjson) {
		final JSONObject jsonObj=JSONObject.fromObject(paramjson);
		final String loginUesrId=jsonObj.getString("loginUesrId");
		final String actiId=jsonObj.getString("actiId");
		final String level=jsonObj.getString("level");
		final String context=jsonObj.getString("context");
		return this.addDiscuss(loginUesrId, actiId, level, context);
	}
	@Override
	public String getProblems(String paramjson) {
		final JSONObject jsonObj=JSONObject.fromObject(paramjson);
		final String actiId=jsonObj.getString("actiId");
		final String page=jsonObj.getString("page");
		final String num=jsonObj.getString("num");
		
		return this.getProblems(actiId, page, num);
	}
	@Override
	public String addProblem(String paramjson) {
		final JSONObject jsonObj=JSONObject.fromObject(paramjson);
		final String loginUserId=jsonObj.getString("loginUserId");
		final String programContent=jsonObj.getString("programContent");
		final String actiId=jsonObj.getString("actiId");
		return this.addProblem(loginUserId, programContent, actiId);
	}
	@Override
	public String getCountryAndType() {
		List counList=wsDesti.findCountries();
		List typeList=wsDesti.findTypes();
		List returnCounList=new ArrayList();
		List returnTypeList=new ArrayList();
		if(counList!=null)
		{
			for(int i=0;i<counList.size();i++)
			{
				Map counMap=(Map)counList.get(i);
				String fsId=counMap.get("fs_id")+"";
				ActiCountry ac=new ActiCountry();
				List imageList=wsDesti.findImageUrl(fsId);
				if(imageList!=null)
				{
					log.info("find country image num: "+imageList.size());
					ac.setCountryImg(imageList.get(0)+"");
				}
				else
				{
					log.info("find no country image");
					ac.setCountryImg(null);
				}
				ac.setCountryId(fsId);
				ac.setCountryName(counMap.get("fs_name")+"");
				returnCounList.add(ac);
			}
		}
	  if(typeList!=null)
		{
			for(int i=0;i<typeList.size();i++)
			{
				Map typeMap=(Map) typeList.get(i);
				String typefsId=typeMap.get("fs_id")+"";
				ActiType at=new ActiType();
				at.setTypeId(typefsId);
				at.setTypeName(typeMap.get("fs_name")+"");
				List typeImageList=wsDesti.findImageUrl(typefsId);
				if(typeImageList!=null)
				{
					log.info("find type image num: "+typeImageList.size());
					at.setTypeImg(typeImageList.get(0)+"");
				}
				else
				{
					log.info("find no type image return null "+typefsId);
					at.setTypeImg(null);
				}
				returnTypeList.add(at);
			}
		}
		if(typeList==null&counList==null)
		{
			return ResultJsonUtil.returnErrorJson(super.return_status_fail, "no data", "false");
		}
		JSONArray counJson=JSONArray.fromObject(returnCounList);
		String cj=counJson.toString();
	
		
		JSONArray typeJson=JSONArray.fromObject(returnTypeList);
		String tj=typeJson.toString();
	
		return ResultJsonUtil.returnJSON(new String[]{"country","type"},new String[]{cj,tj}, "200", "null");
	}
	
	
	@Override
	public String getActiByPosition(String paramjson) {
		final JSONObject jsonObj=JSONObject.fromObject(paramjson);
		final String latitude=jsonObj.getString("latitude");
		final String longitude=jsonObj.getString("longitude");
		List list=this.wsDesti.getDestinations(longitude, latitude);
		if(list!=null)
		{
			List jsonList=new ArrayList();
			for(int i=0;i<list.size();i++)
			{
				Map map=(Map)list.get(i);
				ActiPosition ap=new ActiPosition();
				ap.setActiId(map.get("fs_id")+"");
				ap.setActiName(map.get("fs_name")+"");
				ap.setLatitude(map.get("fs_latitude")+"");
				ap.setLongitude(map.get("fs_longitudel")+"");
				jsonList.add(ap);
			}
			JSONArray json=JSONArray.fromObject(jsonList);
			return ResultJsonUtil.returnJSON(new String[]{"position"}, new String[]{json.toString()}, "200", "null");
		}

		return ResultJsonUtil.returnErrorJson(super.return_status_fail, "no data", "false");
	}
	
	

}
