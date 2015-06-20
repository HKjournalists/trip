package com.otrip.dao.ws;

import java.util.List;

import com.otrip.dao.IGenericDao;
import com.otrip.domain.trip.OtActiDiscuss;
import com.otrip.domain.trip.OtActiProblemDiscuss;

public interface WsProblemDao extends IGenericDao<OtActiProblemDiscuss, String>{
	
	//获取活动问题
		public List getActiProblems(String actiId, String page, String num);
		
		//保存活动提问
		
		public boolean addActiProblem(String loginUserId,String programContent,String actiId);
		
		//用户中心加载用户的提问
		public List getProblemsByUser(String loginUserId,String page,String num);
		
		public List getReply(String proId);

}
