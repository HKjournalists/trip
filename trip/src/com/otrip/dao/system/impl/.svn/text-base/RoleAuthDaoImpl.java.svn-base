package com.otrip.dao.system.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.otrip.dao.GenericHibernateDao;
import com.otrip.dao.system.RoleAuthDao;
import com.otrip.domain.system.SysRole;
import com.otrip.domain.system.SysRoleAuth;

@Component(value="roleAuthDao")
public class RoleAuthDaoImpl extends GenericHibernateDao<SysRoleAuth, String> implements RoleAuthDao {

	static final Logger log=Logger.getLogger(RoleAuthDaoImpl.class);
	
	public void saveSysRoleAuths(final List<SysRoleAuth> ras) throws DataAccessException{
		if(ras!=null&&ras.size()>0){
			super.batchSaveEntity(ras);
		}
	}
	
	public void deleteRoleAuthsBySysRole(final SysRole sysRole) throws DataAccessException{
		if(sysRole!=null&&StringUtils.isNotBlank(sysRole.getFsId())){
			StringBuffer sbDeleteHql=new StringBuffer(" delete from SysRoleAuth ra where ra.sysRole.fsId='"+sysRole.getFsId()+"'");
			super.bulkUpdate(sbDeleteHql.toString());
		}
	}
	
}
