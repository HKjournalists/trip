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
import com.otrip.domain.system.SysMenuType;
import com.otrip.domain.trip.OtActiDestinationType;
import com.otrip.service.trip.DestinationTypeService;
import com.otrip.util.OtripConstants;

/**   
 * Filename:    ActivityDestinationTypeController.java   
 * Copyright:   Copyright (c)2015  
 * Company:     otrip  
 * @version:    1.0   
 * @since:  JDK 1.7.0_21  
 * Create at:   2015年3月26日 上午10:13:14   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年3月26日 zhongJc      1.0     1.0 Version   
 */
@Controller
@RequestMapping(value="/trip/configure/destination")
public class ActivityDestinationTypeController extends BaseController {
	
	static Logger log=Logger.getLogger(ActivityDestinationTypeController.class);

	private static final String view_destination_type_manager="/trip/configure/destination/type_manager";
	private static final String view_destination_type_add="/trip/configure/destination/type_add";
	private static final String view_destination_type_modify="/trip/configure/destination/modify_type";
	
	
	private DestinationTypeService destinationTypeService;
	@Autowired
	public void setDestinationTypeService(
			DestinationTypeService destinationTypeService) {
		this.destinationTypeService = destinationTypeService;
	}
	
	
	/**
	 * @see 景区类型管理
	 * @param request
	 * @param response
	 * @param otActiDestinationType
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/type_manager.html")
	public ModelAndView manager(HttpServletRequest request,HttpServletResponse response,@ModelAttribute OtActiDestinationType otActiDestinationType,BindingResult result) throws Exception{
		ModelAndView mav=new ModelAndView(view_destination_type_manager);
		final List<OtActiDestinationType> dtList=destinationTypeService.queryOtActiDestinationTypes(otActiDestinationType);
		mav.addObject("dtList", dtList);
		mav.addObject("dt", otActiDestinationType);
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
	public ModelAndView toAdd(HttpServletRequest request,HttpServletResponse response,@ModelAttribute OtActiDestinationType otActiDestinationType,BindingResult result)throws Exception{
		ModelAndView mav=new ModelAndView(view_destination_type_add);
		log.info("in add page.");
		return mav;
	}
	
	
	/**
	 * @see 保存景区类型
	 * @param request
	 * @param response
	 * @param otActiDestinationType
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	@RequestMapping(value="/to_type_save.html")
	public ModelAndView save(HttpServletRequest request,HttpServletResponse response,@ModelAttribute OtActiDestinationType otActiDestinationType,BindingResult result) throws Exception{
		ModelAndView mav=new ModelAndView(view_destination_type_add);
		log.info("in add page.");
		if(otActiDestinationType!=null&&StringUtils.isNotBlank(otActiDestinationType.getFsName())){
			otActiDestinationType.setFdCreateTime(new Date());
			otActiDestinationType.setFsId(DomainUtils.generalUuid());
			destinationTypeService.saveOtActiDestinationType(otActiDestinationType);
		}
		mav.addObject(super.operator_state_code, "success");
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
 			log.info("delete destination type by id:"+id);
 			destinationTypeService.deleteActiDestinationById(id);
 			super.operatro_state_code_object.put(super.operator_state_code, "success");
 		}else{
 			super.operatro_state_code_object.put(super.operator_state_code, "fail");
 		}
		log.info(" Operator status#####:"+super.operatro_state_code_object.toString());
		return super.operatro_state_code_object.toString();
	}
	
	@RequestMapping(value="/modify.html")
	@ResponseBody
	public ModelAndView modifyDestinationType(HttpServletRequest request,HttpServletResponse response,@ModelAttribute OtActiDestinationType ot)
	{
		ModelAndView mv=new ModelAndView(view_destination_type_modify); 
		try {
			OtActiDestinationType oadt=this.destinationTypeService.loadOtActiDestinationTypeById(ot.getFsId());
			mv.addObject("dt", oadt);
			
		} catch (Exception e) {
			log.error("not found destinationType");
		}
		log.info("destinationType:"+ot.getFsId());
		return mv;
	}
	
	@SuppressWarnings("static-access")
	@RequestMapping(value="/saveChange.html",params="json", method=RequestMethod.POST)
	@ResponseBody
	public String saveChange(HttpServletRequest request,HttpServletResponse response,@ModelAttribute OtActiDestinationType ot)
	{
		log.info(ot.getFsSign());
		try 
		{
			if(this.destinationTypeService.updateActiDestinationType(ot))
			{
				return OtripConstants.getReturnSuccessjson();
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return OtripConstants.getReturnErrorjson();
	}
	
	
	@SuppressWarnings("static-access")
	@RequestMapping(value="/judgeInput.html",params="json", method=RequestMethod.POST)
	@ResponseBody
	public String judgeInput(HttpServletRequest request,HttpServletResponse response)
	{
		String fsname=request.getParameter("fsname");
		String fsSign=request.getParameter("fsSign");
		if(this.destinationTypeService.judgeInput("fsName", fsname))
		{
			if(this.destinationTypeService.judgeInput("fsSign", fsSign))
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
	
	
	
	
	@ResponseBody
	/**
	 * @see 绑定请求的对象
	 * @param binder
	 * @throws Exception
	 */
	@InitBinder("otActiDestinationType")      
	public void initBinder1(ServletRequestDataBinder binder) throws Exception{              
		binder.setFieldDefaultPrefix("dt.");     
	}
}
