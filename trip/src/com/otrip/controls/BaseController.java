package com.otrip.controls;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.otrip.domain.system.SysLoginHistory;
import com.otrip.domain.system.SysUser;
import com.otrip.exception.CustomGenericException;
import com.otrip.security.LoginUser;
import com.otrip.security.LoginUserHelper;
import com.sun.beans.editors.DoubleEditor;
import com.sun.beans.editors.FloatEditor;
import com.sun.beans.editors.IntegerEditor;
import com.sun.beans.editors.LongEditor;
/**
 * @see 基础控制类
 * @author zhongJc
 *
 */
public class BaseController implements ServletContextAware {
	
	static Logger log=Logger.getLogger(BaseController.class);
	
	protected static final String operator_state_code="operatorStateCode";	//用户存储操作状态码
	protected static final JSONObject operatro_state_code_object = new JSONObject(); 
	
	private ServletContext servletContext;
	private WebApplicationContext webApplicationContext;
	private Locale locale;

	@Override
	public void setServletContext(ServletContext servletContext) {
		// TODO Auto-generated method stub
		this.servletContext=servletContext;
	}
	
	public WebApplicationContext getWebApplicationContext() {
		webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);  
		return webApplicationContext;
	}
	
	public Locale getLocale(HttpServletRequest request) {
		locale=RequestContextUtils.getLocaleResolver(request).resolveLocale(request);  
		return locale;
	}
	
	/**
	 * @see 获取国际化信息
	 * @param key
	 * @param request
	 * @param args
	 * @return
	 */
	public String getMessage(String key,HttpServletRequest request,Object [] args){
		getWebApplicationContext();
		getLocale(request);
		final String message=webApplicationContext.getMessage(key,args, null, locale);  
		return message;
	}
	
	/**
	 * @see 输出json数据
	 * @param response
	 * @param text
	 */
	public static void renderJson(HttpServletResponse response, String text){
		response.setContentType("application/json;charset=UTF-8");
	    response.setHeader("Pragma", "No-cache");
	    response.setHeader("Cache-Control", "no-cache");
	    response.setDateHeader("Expires", 0);
	    try{
	    	response.getWriter().write(text);
	    }catch(IOException e){
	    	log.error(e.getMessage(), e); 
	    }
	 }
	
	/**
	 * @see 输出text数据
	 * @param response
	 * @param text
	 */
	public static void renderText(HttpServletResponse response, String text){
		response.setContentType("application/text;charset=UTF-8");
	    response.setHeader("Pragma", "No-cache");
	    response.setHeader("Cache-Control", "no-cache");
	    response.setDateHeader("Expires", 0);
	    try{
	    	response.getWriter().write(text);
	    }catch(IOException e){
	    	log.error(e.getMessage(), e); 
	    }
	 }
	
	/**
	 * @see 获取登入用户所有权限对象
	 * @param request
	 * @return
	 */
	public LoginUser currentLoginUser(HttpServletRequest request){
		Object o=request.getSession().getAttribute(LoginUserHelper.LOGIN_SECURITY_CONTENT);
		if(o!=null){
			return (LoginUser)o;
		}
		return null;
	}
	
	/**
	 * @see 获取登入用户对象
	 * @param request
	 * @return
	 */
	public SysUser currentSysUser(HttpServletRequest request){
		Object o=request.getSession().getAttribute(LoginUserHelper.session_login_user_key);
		if(o!=null){
			return (SysUser)o;
		}
		return null;
	}
	
	/**
	 * @see 获取登入用户对象
	 * @param request
	 * @return
	 */
	public SysLoginHistory currentLoginHistory(HttpServletRequest request){
		Object o=request.getSession().getAttribute(LoginUserHelper.LOGIN_CURRENT_USER_HISTORY);
		if(o!=null){
			return (SysLoginHistory)o;
		}
		return null;
	}
	
	
	/*******************************************************
	 * 进行异常处理
	 *******************************************************/
	
    // 这里处理自定义的业务异常，当有 CustomGenericException 抛出时会执行.
    @ExceptionHandler(CustomGenericException.class)
    public ModelAndView handleCustomException(CustomGenericException ex) {
        ModelAndView model = new ModelAndView("redirect:/exception.html");
        model.addObject("errCode", ex.getErrCode());
        model.addObject("errMsg", ex.getErrMsg());
        return model;
    }
  
        // 处理所有异常，自定义异常之外的异常都执行到这里.
    @ExceptionHandler(Exception.class)
    public ModelAndView handleAllException(Exception ex) {
        ModelAndView model = new ModelAndView("redirect:/exception.html");
        model.addObject("errCode","common");
        model.addObject("errMsg", "this is Exception.class");
        return model;
    }
    
    /**
     * @see 获取当前请求的menu的Id
     * @param request
     * @return
     */
    public static String getCurrentMenuId(HttpServletRequest request){
    	if(request!=null){
    		final Object o=request.getParameter(ControlsHelper.current_request_menu_id);
    		if(o!=null){
    			return String.valueOf(o);
    		}
    	}
    	return null;
    }
    


}
