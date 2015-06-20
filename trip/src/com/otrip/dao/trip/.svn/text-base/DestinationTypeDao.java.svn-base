package com.otrip.dao.trip;   

import java.util.List;

import com.otrip.dao.IGenericDao;
import com.otrip.domain.trip.OtActiDestination;
import com.otrip.domain.trip.OtActiDestinationType;

/**   
 * Filename:    DestinationTypeDao.java   
 * Copyright:   Copyright (c)2015  
 * Company:     otrip  
 * @version:    1.0   
 * @since:  JDK 1.7.0_21  
 * Create at:   2015年3月26日 上午11:07:43   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年3月26日 zhongJc      1.0     1.0 Version   
 */
public interface DestinationTypeDao extends IGenericDao<OtActiDestinationType, String> {
	
	public List<OtActiDestinationType> queryOtActiDestinationTypes(final OtActiDestinationType otActiDestinationType) throws Exception;
	
	public void saveOtActiDestinationType(final OtActiDestinationType otActiDestinationType)throws Exception;
	
	public boolean updateOtActiDestinationTypeBySql(final OtActiDestinationType otacti) throws Exception;
	
	public boolean judgeInput(String name,String value);
}
