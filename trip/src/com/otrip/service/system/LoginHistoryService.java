package com.otrip.service.system;

import java.util.List;

import com.otrip.domain.system.SysLoginHistory;
import com.otrip.service.IService;

public interface LoginHistoryService extends IService {
	
	public SysLoginHistory addLoginHistory(final SysLoginHistory sysLoginHistory);
	
	public void updateLoginHistoryLogoutTime(final String loginHistoryId) throws RuntimeException;
	
	public void updateOldLoginHistoryTimeIsNull(final String loginUserId) throws RuntimeException;
	
	public List<SysLoginHistory> querySysLoginHistories(final SysLoginHistory sysLoginHistory)throws Exception;
	
	public void deleteSysLoginHistory(final String id)throws Exception;

}
