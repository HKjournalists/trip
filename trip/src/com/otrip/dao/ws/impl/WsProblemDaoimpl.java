package com.otrip.dao.ws.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.otrip.dao.GenericHibernateDao;
import com.otrip.dao.util.ConvertDataUtil;
import com.otrip.dao.ws.WsProblemDao;
import com.otrip.domain.DomainUtils;
import com.otrip.domain.system.SysUser;
import com.otrip.domain.trip.OtActiInfo;
import com.otrip.domain.trip.OtActiProblemDiscuss;

@Component(value="wsProblemDao")
public class WsProblemDaoimpl extends GenericHibernateDao<OtActiProblemDiscuss, String>
		implements WsProblemDao {
	Logger log=Logger.getLogger(WsProblemDaoimpl.class);
	@Override
	public List getActiProblems(String actiId, String page, String num) {
		int start=ConvertDataUtil.StringToInt(page);
		int numbers=ConvertDataUtil.StringToInt(num);
		String sql="select a.fs_id as id ,a.fd_time as proTime,a.fs_content as content,"
				+ " a.fs_status as fsStatus ,b.fs_name as userName from (select fs_id,fd_time , "
				+ " fs_content  ,fs_user_id,fs_status from ot_acti_problem_discuss where "
				+ " fs_proplem_id='0' and fs_acti_id='"+actiId+"' order by fd_time desc limit "+start*numbers+", "+(start+1)*numbers+") a  inner join (select fs_id,fs_name from sys_user) b on a.fs_user_id=b.fs_id ";
		List list= super.findBySQL(sql);
		if(list.size()!=0)
		{
			return list;
		}
		else
		{
			return null;
		}
		
		
		/*
		OtActiInfo acti=null;
		try
		{
			acti=(OtActiInfo) super.getSession().load(OtActiInfo.class, actiId);
			
		}catch(Exception e)
		{
			log.info("the acti is not exist");
			return null;
		}
		String hql="from OtActiProblemDiscuss as a where a.otActiInfo=? order by a.fdTime desc";
		List list=super.findLimitNumByParam(hql, numbers, start, new Object[]{acti});
		if(list.size()==0)
			return null;
		else
			return list;
	   */
	}
	@Override
	public List getReply(String proId)
	{
		String sql="select fs_id as id,fd_time as time ,fs_content as reply ,fs_proplem_id from ot_acti_problem_discuss where fs_proplem_id=?";
		List list=super.findBySQL(sql, new String[]{proId});
		if(list.size()!=0)
		{
			return list;
		}
		else
		{
			return null;
		}
	}
	
	
	
	@Override
	public boolean addActiProblem(String loginUserId, String programContent,
			String actiId) {
		
		SysUser user=null;
		OtActiInfo acti=null;
		try
		{
			user=super.getHibernateTemplate().load(SysUser.class, loginUserId);
			acti=super.getHibernateTemplate().load(OtActiInfo.class, actiId);
		}
		catch(Exception e)
		{
			
			return false;
		}
		OtActiProblemDiscuss pro=new OtActiProblemDiscuss();
		pro.setFdTime(new Date());//保存创建时间
		pro.setFsContent(programContent);//保存内容
		pro.setFsId(DomainUtils.generalUuid());//保存主键
		pro.setFsStatus(0);//保存状态 0 表示未回复 1表示已回复 2表示答案
		pro.setOtActiInfo(acti);//保存活动
		pro.setSysUser(user);//保存提问者
		super.save(pro);
		return true;
	}

	@Override
	public List getProblemsByUser(String loginUserId, String page, String num) {
		int start=ConvertDataUtil.StringToInt(page);
		int numbers=ConvertDataUtil.StringToInt(num);
		String sql="select a.fs_id as id ,a.fd_time as proTime,a.fs_content as content,a.fs_status as fsstatus  from ot_acti_problem_discuss  a where "
				+ " fs_user_id='"+loginUserId+"' limit "+start*numbers+","+(start+1)*numbers;
		List list=super.findBySQL(sql);
		if(list.size()!=0)
		{
			return list;
		}
		else
		{
			return null;
		}
	}

}
