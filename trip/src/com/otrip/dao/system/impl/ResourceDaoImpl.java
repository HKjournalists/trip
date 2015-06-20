package com.otrip.dao.system.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.LockMode;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Component;

import com.otrip.dao.GenericHibernateDao;
import com.otrip.dao.system.ResourceDao;
import com.otrip.domain.system.SysResource;

@Component(value="resourceDao")
public class ResourceDaoImpl extends GenericHibernateDao<SysResource, String> implements ResourceDao {
	
	static Logger log=Logger.getLogger(ResourceDaoImpl.class);
	
	public List<SysResource> findAllSysResources(){
		return super.loadAll();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<SysResource> queryRescourcesBySysResource(final SysResource sysResource) throws RuntimeException{
		StringBuffer sbQueryHql=new StringBuffer(" from SysResource r where 1=1 ");
		if(sysResource!=null){
			if(StringUtils.isNotBlank(sysResource.getFsName())){
				sbQueryHql.append(" and r.fsName like '%"+sysResource.getFsName()+"%' ");
			}
			if(StringUtils.isNotBlank(sysResource.getFsKey())){
				sbQueryHql.append(" and r.fsKey like '%"+sysResource.getFsKey()+"%' ");
			}
			if(StringUtils.isNotBlank(sysResource.getFsUrl())){
				sbQueryHql.append(" and r.fsUrl like '%"+sysResource.getFsUrl()+"%' ");
			}
		}
		return super.find(sbQueryHql.toString());
	}
	
	public SysResource findSysResourceById(final String id)throws RuntimeException{
		return super.load(id);
	}
	
	public void delSysResourceById(final String id) throws RuntimeException{
		if(StringUtils.isNotBlank(id)){
			super.deleteByKey(id);
		}
	}
	

	
}
