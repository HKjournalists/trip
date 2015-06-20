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
import com.otrip.dao.system.DictionaryValueDao;
import com.otrip.domain.system.SysDictionaryValue;

/**   
 * Filename:    DictionaryValueDaoImpl.java   
 * Copyright:   Copyright (c)2015  
 * Company:     otrip  
 * @version:    1.0   
 * @since:  JDK 1.7.0_21  
 * Create at:   2015年3月21日 下午6:44:54   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年3月21日 zhongJc      1.0     1.0 Version   
 */

@Component(value="dictionaryValueDao")
public class DictionaryValueDaoImpl extends GenericHibernateDao<SysDictionaryValue, String> implements DictionaryValueDao {

	static Logger log=Logger.getLogger(DictionaryValueDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	public List<SysDictionaryValue> findAllDicValues(SysDictionaryValue sysDictionaryValue) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer queryHql=new StringBuffer(" select dv from SysDictionaryValue dv where 1=1 ");
		if(sysDictionaryValue!=null){
			if(StringUtils.isNotBlank(sysDictionaryValue.getFsName())){
				queryHql.append(" and dv.fsName like '%"+sysDictionaryValue.getFsName()+"%' ");
			}
			if(StringUtils.isNotBlank(sysDictionaryValue.getFsValue())){
				queryHql.append(" and dv.fsValue like '%"+sysDictionaryValue.getFsValue()+"%' ");
			}
			if(sysDictionaryValue.getSysDictionaryType()!=null&&StringUtils.isNotBlank(sysDictionaryValue.getSysDictionaryType().getFsId())){
				queryHql.append(" and dv.sysDictionaryType.fsId='"+sysDictionaryValue.getSysDictionaryType().getFsId()+"' ");
			}
		}
		return super.find(queryHql.toString());
	}
	
	@SuppressWarnings("unchecked")
	public List<SysDictionaryValue> queryChildDicValue(final SysDictionaryValue sysDictionaryValue,final String parentDivId) throws Exception{
		StringBuffer queryHql=new StringBuffer(" select sdv from SysDictionaryValue sdv where 1=1 and sdv.fsParentId='"+parentDivId+"' ");
		if(sysDictionaryValue!=null){
			if(StringUtils.isNotBlank(sysDictionaryValue.getFsName())){
				queryHql.append(" and sdv.fsName like '%"+sysDictionaryValue.getFsName()+"%' ");
			}
			if(StringUtils.isNotBlank(sysDictionaryValue.getFsValue())){
				queryHql.append(" and sdv.fsValue like '%"+sysDictionaryValue.getFsValue()+"%' ");
			}
			if(sysDictionaryValue.getSysDictionaryType()!=null&&StringUtils.isNotBlank(sysDictionaryValue.getSysDictionaryType().getFsId())){
				queryHql.append(" and sdv.sysDictionaryType.fsId='"+sysDictionaryValue.getSysDictionaryType().getFsId()+"' ");
			}
		}
		return super.find(queryHql.toString());
	}
	
	public void saveDictionaryValue(final SysDictionaryValue sysDictionaryValue)throws Exception{
		if(sysDictionaryValue!=null&&StringUtils.isNotBlank(sysDictionaryValue.getFsId())){
			super.save(sysDictionaryValue);
		}else{
			throw new Exception("保存数据字典出错");
		}
	}
	
	public void deleteDictionaryValueById(final String fsId) throws Exception{
		if(StringUtils.isNotBlank(fsId)){
			super.deleteByKey(fsId);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<SysDictionaryValue> queryDictionaryValuesByTypeSign(final String typeSign) throws DataAccessException{
		if(StringUtils.isNotBlank(typeSign)){
			StringBuffer queryHql=new StringBuffer(" select dv from SysDictionaryValue dv where 1=1 ");
			queryHql.append(" and dv.sysDictionaryType.fsSign='"+typeSign+"' ");
			return super.find(queryHql.toString());
		}else{
			return null;
		}
	}

}
