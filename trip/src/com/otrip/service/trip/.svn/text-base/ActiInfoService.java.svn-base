package com.otrip.service.trip;   

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.otrip.domain.trip.OtActiInfo;
import com.otrip.service.IService;

/**   
 * Filename:    ActiInfoService.java   
 * Copyright:   Copyright (c)2015  
 * Company:     otrip  
 * @version:    1.0   
 * @since:  JDK 1.7.0_21  
 * Create at:   2015年4月2日 下午10:11:47   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年4月2日 zhongJc      1.0     1.0 Version   
 */
public interface ActiInfoService extends IService {
	
	public List<OtActiInfo> queryOtActiInfos(final OtActiInfo otActiInfo)throws Exception;
	
	public void saveOtActiInfo(final OtActiInfo otActiInfo) throws DataAccessException;
	
	public void saveOrUpdateActiInfo(final OtActiInfo otActiInfo)throws DataAccessException;
	
	public OtActiInfo findOtActiInfoById(final String id) throws DataAccessException;
	
	public void updateActiInfoBySql(OtActiInfo otActiInfo)  throws Exception;
	
	public boolean delActiInfoById(String actiId) throws Exception;

}
