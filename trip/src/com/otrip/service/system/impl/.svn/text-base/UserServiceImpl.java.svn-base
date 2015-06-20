package com.otrip.service.system.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.fop.fo.properties.DominantBaseline;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otrip.dao.system.UserDao;
import com.otrip.domain.DomainUtils;
import com.otrip.domain.system.SysUser;
import com.otrip.service.GeneralService;
import com.otrip.service.system.UserService;

@Service
public class UserServiceImpl extends GeneralService<SysUser> implements UserService {

	private static final long serialVersionUID = 6178070119641902396L;
	
	static Logger log=Logger.getLogger(UserServiceImpl.class);
	
	private UserDao userDao;
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public SysUser findUserByAccount(final String account){
		return userDao.findUserByAccount(account);
	}
	
	public SysUser saveManagerUser(final SysUser sysUser)throws Exception{
		if(sysUser!=null&&StringUtils.isNotBlank(sysUser.getFsId())){
			userDao.save(sysUser);
		}
		return sysUser;
	}
	
	public SysUser saveWsSysUser(final SysUser sysUser) throws Exception{
		if(sysUser!=null){
			sysUser.setFsId(DomainUtils.generalUuid());
			return userDao.saveWsSysUser(sysUser);
		}else{
			return null;
		}
	}
	
	public List<SysUser> queryManagerUser(final SysUser queryUser)throws Exception{
		return userDao.queryManagerUser(queryUser);
	}
	
	public List<SysUser> queryFrontUser(final SysUser queryUser)throws Exception{
		return userDao.queryFrontUser(queryUser);
	}
	
	
	

}
