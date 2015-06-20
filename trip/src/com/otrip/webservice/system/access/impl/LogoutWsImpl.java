package com.otrip.webservice.system.access.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otrip.domain.system.SysUser;
import com.otrip.domain.ws.WsLogLogin;
import com.otrip.service.ws.WsLogLoginService;
import com.otrip.webservice.BaseWsService;
import com.otrip.webservice.system.access.LogoutWs;
import com.otrip.webservice.util.WebServiceHelper;
import com.otrip.webservice.util.WsLoginSession;

/**
 * @see WS登出服务
 * @author zhongJc
 */

@Service("logoutWsImpl")
public class LogoutWsImpl extends BaseWsService implements LogoutWs {
	static Logger log=Logger.getLogger(LogoutWsImpl.class);
	
	private WsLogLoginService	wsLogLoginService;
	@Autowired
	public void setWsLogLoginService(WsLogLoginService wsLogLoginService) {
		this.wsLogLoginService = wsLogLoginService;
	}
	
	/**
	 * @see 
	 * 1.要求传入 ws_login_session_to_content_key =session id的值传入【session id对应登入用户的sessionid，也就是说以sesion的id为存入servletContext的存入session的id】；
	 * 2.然后在getServletContext找到对应的session，通过传入的session id
	 * 	
	 */
	@SuppressWarnings({ "static-access", "finally" })
	public String logout(String paramjson){
		final JSONObject returnObject=new JSONObject();
		returnObject.put(super.return_status, super.return_status_fail);
		try{
			if(StringUtils.isNotBlank(paramjson)){
				JSONObject logoutFormJsonObj=JSONObject.fromObject(paramjson);
				final String logoutSessionIdKey=logoutFormJsonObj!=null?logoutFormJsonObj.getString(WebServiceHelper.getWsLoginSessionToContentKey()):null;
				if(StringUtils.isNotBlank(logoutSessionIdKey)){
					final Object loginSessionObject=super.getServletContext().getAttribute(logoutSessionIdKey);
					if(loginSessionObject!=null){
						HttpSession session=(HttpSession)loginSessionObject;
						final WsLoginSession wsLoginSession =session.getAttribute(WebServiceHelper.getWsLoginSessionInfoToSessionKey())!=null?(WsLoginSession)session.getAttribute(WebServiceHelper.getWsLoginSessionInfoToSessionKey()):null;;
						if(wsLoginSession!=null){
							final SysUser loginSysUser=wsLoginSession!=null?wsLoginSession.getSysUser():null;
							final WsLogLogin logoutWsLogLogin=new WsLogLogin();
							logoutWsLogLogin.setSysUser(loginSysUser);
							final String wsLogLoginId=wsLoginSession.getWsLogLoginId();
							if(StringUtils.isNotBlank(wsLogLoginId)){
								logoutWsLogLogin.setFsId(wsLogLoginId);
							}
							wsLogLoginService.updateLogoutWs(logoutWsLogLogin);
						}
						session.invalidate();
						returnObject.put(super.return_status, super.return_status_success);
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			log.debug("register is error!"+e.getStackTrace());
		}finally{
			log.info("return info:"+returnObject.toString());
			return returnObject.toString();
		}
	}

}
