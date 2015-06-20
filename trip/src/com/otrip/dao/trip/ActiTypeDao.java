package com.otrip.dao.trip;   

import java.util.List;



import com.otrip.dao.IGenericDao;
import com.otrip.domain.trip.OtActiType;

/**   
 * Filename:    ActiTypeDao.java   
 * Copyright:   Copyright (c)2015  
 * Company:     otrip  
 * @version:    1.0   
 * @since:  JDK 1.7.0_21  
 * Create at:   2015年3月26日 上午10:34:01   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年3月26日 zhongJc      1.0     1.0 Version   
 */

public interface ActiTypeDao extends IGenericDao<OtActiType, String> {
	
	public List<OtActiType> queryOtActiTypes(final OtActiType otActiType) throws Exception;
	
	public void saveOtActiType(final OtActiType otActiType)throws Exception;
	
	public boolean updateActiType(final OtActiType actiType) throws Exception;
	
	public boolean judgeInput(String name,String value);

}
