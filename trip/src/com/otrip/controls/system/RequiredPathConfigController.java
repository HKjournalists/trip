package com.otrip.controls.system;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.metamodel.domain.Superclass;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.otrip.controls.BaseController;
import com.otrip.domain.system.SysResource;
import com.otrip.service.system.ResourceService;
/**
 * @see 请求地址控制类
 * @author zhongJc
 *
 */
@Controller
@RequestMapping(value="/system/requiredpath")
public class RequiredPathConfigController extends BaseController {
	
	static Logger log=Logger.getLogger(RequiredPathConfigController.class);
	
	private static final String view_list="/system/requiredpath/list";
	private static final String view_add="/system/requiredpath/add";	
	private static final String view_select_list="/system/requiredpath/select_list";
	
	
	private static final String action_list="redirect:/system/requiredpath/list.html";
	
	private ResourceService resourceService;
	@Autowired
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}
	
	/**
	 * @see 请求地址配置列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/list.html")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response,@ModelAttribute SysResource sysResource,BindingResult result){
		ModelAndView mav=new ModelAndView(view_list);
		final List<SysResource> resourceAll=resourceService.queryRescourcesBySysResource(sysResource);
		mav.addObject("resourceList", resourceAll);
		mav.addObject("sysResource", sysResource);
		
		return mav;
	}
	
	/**
	 * @see 请求地址配置列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/select_list.html")
	public ModelAndView selectList(HttpServletRequest request,HttpServletResponse response,@ModelAttribute SysResource sysResource,BindingResult result){
		ModelAndView mav=new ModelAndView(view_select_list);
		final List<SysResource> resourceAll=resourceService.queryRescourcesBySysResource(sysResource);
		mav.addObject("resourceList", resourceAll);
		mav.addObject("sysResource", sysResource);
		return mav;
	}
	
	/**
	 * @see 新增请求地址
	 * @param request
	 * @param response
	 * @param sysResource
	 * @param result
	 * @return
	 */
	@RequestMapping(value="/toAdd.html")
	public ModelAndView toAdd(HttpServletRequest request,HttpServletResponse response,@ModelAttribute SysResource sysResource,BindingResult result){
		ModelAndView mav=new ModelAndView(view_add);
		log.info("in add page.");
		return mav;
	}
	
	
	/**
	 * @see 保存地址请求
	 * @param request
	 * @param response
	 * @param sysResource
	 * @param result
	 * @return
	 */
	@RequestMapping(value="/save.html")
	public ModelAndView save(HttpServletRequest request,HttpServletResponse response,@ModelAttribute SysResource sysResource,BindingResult result){
		ModelAndView mav=new ModelAndView(view_add);
		log.info("in add page.");
		sysResource.setFdCreateTime(new Date());
		sysResource=resourceService.addSysResource(sysResource);
		mav.addObject(super.operator_state_code, "success");
		return mav;
	}
	
	/**
	 * @see 删除地址请求
	 * @param request
	 * @param response
	 * @param id
	 * @param result
	 * @return
	 */
	@SuppressWarnings("static-access")
	@RequestMapping(value="/delete.html",params="json",method=RequestMethod.POST)
	@ResponseBody
	public String delete(HttpServletRequest request,HttpServletResponse response,@RequestParam("id") String id){		 
		 if(StringUtils.isNotBlank(id)){
 			log.info("delete Resources id:"+id);
 			resourceService.delSysResourceById(id);
 			super.operatro_state_code_object.put(super.operator_state_code, "success");
 		}else{
 			super.operatro_state_code_object.put(super.operator_state_code, "fail");
 		}
		log.info(" Operator status#####:"+super.operatro_state_code_object.toString());
		return super.operatro_state_code_object.toString();
	}
	
	
	/**
	 * @see 绑定地址请求
	 * @param binder
	 */
	@InitBinder("sysResource")      
	public void initBinder1(ServletRequestDataBinder binder) throws Exception{              
		binder.setFieldDefaultPrefix("reso.");     
	} 
	
	
}
