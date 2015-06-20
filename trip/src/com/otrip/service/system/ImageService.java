package com.otrip.service.system;   

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.otrip.domain.system.OtImage;
import com.otrip.pojo.ImageVo;
import com.otrip.service.IService;

/**   
 * Filename:    ImageService.java   
 * Copyright:   Copyright (c)2015  
 * Company:     otrip  
 * @version:    1.0   
 * @since:  JDK 1.7.0_21  
 * Create at:   2015年4月8日 下午9:17:18   
 * Description:  图片服务接口
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年4月8日 zhongJc      1.0     1.0 Version   
 */
public interface ImageService extends IService {

	/**
	 * @see 根据业务ID和业务标示查询图片列表
	 * @param objId
	 * @param objSign
	 * @param name
	 * @return
	 * @throws DataAccessException
	 */
	public List<OtImage> findOtImagesByObjIdAndObjSignOrName(final String objId,final String objSign,final String name) throws DataAccessException;
	
	
	/**
	 * @see 保存图片
	 * @param otImage
	 * @throws DataAccessException
	 */
	public void saveOtImage(OtImage otImage) throws DataAccessException;
	
	/**
	 * @see 删除图片通过ID
	 * @param id
	 * @throws DataAccessException
	 */
	public void deleteOtImageById(final String id)throws DataAccessException;
	
	
	/**
	 * cha xun suo you tu pian 
	 */
	public List<ImageVo> findAllImage(OtImage otImage);
	
	public void deleteRealFile(final String id,String webPath) throws Exception;
}
