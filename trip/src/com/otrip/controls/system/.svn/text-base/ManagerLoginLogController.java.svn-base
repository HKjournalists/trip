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
import com.otrip.domain.system.SysLoginHistory;
import com.otrip.domain.ws.WsLogLogin;
import com.otrip.service.system.LoginHistoryService;

/**   
 * Filename:    ManagerLoginLogController.java   
 * Copyright:   Copyright (c)2015  
 * Company:     otrip  
 * @version:    1.0   
 * @since:  JDK 1.7.0_21  
 * Create at:   2015年3月25日 下午5:34:25   
 * Description:  管理员登入日志管理
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年3月25日 zhongJc      1.0     1.0 Version   
 */
@Controller
@RequestMapping(value="/system/manager_log")
public class ManagerLoginLogController extends BaseController {
	static Logger log=Logger.getLogger(ManagerLoginLogController.class);
	
	private static final String view_manager_login_log="/system/log/manager_login_log";
	
	private LoginHistoryService loginHistoryService;
	@Autowired
	public void setLoginHistoryService(LoginHistoryService loginHistoryService) {
		this.loginHistoryService = loginHistoryService;
	}
	
	
	@RequestMapping(value="/manager_login_log.html")
	public ModelAndView listLog(HttpServletRequest request,HttpServletResponse response,@ModelAttribute SysLoginHistory  sysLoginHistory,BindingResult result) throws Exception{
		final ModelAndView mav=new ModelAndView(view_manager_login_log);
		final List<SysLoginHistory> lhList=loginHistoryService.querySysLoginHistories(sysLoginHistory);
		mav.addObject("lhList", lhList);
		mav.addObject("lh", sysLoginHistory);
		return mav;
	}
	
	@SuppressWarnings("static-access")
	@RequestMapping(value="/delete_login_log.html",params="json",method=RequestMethod.POST)
	@ResponseBody
	public String delete(HttpServletRequest request,HttpServletResponse response,@RequestParam("id") String id) throws Exception{		 
		 if(StringUtils.isNotBlank(id)){
 			log.info("delete MenuType id:"+id);
 			loginHistoryService.deleteSysLoginHistory(id);
 			super.operatro_state_code_object.put(super.operator_state_code, "success");
 		}else{
 			super.operatro_state_code_object.put(super.operator_state_code, "fail");
 		}
		log.info(" Operator status#####:"+super.operatro_state_code_object.toString());
		return super.operatro_state_code_object.toString();
	}
	
	
	@InitBinder("sysLoginHistory")
	public void initBinder(ServletRequestDataBinder binder) {              
		binder.setFieldDefaultPrefix("lh.");     
	} 
	

}
