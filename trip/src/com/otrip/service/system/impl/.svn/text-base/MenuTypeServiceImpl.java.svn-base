package com.otrip.service.system.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.otrip.dao.system.MenuTypeDao;
import com.otrip.domain.DomainUtils;
import com.otrip.domain.system.SysMenuType;
import com.otrip.service.GeneralService;
import com.otrip.service.system.MenuAuthService;
import com.otrip.service.system.MenuTypeService;
@Service
public class MenuTypeServiceImpl extends GeneralService<SysMenuType> implements MenuTypeService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7404781893917560356L;
	
	static Logger log=Logger.getLogger(MenuTypeServiceImpl.class);
	
	private MenuTypeDao menuTypeDao;
	@Autowired
	public void setMenuTypeDao(MenuTypeDao menuTypeDao) {
		this.menuTypeDao = menuTypeDao;
	}
	
	public List<SysMenuType> findSysMenuType(final SysMenuType sysMenuType) throws DataAccessException{
		return menuTypeDao.findSysMenuType(sysMenuType);
	}
	
	public SysMenuType loadMenuTypeById(final String id) throws DataAccessException{
		return menuTypeDao.load(id);
	}
	
	public SysMenuType findSysMenuTypeById(final String id)throws RuntimeException{
		return menuTypeDao.findSysMenuTypeById(id);
	}
	
	public void delSysMenuTypeById(final String id) throws RuntimeException{
		if(StringUtils.isNotBlank(id)){
			menuTypeDao.delSysMenuTypeById(id);
		}
	}
	
	public void addSysMenuType(final SysMenuType sysMenuType)throws DataAccessException{
		if(sysMenuType!=null&&StringUtils.isNotBlank(sysMenuType.getFsName())){
			sysMenuType.setFsId(DomainUtils.generalUuid());
			menuTypeDao.save(sysMenuType);
		}
	}
	
	public List<SysMenuType> findMenuModuleType() throws RuntimeException{
		return menuTypeDao.findMenuModuleType();
	}
	
	public List<SysMenuType> findMenuChildItemType() throws RuntimeException{
		return menuTypeDao.findMenuChildItemType();
	}
	
	public List<SysMenuType> findChildMenuType(final String parentTypeSign) throws RuntimeException{
		return menuTypeDao.findChildMenuType(parentTypeSign);
	}
	
	public List<SysMenuType> findAllMenuType()throws DataAccessException{
		return menuTypeDao.loadAll();
	}
	

}
