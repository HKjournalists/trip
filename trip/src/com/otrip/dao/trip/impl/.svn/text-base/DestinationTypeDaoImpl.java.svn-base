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
import com.otrip.dao.system.impl.MenuTypeDaoImpl;
import com.otrip.dao.trip.DestinationTypeDao;
import com.otrip.dao.util.ConvertDataUtil;
import com.otrip.domain.trip.OtActiDestination;
import com.otrip.domain.trip.OtActiDestinationType;
import com.otrip.domain.trip.OtActiType;

/**   
 * Filename:    DestinationTypeDaoImpl.java   
 * Copyright:   Copyright (c)2015  
 * Company:     otrip  
 * @version:    1.0   
 * @since:  JDK 1.7.0_21  
 * Create at:   2015年3月26日 上午11:08:23   
 * Description:  景区类型
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年3月26日 zhongJc      1.0     1.0 Version   
 */
@Component("destinationTypeDao")
public class DestinationTypeDaoImpl extends GenericHibernateDao<OtActiDestinationType, String> implements DestinationTypeDao {
	
	static Logger log=Logger.getLogger(DestinationTypeDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	public List<OtActiDestinationType> queryOtActiDestinationTypes(final OtActiDestinationType otActiDestinationType) throws Exception{
		StringBuffer queryHql=new StringBuffer(" select ad from OtActiDestinationType ad where 1=1 ");
		if(otActiDestinationType!=null){
			if(StringUtils.isNotBlank(otActiDestinationType.getFsName())){
				queryHql.append(" and ad.fsName like '%"+otActiDestinationType.getFsName()+"%'");
			}
			if(StringUtils.isNotBlank(otActiDestinationType.getFsSign())){
				queryHql.append(" and ad.fsSign like '%"+otActiDestinationType.getFsSign()+"%' ");
			}
		}
		return super.find(queryHql.toString());
	}

	
	public void saveOtActiDestinationType(final OtActiDestinationType otActiDestinationType)throws Exception{
		if(otActiDestinationType!=null&&StringUtils.isNotBlank(otActiDestinationType.getFsId())){
			super.save(otActiDestinationType);
		}
	}


	@Override
	public boolean updateOtActiDestinationTypeBySql(OtActiDestinationType otacti)
			throws Exception {
		if(StringUtils.isNotBlank(otacti.getFsId()))
		{
			OtActiDestinationType oadt=super.get(otacti.getFsId());
			StringBuffer sb=new StringBuffer();
			sb.append("update ot_acti_destination_type set ");
			boolean flag=false;
			log.info(oadt.getFsSign()+"::"+otacti.getFsSign());
			if(!oadt.getFsName().equals(otacti.getFsName()))
			{
				sb.append("fs_name='"+otacti.getFsName()+"' ,");
				flag=true;
			}
			if(!oadt.getFsSign().equals(otacti.getFsSign()))
			{
				sb.append("fs_sign='" +otacti.getFsSign()+"' ,");
				flag=true;
			}
			if(flag)
			{
				sb.append("fd_update_time='"+ConvertDataUtil.getNow()+"' ");
				sb.append("where fs_id='"+otacti.getFsId()+"' ");
				log.info("update sql:"+sb.toString());
				super.updateBySQL(sb.toString());
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断输入内容是否存在重复
	 * @param name
	 * @param value
	 * @return true 不存在重复记录
	 */
	public boolean judgeInput(String name,String value)
	{
		if(name.equals("fsSign"))
		{
			String hql="from OtActiDestinationType o where o.fsSign=?";
			int i=super.find(hql, new String[]{value}).size();
		
			return i==0?true:false;
		}
		else if(name.equals("fsName"))
		{
			String hql="from OtActiDestinationType o where o.fsName=?";
			int i=super.find(hql, new String[]{value}).size();
			return i==0?true:false;
		}
		return false;
		
	}

}
