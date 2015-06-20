package com.otrip.service.trip.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.otrip.dao.trip.TimePriceDao;
import com.otrip.domain.trip.OtActiDay;
import com.otrip.domain.trip.OtActiTimePrice;
import com.otrip.service.GeneralService;
import com.otrip.service.trip.TimePriceService;


@Component("timePriceServiceImpl")
public class TimePriceServiceImpl extends GeneralService<OtActiDay> implements TimePriceService
{
	@Autowired
	private TimePriceDao tpdl;
	
	public void setTimePriceDaoImpl(TimePriceDao tpdl)
	{
		this.tpdl=tpdl;
	}
	
	static Logger log=Logger.getLogger(TimePriceServiceImpl.class);
	@Override
	public List<OtActiTimePrice> queryTimePriceByActiInfoId(String actiId,String page,String rows) {
		int pageNum=StringUtils.isNotBlank(page)?Integer.valueOf(page):0;
		int rowsNum=StringUtils.isNotBlank(rows)?Integer.valueOf(rows):10;
		log.info("pageNum is"+pageNum);
		log.info("rowsNum"+rowsNum);
		return tpdl.findOtActiTimePriceByactiId(actiId, pageNum, rowsNum);
	}
	@Override
	public boolean saveTimePrice(String actId, String original, String special,
			String start, String end) {
	
		return tpdl.saveTimePrice(actId, original, special, start, end);
	}
	@Override
	public boolean deleteTimePriceById(String fsId) {
		if(StringUtils.isNotBlank(fsId))
		{
			return tpdl.delTimePrice(fsId);
		}
		else
			return false;
	}
	@Override
	public boolean modifyTimePrice(String tpid, String original,
			String special, String start, String end) {
		return tpdl.modify(tpid, original, special, start, end);
	}

}
