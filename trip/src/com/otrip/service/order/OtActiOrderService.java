package com.otrip.service.order;

import java.util.List;

import com.otrip.pojo.OrdeqpVo;
import com.otrip.pojo.OrderAnalyseVo;
import com.otrip.pojo.OrderInfoVo;

public interface OtActiOrderService {

	public List<OrderInfoVo> listOrders(String page,String num);
	
	public List<OrderAnalyseVo> getStatisInfo(String flag,String sta);
	
	public List<OrderAnalyseVo> getStatisInfo(OrdeqpVo od);
}
