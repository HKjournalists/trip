package com.otrip.service.trip.impl;   

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otrip.dao.trip.ActiTypeDao;
import com.otrip.domain.trip.OtActiType;
import com.otrip.service.GeneralService;
import com.otrip.service.trip.ActiTypeService;

/**   
 * Filename:    ActiTypeServiceImpl.java   
 * Copyright:   Copyright (c)2015  
 * Company:     otrip  
 * @version:    1.0   
 * @since:  JDK 1.7.0_21  
 * Create at:   2015年3月26日 上午11:02:25   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年3月26日 zhongJc      1.0     1.0 Version   
 */
@Service(value="actiTypeService")
public class ActiTypeServiceImpl extends GeneralService<OtActiType> implements ActiTypeService {

	private static final long serialVersionUID = 8411748994584781590L;
	
	static Logger log=Logger.getLogger(ActiTypeServiceImpl.class);
	
	private ActiTypeDao actiTypeDao;
	@Autowired
	public void setActiTypeDao(ActiTypeDao actiTypeDao) {
		this.actiTypeDao = actiTypeDao;
	}
	
	public List<OtActiType> queryOtActiTypes(final OtActiType otActiType) throws Exception{
		return actiTypeDao.queryOtActiTypes(otActiType);
	}
	
	public void saveOtActiType(final OtActiType otActiType)throws Exception{
		actiTypeDao.saveOtActiType(otActiType);
	}
	
	public void deleteOtActiTypeById(final String id)throws Exception{
		if(StringUtils.isNotBlank(id)){
			actiTypeDao.deleteByKey(id);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<OtActiType> findAll() throws Exception{
		return actiTypeDao.find(" select at from OtActiType at where 1=1 ");
	}
	
	public OtActiType loadById(final String id) throws Exception{
		if(StringUtils.isNotBlank(id)){
			return actiTypeDao.load(id);
		}else{
			return null;
		}
	}
 
	
	public boolean judgeInput(String name,String value)
	{
		if(StringUtils.isNotBlank(name)&&StringUtils.isNotBlank(value))
			return actiTypeDao.judgeInput(name, value);
		else
			return false;
	}

	@Override
	public boolean updateActiType(OtActiType ot) throws Exception {
		// TODO Auto-generated method stub
		if(ot!=null)
		{
			return actiTypeDao.updateActiType(ot);
		}
		return false;
	}
}
