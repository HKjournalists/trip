package com.otrip.service.system;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.otrip.controls.system.vo.RoleVo;
import com.otrip.domain.system.SysRole;
import com.otrip.service.IService;

public interface RoleService extends IService {
	
	public List<RoleVo> querySysRole(final SysRole sysRole) throws DataAccessException;
	
	public SysRole findSysRoleByHqlAndId(final String id)throws DataAccessException;
	
	public SysRole loadSysRole(final String id) throws DataAccessException;
	
	public void deleteSysRoleById(final String id)throws DataAccessException;
	
	public SysRole addRole(final SysRole sysRole) throws DataAccessException;
	
	public List<SysRole> findChildRoleByParentRoleId(final String parentRoleId) throws DataAccessException;
	
	public void deleteRole(final String roleId) throws DataAccessException;
	
	public List<SysRole> findAllSysRoleNoRootRole() throws Exception;
	
	public List<SysRole> findSysRolesByIdS(final String [] ids) throws DataAccessException;


}
