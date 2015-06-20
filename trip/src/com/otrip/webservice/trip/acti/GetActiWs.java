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
public interface GetActiWs {
	
	/**
	 * @author yangyu
	 * @param longitude
	 * @param latitude
	 * @return
	 * @throws Exception
	 * 根据目标经纬度加载首页需要的活动
	
	@WebMethod
	@WebResult(name = "return", targetNamespace = "http://www.otrip.net/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/indexActi")
	public String getIndexActi(@WebParam(name="longitude") @QueryParam("longitude") String longitude,@WebParam(name="latitude") @QueryParam("latitude") String latitude) throws Exception;
	 */
	
	@WebMethod
	@WebResult(name = "return", targetNamespace = "http://www.otrip.net/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/indexActi")
	public String getIndexActi(@WebParam(name = "paramjson" ) @QueryParam("paramjson")String paramjson);
	
	
	
	
	
	/**
	 * 
	 * @param desctiId
	 * @return
	 * 获取目的地附近的活动列表

	@WebMethod
	@WebResult(name="return" , targetNamespace="http://www.otrip.net/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/getActiBydesti")
	public String getActiBydesti(@WebParam(name="desctiId") @QueryParam("desctiId") String desctiId);
	*/
	
	@WebMethod
	@WebResult(name="return" , targetNamespace="http://www.otrip.net/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/getActiBydesti")
	public String getActiBydesti(@WebParam(name="paramjson") @QueryParam("paramjson") String paramjson);
	/**
	 * 点击活动进入详情页
	 */
	/*
	@WebMethod
	@WebResult(name="return" , targetNamespace="http://www.otrip.net/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/getActiInfo")
	public String getActiInfo(@WebParam(name="actiId") @QueryParam("actiId") String actiId);
	*/
	@WebMethod
	@WebResult(name="return" , targetNamespace="http://www.otrip.net/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/getActiInfo")
	public String getActiInfo(@WebParam(name="paramjson") @QueryParam("paramjson") String paramjson);
	
	
	/**
	 * 加载日历页
	 */
	@WebMethod
	@WebResult(name="return" , targetNamespace="http://www.otrip.net/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/getPriceBydate")
	public String getPriceBydate(@WebParam(name="actiId") @QueryParam("actiId") String actiId,@WebParam(name="month") @QueryParam("month") String month);
	
	/**
	 * 加载历史评价与点击查看更多共用API
	 */
	/*
	@WebMethod
	@WebResult(name="return" , targetNamespace="http://www.otrip.net/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/getDiscusses")
	public String getDiscusses(@WebParam(name="actiId") @QueryParam("actiId") String actiId,
								@WebParam(name="page") @QueryParam("page") String page,
								@WebParam(name="num") @QueryParam("num") String num
								);
	*/
	//http:localhost:8080/trip/ws/rest_acti/getDiscusses?paramjson={actiId:"",page:"",num:""}
	@WebMethod
	@WebResult(name="return" , targetNamespace="http://www.otrip.net/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/getDiscusses")
	public String getDiscusses(@WebParam(name="paramjson") @QueryParam("paramjson") String paramjson);
	
	/**
	 * 添加评论
	 
	@WebMethod
	@WebResult(name="return" , targetNamespace="http://www.otrip.net/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/addDiscuss")
	public String addDiscuss(
			@WebParam(name="loginUesrId") @QueryParam("loginUesrId") String loginUesrId,
			@WebParam(name="actiId") @QueryParam("actiId") String actiId,
			@WebParam(name="level") @QueryParam("level") String level,
			@WebParam(name="context") @QueryParam("context") String context
						);
	*/
	@WebMethod
	@WebResult(name="return" , targetNamespace="http://www.otrip.net/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/addDiscuss")
	public String addDiscuss(@WebParam(name="paramjson") @QueryParam("paramjson") String paramjson);
	
	
	
	
	/**
	 * 加载历史问题与点击查看更多共用API
	
	@WebMethod
	@WebResult(name="return" , targetNamespace="http://www.otrip.net/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/getProblems")
	public String getProblems(@WebParam(name="actiId") @QueryParam("actiId") String actiId,
								@WebParam(name="page") @QueryParam("page") String page,
								@WebParam(name="num") @QueryParam("num") String num
								);
	 */
	@WebMethod
	@WebResult(name="return" , targetNamespace="http://www.otrip.net/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/getProblems")
	public String getProblems(@WebParam(name="paramjson") @QueryParam("paramjson") String paramjson);
	/**
	 * 添加问题
	 */
	@WebMethod
	@WebResult(name="return" , targetNamespace="http://www.otrip.net/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/addProblem")
	public String addProblem(@WebParam(name="paramjson") @QueryParam("paramjson") String paramjson
			//@WebParam(name="loginUesrId") @QueryParam("loginUesrId") String loginUserId,
			//@WebParam(name="programContent") @QueryParam("programContent") String programContent,
			//@WebParam(name="actiId") @QueryParam("actiId") String actiId
						);
	
	/**
	 * 收藏活动
	 * /otrip/ws/acti/addfavoriteActi
	 
	@WebMethod
	@WebResult(name="return" , targetNamespace="http://www.otrip.net/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/addfavoriteActi")
	public String addfavoriteActi(
			@WebParam(name="loginUserId") @QueryParam("loginUserId") String loginUserId,
			@WebParam(name="actiId") @QueryParam("actiId") String actiId
								);
	*/
	@WebMethod
	@WebResult(name="return" , targetNamespace="http://www.otrip.net/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/addfavoriteActi")
	public String addfavoriteActi(@WebParam(name="paramjson") @QueryParam("paramjson") String paramjson);
	/**
	 * 按活动名称活地点搜索活动
	 * /otrip/ws/acti/findActiByName
	 
	@WebMethod
	@WebResult(name="return" , targetNamespace="http://www.otrip.net/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/findActiByName")
	public String findActiByName(@WebParam(name="keyWord")
								 @QueryParam("keyWord")
						String keyWord);
	*/
	@WebMethod
	@WebResult(name="return" , targetNamespace="http://www.otrip.net/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/findActiByName")
	public String findActiByName(@WebParam(name="paramjson") @QueryParam("paramjson") String paramjson);
	
	
	/**
	 * 按活动类型搜索活动
	 * /otrip/ws/acti/findActiByType
	 
	@WebMethod
	@WebResult(name="return" , targetNamespace="http://www.otrip.net/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/findActiByType")
	public String findActiByType(@WebParam(name="actiType") @QueryParam("actiType")
							String actiType
							);
	
	*/
	@WebMethod
	@WebResult(name="return" , targetNamespace="http://www.otrip.net/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/findActiByType")
	public String findActiByType(@WebParam(name="paramjson") @QueryParam("paramjson") String paramjson);
	
	/**
	 * 按热门度搜索活动
	 * /otrip/ws/acti/findActiByPraise
	 
	@WebMethod
	@WebResult(name="return" , targetNamespace="http://www.otrip.net/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/findActiByPraise")
	public String findActiByPraise();
	*/
	@WebMethod
	@WebResult(name="return" , targetNamespace="http://www.otrip.net/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/findActiByType")
	public String findActiByPraise();
	
	
	
	
	/**
	 * 4.热门活动底部按类型搜索
	 * /otrip/ws/acti/findActiByPraiseAndType
	 
	@WebMethod
	@WebResult(name="return" , targetNamespace="http://www.otrip.net/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/findActiByPraiseAndType")
	public String findActiByPraiseAndType(@WebParam(name="actiType")@QueryParam("actiType")String actiType);
	*/
	@WebMethod
	@WebResult(name="return" , targetNamespace="http://www.otrip.net/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/findActiByPraiseAndType")
	public String findActiByPraiseAndType(@WebParam(name="paramjson") @QueryParam("paramjson") String paramjson);
	
	
	
	
	
	
	
	
	/**
	 * 热门活动底部按目的地搜索
	 * /otrip/ws/acti/findActiByPraiseAndDestinName
	 
	@WebMethod
	@WebResult(name="return" , targetNamespace="http://www.otrip.net/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/findActiByPraiseAndDestinName")
	public String findActiByPraiseAndDestinName(@WebParam(name="actiDestinName") @QueryParam("actiDestinName")
							String actiDestinName);
	*/
	
	@WebMethod
	@WebResult(name="return" , targetNamespace="http://www.otrip.net/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/findActiByPraiseAndDestinName")
	public String findActiByPraiseAndDestinName(@WebParam(name="paramjson") @QueryParam("paramjson") String paramjson);
	
	
	
	/**
	 * 在地图上点击目的地搜索
	 * /otrip/ws/acti/findActiByDestination
	 
	@WebMethod
	@WebResult(name="return" , targetNamespace="http://www.otrip.net/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/findActiByCountry")
	public String findActiByCountry(@WebParam(name="countryId")
										@QueryParam("countryId")String countryId);
	*/
	@WebMethod
	@WebResult(name="return" , targetNamespace="http://www.otrip.net/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/findActiByCountry")
	public String findActiByCountry(@WebParam(name="paramjson") @QueryParam("paramjson") String paramjson);
	
	/**
	 * 加载目的地搜索地图
	 * /otrip/ws/acti/getDestinations
	 */
	/*
	@WebMethod
	@WebResult(name="return" , targetNamespace="http://www.otrip.net/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/getMapDestinations")
	public String getMapDestinations(@WebParam(name="longitude")
									@QueryParam("longitude")String longitude,
									@WebParam(name="latitude") @QueryParam("latitude") String latitude);
									*/
	@WebMethod
	@WebResult(name="return" , targetNamespace="http://www.otrip.net/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/getMapDestinations")
	public String getMapDestinations(@WebParam(name="paramjson") @QueryParam("paramjson") String paramjson);
	
	@WebMethod
	@WebResult(name="return" , targetNamespace="http://www.otrip.net/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/findActiByCountryName")
	public String findActiByCountryName(@WebParam(name="paramjson") @QueryParam("paramjson") String paramjson);
	
	
	//获取类型和国家用于搜索
	@WebMethod
	@WebResult(name="return" , targetNamespace="http://www.otrip.net/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/getCountryAndType")
	public String getCountryAndType();
	
	@WebMethod
	@WebResult(name="return" , targetNamespace="http://www.otrip.net/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/getActiByPosition")
	public String getActiByPosition(@WebParam(name="paramjson") @QueryParam("paramjson") String paramjson);
	
}
