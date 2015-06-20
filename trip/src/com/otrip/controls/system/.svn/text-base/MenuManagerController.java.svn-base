package com.otrip.controls.system;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.ztree.utils.NodeMenu;

import com.otrip.controls.BaseController;
import com.otrip.controls.system.vo.MenuVo;
import com.otrip.domain.system.SysMenuAuth;
import com.otrip.domain.system.SysMenuType;
import com.otrip.domain.system.SysResource;
import com.otrip.initdata.datacache.SystemDataCache;
import com.otrip.service.system.MenuAuthService;
import com.otrip.service.system.MenuTypeService;
import com.otrip.service.system.ResourceService;

@Controller
@RequestMapping(value="/system/menu")
public class MenuManagerController extends BaseController {
	
	static Logger log=Logger.getLogger(MenuManagerController.class);
	
	private static final String view_manager="/system/menu/manager";
	private static final String view_menu="/system/menu/menu";
	private static final String view_include_menu="/system/menu/include";
	
	private static final String view_add_child_menu="/system/menu/add_child_menu";
	
	private MenuAuthService 		menuAuthService;
	private MenuTypeService			menuTypeService;
	private ResourceService			resourceService;
	@Autowired
	public void setMenuAuthService(MenuAuthService menuAuthService) {
		this.menuAuthService = menuAuthService;
	}
	@Autowired
	public void setMenuTypeService(MenuTypeService menuTypeService) {
		this.menuTypeService = menuTypeService;
	}
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
	@RequestMapping(value="/manager.html")
	public ModelAndView manager(HttpServletRequest request,HttpServletResponse response,@ModelAttribute SysMenuAuth sysMenuAuth,BindingResult result){
		ModelAndView mav=new ModelAndView(view_manager);
		sysMenuAuth=menuAuthService.loadSysMenuAuthById(SystemDataCache.getMainSystemId());
		mav.addObject("mainMenu", sysMenuAuth);
		return mav;
	}
	
	/**
	 * @see 进入菜单管理树
	 * @param request
	 * @param response
	 * @param otripMenuAuth
	 * @param result
	 * @return
	 */
	@RequestMapping(value="/menu_manager.html")
	public ModelAndView menuManager(HttpServletRequest request,HttpServletResponse response,@ModelAttribute SysMenuAuth sysMenuAuth,BindingResult result){
		ModelAndView mav=new ModelAndView(view_menu);
		return mav;
	} 
	
	/**
	 * @see 进入对应菜单的详细信息以及连接管理页	
	 * @param request
	 * @param response
	 * @param otripMenuAuth
	 * @param result
	 * @return
	 */
	@SuppressWarnings("null")
	@RequestMapping(value="/include_menu.html")
	public ModelAndView includeMenu(HttpServletRequest request,HttpServletResponse response,@ModelAttribute SysMenuAuth sysMenuAuth,@ModelAttribute MenuVo menuVo ,BindingResult result){
		ModelAndView mav=new ModelAndView(view_include_menu);
		final String menuId=sysMenuAuth!=null||StringUtils.isNotBlank(sysMenuAuth.getFsId())?sysMenuAuth.getFsId():SystemDataCache.getMainSystemId();
		log.info(menuId+":menu is id");
		final SysMenuAuth selMenu=menuAuthService.loadSysMenuAuthById(menuId);
		if(selMenu!=null&&selMenu.getSysResource()!=null&&StringUtils.isNotBlank(selMenu.getSysResource().getFsId())){
			final SysResource r=resourceService.findSysResourceById(selMenu.getSysResource().getFsId());
			mav.addObject("cmar",r);
		}	
		if(selMenu!=null&&selMenu.getSysMenuType()!=null&&StringUtils.isNotBlank(selMenu.getSysMenuType().getFsId())){
			final SysMenuType cmat=menuTypeService.loadMenuTypeById(selMenu.getSysMenuType().getFsId());
			mav.addObject("cmat",cmat);
		}
		mav.addObject("cma",selMenu );	
		final List<MenuVo> mvList=menuAuthService.queryMenuIncludeLinkOrButtons(selMenu, menuVo);
		mav.addObject("mvList", mvList);
		mav.addObject("mv", menuVo);
		return mav;
	} 
	
	
	
	/**
	 * @see 获取json数据
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/manager_tree.html",params="json", method = RequestMethod.POST) 
	public void loadMenuTree(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		final List<NodeMenu> listMenu=new ArrayList<NodeMenu>();
		final List<SysMenuAuth> listSysMenu=menuAuthService.loadAllMenu();
		if(listSysMenu!=null&&listSysMenu.size()>0){
			NodeMenu nm=null;
			for(SysMenuAuth ma:listSysMenu ){
				nm=new NodeMenu();
				nm.setId(ma.getFsId());
				nm.setName(ma.getFsName());
				nm.setpId(ma.getFsParentId());
				if(SystemDataCache.getRootSystemParentId().equals(ma.getFsParentId())){
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
	 * @see 新增子菜单
	 * @param request
	 * @param response
	 * @param otripMenuAuth
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/add_child_menu.html")
	public ModelAndView toAddChildMenu(HttpServletRequest request,HttpServletResponse response,@ModelAttribute SysMenuAuth sysMenuAuth,@RequestParam("parentMenuId") String parentMenuId,BindingResult result) throws Exception{
		ModelAndView mav=new ModelAndView(view_add_child_menu);
		final SysMenuAuth parentMenu=menuAuthService.loadSysMenuAuth(parentMenuId);
		mav.addObject("parentMenu",parentMenu);
		mav.addObject("menuTypeList", menuTypeService.findChildMenuType(parentMenu.getSysMenuType().getFsSign()));
		return mav;
	}
	
	/**
	 * @see 保存子菜单
	 * @param request
	 * @param response
	 * @param otripMenuAuth
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	@RequestMapping(value="/save_child_menu.html")
	public ModelAndView saveAddChildMenu(HttpServletRequest request,HttpServletResponse response,@ModelAttribute SysMenuAuth sysMenuAuth,BindingResult result) throws Exception{
		ModelAndView mav=new ModelAndView(view_add_child_menu);
		log.info("#######Add otrip Menu Info:##########");
		if(sysMenuAuth!=null&&StringUtils.isNotBlank(sysMenuAuth.getFsName())&&StringUtils.isNotBlank(sysMenuAuth.getFsParentId())){
			sysMenuAuth.setFdCreateTime(new Date());
			sysMenuAuth=menuAuthService.addSysMenuAuth(sysMenuAuth);
			mav.addObject(super.operator_state_code, "success");
			
		}else{
			mav.addObject(super.operator_state_code, "fail");
		}
		mav.addObject("ma",sysMenuAuth);
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
 			final List<SysMenuAuth> childMenus=menuAuthService.findChildsMenuByParentId(id);
 			if(childMenus!=null&&childMenus.size()>0){
 				super.operatro_state_code_object.put(super.operator_state_code, "fail");
 			}else{
 				final SysMenuAuth currentMenu=menuAuthService.findSysMenuAuthById(id);
 				super.operatro_state_code_object.put("parentId", currentMenu!=null?currentMenu.getFsParentId():"");
 				menuAuthService.deleteSysMenuAuthById(currentMenu!=null?currentMenu.getFsId():"");
 				super.operatro_state_code_object.put(super.operator_state_code, "success");
 			}			
 		}else{
 			super.operatro_state_code_object.put(super.operator_state_code, "fail");
 		}
		log.info(" Operator status#####:"+super.operatro_state_code_object.toString());
		return super.operatro_state_code_object.toString();
	}
	
	@SuppressWarnings("static-access")
	@RequestMapping(value="/deleteLink.html",params="json",method=RequestMethod.POST)
	@ResponseBody
	public String deleteLink(HttpServletRequest request,HttpServletResponse response,@RequestParam("id") String id){		 
		 if(StringUtils.isNotBlank(id)){
 			log.info("delete MenuType id:"+id);
 			final List<SysMenuAuth> childMenus=menuAuthService.findChildsMenuByParentId(id);
 			if(childMenus!=null&&childMenus.size()>0){
 				super.operatro_state_code_object.put(super.operator_state_code, "fail");
 			}else{
 				final SysMenuAuth currentMenu=menuAuthService.findSysMenuAuthById(id);
 				super.operatro_state_code_object.put("parentId", currentMenu!=null?currentMenu.getFsParentId():"");
 				menuAuthService.deleteSysMenuAuthById(currentMenu!=null?currentMenu.getFsId():"");
 				super.operatro_state_code_object.put(super.operator_state_code, "success");
 			}			
 		}else{
 			super.operatro_state_code_object.put(super.operator_state_code, "fail");
 		}
		log.info(" Operator status#####:"+super.operatro_state_code_object.toString());
		return super.operatro_state_code_object.toString();
	}
	
	/**
	 * @see 保存菜单绑定
	 * @param binder
	 */
	@InitBinder("sysMenuAuth")      
	public void initBinder1(ServletRequestDataBinder binder) {              
		binder.setFieldDefaultPrefix("ma.");     
	}  
	
	/**
	 * @see 菜单列表
	 * @param binder
	 */
	@InitBinder("menuVo")      
	public void initBinder2(ServletRequestDataBinder binder) {              
		binder.setFieldDefaultPrefix("mv.");     
	} 
	
}
