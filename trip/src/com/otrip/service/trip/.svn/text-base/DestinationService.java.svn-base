package com.otrip.service.trip;   

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.otrip.domain.trip.OtActiDestination;
import com.otrip.service.IService;

/**   
 * Filename:    DestinationService.java   
 * Copyright:   Copyright (c)2015  
 * Company:     otrip  
 * @version:    1.0   
 * @since:  JDK 1.7.0_21  
 * Create at:   2015年3月28日 下午10:55:34   
 * Description:  景区管理
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年3月28日 zhongJc      1.0     1.0 Version   
 */
public interface DestinationService extends IService {
	
	public List<OtActiDestination> queryActiDestinations(final OtActiDestination otActiDestination)throws Exception;
	
	public List<OtActiDestination> findAllOtActiDestinations() throws Exception;
	
	public OtActiDestination getOtActiDestinationById(final String id) throws Exception;
	
	public List<OtActiDestination> findChildsOtActiDestinations(final String parentId,final OtActiDestination otActiDestination)throws Exception;
	
	public List<OtActiDestination> findChildsOtActiDestinationsByName(final String parentId,final String destinationName)throws Exception;
	
	public void saveOtActiDestion(final OtActiDestination otActiDestination) throws Exception;
	
	public List<OtActiDestination> findOtActiDestinationsByParentId(final String parentId)throws DataAccessException;

}
