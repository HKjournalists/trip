package com.otrip.service.trip.impl;   

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.otrip.dao.trip.ActiDayDao;
import com.otrip.domain.trip.OtActiDay;
import com.otrip.domain.trip.OtActiInfo;
import com.otrip.service.GeneralService;
import com.otrip.service.trip.ActiDayService;

/**   
 * Filename:    ActiDayServiceImpl.java   
 * Copyright:   Copyright (c)2015  
 * Company:     otrip  
 * @version:    1.0   
 * @since:  JDK 1.7.0_21  
 * Create at:   2015年4月8日 下午9:49:17   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年4月8日 zhongJc      1.0     1.0 Version   
 */
@Service("actiDayService")
public class ActiDayServiceImpl extends GeneralService<OtActiDay> implements ActiDayService {


	private static final long serialVersionUID = 6597419632446001935L;
	
	static Logger log=Logger.getLogger(ActiDayServiceImpl.class);
	
	private ActiDayDao actiDayDao;
	@Autowired
	public void setActiDayDao(ActiDayDao actiDayDao) {
		this.actiDayDao = actiDayDao;
	}
	
	
	@Override
	public List<OtActiDay> queryOtActiDaysByOtActiInfoAndName(OtActiInfo otActiInfo, String name) throws DataAccessException {
		// TODO Auto-generated method stub
		return actiDayDao.queryOtActiDaysByOtActiInfoAndName(otActiInfo, name);
	}
	
	public void saveOtActiDay(final OtActiDay otActiDay)throws DataAccessException{
		if(otActiDay!=null&&StringUtils.isNotBlank(otActiDay.getFsId())){
			actiDayDao.save(otActiDay);
			
		}
	}
	
	public OtActiDay queryOtActiDayById(final String id)throws Exception{
		return actiDayDao.get(id);
	}


	@Override
	public void updateOtActiDay(OtActiDay otActiDay) throws DataAccessException {
		// TODO Auto-generated method stub
		if(otActiDay!=null&&StringUtils.isNotBlank(otActiDay.getFsId())){
			
			OtActiDay OldotActiDay=actiDayDao.get(otActiDay.getFsId());
			boolean flag=false;
			if(OldotActiDay.getFnDays()!=otActiDay.getFnDays())
			{
				OldotActiDay.setFnDays(otActiDay.getFnDays());
				flag=true;
			}
			if(OldotActiDay.getFsLatitude().equals(otActiDay.getFsLatitude()))
			{
				OldotActiDay.setFsLatitude(otActiDay.getFsLatitude());
				flag=true;
			}
			if(OldotActiDay.getFsLongitude().equals(otActiDay.getFsLongitude()))
			{
				OldotActiDay.setFsLongitude(otActiDay.getFsLongitude());
				flag=true;
			}
			if(OldotActiDay.getFsDescription().equals(OldotActiDay.getFsDescription()))
			{
				OldotActiDay.setFsDescription(otActiDay.getFsDescription());
				flag=true;
			}
			if(OldotActiDay.getFsName().equals(OldotActiDay.getFsName()))
			{
				OldotActiDay.setFsName(otActiDay.getFsName());
				flag=true;
			}
			if(flag)
			{
				OldotActiDay.setFdUpdateTime(new Date());
				actiDayDao.saveOrUpdate(OldotActiDay);
			}
		}
	}


	@Override
	public boolean delOtActiDayById(String dayId) throws Exception {
		// TODO Auto-generated method stub
		actiDayDao.delActiDayById(dayId);
		return false;
	}


	@Override
	public boolean checkDayNum(String dayNum) throws Exception {
		if(StringUtils.isNotBlank(dayNum))
		{
			return actiDayDao.checkDayNum(dayNum);
		}
		return false;
	}

}
