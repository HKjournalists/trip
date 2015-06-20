package com.otrip.service.system;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.otrip.domain.system.SysLoginHistory;
import com.otrip.domain.system.SysMenuAuth;
import com.otrip.domain.system.SysResource;
import com.otrip.domain.system.SysUser;
import com.otrip.service.IService;

public interface AccessService extends IService {
	
	public SysUser findUserByAccount(final String account);
	
	public List<SysMenuAuth> findUserMenuAuth(final SysUser user);
 
	public List<SysResource> findUserResource(final SysUser user);
	
	public Collection<GrantedAuthority> loadUserAllAuthorityByUser(final SysUser user);
	
	public SysLoginHistory addLoginHistory(final SysLoginHistory sysLoginHistory);
	
	public void updateLoginHistoryLogoutTime(final String loginHistoryId) throws RuntimeException;
	
	public void updateOldLoginHistoryTimeIsNull(final String loginUserId) throws RuntimeException;
	
}
