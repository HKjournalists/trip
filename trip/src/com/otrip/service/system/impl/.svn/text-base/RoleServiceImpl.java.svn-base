package com.otrip.service.system.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.opensaml.samlext.saml2mdui.DomainHint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.otrip.controls.system.vo.RoleVo;
import com.otrip.dao.system.RoleDao;
import com.otrip.domain.DomainUtils;
import com.otrip.domain.system.SysRole;
import com.otrip.service.GeneralService;
import com.otrip.service.system.RoleService;

@Service
public class RoleServiceImpl extends GeneralService<SysRole> implements RoleService {

	private static final long serialVersionUID = -8695524282642929305L;
	
	static final Logger log=Logger.getLogger(RoleServiceImpl.class);
	
	private RoleDao roleDao;
	@Autowired
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}
	
	public List<RoleVo> querySysRole(final SysRole sysRole) throws DataAccessException{
		return roleDao.querySysRole(sysRole);
	}
	
	public SysRole findSysRoleByHqlAndId(final String id)throws DataAccessException{
		return roleDao.findSysRoleByHqlAndId(id);
	}
	
	public SysRole loadSysRole(final String id) throws DataAccessException{
		return roleDao.load(id);
	}
	
	public void deleteSysRoleById(final String id)throws DataAccessException{
		roleDao.deleteByKey(id);
	}
	
	public SysRole addRole(final SysRole sysRole) throws DataAccessException{
		if(sysRole!=null&&StringUtils.isNotBlank(sysRole.getFsName())){
			sysRole.setFsId(DomainUtils.generalUuid());
			roleDao.save(sysRole);
		}
		return sysRole;
	}
	
	public List<SysRole> findChildRoleByParentRoleId(final String parentRoleId) throws DataAccessException{
		return roleDao.findChildRoleByParentRoleId(parentRoleId);
	}
	
	public void deleteRole(final String roleId) throws DataAccessException{
		if(StringUtils.isNotBlank(roleId)){
			roleDao.deleteByKey(roleId);
		}
	}
	
	public List<SysRole> findAllSysRoleNoRootRole() throws Exception{
		return roleDao.findAllSysRoleNoRootRole();
	}

	public List<SysRole> findSysRolesByIdS(final String [] ids) throws DataAccessException{
		return roleDao.findSysRolesByIdS(ids);
	}

}
