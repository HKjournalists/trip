package com.otrip.controls.trip.configure;   

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.otrip.dao.util.ReturnJsonMsg;
import com.otrip.domain.DomainUtils;
import com.otrip.domain.trip.OtActiDestinationType;
import com.otrip.domain.trip.OtActiType;
import com.otrip.service.trip.ActiTypeService;
import com.otrip.util.OtripConstants;

/**   
 * Filename:    ActivityTypeController.java   
 * Copyright:   Copyright (c)2015  
 * Company:     otrip  
 * @version:    1.0   
 * @since:  JDK 1.7.0_21  
 * Create at:   2015年3月26日 上午10:11:44   
 * Description:  活动了类型配置
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年3月26日 zhongJc      1.0     1.0 Version   
 */

@Controller
@RequestMapping(value="/trip/configure/activity")
public class ActivityTypeController extends BaseController {
	
	static Logger log=Logger.getLogger(ActivityDestinationTypeController.class);

	private static final String view_activity_type_manager="/trip/configure/activity/type_manager";
	private static final String view_activity_type_add="/trip/configure/activity/type_add";
	private static final String view_activity_type_modify="/trip/configure/activity/modify_type";
	
	
	private ActiTypeService actiTypeService;
	@Autowired
	public void setActiTypeService(ActiTypeService actiTypeService) {
		this.actiTypeService = actiTypeService;
	}
	
	/**
	 * @see 活动类型
	 * @param request
	 * @param response
	 * @param otActiType
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/type_manager.html")
	public ModelAndView manager(HttpServletRequest request,HttpServletResponse response,@ModelAttribute OtActiType otActiType,BindingResult result) throws Exception{
		ModelAndView mav=new ModelAndView(view_activity_type_manager);
		final List<OtActiType> atList=actiTypeService.queryOtActiTypes(otActiType);
		mav.addObject("atList", atList);
		mav.addObject("at", otActiType);
		return mav;
	}
	
	/**
	 * @see 新增景区类型
	 * @param request
	 * @param response
	 * @param otActiDestinationType
	 * @param result
	 * @return
	 */
	@RequestMapping(value="/to_type_add.html")
	public ModelAndView toAdd(HttpServletRequest request,HttpServletResponse response,@ModelAttribute OtActiType otActiType,BindingResult result)throws Exception{
		ModelAndView mav=new ModelAndView(view_activity_type_add);
		log.info("in add page.");
		return mav;
	}
	
	/**
	 * @see 保存活动类型
	 * @param request
	 * @param response
	 * @param otActiType
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	@RequestMapping(value="/to_type_save.html")
	public ModelAndView save(HttpServletRequest request,HttpServletResponse response,@ModelAttribute OtActiType otActiType,BindingResult result) throws Exception{
		ModelAndView mav=new ModelAndView(view_activity_type_add);
		log.info("in add page.");
		if(otActiType!=null&&StringUtils.isNotBlank(otActiType.getFsName())){
			otActiType.setFdCreateTime(new Date());
			otActiType.setFsId(DomainUtils.generalUuid());
			actiTypeService.saveOtActiType(otActiType);
			mav.addObject(super.operator_state_code, "success");
		}else{
			mav.addObject(super.operator_state_code, "fail");
		}
		return mav;
	}
	
	/**
	 * @see 删除活动类型
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	@RequestMapping(value="/delete.html",params="json",method=RequestMethod.POST)
	@ResponseBody
	public String delete(HttpServletRequest request,HttpServletResponse response,@RequestParam("id") String id) throws Exception{		 
		 if(StringUtils.isNotBlank(id)){
 			log.info("delete activity type by id:"+id);
 			actiTypeService.deleteOtActiTypeById(id);
 			super.operatro_state_code_object.put(super.operator_state_code, "success");
 		}else{
 			super.operatro_state_code_object.put(super.operator_state_code, "fail");
 		}
		log.info(" Operator status#####:"+super.operatro_state_code_object.toString());
		return super.operatro_state_code_object.toString();
	}
	
	
	
	@InitBinder("otActiType")      
	public void initBinder1(ServletRequestDataBinder binder) throws Exception{              
		binder.setFieldDefaultPrefix("at.");     
	}

	
	
	
	@RequestMapping(value="/modify.html")
	@ResponseBody
	public ModelAndView modifyDestinationType(HttpServletRequest request,HttpServletResponse response,@ModelAttribute OtActiType ot)
	{
		ModelAndView mv=new ModelAndView(view_activity_type_modify); 
		try {
			OtActiType oat=this.actiTypeService.loadById(ot.getFsId());
			oat.getFsName();oat.getFsSign();
			mv.addObject("dt", oat);
			
		} catch (Exception e) {
			log.error("not found actiType");
		}
		log.info("actiType:"+ot.getFsId());
		return mv;
	}
	
	@SuppressWarnings("static-access")
	@RequestMapping(value="/saveChange.html",params="json", method=RequestMethod.POST)
	@ResponseBody
	public String saveChange(HttpServletRequest request,HttpServletResponse response,@ModelAttribute OtActiType ot)
	{
		log.info(ot.getFsId());
		log.info(ot.getFsSign());
		try 
		{
			if(this.actiTypeService.updateActiType(ot))
			{
				return OtripConstants.getReturnSuccessjson();
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return OtripConstants.getReturnErrorjson();
	}
	
	
	
	
	
	@SuppressWarnings("static-access")
	@RequestMapping(value="/judgeInput.html",params="json",method=RequestMethod.POST)
	@ResponseBody
	public  String judgeInput(HttpServletRequest request,HttpServletResponse response)
	{
		String fsname=request.getParameter("fsname");
		String fsSign=request.getParameter("fsSign");
		log.info(fsname);
		log.info(fsSign);
		if(this.actiTypeService.judgeInput("fsName", fsname))
		{
			if(this.actiTypeService.judgeInput("fsSign", fsSign))
			{
				return OtripConstants.getReturnSuccessjson();
			}
			else
			{
				return ReturnJsonMsg.getMsgJSON("\u6d3b\u52a8\u7c7b\u578b\u6807\u793a\u5df2\u5b58\u5728", "fsSign");
			}
		}
		else
		{
			return ReturnJsonMsg.getMsgJSON("\u6d3b\u52a8\u7c7b\u578b\u540d\u79f0\u5df2\u5b58\u5728", "fsName");
		}
	}
}
