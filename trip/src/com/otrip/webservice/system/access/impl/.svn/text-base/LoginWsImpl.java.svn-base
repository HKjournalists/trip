package com.otrip.webservice.system.access.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.QueryParam;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otrip.domain.DomainUtils;
import com.otrip.domain.system.SysUser;
import com.otrip.domain.ws.WsLogLogin;
import com.otrip.service.system.UserService;
import com.otrip.service.ws.WsLogLoginService;
import com.otrip.webservice.BaseWsService;
import com.otrip.webservice.system.access.LoginWs;
import com.otrip.webservice.util.WebServiceHelper;
import com.otrip.webservice.util.WsLoginSession;
/**
 * @see 登入服务信息
 * @author zhongJc
 */
@Service("loginWsImpl")
public class LoginWsImpl extends BaseWsService implements LoginWs {

	static Logger log=Logger.getLogger(LoginWsImpl.class);
	
	private WsLogLoginService wsLogLoginService;
	private UserService		  userService;
	
	@Autowired
	public void setWsLogLoginService(WsLogLoginService wsLogLoginService) {
		this.wsLogLoginService = wsLogLoginService;
	}
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	/**
	 * @see
	 * 1.将用户名和密码传入后台，进行验证；
	 * 2.查找是否有当前用户；
	 * 3.如果有当前用户，添加ws的登入记录；
	 * 4.将用户信息存入session；
	 * 5.同时以session的id为key，将session存入servlet context；
	 * 6.将session的id传回到前台
	 */
	@SuppressWarnings({ "static-access", "finally" })
	public String login(String paramjson) {
		final JSONObject loginFormJsonObj=JSONObject.fromObject(paramjson);
		final String account=loginFormJsonObj.getString("account");
		final String password=loginFormJsonObj.getString("password");
		
		final JSONObject returnObject=new JSONObject();
		returnObject.put(super.return_status, super.return_status_fail);
		final WsLoginSession wsLoginSession=new WsLoginSession();
		try{
			if(StringUtils.isNotBlank(account)&&StringUtils.isNotBlank(password)){
				final SysUser loginUser=userService.findUserByAccount(account);
				
				if(loginUser!=null&&password.equals(loginUser.getFsPassword())){
					final WsLogLogin wsLogLogin=new WsLogLogin();
					wsLogLogin.setFsIp(super.getRequest().getRemoteAddr());
					wsLogLogin.setFdLoginTime(new Date());
					wsLogLogin.setSysUser(loginUser);
					final String wsLogLoginId=DomainUtils.generalUuid();
					wsLogLogin.setFsId(wsLogLoginId);
					wsLogLoginService.saveLoginWs(wsLogLogin);
					
					wsLoginSession.setWsLogLoginId(wsLogLoginId);
					wsLoginSession.setSysUser(loginUser);
					wsLoginSession.setLoginUserId(loginUser.getFsId());
					wsLoginSession.setAccount(account);
					wsLoginSession.setEmail(StringUtils.isNotBlank(loginUser.getFsEmail())?loginUser.getFsEmail():"");
					wsLoginSession.setPhone(StringUtils.isNotBlank(loginUser.getFsPhone())?loginUser.getFsPhone():"");
					wsLoginSession.setUserName(StringUtils.isNotBlank(loginUser.getFsName())?loginUser.getFsName():"");
					
					final HttpSession session=super.getSession();
					wsLoginSession.setSession_id_key(session.getId());
					session.setAttribute(WebServiceHelper.getWsLoginSessionInfoToSessionKey(), wsLoginSession);
					super.getServletContext().setAttribute(session.getId(), session);
					returnObject.put(super.return_status, super.return_status_success);
					
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			log.debug("login is error!"+e.getStackTrace());
		}finally{
			JsonConfig config = new JsonConfig();
			config.setExcludes(new String[]{"sysUser"});//除去sysUser属性
			returnObject.put(super.return_user, JSONObject.fromObject(wsLoginSession,config).toString());
			log.info(" out information :"+returnObject.toString());
			return returnObject.toString();
		}

	}
	

}
