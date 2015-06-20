package com.otrip.dao.system.impl;   

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.LockMode;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.otrip.dao.GenericHibernateDao;
import com.otrip.dao.system.OtImageDao;
import com.otrip.domain.system.OtImage;
import com.otrip.domain.trip.OtActiDay;
import com.otrip.domain.trip.OtActiInfo;
import com.otrip.domain.trip.OtActiType;
import com.otrip.pojo.ImageVo;

/**   
 * Filename:    OtImageDaoImpl.java   
 * Copyright:   Copyright (c)2015  
 * Company:     otrip  
 * @version:    1.0   
 * @since:  JDK 1.7.0_21  
 * Create at:   2015年4月8日 下午9:06:06   
 * Description:  图片持久层操作类
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年4月8日 zhongJc      1.0     1.0 Version   
 */
@Component("otImageDao")
public class OtImageDaoImpl extends GenericHibernateDao<OtImage, String> implements OtImageDao {
	
	static Logger log=Logger.getLogger(OtImageDaoImpl.class);
	Map tableName=new HashMap();
	/**
	 * @see 根据业务对象ID和业务对象标示查询记录，并且以图片名称为条件
	 * @param objId
	 * @param objSign
	 * @param name
	 * @return
	 * @throws DataAccessException
	 */
	@SuppressWarnings("unchecked")
	public List<OtImage> findOtImagesByObjIdAndObjSignOrName(final String objId,final String objSign,final String name) throws DataAccessException{
		if(StringUtils.isNotBlank(objId)&&StringUtils.isNotBlank(objSign)){
			StringBuffer queryHql=new StringBuffer(" select i from OtImage i where 1=1 and i.fsObjId='"+objId+"' ");
			//queryHql.append(" and i.fsObjSign='"+objSign+"' ");
			if(StringUtils.isNotBlank(name))
				queryHql.append(" and i.fsName like '%"+name+"%' ");
			return super.find(queryHql.toString());
			
		}else{
			return null;
		}
	}

	@Override
	public List<ImageVo> findAllImage(OtImage otImage)
			throws Exception {
		StringBuffer queryHql=new StringBuffer(" select ad from OtImage ad where 1=1 ");
		if(otImage!=null)
		{
			if(StringUtils.isNotBlank(otImage.getFsObjId()))
			{
				queryHql.append(" and ad.fsObjId = '"+otImage.getFsObjId()+"'");
			}
		}
		
		List<OtImage> list= super.find(queryHql.toString());
		
		List<ImageVo> returnList=new ArrayList<ImageVo>();
		for(int i=0;i<list.size();i++)
		{
			ImageVo imv=this.getImageVo(list.get(i));
			returnList.add(imv);
		}
		log.info("find images :"+returnList.size() );
		return returnList;
	}
	
	private ImageVo getImageVo(OtImage otImage)
	{
		ImageVo iv=new ImageVo();
		String str="无";
		iv.setFsId(otImage.getFsId());
		iv.setFsUrl(otImage.getFsUrl());
		iv.setImageObjType(otImage.getFsObjSign());
		iv.setFsName(otImage.getFsName());
		iv.setCreateDate(otImage.getFormateFdCreateTime());
		String tab=otImage.getFsObjTabName();

		if(otImage.getFsObjTabName().equals("ot_acti_info"))
		{
			OtActiInfo oai=super.getHibernateTemplate().get(OtActiInfo.class, otImage.getFsObjId());
			if(oai!=null)
			{
				iv.setImageObjName(oai.getFsTitle());
			}
			else
			{
				iv.setImageObjName(str);
			}
			
		}
		else if(otImage.getFsObjTabName().equals("ot_acti_day"))
		{
			
			OtActiDay oad=super.getHibernateTemplate().get(OtActiDay.class, otImage.getFsObjId());
			if(iv!=null)
				iv.setImageObjName(oad.getFsName());
			else
				iv.setImageObjName(str);
		}
		else if(otImage.getFsObjTabName().equals("ot_acti_type"))
		{
			OtActiType oat=super.getHibernateTemplate().get(OtActiType.class, otImage.getFsObjId());
			if(oat!=null)
				iv.setImageObjName(oat.getFsName());
			else
				iv.setImageObjName(str);
		}
		else
		{
			iv.setImageObjName(str);
			
		}
		return iv;
	}

	@Override
	public void deleteRealFile(final String id,String webPath) throws Exception
	{
		if(StringUtils.isNotBlank(webPath)&&StringUtils.isNotBlank(id))
		{
			OtImage image=super.get(id);
			String url=image.getFsUrl();
			url=webPath+url.substring(1);
			File file=new File(url);
			if(file.delete())
				log.info("delete real file success "+url);
			else
				log.info("delete real file failed");
		}
	}
}
