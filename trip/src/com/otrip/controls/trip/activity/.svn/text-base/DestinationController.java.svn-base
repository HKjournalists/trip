package com.otrip.controls.trip.activity;   

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.ztree.utils.NodeMenu;

import com.otrip.controls.BaseController;
import com.otrip.controls.trip.configure.ActivityDestinationTypeController;
import com.otrip.domain.DomainUtils;
import com.otrip.domain.system.SysMenuAuth;
import com.otrip.domain.trip.OtActiDestination;
import com.otrip.domain.trip.OtActiType;
import com.otrip.initdata.datacache.SystemDataCache;
import com.otrip.service.trip.DestinationService;

/**   
 * Filename:    DestinationController.java   
 * Copyright:   Copyright (c)2015  
 * Company:     otrip  
 * @version:    1.0   
 * @since:  JDK 1.7.0_21  
 * Create at:   2015年3月28日 下午4:56:29   
 * Description:  景区管理控制类
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年3月28日 zhongJc      1.0     1.0 Version   
 */
@Controller
@RequestMapping(value="/trip/activity/destination")
public class DestinationController extends BaseController {
	
	static Logger log=Logger.getLogger(DestinationController.class);

	private static final String view_destination_manager="/trip/activity/destination/manager";
	private static final String view_destination_tree="/trip/activity/destination/tree";
	private static final String view_destination_add="/trip/activity/destination/add";
	private static final String view_destination_view="/trip/activity/destination/view";
	private static final String view_destination_coordinate="/trip/activity/destination/coordinate";
	private static final String view_destination_position="/common/map/get_position";
	
	private DestinationService destinationService;
	@Autowired
	public void setDestinationService(DestinationService destinationService) {
		this.destinationService = destinationService;
	}
	
	/**
	 * @see 加载景区主界面
	 * @param request
	 * @param response
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/manager.html")
	public ModelAndView  manager(HttpServletRequest request,HttpServletResponse response,@ModelAttribute OtActiDestination otActiDestination,BindingResult result) throws Exception{
		ModelAndView mav=new ModelAndView(view_destination_manager);
		otActiDestination=destinationService.getOtActiDestinationById(SystemDataCache.getRootDestinationId());
		mav.addObject("ad", otActiDestination);
		return mav;
	}
	
	/**
	 * @see 加载景区树界面
	 * @param request
	 * @param response
	 * @param otActiDestination
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/tree.html")
	public ModelAndView tree(HttpServletRequest request,HttpServletResponse response,@ModelAttribute OtActiDestination otActiDestination,BindingResult result)throws Exception{
		ModelAndView mav=new ModelAndView(view_destination_tree);
		return mav;
	}
	
	/**
	 * @see 获取景区树结构树
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/json_tree.html",params="json", method = RequestMethod.POST) 
	public void loadMenuTree(HttpServletRequest request,HttpServletResponse response) throws Exception{
		final List<NodeMenu> listMenu=new ArrayList<NodeMenu>();
		final List<OtActiDestination> listDestination=destinationService.findAllOtActiDestinations();
		if(listDestination!=null&&listDestination.size()>0){
			NodeMenu nm=null;
			for(OtActiDestination d:listDestination ){
				nm=new NodeMenu();
				nm.setId(d.getFsId());
				nm.setName(d.getFsName());
				nm.setpId(d.getFsParentId());
				if(SystemDataCache.getRootDestinationParentId().equals(d.getFsParentId())){
					nm.setOpen("true");
				}
				listMenu.add(nm);
			}
		}
		final JSONArray json = JSONArray.fromObject(listMenu);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(json.toString());
		response.getWriter().flush();
		response.getWriter().close();
	}
	
	/**
	 * @see 查看景区信息
	 * @param request
	 * @param response
	 * @param otActiDestination
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/view.html")
	public ModelAndView	viewDestination(HttpServletRequest request,HttpServletResponse response,@ModelAttribute OtActiDestination otActiDestination,String queryDestinationName,BindingResult result)throws Exception{
		ModelAndView mav=new ModelAndView(view_destination_view);
		final String destinationId=otActiDestination!=null&&StringUtils.isNotBlank(otActiDestination.getFsId())?otActiDestination.getFsId():SystemDataCache.getRootDestinationId();
		final OtActiDestination selDestination=destinationService.getOtActiDestinationById(destinationId);
		if(selDestination!=null&&StringUtils.isNotBlank(selDestination.getFsParentId())){
			final OtActiDestination parentDestination=destinationService.getOtActiDestinationById(selDestination.getFsParentId());
			mav.addObject("pad", parentDestination);
		}else{
			mav.addObject("pad", null);
		}
		final List<OtActiDestination> listChildsDestination=destinationService.findChildsOtActiDestinationsByName(destinationId, queryDestinationName);
		mav.addObject("queryDestinationName", queryDestinationName);
		mav.addObject("ad", selDestination);
		mav.addObject("listChildsDestination", listChildsDestination);
		return mav;
	}
	
	@RequestMapping(value="/add_child_destination.html")
	public ModelAndView	addDestination(HttpServletRequest request,HttpServletResponse response,@ModelAttribute OtActiDestination otActiDestination,BindingResult result)throws Exception{
		ModelAndView mav=new ModelAndView(view_destination_add);
		if(otActiDestination!=null&&StringUtils.isNotBlank(otActiDestination.getFsParentId())){
			final OtActiDestination parentDestination=destinationService.getOtActiDestinationById(otActiDestination.getFsParentId());
			mav.addObject("pad", parentDestination); 
		}else{
			mav.addObject("pad", null); 
		}
		return mav;
	}
	
	@SuppressWarnings("static-access")
	@RequestMapping(value="/save.html")
	public ModelAndView	saveDestination(HttpServletRequest request,HttpServletResponse response,@ModelAttribute OtActiDestination otActiDestination,BindingResult result)throws Exception{
		ModelAndView mav=new ModelAndView(view_destination_add);
		log.info("#######Add otrip Dstination Info:##########");
		if(otActiDestination!=null&&StringUtils.isNotBlank(otActiDestination.getFsName())&&StringUtils.isNotBlank(otActiDestination.getFsParentId())){
			otActiDestination.setFdCreateTime(new Date());
			otActiDestination.setFsId(DomainUtils.generalUuid());
			destinationService.saveOtActiDestion(otActiDestination);
			mav.addObject(super.operator_state_code, "success");
			
		}else{
			mav.addObject(super.operator_state_code, "fail");
		}
		mav.addObject("ad",otActiDestination);
		return mav;
	}
	
	/**
	 * @see 进入地图坐标
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/coordinate.html")
	public ModelAndView coordinateWin(HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView mav=new ModelAndView(view_destination_coordinate);
		log.info("#######################进入地图坐标#######################");
		return mav;
	}
	
	@RequestMapping(value="/position.html")
	public ModelAndView getPosition(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		ModelAndView mav=new ModelAndView(view_destination_position);
		return mav;
	}
	
	
	@InitBinder("otActiDestination")      
	public void initBinder1(ServletRequestDataBinder binder) throws Exception{              
		binder.setFieldDefaultPrefix("ad.");     
	}
	
	
	

}
