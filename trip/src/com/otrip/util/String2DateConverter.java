package com.otrip.util;

import java.text.ParseException;
import java.util.Date;


import org.springframework.core.convert.converter.Converter;



import org.apache.commons.lang3.time.DateUtils;
import org.springframework.core.convert.converter.Converter;

/**   
 * @Filename:    String2DateConverter.java
 * @Copyright:   Copyright (c)2015  
 * @Company:     otrip 
 * @Author:      zhongJc  
 * @version:     v1.0   
 * @since:  	 JDK 1.7.0_21  
 * @Create at:   2015年4月12日 上午12:01:48  
 * @Description: TODO(用一句话描述该文件做什么)
 *   
 * Modification History:   
 * Date    		 Author       Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年4月12日 	 	 zhongJc      1.0     	  1.0 Version   
 */
public class String2DateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String arg0) {
		try {
			return DateUtils.parseDate(arg0,
					new String[] { "yyyy-MM-dd HH:mm:ss","yyyy-MM-dd" });
		} catch (ParseException e) {
			return null;
		}
	}


}
