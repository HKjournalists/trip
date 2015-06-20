package com.otrip.dao.system.impl;


import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.otrip.dao.GenericHibernateDao;
import com.otrip.dao.system.LoginHistoryDao;
import com.otrip.domain.DomainUtils;
import com.otrip.domain.system.SysLoginHistory;
import com.otrip.domain.system.SysUser;
import com.otrip.util.Common;

@Component(value="loginHistoryDao")
public class LoginHistoryDaoImpl extends GenericHibernateDao<SysLoginHistory, String> implements LoginHistoryDao {
	
	static Logger log=Logger.getLogger(LoginHistoryDaoImpl.class);
	
	/**
	 * @see 新增登入历史记录
	 * @param SysLoginHistory
	 * @return
	 */
	public SysLoginHistory addSysLoginHistory(final SysLoginHistory sysLoginHistory){
		if(sysLoginHistory!=null&&sysLoginHistory.getSysUser()!=null&&StringUtils.isNotBlank(sysLoginHistory.getSysUser().getFsId())){
			sysLoginHistory.setFsId(DomainUtils.generalUuid());
			this.save(sysLoginHistory);
		}
		return sysLoginHistory;
	}
	
	/**
	 * @see 更新登入历史记录
	 * @param loginHistoryId
	 */
	public void updateLoginHistoryLogoutTime(final String loginHistoryId) throws RuntimeException{
		if(StringUtils.isNotBlank(loginHistoryId)){
			final String updateHql=" update SysLoginHistory set fdLogoutTime='"+Common.fromDateH()+"' where fsId='"+loginHistoryId+"'";
			final int updateCount=this.bulkUpdate(updateHql);
			if(updateCount<=0){
				throw new RuntimeException("登出出错！");
			}
		}
	}
	
	public void updateOldLoginHistoryTimeIsNull(final String loginUserId) throws RuntimeException{
		try{
			if(StringUtils.isNotBlank(loginUserId)){
				final String updateHql=" update SysLoginHistory set fdLogoutTime='"+Common.fromDateH()+"' where sysUser.fsId='"+loginUserId+"' and fdLogoutTime is null ";
				this.bulkUpdate(updateHql);
			}
		}catch (Exception e){
			throw new RuntimeException("更新旧登入信息！");
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<SysLoginHistory> querySysLoginHistories(final SysLoginHistory sysLoginHistory)throws Exception{
		StringBuffer queryHql=new StringBuffer(" select lh from SysLoginHistory lh where 1=1 ");
		if(sysLoginHistory!=null){
			if(StringUtils.isNotBlank(sysLoginHistory.getFsIp())){
				queryHql.append(" and lh.fsIp like '%"+sysLoginHistory.getFsIp()+"%' ");
			}
			if(sysLoginHistory.getSysUser()!=null&&StringUtils.isNotBlank(sysLoginHistory.getSysUser().getFsName())){
				queryHql.append(" and lh.sysUser.fsName like '%"+sysLoginHistory.getSysUser().getFsName()+"%' ");
			}
			if(sysLoginHistory.getFdLoginTime()!=null){
				queryHql.append(" and lh.fdLoginTime = '"+sysLoginHistory.getFdLoginTime()+"' ");
			}
			if(sysLoginHistory.getFdLogoutTime()!=null){
				queryHql.append(" and lh.fdLogoutTime = '"+sysLoginHistory.getFdLogoutTime()+"' ");
			}
		}
		return super.find(queryHql.toString());
	}

	
}
