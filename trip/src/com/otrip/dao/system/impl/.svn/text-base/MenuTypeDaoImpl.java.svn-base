package com.otrip.dao.system.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.LockMode;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.otrip.dao.GenericHibernateDao;
import com.otrip.dao.system.MenuTypeDao;
import com.otrip.domain.system.SysMenuType;
import com.otrip.domain.system.SysResource;

/**
 * @see 
 * @author Administrator
 *
 */

@Component(value="menuTypeDao")
public class MenuTypeDaoImpl extends GenericHibernateDao<SysMenuType, String> implements MenuTypeDao {

	static Logger log=Logger.getLogger(MenuTypeDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	public List<SysMenuType> findSysMenuType(final SysMenuType sysMenuType) throws DataAccessException{
		final StringBuffer sbHql=new StringBuffer(" from SysMenuType mt where 1=1 ");
		if(sysMenuType!=null){
			if(StringUtils.isNotBlank(sysMenuType.getFsName())){
				sbHql.append(" and mt.fsName like '%"+sysMenuType.getFsName()+"%' ");
			}
			
			if(StringUtils.isNotBlank(sysMenuType.getFsSign())){
				sbHql.append(" and mt.fsSign = '"+sysMenuType.getFsSign()+"' ");
			}
		}
		return super.find(sbHql.toString());
	}
	
	public SysMenuType findSysMenuTypeById(final String id)throws RuntimeException{
		return super.load(id);
	}
	
	public void delSysMenuTypeById(final String id) throws RuntimeException{
		if(StringUtils.isNotBlank(id)){
			super.deleteByKey(id);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<SysMenuType> findMenuModuleType() throws RuntimeException{
		StringBuffer queryHql=new StringBuffer(" from SysMenuType mt where 1=1 ");
		queryHql.append( "and mt.fsSign!='4' and mt.fsId!='5'");
		return super.find(queryHql.toString());
	}
	
	@SuppressWarnings("unchecked")
	public List<SysMenuType> findMenuChildItemType() throws RuntimeException{
		StringBuffer queryHql=new StringBuffer(" from SysMenuType mt where 1=1 ");
		queryHql.append( "and mt.fsSign='4' or mt.fsSign='5'");
		return super.find(queryHql.toString());
	}
	
	@SuppressWarnings("unchecked")
	public List<SysMenuType> findChildMenuType(final String parentTypeSign) throws RuntimeException{
		if(StringUtils.isNotBlank(parentTypeSign)){
			StringBuffer queryHql=new StringBuffer(" from SysMenuType mt where 1=1 ");
			queryHql.append(" and mt.fsSign>'"+parentTypeSign+"'");
			return super.find(queryHql.toString());
		}else{
			return null;
		}
		
	}
	
}
