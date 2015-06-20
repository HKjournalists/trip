package com.otrip.dao.trip;   

import java.util.List;

import com.otrip.dao.IGenericDao;
import com.otrip.domain.trip.OtActiInfo;

/**   
 * Filename:    ActiInfoDao.java   
 * Copyright:   Copyright (c)2015  
 * Company:     otrip  
 * @version:    1.0   
 * @since:  JDK 1.7.0_21  
 * Create at:   2015年4月2日 下午9:37:38   
 * Description:  活动信息数据库服务接口
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年4月2日 zhongJc      1.0     1.0 Version   
 */
public interface ActiInfoDao extends IGenericDao<OtActiInfo, String> {
	
	public List<OtActiInfo> queryOtActiInfos(final OtActiInfo otActiInfo)throws Exception;
	
	
	public void saveOtActiInfoById(final OtActiInfo otActiInfo) throws Exception ;
	
	
	public boolean  deleteActiInfoById(final String actiFsId) throws Exception;
}
