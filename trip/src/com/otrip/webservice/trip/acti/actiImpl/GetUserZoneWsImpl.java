package com.otrip.webservice.trip.acti.actiImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otrip.dao.ws.WsActiClickPraiseDao;
import com.otrip.dao.ws.WsDestinationDao;
import com.otrip.dao.ws.WsDiscussDao;
import com.otrip.dao.ws.WsFavoriteDao;
import com.otrip.dao.ws.WsProblemDao;
import com.otrip.dao.ws.impl.WsProblemDaoimpl;
import com.otrip.domain.trip.OtActiDiscuss;
import com.otrip.domain.trip.OtActiFavorite;
import com.otrip.pojo.ws.Discuss;
import com.otrip.pojo.ws.Favorite;
import com.otrip.pojo.ws.Problems;
import com.otrip.webservice.BaseWsService;
import com.otrip.webservice.trip.acti.GetUserZoneWs;
import com.otrip.webservice.util.ResultJsonUtil;

@Service("getUserZoneWsImpl")
public class GetUserZoneWsImpl extends BaseWsService implements GetUserZoneWs
{
	@Autowired
	WsFavoriteDao wsfd;
	@Autowired
	WsDestinationDao wsd;
	@Autowired
	WsProblemDao wspd;
	@Autowired
	WsDiscussDao wsdis;
	@Autowired
	WsActiClickPraiseDao wdcpa;
	
	
	public void setWsActiClickPraiseDao(WsActiClickPraiseDao wdcpa)
	{
		this.setWsActiClickPraiseDao(wdcpa);
	}
	public void setWsDiscussDao(WsDiscussDao wsdis)
	{
		this.wsdis=wsdis;
	}
	
	public void setWsProblemDao(WsProblemDao wspd)
	{
		this.wspd=wspd;
	}
	public void setWsFavoriteDao(WsFavoriteDao wsfd)
	{
		this.wsfd=wsfd;
	}

	public void setWsDestinationDao(WsDestinationDao wsd)
	{
		this.wsd=wsd;
	}

	public String getFavouritesByUser(String userId, String page, String num) {
		// TODO Auto-generated method stub
		List favList=wsfd.getActiFavoites(userId, page, num);
		List jsonList=new ArrayList();
		if(favList!=null)
		{
			for(int i=0;i<favList.size();i++)
			{
				Favorite fav=new Favorite();
				OtActiFavorite af=(OtActiFavorite)favList.get(i);
				fav.setActiId(af.getOtActiInfo().getFsId());
				fav.setActiTitle(af.getOtActiInfo().getFsTitle());
				fav.setCountry(af.getOtActiInfo().getFsDestinationCountry().getFsName());
				if(af.getOtActiInfo().getOtActiTimePrice()!=null)
					fav.setPrice(af.getOtActiInfo().getOtActiTimePrice().getFnSpecialPrice()+"");
				else
					fav.setPrice("0.00");
				fav.setType(af.getOtActiInfo().getOtActiType().getFsName());
				fav.setUrl(wsd.findImageUrl(fav.getActiId()));
				jsonList.add(fav);
			}
			JSONArray jsonArray=JSONArray.fromObject(jsonList);
			return ResultJsonUtil.returnJSON(new String[]{"favorite"}, new String[]{jsonArray.toString()}, "200", "success");
		}
		else
		{
			return ResultJsonUtil.returnErrorJson("404", "没有收藏", "false");
		}
	}

	@Override
	public String getProblemsByUser(String actiId, String page, String num) {
		// TODO Auto-generated method stub
		
		List list=wspd.getProblemsByUser(actiId, page, num);
		if(list!=null)
		{
			List jsonList=new ArrayList();
			for(int i=0;i<list.size();i++)
			{
				Map proMap=(Map)list.get(i);
				Problems pro=new Problems();
				pro.setProId(proMap.get("id")+"");
				pro.setProblemContent(proMap.get("content")+"");
				pro.setProblemDate(proMap.get("proTime")+"");
				pro.setStatus(Integer.valueOf(proMap.get("fsstatus")+""));
				if(pro.getStatus()==1)
				{
					List replyList=wspd.getReply(pro.getProId());
					if(replyList!=null)
					{
						for(int j=0;j<replyList.size();j++)
						{
							Map rep=(Map)replyList.get(j);
							pro.setReplyContent(rep.get("reply")+"");
							pro.setReplyDate(rep.get("time")+"");
						}
						
					}
					
				}
				jsonList.add(pro);
			}
			JSONArray proJson=JSONArray.fromObject(jsonList);
			String json=proJson.toString();
			return ResultJsonUtil.returnJSON(new String[]{"problems"},new String[]{json}, "200", "null");
		}
		else
			return ResultJsonUtil.returnErrorJson("404", "加载问题失败", "false");
	}

	@Override
	public String getDiscussByUser(String paramjson) {
		// TODO Auto-generated method stub
		final JSONObject jsonObj=JSONObject.fromObject(paramjson);
		final String userId=jsonObj.getString("userId");
		final String page=jsonObj.getString("page");
		final String num=jsonObj.getString("num");
		List list=wsdis.getActiDiscussesByUser(userId, page, num);
		if(list!=null)
		{
			List jsonList=new ArrayList();
			for(int i=0;i<list.size();i++)
			{
				OtActiDiscuss oatd =(OtActiDiscuss)list.get(i);
				Discuss dis=new Discuss();
				dis.setDissContent(oatd.getFsContent());
				dis.setDissDate(oatd.getFdTime()+"");
				dis.setLevel(oatd.getFsGradeLevel()+"");
				jsonList.add(dis);
			}
			JSONArray proJson=JSONArray.fromObject(jsonList);
			String json=proJson.toString();
			return ResultJsonUtil.returnJSON(new String[]{"disscuss"},new String[]{json}, "200", "null");
		}
		else
			return ResultJsonUtil.returnErrorJson("404", "加载评论失败", "false");
	}

	@Override
	public String postAdvice(String actiId, String page, String num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String cancelFavourite(String paramjson) 
	{
		final JSONObject jsonObj=JSONObject.fromObject(paramjson);
		final String userId=jsonObj.getString("userId");
		final String actiId=jsonObj.getString("actiId");
		if(wsfd.saveCancelFavorite(userId, actiId))
			return ResultJsonUtil.returnErrorJson("200", "取消收藏成功", "true");
		else
			return ResultJsonUtil.returnErrorJson("404", "取消收藏失败", "false");
	}

	@Override
	public String getFavouritesByUser(String paramjson)
	{
		final JSONObject jsonObj=JSONObject.fromObject(paramjson);
		final String userId=jsonObj.getString("userId");
		final String page=jsonObj.getString("page");
		final String num=jsonObj.getString("num");
		return this.getFavouritesByUser(userId, page, num);
	}

	


	@Override
	public String addPraise(String paramjson) {
		final JSONObject jsonObj=JSONObject.fromObject(paramjson);
		final String userId=jsonObj.getString("userId");
		final String actiId=jsonObj.getString("actiId");
		String result=wdcpa.addActiClickPraise(actiId, userId);
		if(result!=null)
		{
			return ResultJsonUtil.returnJSON(new String[]{"Praise"},new String[]{"{\"number\":\""+result+"\"}"}, "200", "null");
		}
		return  ResultJsonUtil.returnErrorJson("404", "点赞失败", "false");
	}
	
}
