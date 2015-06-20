package com.otrip.service.trip.impl;   

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.otrip.dao.trip.ActiInfoDao;
import com.otrip.domain.trip.OtActiInfo;
import com.otrip.service.GeneralService;
import com.otrip.service.trip.ActiInfoService;

/**   
 * Filename:    ActiInfoServiceImpl.java   
 * Copyright:   Copyright (c)2015  
 * Company:     otrip  
 * @version:    1.0   
 * @since:  JDK 1.7.0_21  
 * Create at:   2015年4月2日 下午10:12:53   
 * Description: 活动信息服务类 
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年4月2日 zhongJc      1.0     1.0 Version   
 */
@Service(value="actiInfoService")
public class ActiInfoServiceImpl extends GeneralService<OtActiInfo> implements ActiInfoService {

	private static final long serialVersionUID = -2897763569604471267L;
	
	static Logger log=Logger.getLogger(ActiInfoServiceImpl.class);
	
	private ActiInfoDao		actiInfoDao;
	@Autowired
	public void setActiInfoDao(ActiInfoDao actiInfoDao) {
		this.actiInfoDao = actiInfoDao;
	}
	
	public List<OtActiInfo> queryOtActiInfos(final OtActiInfo otActiInfo)throws Exception{
		return actiInfoDao.queryOtActiInfos(otActiInfo);
	}
	
	public void saveOtActiInfo(final OtActiInfo otActiInfo) throws DataAccessException{
		if(otActiInfo!=null&&StringUtils.isNotBlank(otActiInfo.getFsId())){
			actiInfoDao.save(otActiInfo);
		}
	}
	
	public OtActiInfo findOtActiInfoById(final String id) throws DataAccessException{
		if(StringUtils.isNotBlank(id)){
			return actiInfoDao.load(id);
		}else{
			return null;
		}
	}

	@Override
	public void saveOrUpdateActiInfo(OtActiInfo otActiInfo)
			throws DataAccessException {
		// TODO Auto-generated method stub
		if(otActiInfo!=null&&StringUtils.isNotBlank(otActiInfo.getFsId()))
		{
			log.info("sava acti");
			actiInfoDao.save(otActiInfo);
		}
	}

	@Override
	public void updateActiInfoBySql(OtActiInfo otActiInfo) throws Exception {
		// TODO Auto-generated method stub
		if(otActiInfo!=null&&StringUtils.isNotBlank(otActiInfo.getFsId()))
		{
			try
			{
			actiInfoDao.saveOtActiInfoById( otActiInfo);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean delActiInfoById(String actiId) throws Exception {
		// TODO Auto-generated method stub
		actiInfoDao.deleteActiInfoById(actiId);
		return false;
	}

}
