package com.otrip.dao.ws;

import java.util.List;

import org.springframework.stereotype.Component;

import com.otrip.dao.IGenericDao;
import com.otrip.domain.trip.OtActiClickPraise;

public interface WsActiClickPraiseDao extends IGenericDao<OtActiClickPraise, String> {
	//获取活动点赞数
	public String getWsActiClickPraiseNum(String actiID);
	
	//点赞
	public String addActiClickPraise(String actiId,String loginUserId);
	
	
	//取消赞
	public boolean cancelClickPraise(String actiID,String loginUserId);
	
	//根据活动id获取点赞的用户
	public List getActiClickPraiseByActi(String actiId);
	

}
