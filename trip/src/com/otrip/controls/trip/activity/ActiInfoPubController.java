package com.otrip.controls.trip.activity;   

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.otrip.controls.BaseController;
import com.otrip.dao.trip.ActiTypeDao;
import com.otrip.dao.trip.ImageDao;
import com.otrip.dao.util.ConvertDataUtil;
import com.otrip.domain.DomainUtils;
import com.otrip.domain.system.OtImage;
import com.otrip.domain.system.SysUser;
import com.otrip.domain.trip.OtActiDay;
import com.otrip.domain.trip.OtActiDestination;
import com.otrip.domain.trip.OtActiInfo;
import com.otrip.domain.trip.OtActiTimePrice;
import com.otrip.domain.trip.OtActiType;
import com.otrip.pojo.ImageVo;
import com.otrip.service.system.ImageService;
import com.otrip.service.trip.ActiDayService;
import com.otrip.service.trip.ActiInfoService;
import com.otrip.service.trip.ActiTypeService;
import com.otrip.service.trip.DestinationService;
import com.otrip.service.trip.TimePriceService;
import com.otrip.util.OtripConstants;
import com.otrip.view.SystemUtils;
import com.sun.beans.editors.DoubleEditor;
import com.sun.beans.editors.FloatEditor;
import com.sun.beans.editors.IntegerEditor;
import com.sun.beans.editors.LongEditor;

/**   
 * Filename:    ActiInfoController.java   
 * Copyright:   Copyright (c)2015  
 * Company:     otrip  
 * @version:    1.0   
 * @since:  JDK 1.7.0_21  
 * Create at:   2015年4月2日 下午10:24:33   
 * Description:  活动发布控制类
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年4月2日 zhongJc      1.0     1.0 Version   
 */
@Controller
@RequestMapping(value="/trip/activity/acti")
public class ActiInfoPubController extends BaseController {
	static Logger log=Logger.getLogger(ActiInfoPubController.class);
	
	private static final String view_acti_pub_manager="/trip/activity/acti/manager";
	private static final String view_acti_add_public="/trip/activity/acti/add";
	private static final String view_acti_view_public="/trip/activity/acti/view";
	
	private static final String view_acti_list_cover="/trip/activity/acti/list_cover";
	private static final String view_acti_list_days="/trip/activity/acti/list_days";
	private static final String view_acti_add_PriceTime="/trip/activity/acti/addPriceTime";
	private static final String modify_acti_info="/trip/activity/acti/modifyActi";
	
	private static final String view_acti_change_days="/trip/activity/acti/change_Days";
	private static final String view_acti_to_days="/trip/activity/acti/to_days";
	private static final String view_acti_view_days="/trip/activity/acti/view_days";
	private static final String view_other_image_type="/trip/activity/acti/otherImage";
	private static final String	view_acti_days_images="/trip/activity/acti/days_images";
	
	private ActiInfoService		actiInfoService;
	private DestinationService	destinationService;
	private ImageService		imageService;
	private ActiDayService		actiDayService;
	private TimePriceService  timePriceService;
	private ActiTypeService ats;
	
	
	
	@Autowired
	public void setActiTypeServie(ActiTypeService ats)
	{
		this.ats=ats;
	}
	
	@Autowired
	public void setActiInfoService(ActiInfoService actiInfoService) {
		this.actiInfoService = actiInfoService;
	}
	@Autowired
	public void setDestinationService(DestinationService destinationService) {
		this.destinationService = destinationService;
	}
	@Autowired
	public void setImageService(ImageService imageService) {
		this.imageService = imageService;
	}
	@Autowired
	public void setActiDayService(ActiDayService actiDayService) {
		this.actiDayService = actiDayService;
	}
	
	@Autowired
	public void setTimePriceService(TimePriceService tps)
	{
		this.timePriceService=tps;
	}
	/**
	 * @see 活动管理
	 * @param request
	 * @param response
	 * @param otActiInfo
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value="/manager.html")
	public ModelAndView  manager(HttpServletRequest request,HttpServletResponse response,@ModelAttribute OtActiInfo otActiInfo,BindingResult result) throws Exception{
		ModelAndView mav=new ModelAndView(view_acti_pub_manager);
		final List<OtActiInfo> actiList=actiInfoService.queryOtActiInfos(otActiInfo);
		mav.addObject("actiList", actiList);
		mav.addObject("a", otActiInfo);
		return mav;
	}
	
	/**
	 * @see 新增活动发布页面
	 * @param request
	 * @param response
	 * @param otActiInfo
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/add_public.html")
	public ModelAndView addPublic(HttpServletRequest request,HttpServletResponse response,@ModelAttribute OtActiInfo otActiInfo,BindingResult result)throws Exception{
		ModelAndView mav=new ModelAndView(view_acti_add_public);
		log.info(" input the public activity information");
		return mav;
	}
	
	
	
	/**
	 * @see 保存发布信息
	 * @param request
	 * @param response
	 * @param otActiInfo
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	@RequestMapping(value="/save_public.html")
	public ModelAndView savePublic(HttpServletRequest request,HttpServletResponse response,@ModelAttribute OtActiInfo otActiInfo,BindingResult result)throws Exception{
		ModelAndView mav=new ModelAndView(view_acti_add_public);
		log.info("#######Add otrip Dstination Info:##########");
		if(otActiInfo!=null&&StringUtils.isNotBlank(otActiInfo.getFsNo())&&StringUtils.isNotBlank(otActiInfo.getFsTitle())){
			final SysUser loginSysUser=super.currentSysUser(request);
			log.info(ConvertDataUtil.doString(otActiInfo.getFsLineRoad()));
			otActiInfo.setFsId(DomainUtils.generalUuid());
			otActiInfo.setFdCreateTime(new Date());
			otActiInfo.setFsCreateUserId(loginSysUser!=null&&StringUtils.isNotBlank(loginSysUser.getFsId())?loginSysUser.getFsId():null);
			
			actiInfoService.saveOtActiInfo(otActiInfo);
			mav.addObject(super.operator_state_code, "success");
		}else{
			mav.addObject(super.operator_state_code, "fail");
		}
		return mav;
	}
	
	/**
	 * @see 查看发布记录
	 * @param request
	 * @param response
	 * @param otActiInfo
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/view_public.html")
	public ModelAndView viewPublic(HttpServletRequest request,HttpServletResponse response,@ModelAttribute OtActiInfo otActiInfo,BindingResult result)throws Exception{
		ModelAndView mav=new ModelAndView(view_acti_view_public);
		final OtActiInfo actv=otActiInfo!=null&&StringUtils.isNotBlank(otActiInfo.getFsId())?actiInfoService.findOtActiInfoById(otActiInfo.getFsId()):null;
		mav.addObject("actv", actv);
		request.getSession().setAttribute("actiTitle", actv.getFsTitle());
		return mav;
	}
	
	/**
	 * 修改活动内容
	 */
	@RequestMapping(value="/modifyActi.html")
	public ModelAndView modifyActiById(HttpServletRequest request,HttpServletResponse response,@ModelAttribute OtActiInfo otActiInfo,BindingResult result)throws Exception
	{
		ModelAndView mav=new ModelAndView(modify_acti_info);
		final OtActiInfo actv=otActiInfo!=null&&StringUtils.isNotBlank(otActiInfo.getFsId())?actiInfoService.findOtActiInfoById(otActiInfo.getFsId()):null;
		mav.addObject("actv",actv);
		log.info(actv.getFsSeason()+":"+actv.getFsSeason());
		return mav;
	}
	
	@RequestMapping(value="/save_modifyActi.html")
	public String saveModifyActi(HttpServletRequest request,HttpServletResponse response, OtActiInfo a) throws Exception
	{

		log.info("desFsname: "+a.getFormatFdUpperTime());
		actiInfoService.updateActiInfoBySql(a);
		log.info("desFsname: "+a.getFdUpdateTime());
		return "forward:/trip/activity/acti/manager.html";
	}
	
	
	/**
	 * @see 封面图片列表
	 * @param request
	 * @param response
	 * @param imageName
	 * @param actId
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/list_cover.html")
	public ModelAndView listCover(HttpServletRequest request,HttpServletResponse response,@RequestParam("actId")  String actId,@RequestParam("imageName")  String imageName)throws Exception{
		ModelAndView mav=new ModelAndView(view_acti_list_cover);
		final List<OtImage> actCoverImages=imageService.findOtImagesByObjIdAndObjSignOrName(actId, ActiInfoPubConstans.ACTI_TRIP_OBJ_SIGN_COVER_IMAGE, imageName);
		mav.addObject("actCoverImages", actCoverImages);
		mav.addObject("imageName", imageName);
		mav.addObject("actId", actId);
		return mav;
	}
	
	
	@RequestMapping(value="/days_image.html")
	public ModelAndView daysImage(HttpServletRequest request,HttpServletResponse response,@RequestParam("daysId")  String daysId,@RequestParam("imageName")  String imageName)throws Exception{
		ModelAndView mav=new ModelAndView(view_acti_days_images);
		final List<OtImage> actDaysImages=imageService.findOtImagesByObjIdAndObjSignOrName(daysId, ActiInfoPubConstans.ACTI_TRIP_OBJ_SIGN_DAYS_IMAGE, imageName);
		mav.addObject("actDaysImages", actDaysImages);
		mav.addObject("imageName", imageName);
		mav.addObject("daysId", daysId);
		return mav;
	}
	
	
	
	/**
	 * 查看其他图片
	 */
	@RequestMapping("/list_otherImage")
	public ModelAndView list_otherImage(HttpServletRequest request,HttpServletResponse response)
	{
		
		ModelAndView mav=new ModelAndView(view_other_image_type);
		
		List<ImageVo> images=null;
		
	   images= this.imageService.findAllImage(null);
	    log.info("find list images: "+images.size());
		
		mav.addObject("images",images);
		return mav;
	}
	
	/**
	 * 检查天数是否重复，重复返回true
	 * @param request
	 * @param response
	 * @param dayNum
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/checkDaysInput.html",params="json",method=RequestMethod.POST)
	@ResponseBody
	public String checkDaysInput(HttpServletRequest request,HttpServletResponse response,@RequestParam("dayNum")String dayNum) throws Exception
	{
		
		if(this.actiDayService.checkDayNum(dayNum))
		{
			return OtripConstants.getReturnSuccessjson();
		}
		else
		{
			return OtripConstants.getReturnErrorjson();
		}
		
	}
	/**
	 * huo qu tu pian lei xing
	 */
	@RequestMapping(value="/getImageType.html",params="json",method=RequestMethod.POST)
	@ResponseBody
	public String getImageType(HttpServletRequest request,HttpServletResponse response)
	{
		String json="[{\"typeValue\":\"ot_acti_type\",\"typeText\":\"\u6d3b\u52a8\u7c7b\u578b\"}]";
		return json;
	}
	
	
	/**
	 * huo qutu pian xiang xi lei xing
	 */
	@RequestMapping(value="/getImageDetail",params="json",method=RequestMethod.POST)
	@ResponseBody
	public String getImageDetail(HttpServletRequest request,HttpServletResponse response,@RequestParam("typeId") String typeId)
	{
		log.info(typeId);
		String json=null;
		if(typeId.endsWith("ot_acti_type"))
		{
			try {
				List<OtActiType> list=ats.queryOtActiTypes(new OtActiType());
				if(list.size()!=0)
				{
					List jsonList=new ArrayList();
					for(int i=0;i<list.size();i++)
					{
						//list.get(i).getFsName();
						Map map=new HashMap();
						map.put("detailValue",list.get(i).getFsId());
						map.put("detailText", list.get(i).getFsName());
						jsonList.add(map);
					}
					JSONArray ja=JSONArray.fromObject(jsonList);
					json=ja.toString();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				log.error(e.getMessage());
				//e.printStackTrace();
			}
			 //json="[{\"detailValue\":\"1\",\"detailText\":\"1detail1\"},{\"detailValue\":\"1\",\"detailText\":\"1detail2\"},{\"detailValue\":\"1\",\"detailText\":\"1detail3\"}]";
		}
		/*
		else if(typeId.endsWith("2"))
		{
			json="[{\"detailValue\":\"1\",\"detailText\":\"2detail1\"},{\"detailValue\":\"1\",\"detailText\":\"2detail2\"},{\"detailValue\":\"1\",\"detailText\":\"2detail3\"}]";
		}
		else if(typeId.endsWith("3"))
		{
			json="[{\"detailValue\":\"1\",\"detailText\":\"3detail1\"},{\"detailValue\":\"1\",\"detailText\":\"3detail2\"},{\"detailValue\":\"1\",\"detailText\":\"3detail3\"}]";
		}
		*/
		log.info(json);
			return json;
	}
	
	/**
	 * @see 日程安排
	 * @param request
	 * @param response
	 * @param otActiDay
	 * @param actId
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/list_days.html")
	public ModelAndView listDays(HttpServletRequest request,HttpServletResponse response,@RequestParam(value="actId",required=false,defaultValue="") String actId,@ModelAttribute OtActiDay otActiDay,BindingResult result)throws Exception{
		ModelAndView mav=new ModelAndView(view_acti_list_days);
		final OtActiInfo actv=StringUtils.isNotBlank(actId)?actiInfoService.findOtActiInfoById(actId):null;
		final List<OtActiDay> actDays=actiDayService.queryOtActiDaysByOtActiInfoAndName(actv, null);
		log.info("find days: "+actDays.size());
		mav.addObject("actDays", actDays);
		mav.addObject("actId", actId);
		//mav.addObject("otActiDay", otActiDay);
		return mav;
	}
	
	
	@RequestMapping(value="/list_TimePrice.html")
	public ModelAndView getListDays(HttpServletRequest request,HttpServletResponse response,@RequestParam(value="actId") String actId ,@ModelAttribute OtActiDay otActiDay,BindingResult result) throws Exception
	{
		ModelAndView mav=new ModelAndView(view_acti_add_PriceTime);
		OtActiInfo actv=StringUtils.isNotBlank(actId)?actiInfoService.findOtActiInfoById(actId):null;
		List<OtActiTimePrice> timePrice=actv.getOtActiTimePrices();
		log.info("find timePrices num is:"+timePrice.size());
		mav.addObject("actId",actId);
		mav.addObject("timePrice", timePrice);
		
		return mav;  
	}
	
	
	/**
	 * 获取日程信息
	 * @param request
	 * @param response
	 * @param actId
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value="/getTimePrice.html",params="json",method=RequestMethod.POST)
	@ResponseBody
	public String getTimePrice(HttpServletRequest request,HttpServletResponse response,@RequestParam("actId") String actId,
			@RequestParam("page") String page,
			@RequestParam("rows") String rows)
	{
		log.info("actId "+actId+" ;start :"+page+" ;rows "+rows);
		//OtActiInfo actv=StringUtils.isNotBlank(actId)?actiInfoService.findOtActiInfoById(actId):null;
		List jsonList =this.timePriceService.queryTimePriceByActiInfoId(actId, page, rows);
		List returnList=new ArrayList();
		if(jsonList!=null)
		{
			log.info("find timePrice : "+jsonList.size());
			for(int i=0;i<jsonList.size();i++)
			{
				Map oatp=(Map)jsonList.get(i);
				
				Map timeMap=new HashMap();
				timeMap.put("JSON_Id", oatp.get("fsId")+"");
				timeMap.put("JSON_no",oatp.get("fs_title")+"");
				timeMap.put("JSON_orignal",oatp.get("fn_original_price")+"");
				timeMap.put("JSON_special",oatp.get("fn_special_price")+"" );
				timeMap.put("JSON_start", oatp.get("fd_start_time")+"");
				timeMap.put("JSON_end", oatp.get("fd_end_time")+"");
				timeMap.put("JSON_create",oatp.get("fd_create_time")+"" );
				timeMap.put("JSON_update", oatp.get("fd_update_time")+"");
				returnList.add(timeMap);
				
			}
			
			JSONArray ja=JSONArray.fromObject(returnList);
			log.info("return code:"+ja.toString());
			return ja.toString();
			
		}
		else
		{
			return OtripConstants.getReturnErrorjson();
		}
		
	}
	
	@RequestMapping(value="/delDay.html",params="json")
	@ResponseBody
	public String delDayById(HttpServletRequest request,HttpServletResponse response,
			@RequestParam("dayId")String dayId) 
	{
		
		try 
		{
			
			if(this.actiDayService.delOtActiDayById(dayId))
			{
				return OtripConstants.getReturnSuccessjson();
			}
		}catch (Exception e) {
			
			log.error(e.getMessage());
		}
		return OtripConstants.getReturnErrorjson();
		
	}
	
	@RequestMapping(value="/delActiInfo.html",params="json")
	@ResponseBody
	public String delActiInfoById(HttpServletRequest request,HttpServletResponse response,
			@RequestParam("actiId")String actiId) 
	{
		
		try 
		{
			
			if(this.actiInfoService.delActiInfoById(actiId))
			{
				return OtripConstants.getReturnSuccessjson();
			}
		}catch (Exception e) {
			
			log.error(e.getMessage());
		}
		return OtripConstants.getReturnErrorjson();
		
	}
	

	/**
	 *删除时间价格
	 */
	@RequestMapping(value="/delTimePrice",params="json",method=RequestMethod.POST)
	@ResponseBody
	public String delTimePrice(HttpServletRequest request,HttpServletResponse response,
			@RequestParam("fsId")String fsId)
	{
		log.info("del TimePrice fsId"+fsId);
		if(this.timePriceService.deleteTimePriceById(fsId))
		{
			return OtripConstants.getReturnSuccessjson();
		}
		else
			return OtripConstants.getReturnErrorjson();
	}
	
	/**
	 * 添加时间价格
	 */
	@RequestMapping(value="/addTimePrice.html",params="json",method=RequestMethod.POST)
	@ResponseBody
	public String addTimePrice(HttpServletRequest request,HttpServletResponse response,
			@RequestParam("original") String original
			,@RequestParam("end") String  end
			,@RequestParam("start") String start
			,@RequestParam("special") String special
			,@RequestParam("actid") String actid
			)
	{
		if(this.timePriceService.saveTimePrice(actid, original, special, start, end))
			return OtripConstants.getReturnSuccessjson();
		else
			return OtripConstants.getReturnErrorjson();
			
		
	}

	@RequestMapping(value="/modifyTimePrice.html",params="json",method=RequestMethod.POST)
	@ResponseBody
	public String modifyTimePrice(HttpServletRequest request,HttpServletResponse response,
			@RequestParam("original") String original
			,@RequestParam("end") String  end
			,@RequestParam("start") String start
			,@RequestParam("special") String special
			,@RequestParam("tpid") String tpid
			)
	{
		//String tpid=request.getParameter("tpid");
		log.info("tpid"+": "+tpid);
		log.info("original :"+original+" end :"+end+" : start :"+start+" :special :"+special);
		if(this.timePriceService.modifyTimePrice(tpid, original, special, start, end))
		{
			return OtripConstants.getReturnSuccessjson();
		}
		
		return OtripConstants.getReturnErrorjson();
	}
	/**
	 * @see 添加日程表
	 * @param request
	 * @param response
	 * @param actId
	 * @param otActiDay
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/to_days.html")
	public ModelAndView toDays(HttpServletRequest request,HttpServletResponse response,@ModelAttribute OtActiDay otActiDay,BindingResult result)throws Exception{
		ModelAndView mav=new ModelAndView(view_acti_to_days);
		mav.addObject("d", otActiDay);
		return mav;
	}
	
	/**
	 * @see 保存日程
	 * @param request
	 * @param response
	 * @param actId
	 * @param otActiDay
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/save_days.html")
	public ModelAndView saveDays(HttpServletRequest request,HttpServletResponse response,@ModelAttribute OtActiDay otActiDay,BindingResult result)throws Exception{
		ModelAndView mav=new ModelAndView(view_acti_to_days);
		otActiDay.setFsId(DomainUtils.generalUuid());
		otActiDay.setFdCreateTime(new Date());
		actiDayService.saveOtActiDay(otActiDay);
		mav.addObject(super.operator_state_code, "success");
		mav.addObject("actId", otActiDay.getOtActiInfo().getFsId());
		mav.addObject("d", otActiDay);
		return mav;
	}
	
	@RequestMapping(value="/save_Changedays.html")
	public String saveChangeDays(HttpServletRequest request,HttpServletResponse response,@ModelAttribute OtActiDay otActiDay,BindingResult result)throws Exception{
		
		
		
		log.info("save change Day");
		try
		{
			actiDayService.updateOtActiDay(otActiDay);
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "redirect:/trip/activity/acti/list_days.html?actId="+otActiDay.getOtActiInfo().getFsId();
		
	}
	
	
	/**
	 * 修改编辑日程
	 */
	@RequestMapping(value="/change_days.html")
	public ModelAndView changeDays(HttpServletRequest request,HttpServletResponse response,@RequestParam("daysFsId")String daysFsId,@RequestParam("actiFsId")String actiFsId)throws Exception
	{
		ModelAndView mav=new ModelAndView(view_acti_change_days);
		if(StringUtils.isNotBlank(daysFsId))
		{
			log.info(daysFsId);
			log.info(actiFsId);
			OtActiDay otActiDay=actiDayService.queryOtActiDayById(daysFsId);
			
			mav.addObject("actiDay", otActiDay);
			mav.addObject("actiId",actiFsId );
		}
		return mav;
	}
	
	
	/**
	 * @see 查看日程
	 * @param request
	 * @param response
	 * @param otActiDay
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/view_days.html")
	public ModelAndView viewDays(HttpServletRequest request,HttpServletResponse response,@ModelAttribute OtActiDay otActiDay,BindingResult result)throws Exception{
		ModelAndView mav=new ModelAndView(view_acti_view_days);
		if(otActiDay!=null&&StringUtils.isNotBlank(otActiDay.getFsId())){
			otActiDay=actiDayService.queryOtActiDayById(otActiDay.getFsId());
			final List<OtImage> actDaysImages=imageService.findOtImagesByObjIdAndObjSignOrName(otActiDay.getFsId(), ActiInfoPubConstans.ACTI_TRIP_OBJ_SIGN_DAYS_IMAGE, null);
			mav.addObject("actDayImages", actDaysImages);
		}
		mav.addObject("d", otActiDay);
		return mav;
	}
	
	
	
	/**
	 * @see 获取景区下拉选项
	 * @param request
	 * @param response
	 * @param parentId
	 * @return
	 */
	@SuppressWarnings("static-access")
	@RequestMapping(value="/getDestinationOpt.html",params="json",method=RequestMethod.POST)
	@ResponseBody
	public String getDestinationOpt(HttpServletRequest request,HttpServletResponse response,@RequestParam("parentId") String parentId)throws Exception{		 
		log.info(" parentId id:"+parentId);
		final List<OtActiDestination> childList=destinationService.findOtActiDestinationsByParentId(parentId);
		final List<Map<String,Object>> optList=new ArrayList<Map<String,Object>>();
		if(childList!=null&&childList.size()>0){
			for( OtActiDestination d :childList ){
				Map<String,Object> m=new HashMap<String,Object>();
				m.put("value", d.getFsId());
				m.put("name", d.getFsName());
				optList.add(m);
			}
		}
		JSONArray j=new JSONArray();
		j.addAll(optList);
		log.info(" message:"+j.toString());
		return j.toString();
	}
	
	
	
	/**
	 * @see 线路编号
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	@RequestMapping(value="/get_trip_line_no.html",params="json",method=RequestMethod.POST)
	@ResponseBody
	public String getTripLineNo(HttpServletRequest request,HttpServletResponse response)throws Exception{
		final String dateno="TRIP-LINE"+SystemUtils.getTimeFormat("yyyyMMddHHmmss", new Date())+(Math.round(100d))+1;
		JSONObject j=new JSONObject();
		j.put("tripno", dateno);
		log.info(" message tripno:"+j.toString());
		return j.toString();
	}
	
	/**
	 * @see 参数为ServletRequestDataBinder，可以进行自定义绑定类型转换
	 * @param binder
	 * @throws Exception
	 */
	@InitBinder("otActiInfo")      
	public void initBinder1(ServletRequestDataBinder binder) throws Exception{   
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));  
		binder.registerCustomEditor(int.class, new IntegerEditor());  
        binder.registerCustomEditor(long.class, new LongEditor());  
        binder.registerCustomEditor(double.class, new DoubleEditor());  
        binder.registerCustomEditor(float.class, new FloatEditor());  
		binder.setFieldDefaultPrefix("a.");  
		
	}
	
	@InitBinder("otActiDay")      
	public void initBinder2(ServletRequestDataBinder binder) throws Exception{   
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));  
		binder.registerCustomEditor(int.class, new IntegerEditor());  
        binder.registerCustomEditor(long.class, new LongEditor());  
        binder.registerCustomEditor(double.class, new DoubleEditor());  
        binder.registerCustomEditor(float.class, new FloatEditor());  
		binder.setFieldDefaultPrefix("d.");  
		
	}
	
	@InitBinder("otImage")      
	public void initBinder3(ServletRequestDataBinder binder) throws Exception{   
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));  
		binder.registerCustomEditor(int.class, new IntegerEditor());  
        binder.registerCustomEditor(long.class, new LongEditor());  
        binder.registerCustomEditor(double.class, new DoubleEditor());  
        binder.registerCustomEditor(float.class, new FloatEditor());  
		binder.setFieldDefaultPrefix("i.");  
		
	}
	
	
	

}
