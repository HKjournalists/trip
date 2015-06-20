package com.otrip.dao.ws;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.otrip.dao.IGenericDao;
import com.otrip.domain.trip.OtActiDestination;
import com.otrip.domain.trip.OtActiInfo;
import com.otrip.domain.ws.WsLogLogin;

public interface WsDestinationDao extends IGenericDao<OtActiDestination, String> {
	
	//根据经纬度加载附近的城市和活动
	public List findOtActiDestinationByPosition(final double fsLongitudel , final double fsLatitude ,String type) throws DataAccessException;

	
	//根据城市查询附近的活动
	public List findOtActisByCity(final String fs_id);
	
	
	//根据点赞数查询活动
	public List searchOtActiByPraiseNum();
	
	//查找图片
	public List findImageUrl(String value);
	
	//根据活动ID 加载活动详情
	public Map getactiInfoByActiId(String actiId);
	
	//获取活动评级
	public String getActiLevel(String actiId);
	//加载搜索地图
	public List getDestinations(String longitude,String latitude);
	//获取这个国家的活动
	public List findActiByMapCountry(String countryId);
	/**
	 * 根据活动热度和活动类型搜索
	 * @param actiId
	 * @return
	 */
	public List getActiByPraiseAndType(String type);
	
	/**
	 * 按活动类型搜索
	 * @param type
	 * @return
	 */
	public List findActiByType(String type);
	
	/**
	 * 按活动热度搜索
	 */
	public List findOtActiByPraiseNum();
	/**
	 * 根据活动热度和目的地搜索
	 * @param actiId
	 * @return
	 */
	public List getActiByPraiseAndDesti(String desti);
	
	//加载活动详情的静态部分
		public Map getActiInfoStaticDetail(String actiId);
		
		//加载活动详情动态部分(评论，点赞等信息)
		public Map getAcitDynamicDetail(String actiId);
		
		//加载活动部分详情的静态部分
		public Map getActiPartInfoStaticInfo(String actiId);
		
		//加载活动部分详情动态部分(评论，点赞等信息)
		public Map getActiPartInfoDynamic(String actiId);
		
		public List findActiByNameOrDesci(String keyWord);
		
		//获取活动景点的经纬度
		public List getActiScenicByActiId(String actiId);
		
		//获取点赞用户
		public List getPraiseUsers(String actiId);
		
		//获取活动日程
		public List getActiDays(String actiId);
		//按国家名搜索活动
		public List getActiIdByCountryName(String countryName);
		//查找国家
		public List findCountries();
		
		//获取活动类型
		public List findTypes();
}
