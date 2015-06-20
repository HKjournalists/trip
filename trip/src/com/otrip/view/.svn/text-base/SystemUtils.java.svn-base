package com.otrip.view;   

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**   
 * Filename:    SystemUtils.java   
 * Copyright:   Copyright (c)2015  
 * Company:     otrip  
 * @version:    1.0   
 * @since:  JDK 1.7.0_21  
 * Create at:   2015年3月28日 下午3:17:00   
 * Description:  系统帮助类
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年3月28日 zhongJc      1.0     1.0 Version   
 */
public class SystemUtils {
	
	/**
	 * @see 根据request获取国际化信息
	 * @param key
	 * @param args
	 * @param req
	 * @return
	 */
	public static final String getMessage(final String key,final String [] args,final HttpServletRequest req){
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(req.getSession().getServletContext()); 
		String msg  = context.getMessage(  key , null , req.getLocale() );
		return msg;
	}
	
	/**
	 * @see 根据日期和模板，获取日期字符串
	 * @param pattern
	 * @param d
	 * @return
	 */
	public static final String getTimeFormat(final String pattern,final Date d){
		if(d!=null&&StringUtils.isNotBlank(pattern)){
			final SimpleDateFormat sdf=new SimpleDateFormat(pattern);
			return sdf.format(d);
		}else{
			return "";
		}
	}


}
