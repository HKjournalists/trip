package com.otrip.dao.trip.impl;   

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.LockMode;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Component;

import com.otrip.dao.GenericHibernateDao;
import com.otrip.dao.trip.ActiTypeDao;
import com.otrip.dao.util.ConvertDataUtil;
import com.otrip.domain.trip.OtActiType;

/**   
 * Filename:    ActiTypeDaoImpl.java   
 * Copyright:   Copyright (c)2015  
 * Company:     otrip  
 * @version:    1.0   
 * @since:  JDK 1.7.0_21  
 * Create at:   2015年3月26日 上午10:42:46   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年3月26日 zhongJc      1.0     1.0 Version   
 */
@Component(value="actiTypeDao")
public class ActiTypeDaoImpl extends GenericHibernateDao<OtActiType, String> implements ActiTypeDao {

	static Logger log=Logger.getLogger(ActiTypeDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	public List<OtActiType> queryOtActiTypes(final OtActiType otActiType) throws Exception{
		StringBuffer queryHql=new StringBuffer(" select at from OtActiType at where 1=1 ");
		if(otActiType!=null){
			if(StringUtils.isNotBlank(otActiType.getFsName())){
				queryHql.append(" and at.fsName like '%"+otActiType.getFsName()+"%'");
			}
			if(StringUtils.isNotBlank(otActiType.getFsSign())){
				queryHql.append(" and at.fsSign like '%"+otActiType.getFsSign()+"%' ");
			}
		}
		return super.find(queryHql.toString());
	}

	
	public void saveOtActiType(final OtActiType otActiType)throws Exception{
		if(otActiType!=null&&StringUtils.isNotBlank(otActiType.getFsId())){
			super.save(otActiType);
		}
	}
	
	public boolean updateActiType(final OtActiType actiType) throws Exception
	{
		if(StringUtils.isNotBlank(actiType.getFsId()))
		{
			OtActiType ota=super.get(actiType.getFsId());
			StringBuffer sb=new StringBuffer();
			sb.append("update ot_acti_type set");
			if(!ota.getFsName().equals(actiType.getFsName()))
			{
				sb.append(" fs_name='"+actiType.getFsName()+"', ");
			}
			if(!ota.getFsSign().equals(actiType.getFsSign()))
			{
				sb.append(" fs_sign='"+actiType.getFsSign()+"', ");	
			}
			if(sb.lastIndexOf(",")>0)
			{
				sb.append(" fd_update_time='"+ConvertDataUtil.getNow()+"' ");
				sb.append("where fs_id='"+actiType.getFsId()+"'");
				log.info("update actiType sql: "+sb.toString());
				super.updateBySQL(sb.toString());
				return true;
			}
		}
		return false;
	}
	
	public boolean judgeInput(String name,String value)
	{
		if(name.equals("fsSign"))
		{
			String hql="from OtActiType o where o.fsSign=?";
			int i=super.find(hql, new String[]{value}).size();
		
			return i==0?true:false;
		}
		else if(name.equals("fsName"))
		{
			String hql="from OtActiType o where o.fsName=?";
			int i=super.find(hql, new String[]{value}).size();
			return i==0?true:false;
		}
		return false;
		
	}
	
}
