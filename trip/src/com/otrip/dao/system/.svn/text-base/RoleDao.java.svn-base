package com.otrip.dao.system;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.otrip.controls.system.vo.RoleVo;
import com.otrip.dao.IGenericDao;
import com.otrip.domain.system.SysRole;

public interface RoleDao extends IGenericDao<SysRole, String> {
	
	public List<RoleVo> querySysRole(final SysRole sysRole) throws DataAccessException;
	
	public SysRole findSysRoleByHqlAndId(final String id)throws DataAccessException;
	
	public List<SysRole> findChildRoleByParentRoleId(final String parentRoleId) throws DataAccessException;
	
	public List<SysRole> findAllSysRoleNoRootRole() throws Exception;
	
	public List<SysRole> findSysRolesByIdS(final String [] ids) throws DataAccessException;

}
