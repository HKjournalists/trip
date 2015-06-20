package com.otrip.controls.system;   

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.otrip.controls.BaseController;
import com.otrip.domain.DomainUtils;
import com.otrip.domain.system.SysDictionaryType;
import com.otrip.domain.system.SysResource;
import com.otrip.service.system.DictionaryTypeService;
import com.sun.tools.xjc.model.Model;

/**   
 * Filename:    DictionaryTypeController.java   
 * Copyright:   Copyright (c)2015  
 * Company:     otrip  
 * @version:    1.0   
 * @since:  JDK 1.7.0_21  
 * Create at:   2015年3月19日 下午9:44:27   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年3月19日 	zhongJc      1.0     1.0 Version   
 */

@Controller
@RequestMapping(value="/system/dictionary_type")
public class DictionaryTypeController extends BaseController {
	
	static Logger log=Logger.getLogger(DictionaryTypeController.class);
	
	private static final String view_manager="/system/dictionary/type_manager";
	private static final String view_select="/system/dictionary/type_select";
	private static final String view_add="/system/dictionary/type_add";
	
	
	private DictionaryTypeService dictionaryTypeService;
	@Autowired
	public void setDictionaryTypeService(
			DictionaryTypeService dictionaryTypeService) {
		this.dictionaryTypeService = dictionaryTypeService;
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @param sysDictionaryType
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/manager.html")
	public ModelAndView managerDictionaryType(HttpServletRequest request,HttpServletResponse response,@ModelAttribute SysDictionaryType  sysDictionaryType,BindingResult result) throws Exception{
		final ModelAndView mav=new ModelAndView(view_manager);
		final List<SysDictionaryType> dtList=dictionaryTypeService.queryDictionaryType(sysDictionaryType);
		mav.addObject("dt", sysDictionaryType);
		mav.addObject("dtList", dtList);
		return mav;
	}
	

	/**
	 * 
	 * @param request
	 * @param response
	 * @param sysDictionaryType
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/toAdd.html")
	public ModelAndView toAddDictionaryType(HttpServletRequest request,HttpServletResponse response,@ModelAttribute SysDictionaryType  sysDictionaryType,BindingResult result) throws Exception{
		final ModelAndView mav=new ModelAndView(view_add);
		return mav;
	}
	
	/**
	 * @see 保存字典类型
	 * @param request
	 * @param response
	 * @param sysDictionaryType
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	@RequestMapping(value="/save.html")
	public ModelAndView saveDictionaryType(HttpServletRequest request,HttpServletResponse response,@ModelAttribute SysDictionaryType  sysDictionaryType,BindingResult result) throws Exception{
		final ModelAndView mav=new ModelAndView(view_add);
		if(sysDictionaryType!=null&&StringUtils.isNotBlank(sysDictionaryType.getFsName())){
			sysDictionaryType.setFdCreateTime(new Date());
			sysDictionaryType.setFsId(DomainUtils.generalUuid());
			dictionaryTypeService.saveDictionaryType(sysDictionaryType);
			mav.addObject(super.operator_state_code, "success");
		}else{
			mav.addObject(super.operator_state_code, "fail");
		}
		return mav;
	}
	
	
	@RequestMapping(value="/select.html")
	public ModelAndView selectDictionaryType(HttpServletRequest request,HttpServletResponse response,@ModelAttribute SysDictionaryType  sysDictionaryType,BindingResult result) throws Exception{
		final ModelAndView mav=new ModelAndView(view_select);
		final List<SysDictionaryType> dtList=dictionaryTypeService.queryDictionaryType(sysDictionaryType);
		mav.addObject("dt", sysDictionaryType);
		mav.addObject("dtList", dtList);
		return mav;
	}
	
	
	/**
	 * @see 绑定字典类型对象
	 * @param binder
	 * @throws Exception
	 */
	@InitBinder("sysDictionaryType")      
	public void initBinder1(ServletRequestDataBinder binder ) throws Exception{              
		binder.setFieldDefaultPrefix("dt.");     
	}
	

}
