package com.otrip.controls.layout;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.otrip.controls.BaseController;

/**
 * @see 异常处理控制类
 * @author Administrator
 *
 */
@Controller
public class OtripExceptionController extends BaseController{

	static Logger log=Logger.getLogger(OtripExceptionController.class);
	
	private static final String view_exception="/general/exception";
	
	@RequestMapping(value="/exception.html")
	public ModelAndView exceptionView(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav=new ModelAndView(view_exception);
		mav.addObject("errCode",request.getParameter("errCode"));
        mav.addObject("errMsg", request.getParameter("errMsg"));
        log.info("Exception code:"+request.getParameter("errCode"));
        log.info("Exception msg:"+request.getParameter("errMsg"));
		return mav;
	}
	
}
