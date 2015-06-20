package com.otrip.service.system.impl;   

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.otrip.dao.system.OtImageDao;
import com.otrip.domain.system.OtImage;
import com.otrip.pojo.ImageVo;
import com.otrip.service.GeneralService;
import com.otrip.service.system.ImageService;

/**   
 * Filename:    ImageServiceImpl.java   
 * Copyright:   Copyright (c)2015  
 * Company:     otrip  
 * @version:    1.0   
 * @since:  JDK 1.7.0_21  
 * Create at:   2015年4月8日 下午9:20:35   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年4月8日 zhongJc      1.0     1.0 Version   
 */
@Service("imageService")
public class ImageServiceImpl extends GeneralService<OtImage> implements ImageService {

	private static final long serialVersionUID = -1551508499573721012L;
	
	private OtImageDao otImageDao;
	@Autowired
	public void setOtImageDao(OtImageDao otImageDao) {
		this.otImageDao = otImageDao;
	}

	public List<OtImage> findOtImagesByObjIdAndObjSignOrName(String objId,String objSign, String name) throws DataAccessException {
		// TODO Auto-generated method stub
		return otImageDao.findOtImagesByObjIdAndObjSignOrName(objId, objSign, name);
	}

	public void saveOtImage(OtImage otImage) throws DataAccessException {
		// TODO Auto-generated method stub
		if(otImage!=null&&StringUtils.isNotBlank(otImage.getFsId())){
			otImageDao.save(otImage);
		}
	}
	
	public void deleteOtImageById(final String id)throws DataAccessException{
		if(StringUtils.isNotBlank(id)){
			otImageDao.deleteByKey(id);
		}
	}

	@Override
	public List<ImageVo> findAllImage(OtImage otImage){
		try {
			return otImageDao.findAllImage(otImage);
		} catch (Exception e) {
			
			return null;
			
		}
		
	}

	public void deleteRealFile(final String id,String webPath) throws Exception
	{
		otImageDao.deleteRealFile(id, webPath);
	}
}
