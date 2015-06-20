package com.otrip.dao.trip.impl;   

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.LockMode;
import org.hibernate.criterion.DetachedCriteria;
import org.junit.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.otrip.dao.GenericHibernateDao;
import com.otrip.dao.trip.DestinationDao;
import com.otrip.domain.trip.OtActiDestination;

/**   
 * Filename:    DestinationDaoImpl.java   
 * Copyright:   Copyright (c)2015  
 * Company:     otrip  
 * @version:    1.0   
 * @since:  JDK 1.7.0_21  
 * Create at:   2015年3月28日 下午10:08:25   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年3月28日 zhongJc      1.0     1.0 Version   
 */
@Component("destinationDao")
public class DestinationDaoImpl extends GenericHibernateDao<OtActiDestination, String> implements DestinationDao {
	
	static Logger log=Logger.getLogger(DestinationDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	public List<OtActiDestination> queryOtActiDestinations(final OtActiDestination otActiDestination)throws Exception{
		StringBuffer queryHql=new StringBuffer("select ad from OtActiDestination ad where 1=1 ");
		if(otActiDestination!=null){
			if(StringUtils.isNotBlank(otActiDestination.getFsName())){
				queryHql.append(" and ad.fsName like '%"+otActiDestination.getFsName()+"%' ");
			}
		}
		return super.find(queryHql.toString());
	}
	
	@SuppressWarnings("unchecked")
	public List<OtActiDestination> findAllOtActiDestinations() throws Exception{
		return super.find(" select ad from OtActiDestination ad where 1=1 ");
	}
	
	@SuppressWarnings("unchecked")
	public List<OtActiDestination> findChildsOtActiDestinations(final String parentId,final OtActiDestination otActiDestination)throws Exception{
		if(StringUtils.isNotBlank(parentId)){
			StringBuffer queryHql=new StringBuffer("select ad from OtActiDestination ad where 1=1 and ad.fsParentId='"+parentId+"'");
			if(otActiDestination!=null){
				if(StringUtils.isNotBlank(otActiDestination.getFsName())){
					queryHql.append(" and ad.fsName like '%"+otActiDestination.getFsName()+"%' ");
				}
			}
			return super.find(queryHql.toString());
		}else{
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<OtActiDestination> findChildsOtActiDestinationsByName(final String parentId,final String destinationName)throws Exception{
		if(StringUtils.isNotBlank(parentId)){
			StringBuffer queryHql=new StringBuffer("select ad from OtActiDestination ad where 1=1 and ad.fsParentId='"+parentId+"'");
			if(StringUtils.isNotBlank(destinationName)){
				queryHql.append(" and ad.fsName like '%"+destinationName+"%' ");
			}
			return super.find(queryHql.toString());
		}else{
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<OtActiDestination> findOtActiDestinationsByParentId(final String parentId)throws DataAccessException{
		if(StringUtils.isNotBlank(parentId)){
			StringBuffer queryHql=new StringBuffer(" select ad from OtActiDestination ad where 1=1 ");
			queryHql.append(" and ad.fsParentId='"+parentId+"'");
			return super.find(queryHql.toString());
		}else{
			return null;
		}
	}


	
	
}
