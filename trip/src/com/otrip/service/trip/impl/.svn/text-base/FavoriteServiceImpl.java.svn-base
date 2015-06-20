package com.otrip.service.trip.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otrip.dao.trip.FavoriteDao;
import com.otrip.dao.util.ConvertDataUtil;
import com.otrip.pojo.FavoriteActiVo;
import com.otrip.service.trip.FavoriteService;

@Service(value="favoriteService")
public class FavoriteServiceImpl implements FavoriteService {

	private FavoriteDao favoriteDao;

	
	public FavoriteDao getFavoriteDao() {
		return favoriteDao;
	}

	@Autowired
	public void setFavoriteDao(FavoriteDao favoriteDao) {
		this.favoriteDao = favoriteDao;
	}
	
	/**
	 * 获取最热门的收藏活动
	 * @param top
	 * @return
	 */
	@Override
	public List<FavoriteActiVo> getTopFavorite(String top)
	{
		if(StringUtils.isNotBlank(top))
		{
			int topNum=ConvertDataUtil.StringToInt(top);
			return this.favoriteDao.getTopFavorite(topNum);
		}
		return null;
	}
	
	
	
}
