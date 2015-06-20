package com.otrip.controls.warn;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.otrip.controls.BaseController;
import com.otrip.controls.verify.VerifyLoginController;
import com.sun.net.httpserver.HttpServer;

/**
 * @see 消息提醒菜单
 * @author zhongJc
 *
 */

@Controller
@RequestMapping(value="/warn")
public class WarnMainController extends BaseController {

	static Logger log=Logger.getLogger(WarnMainController.class);
	
	private static final String view_warn_menu="/warn/menu";
	private static final String view_warn_default="/warn/default";

	/**
	 * @see 消息菜单左边界面进入
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/menu.html")
	public ModelAndView leftMenu(HttpServletRequest request) throws Exception{
		ModelAndView view=new ModelAndView(view_warn_menu);
		return view;
	}
	
	@RequestMapping(value="/default.html")
	public ModelAndView rightDefault(HttpServletRequest request) throws Exception{
		ModelAndView view=new ModelAndView(view_warn_default);
		return view;
	}
	
}
