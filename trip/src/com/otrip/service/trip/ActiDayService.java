package com.otrip.service.trip;   

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.otrip.domain.trip.OtActiDay;
import com.otrip.domain.trip.OtActiInfo;
import com.otrip.service.IService;

/**   
 * Filename:    ActiDayService.java   
 * Copyright:   Copyright (c)2015  
 * Company:     otrip  
 * @version:    1.0   
 * @since:  JDK 1.7.0_21  
 * Create at:   2015年4月8日 下午9:48:11   
 * Description:  日程安排业务类
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年4月8日 zhongJc      1.0     1.0 Version   
 */
public interface ActiDayService extends IService {
	
	public List<OtActiDay> queryOtActiDaysByOtActiInfoAndName(final OtActiInfo otActiInfo,final String name)throws DataAccessException;
	
	public void saveOtActiDay(final OtActiDay otActiDay)throws DataAccessException;
	
	public OtActiDay queryOtActiDayById(final String id)throws Exception;
	
	public void updateOtActiDay(final OtActiDay otActiDay)throws DataAccessException;
	
	public boolean delOtActiDayById(final String dayId)throws Exception;
	
	public boolean checkDayNum(String dayNum)throws Exception;

}
