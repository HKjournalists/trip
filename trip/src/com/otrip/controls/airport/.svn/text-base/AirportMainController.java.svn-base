package com.otrip.controls.airport;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.otrip.controls.BaseController;
import com.otrip.controls.verify.VerifyLoginController;
import com.sun.net.httpserver.HttpServer;

/**
 * @see 接机主界面界面菜单
 * @author zhongJc
 *
 */

@Controller
@RequestMapping(value="/airport")
public class AirportMainController extends BaseController {

	static Logger log=Logger.getLogger(AirportMainController.class);
	
	private static final String view_airport_menu="/airport/menu";
	private static final String view_airport_default="/airport/default";

	/**
	 * @see 接机菜单左边界面进入
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/menu.html")
	public ModelAndView leftMenu(HttpServletRequest request) throws Exception{
		ModelAndView view=new ModelAndView(view_airport_menu);
		return view;
	}
	
	/**
	 * @see 右边默认界面
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/default.html")
	public ModelAndView rightDefault(HttpServletRequest request) throws Exception{
		ModelAndView view=new ModelAndView(view_airport_default);
		return view;
	}
	
}
