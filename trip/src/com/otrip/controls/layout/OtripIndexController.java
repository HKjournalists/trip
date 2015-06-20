package com.otrip.controls.layout;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.otrip.controls.BaseController;
import com.otrip.domain.system.SysUser;
import com.otrip.initdata.datacache.SystemDataCache;
import com.otrip.security.LoginUser;
import com.otrip.security.LoginUserHelper;

/**
 * @see 索引主页
 * @author Administrator
 */
@Controller
public class OtripIndexController extends BaseController{

	static Logger log=Logger.getLogger(OtripIndexController.class);
	
	private static final String view_index="/layout/index";
	private static final String view_top="/layout/top";
	private static final String view_left="/layout/left";
	private static final String view_main="/layout/main";
	
	@RequestMapping("/index.html")
	public ModelAndView otrip(){
		ModelAndView mav=new ModelAndView(view_index);
		return mav;
	}
	
	/**
	 * @see 进入顶部
	 * @return
	 */
	@RequestMapping("/otrip_top.html")
	public ModelAndView otripTop(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav=new ModelAndView(view_top);
		final SysUser user=super.currentSysUser(request);
		mav.addObject("loginUser", user);
		mav.addObject("mainSystem", SystemDataCache.getSysMain()!=null&&SystemDataCache.getSysMain().size()>0?SystemDataCache.getSysMain().get(0):null);
		mav.addObject("childSystem", SystemDataCache.getSysChild());
		return mav;
	}
	
	/**
	 * @see 进入左边
	 * @return
	 */
	@RequestMapping("/otrip_left.html")
	public ModelAndView otripLeft() {
		ModelAndView mav=new ModelAndView(view_left);
		System.out.println("打开你顶部....");
		return mav;
	}
	
	/**
	 * @see 进入左边
	 * @return
	 */
	@RequestMapping("/otrip_main.html")
	public ModelAndView otripMain() {
		ModelAndView mav=new ModelAndView(view_main);
		System.out.println("打开你顶部....");
		return mav;
	}
	
	
}
