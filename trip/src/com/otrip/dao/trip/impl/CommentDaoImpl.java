package com.otrip.dao.trip.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.otrip.dao.GenericHibernateDao;
import com.otrip.dao.trip.CommentDao;
import com.otrip.domain.trip.OtActiDiscuss;
import com.otrip.pojo.CommentActiVo;

@Component("coommentDao")
public class CommentDaoImpl extends GenericHibernateDao<OtActiDiscuss,String> implements CommentDao
{
	
	public List<CommentActiVo> getCommentActiByTopLevel(int topNum)
	{
		if(topNum>0)
		{
			String sql=" select a.avgLevel,a.commNum,b.fs_id,b.fs_no,b.fn_day,b.fs_title from "
					+ " (select round(avg(fs_grade_level),0) as avgLevel ,count(fs_id) as "
					+ " commNum ,fs_acti_id from ot_acti_discuss group by "
					+ " fs_acti_id limit 0,"+topNum+") a"
					+ " inner join (select fs_id,fs_no,fn_day,fs_title from ot_acti_info ) "
					+ " b on a.fs_acti_id=b.fs_id order by  avgLevel desc";
			List list=super.findBySQL(sql);
			List<CommentActiVo> returnList=new ArrayList();
			if(list.size()>0)
			{
				for(int i=0;i<list.size();i++)
				{
					Map map=(Map)list.get(i);
					returnList.add(this.getCommentActiVo(map));
				}
				return returnList;
			}
		}
		return null;
	}
	
	public List<CommentActiVo> getCommentActiByTopCommNum(int topNum)
	{
		if(topNum>0)
		{
			String sql=" select a.avgLevel,a.commNum,b.fs_id,b.fs_no,b.fn_day,b.fs_title from "
					+ " (select round(avg(fs_grade_level),0) as avgLevel ,count(fs_id) as "
					+ " commNum ,fs_acti_id from ot_acti_discuss group by "
					+ " fs_acti_id limit 0,"+topNum+") a"
					+ " inner join (select fs_id,fs_no,fn_day,fs_title from ot_acti_info ) "
					+ " b on a.fs_acti_id=b.fs_id order by  commNum desc";
			List list=super.findBySQL(sql);
			List<CommentActiVo> returnList=new ArrayList();
			if(list.size()>0)
			{
				for(int i=0;i<list.size();i++)
				{
					Map map=(Map)list.get(i);
					returnList.add(this.getCommentActiVo(map));
					return returnList;
				}
			}
		}
		return null;
	}
	
	
	private CommentActiVo getCommentActiVo(Map map)
	{
		CommentActiVo cav=new CommentActiVo();
		cav.setActiDays(map.get("fn_day")+"");
		cav.setActiId(map.get("fs_id")+"");
		cav.setActiLevel(map.get("avgLevel")+"");
		cav.setCommNum(map.get("commNum")+"");
		cav.setActiTitle(map.get("fs_title")+"");
		cav.setActiNo(map.get("fs_no")+"");
		return cav;
	}

}
