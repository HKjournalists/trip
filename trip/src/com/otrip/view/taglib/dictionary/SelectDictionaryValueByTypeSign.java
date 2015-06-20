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
 * Filename:    SelectDictionaryValueByTypeSign.java   
 * Copyright:   Copyright (c)2015  
 * Company:     otrip  
 * @version:    1.0   
 * @since:  JDK 1.7.0_21  
 * Create at:   2015年4月4日 下午7:31:30   
 * Description:  根据字典类型的标示获取字典值
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年4月4日 zhongJc      1.0     1.0 Version   
 */
public class SelectDictionaryValueByTypeSign extends BodyTagSupport{

	private static final long serialVersionUID = 1057157807657635143L;
	
	static Logger log=Logger.getLogger(SelectDictionaryValueByTypeSign.class);
	
	private String selid;
	private String selname;
	private String typesign;
	private String initValue;
	
	
	
	public String getInitValue() {
		return initValue;
	}
	public void setInitValue(String initValue) {
		this.initValue = initValue;
	}
	public String getSelid() {
		return selid;
	}
	public void setSelid(String selid) {
		this.selid = selid;
	}
	public String getSelname() {
		return selname;
	}
	public void setSelname(String selname) {
		this.selname = selname;
	}
	public String getTypesign() {
		return typesign;
	}
	public void setTypesign(String typesign) {
		this.typesign = typesign;
	}
	
	/**
	 * @see 标示不处理标签体，直接调用后面的方法doEndTag
	 */
	@Override
	public int doAfterBody() throws JspException {
		// TODO Auto-generated method stub
		return SKIP_BODY;
	}
	
	
	
	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		setDictionaryValueService();
		final List<SysDictionaryValue> valueList=dictionaryValueService.queryDictionaryValuesByTypeSign(typesign);
		
		StringBuffer outBuf=new StringBuffer("<select name=\""+selname+"\" id=\""+selid+"\" >");
		outBuf.append("<option value='0'>"+SystemUtils.getMessage("taglib.common.select.default.option.pls", null, (HttpServletRequest) pageContext.getRequest())+"</option>");
		if(valueList!=null&&valueList.size()>0){
			for( SysDictionaryValue dv : valueList){
				if(dv!=null&&StringUtils.isNotBlank(dv.getFsId())&&StringUtils.isNotBlank(dv.getFsName())){
					if(this.initValue!=null&&dv.getFsId().equals(this.initValue))
					{
						outBuf.append("<option value=\""+dv.getFsId()+"\" selected=true >"+dv.getFsName()+"</option>");
						continue;
					}
					outBuf.append("<option value=\""+dv.getFsId()+"\">"+dv.getFsName()+"</option>");
				}
			}
		}
		outBuf.append("</select>");
		log.info(" dictionary type select :"+outBuf.toString());
		JspWriter out =null;   
        
        try {
        	out = pageContext.getOut();   
			out.write(outBuf.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.info(" has errpr:"+e.getLocalizedMessage());
		}
		return EVAL_PAGE;
	}
	
	
	
	
	
	/*****************************************************************************
	 * 引入数据字典类型服务类
	 * */
	private	DictionaryValueService dictionaryValueService;
	public void setDictionaryValueService() {
		log.info("注入dictionaryValueService");
        ServletContext servletContext = pageContext.getServletContext();
        WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        dictionaryValueService=(DictionaryValueService) wac.getBean("dictionaryValueService");
	}
	
	

}
