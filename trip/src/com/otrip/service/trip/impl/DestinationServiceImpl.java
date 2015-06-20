package com.otrip.service.trip.impl;   

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.otrip.dao.trip.DestinationDao;
import com.otrip.domain.trip.OtActiDestination;
import com.otrip.service.GeneralService;
import com.otrip.service.trip.DestinationService;

/**   
 * Filename:    DestinationServiceImpl.java   
 * Copyright:   Copyright (c)2015  
 * Company:     otrip  
 * @version:    1.0   
 * @since:  JDK 1.7.0_21  
 * Create at:   2015年3月28日 下午10:56:15   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年3月28日 zhongJc      1.0     1.0 Version   
 */
@Service(value="destinationService")
public class DestinationServiceImpl extends GeneralService<OtActiDestination> implements DestinationService {

	private static final long serialVersionUID = 3074741670611332957L;
	static Logger log=Logger.getLogger(DestinationServiceImpl.class);
	
	private DestinationDao destinationDao;
	@Autowired
	public void setDestinationDao(DestinationDao destinationDao) {
		this.destinationDao = destinationDao;
	}
	
	
	public List<OtActiDestination> queryActiDestinations(final OtActiDestination otActiDestination)throws Exception{
		return destinationDao.queryOtActiDestinations(otActiDestination);
	}

	public List<OtActiDestination> findAllOtActiDestinations() throws Exception{
		return destinationDao.findAllOtActiDestinations();
	}
	
	public OtActiDestination getOtActiDestinationById(final String id) throws Exception{
		if(StringUtils.isNotBlank(id)){
			return destinationDao.get(id);
		}else{
			return null;
		}
	}
	
	public List<OtActiDestination> findChildsOtActiDestinations(final String parentId,final OtActiDestination otActiDestination)throws Exception{
		return destinationDao.findChildsOtActiDestinations(parentId, otActiDestination);
	}
	
	public List<OtActiDestination> findChildsOtActiDestinationsByName(final String parentId,final String destinationName)throws Exception{
		return destinationDao.findChildsOtActiDestinationsByName(parentId, destinationName);
	}
	
	public void saveOtActiDestion(final OtActiDestination otActiDestination) throws Exception{
		if(otActiDestination!=null&&StringUtils.isNotBlank(otActiDestination.getFsId())){
			destinationDao.save(otActiDestination);
		}
	}
	
	public List<OtActiDestination> findOtActiDestinationsByParentId(final String parentId)throws DataAccessException{
		return destinationDao.findOtActiDestinationsByParentId(parentId);
	}
	
	
	
}
