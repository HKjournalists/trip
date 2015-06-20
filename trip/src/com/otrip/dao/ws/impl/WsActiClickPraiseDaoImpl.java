package com.otrip.dao.ws.impl;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.LockMode;
import org.hibernate.criterion.DetachedCriteria;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

import com.otrip.dao.GenericHibernateDao;
import com.otrip.dao.ws.WsActiClickPraiseDao;
import com.otrip.domain.DomainUtils;
import com.otrip.domain.system.SysUser;
import com.otrip.domain.trip.OtActiClickPraise;
import com.otrip.domain.trip.OtActiFavorite;
import com.otrip.domain.trip.OtActiInfo;

@Component(value="wsActiClickPraiseDao")
public class WsActiClickPraiseDaoImpl extends GenericHibernateDao<OtActiClickPraise,String> implements
		WsActiClickPraiseDao {

	Logger log=Logger.getLogger(WsActiClickPraiseDaoImpl.class);
	@Override
	public String getWsActiClickPraiseNum(String actiID) {
		String sql="select count(fs_id) as num from ot_acti_click_praise where actiID='"+actiID+"' and state=0";
		List list=super.findBySQL(sql);
		if(list.size()!=0)
		{
			return (String)((Map) list.get(0)).get("num");
		}
		else
			return null;
	}

	@Override
	public String addActiClickPraise(String actiId, String loginUserId) {
		SysUser user=null;
		OtActiInfo acti=null;
		log.info(actiId);
		try
		{
			user=super.getHibernateTemplate().load(SysUser.class, loginUserId);
			acti=super.getHibernateTemplate().load(OtActiInfo.class, actiId);
		}
		catch(Exception e)
		{
			log.debug("user or oaActiInfo is not exist!");
			return null;
		}
		OtActiClickPraise ota=new OtActiClickPraise();
		ota.setFdPraiseTime(new Date());
		log.info("praiseTime :"+ota.getFdPraiseTime());
		ota.setFsId(DomainUtils.generalUuid());
		log.info("uid :"+ota.getFsId());
		log.info("actiInfo :"+acti.getFsId());
		ota.setOtActiInfo(acti);
		ota.setSysUser(user);
		log.info("userId :" +ota.getSysUser().getFsId());
		super.save(ota);
		log.info("save Priaise");
		//
		String hql="select count(a.fsId) from OtActiClickPraise a where a.otActiInfo=?";
		try
		{
			String count=((Long) super.iterate(hql,new Object[]{acti}).next())+"";
			log.info(count);
			return count;
		}
		catch(Exception e)
		{
			log.debug("find no Praisenumber");
			return null;
		}
		
	}

	@Override
	public boolean cancelClickPraise(String actiId, String loginUserId) {
		SysUser user=null;
		OtActiInfo acti=null;
		try
		{
			user=super.getHibernateTemplate().load(SysUser.class, loginUserId);
			acti=super.getHibernateTemplate().load(OtActiInfo.class, actiId);
			
		}
		catch(Exception e)
		{
			log.debug("user or oaActiInfo is not exist!");
			return false;
		}
		String hql="from OtActiClickPraise as a where a.sysUser=? and a.otActiInfo=? and state=0";
		List list=super.find(hql, new Object[]{user,acti});
		if(list.size()!=0)
		{
			//设置删除状态为true，表示已删除
			((OtActiClickPraise) list.get(0)).setState(true);
			return true;
		}
		else
		{
			log.info("the favorite is not exist");
			return false;
		}
	}

	@Override
	public List getActiClickPraiseByActi(String actiId) {
		
		return null;
	}

	

}
