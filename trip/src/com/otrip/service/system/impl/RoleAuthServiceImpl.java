package com.otrip.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.otrip.dao.system.RoleAuthDao;
import com.otrip.domain.system.SysRole;
import com.otrip.domain.system.SysRoleAuth;
import com.otrip.service.GeneralService;
import com.otrip.service.system.RoleAuthService;

@Service
public class RoleAuthServiceImpl extends GeneralService<SysRoleAuth> implements RoleAuthService {

	private static final long serialVersionUID = -9177634375709144834L;
	
	private RoleAuthDao roleAuthDao;
	@Autowired
	public void setRoleAuthDao(RoleAuthDao roleAuthDao) {
		this.roleAuthDao = roleAuthDao;
	}
	
	public void addRoleAuths(final List<SysRoleAuth> ras) throws DataAccessException{
		roleAuthDao.saveSysRoleAuths(ras);
	}
	
	public void deleteRoleAuthsBySysRole(final SysRole sysRole) throws DataAccessException{
		roleAuthDao.deleteRoleAuthsBySysRole(sysRole);
	}

}
