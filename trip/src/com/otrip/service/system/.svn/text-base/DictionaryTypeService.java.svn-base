package com.otrip.service.system;   

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.otrip.domain.system.SysDictionaryType;
import com.otrip.service.IService;

/**   
 * Filename:    DictionaryTypeService.java   
 * Copyright:   Copyright (c)2015  
 * Company:     otrip  
 * @version:    1.0   
 * @since:  JDK 1.7.0_21  
 * Create at:   2015年3月19日 下午9:55:20   
 * Description:  字典类型管理服务类
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年3月19日 zhongJc      1.0     1.0 Version   
 */
public interface DictionaryTypeService extends IService {
	
	/**
	 * @see 查询字典类型
	 * @param sysDictionaryType
	 * @return
	 * @throws DataAccessException
	 */
	public List<SysDictionaryType> queryDictionaryType(final SysDictionaryType sysDictionaryType) throws DataAccessException;
	
	/**
	 * @see 保存字典类型
	 * @param sysDictionaryType
	 * @throws DataAccessException
	 */
	public void saveDictionaryType(final SysDictionaryType sysDictionaryType) throws DataAccessException;
	
	/**
	 * @see 查找所有的字典类型
	 * @return
	 * @throws DataAccessException
	 */
	public List<SysDictionaryType> queryAllDictionaryType() throws DataAccessException;
	
	public SysDictionaryType loadSysDictionaryTypeById(final String id)throws DataAccessException;
	

}
