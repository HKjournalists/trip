package com.otrip.dao.system;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.otrip.dao.IGenericDao;
import com.otrip.domain.system.SysRole;
import com.otrip.domain.system.SysRoleAuth;

public interface RoleAuthDao extends IGenericDao<SysRoleAuth, String> {
	
	public void saveSysRoleAuths(final List<SysRoleAuth> ras) throws DataAccessException;
	
	public void deleteRoleAuthsBySysRole(final SysRole sysRole) throws DataAccessException;

}
