package com.otrip.service.order.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.eclipse.jetty.util.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.otrip.controls.order.OrderMainController;
import com.otrip.dao.order.OtActiOrderDao;
import com.otrip.pojo.OrdeqpVo;
import com.otrip.pojo.OrderAnalyseVo;
import com.otrip.service.order.OtActiOrderService;
@Component("otActiOrderService")
public class OtActiOrderServiceImpl implements OtActiOrderService{

	static Logger log=Logger.getLogger(OtActiOrderServiceImpl.class);
	private OtActiOrderDao oaod;
	
	@Autowired
	public void setOtActiOrderDao(OtActiOrderDao oaod)
	{
		this.oaod=oaod;
	}
	
	@Override
	public List listOrders(String page,String num)
	{
		
		if(StringUtils.isNotBlank(page)&&StringUtils.isNotBlank(num))
		{
			return oaod.findOrders(page, num);
		}
		else
		{
			return oaod.findOrders("0", "10");
		}
	}

	@Override
	public List<OrderAnalyseVo> getStatisInfo(String flag,String sta) {
		if(StringUtils.isNotBlank(flag)&&StringUtils.isNotBlank(sta))
			return oaod.getStatisInfo(flag,sta);
		else
			return null;
	}
	
	public List<OrderAnalyseVo> getStatisInfo(OrdeqpVo od)
	{
		if(od!=null)
		{
			return oaod.getOrderStatistic(od);
		}
		else
			 return null;
	}
}
