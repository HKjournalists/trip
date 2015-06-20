package com.otrip.initdata;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.otrip.service.initdata.InitSystemDataService;

/**
 * @see 启动时候加载基础数据
 * @author zhongJc
 *
 */
public class InitBaseSystemDatabase implements BeanPostProcessor {

	static Logger log=Logger.getLogger(InitBaseSystemDatabase.class);
	
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		return bean;
	}
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		if(bean instanceof InitSystemDataService) {  
			((InitSystemDataService)bean).initSystemDataCache(); //调用方法加载数据   
		}
		return bean;
	}

	

}
