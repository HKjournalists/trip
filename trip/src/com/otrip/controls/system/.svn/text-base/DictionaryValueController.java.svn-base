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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.otrip.controls.BaseController;
import com.otrip.domain.DomainUtils;
import com.otrip.domain.system.SysDictionaryType;
import com.otrip.domain.system.SysDictionaryValue;
import com.otrip.service.system.DictionaryTypeService;
import com.otrip.service.system.DictionaryValueService;

/**   
 * Filename:    DictionaryValueController.java   
 * Copyright:   Copyright (c)2015  
 * Company:     otrip  
 * @version:    1.0   
 * @since:  JDK 1.7.0_21  
 * Create at:   2015年3月21日 下午6:05:08   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年3月21日 zhongJc      1.0     1.0 Version   
 */

@Controller
@RequestMapping(value="/system/dictionary_value")
public class DictionaryValueController extends BaseController {
	
	static Logger log=Logger.getLogger(DictionaryValueController.class);
	
	private static final String view_manager="/system/dictionary/value_manager";
	private static final String view_child_list="/system/dictionary/value_child_list";
	private static final String view_add="/system/dictionary/value_add";
	
	private DictionaryValueService dictionaryValueService;
	private DictionaryTypeService	dictionaryTypeService;
	@Autowired
	public void setDictionaryValueService(
			DictionaryValueService dictionaryValueService) {
		this.dictionaryValueService = dictionaryValueService;
	}
	@Autowired
	public void setDictionaryTypeService(
			DictionaryTypeService dictionaryTypeService) {
		this.dictionaryTypeService = dictionaryTypeService;
	}
	
	/**
	 * @see 进入数据字典列表页面
	 * @param request
	 * @param response
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/manager.html")
	public ModelAndView manager(HttpServletRequest request,HttpServletResponse response,@ModelAttribute SysDictionaryValue sysDictionaryValue,BindingResult result) throws Exception{
		final ModelAndView mav=new ModelAndView(view_manager);
		final List<SysDictionaryValue> allDvList=dictionaryValueService.findAllDicValues(sysDictionaryValue);
		final List<SysDictionaryType> selTypeList=dictionaryTypeService.queryAllDictionaryType();
		mav.addObject("selTypeList", selTypeList);
		mav.addObject("allDvList", allDvList);
		mav.addObject("dv", sysDictionaryValue);
		return mav;
	}
	
	/**
	 * @see 获取子字典值信息列表
	 * @param request
	 * @param response
	 * @param sysDictionaryValue
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/child_list.html")
	public ModelAndView valueChildList(HttpServletRequest request,HttpServletResponse response,@ModelAttribute SysDictionaryValue sysDictionaryValue,@RequestParam("parentDivId") String parentDivId,BindingResult result) throws Exception{
		final ModelAndView mav=new ModelAndView(view_child_list);
		final List<SysDictionaryValue> childDvList=dictionaryValueService.queryChildDicValue(sysDictionaryValue, parentDivId);
		final SysDictionaryValue parentDv=dictionaryValueService.findSysDictionaryValueById(parentDivId);
		final List<SysDictionaryType> selTypeList=dictionaryTypeService.queryAllDictionaryType();
		
		
		mav.addObject("parentDivName", parentDv!=null&&StringUtils.isNotBlank(parentDv.getFsName())?parentDv.getFsName():super.getMessage("system.configure.manager.dictionary.value.child.pls.title", request, null));
		mav.addObject("childDvList", childDvList);
		mav.addObject("selTypeList", selTypeList);
		mav.addObject("dv",sysDictionaryValue);
		mav.addObject("parentDivId", parentDivId);
		return mav;
	}
	
	/**
	 * @see 新增到数据字典
	 * @param request
	 * @param response
	 * @param sysDictionaryValue
	 * @param parentDivId
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/to_add.html")
	public ModelAndView toAdd(HttpServletRequest request,HttpServletResponse response,@ModelAttribute SysDictionaryValue sysDictionaryValue,@RequestParam("parentDivId") String parentDivId,BindingResult result) throws Exception{
		final ModelAndView mav=new ModelAndView(view_add);
		if(StringUtils.isNotBlank(parentDivId)){
			final SysDictionaryValue parentDicv=dictionaryValueService.findSysDictionaryValueById(parentDivId);
			mav.addObject("parentDicv", parentDicv);
		}
		return mav;
	}
	
	/**
	 * @see 保存到数据字典
	 * @param request
	 * @param response
	 * @param sysDictionaryValue
	 * @param parentDivId
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	@RequestMapping(value="/save.html")
	public ModelAndView save(HttpServletRequest request,HttpServletResponse response,@ModelAttribute SysDictionaryValue sysDictionaryValue,BindingResult result) throws Exception{
		final ModelAndView mav=new ModelAndView(view_add);
		if(sysDictionaryValue!=null&&StringUtils.isNotBlank(sysDictionaryValue.getFsName())){
			sysDictionaryValue.setFsId(DomainUtils.generalUuid());
			sysDictionaryValue.setFdCreateTime(new Date());
			dictionaryValueService.saveDictionaryValue(sysDictionaryValue);
			mav.addObject(super.operator_state_code, "success");
		}else{
			mav.addObject(super.operator_state_code, "fail");
		}
		return mav;
	}
	
	@SuppressWarnings("static-access")
	@RequestMapping(value="/delete.html",params="json",method=RequestMethod.POST)
	@ResponseBody
	public String delete(HttpServletRequest request,HttpServletResponse response,@RequestParam("id") String id) throws Exception{		 
		 if(StringUtils.isNotBlank(id)){
 			log.info("delete dictionary Value id:"+id);
 			dictionaryValueService.deleteDictionaryValueById(id);
 			super.operatro_state_code_object.put(super.operator_state_code, "success");
 		}else{
 			super.operatro_state_code_object.put(super.operator_state_code, "fail");
 		}
		log.info(" Operator status#####:"+super.operatro_state_code_object.toString());
		return super.operatro_state_code_object.toString();
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
	
	/**
	 * @see 绑定字典类型对象
	 * @param binder
	 * @throws Exception
	 */
	@InitBinder("sysDictionaryValue")      
	public void initBinder2(ServletRequestDataBinder binder ) throws Exception{              
		binder.setFieldDefaultPrefix("dv.");     
	}
	
	

}
