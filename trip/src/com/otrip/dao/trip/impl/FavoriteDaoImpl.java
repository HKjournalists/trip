package com.otrip.dao.trip.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.otrip.dao.GenericHibernateDao;
import com.otrip.dao.trip.FavoriteDao;
import com.otrip.domain.system.SysUser;
import com.otrip.domain.trip.OtActiFavorite;
import com.otrip.domain.trip.OtActiInfo;
import com.otrip.pojo.FavoriteActiVo;
import com.otrip.pojo.UserFavoriteVo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component(value="favoriteDao")
public class FavoriteDaoImpl extends GenericHibernateDao<OtActiFavorite, String> implements FavoriteDao
{
	
	public FavoriteActiVo getFavoriteByActi(String actiId)
	{
		if(StringUtils.isNotBlank(actiId))
		{
			OtActiInfo acti=super.getHibernateTemplate().get(OtActiInfo.class, actiId);
			if(acti!=null)
			{
				String sql=" select a.fs_id,a.fn_day,a.fn_trip_distance,a.fs_no,a.fs_title,b.favNum "
						+ " from (select fs_id,fn_day,fn_trip_distance,fs_no,fs_title from ot_acti_info "
						+ " where fs_id=? ) a inner join "
						+ " (select count(*) as favNum ,fs_acti_id from ot_acti_favorite where fs_acti_id=?"
						+ "  ) b on a.fs_id=b.fs_acti_id";
				List list=super.findBySQL(sql, new String[]{actiId});
				if(list.size()==1)
				{
					Map map=(Map) list.get(0);
					return this.getFavoriteActiVo(map);
				}
			}
			
		}
			return null;
	}

	public List<FavoriteActiVo> getTopFavorite(int topNum)
	{
		if(topNum>0)
		{
			String sql="  select a.fs_id,a.fn_day,a.fn_trip_distance,a.fs_no,a.fs_title,b.favNum from"
					+ " (select count(fs_id) as favNum, fs_acti_id from ot_acti_favorite group by fs_acti_id  limit 0,"+topNum+") b"
					+ " inner join (select fs_id,fn_day,fn_trip_distance,fs_no,fs_title from ot_acti_info) a on a.fs_id=b.fs_acti_id "
					+ " order by favNum desc";
			List list=super.findBySQL(sql);
			List<FavoriteActiVo> returnList=new ArrayList();
			if(list.size()>0)
			{
				for(int i=0;i<list.size();i++)
				{
					Map map=(Map)list.get(i);
					returnList.add(this.getFavoriteActiVo(map));
				}
				return returnList;
			}
		}
		return null;
	}
	
	public UserFavoriteVo getFavoriteByUser(String userId)
	{
		if(StringUtils.isNotBlank(userId))
		{
			SysUser user=super.getHibernateTemplate().get(SysUser.class, userId);
			if(user!=null)
			{
				String sql="select a.fs_id,a.fd_register_date,a.fs_account,a.fs_name,b.userFav from "
						+ " (select fs_id,fd_register_date,fs_account,fs_name from sys_user where fs_id=?) a inner join "
						+ " (select count(fs_id) as userFav ,fs_user_id  from ot_acti_favorite where fs_user_id=?) b on "
						+ " a.fs_id=b.fs_user_id";
				List list=super.findBySQL(sql, new String[]{userId});
				if(list.size()==1)
				{
					Map map=(Map)list.get(0);
					return this.getUserFavoriteVo(map);
				}
			}
			
		}
		return null;
	}
	
	public List<UserFavoriteVo> getTopUserFav(int topNum)
	{
		if(topNum>0)
		{
			String sql=" select a.fs_id,a.fd_register_date,a.fs_account,a.fs_name,b.userFav from "
					+ " (select count(fs_id) as userFav,fs_user_id from ot_acti_favorite group by  "
					+ " fs_user_id order by userFav desc limit 0,"+topNum+" ) b"
					+ " inner join (select fs_id,fd_register_date,fs_account,fs_name from sys_user ) "
					+ " a on  a.fs_id=b.fs_user_id;";
			List list=super.findBySQL(sql);
			List<UserFavoriteVo> returnList=new ArrayList();
			if(list.size()>0)
			{
				for(int i=0;i<list.size();i++)
				{
					Map map=(Map)list.get(i);
					returnList.add(this.getUserFavoriteVo(map));
				}
				return returnList;
			}
		}
		return null;
	}
	
	
	private FavoriteActiVo getFavoriteActiVo(Map map)
	{
		FavoriteActiVo  fav=new FavoriteActiVo();
		fav.setFsNo(map.get("fs_no")+"");
		fav.setFsId(map.get("fs_id")+"");
		fav.setFsTitle(map.get("fs_title")+"");
		fav.setFnTripDistance(map.get("fn_trip_distance")+"");
		fav.setFnDay(map.get("fn_day")+"");
		fav.setFavoriteNum(map.get("favNum")+"");
		return fav;
	}
	
	private UserFavoriteVo getUserFavoriteVo(Map map)
	{
		UserFavoriteVo ufav=new UserFavoriteVo();
		ufav.setAccount(map.get("fs_account")+"");
		ufav.setName(map.get("fs_name")+"");
		ufav.setRegisterDate(map.get("fd_register_date")+"");
		ufav.setUserFav(map.get("userFav")+"");
		ufav.setUserId(map.get("fs_id")+"");
		return ufav;
	}
}

