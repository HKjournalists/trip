package com.otrip.dao.trip;

import java.util.List;

import com.otrip.dao.IGenericDao;
import com.otrip.domain.trip.OtActiDiscuss;
import com.otrip.pojo.CommentActiVo;


public interface CommentDao extends IGenericDao<OtActiDiscuss,String>{
	
	public List<CommentActiVo> getCommentActiByTopLevel(int topNum);
	
	public List<CommentActiVo> getCommentActiByTopCommNum(int topNum);

}
