package com.otrip.controls.verify;

import java.util.Date;

import javax.security.sasl.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.otrip.controls.BaseController;
import com.otrip.domain.system.SysLoginHistory;
import com.otrip.domain.system.SysUser;
import com.otrip.security.LoginUserHelper;
import com.otrip.service.system.AccessService;
import com.otrip.util.Common;

/**
 * @see 登入控制器
 * @author zhongJc
 */

@Controller
public class VerifyLoginController extends BaseController{
	
	static Logger log=Logger.getLogger(VerifyLoginController.class);
	
	private static final String view_login="/login";
	private static final String act_index="redirect:/index.html";
	private static final String act_login="redirect:/login.html";
	
	
	private AccessService accessService;
	private AuthenticationManager usernamePasswordProcessingFilter;
	@Autowired
	public void setAccessService(AccessService accessService) {
		this.accessService = accessService;
	}
	@Autowired
	public void setUsernamePasswordProcessingFilter(AuthenticationManager usernamePasswordProcessingFilter) {
		this.usernamePasswordProcessingFilter = usernamePasswordProcessingFilter;
	}
	
	/**
	 * @see 登入前先清除旧的session
	 * @param request
	 * @return
	 */
	@RequestMapping("/login.html")
	public ModelAndView validate(HttpServletRequest request){
		ModelAndView mav=new ModelAndView(view_login);
		Object lsc = request.getSession().getAttribute(LoginUserHelper.LOGIN_SECURITY_CONTENT);
		if(null != lsc){
			request.getSession().removeAttribute(LoginUserHelper.LOGIN_SECURITY_CONTENT);
		}
		Object sluk = request.getSession().getAttribute(LoginUserHelper.session_login_user_key);
		if(null != sluk){
			request.getSession().removeAttribute(LoginUserHelper.session_login_user_key);
			
			Object lcuho=request.getSession().getAttribute(LoginUserHelper.LOGIN_CURRENT_USER_HISTORY);
			if(lcuho!=null){
				SysLoginHistory loginUserHistory=(SysLoginHistory)lcuho;
				accessService.updateLoginHistoryLogoutTime(loginUserHistory.getFsId());
			}
		}
		return mav;
	}
	
	@RequestMapping("/login_validate.html")
	public ModelAndView input(String username,String password,HttpServletRequest request){
		ModelAndView mav=new ModelAndView(act_index);
		try {
			if (!request.getMethod().equals("POST")) {
				request.setAttribute("error","支持POST方法提交！");
			}
			if (Common.isEmpty(username) || Common.isEmpty(password)) {
				request.setAttribute("error","用户名或密码不能为空！");
				mav.setViewName(act_login);
				return mav;
			}
			// 验证用户账号与密码是否正确
			final SysUser sysUser=accessService.findUserByAccount(username);
			if (sysUser == null || !sysUser.getFsPassword().equals(password)) {
				request.setAttribute("error", "用户或密码不正确！");
				mav.setViewName(act_login);
			    return mav;
			}
			Authentication authentication = usernamePasswordProcessingFilter.authenticate(new UsernamePasswordAuthenticationToken(username,password));
			SecurityContext securityContext = SecurityContextHolder.getContext();
			securityContext.setAuthentication(authentication);
			HttpSession session = request.getSession(true);  
		    session.setAttribute(LoginUserHelper.LOGIN_SECURITY_CONTENT, securityContext);  
		    // 当验证都通过后，把用户信息放在session里
			request.getSession().setAttribute(LoginUserHelper.session_login_user_key, sysUser);
			// 记录登录信息
			SysLoginHistory loginUserHistory=new SysLoginHistory();
			loginUserHistory.setFsIp(Common.toIpAddr(request));
			loginUserHistory.setFdLoginTime(new Date());
			loginUserHistory.setSysUser(sysUser);
			accessService.updateOldLoginHistoryTimeIsNull(sysUser.getFsId());
			loginUserHistory=accessService.addLoginHistory(loginUserHistory);
			request.getSession().setAttribute(LoginUserHelper.LOGIN_CURRENT_USER_HISTORY, loginUserHistory);
		} catch (Exception ae) {  
			mav.setViewName(act_login);
		    return mav;
		}
		return mav;
	}
}
