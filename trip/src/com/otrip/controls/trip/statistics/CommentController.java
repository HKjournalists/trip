package com.otrip.controls.trip.statistics;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value="/trip/statistics/comment")
public class CommentController {
	static Logger log=Logger.getLogger(CommentController.class);
	
	private static final String view_statistics_comment="/trip/statistics/comment/commentView";
	
	@RequestMapping("/statistics.html")
	public ModelAndView viewCommentStatistics()
	{
		ModelAndView mav=new ModelAndView(view_statistics_comment);
		return mav;
	}
}
