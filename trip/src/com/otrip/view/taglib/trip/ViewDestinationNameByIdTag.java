package com.otrip.view.taglib.trip;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.otrip.domain.trip.OtActiDestination;
import com.otrip.domain.trip.OtActiDestinationType;
import com.otrip.service.trip.DestinationService;

/**   
 * @Filename:    ViewDestinationNameByIdTag.java
 * @Copyright:   Copyright (c)2015  
 * @Company:     otrip 
 * @Author:      zhongJc  
 * @version:     v1.0   
 * @since:  	 JDK 1.7.0_21  
 * @Create at:   2015年4月11日 下午10:26:52  
 * @Description: 根据景区ID查看景区名称
 *   
 * Modification History:   
 * Date    		 Author       Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年4月11日 	 	 zhongJc      1.0     	  1.0 Version   
 */
public class ViewDestinationNameByIdTag extends BodyTagSupport {

	private static final long serialVersionUID = 1558631175921763703L;
	
	static Logger log=Logger.getLogger(ViewDestinationNameByIdTag.class);

	private String id;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public int doAfterBody() throws JspException {
		// TODO Auto-generated method stub
		return SKIP_BODY;
	}
	
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		setDestinationService();
		
		JspWriter out =null;   
        
        try {
        	final OtActiDestination destination=destinationService.getOtActiDestinationById(id);
        	out = pageContext.getOut();  
        	if(destination!=null&&StringUtils.isNotBlank(destination.getFsName())){
    			out.write(destination.getFsName());
        	}else{
        		out.write("");
        	}
        	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.info(" has errpr:"+e.getLocalizedMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.info(" has errpr:"+e.getLocalizedMessage());
		}
		return EVAL_PAGE;
	}
	
	/*****************************************************************************
	 * 引入数据字典类型服务类
	 * */
	private	DestinationService destinationService;
	public void setDestinationService() {
		log.info("注入DestinationService");
        ServletContext servletContext = pageContext.getServletContext();
        WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        destinationService=(DestinationService) wac.getBean("destinationService");
	}
}
