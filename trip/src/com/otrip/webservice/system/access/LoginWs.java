package com.otrip.webservice.system.access;

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
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import org.json.JSONException;

import com.otrip.domain.system.SysUser;


@WebService
@Path("/") 
public interface LoginWs {
	
	@WebMethod
	@WebResult(name = "return", targetNamespace = "http://www.otrip.net/") 
	
	/*@GET    
	@Produces (MediaType.TEXT_PLAIN)    
	@Path("/login/paramjson={paramjson}")
	public String login(@WebParam(name = "paramjson" ) @PathParam("paramjson")String paramjson) throws Exception;*/
	@GET    
	@Produces (MediaType.TEXT_PLAIN)    
	@Path("/login")
	public String login(@WebParam(name = "paramjson" ) @QueryParam("paramjson")String paramjson) throws Exception;

	/*
	@GET
	@Produces (MediaType.TEXT_PLAIN)    
	@Path("/loginws?paramjson={paramjson}")
	public String loginws(@WebParam(name = "paramjson" ) @QueryParam("paramjson")String paramjson) throws Exception;
	*/
}
