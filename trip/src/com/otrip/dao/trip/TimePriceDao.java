package com.otrip.dao.trip;

import java.util.List;

import com.otrip.dao.IGenericDao;
import com.otrip.domain.trip.OtActiDestination;
import com.otrip.domain.trip.OtActiTimePrice;

public interface TimePriceDao  extends IGenericDao<OtActiTimePrice, String>{
	
	
	public List<OtActiTimePrice> findOtActiTimePriceByactiId(String actiId,int page,int rows);
	
	public boolean saveTimePrice(String actiId,String orignal,String special,String start,String end);
	
	public boolean delTimePrice(String fsId);
	
	public boolean modify(String tpid,String orignal,String special,String start,String end);
}
