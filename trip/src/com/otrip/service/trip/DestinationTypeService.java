package com.otrip.service.trip;   

import java.util.List;

import com.otrip.domain.trip.OtActiDestinationType;
import com.otrip.service.IService;

/**   
 * Filename:    DestinationTypeService.java   
 * Copyright:   Copyright (c)2015  
 * Company:     otrip  
 * @version:    1.0   
 * @since:  JDK 1.7.0_21  
 * Create at:   2015年3月26日 下午7:27:39   
 * Description:  景区类型
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年3月26日 zhongJc      1.0     1.0 Version   
 */
public interface DestinationTypeService extends IService {
	
	public List<OtActiDestinationType> queryOtActiDestinationTypes(final OtActiDestinationType otActiDestinationType) throws Exception;
	
	public void saveOtActiDestinationType(final OtActiDestinationType otActiDestinationType)throws Exception;
	
	public void deleteActiDestinationById(final String id) throws Exception;
	
	public List<OtActiDestinationType> findAll() throws Exception;
	
	public OtActiDestinationType loadOtActiDestinationTypeById(final String id) throws Exception;

	public boolean updateActiDestinationType(final OtActiDestinationType otactiType) throws Exception;
	
	public boolean judgeInput(String name,String value);
}
