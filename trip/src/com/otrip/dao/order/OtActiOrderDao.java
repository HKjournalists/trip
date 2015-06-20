package com.otrip.dao.order;

import java.util.List;

import com.otrip.dao.IGenericDao;
import com.otrip.domain.trip.OtActiOrder;
import com.otrip.pojo.OrdeqpVo;

public interface OtActiOrderDao extends IGenericDao<OtActiOrder, String>{


	public List findOrders(String page,String num);
	
	public List getStatisInfo(String flag,String sta);
	
	public List getOrderStatistic(OrdeqpVo od);
}
