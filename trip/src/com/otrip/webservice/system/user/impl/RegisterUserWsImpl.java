package com.otrip.webservice.system.user.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
import com.otrip.util.OtripConstants;
import com.otrip.webservice.BaseWsService;
import com.otrip.webservice.system.user.RegisterUserWs;
import com.otrip.webservice.util.WebServiceHelper;
import com.otrip.webservice.util.WsLoginSession;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;
/**
 * @see 开始注册用户
 * @author Administrator
 *
 */
@Service("registerUserWsImpl")
public class RegisterUserWsImpl extends BaseWsService  implements RegisterUserWs {
	
	private static Logger log=Logger.getLogger(RegisterUserWsImpl.class); 
	@Autowired
	private WsLogLoginService wsLogLoginService;
	public void setWsLogLoginService(WsLogLoginService wsLogLoginService) {
		this.wsLogLoginService = wsLogLoginService;
	}
	private UserService userService;
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	/**
	 * @see 注册用户
	 */
	@SuppressWarnings({ "static-access", "finally" })
	public String register(String paramjson)  {
		final JSONObject regFormJsonObj=JSONObject.fromObject(paramjson);
		final JSONObject returnObject=new JSONObject();
		final Map<String,Object> returnMap=new HashMap<String,Object>();
		returnObject.put(super.return_status, super.return_status_fail);
		
		SysUser sysUser=null;
		final Map<String,String> returnUserMap=new HashMap<String,String>();
		try {
			if(regFormJsonObj!=null&&StringUtils.isNotBlank(regFormJsonObj.getString("email"))&&StringUtils.isNotBlank(regFormJsonObj.getString("password"))){
				final SysUser isRegiterUser=userService.findUserByAccount(regFormJsonObj.getString("email"));
				final boolean isExist=isRegiterUser!=null&&StringUtils.isNotBlank(isRegiterUser.getFsId())?true:false;
				if(isExist==false){
					final SysUser regUser=new SysUser();
					regUser.setFsAccount(StringUtils.isNotBlank(regFormJsonObj.getString("email"))?regFormJsonObj.getString("email"):null);
					regUser.setFsName(StringUtils.isNotBlank(regFormJsonObj.getString("email"))?regFormJsonObj.getString("email"):null);
					regUser.setFsEmail(StringUtils.isNotBlank(regFormJsonObj.getString("email"))?regFormJsonObj.getString("email"):null);
					regUser.setFsPassword(StringUtils.isNotBlank(regFormJsonObj.getString("password"))?regFormJsonObj.getString("password"):null);
					regUser.setFsTypeSign(OtripConstants.getWsFrontUserTypeSign());
					regUser.setFsStatus("1");
					regUser.setFdCreateTime(new Date());
					regUser.setFdRegisterDate(new Date());
					
					sysUser = userService.saveWsSysUser(regUser);
					final String account=StringUtils.isNotBlank(regFormJsonObj.getString("email"))?regFormJsonObj.getString("email"):null;
					final SysUser loginUser=userService.findUserByAccount(account);
					final WsLogLogin wsLogLogin=new WsLogLogin();
					final WsLoginSession wsLoginSession=new WsLoginSession();
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
					
					
					returnUserMap.put("account", sysUser!=null&&StringUtils.isNotBlank(sysUser.getFsAccount())?sysUser.getFsAccount():"");
					returnUserMap.put("name", sysUser!=null&&StringUtils.isNotBlank(sysUser.getFsName())?sysUser.getFsName():"");
					returnUserMap.put("phone", sysUser!=null&&StringUtils.isNotBlank(sysUser.getFsPhone())?sysUser.getFsPhone():"");
					returnUserMap.put("email", sysUser!=null&&StringUtils.isNotBlank(sysUser.getFsEmail())?sysUser.getFsEmail():"");
					returnUserMap.put("session_id_key", wsLoginSession.getSession_id_key());
					returnUserMap.put("loginUserId", wsLoginSession.getLoginUserId());
					returnUserMap.put("userName", wsLoginSession.getUserName());
					returnObject.put(super.return_status, super.return_status_success);
					log.info(" register success");
				}else{
					log.info(" register fail,user is exist!");
				}
			}else{
				log.info(" register fail,email or password is null!");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("register is error!"+e.getStackTrace());
		}finally{
			
			returnMap.put(super.return_user, returnUserMap);
			
			returnObject.putAll(returnMap);
			log.info(" out the result info:"+returnObject.toString());
			return returnObject.toString();
		}
	}

}
