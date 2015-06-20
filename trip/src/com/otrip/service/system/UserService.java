package com.otrip.service.system;

import java.util.List;

import com.otrip.domain.system.SysUser;
import com.otrip.service.IService;

public interface UserService extends IService {
	
	public SysUser findUserByAccount(final String account);
	
	public SysUser saveWsSysUser(final SysUser sysUser) throws Exception;
	
	public List<SysUser> queryManagerUser(final SysUser queryUser)throws Exception;
	
	public List<SysUser> queryFrontUser(final SysUser queryUser)throws Exception;
	
	public SysUser saveManagerUser(final SysUser sysUser)throws Exception;
	
	
}
