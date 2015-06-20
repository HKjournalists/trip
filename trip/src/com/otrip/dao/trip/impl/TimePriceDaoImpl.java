package com.otrip.dao.trip.impl;

import java.util.List;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.FlushMode;
import org.springframework.stereotype.Component;

import com.otrip.dao.GenericHibernateDao;
import com.otrip.dao.trip.DestinationDao;
import com.otrip.dao.trip.TimePriceDao;
import com.otrip.dao.util.ConvertDataUtil;
import com.otrip.domain.DomainUtils;
import com.otrip.domain.system.SysUser;
import com.otrip.domain.trip.OtActiDestination;
import com.otrip.domain.trip.OtActiInfo;
import com.otrip.domain.trip.OtActiTimePrice;

@Component("timePriceDao")
public class TimePriceDaoImpl extends GenericHibernateDao<OtActiTimePrice, String> implements TimePriceDao{

	Logger log=Logger.getLogger(TimePriceDaoImpl.class);
	@Override
	public List<OtActiTimePrice> findOtActiTimePriceByactiId(String actiId ,int page, int rows) {
		page=(page-1)>=0?page-1:0;
		String sql="select b.fs_id,b.fs_title,a.fn_original_price,a.fn_special_price,a.fd_start_time,a.fd_end_time , "
				+ " a.fd_create_time,a.fd_update_time ,a.fs_id as fsId from (select fs_id, fs_acti_id,fn_original_price,fn_special_price,fd_start_time,"
				+" fd_end_time,fd_create_time,fd_update_time from ot_acti_time_price where fs_acti_id='"+actiId+"' and fs_flag=0)  a  inner join ot_acti_info  b on a.fs_acti_id=b.fs_id "
				+ "  limit "+page+" , "+(page+1)*rows;
		log.info("sql :"+sql);
		List list=super.findBySQL(sql);
		log.info("find timePrice:"+list.size());
		if(list.size()!=0)
		{
			return list;
		}
		else
		{
			return null;
		}
	}
	
	
	@SuppressWarnings("deprecation")
	public boolean saveTimePrice(String actiId,String orignal,String special,String start,String end)
	{
		OtActiInfo acti=null;
		try
		{
			acti=super.getHibernateTemplate().load(OtActiInfo.class, actiId);
		}
		catch(Exception e)
		{
			log.debug("user or oaActiInfo is not exist!");
			return false;
		}
		OtActiTimePrice oatp=new OtActiTimePrice();
		oatp.setFsId(DomainUtils.generalUuid());
		oatp.setFdCreateTime(new Date());
		log.info("save timePrice createTime:"+oatp.getFdCreateTime());
		oatp.setFdStartTime(ConvertDataUtil.parseStringDate(start, "yyyy-MM-dd hh:mm:ss"));
		log.info("save timePrice StartTime:"+oatp.getFdStartTime());
		oatp.setFdEndTime(ConvertDataUtil.parseStringDate(end, "yyyy-MM-dd hh:mm:ss"));
		log.info("save timePrice EndTime:"+oatp.getFdEndTime());
		oatp.setFnOriginalPrice(ConvertDataUtil.StringToBigDecimal(orignal));
		log.info("save timePrice OriginalPrice:"+oatp.getFnOriginalPrice());
		oatp.setFnSpecialPrice(ConvertDataUtil.StringToBigDecimal(special));
		log.info("save timePrice SpecialPrice:"+oatp.getFnSpecialPrice());
		oatp.setOtActiInfo(acti);
		try
		{
			super.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
			//log.info(super.getSession().getFlushMode().toString());
			super.save(oatp);
			super.flush();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean delTimePrice(String fsId)
	{
		try
		{
			OtActiTimePrice oatp=super.load(fsId);
			oatp.setFsFlag(true);//1表示已删除
			super.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
			//log.info(super.getSession().getFlushMode().toString());
			super.update(oatp);
			super.flush();
			return true;
		}
		catch(Exception e)
		{
			log.error("no TimePrice find");
			return false;
		}
		
	}


	@Override
	public boolean modify(String tpid, String orignal, String special,
			String start, String end) {
			log.info(start+":::"+end);
			if(StringUtils.isNotBlank(tpid))
			{
				OtActiTimePrice otp=super.load(tpid);
				StringBuffer sb=new StringBuffer();
				sb.append("update ot_acti_time_price set ");
				if(StringUtils.isNotBlank(orignal))
				{
					if(!orignal.equals(otp.getFnOriginalPrice()+""))
						sb.append(" fn_original_price='"+orignal+"' ,");
				}
				if(StringUtils.isNotBlank(special))
				{
					log.info(special.equals(otp.getFnSpecialPrice()+"")+special+"::"+otp.getFnSpecialPrice()+"");
					if(!special.equals(otp.getFnSpecialPrice()+""))
						sb.append(" fn_special_price='"+special+"' ,");
				}
				if(StringUtils.isNotBlank(start))
				{
					log.info(ConvertDataUtil.differentFromDate(otp.getFormatStartTime(), start)+start+"::"+otp.getFormatStartTime()+"");
					if(ConvertDataUtil.differentFromDate(otp.getFormatStartTime(), start))
						sb.append(" fd_start_time='"+start+"' ,");
				}
				if(StringUtils.isNotBlank(end))
				{
					log.info(ConvertDataUtil.differentFromDate(otp.getFormatEndTime(), end)+end+"::"+otp.getFormatEndTime()+"");
					if(ConvertDataUtil.differentFromDate(otp.getFormatEndTime(), end))
						sb.append("fd_end_time='"+end+"' ,");
				}
				if(sb.lastIndexOf(",")>0)
				{
					sb.append("fd_update_time = '"+ConvertDataUtil.getNow()+"' where fs_id='"+tpid+"'");
					log.info("update timePrice sql:"+sb.toString());
					super.updateBySQL(sb.toString());
					return true;
				}
			}
		return false;
	}	

}
