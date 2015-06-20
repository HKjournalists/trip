package com.otrip.dao.ws.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.otrip.dao.GenericHibernateDao;
import com.otrip.dao.util.ConvertDataUtil;
import com.otrip.dao.ws.WsDiscussDao;
import com.otrip.domain.DomainUtils;
import com.otrip.domain.system.SysUser;
import com.otrip.domain.trip.OtActiDiscuss;
import com.otrip.domain.trip.OtActiFavorite;
import com.otrip.domain.trip.OtActiInfo;
@Component(value="wsDiscussDao")
public class WsDiscussDaoimpl extends GenericHibernateDao<OtActiDiscuss,String> implements WsDiscussDao{

	Logger log=Logger.getLogger(WsDiscussDaoimpl.class);
	@Override
	public List getActiDiscusses(String actiId, String page, String num) {
		// TODO Auto-generated method stub
		int start=ConvertDataUtil.StringToInt(page);
		int numbers=ConvertDataUtil.StringToInt(num);
		OtActiInfo acti=null;
		try
		{
			acti=(OtActiInfo) super.getSession().load(OtActiInfo.class, actiId);
			
		}catch(Exception e)
		{
			log.info("the acti is not exist");
			return null;
		}
		
		String hql="from OtActiDiscuss as a where a.otActiInfo=? order by a.fdTime desc";
		List list=super.findLimitNumByParam(hql, numbers, start, new Object[]{acti});
		if(list.size()==0)
			return null;
		else
			return list;
	}

	@Override
	public boolean addDiscuss(String loginUesrId, String actiId, String level,
			String context) {
		// 
		OtActiInfo acti=null;
		SysUser sys=null;
		try
		{
			acti=super.getHibernateTemplate().load(OtActiInfo.class, actiId);
			sys=super.getHibernateTemplate().load(SysUser.class, loginUesrId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		OtActiDiscuss discuss=new OtActiDiscuss();
		discuss.setFdTime(new Date());
		discuss.setFsContent(context);
		int le=ConvertDataUtil.StringToInt(level);
		discuss.setFsGradeLevel(le);
		discuss.setFsContent(context);
		discuss.setFsId(DomainUtils.generalUuid());
		discuss.setOtActiInfo(acti);
		discuss.setSysUser(sys);
		super.save(discuss);
		return true;
	}

	
	//个人中心加载用户评论
	@Override
	public List getActiDiscussesByUser(String loginUserId, String page,
			String num) {
		int start=ConvertDataUtil.StringToInt(page);
		int numbers=ConvertDataUtil.StringToInt(num);
		SysUser sys=null;
		try
		{
			sys=super.getHibernateTemplate().load(SysUser.class	, loginUserId);
		}
		catch(Exception e)
		{
			log.debug("user is not exists");
			return null;
		}
		String hql="from OtActiDiscuss as a where a.sysUser=? order by a.fdTime desc";
		List list=super.findLimitNumByParam(hql, numbers, start, new Object[]{sys});
		if(list.size()==0)
			return null;
		else
			return list;
	}
	
	public String getActiDiscuesNum(String actiId)
	{
		String sql="select count(fs_id) as num from ot_acti_discuss where fs_acti_id='"+actiId+" '";
		List list=super.findBySQL(sql);
		if(list.size()!=0)
		{
			return (String)((Map) list.get(0)).get("num");
		}
		else
			return null;
	}

}
