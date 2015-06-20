package com.otrip.dao.system;   

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.otrip.dao.IGenericDao;
import com.otrip.domain.system.SysDictionaryType;

/**   
 * Filename:    DictionaryTypeDao.java   
 * Copyright:   Copyright (c)2015  
 * Company:     otrip  
 * @version:    1.0   
 * @since:  JDK 1.7.0_21  
 * Create at:   2015年3月19日 下午10:20:27   
 * Description:  数据字典类型操作实体接口
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年3月19日 zhongJc      1.0     1.0 Version   
 */
public interface DictionaryTypeDao extends IGenericDao<SysDictionaryType, String> {
	
	public List<SysDictionaryType> queryDictionaryType(final SysDictionaryType sysDictionaryType) throws DataAccessException;

}
