package com.otrip.service.system;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.otrip.domain.system.SysRole;
import com.otrip.domain.system.SysRoleAuth;
import com.otrip.service.IService;

public interface RoleAuthService extends IService {
	
	public void addRoleAuths(final List<SysRoleAuth> ras) throws DataAccessException;
	
	public void deleteRoleAuthsBySysRole(final SysRole sysRole) throws DataAccessException;

}
