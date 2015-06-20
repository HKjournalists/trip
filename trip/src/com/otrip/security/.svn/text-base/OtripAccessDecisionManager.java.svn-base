package com.otrip.security;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

/**
 * @see 主要进行权限检查,是否拥有权限
 * 		AffirmativeBased：只要有一个投票器通过即审核通过
 *		ConsensusBased：只有当赞成票>反对票时 审核才会通过
 *		UnanimousBased：只要有一个投票器反对，审核就不通过 
 * @author Administrator
 *
 */
@SuppressWarnings("deprecation")
public class OtripAccessDecisionManager extends AffirmativeBased implements AccessDecisionManager{
	
	private static final Logger logger = Logger.getLogger(OtripAccessDecisionManager.class);  
	@Override
	public void decide(Authentication authentication, Object object,Collection<ConfigAttribute> configAttributes) throws AccessDeniedException,
			InsufficientAuthenticationException {
		// TODO Auto-generated method stub
		
		if (logger.isDebugEnabled()) {  
			logger.debug("decide(Authentication, Object, Collection<ConfigAttribute>) - start"); //$NON-NLS-1$  
		}  
		if(configAttributes==null){
			if (logger.isDebugEnabled()) {  
                logger.debug("decide(Authentication, Object, Collection<ConfigAttribute>) - end"); //$NON-NLS-1$  
            }  
			return ;
		}
		
		if (logger.isDebugEnabled()){  
            logger.debug("正在访问的url是："+object.toString());  
        }  
		
		Iterator<ConfigAttribute> ite=configAttributes.iterator();
		while (ite.hasNext()) {
			ConfigAttribute ca=ite.next();
			logger.debug("NeedAuth is："+ca.getAttribute());  
			//访问所请求资源所需要的权限 
			String needAuth=((SecurityConfig)ca).getAttribute();
			//ga 为用户所被赋予的权限。 needRole 为访问相应的资源应该具有的权限。
			for(GrantedAuthority ga:authentication.getAuthorities()){
				logger.debug("\t授权信息是："+ga.getAuthority());  
				if(needAuth.endsWith(ga.getAuthority())){
					if (logger.isDebugEnabled()) {  
                        logger.debug("判断到，needAuth 是"+needAuth+",用户的权限是:"+ga.getAuthority()+"，授权数据相匹配");  
                        logger.debug("decide(Authentication, Object, Collection<ConfigAttribute>) - end"); //$NON-NLS-1$  
                    }  
					return ;
				}
			}
		}
		throw new AccessDeniedException("没有访问权限！");
	}

	@Override
	public boolean supports(ConfigAttribute attribute) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return true;
	}

}
