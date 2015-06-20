package com.otrip.webservice;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Context;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.apache.commons.lang3.StringUtils;

/**
 * @see ws的基本服务类
 * @author Administrator
 *
 */
public abstract class BaseWsService {
	
	@Context    
	private WebServiceContext restContext;  
	@Resource
	private WebServiceContext wsContext;  
	
	private MessageContext mc;      
	private HttpSession session; 
	private HttpServletRequest request;
	
	@Context   
	private HttpServletRequest restRequest;
	
	
	private ServletContext	servletContext;
	
	/*************************************************
	 * @see 获取WS的消息上下文
	 * @return
	 *************************************************/
	public MessageContext getMessageContext(){
		if(restContext!=null&&StringUtils.isNotBlank(restContext.toString())){
			mc=restContext.getMessageContext();   
		}else if(wsContext!=null&&StringUtils.isNotBlank(wsContext.toString())){
			mc=wsContext.getMessageContext();  
		}
		return mc;
	}
	
	public HttpSession getSession(){
		if(mc==null){
			getMessageContext();
		}
		session =getRequest().getSession();          
		return session;
	}
	
	public WebServiceContext getWebServiceContext(){
		if(restContext!=null&&StringUtils.isNotBlank(restContext.toString())){
			return restContext;   
		}else if(wsContext!=null&&StringUtils.isNotBlank(wsContext.toString())){
			return wsContext;
		}
		return null;
	}
	
	public HttpServletRequest getRequest(){
		if(mc==null){
			getMessageContext();
		}
		if(mc!=null&&StringUtils.isNotBlank(mc.toString())){
			return ((javax.servlet.http.HttpServletRequest) mc.get(MessageContext.SERVLET_REQUEST));
		}else{
			return restRequest;
		}
		
	}
	
	public ServletContext getServletContext(){
		if(mc==null){
			getMessageContext();
		}
		if(mc!=null&&StringUtils.isNotBlank(mc.toString())){
			servletContext=((javax.servlet.ServletContext) mc.get(MessageContext.SERVLET_CONTEXT));
		}else{
			servletContext=getRequest().getServletContext();
		}
		
		return servletContext;
	}
	/*********************************************
	 * @see 定义常量
	 *********************************************/
	protected static final String   return_status="status";	//返回的JSON操纵状态状态
	protected static final String 	return_status_success="1";	//成功
	protected static final String 	return_status_fail="0";	//失败

	protected static final String   return_user="user";	//返回的JSON用户对象标示
	protected static final String 	return_actiInfo="actiInfo";//返回回活动详情

}
