package com.otrip.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.web.servlet.ModelAndView;

/**
 * @see 异常处理类
 * @author Administrator
 */
public class OtripAccessDeniedHandlerImpl implements AccessDeniedHandler {
	public OtripAccessDeniedHandlerImpl(){  
          
    }  
    public String getAccessDeniedUrl() {  
        return accessDeniedUrl;  
    }  
  
    private String accessDeniedUrl;
    
    public void setAccessDeniedUrl(String accessDeniedUrl) {  
        this.accessDeniedUrl = accessDeniedUrl;  
    }  
  
    public OtripAccessDeniedHandlerImpl(String accessDeniedUrl)  {  
    	this.accessDeniedUrl=accessDeniedUrl;  
    }  
      
      
    @Override  
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws ServletException,IOException {  
        boolean isAjax = "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));  
        //如果是ajax请求  
        if (isAjax) {         
            String jsonExceptiont = accessDeniedException.getMessage();  
            String contentType = "application/json";  
            response.setContentType(contentType);   
            PrintWriter out = response.getWriter();  
            out.print(jsonExceptiont);  
            out.flush();  
            out.close();  
            return;  
        }else{  
        	
        	String jsonExceptiont = accessDeniedException.getMessage();  
        	request.setAttribute("SPRING_SECURITY_403_EXCEPTION", accessDeniedException);
        	request.setAttribute("jsonExceptiont", jsonExceptiont);
        	request.getRequestDispatcher(accessDeniedUrl).forward(request, response); 
        }  
    }

}
