package com.otrip.dao.ws.impl;

import java.util.Collection; 

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.LockMode;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.otrip.dao.GenericHibernateDao;
import com.otrip.dao.ws.WsLogLoginDao;
import com.otrip.domain.ws.WsLogLogin;
import com.otrip.util.Common;

@Component(value="wsLogLoginDao")
public class WsLogLoginDaoImpl extends GenericHibernateDao<WsLogLogin, String> implements WsLogLoginDao {

	static Logger log=Logger.getLogger(WsLogLoginDaoImpl.class);
	
	public void logoutWs(final WsLogLogin wsLogLogin) throws Exception {
		if(wsLogLogin!=null&&wsLogLogin.getSysUser()!=null){
			final StringBuffer sbUpdateHql=new StringBuffer(" update WsLogLogin set fdLogoutTime='"+Common.fromDateH()+"' where fsId='"+wsLogLogin.getFsId()+"' and fdLogoutTime is null ");
			super.bulkUpdate(sbUpdateHql.toString());
		}
	}
	
	public void saveWsLogLogin(final WsLogLogin wsLogLogin) throws DataAccessException{
		if(wsLogLogin!=null&&StringUtils.isNotBlank(wsLogLogin.getFsId())){
			log.info("To method info:..............");
			super.save(wsLogLogin);
			log.info("result the info.....");
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<WsLogLogin> queryWsLogLogins(final WsLogLogin wsLogLogin) throws Exception{
		StringBuffer queryHql=new StringBuffer(" select ll from WsLogLogin ll where 1=1 ");
		if(wsLogLogin!=null){
			if(StringUtils.isNotBlank(wsLogLogin.getFsIp())){
				queryHql.append(" and ll.fsIp like '%"+wsLogLogin.getFsIp()+"%' ");
			}
			if(wsLogLogin.getSysUser()!=null&&StringUtils.isNotBlank(wsLogLogin.getSysUser().getFsName())){
				queryHql.append(" and ll.sysUser.fsName like '%"+wsLogLogin.getSysUser().getFsName()+"%' ");
			}
			if(wsLogLogin.getFdLoginTime()!=null){
				queryHql.append(" and ll.fdLoginTime = '"+wsLogLogin.getFdLogoutTime()+"' ");
			}
			if(wsLogLogin.getFdLogoutTime()!=null){
				queryHql.append(" and ll.getFdLogoutTime = '"+wsLogLogin.getFdLogoutTime()+"' ");
			}
		}
		return super.find(queryHql.toString());
	}



	

}
