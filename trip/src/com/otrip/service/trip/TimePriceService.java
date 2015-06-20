package com.otrip.service.trip;

import java.util.List;

import com.otrip.domain.trip.OtActiTimePrice;

public interface TimePriceService {

	public List<OtActiTimePrice> queryTimePriceByActiInfoId(String actiId,String page,String rows);
	
	public boolean saveTimePrice(String actId,String original,String special,String start,String end);
	
	public boolean deleteTimePriceById(String fsId);
	
	public boolean modifyTimePrice(String tpid,String original,String special,String start,String end);
}
