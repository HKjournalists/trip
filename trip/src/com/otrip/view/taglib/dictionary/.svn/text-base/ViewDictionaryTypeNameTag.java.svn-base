package com.otrip.view.taglib.dictionary;   

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.otrip.domain.system.SysDictionaryType;
import com.otrip.domain.system.SysDictionaryValue;
import com.otrip.service.system.DictionaryTypeService;
import com.otrip.service.system.DictionaryValueService;
import com.otrip.view.SystemUtils;

/**   
 * Filename:    ViewDictionaryNameTag.java   
 * Copyright:   Copyright (c)2015  
 * Company:     otrip  
 * @version:    1.0   
 * @since:  JDK 1.7.0_21  
 * Create at:   2015年4月8日 下午10:42:57   
 * Description:  显示字典名称
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年4月8日 zhongJc      1.0     1.0 Version   
 */
public class ViewDictionaryTypeNameTag extends BodyTagSupport {

	private static final long serialVersionUID = 1735547281360518499L;
	
	static Logger log=Logger.getLogger(ViewDictionaryNameTag.class);


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
		setDictionaryTypeService();
		
		JspWriter out =null;   
        
        try {
        	final SysDictionaryType type=dictionaryTypeService.loadSysDictionaryTypeById(id);
        	out = pageContext.getOut();  
        	if(type!=null&&StringUtils.isNotBlank(type.getFsName())){
    			out.write(type.getFsName());
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
	private	DictionaryTypeService dictionaryTypeService;
	public void setDictionaryTypeService() {
		log.info("注入dictionaryTypeService");
        ServletContext servletContext = pageContext.getServletContext();
        WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        dictionaryTypeService=(DictionaryTypeService) wac.getBean("dictionaryTypeService");
	}
}
