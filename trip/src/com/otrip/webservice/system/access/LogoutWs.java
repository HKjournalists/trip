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

import org.json.JSONException;

@WebService
@Path("/") 
public interface LogoutWs {
	
	@WebMethod
	@WebResult(name = "return", targetNamespace = "http://www.otrip.net/") 
	
	@GET    
	@Produces (MediaType.TEXT_PLAIN)    
	@Path("/logout")
	public String logout(@WebParam(name = "paramjson" ) @QueryParam("paramjson")String paramjson) throws Exception;

}
