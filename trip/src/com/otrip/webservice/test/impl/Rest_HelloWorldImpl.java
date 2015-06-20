package com.otrip.webservice.test.impl;   

import org.springframework.stereotype.Service;

import com.otrip.webservice.test.Rest_HelloWorld;

/**   
 * Filename:    Rest_HelloWorldImpl.java   
 * Copyright:   Copyright (c)2015  
 * Company:     otrip  
 * @version:    1.0   
 * @since:  JDK 1.7.0_21  
 * Create at:   2015年3月22日 下午12:11:22   
 * Description:  
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年3月22日 zhongJc      1.0     1.0 Version   
 */
@Service("rest_HelloWorldImpl")
public class Rest_HelloWorldImpl implements Rest_HelloWorld {

	
	public String say(String name) {
		// TODO Auto-generated method stub
		System.out.println("rest 接口");
		return name+"，您好！";   
	}

}
