package com.otrip.dao.trip.impl;   

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.LockMode;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.otrip.dao.GenericHibernateDao;
import com.otrip.dao.trip.ActiDayDao;
import com.otrip.dao.util.ConvertDataUtil;
import com.otrip.domain.trip.OtActiDay;
import com.otrip.domain.trip.OtActiInfo;

/**   
 * Filename:    ActiDayDaoImpl.java   
 * Copyright:   Copyright (c)2015  
 * Company:     otrip  
 * @version:    1.0   
 * @since:  JDK 1.7.0_21  
 * Create at:   2015年4月8日 下午9:38:04   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年4月8日 zhongJc      1.0     1.0 Version   
 */
@Component("actiDayDao")
public class ActiDayDaoImpl extends GenericHibernateDao<OtActiDay, String> implements ActiDayDao {

	static Logger log=Logger.getLogger(ActiDayDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	public List<OtActiDay> queryOtActiDaysByOtActiInfoAndName(final OtActiInfo otActiInfo,final String name)throws DataAccessException{
		if(otActiInfo!=null&&StringUtils.isNotBlank(otActiInfo.getFsId())){
			StringBuffer queryHql=new StringBuffer(" select d from OtActiDay d where 1=1 and d.fsFlag=0 and d.otActiInfo.fsId='"+otActiInfo.getFsId()+"' ");
			if(StringUtils.isNotBlank(name)){
				queryHql.append(" and d.fsName like '%"+name+"%' ");
			}
			return super.find(queryHql.toString());
		}else{
			return null;
		}
	}

	@Override
	public boolean delActiDayById(String actiDayId) throws Exception {
		if(StringUtils.isNotBlank(actiDayId))
		{
			OtActiDay day=super.get(actiDayId);
			if(day!=null)
			{
				day.setFsFlag(true);
				super.update(day);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean checkDayNum(String dayNum) throws Exception {
		int days=ConvertDataUtil.StringToInt(dayNum);
		String hql="from OtActiDay a where a.fnDays=?";
		List list=super.find(hql, new Integer[]{days});
		if(list.size()!=0)
		{
			return true;
		}
		return false;
	}
	
}
