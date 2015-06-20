package com.otrip.service.system.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.otrip.dao.system.UserRoleDao;
import com.otrip.domain.system.SysUserRole;
import com.otrip.service.GeneralService;
import com.otrip.service.system.UserRoleService;

@Service
public class UserRoleServiceImpl extends GeneralService<SysUserRole> implements UserRoleService {

	private static final long serialVersionUID = -5018381760764243842L;
	static Logger log=Logger.getLogger(UserRoleServiceImpl.class);
	
	private UserRoleDao	userRoleDao;
	@Autowired
	public void setUserRoleDao(UserRoleDao userRoleDao) {
		this.userRoleDao = userRoleDao;
	}
	
	public void saveUserRoles(final List<SysUserRole> sysUserRoles) throws Exception{
		if(sysUserRoles!=null&&sysUserRoles.size()>0){
			userRoleDao.batchSaveEntity(sysUserRoles);
		}
	}
	
	public void saveSysUserRoles(final List<SysUserRole> urList) throws DataAccessException{
		if(urList!=null&&urList.size()>0){
			userRoleDao.saveSysUserRoles(urList);
		}
	}
	
}
