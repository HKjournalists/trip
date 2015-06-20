package com.otrip.dao.system.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.otrip.controls.system.vo.RoleVo;
import com.otrip.dao.GenericHibernateDao;
import com.otrip.dao.system.RoleDao;
import com.otrip.domain.system.SysMenuAuth;
import com.otrip.domain.system.SysRole;
import com.otrip.initdata.datacache.SystemDataCache;

@Component(value="roleDao")
public class RoleDaoImpl extends GenericHibernateDao<SysRole, String> implements RoleDao {
	
	static final  Logger log=Logger.getLogger(RoleDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	public List<RoleVo> querySysRole(final SysRole sysRole) throws DataAccessException{
		StringBuffer sbQueryHql=new StringBuffer(" select new com.otrip.controls.system.vo.RoleVo( ");
		sbQueryHql.append(" r.fsId,r.fsName,r.fsSign,r.fsStatus,r.sysRole.fsId,r.fnOrder,r.sysRole.fsName ");
		sbQueryHql.append(" ) ");
		sbQueryHql.append(" from  SysRole r where 1=1 ");
		if(sysRole!=null){
			if(StringUtils.isNotBlank(sysRole.getFsName())){
				sbQueryHql.append(" and r.fsName like '%"+sysRole.getFsName()+"%' ");
			}
			if(StringUtils.isNotBlank(sysRole.getFsSign())){
				sbQueryHql.append(" and r.fsSign like '%"+sysRole.getFsSign()+"%' ");
			}
			if(StringUtils.isNotBlank(sysRole.getFsStatus())){
				sbQueryHql.append(" and r.fsStatus = '"+sysRole.getFsStatus()+"' ");
			}
		}
		return super.find(sbQueryHql.toString());
	}
	
	@SuppressWarnings("unchecked")
	public SysRole findSysRoleByHqlAndId(final String id)throws DataAccessException{
		if(StringUtils.isNotBlank(id)){
			StringBuffer sbQueryHql=new StringBuffer(" from SysRole r where 1=1 ");
			sbQueryHql.append(" and r.fsId='"+id+"'");
			final List<SysRole> rList=super.find(sbQueryHql.toString());
			return rList!=null&&rList.size()>0?rList.get(0):null;
		}else{
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<SysRole> findChildRoleByParentRoleId(final String parentRoleId) throws DataAccessException{
		if(StringUtils.isNotBlank(parentRoleId)){
			StringBuffer sbQueryHql=new StringBuffer(" from SysRole r where r.sysRole.fsId='"+parentRoleId+"'");
			return super.find(sbQueryHql.toString());
		}else{
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<SysRole> findAllSysRoleNoRootRole() throws Exception{
		StringBuffer queryHQL=new StringBuffer(" select r from SysRole r where 1=1 ");
		queryHQL.append(" and r.fsSign!='"+SystemDataCache.getRoleRootSign()+"'");
		return super.find(queryHQL.toString());
	}
	
	public List<SysRole> findSysRolesByIdS(final String [] ids) throws DataAccessException{
		if(ids!=null&&ids.length>0){
			StringBuffer sbQueryHql=new StringBuffer(" SELECT r FROM SysRole r WHERE r.fsId in (:ids)" );
			return super.findByInCondition(sbQueryHql.toString(), "ids", ids);
		}
		return null;
	}

}
