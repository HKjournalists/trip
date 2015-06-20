package com.otrip.webservice.system.user;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;

import com.otrip.domain.system.SysUser;

/**
 * @see 注册用户接口
 * @author zhongJc
 *
 */
@WebService
@Path("/") 
public interface RegisterUserWs {
	
	@WebMethod
	@WebResult(name = "return", targetNamespace = "http://www.otrip.net/") 
	
	@GET    
	@Produces (MediaType.TEXT_PLAIN)    
	@Path("/register")
	public String register(@WebParam(name = "paramjson") @QueryParam("paramjson")String paramjson) ;
	
	
}
