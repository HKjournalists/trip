package com.otrip.controls.trip;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.otrip.controls.BaseController;
import com.otrip.controls.verify.VerifyLoginController;
import com.sun.net.httpserver.HttpServer;

/**
 * @see 旅行管理界面
 * @author zhongJc
 *
 */

@Controller
@RequestMapping(value="/trip")
public class TripMainController extends BaseController {

	static Logger log=Logger.getLogger(TripMainController.class);
	
	private static final String view_trip_menu="/trip/menu";
	private static final String view_trip_default="/trip/default";
	

	/**
	 * @see 旅行管理菜单左边界面进入
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/menu.html")
	public ModelAndView leftMenu(HttpServletRequest request) throws Exception{
		ModelAndView view=new ModelAndView(view_trip_menu);
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
		ModelAndView view=new ModelAndView(view_trip_default);
		return view;
	}
	
}
