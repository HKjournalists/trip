package com.otrip.service.trip;   

import java.util.List;

import com.otrip.domain.trip.OtActiType;
import com.otrip.service.IService;

/**   
 * Filename:    ActiTypeService.java   
 * Copyright:   Copyright (c)2015  
 * Company:     otrip  
 * @version:    1.0   
 * @since:  JDK 1.7.0_21  
 * Create at:   2015年3月26日 上午11:01:00   
 * Description:  活动类型服务类
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年3月26日 zhongJc      1.0     1.0 Version   
 */
public interface ActiTypeService extends IService {
	
	public List<OtActiType> queryOtActiTypes(final OtActiType otActiType) throws Exception;
	
	public void saveOtActiType(final OtActiType otActiType)throws Exception;
	
	public void deleteOtActiTypeById(final String id)throws Exception;
	
	public List<OtActiType> findAll() throws Exception;
	
	public OtActiType loadById(final String id) throws Exception;
	
	public boolean updateActiType(OtActiType ot)throws Exception;
	
	public boolean judgeInput(String name,String value);

}
