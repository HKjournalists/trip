package com.otrip.security;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.otrip.domain.system.SysMenuAuth;
import com.otrip.domain.system.SysUser;
import com.otrip.service.system.AccessService;


/**
 * @see 从数据库中读入用户的密码、角色信息，是否被锁定账户是否过期
 * @author Administrator
 *
 */
public class OtripUserDetailService implements UserDetailsService{
	
	private AccessService accessService;
	
	@Autowired
	public void setAccessService(AccessService accessService) {
		this.accessService = accessService;
	}

	@Override
	public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException,DataAccessException {
		// TODO Auto-generated method stub

		final SysUser user = accessService.findUserByAccount(username);
		if(!(user!=null)){
			throw new UsernameNotFoundException("没有找到用户!");
		}
		final List<SysMenuAuth> ownerAuthority=accessService.findUserMenuAuth(user);
		//accessService.findUserMenuAuth(user);
		final String password=user.getFsPassword();
		// 获得用户权限
		final Collection<GrantedAuthority> auths = accessService.loadUserAllAuthorityByUser(user);
		boolean enabled = true;
		// 账户过期否
		boolean accountNonExpired = true;
		// 证书过期否
		boolean credentialsNonExpired = true;
		// 账户锁定否
		boolean accountNonLocked = true;
		// 封装成spring security的user
		LoginUser loginUser = new LoginUser(password,user.getFsName(),user.getFsEmail(),user,ownerAuthority,username,auths,accountNonExpired,accountNonLocked,credentialsNonExpired,enabled);
		return loginUser;
	}

}
