package com.otrip.dao.system.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.LockMode;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.otrip.dao.GenericHibernateDao;
import com.otrip.dao.system.UserRoleDao;
import com.otrip.domain.system.SysRoleAuth;
import com.otrip.domain.system.SysUserRole;

@Component(value="userRoleDao")
public class UserRoleDaoImpl extends GenericHibernateDao<SysUserRole, String> implements UserRoleDao {

	static Logger log=Logger.getLogger(UserRoleDaoImpl.class);
	
	public void saveSysUserRoles(final List<SysUserRole> urList) throws DataAccessException{
		if(urList!=null&&urList.size()>0){
			super.batchSaveEntity(urList);
		}
	}

}
