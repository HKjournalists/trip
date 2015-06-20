package com.otrip.security.tool;

import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

public class AntUrlPathMatcher implements UrlMatcher {

	private boolean requiresLowerCaseUrl;
	private PathMatcher pathMatcher;
	
	public AntUrlPathMatcher(){
		this(true);
	}
	
	public AntUrlPathMatcher(boolean requiresLowerCaseUrl){
		this.requiresLowerCaseUrl=true;
		this.pathMatcher=new AntPathMatcher();
		this.requiresLowerCaseUrl=requiresLowerCaseUrl;
	}
	
	@Override
	public Object compile(String path) {
		// TODO Auto-generated method stub
		if(this.requiresLowerCaseUrl){
			return path.toLowerCase();
		}
		return path;
	}

	public void setRequiresLowerCaseUrl(boolean requiresLowerCaseUrl) {
		this.requiresLowerCaseUrl = requiresLowerCaseUrl;
	}
	
	@Override
	public boolean pathMatchesUrl(Object path, String url) {
		// TODO Auto-generated method stub
		if("/**".equals(path)||"**".equals(path)){
			return true;
		}
		return this.pathMatcher.match((String)path, url);
	}

	@Override
	public String getUniversalMatchPattern() {
		// TODO Auto-generated method stub
		return "/**";
	}

	@Override
	public boolean requiresLowerCaseUrl() {
		// TODO Auto-generated method stub
		return this.requiresLowerCaseUrl;
	}

	@Override
	public String toString() {
		return super.getClass().getName()+" [requiresLowerCaseUrl="
				+ requiresLowerCaseUrl + "]";
	}
}
