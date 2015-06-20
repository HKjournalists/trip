package com.otrip.controls.common.map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.otrip.controls.BaseController;

/**   
 * @Filename:    MapPositionController.java
 * @Copyright:   Copyright (c)2015  
 * @Company:     otrip 
 * @Author:      zhongJc  
 * @version:     v1.0   
 * @since:  	 JDK 1.7.0_21  
 * @Create at:   2015年4月16日 下午9:58:30  
 * @Description: TODO(用一句话描述该文件做什么)
 *   
 * Modification History:   
 * Date    		 Author       Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年4月16日 	 	 zhongJc      1.0     	  1.0 Version   
 */
@Controller
@RequestMapping("/common/map")
public class MapPositionController extends BaseController {

	static final Logger log=Logger.getLogger(MapPositionController.class);
	
	private static final String view_position_get="/common/map/get_position";
	
	@RequestMapping(value="/get_position.html")
	public ModelAndView coordinateWin(HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView mav=new ModelAndView(view_position_get);
		log.info("#######################进入地图坐标#######################");
		return mav;
	}
	
}
