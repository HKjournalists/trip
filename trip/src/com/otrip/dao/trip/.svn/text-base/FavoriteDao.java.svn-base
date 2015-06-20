package com.otrip.dao.trip;

import java.util.List;

import com.otrip.dao.IGenericDao;
import com.otrip.domain.trip.OtActiFavorite;
import com.otrip.domain.trip.OtActiType;
import com.otrip.pojo.FavoriteActiVo;
import com.otrip.pojo.UserFavoriteVo;

public interface FavoriteDao extends IGenericDao<OtActiFavorite, String>{

	
	public FavoriteActiVo getFavoriteByActi(String actiId);
	
	public List<FavoriteActiVo> getTopFavorite(int topNum);
	
	public UserFavoriteVo getFavoriteByUser(String userId);
	
	public List<UserFavoriteVo> getTopUserFav(int topNum);
}
