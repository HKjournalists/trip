package com.otrip.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import com.otrip.domain.system.SysResource;
import com.otrip.security.tool.AntUrlPathMatcher;
import com.otrip.security.tool.UrlMatcher;
import com.otrip.service.system.ResourceService;

/**
 * @see 启动时候加载所有资源和地质
 * @author Administrator
 *
 */
public class OtripInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource{
	static Logger log=Logger.getLogger(OtripInvocationSecurityMetadataSource.class);
	
	private ResourceService resourceService;
	private UrlMatcher urlMatcher=new AntUrlPathMatcher();
	private static Map<String,Collection<ConfigAttribute>> resourceMap=null;	
	
	public OtripInvocationSecurityMetadataSource(final ResourceService resourceService) {
		// TODO Auto-generated constructor stub
		//使用注解方式的话，只能在构造函数执行完成后才能获得实例
		this.resourceService=resourceService;
		loadResourceDefine();
	}
	
	/**
	 * @see 在Web服务器启动时，提取系统中的所有权限
	 * 		应当是资源为key， 权限为value。 资源通常为URL， 权限就是那些以ROLE_为前缀的角色。 一个资源
	 */
	public void loadResourceDefine(){
		resourceMap=new HashMap<String, Collection<ConfigAttribute>>();
		
		final List<SysResource> allResource=resourceService.findAllResource();
		if(allResource!=null&&allResource.size()>0){
			int i=0;
			while(i<allResource.size()){
				final SysResource sysResource=allResource.get(i++);
				if(sysResource!=null&&StringUtils.isNotBlank(sysResource.getFsUrl())&&StringUtils.isNotBlank(sysResource.getFsKey())){
					final String url=sysResource.getFsUrl();
					final String auth=sysResource.getFsKey();
					ConfigAttribute ca = new SecurityConfig(auth);
					if (resourceMap.containsKey(url)) {
	                    Collection<ConfigAttribute> value = resourceMap.get(url);
	                    value.add(ca);
	                    resourceMap.put(url, value);
	                } else {
	                    Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
	                    atts.add(ca);
	                    resourceMap.put(url, atts);
	                }
				}				
			}
		}		
	}
	
	/**
	 * @see 根据URL，找到相关的权限配置。
	 * @param object 是一个URL，被用户请求的URL
	 */
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		String url=((FilterInvocation)object).getRequestUrl();
		int firstQuestionMarkIndex = url.indexOf("?");
		if (firstQuestionMarkIndex != -1) {
            url = url.substring(0, firstQuestionMarkIndex);
        }
		Iterator<String> ite=resourceMap.keySet().iterator();
		while(ite.hasNext()){
			String resURL=ite.next();
			if(url.equals(resURL)||urlMatcher.pathMatchesUrl(resURL, url)){
				return resourceMap.get(resURL);
			}
		}
		return null;
	}
	
	@Override
	public boolean supports(Class<?> classzz) {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
