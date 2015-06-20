package com.otrip.controls.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.otrip.controls.BaseController;

/**
 * @see 系统设置管理
 * @author Administrator
 */
@Controller
@RequestMapping(value="/system")
public class SystemMainController extends BaseController {

	static Logger log=Logger.getLogger(SystemMainController.class);
	
	private static final String view_menu_left="/system/menu_left";
	private static final String view_main_content="/system/main_content";
	
	/**
	 * @see 系统设置管理左边菜单
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/menu_left.html")
	public ModelAndView menuLeft(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav=new ModelAndView(view_menu_left);
		return mav;
	}
	
	/**
	 * @see 系统设置管理左边菜单
	 * @param request
	 * @param response
	 * @return 
	 */
	@RequestMapping(value="/main_content.html")
	public ModelAndView mainContent(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav=new ModelAndView(view_main_content);
		return mav;
	}
	
	
}
