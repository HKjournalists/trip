package com.otrip.dao.ws.impl;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.FlushMode;
import org.hibernate.LockMode;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Component;

import com.otrip.dao.GenericHibernateDao;
import com.otrip.dao.IGenericDao;
import com.otrip.dao.util.ConvertDataUtil;
import com.otrip.dao.ws.WsFavoriteDao;
import com.otrip.domain.DomainUtils;
import com.otrip.domain.system.SysUser;
import com.otrip.domain.trip.OtActiFavorite;
import com.otrip.domain.trip.OtActiInfo;

@Component(value="wsFavoriteDao")
public class WsFavoriteDaoImpl extends GenericHibernateDao<OtActiFavorite,String> implements WsFavoriteDao{

	static Logger log=Logger.getLogger(WsFavoriteDaoImpl.class);
	
	@Override
	public List getActiFavoites(String loginUserId, String page, String num) {
		
		int n=ConvertDataUtil.StringToInt(num);
		int start=ConvertDataUtil.StringToInt(page);
		String hql="from SysUser as s where s.fsId=?";
		List userList=super.find(hql, new String[]{loginUserId});
		if(userList.size()!=0)
		{
			SysUser user=(SysUser) userList.get(0);
			String hql2="from OtActiFavorite as a where a.sysUser=? and a.state=0";
			List list=super.findLimitNumByParam(hql2, n, start, new Object[]{user});
			log.info("find Favorites from"+n*start+" to "+n*start+n);
			return list;
		}
		else
		{
			log.debug("the user is no exist!");
			return null;
		}
		
	}

	@Override
	public boolean addFavoite(String loginUserId, String actiId) {
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
		OtActiFavorite fav=new OtActiFavorite();
		fav.setFdCreateTime(new Date());
		fav.setFdUpdateTime(null);
		fav.setFsId(DomainUtils.generalUuid());
		fav.setOtActiInfo(acti);
		fav.setSysUser(user);
		super.save(fav);
		log.info("add favorite success");
		return true;
	}

	@Override
	public boolean saveCancelFavorite(String loginUserId, String actiId) {
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
		String hql="from OtActiFavorite as a where a.sysUser=? and a.otActiInfo=? and state=0";
		List list=super.find(hql, new Object[]{user,acti});
		if(list.size()!=0)
		{
			//设置删除状态为true，表示已删除
			((OtActiFavorite) list.get(0)).setState(true);
			super.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.COMMIT);
			super.save(((OtActiFavorite) list.get(0)));
			super.flush();
			log.info("delete favorite success"+((OtActiFavorite) list.get(0)).getFsId());
			return true;
		}
		else
		{
			log.info("the favorite is not exist");
			return false;
		}
	
	}
	
	


	
}
