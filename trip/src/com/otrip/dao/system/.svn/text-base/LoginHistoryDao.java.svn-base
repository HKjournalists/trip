package com.otrip.dao.system;

import java.util.List;

import com.otrip.dao.IGenericDao;
import com.otrip.domain.system.SysLoginHistory;

public interface LoginHistoryDao extends IGenericDao<SysLoginHistory, String> {
	
	public SysLoginHistory addSysLoginHistory(final SysLoginHistory sysLoginHistory);
	
	public void updateLoginHistoryLogoutTime(final String loginHistoryId) throws RuntimeException;
	
	public void updateOldLoginHistoryTimeIsNull(final String loginUserId) throws RuntimeException;
	
	public List<SysLoginHistory> querySysLoginHistories(final SysLoginHistory sysLoginHistory)throws Exception;

}
