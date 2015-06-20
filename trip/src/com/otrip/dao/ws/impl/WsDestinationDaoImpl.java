package com.otrip.dao.ws.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.otrip.dao.GenericHibernateDao;
import com.otrip.dao.util.ConvertDataUtil;
import com.otrip.dao.ws.WsDestinationDao;
import com.otrip.domain.DomainUtils;
import com.otrip.domain.system.OtImage;
import com.otrip.domain.system.SysUser;
import com.otrip.domain.trip.OtActiDestination;
import com.otrip.domain.trip.OtActiDiscuss;
import com.otrip.domain.trip.OtActiInfo;
import com.otrip.pojo.ws.Destination;

@Component(value="wsDestinationDao")
public class WsDestinationDaoImpl extends GenericHibernateDao<OtActiDestination, String> implements WsDestinationDao{

	Logger log=Logger.getLogger(WsDestinationDaoImpl.class);
	/**
	 * 查找指定位置附近的活动数量
	 */
	@Override
	public List<Destination> findOtActiDestinationByPosition(double fsLongitudel,
			double fsLatitude, String type) throws DataAccessException {
		
		List list;
		List midList;
		List returnList=new ArrayList();
		
	
		if(StringUtils.isNotBlank(type))
		{
			String fsId;
			String sql="select d.fs_id , d.fs_name from "
					+ "(select fs_id ,fs_name,fs_type_id from ot_acti_destination des "
					+ "order by "
					+ "ACOS(SIN(("+fsLatitude+"* 3.1415) / 180 ) *SIN(("+fsLatitude+" * 3.1415) / 180 ) +COS(("+fsLongitudel+" * 3.1415) / 180 ) * COS((des.fs_latitude * 3.1415) / 180 ) *COS(("+fsLongitudel+"* 3.1415) / 180 - (des.fs_longitudel * 3.1415) / 180 ) ) * 6380 "
					+ "asc) d inner join (select dest.fs_id from ot_acti_destination_type dest where dest.fs_name='"+type+"' ) d_dest on "
					+ "d.fs_type_id=d_dest.fs_id limit 2";
			list= super.findBySQL(sql);
			log.info("find city number:"+list.size());
			if(list.size()!=0)
			{
				for(int i=0;i<list.size();i++)
				{
					Map map=(Map)list.get(i);
					Destination des=new Destination();
					fsId=(String)map.get("fs_id");
					des.setDestiId(fsId);
					des.setDestiName((String)map.get("fs_name"));				
					midList=this.getActiNum(fsId);
					if(midList.size()!=0)
					{
						Map m=(Map)midList.get(0);
						log.info("find the number of the activities in the city is "+m.get("num"));
						des.setActiNum( m.get("num")+"");
					}
					else
					{
						log.info("there is no activities in the city"+des.getDestiName());
						des.setActiNum("0");
					}
					midList=this.getActiImageUrl(fsId);
					if(midList.size()!=0)
					{
						Map m=(Map)midList.get(0);
						log.info("find the image of the city is "+m.get("fs_url"));
						des.setDestiImg((String)m.get("fs_url"));
					}
					else
					{
						log.info("there is no image in the city"+des.getDestiName());
						des.setDestiImg("null");
					}
					returnList.add(des);
				}
			}
			return returnList;
		}
		else
		{
			log.info("the city number is 0");
			return null;
		}	
	}

	private List getActiNum(String fsId)
	{
		String sql="select count(*) as num from ot_acti_info where fs_acti_flag=0 and fs_destination_city='"+fsId+"' ";
		return super.findBySQL(sql);
	}
	private List getActiImageUrl(String fsId)
	{
		String sql="select fs_url from ot_image where fs_obj_id='"+fsId+"'";
		return super.findBySQL(sql);
	}
	
	
	//根据城市ID查找城市里的活动
	@Override
	public List findOtActisByCity(String fs_id) {
		String hql="from OtActiDestination as a where a.fsId=?";
		List list=super.find(hql, new String[]{fs_id});
		if(list.size()!=0)
		{
			log.info("find the number of destination is "+list.size());
			OtActiDestination otad=(OtActiDestination)list.get(0);
			return otad.getOtActiInfos4();
		}
		else
		{
			log.info("find the number of destination is "+list.size());
			return null;
		}
	}

	
	//根据点赞数获取热门活动的信息
	@Override
	@Deprecated
	public List searchOtActiByPraiseNum() {
		//String hql="from OtActiInfo as a order by a.fnPraiseNum desc";
		String sql=" select a.fs_id,a.fs_title,a.fs_physical_strength,g.fs_name,a.fn_trip_distance,a.fn_day,b.praiseNum" 
				+" , c.discussNum,e.fn_special_price,e.fn_original_price from ((((ot_acti_info a inner join" 
				+" (select fs_acti_id,count(fs_id) as praiseNum from ot_acti_click_praise group by fs_acti_id order by count(fs_id)" 
				+" desc limit 2) b on a.fs_id=b.fs_acti_id) inner join (select count(fs_id) as discussNum,fs_acti_id"  
				+" from ot_acti_discuss group by fs_acti_id) c on a.fs_id=c.fs_acti_id)"
                +" inner join (select fs_acti_id,fn_original_price,fn_special_price from ot_acti_time_price e where" 
                +" unix_timestamp(now()) between unix_timestamp(a.fd_start_time) and unix_timestamp(a.fd_end_time))"
                +" e on a.fs_id=e.fs_acti_id )) inner join ot_acti_type g on g.fs_id=a.fs_outdoors_type  ";
		return super.findBySQL(sql);
	}
	

	
	/**
	 * 按活动热度搜索
	 */
	@Override
	public List findOtActiByPraiseNum()
	{
		String sql=" select fs_acti_id from ot_acti_click_praise group by fs_acti_id order by count(fs_id) desc";
		log.info("the sql is"+ sql);
		List returnList=new ArrayList();
		List list=super.findBySQL(sql);	
		if(list.size()!=0)
		{
			log.info("find the number of activities is "+list.size());
			for(int i=0;i<list.size();i++)
			{
				//String actiId=String.valueOf(((Map) list.get(i)).get("fs_acti_id"));
				log.info("fs_acti_id :"+((Map) list.get(i)).get("fs_acti_id")+"");
				Map staMap=this.getActiPartInfoStaticInfo(((Map) list.get(i)).get("fs_acti_id")+"");
				Map dyaMap=this.getActiPartInfoDynamic(((Map) list.get(i)).get("fs_acti_id")+"");
				Map actiMap=new HashMap();
				actiMap.put("static", staMap);
				actiMap.put("dynamic", dyaMap);
				returnList.add(actiMap);
			}
			return returnList ;
		}
		else
			return null;
	}
	
	
	
	
	
	
	
	/**
	 * 按活动热度和类型搜索
	 */
	@Override
	public List getActiByPraiseAndType(String type) {
		// TODO Auto-generated method stub
		String sql="select z.fs_id from (select fs_id ,fs_outdoors_type,fs_acti_flag from ot_acti_info where fs_acti_flag=0 and fs_id in "
				+ " (select fs_acti_id from ot_acti_click_praise group by fs_acti_id order by count(fs_id) desc)) z inner join "
				+ " (select fs_id,fs_name from ot_acti_type where fs_name like '%"+type+"%') y on z.fs_outdoors_type=y.fs_id";
		List returnList=new ArrayList();
		List list=super.findBySQL(sql);	
		if(list.size()!=0)
		{
			for(int i=0;i<list.size();i++)
			{
				String actiId=String.valueOf(((Map) list.get(i)).get("fs_id"));
				Map staMap=this.getActiPartInfoStaticInfo(actiId);
				Map dyaMap=this.getActiPartInfoDynamic(actiId);
				Map actiMap=new HashMap();
				actiMap.put("static", staMap);
				actiMap.put("dynamic", dyaMap);
				returnList.add(actiMap);
			}
			return returnList ;
		}
		else
			return null;
	}

	//获取对应图片的url
	@Override
	public List findImageUrl(String value) {
		String hql="from OtImage as a where a.fsObjId=?";
		log.info("find image: "+hql+":"+value);
		List urlList=super.find(hql, new String[]{value});
		List returnList=new ArrayList();
		if(urlList.size()==0)
		{
			log.info("find no image return null");
			return null;
		}
		else
		{
			log.info("find image: "+urlList.size());;
			for(int i=0;i<urlList.size();i++)
			{
				OtImage o= (OtImage) urlList.get(i);
				returnList.add((String)o.getFsUrl());
			}
			return returnList;
		}
	
	}

	//统计用户的评级，计算平均值
	public String getActiLevel(String actiId)
	{
		String sql="select avg(fs_grade_level) as actiLevel from ot_acti_discuss where fs_acti_flag=0 and fs_acti_id='"+actiId+"'";
		List list=super.findBySQL(sql);
		if(list.size()!=0)
		{
			Map map=(Map)list.get(0);
			return (String)map.get("actiLevel");
		}
		else
			return null;
	}
	
	//根据活动ID查找活动详情
	@Override
	public Map getactiInfoByActiId(String actiId) {
		//String hql="from OtActiInfo as a where a.fsId=?";
		//List list=super.find(hql, new String[]{actiId});
		
		Map staticMap=this.getActiInfoStaticDetail(actiId);
		Map dyMap=this.getAcitDynamicDetail(actiId);
		Map actiMap=new HashMap();
		actiMap.put("static", staticMap);
		actiMap.put("dynamic",dyMap);
		if(staticMap!=null)
			return actiMap;
		else
			return null;
	}

	
	//获取位置信息加载地图
	@Override
	public List getDestinations(String longitude, String latitude) {
		// TODO Auto-generated method stub
		String sql="select fs_id,fs_longitudel,fs_latitude,fs_name from ot_acti_destination where fs_type_id in"
				+ " (select fs_id from ot_acti_destination_type where fs_name='城市' or fs_name='景区') order by ACOS(SIN(("+latitude+"* 3.1415) / 180 ) "
				+ " *SIN(("+latitude+" * 3.1415) / 180 ) + COS(("+longitude+" * 3.1415) / 180 ) * COS((fs_latitude * 3.1415) "
				+ " / 180 ) *COS(("+longitude+"* 3.1415) / 180 - (fs_longitudel * 3.1415) / 180 ) ) * 6380 asc  limit 5 ";
		List list= super.findBySQL(sql);
		if(list.size()!=0)
		{
			return list;
		}
		else
			return null;
	}

	
	
	/**
	 * 按目的地或者活动名称搜索活动
	 * @param keyWord
	 * @return
	 */
	@Deprecated
	//需要加上 where fs_acti_flag=0 的限制
	public List searchActiByNameOrDesci(String keyWord)
	{
		String sql="select a.fs_id,a.fs_title,a.fs_physical_strength,"
				+ " a.fs_outdoors_type,a.fn_trip_distance,a.fn_day,b.praiseNum "
				+ " , c.discussNum,e.fn_special_price,e.fn_original_price from "
				+ " ((((select h.fs_id,h.fs_title,h.fs_destination_city,g.fs_id "
				+ " as cityId ,g.fs_name,h.fs_physical_strength, h.fs_outdoors_type ,"
				+ " h.fn_trip_distance,h.fn_day from ot_acti_info h "
				+ " inner join ot_acti_destination g on h.fs_destination_city=g.fs_id "
				+ "  where fs_title like '%"+keyWord+"%' or fs_name like '%"+keyWord+"%') a inner join  "
				+ " (select fs_acti_id,count(fs_id) as praiseNum from ot_acti_click_praise "
				+ " group by fs_acti_id order by count(fs_id)) b on a.fs_id=b.fs_acti_id) inner join "
				+ " (select count(fs_id) as discussNum,fs_acti_id "
				+ " from ot_acti_discuss group by fs_acti_id) c on a.fs_id=c.fs_acti_id)"
				+ " inner join (select fs_acti_id,fn_original_price,fn_special_price from "
				+ " ot_acti_time_price a where unix_timestamp(now()) between unix_timestamp(a.fd_start_time) "
				+ " and unix_timestamp(a.fd_end_time)) e on a.fs_id=e.fs_acti_id)";
		List list=super.findBySQL(sql);
		if(list.size()!=0)
		{
			return list;
		}
		return null;
	}
	
	@Override
	public List findActiByNameOrDesci(String keyWord)
	{
		String sql="select a.fs_id from (select h.fs_id,h.fs_title,h.fs_destination_city,g.fs_id"
				+ " as cityId ,g.fs_name,h.fs_physical_strength, h.fs_outdoors_type , "
				+ " h.fn_trip_distance,h.fn_day ,h.fs_acti_flag from ot_acti_info h  "
				+ " inner join ot_acti_destination g on h.fs_destination_city=g.fs_id "
				+ " where fs_title like '%"+keyWord+"%' or g.fs_name like '%"+keyWord+"%') a where fs_acti_flag=0"; 
		
		List returnList=new ArrayList();
		List list=super.findBySQL(sql);	
		if(list.size()!=0)
		{
			for(int i=0;i<list.size();i++)
			{
				String actiId=String.valueOf(((Map) list.get(i)).get("fs_id"));
				Map staMap=this.getActiPartInfoStaticInfo(actiId);
				Map dyaMap=this.getActiPartInfoDynamic(actiId);
				Map actiMap=new HashMap();
				actiMap.put("static", staMap);
				actiMap.put("dynamic", dyaMap);
				returnList.add(actiMap);
			}
			return returnList ;
		}
		else
			return null;
	}
	/**
	 * 按活动类型搜索
	 * @param type
	 * @return
	 */
	@Deprecated
	//需要加上删除标志的限制 where fs_acti_flag=0
	public List searchActiByType(String type)
	{
		String sql=" select a.fs_id,a.fs_title,a.fs_physical_strength,a.fs_outdoors_type,"
				+ " a.fn_trip_distance,a.fn_day,b.praiseNum , c.discussNum,e.fn_special_price,e.fn_original_price ,a.fs_name  "
				+ " from ((((select z.fs_id,z.fs_title,z.fs_physical_strength, "
				+ " z.fs_outdoors_type,z.fn_trip_distance,z.fn_day,y.fs_name from ot_acti_info z inner join "
				+ " (select fs_id,fs_name from ot_acti_type where fs_name like '%"+type+"%') y on z.fs_outdoors_type=y.fs_id ) a inner join "
				+ " (select fs_acti_id,count(fs_id) as praiseNum from ot_acti_click_praise group by fs_acti_id "
				+ " ) b on a.fs_id=b.fs_acti_id) inner join (select count(fs_id) as discussNum,fs_acti_id "
				+ " from ot_acti_discuss group by fs_acti_id) c on a.fs_id=c.fs_acti_id) inner join (select fs_acti_id,fn_original_price,"
				+ " fn_special_price from ot_acti_time_price a where unix_timestamp(now()) between unix_timestamp(a.fd_start_time) and unix_timestamp(a.fd_end_time))"
				+ " e on a.fs_id=e.fs_acti_id)";
		List list=super.findBySQL(sql);
		if(list.size()!=0)
		{
			return list;
		}
		return null;
	}
	@Override
	public List findActiByType(String type)
	{
		String sql="select z.fs_id from (select fs_id ,fs_outdoors_type ,fs_acti_flag from ot_acti_info where fs_acti_flag=0) z "
				+ " inner join (select fs_id,fs_name from ot_acti_type where fs_name like '%"+type+"%') y "
						+ " on z.fs_outdoors_type=y.fs_id";
		List returnList=new ArrayList();
		List list=super.findBySQL(sql);	
		if(list.size()!=0)
		{
			for(int i=0;i<list.size();i++)
			{
				String actiId=String.valueOf(((Map) list.get(i)).get("fs_id"));
				Map staMap=this.getActiPartInfoStaticInfo(actiId);
				Map dyaMap=this.getActiPartInfoDynamic(actiId);
				Map actiMap=new HashMap();
				actiMap.put("static", staMap);
				actiMap.put("dynamic", dyaMap);
				returnList.add(actiMap);
			}
			return returnList ;
		}
		else
			return null;
	}
	

	
	
	
	
	
	
	
	
	
	@Override
	public Map getActiInfoStaticDetail(String actiId) {
		String sql=" select a.fs_id,a.fn_day,a.fn_trip_distance,a.fs_cost_notes,a.fs_equip_list,a.fs_line_road,a.fs_no,"
				+ " a.fs_physical_strength,a.fs_refund_notes,a.fs_title,b.fn_special_price ,a.fs_destination_country ,"
				+ " a.fs_destination_type,d.fs_name as country,e.fs_name as actiType  from (((select z.fs_id,z.fn_day,z.fn_trip_distance,"
				+ " z.fs_cost_notes,z.fs_equip_list,z.fs_line_road,z.fs_no,z.fs_physical_strength,z.fs_refund_notes,"
				+ " z.fs_title, z.fs_destination_country ,z.fs_destination_type,z.fs_outdoors_type from ot_acti_info z "
				+ " where fs_id=?) a inner join (select fn_special_price,fs_acti_id "
				+ " from ot_acti_time_price f where unix_timestamp(now()) between unix_timestamp(f.fd_start_time) and "
				+ " unix_timestamp(f.fd_end_time) and f.fs_flag=0) b on a.fs_id =b.fs_acti_id) inner join (select fs_name,"
				+ " fs_id from ot_acti_destination) d on fs_destination_country=d.fs_id) inner join (select fs_id,fs_name "
				+ " from ot_acti_type) e on a.fs_outdoors_type=e.fs_id";
		List list=this.findBySQL(sql, new String[]{actiId});
		if(list.size()!=0)
		{
			return (Map)list.get(0);
		}
		else
			return null;
	}

	@Override
	public Map getAcitDynamicDetail(String actiId) {
		String sql=" select a.fs_id,b.disNum,b.actiLevel,f.praiseNum"
				+ "  from ((select fs_id from ot_acti_info where fs_id=?) a inner join "
				+ " (select count(fs_id) as disNum,fs_acti_id,round(avg(fs_grade_level),0) as actiLevel from ot_acti_discuss "
				+ " group by fs_acti_id ) b on a.fs_id=b.fs_acti_id) inner join (select count(fs_id) as praiseNum,fs_acti_id "
				+ " from ot_acti_click_praise group by fs_acti_id) f on f.fs_acti_id=a.fs_id";
		List list=this.findBySQL(sql, new String[]{actiId});
		if(list.size()!=0)
		{
			return (Map)list.get(0);
		}
		else
			return null;
	}

	@Override
	public Map getActiPartInfoStaticInfo(String actiId) {
		// TODO Auto-generated method stub
		String sql="select a.fs_id,a.fs_title,a.fs_physical_strength ,a.fn_trip_distance,a.fn_day ,b.fs_name,d.fn_original_price,"
				+ " d.fn_special_price from ((select fs_id,fs_title,fs_physical_strength,fn_trip_distance,fn_day,fs_outdoors_type from "
				+ " ot_acti_info where fs_id=?) a inner join (select fs_id,fs_name from ot_acti_type )"
				+ "  b on a.fs_outdoors_type=b.fs_id) inner join (select fs_acti_id,fd_start_time,fd_end_time,fn_original_price,"
				+ "  fn_special_price,fs_flag from ot_acti_time_price where fs_flag=0) d on a.fs_id=d.fs_acti_id";
		List list=this.findBySQL(sql, new String[]{actiId});
		log.info(sql);
		log.info("find the part static information :"+ list.size());
		if(list.size()!=0)
		{
			return (Map)list.get(0);
		}
		else
		{
			log.info("find the part static information failed,the size is"+list.size());
			return null;
		}
	}

	@Override
	public Map getActiPartInfoDynamic(String actiId) {
		String sql=" select a.disNum,b.praiseNum from (select count(fs_id) as disNum,fs_acti_id from ot_acti_discuss group by "
				+ " fs_acti_id having fs_acti_id=?) a inner join (select count(fs_id) as "
				+ " praiseNum ,fs_acti_id from ot_acti_click_praise group by fs_acti_id) b on a.fs_acti_id =b.fs_acti_id";
		List list=this.findBySQL(sql, new String[]{actiId});
		log.info(sql);
		log.info("find the part dynamic information :"+ list.size());
		if(list.size()!=0)
		{
			return (Map)list.get(0);
		}
		else
		{
			log.info("find the part dynamic information failed,the size is"+list.size());
			return null;
		}
	}

	/**
	 * 根据热度和目的地搜索
	 */
	@Override
	public List getActiByPraiseAndDesti(String desti) {
		String sql="select a.fs_id from (select fs_id ,fs_destination_city,fs_destination_country,fs_destination_province ,fs_acti_flag from ot_acti_info "
				+ " where fs_acti_flag=0 and fs_id in (select fs_acti_id from ot_acti_click_praise group by fs_acti_id order by count(fs_id) desc)) a where "
				+ " fs_destination_city in (select b.fs_id from ot_acti_destination b where fs_name like '%"+desti+"%') or"
				+ " fs_destination_country in (select b.fs_id from ot_acti_destination b where fs_name like '%"+desti+"%') or"
				+ " fs_destination_province in (select b.fs_id from ot_acti_destination  b where fs_name like '%"+desti+"%') ";
		List returnList=new ArrayList();
		List list=super.findBySQL(sql);	
		log.info("getActiByPraiseAndDesti:the acti number is"+list.size());
		if(list.size()!=0)
		{
			for(int i=0;i<list.size();i++)
			{
				String actiId=String.valueOf(((Map) list.get(i)).get("fs_id"));
				Map staMap=this.getActiPartInfoStaticInfo(actiId);
				Map dyaMap=this.getActiPartInfoDynamic(actiId);
				Map actiMap=new HashMap();
				actiMap.put("static", staMap);
				actiMap.put("dynamic", dyaMap);
				returnList.add(actiMap);
			}
			return returnList ;
		}
		else
		{
			log.info("getActiByPraiseAndDesti:the acti number is 0 return null");
			return null;
		}
	}

	/**
	 * 根据地图搜索
	 */
	@Override
	public List findActiByMapCountry(String countryId) {
		// TODO Auto-generated method stub
		
		String sql="select fs_id,fs_acti_flag from ot_acti_info a where and a.fs_acti_flag=0 and a.fs_destination_country=?";
		List list=super.findBySQL(sql, new String[]{countryId});
		List returnList=new ArrayList();
		log.info("findActiByMapCountry:the acti number is "+list.size());
		if(list.size()!=0)
		{
			for(int i=0;i<list.size();i++)
			{
				String actiId=String.valueOf(((Map) list.get(i)).get("fs_id"));
				Map staMap=this.getActiPartInfoStaticInfo(actiId);
				Map dyaMap=this.getActiPartInfoDynamic(actiId);
				Map actiMap=new HashMap();
				actiMap.put("static", staMap);
				actiMap.put("dynamic", dyaMap);
				returnList.add(actiMap);
			}
			return returnList ;
		}
		else
		{
			log.info("findActiByMapCountry:the acti number is 0 return null");
			return null;
		}
	}
	
	//获取活动景点的经纬度
	public List getActiScenicByActiId(String actiId)
	{
		String sql="select fs_longitude as longitude,fs_latitude  as latitude from ot_acti_day where fs_acti_id=? and fs_flag=0";
		log.info("getActiSecnicByActiId sql:"+sql);
		List list=super.findBySQL(sql, new String[]{actiId});
		log.info("getActiScenicByActiId:the scenic position :"+list.size());
		if(list.size()!=0)
		{
			return list;
		}
		else
		{
			log.info("getActiScenicByActiId:the scenic position is 0 return null");
			return null;
		}
	}
	//获取点赞用户
	public List getPraiseUsers(String actiId)
	{
		String sql=" select b.fs_name ,a.userId from (select fs_user_id as userId from ot_acti_click_praise where "
				+ " state=0 and fs_acti_id=?) a inner join sys_user b on a.userId=b.fs_id";
		log.info("getPraiseUsers sql:"+sql);
		List list=super.findBySQL(sql, new String[]{actiId});
		log.info("getPraiseUsers: the number is"+list.size());
		if(list.size()!=0)
		{
			return list;
		}
		else
		{
			log.info("getPraiseUsers: the number is 0 return null");
			return null;
		}
	}
	//获取活动日程
	public List getActiDays(String actiId)
	{
		String sql="select fs_id,fn_days,fs_description,"
				+ " fs_name from ot_acti_day where fs_acti_id=? and fs_flag=0 order by fn_days";
		log.info("getActiDays :sql"+sql);
		List list=super.findBySQL(sql, new String[]{actiId });
		log.info("getActiDays :"+list.size());
		if(list.size()!=0)
		{
			return list;
		}
		else
		{
			log.info("getActiDays return null");
			return null;
		}
	}
	
	//按活动国家名搜索
	public List getActiIdByCountryName(String countryName)
	{
		String sql="select fs_id from ot_acti_info where fs_acti_flag=0 and fs_destination_country "
				+ " in  (select fs_id from ot_acti_destination where fs_name=?)";
		List list=super.findBySQL(sql, new String[]{countryName});
		List returnList=new ArrayList();
		log.info("find actiId num :"+list.size());
		if(list.size()!=0)
		{
			for(int i=0;i<list.size();i++)
			{
				String actiId=String.valueOf(((Map) list.get(i)).get("fs_id"));
				Map staMap=this.getActiPartInfoStaticInfo(actiId);
				Map dyaMap=this.getActiPartInfoDynamic(actiId);
				Map actiMap=new HashMap();
				actiMap.put("static", staMap);
				actiMap.put("dynamic", dyaMap);
				returnList.add(actiMap);
			}
			return returnList ;
		}
		else
		{
			return null;
		}

	}
	
	//查找国家
	public List findCountries()
	{
		String sql="select fs_name,fs_id from ot_acti_destination where fs_type_id='19d49996-07d0-4817-8612-d46133cfc04b' order by fd_update_time desc limit 5";
		List list=super.findBySQL(sql);
		if(list.size()!=0)
		{
			log.info("find country num: "+list.size());
			return list;
		}
		else
		{
			log.info("find no country return null");
			return null; 
		}
		
	}
	
	//获取活动类型
	public List findTypes()
	{
		String sql="select fs_id,fs_name from ot_acti_type";
		List list=super.findBySQL(sql);
		if(list.size()!=0)
		{
			log.info("find type num: "+list.size() );
			return list;
		}
		else
		{
			log.info("find no type return null");
			return null;
		}
	}
}
