package com.otrip.dao.ws;

import java.util.List;
import java.util.Map;

import com.otrip.dao.IGenericDao;
import com.otrip.domain.trip.OtActiClickPraise;
import com.otrip.domain.trip.OtActiInfo;

public interface WsActiInfoDao extends IGenericDao<OtActiInfo, String> {
	
	//根据城市名或活动名称搜索
	public List findActiInfoByCityOrName(String param);
	
	
	//根据活动类型搜索
	public List findActiInfoByType(String actiType);
	
	//热门活动底部按类型搜索
	public List findActiInfoByPraiseAndType();
	
	//热门活动底部按目的地搜索
	public List findActiInfoByPraiseAndDestinName();
	
	
	//加载活动景点的经纬度
	public List getSecnicPositionByActiId(String actiId);
	
	//加载活动日程安排
	public List getDaysByActiId(String actiId);
	
	

	
}
