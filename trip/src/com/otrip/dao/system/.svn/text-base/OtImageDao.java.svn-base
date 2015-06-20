package com.otrip.dao.system;   

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.otrip.dao.IGenericDao;
import com.otrip.domain.system.OtImage;
import com.otrip.pojo.ImageVo;

/**   
 * Filename:    OtImageDao.java   
 * Copyright:   Copyright (c)2015  
 * Company:     otrip  
 * @version:    1.0   
 * @since:  JDK 1.7.0_21  
 * Create at:   2015年4月8日 下午9:04:47   
 * Description:  系统图片存储数据库操作接口
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年4月8日 zhongJc      1.0     1.0 Version   
 */
public interface OtImageDao extends IGenericDao<OtImage, String> {
	
	public List<OtImage> findOtImagesByObjIdAndObjSignOrName(final String objId,final String objSign,final String name) throws DataAccessException;
	
	public List<ImageVo> findAllImage(OtImage otImage) throws Exception;
	
	public void deleteRealFile(final String id,String webPath) throws Exception;

}
