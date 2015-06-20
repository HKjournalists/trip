package com.otrip.controls.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
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
import com.otrip.domain.DomainUtils;
import com.otrip.domain.system.SysMenuAuth;
import com.otrip.domain.system.SysMenuType;
import com.otrip.domain.system.SysResource;
import com.otrip.domain.system.SysRole;
import com.otrip.domain.system.SysRoleAuth;
import com.otrip.service.system.MenuAuthService;
import com.otrip.service.system.MenuTypeService;
import com.otrip.service.system.RoleAuthService;
import com.otrip.service.system.RoleService;

/**
 * @see 角色管理
 * @author zhongJc
 *
 */
@Controller
@RequestMapping(value="/system/role")
public class RoleController extends BaseController {

	static Logger log=Logger.getLogger(RoleController.class);
	
	private static final String view_manager="/system/role/manager";
	private static final String view_add="/system/role/add";
	
	private RoleService	roleService;
	private MenuTypeService menuTypeService;
	private MenuAuthService	menuAuthService;
	private RoleAuthService	roleAuthService;
	@Autowired
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	@Autowired
	public void setMenuTypeService(MenuTypeService menuTypeService) {
		this.menuTypeService = menuTypeService;
	}
	@Autowired
	public void setMenuAuthService(MenuAuthService menuAuthService) {
		this.menuAuthService = menuAuthService;
	}
	@Autowired
	public void setRoleAuthService(RoleAuthService roleAuthService) {
		this.roleAuthService = roleAuthService;
	}
	
	/**
	 * @see 请求地址配置列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/manager.html")
	public ModelAndView queryRoleManager(HttpServletRequest request,HttpServletResponse response,@ModelAttribute SysRole sysRole,BindingResult result){
		ModelAndView mav=new ModelAndView(view_manager);
		mav.addObject("roleList", roleService.querySysRole(sysRole));
		mav.addObject("r", sysRole);
		return mav;
	}
	
	/**
	 * @see 新增角色
	 * @param request
	 * @param response
	 * @param sysRole
	 * @param result
	 * @return
	 */
	@RequestMapping(value="/toAdd.html")
	public ModelAndView toAddRole(HttpServletRequest request,HttpServletResponse response,@ModelAttribute SysRole sysRole,BindingResult result){
		ModelAndView mav=new ModelAndView(view_add);
		if(sysRole!=null&&StringUtils.isNotBlank(sysRole.getFsId())){
			final SysRole parentRole=roleService.loadSysRole(sysRole.getFsId());
			mav.addObject("p", parentRole);
		}
		
		final List<SysMenuType> menuTypeList=menuTypeService.findAllMenuType();
		mav.addObject("menuTypeList", menuTypeList);
		
		return mav;
	}
	
	/**
	 * @see 保存角色
	 * @param request
	 * @param response
	 * @param sysRole
	 * @param authId
	 * @param result
	 * @return
	 */
	@SuppressWarnings("static-access")
	@RequestMapping(value="/save.html")
	public ModelAndView saveRole(HttpServletRequest request,HttpServletResponse response,@ModelAttribute SysRole sysRole,@RequestParam("authId") String authId,BindingResult result){
		ModelAndView mav=new ModelAndView(view_add);
		if(sysRole!=null&&StringUtils.isNotBlank(sysRole.getFsName())){
			sysRole.setFdCreateTime(new Date());
			sysRole=roleService.addRole(sysRole);
			if(StringUtils.isNotBlank(authId)&&authId.length()>0&&StringUtils.isNotBlank(sysRole.getFsId())){
				log.info(" menu ids:"+authId);
				final String[] menuIdArr=StringUtils.split(authId, ",");
				final List<SysRoleAuth> mraList=new ArrayList<SysRoleAuth>();
				final List<SysMenuAuth> mas=menuAuthService.findSysMenuAuthByIdS(menuIdArr);
				if(mas!=null&&mas.size()>0){
					for(int i=0;i<mas.size();i++){
						final SysRoleAuth ra=new SysRoleAuth();
						ra.setFsId(DomainUtils.generalUuid());
						ra.setSysRole(sysRole);
						ra.setSysMenuAuth(mas.get(i));
						mraList.add(ra);
					}
				}
				roleAuthService.addRoleAuths(mraList);
			}
		}
		mav.addObject(super.operator_state_code, "success");
		return mav;
	}
	
	/**
	 * @see 删除角色，拥有子角色的不能删除，如果能够删除则需要先删除匹配的角色权限关系
	 * @param request
	 * @param response
	 * @param roleId
	 * @return
	 */
	@SuppressWarnings("static-access")
	@RequestMapping(value="/delete.html",params="json",method=RequestMethod.POST)
	@ResponseBody
	public String deletRole(HttpServletRequest request,HttpServletResponse response,@RequestParam("roleId") String roleId){
		 if(StringUtils.isNotBlank(roleId)){
			 final List<SysRole> childRoles=roleService.findChildRoleByParentRoleId(roleId);
			 if(childRoles!=null&&childRoles.size()>0){
				 super.operatro_state_code_object.put(super.operator_state_code, "fail");
			 }else{
				 final SysRole role=roleService.loadSysRole(roleId);
				 roleAuthService.deleteRoleAuthsBySysRole(role);
				 roleService.deleteRole(roleId);
				 super.operatro_state_code_object.put(super.operator_state_code, "success");
			 }
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
	@InitBinder("sysRole")      
	public void initBinder1(ServletRequestDataBinder binder) throws Exception{              
		binder.setFieldDefaultPrefix("r.");     
	}  
}
