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
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.otrip.controls.BaseController;
import com.otrip.domain.system.SysMenuType;
import com.otrip.domain.system.SysResource;
import com.otrip.service.system.MenuTypeService;
import com.otrip.service.system.ResourceService;
/**
 * @see 菜单类型管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="/system/menutype")
public class MenuTypeManagerController extends BaseController {
	
	static Logger log=Logger.getLogger(MenuTypeManagerController.class);
	
	private static final String view_list="/system/menutype/list";
	private static final String view_add="/system/menutype/add";
	
	private MenuTypeService menuTypeService;
	@Autowired
	public void setMenuTypeService(MenuTypeService menuTypeService) {
		this.menuTypeService = menuTypeService;
	}
	
	/**
	 * @see 请求地址配置列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/list.html")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response,@ModelAttribute SysMenuType sysMenuType,BindingResult result){
		ModelAndView mav=new ModelAndView(view_list);
		final List<SysMenuType> menuTypeList=menuTypeService.findSysMenuType(sysMenuType);
		mav.addObject("menuTypeList", menuTypeList);
		mav.addObject("sysMenuType", sysMenuType);
		return mav;
	}
	
	/**
	 * @see 新增菜单类型
	 * @param request
	 * @param response
	 * @param OtripMenuType
	 * @param result
	 * @return
	 */
	@RequestMapping(value="/toAdd.html")
	public ModelAndView toAdd(HttpServletRequest request,HttpServletResponse response,@ModelAttribute SysMenuType sysMenuType,BindingResult result){
		ModelAndView mav=new ModelAndView(view_add);
		log.info("in add page.");
		return mav;
	}
	
	/**
	 * @see 保存菜单类型
	 * @param request
	 * @param response
	 * @param OtripMenuType
	 * @param result
	 * @return
	 */
	@SuppressWarnings("static-access")
	@RequestMapping(value="/save.html")
	public ModelAndView save(HttpServletRequest request,HttpServletResponse response,@ModelAttribute SysMenuType sysMenuType,BindingResult result){
		ModelAndView mav=new ModelAndView(view_add);
		log.info("in add page.");
		sysMenuType.setFdCreateTime(new Date());
		menuTypeService.addSysMenuType(sysMenuType);
		mav.addObject(super.operator_state_code, "success");
		return mav;
	}
	
	/**
	 * @see 删除菜单类型
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@SuppressWarnings("static-access")
	@RequestMapping(value="/delete.html",params="json",method=RequestMethod.POST)
	@ResponseBody
	public String delete(HttpServletRequest request,HttpServletResponse response,@RequestParam("id") String id){		 
		 if(StringUtils.isNotBlank(id)){
 			log.info("delete MenuType id:"+id);
 			menuTypeService.delSysMenuTypeById(id);
 			super.operatro_state_code_object.put(super.operator_state_code, "success");
 		}else{
 			super.operatro_state_code_object.put(super.operator_state_code, "fail");
 		}
		log.info(" Operator status#####:"+super.operatro_state_code_object.toString());
		return super.operatro_state_code_object.toString();
	}
	
	/**
	 * @see 数据绑定对象
	 * @param binder
	 * @throws Exception
	 */
	@InitBinder("sysMenuType")      
	public void initBinder1(ServletRequestDataBinder binder) throws Exception{              
		binder.setFieldDefaultPrefix("mt.");     
	}  

}
