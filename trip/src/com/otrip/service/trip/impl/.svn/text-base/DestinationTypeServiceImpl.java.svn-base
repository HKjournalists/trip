package com.otrip.service.trip.impl;   

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otrip.dao.trip.DestinationTypeDao;
import com.otrip.domain.trip.OtActiDestinationType;
import com.otrip.service.GeneralService;
import com.otrip.service.trip.DestinationTypeService;

/**   
 * Filename:    DestinationTypeServiceImpl.java   
 * Copyright:   Copyright (c)2015  
 * Company:     otrip  
 * @version:    1.0   
 * @since:  JDK 1.7.0_21  
 * Create at:   2015年3月26日 下午7:30:12   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年3月26日 zhongJc      1.0     1.0 Version   
 */
@Service(value="destinationTypeService")
public class DestinationTypeServiceImpl extends GeneralService<OtActiDestinationType> implements DestinationTypeService {

	private static final long serialVersionUID = 8657433369386694405L;
	
	static Logger log=Logger.getLogger(DestinationTypeServiceImpl.class);
	
	private DestinationTypeDao destinationTypeDao;
	@Autowired
	public void setDestinationTypeDao(DestinationTypeDao destinationTypeDao) {
		this.destinationTypeDao = destinationTypeDao;
	}
	
	public List<OtActiDestinationType> queryOtActiDestinationTypes(final OtActiDestinationType otActiDestinationType) throws Exception{
		return destinationTypeDao.queryOtActiDestinationTypes(otActiDestinationType);
	}
	
	public void saveOtActiDestinationType(final OtActiDestinationType otActiDestinationType)throws Exception{
		if(otActiDestinationType!=null&&StringUtils.isNotBlank(otActiDestinationType.getFsId())){
			destinationTypeDao.save(otActiDestinationType);
		}
	}
	
	public void deleteActiDestinationById(final String id) throws Exception{
		if(StringUtils.isNotBlank(id)){
			destinationTypeDao.deleteByKey(id);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<OtActiDestinationType> findAll() throws Exception{
		return destinationTypeDao.find(" select t from OtActiDestinationType t where 1=1 ");
	}
	
	public OtActiDestinationType loadOtActiDestinationTypeById(final String id) throws Exception{
		if(StringUtils.isNotBlank(id)){
			return destinationTypeDao.load(id);
		}else{
			return null;
		}
	}

	@Override
	public boolean updateActiDestinationType(OtActiDestinationType otactiType)
			throws Exception {
		// TODO Auto-generated method stub
		return destinationTypeDao.updateOtActiDestinationTypeBySql(otactiType);
	}

	
	public boolean judgeInput(String name,String value)
	{
		if(StringUtils.isNotBlank(name)&&StringUtils.isNotBlank(value))
		{
			return this.destinationTypeDao.judgeInput(name, value);
		}
		else
		{
			return false;
		}
	}
}
