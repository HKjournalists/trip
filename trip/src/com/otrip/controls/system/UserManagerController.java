package com.otrip.controls.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.otrip.controls.BaseController;
import com.otrip.domain.DomainUtils;
import com.otrip.domain.system.SysMenuAuth;
import com.otrip.domain.system.SysRole;
import com.otrip.domain.system.SysUser;
import com.otrip.domain.system.SysUserRole;
import com.otrip.service.system.RoleService;
import com.otrip.service.system.UserRoleService;
import com.otrip.service.system.UserService;

/**
 * @see 系统设置用户管理
 * @author zhongJc
 *
 */

@Controller
@RequestMapping(value="/system/user")
public class UserManagerController extends BaseController {

	static Logger log=Logger.getLogger(UserManagerController.class);
	
	private static final String view_manager_user="/system/user/manager_user";
	private static final String view_travel_user="/system/user/travel_user";
	private static final String	view_manager_user_add="/system/user/manager_user_add";
	
	@SuppressWarnings("unused")
	private UserService	userService;
	private RoleService roleService;
	private UserRoleService	userRoleService;

	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@Autowired
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	@Autowired
	public void setUserRoleService(UserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}
	
	/**
	 * @see 进入用户信息列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/manager_user.html")
	public ModelAndView managerUser(HttpServletRequest request,HttpServletResponse response,@ModelAttribute SysUser sysUser) throws Exception{
		ModelAndView mav=new ModelAndView(view_manager_user);
		final List<SysUser> managerUserList=userService.queryManagerUser(sysUser);
		mav.addObject("managerUserList", managerUserList);
		return mav;
	}
	
	/**
	 * @see 旅行用户
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/travel_user.html")
	public ModelAndView travelUser(HttpServletRequest request,HttpServletResponse response,@ModelAttribute SysUser sysUser) throws Exception{
		ModelAndView mav=new ModelAndView(view_travel_user);
		final List<SysUser> travelUserList=userService.queryFrontUser(sysUser);
		mav.addObject("travelUserList", travelUserList);
		return mav;
	}
	
	/**
	 * @see 添加管理用户add
	 * @param request
	 * @param response
	 * @param sysUser
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/manager_user_to_add.html")
	public ModelAndView toAddManagerUser(HttpServletRequest request,HttpServletResponse response,@ModelAttribute SysUser sysUser)throws Exception{
		ModelAndView mav=new ModelAndView(view_manager_user_add);
		final List<SysRole>	optRoles=roleService.findAllSysRoleNoRootRole();
		mav.addObject("optRoles", optRoles);
		return mav;
	}
	
	@SuppressWarnings("static-access")
	@RequestMapping(value="/manager_user_save.html")
	public ModelAndView saveManagerUser(HttpServletRequest request,HttpServletResponse response,@ModelAttribute SysUser sysUser,@RequestParam("roleIds") String roleIds)throws Exception{
		ModelAndView mav=new ModelAndView(view_manager_user_add);
		if(sysUser!=null&&StringUtils.isNotBlank(sysUser.getFsAccount())){
			sysUser.setFsId(DomainUtils.generalUuid());
			sysUser.setFdCreateTime(new Date());
			sysUser.setFdRegisterDate(new Date());
			userService.saveManagerUser(sysUser);
			if(StringUtils.isNotBlank(roleIds)){
				log.info(" role ids:"+roleIds);
				final String[] roleIdArr=StringUtils.split(roleIds, ",");
				final List<SysRole> selRoles=roleService.findSysRolesByIdS(roleIdArr);
				if(selRoles!=null&&selRoles.size()>0){
					final List<SysUserRole> surList=new ArrayList<SysUserRole>();
					SysUserRole sysUserRole=null;
					for(int i=0;i<selRoles.size();i++){
						sysUserRole=new SysUserRole();
						sysUserRole.setFsId(DomainUtils.generalUuid());
						sysUserRole.setSysUser(sysUser);
						sysUserRole.setSysRole(selRoles.get(i));
						surList.add(sysUserRole);
					}
					userRoleService.saveSysUserRoles(surList);
				}
			}
			
		}
		
		mav.addObject(super.operator_state_code, "success");
		return mav;
	}
	
	/**
	 * @see 菜单列表
	 * @param binder
	 */
	@InitBinder("sysUser")      
	public void initBinder(ServletRequestDataBinder binder) {              
		binder.setFieldDefaultPrefix("su.");     
	} 
	
}
