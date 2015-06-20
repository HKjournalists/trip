package com.otrip.controls.system;   

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
import com.otrip.domain.system.SysDictionaryType;
import com.otrip.domain.ws.WsLogLogin;
import com.otrip.service.ws.WsLogLoginService;

/**   
 * Filename:    TravelLoginLogController.java   
 * Copyright:   Copyright (c)2015  
 * Company:     otrip  
 * @version:    1.0   
 * @since:  JDK 1.7.0_21  
 * Create at:   2015年3月25日 下午5:35:06   
 * Description:  旅行登入日志
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年3月25日 zhongJc      1.0     1.0 Version   
 */
@Controller
@RequestMapping(value="/system/travel_log")
public class TravelLoginLogController extends BaseController {
	
static Logger log=Logger.getLogger(TravelLoginLogController.class);
	
	private static final String view_travel_login_log="/system/log/travel_login_log";
	
	private WsLogLoginService wsLogLoginService;
	@Autowired
	public void setWsLogLoginService(WsLogLoginService wsLogLoginService) {
		this.wsLogLoginService = wsLogLoginService;
	}
	
	@RequestMapping(value="/travel_login_log.html")
	public ModelAndView listLog(HttpServletRequest request,HttpServletResponse response,@ModelAttribute WsLogLogin  wsLogLogin,BindingResult result) throws Exception{
		final ModelAndView mav=new ModelAndView(view_travel_login_log);
		final List<WsLogLogin> tlList=wsLogLoginService.queryWsLogLogins(wsLogLogin);
		mav.addObject("tlList", tlList);
		mav.addObject("wll", wsLogLogin);
		return mav;
	}
	
	@SuppressWarnings("static-access")
	@RequestMapping(value="/delete_login_log.html",params="json",method=RequestMethod.POST)
	@ResponseBody
	public String delete(HttpServletRequest request,HttpServletResponse response,@RequestParam("id") String id) throws Exception{		 
		 if(StringUtils.isNotBlank(id)){
 			log.info("delete MenuType id:"+id);
 			wsLogLoginService.deleteWsLogLoginById(id);
 			super.operatro_state_code_object.put(super.operator_state_code, "success");
 		}else{
 			super.operatro_state_code_object.put(super.operator_state_code, "fail");
 		}
		log.info(" Operator status#####:"+super.operatro_state_code_object.toString());
		return super.operatro_state_code_object.toString();
	}
	
	@InitBinder("wsLogLogin")
	public void initBinder(ServletRequestDataBinder binder) {              
		binder.setFieldDefaultPrefix("wll.");     
	} 
	

}
