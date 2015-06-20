package com.otrip.webservice.trip.acti;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


@WebService
@Path("/")
public interface GetUserZoneWs {
	
	/**
	 * 点击搜藏，查看用户收藏的活动
	 * @param actiId
	 * @param page
	 * @param num
	 * @return
	 */
	@WebMethod
	@WebResult(name = "return", targetNamespace = "http://www.otrip.net/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/getFavouritesByUser")
	public String getFavouritesByUser(
			@WebParam(name="paramjson") @QueryParam("paramjson") String paramjson);
			
	/**
	 * 提问，点击提问，查看用户的提问
	 * @param actiId
	 * @param page
	 * @param num
	 * @return
	 */
	@WebMethod
	@WebResult(name = "return", targetNamespace = "http://www.otrip.net/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/getProblemsByUser")
	public String getProblemsByUser(
			@WebParam(name="userId") @QueryParam("userId") String actiId,
			@WebParam(name="page") @QueryParam("page") String page,
		  @WebParam(name="num") @QueryParam("num") String num);
	
	/**
	 * 查看用户评论
	 * @param actiId
	 * @param page
	 * @param num
	 * @return
	 */
	@WebMethod
	@WebResult(name = "return", targetNamespace = "http://www.otrip.net/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/getDiscussByUser")
	public String getDiscussByUser(
			@WebParam(name="paramjson") @QueryParam("paramjson") String paramjson);
		//	@WebParam(name="userId") @QueryParam("userId") String userId,
			//@WebParam(name="page") @QueryParam("page") String page,
		//  @WebParam(name="num") @QueryParam("num") String num);
	
	/**
	 * 
	 * @param actiId
	 * @param page
	 * @param num
	 * @return
	 */
	@WebMethod
	@WebResult(name = "return", targetNamespace = "http://www.otrip.net/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/postAdvice")
	public String postAdvice(
			@WebParam(name="userId") @QueryParam("userId") String actiId,
			@WebParam(name="content") @QueryParam("content") String page,
		  @WebParam(name="tel") @QueryParam("tel") String num);
	
	
	/**
	 * 
	 * @param actiId
	 * @param page
	 * @return
	 */
	@WebMethod
	@WebResult(name = "return", targetNamespace = "http://www.otrip.net/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/cancelFavourite")
	public String cancelFavourite(
			@WebParam(name="paramjson") @QueryParam("paramjson") String paramjson);
			//@WebParam(name="userId") @QueryParam("userId") String userId,
			//@WebParam(name="actiId") @QueryParam("actiId") String actiId);
	
	
	@WebMethod
	@WebResult(name = "return", targetNamespace = "http://www.otrip.net/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/addPraise")
	public String addPraise(@WebParam(name="paramjson") @QueryParam("paramjson") String paramjson);
	
}
