package com.otrip.dao.system.impl;   

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.LockMode;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.otrip.dao.GenericHibernateDao;
import com.otrip.dao.system.DictionaryTypeDao;
import com.otrip.domain.system.SysDictionaryType;

/**   
 * Filename:    DictionaryTypeDaoImpl.java   
 * Copyright:   Copyright (c)2015  
 * Company:     otrip  
 * @version:    1.0   
 * @since:  JDK 1.7.0_21  
 * Create at:   2015年3月19日 下午10:21:42   
 * Description:  数据字典类型操作实体类
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年3月19日 zhongJc      1.0     1.0 Version   
 */
@Component(value="dictionaryTypeDao")
public class DictionaryTypeDaoImpl extends GenericHibernateDao<SysDictionaryType, String> implements DictionaryTypeDao {

	static Logger log=Logger.getLogger(DictionaryTypeDaoImpl.class);
	
	/**
	 * @see 查询字典类型
	 * @param sysDictionaryType
	 * @return
	 * @throws DataAccessException
	 */
	@SuppressWarnings("unchecked")
	public List<SysDictionaryType> queryDictionaryType(final SysDictionaryType sysDictionaryType) throws DataAccessException{
		StringBuffer queryHql=new StringBuffer(" select dt from SysDictionaryType dt where 1=1 	");
		if(sysDictionaryType!=null){
			if(StringUtils.isNotBlank(sysDictionaryType.getFsName())){
				queryHql.append(" and dt.fsName like '%"+sysDictionaryType.getFsName()+"%' ");
			}
			if(StringUtils.isNotBlank(sysDictionaryType.getFsSign())){
				queryHql.append(" and dt.fsSign like '%"+sysDictionaryType.getFsSign()+"%' ");
			}
			if(StringUtils.isNotBlank(sysDictionaryType.getFsStatus())){
				queryHql.append(" and dt.fsStatus = '%"+sysDictionaryType.getFsStatus()+"%' ");
			}
		}
		return super.find(queryHql.toString());
	}
	
}
