package com.otrip.security;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import com.otrip.domain.system.SysLoginHistory;
import com.otrip.domain.system.SysUser;
/**
 * @see 用户登入帮助类
 * @author Administrator
 *
 */
public class LoginUserHelper {
	static Logger log=Logger.getLogger(LoginUserHelper.class);
	
	/**************************************
	 * @see session 保存用户sessoion
	 **************************************/
	public static final String session_login_user_key="session_login_user_key";

	/*******************
	 * @SEE 登入内容标致
	 *******************/
	public static final String LOGIN_SECURITY_CONTENT="SPRING_SECURITY_CONTEXT";
	
	/********************************
	 * @see 登入当前用户的历史
	 *********************************/
	public static final String LOGIN_CURRENT_USER_HISTORY="login_current_user_history";
	
	
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
	
}
