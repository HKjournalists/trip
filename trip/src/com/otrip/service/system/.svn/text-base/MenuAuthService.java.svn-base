package com.otrip.service.system;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.otrip.controls.system.vo.MenuVo;
import com.otrip.domain.system.SysMenuAuth;
import com.otrip.domain.system.SysMenuType;
import com.otrip.service.IService;

public interface MenuAuthService extends IService {
	
	public List<SysMenuAuth> loadAllMenu() throws RuntimeException;
	
	public SysMenuAuth loadSysMenuAuthById(final String menuId) throws RuntimeException;
	
	public List<SysMenuAuth>  findMenuIncludeLinksOrButtons(final SysMenuAuth parentMenu) throws RuntimeException;
	
	public List<MenuVo> queryMenuIncludeLinkOrButtons(final SysMenuAuth parentMenu,final MenuVo queryVo) throws RuntimeException;
	
	public SysMenuAuth	loadSysMenuAuth(final String id) throws DataAccessException;
	
	public SysMenuAuth addSysMenuAuth(final SysMenuAuth sysMenuAuth) throws DataAccessException;
	
	public List<SysMenuAuth> findChildsMenuByParentId(final String parentId) throws DataAccessException;
	
	public void deleteSysMenuAuthById(final String id)throws DataAccessException;
	
	public SysMenuAuth findSysMenuAuthById(final String id)throws DataAccessException;
	
	public List<SysMenuAuth> findSysMenuAuthByMenuType(final SysMenuType sysMenuType) throws DataAccessException;
	
	public List<SysMenuAuth> findSysMenuAuthByIdS(final String [] ids) throws DataAccessException;
	
}
