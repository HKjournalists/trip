package com.otrip.controls.trip.statistics;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.otrip.pojo.FavoriteActiVo;
import com.otrip.service.trip.FavoriteService;



@Controller
@RequestMapping(value="/trip/statistics/favourite")
public class FavouriteController {
	static Logger log=Logger.getLogger(FavouriteController.class);
	
	private static final String view_statistics_favourite="/trip/statistics/favourite/FavouriteView";
	
	@Autowired
	private FavoriteService favoriteService;
	
	
	
	public FavoriteService getFavoriteService() {
		return favoriteService;
	}



	public void setFavoriteService(FavoriteService favoriteService) {
		this.favoriteService = favoriteService;
	}



	@RequestMapping("/statistics.html")
	public ModelAndView viewFavouriteStatistics(@RequestParam(value="top",defaultValue="null",required=false)String top)
	{
		log.info("favourite view jsp");
		String topNum="5";
		if(StringUtils.isNotBlank(top))
		{	
			topNum=top;
			log.info("topNum :"+top );
		}
		List<FavoriteActiVo> list=this.favoriteService.getTopFavorite(topNum);
		ModelAndView mav=new ModelAndView(view_statistics_favourite);
		mav.addObject("favList", list);
		return mav;
	}
	
	
}
