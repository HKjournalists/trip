package com.otrip.service.system.impl;   

import java.util.List;

import javax.persistence.Access;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.otrip.dao.system.DictionaryValueDao;
import com.otrip.domain.system.SysDictionaryValue;
import com.otrip.service.GeneralService;
import com.otrip.service.system.DictionaryValueService;

/**   
 * Filename:    DictionaryValueServiceImpl.java   
 * Copyright:   Copyright (c)2015  
 * Company:     otrip  
 * @version:    1.0   
 * @since:  JDK 1.7.0_21  
 * Create at:   2015年3月23日 下午8:18:02   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年3月23日 zhongJc      1.0     1.0 Version   
 */
@Service(value="dictionaryValueService")
public class DictionaryValueServiceImpl extends GeneralService<SysDictionaryValue> implements DictionaryValueService {

	private static final long serialVersionUID = 1371629046905602870L;
	
	static Logger log=Logger.getLogger(DictionaryValueServiceImpl.class);
	
	
	private DictionaryValueDao dictionaryValueDao;
	@Autowired
	public void setDictionaryValueDao(DictionaryValueDao dictionaryValueDao) {
		this.dictionaryValueDao = dictionaryValueDao;
	}
	
	public List<SysDictionaryValue> findAllDicValues(final SysDictionaryValue sysDictionaryValue) throws Exception{
		return dictionaryValueDao.findAllDicValues(sysDictionaryValue);
	}
	
	@SuppressWarnings("unchecked")
	public List<SysDictionaryValue> queryChildDicValue(final SysDictionaryValue sysDictionaryValue,final String parentDivId) throws Exception{
		return dictionaryValueDao.queryChildDicValue(sysDictionaryValue, parentDivId);
	}
	
	public SysDictionaryValue findSysDictionaryValueById(final String fsId)throws Exception{
		if(StringUtils.isNotBlank(fsId)){
			return dictionaryValueDao.get(fsId);
		}else{
			return null;
		}
	}
	
	public void saveDictionaryValue(final SysDictionaryValue sysDictionaryValue)throws Exception{
		dictionaryValueDao.saveDictionaryValue(sysDictionaryValue);
	}
	
	public void deleteDictionaryValueById(final String fsId) throws Exception{
		dictionaryValueDao.deleteDictionaryValueById(fsId);
	}
	
	public List<SysDictionaryValue> queryDictionaryValuesByTypeSign(final String typeSign) throws DataAccessException{
		return dictionaryValueDao.queryDictionaryValuesByTypeSign(typeSign);
	}
	
	

}
