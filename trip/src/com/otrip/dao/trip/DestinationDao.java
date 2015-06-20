package com.otrip.dao.trip;   

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.otrip.dao.IGenericDao;
import com.otrip.domain.trip.OtActiDestination;

/**   
 * Filename:    DestinationDao.java   
 * Copyright:   Copyright (c)2015  
 * Company:     otrip  
 * @version:    1.0   
 * @since:  JDK 1.7.0_21  
 * Create at:   2015年3月28日 下午10:07:18   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年3月28日 zhongJc      1.0     1.0 Version   
 */
public interface DestinationDao extends IGenericDao<OtActiDestination, String> {
	
	public List<OtActiDestination> queryOtActiDestinations(final OtActiDestination otActiDestination)throws Exception;
	
	public List<OtActiDestination> findAllOtActiDestinations() throws Exception;
	
	public List<OtActiDestination> findChildsOtActiDestinations(final String parentId,final OtActiDestination otActiDestination)throws Exception;
	
	public List<OtActiDestination> findChildsOtActiDestinationsByName(final String parentId,final String destinationName)throws Exception;
	
	public List<OtActiDestination> findOtActiDestinationsByParentId(final String parentId)throws DataAccessException;
	
	
	
}
