package com.otrip.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * @see springMVC的异常处理
 * @author Administrator
 *
 */
public class ExceptionHandler implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		// TODO Auto-generated method stub
		if(ex instanceof NullPointerException){
			return new ModelAndView("null");
		}else if(ex instanceof NumberFormatException){
			return new ModelAndView("number");
		}else if(ex instanceof AccessDeniedException){
			return new ModelAndView("redirect:/access_denied.html");
		}
		return null;
	}

}
