package com.otrip.controls.layout;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.otrip.controls.BaseController;

/**
 * @see 错误控制类
 * @author Administrator
 *
 */

@Controller
public class OtripErrorController extends BaseController{
	
	static Logger log=Logger.getLogger(OtripErrorController.class);
	
	private static final String view_error="/general/error";
	private static final String	view_access_denied="/general/denied";
	
	/**
	 * @see 错误页面
	 * @return
	 */
	@RequestMapping("/error.html")
	private ModelAndView error(){
		System.out.println("出错了.......................");
		ModelAndView mav=new ModelAndView(view_error);
		return mav;
	}
	
	/**
	 * @see 没有访问权限
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/access_denied.html")  
	public ModelAndView accessDenied(ModelMap model,HttpServletRequest request){  
		Object objAde = request.getAttribute("SPRING_SECURITY_403_EXCEPTION");  
		String errorMessage="";
		if(null != objAde){  
			AccessDeniedException adx = (AccessDeniedException)objAde;
			if(StringUtils.isNotBlank(adx.getMessage())){
				errorMessage=adx.getMessage();
			}
		} 
		if(!StringUtils.isNotBlank(errorMessage)){
			Object errorTempMessage=request.getAttribute("jsonExceptiont");
			if(errorTempMessage!=null&&StringUtils.isNotBlank(errorTempMessage.toString())){
				errorMessage=errorTempMessage.toString();
			}
		}
		
		if(!StringUtils.isNotBlank(errorMessage)){
			errorMessage="系统异常";
		}
		
		model.put("errorMessage", errorMessage);
		return new ModelAndView(view_access_denied, model);  
	}  
}
