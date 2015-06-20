package com.otrip.security;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.otrip.domain.system.SysLoginHistory;
import com.otrip.domain.system.SysUser;
import com.otrip.exception.MethodErrorException;
import com.otrip.exception.ValidateCodeException;
import com.otrip.service.system.AccessService;
import com.otrip.util.Common;
/**
 * @see 开始权限认证
 * @author Administrator
 */

public class UserAuthenticationExtendFilter extends UsernamePasswordAuthenticationFilter {

	private AccessService accessService;
	@Autowired
	public void setAccessService(AccessService accessService) {
		this.accessService = accessService;
	}
	
	// 验证码字段  
    private String validateCodeParameter = "validateCode";  
    // 是否开启验证码功能  
    private boolean openValidateCode = false;  
    @Override  
    public Authentication attemptAuthentication(HttpServletRequest request,HttpServletResponse response) throws AuthenticationException {  
        if (!"POST".equals(request.getMethod()))  
            throw new MethodErrorException("不支持非POST方式的请求!");  
        String username = obtainUsername(request).trim();  
        String password = obtainPassword(request).trim();    
        if (Common.isEmpty(username) || Common.isEmpty(password)) {
			BadCredentialsException exception = new BadCredentialsException("用户名或密码不能为空！");// 在界面输出自定义的信息！！
			throw exception;
		}
        
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);  
        setDetails(request, authRequest);  
        
        final SysUser sysUser=accessService.findUserByAccount(username);
        if (sysUser == null || !sysUser.getFsPassword().equals(password)) {
			BadCredentialsException exception = new BadCredentialsException("用户名或密码不匹配！");// 在界面输出自定义的信息！！
			throw exception;
		}
        
        request.getSession().setAttribute(LoginUserHelper.session_login_user_key, sysUser);
        
        SysLoginHistory userLoginLog=null;
        if(sysUser!=null&&StringUtils.isNotBlank(sysUser.getFsId())){
        	userLoginLog=new SysLoginHistory();
        	userLoginLog.setFsIp(Common.toIpAddr(request));
        	userLoginLog.setFdLoginTime(new Date());
        	userLoginLog.setSysUser(sysUser);
        	accessService.updateOldLoginHistoryTimeIsNull(sysUser.getFsId());
        	userLoginLog=accessService.addLoginHistory(userLoginLog);
        	request.getSession().setAttribute(LoginUserHelper.LOGIN_CURRENT_USER_HISTORY, userLoginLog);
        }
        if(userLoginLog==null||(!StringUtils.isNotBlank(userLoginLog.getFsId()))){
        	BadCredentialsException exception = new BadCredentialsException("用户名或密码不匹配！");// 在界面输出自定义的信息！！
			throw exception;
        }
        
        
        // 运行UserDetailsService的loadUserByUsername 再次封装Authentication  
        return this.getAuthenticationManager().authenticate(authRequest);  
    }  
  
    public String obtainValidateCodeParameter(HttpServletRequest request) {  
        Object obj = request.getParameter(getValidateCodeParameter());  
        return null == obj ? "" : obj.toString().trim();  
    }  
  
    @Override  
    protected String obtainUsername(HttpServletRequest request) {  
        Object obj = request.getParameter(getUsernameParameter());  
        return null == obj ? "" : obj.toString().trim();  
    }  
  
    @Override  
    protected String obtainPassword(HttpServletRequest request) {  
        Object obj = request.getParameter(getPasswordParameter());  
        return null == obj ? "" : obj.toString().trim();  
    }  
  
    public String getValidateCodeParameter() {  
        return validateCodeParameter;  
    }  
  
    public void setValidateCodeParameter(String validateCodeParameter) {  
        this.validateCodeParameter = validateCodeParameter;  
    }  
  
    public boolean isOpenValidateCode() {  
        return openValidateCode;  
    }  
  
    public void setOpenValidateCode(boolean openValidateCode) {  
        this.openValidateCode = openValidateCode;  
    }  
}
