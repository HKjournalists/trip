package com.otrip.service.system;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DataAccessException;

import com.otrip.domain.system.SysMenuType;
import com.otrip.service.IService;

public interface MenuTypeService extends IService {
	
	public List<SysMenuType> findSysMenuType(final SysMenuType sysMenuType) throws DataAccessException;
	
	public SysMenuType loadMenuTypeById(final String id) throws DataAccessException;
	
	public SysMenuType findSysMenuTypeById(final String id)throws RuntimeException;
	
	public void delSysMenuTypeById(final String id) throws RuntimeException;
	
	public void addSysMenuType(final SysMenuType sysMenuType)throws DataAccessException;
	
	public List<SysMenuType> findMenuModuleType() throws RuntimeException;
	
	public List<SysMenuType> findMenuChildItemType() throws RuntimeException;
	
	public List<SysMenuType> findChildMenuType(final String parentTypeSign) throws RuntimeException;
	
	public List<SysMenuType> findAllMenuType()throws DataAccessException;

}
