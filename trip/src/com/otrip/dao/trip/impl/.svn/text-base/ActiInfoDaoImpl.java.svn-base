package com.otrip.dao.trip.impl;   

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.LockMode;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Component;

import com.otrip.dao.GenericHibernateDao;
import com.otrip.dao.trip.ActiInfoDao;
import com.otrip.dao.util.ConvertDataUtil;
import com.otrip.domain.trip.OtActiInfo;

/**   
 * Filename:    ActiInfoDaoImpl.java   
 * Copyright:   Copyright (c)2015  
 * Company:     otrip  
 * @version:    1.0   
 * @since:  JDK 1.7.0_21  
 * Create at:   2015年4月2日 下午9:39:21   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年4月2日 zhongJc      1.0     1.0 Version   
 */
@Component("actiInfoDao")
public class ActiInfoDaoImpl extends GenericHibernateDao<OtActiInfo, String> implements ActiInfoDao {

	static Logger log=Logger.getLogger(ActiInfoDaoImpl.class);
	
	
	@SuppressWarnings("unchecked")
	public List<OtActiInfo> queryOtActiInfos(final OtActiInfo otActiInfo)throws Exception{
		StringBuffer queryHql=new StringBuffer(" select a from OtActiInfo a where 1=1 and fs_acti_flag=0 ");
		if(otActiInfo!=null){
			if(StringUtils.isNotBlank(otActiInfo.getFsTitle())){
				queryHql.append(" and a.fsTitle like '%"+otActiInfo.getFsTitle()+"%' ");
			}
			if(StringUtils.isNotBlank(otActiInfo.getFsNo())){
				queryHql.append(" and a.fsNo like '%"+otActiInfo.getFsNo()+"%' ");
			}
		}
		return super.find(queryHql.toString());
	}


	@Override
	public void saveOtActiInfoById(OtActiInfo otActiInfo) throws Exception {
		// TODO Auto-generated method stub
		OtActiInfo acti=super.get(otActiInfo.getFsId());
		StringBuffer sb=new StringBuffer();
		sb.append("update  ot_acti_info set");
		//String sql="update  ot_acti_info set";
		if(acti!=null)
		{
			if(!acti.getFsNo().equals(otActiInfo.getFsNo()))
			{
				sb.append(" fs_no='"+otActiInfo.getFsNo()+"', ");
				
			}
			if(!acti.getFsTitle().equals(otActiInfo.getFsTitle()))
			{
				sb.append(" fs_title='"+otActiInfo.getFsTitle()+"', ");
				
			}
			if(!acti.getFsDestinationContinent().getFsId().equals(otActiInfo.getFsDestinationContinent().getFsId()))
			{
				sb.append(" fs_destination_continent='"+otActiInfo.getFsDestinationContinent().getFsId()+"', ");
			}
			if(!acti.getFsDestinationCountry().getFsId().equals(otActiInfo.getFsDestinationCountry().getFsId()))
			{
				sb.append(" fs_destination_country='"+otActiInfo.getFsDestinationCountry().getFsId()+"', ");
			}
			if(!acti.getFsDestinationScenic().getFsId().equals(otActiInfo.getFsDestinationScenic().getFsId()))
			{
				sb.append(" fs_destination_scenic='"+otActiInfo.getFsDestinationScenic().getFsId()+"', ");
			}
			if(!acti.getOtActiType().getFsId().equals(otActiInfo.getOtActiType().getFsId()))
			{
				sb.append(" fs_outdoors_type='"+otActiInfo.getOtActiType().getFsId()+"', ");
			}
			if(!acti.getOtActiDestinationType().getFsId().equals(otActiInfo.getOtActiDestinationType().getFsId()))
			{
				sb.append(" fs_destination_type='"+otActiInfo.getOtActiDestinationType().getFsId()+"' ,");
			}
			if(!acti.getFnTripDistance().equals(otActiInfo.getFnTripDistance()))
			{
				sb.append(" fn_trip_distance='"+otActiInfo.getFnTripDistance().toString()+"' ,");
			}
			
			if(ConvertDataUtil.differentFromDate(acti.getFormatFdUpperTime(),otActiInfo.getFormatFdUpperTime()))
			{
				sb.append(" fd_upper_time='"+otActiInfo.getFormatFdUpperTime()+"', ");
			}
			if(ConvertDataUtil.differentFromDate(acti.getFormatFdUnderTime(),otActiInfo.getFormatFdUnderTime()))
			{
				sb.append(" fd_under_time='"+otActiInfo.getFormatFdUnderTime()+"', ");
			}
			if(acti.getFnDay()!=otActiInfo.getFnDay())
			{
				sb.append(" fn_day='"+otActiInfo.getFnDay()+"', ");
			}
			if(!acti.getFsSeason().equals(otActiInfo.getFsSeason()))
			{
				sb.append(" fs_season='"+otActiInfo.getFsSeason()+"',");
			}
			if(!acti.getFsHoliday().equals(otActiInfo.getFsHoliday()))
			{
				sb.append(" fs_holiday='"+otActiInfo.getFsHoliday()+"', ");
			}
			if(!acti.getFsLineRoad().equals(otActiInfo.getFsLineRoad()))
			{
				sb.append(" fs_line_road='"+otActiInfo.getFsLineRoad()+"', ");
			}
			if(!acti.getFsCostNotes().equals(otActiInfo.getFsCostNotes()))
			{
				sb.append(" fs_cost_notes='"+otActiInfo.getFsCostNotes()+"', ");
			}
			if(!acti.getFsRefundNotes().equals(otActiInfo.getFsRefundNotes()))
			{
				sb.append(" fs_refund_notes='"+otActiInfo.getFsRefundNotes()+"', ");
			}
		
			if(!acti.getFsEquipList().equals(otActiInfo.getFsEquipList()))
			{
				
				sb.append(" fs_equip_list='"+otActiInfo.getFsEquipList()+"' ,");
			}
			if(sb.lastIndexOf(",")>0)
			{
				//sb.deleteCharAt(sb.lastIndexOf(","));
				sb.append(" fd_update_time='"+ConvertDataUtil.getNow()+"' ");
				sb.append(" where fs_id='"+acti.getFsId()+"' ");
			    log.info("save acti sql:"+sb.toString());
			  super.updateBySQL(sb.toString());
			}
			log.info("save sql:"+sb.toString());
		}
	}


	

	@Override
	public boolean deleteActiInfoById(String actiFsId) throws Exception {
		// TODO Auto-generated method stub
		if(StringUtils.isNotBlank(actiFsId))
		{
			OtActiInfo acti=super.get(actiFsId);
			if(acti!=null)
			{
				acti.setFsActiFlag(true); //标志为1表示删除
				super.update(acti);
				return true;
			}
		}
		return false;
	}
	
	

	
}
