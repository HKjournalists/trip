package com.otrip.service.system.impl;   

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.otrip.dao.system.DictionaryTypeDao;
import com.otrip.domain.system.SysDictionaryType;
import com.otrip.service.GeneralService;
import com.otrip.service.system.DictionaryTypeService;

/**   
 * Filename:    DictionaryTypeServiceImpl.java   
 * Copyright:   Copyright (c)2015  
 * Company:     otrip  
 * @version:    1.0   
 * @since:  JDK 1.7.0_21  
 * Create at:   2015年3月19日 下午9:56:20   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年3月19日 zhongJc      1.0     1.0 Version   
 */

@Service(value = "dictionaryTypeService")
public class DictionaryTypeServiceImpl extends GeneralService<SysDictionaryType> implements DictionaryTypeService {


	private static final long serialVersionUID = 2721986185451956230L;
	
	private DictionaryTypeDao dictionaryTypeDao;
	@Autowired
	public void setDictionaryTypeDao(DictionaryTypeDao dictionaryTypeDao) {
		this.dictionaryTypeDao = dictionaryTypeDao;
	}
	
	public List<SysDictionaryType> queryDictionaryType(final SysDictionaryType sysDictionaryType) throws DataAccessException{
		return dictionaryTypeDao.queryDictionaryType(sysDictionaryType);
	}
	
	public void saveDictionaryType(final SysDictionaryType sysDictionaryType) throws DataAccessException{
		if(sysDictionaryType!=null&&StringUtils.isNotBlank(sysDictionaryType.getFsId())){
			dictionaryTypeDao.save(sysDictionaryType);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<SysDictionaryType> queryAllDictionaryType() throws DataAccessException{
		return dictionaryTypeDao.find("select dt from SysDictionaryType dt where 1=1");
	}
	
	public SysDictionaryType loadSysDictionaryTypeById(final String id)throws DataAccessException{
		if(StringUtils.isNotBlank(id)){
			return dictionaryTypeDao.load(id);
		}else{
			return null;
		}
	}

}
