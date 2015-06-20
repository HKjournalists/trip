package com.otrip.dao.system;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DataAccessException;

import com.otrip.dao.IGenericDao;
import com.otrip.domain.system.SysMenuType;

public interface MenuTypeDao extends IGenericDao<SysMenuType, String> {
	
	public List<SysMenuType> findSysMenuType(final SysMenuType sysMenuType) throws DataAccessException;
	
	public SysMenuType findSysMenuTypeById(final String id)throws RuntimeException;
	
	public void delSysMenuTypeById(final String id) throws RuntimeException;
	
	public List<SysMenuType> findMenuModuleType() throws RuntimeException;
	
	public List<SysMenuType> findMenuChildItemType() throws RuntimeException;
	
	public List<SysMenuType> findChildMenuType(final String parentTypeSign) throws RuntimeException;

}
