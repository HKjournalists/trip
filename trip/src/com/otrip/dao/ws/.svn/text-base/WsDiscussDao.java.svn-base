package com.otrip.dao.ws;

import java.util.List;

import com.otrip.dao.IGenericDao;
import com.otrip.domain.trip.OtActiDestination;
import com.otrip.domain.trip.OtActiDiscuss;

public interface WsDiscussDao extends IGenericDao<OtActiDiscuss, String>{

	 //根据活动ID加载活动评论
		public List getActiDiscusses(String actiId, String page, String num);
		
		//保存用户评价
		public boolean addDiscuss(String loginUesrId, String actiId, String level,String context);
		
		
		//个人中心，加载用户的评论
		public List getActiDiscussesByUser(String loginUserId,String page,String num);
		
		//获得评论的条数
		public String getActiDiscuesNum(String actiId);
}
