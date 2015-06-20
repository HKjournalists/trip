package com.otrip.service.system.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otrip.dao.system.LoginHistoryDao;
import com.otrip.domain.system.SysLoginHistory;
import com.otrip.service.GeneralService;
import com.otrip.service.system.LoginHistoryService;

/**
 * @see 保存登入历史
 * @author Administrator
 *
 */
@Service
public class LoginHistoryServiceImpl extends GeneralService<SysLoginHistory> implements LoginHistoryService {

	private static final long serialVersionUID = -3871036007040705760L;
	
	private LoginHistoryDao loginHistoryDao;
	@Autowired
	public void setLoginHistoryDao(LoginHistoryDao loginHistoryDao) {
		this.loginHistoryDao = loginHistoryDao;
	}
	
	/**
	 * @see 新增登入历史
	 * @param SysLoginHistory
	 * @return
	 */
	public SysLoginHistory addLoginHistory(final SysLoginHistory sysLoginHistory){
		if(sysLoginHistory!=null&&sysLoginHistory.getSysUser()!=null&&StringUtils.isNotBlank(sysLoginHistory.getSysUser().getFsId())){
			return loginHistoryDao.addSysLoginHistory(sysLoginHistory);
		}
		return null;
	}
	
	public void updateLoginHistoryLogoutTime(final String loginHistoryId) throws RuntimeException{
		loginHistoryDao.updateLoginHistoryLogoutTime(loginHistoryId);
	}
	
	public void updateOldLoginHistoryTimeIsNull(final String loginUserId) throws RuntimeException{
		loginHistoryDao.updateOldLoginHistoryTimeIsNull(loginUserId) ;
	}
	
	public List<SysLoginHistory> querySysLoginHistories(final SysLoginHistory sysLoginHistory)throws Exception{
		return loginHistoryDao.querySysLoginHistories(sysLoginHistory);
	}
	
	public void deleteSysLoginHistory(final String id)throws Exception{
		if(StringUtils.isNotBlank(id)){
			loginHistoryDao.deleteByKey(id);
		}
	}

}
