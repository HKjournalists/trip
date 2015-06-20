package com.otrip.service.system.impl;

import java.util.List;

import org.apache.batik.ext.awt.image.rendered.CachableRed;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.otrip.controls.system.vo.MenuVo;
import com.otrip.dao.system.MenuAuthDao;
import com.otrip.domain.DomainUtils;
import com.otrip.domain.system.SysMenuAuth;
import com.otrip.domain.system.SysMenuType;
import com.otrip.service.GeneralService;
import com.otrip.service.system.MenuAuthService;

@Service
public class MenuAuthServiceImpl extends GeneralService<SysMenuAuth> implements MenuAuthService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2108797384325822568L;
	
	
	private MenuAuthDao menuAuthDao;
	@Autowired
	public void setMenuAuthDao(MenuAuthDao menuAuthDao) {
		this.menuAuthDao = menuAuthDao;
	}
	
	
	public List<SysMenuAuth> loadAllMenu() throws RuntimeException{
		return menuAuthDao.loadAllMenu();
	}
	
	public SysMenuAuth loadSysMenuAuthById(final String menuId) throws RuntimeException{
		return menuAuthDao.loadSysMenuAuthById(menuId);
	}

	public List<SysMenuAuth>  findMenuIncludeLinksOrButtons(final SysMenuAuth parentMenu) throws RuntimeException{
		return menuAuthDao.findMenuIncludeLinksOrButtons(parentMenu);
	}
	
	public List<MenuVo> queryMenuIncludeLinkOrButtons(final SysMenuAuth parentMenu,final MenuVo queryVo) throws RuntimeException{
		return menuAuthDao.queryMenuIncludeLinkOrButtons(parentMenu, queryVo);
	}
	
	public SysMenuAuth	loadSysMenuAuth(final String id) throws DataAccessException{
		if(StringUtils.isNotBlank(id)){
			return menuAuthDao.load(id);
		}else{
			return null;
		}
	}
	
	public SysMenuAuth addSysMenuAuth(final SysMenuAuth sysMenuAuth) throws DataAccessException{
		if(sysMenuAuth!=null&&StringUtils.isNotBlank(sysMenuAuth.getFsParentId())&&StringUtils.isNotBlank(sysMenuAuth.getFsName())){
			sysMenuAuth.setFsId(DomainUtils.generalUuid());
			menuAuthDao.save(sysMenuAuth);
			return sysMenuAuth;
		}else{
			return null;
		}
	}
	
	public List<SysMenuAuth> findChildsMenuByParentId(final String parentId) throws DataAccessException{
		return menuAuthDao.findChildsMenuByParentId(parentId);
	}
	
	public void deleteSysMenuAuthById(final String id)throws DataAccessException{
		if(StringUtils.isNotBlank(id)){
			menuAuthDao.deleteByKey(id);
		}
	}
	
	public SysMenuAuth findSysMenuAuthById(final String id)throws DataAccessException{
		return menuAuthDao.findSysMenuAuthById(id);
	}
	
	public List<SysMenuAuth> findSysMenuAuthByMenuType(final SysMenuType sysMenuType) throws DataAccessException{
		return menuAuthDao.findSysMenuAuthByMenuType(sysMenuType);
	}
	
	public List<SysMenuAuth> findSysMenuAuthByIdS(final String [] ids) throws DataAccessException{
		return menuAuthDao.findSysMenuAuthByIdS(ids);
	}
	
	
}
