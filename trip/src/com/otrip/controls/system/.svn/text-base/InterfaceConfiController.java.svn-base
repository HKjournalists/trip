package com.otrip.controls.system;   

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
import com.otrip.domain.DomainUtils;
import com.otrip.domain.system.SysMenuType;
import com.otrip.domain.ws.WsServiceClient;
import com.otrip.service.ws.WsServiceClientService;

/**   
 * Filename:    InterfaceConfiController.java   
 * Copyright:   Copyright (c)2015  
 * Company:     otrip  
 * @version:    1.0   
 * @since:  JDK 1.7.0_21  
 * Create at:   2015年3月25日 下午4:16:28   
 * Description:  接口配置
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年3月25日 zhongJc      1.0     1.0 Version   
 */

@Controller
@RequestMapping(value="/system/interface_conf")
public class InterfaceConfiController extends BaseController {
	static Logger log=Logger.getLogger(InterfaceConfiController.class);

	private static final String view_manager="/system/interface/manager";
	private static final String view_add="/system/interface/add";
	
	private WsServiceClientService wsServiceClientService;
	@Autowired
	public void setWsServiceClientService(
			WsServiceClientService wsServiceClientService) {
		this.wsServiceClientService = wsServiceClientService;
	}
	
	@RequestMapping(value="/manager.html")
	public ModelAndView manager(HttpServletRequest request,HttpServletResponse response,@ModelAttribute WsServiceClient wsServiceClient,BindingResult result)throws Exception{
		ModelAndView mav=new ModelAndView(view_manager);
		final List<WsServiceClient> scList=wsServiceClientService.queryWsServiceClients(wsServiceClient);
		mav.addObject("wsc", wsServiceClient);
		mav.addObject("scList", scList);
		return mav;
	}
	
	@RequestMapping(value="/toAdd.html")
	public ModelAndView toAdd(HttpServletRequest request,HttpServletResponse response,@ModelAttribute WsServiceClient wsServiceClient,BindingResult result){
		ModelAndView mav=new ModelAndView(view_add);
		log.info("in add page.");
		return mav;
	}
	
	@SuppressWarnings("static-access")
	@RequestMapping(value="/save.html")
	public ModelAndView save(HttpServletRequest request,HttpServletResponse response,@ModelAttribute WsServiceClient wsServiceClient,BindingResult result) throws Exception{
		ModelAndView mav=new ModelAndView(view_add);
		log.info("in add page.");
		if(wsServiceClient!=null&&StringUtils.isNotBlank(wsServiceClient.getFsClientAccount())){
			wsServiceClient.setFdCreateTime(new Date());
			wsServiceClient.setFsId(DomainUtils.generalUuid());
			wsServiceClientService.saveWsServiceClient(wsServiceClient);
			mav.addObject(super.operator_state_code, "success");
		}else{
			mav.addObject(super.operator_state_code, "fail");
		}
		return mav;
	}
	
	@RequestMapping(value="/delete.html",params="json",method=RequestMethod.POST)
	@ResponseBody
	public String delete(HttpServletRequest request,HttpServletResponse response,@RequestParam("id") String id)throws Exception{		 
		 if(StringUtils.isNotBlank(id)){
 			log.info("delete MenuType id:"+id);
 			wsServiceClientService.deleteWsServiceClientById(id);
 			super.operatro_state_code_object.put(super.operator_state_code, "success");
 		}else{
 			super.operatro_state_code_object.put(super.operator_state_code, "fail");
 		}
		log.info(" Operator status#####:"+super.operatro_state_code_object.toString());
		return super.operatro_state_code_object.toString();
	}
	
	@InitBinder("wsServiceClient")
	public void initBinder1(ServletRequestDataBinder binder) throws Exception{
		// TODO Auto-generated method stub
		binder.setFieldDefaultPrefix("wsc.");     
	}
	
	
}
