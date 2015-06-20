package com.otrip.dao.trip;   

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.otrip.dao.IGenericDao;
import com.otrip.domain.trip.OtActiDay;
import com.otrip.domain.trip.OtActiInfo;

/**   
 * Filename:    ActiDayDao.java   
 * Copyright:   Copyright (c)2015  
 * Company:     otrip  
 * @version:    1.0   
 * @since:  JDK 1.7.0_21  
 * Create at:   2015年4月8日 下午9:36:38   
 * Description:  活动日程表持久层操作类
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年4月8日 zhongJc      1.0     1.0 Version   
 */
public interface ActiDayDao extends IGenericDao<OtActiDay, String> {
	
	public List<OtActiDay> queryOtActiDaysByOtActiInfoAndName(final OtActiInfo otActiInfo,final String name)throws DataAccessException;
	
	public boolean delActiDayById(final String actiDayId) throws Exception ; 
	
	public boolean checkDayNum(String dayNum) throws Exception;

}
