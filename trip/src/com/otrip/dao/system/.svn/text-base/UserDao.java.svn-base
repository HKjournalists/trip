package com.otrip.dao.system;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.otrip.dao.IGenericDao;
import com.otrip.domain.system.SysUser;

/**
 * @see 用户接口
 * @author Administrator
 *
 */
public interface UserDao extends IGenericDao<SysUser, String> {
	
	public SysUser findUserByAccount(final String account);
	
	public SysUser saveWsSysUser(final SysUser sysUser) throws Exception;
	
	public List<SysUser> queryManagerUser(final SysUser queryUser)throws Exception;
	
	public List<SysUser> queryFrontUser(final SysUser queryUser)throws Exception;
}
