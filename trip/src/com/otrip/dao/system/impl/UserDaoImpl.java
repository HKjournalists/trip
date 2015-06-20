package com.otrip.dao.system.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.LockMode;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.otrip.dao.GenericHibernateDao;
import com.otrip.dao.system.UserDao;
import com.otrip.domain.system.SysUser;
import com.otrip.util.OtripConstants;

@Component(value="userDao")
public class UserDaoImpl extends GenericHibernateDao<SysUser, String> implements UserDao {

	static Logger log=Logger.getLogger(UserDaoImpl.class); 
	
	private JdbcTemplate jdbcTemplate;
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	@SuppressWarnings("unchecked")
	public SysUser findUserByAccount(final String account){
		if(StringUtils.isNotBlank(account)){
			String [] params=new String []{account};
			StringBuffer hql=new StringBuffer(" from SysUser u where 1=1 and u.fsAccount = ? ");
			final List<SysUser> users=this.find(hql.toString(), params);
			if(users!=null&&users.size()==1){
				return users.get(0);
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
	
	public SysUser saveWsSysUser(final SysUser sysUser) throws Exception{
		if(sysUser!=null&&StringUtils.isNotBlank(sysUser.getFsId())){
			super.save(sysUser);
			return sysUser;
		}else{
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<SysUser> queryManagerUser(final SysUser queryUser)throws Exception{
		StringBuffer queryHql=new StringBuffer();
		queryHql.append(" select su from SysUser su where 1=1 ");
		queryHql.append(" and su.fsTypeSign='"+OtripConstants.getWsBackUserTypeSign()+"' ");
		if(StringUtils.isNotBlank(queryUser.getFsAccount())){
			queryHql.append(" and su.fsAccount like '%"+queryUser.getFsAccount()+"%' ");
		}
		if(StringUtils.isNotBlank(queryUser.getFsName())){
			queryHql.append(" and su.fsName like '%"+queryUser.getFsName()+"%' ");
		}
		if(StringUtils.isNotBlank(queryUser.getFsEmail())){
			queryHql.append(" and su.fsEmail like '%"+queryUser.getFsEmail()+"%' ");
		}
		return super.find(queryHql.toString());
	}
	
	public List<SysUser> queryFrontUser(final SysUser queryUser)throws Exception{
		
		StringBuffer queryHql=new StringBuffer();
		queryHql.append(" select su from SysUser su where 1=1 ");
		queryHql.append(" and su.fsTypeSign='"+OtripConstants.getWsFrontUserTypeSign()+"' ");
		if(StringUtils.isNotBlank(queryUser.getFsAccount())){
			queryHql.append(" and su.fsAccount like '%"+queryUser.getFsAccount()+"%' ");
		}
		if(StringUtils.isNotBlank(queryUser.getFsName())){
			queryHql.append(" and su.fsName like '%"+queryUser.getFsName()+"%' ");
		}
		if(StringUtils.isNotBlank(queryUser.getFsEmail())){
			queryHql.append(" and su.fsEmail like '%"+queryUser.getFsEmail()+"%' ");
		}
		return super.find(queryHql.toString());
	}
	

	

}
