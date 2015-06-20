package com.otrip.webservice.test;   

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**   
 * Filename:    Rest_HelloWorld.java   
 * Copyright:   Copyright (c)2015  
 * Company:     otrip  
 * @version:    1.0   
 * @since:  JDK 1.7.0_21  
 * Create at:   2015年3月22日 下午12:07:09   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年3月22日 zhongJc      1.0     1.0 Version   
 */

@WebService
@Path("/rest_HelloWorld") 
public interface  Rest_HelloWorld {
	
	@WebMethod
	@WebResult(name = "return", targetNamespace = "http://www.otrip.net/") 
	
   @GET    
   @Produces (MediaType.TEXT_PLAIN)    
   @Path("/say/{name}")    
   public String say(@WebParam(name = "name") @PathParam("name")String name);   
      
 


}
