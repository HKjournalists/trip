package com.otrip.controls.verify;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.otrip.controls.BaseController;
import com.otrip.domain.system.SysLoginHistory;
import com.otrip.security.LoginUserHelper;
import com.otrip.service.system.AccessService;

/**
 * @see 登出
 * @author Administrator
 *
 */

@Controller
public class VerifyLogoutController extends BaseController{
	
	static Logger log=Logger.getLogger(VerifyLogoutController.class);
	
	private static final String view_login="redirect:/login.html";
	private static final String act_logout="redirect:/logout.html";
	
	private AccessService accessService;
	@Autowired
	public void setAccessService(AccessService accessService) {
		this.accessService = accessService;
	}
	
	/**
	 * @see 开始登出
	 * @return
	 */
	@RequestMapping("/logout_exits.html")
	public ModelAndView logoutExits(HttpServletRequest request){
		ModelAndView mav=new ModelAndView(act_logout);
		Object lcuho=request.getSession().getAttribute(LoginUserHelper.LOGIN_CURRENT_USER_HISTORY);
		if(lcuho!=null){
			SysLoginHistory loginUserHistory=(SysLoginHistory)lcuho;
			accessService.updateLoginHistoryLogoutTime(loginUserHistory.getFsId());
		}
		HttpSession currentSession=request.getSession(false);
		if(currentSession!=null){
			currentSession.invalidate();
		}
		return mav;
	}
	
	/**
	 * @see security 最终退出
	 * @param request
	 * @return
	 */
	@RequestMapping("/logout.html")
	public ModelAndView logout(HttpServletRequest request){
		ModelAndView mav=new ModelAndView(view_login);
		Object lcuho=request.getSession().getAttribute(LoginUserHelper.LOGIN_CURRENT_USER_HISTORY);
		if(lcuho!=null){
			SysLoginHistory loginUserHistory=(SysLoginHistory)lcuho;
			accessService.updateLoginHistoryLogoutTime(loginUserHistory.getFsId());
		}
		HttpSession currentSession=request.getSession(false);
		if(currentSession!=null){
			currentSession.invalidate();
		}
		return mav;
	}
}
