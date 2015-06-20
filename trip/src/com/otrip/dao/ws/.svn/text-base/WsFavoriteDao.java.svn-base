package com.otrip.dao.ws;

import java.util.List;

import com.otrip.dao.IGenericDao;
import com.otrip.domain.trip.OtActiDiscuss;
import com.otrip.domain.trip.OtActiFavorite;

public interface WsFavoriteDao extends IGenericDao<OtActiFavorite, String>{
	
	//获取用户的收藏的活动
	public List getActiFavoites(String loginUserId,String page, String num);
	
	//收藏活动
	public boolean addFavoite(String loginUserId,String actiId);
	
	//取消收藏
	public boolean saveCancelFavorite(String loginUserId,String actiId);
}
