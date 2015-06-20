package com.otrip.controls.trip.statistics;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value="/trip/statistics/praise")
public class PraiseController {

	static Logger log=Logger.getLogger(PraiseController.class);
	private static final String view_statistics_praise="/trip/statistics/clickPraise/PraiseView";
	
	@RequestMapping("/statistics.html")
	public ModelAndView viewPraiseStatistics()
	{
		ModelAndView mav=new ModelAndView(view_statistics_praise);
		return mav;
	}
}
