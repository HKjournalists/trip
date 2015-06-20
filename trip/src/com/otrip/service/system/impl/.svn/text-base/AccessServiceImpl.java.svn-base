package com.otrip.service.system.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.otrip.dao.system.MenuAuthDao;
import com.otrip.dao.system.ResourceDao;
import com.otrip.dao.system.UserDao;
import com.otrip.domain.system.SysLoginHistory;
import com.otrip.domain.system.SysMenuAuth;
import com.otrip.domain.system.SysResource;
import com.otrip.domain.system.SysUser;
import com.otrip.service.GeneralService;
import com.otrip.service.system.AccessService;
import com.otrip.service.system.LoginHistoryService;

@Service
public class AccessServiceImpl extends GeneralService<SysUser> implements AccessService {

	private static final long serialVersionUID = -5197775615818639142L;


	static Logger log=Logger.getLogger(AccessServiceImpl.class);
	
	
	private UserDao userDao;
	private MenuAuthDao	menuAuthDao;
	private ResourceDao resourceDao;
	private LoginHistoryService loginHistoryService;
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Autowired
	public void setMenuAuthDao(MenuAuthDao menuAuthDao) {
		this.menuAuthDao = menuAuthDao;
	}
	@Autowired
	public void setResourceDao(ResourceDao resourceDao) {
		this.resourceDao = resourceDao;
	}
	@Autowired
	public void setLoginHistoryService(LoginHistoryService loginHistoryService) {
		this.loginHistoryService = loginHistoryService;
	}
	
	
	/**
	 * @see 根据账号查找用户
	 */
	public SysUser findUserByAccount(final String account){
		return userDao.findUserByAccount(account);
	}
	
	/**
	 * @see 查找用户权限
	 */
	@SuppressWarnings("unchecked")
	public List<SysMenuAuth> findUserMenuAuth(final SysUser user){
		if(user!=null&&StringUtils.isNotBlank(user.getFsId())){
			StringBuffer queryHql=new StringBuffer(" select ma from SysMenuAuth ma,SysRoleAuth ra,SysUserRole ur where 1=1 ");
			queryHql.append(" and ma=ra.sysMenuAuth and ra.sysRole=ur.sysRole ");
			queryHql.append(" and ur.sysUser.fsId='"+user.getFsId()+"' ");
			return menuAuthDao.find(queryHql.toString());
		}
		return null;
	}

	/**
	 * @see  查找用户资源权限
	 */
	@SuppressWarnings("unchecked")
	public List<SysResource> findUserResource(final SysUser user){
		if(user!=null&&StringUtils.isNotBlank(user.getFsId())){
			StringBuffer queryHql=new StringBuffer(" select r from SysResource r, SysMenuAuth ma,SysRoleAuth ra,SysUserRole ur where 1=1 ");
			queryHql.append(" and ma=ra.sysMenuAuth and ra.sysRole=ur.sysRole and r=ma.sysResource ");
			queryHql.append(" and ur.sysUser.fsId='"+user.getFsId()+"' ");
			return resourceDao.find(queryHql.toString());
		}
		return null;
	}
	
	/**
	 * @see 加载用户的security权限
	 */
	public Collection<GrantedAuthority> loadUserAllAuthorityByUser(final SysUser user){
		List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		
		Map<String,String> authTempMap=new HashMap<String,String>();
		//直接从用户权限关系获取权限，进入临时权限MAP集合
		final List<SysResource> crList=this.findUserResource(user);
		if(crList!=null&&crList.size()>0){
			for(int index=0;index<crList.size();index++){
				final SysResource cr=crList.get(index);
				if(cr!=null&&StringUtils.isNotBlank(cr.getFsId())){
					if(!authTempMap.containsKey(cr.getFsId())){
						authTempMap.put(cr.getFsId(), cr.getFsKey());
					}
				}				
			}
		}
		
		//将临时权限MAP集合，放入返回对象中
		if(authTempMap.size()>0){
			Collection<String> authorCodes=authTempMap.values();
			Iterator<String> iter=authorCodes.iterator();
			while(iter.hasNext()){
				final String ahthCode=iter.next();
				SimpleGrantedAuthority authority = new SimpleGrantedAuthority(ahthCode);
		        auths.add(authority);
			}
		}
		return auths;
	}
	
	/**
	 * @see 新增历史肌瘤
	 * @param SysLoginHistory
	 * @return
	 */
	public SysLoginHistory addLoginHistory(final SysLoginHistory sysLoginHistory){
		if(sysLoginHistory!=null&&sysLoginHistory.getSysUser()!=null&&StringUtils.isNotBlank(sysLoginHistory.getSysUser().getFsId())){
			return loginHistoryService.addLoginHistory(sysLoginHistory);
		}else{
			return null;
		}
	}
	
	public void updateLoginHistoryLogoutTime(final String loginHistoryId) throws RuntimeException{
		loginHistoryService.updateLoginHistoryLogoutTime(loginHistoryId);
	}
	
	public void updateOldLoginHistoryTimeIsNull(final String loginUserId) throws RuntimeException{
		loginHistoryService.updateOldLoginHistoryTimeIsNull(loginUserId);
	}
	
}
