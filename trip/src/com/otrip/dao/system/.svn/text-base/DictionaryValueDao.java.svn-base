package com.otrip.dao.system;   

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.otrip.dao.IGenericDao;
import com.otrip.domain.system.SysDictionaryValue;

/**   
 * Filename:    DictionaryValueDao.java   
 * Copyright:   Copyright (c)2015  
 * Company:     otrip  
 * @version:    1.0   
 * @since:  JDK 1.7.0_21  
 * Create at:   2015年3月21日 下午6:41:21   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年3月21日 zhongJc      1.0     1.0 Version   
 */
public interface DictionaryValueDao extends IGenericDao<SysDictionaryValue, String> {

	public List<SysDictionaryValue> findAllDicValues(final SysDictionaryValue sysDictionaryValue) throws Exception; 
	
	public List<SysDictionaryValue> queryChildDicValue(final SysDictionaryValue sysDictionaryValue,final String parentDivId) throws Exception;
	
	public void saveDictionaryValue(final SysDictionaryValue sysDictionaryValue)throws Exception;
	
	public void deleteDictionaryValueById(final String fsId) throws Exception;
	
	public List<SysDictionaryValue> queryDictionaryValuesByTypeSign(final String typeSign) throws DataAccessException;
}
