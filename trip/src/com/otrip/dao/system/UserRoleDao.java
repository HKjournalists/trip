package com.otrip.dao.system;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.otrip.dao.IGenericDao;
import com.otrip.domain.system.SysUserRole;

public interface UserRoleDao extends IGenericDao<SysUserRole, String> {
	
	public void saveSysUserRoles(final List<SysUserRole> urList) throws DataAccessException;

}
