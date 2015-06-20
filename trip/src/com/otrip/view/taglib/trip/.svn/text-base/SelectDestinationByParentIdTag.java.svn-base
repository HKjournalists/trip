package com.otrip.view.taglib.trip;   

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

import com.otrip.domain.trip.OtActiDestination;
import com.otrip.domain.trip.OtActiDestinationType;
import com.otrip.service.trip.DestinationService;
import com.otrip.service.trip.DestinationTypeService;
import com.otrip.view.SystemUtils;

/**   
 * Filename:    SelectDestinationByParentIdTag.java   
 * Copyright:   Copyright (c)2015  
 * Company:     otrip  
 * @version:    1.0   
 * @since:  JDK 1.7.0_21  
 * Create at:   2015年4月5日 下午6:21:45   
 * Description:  根据父亲ID获取景区
 *   
 * Modification History:   
 * Date    Author      Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年4月5日 zhongJc      1.0     1.0 Version   
 */
public class SelectDestinationByParentIdTag extends BodyTagSupport{

private static final long serialVersionUID = -2562625327668611813L;
	
	static Logger log=Logger.getLogger(SelectDestinationByParentIdTag.class);
	
	private String selid;
	private String selname;
	private String parentid;
	private String onchangename;

	

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

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String getOnchangename() {
		return onchangename;
	}

	public void setOnchangename(String onchangename) {
		this.onchangename = onchangename;
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
		setDestinationService();
		List<OtActiDestination> destinationList=null;
		try {
			destinationList = destinationService.findOtActiDestinationsByParentId(parentid);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		StringBuffer outBuf=new StringBuffer();
		if(StringUtils.isNotBlank(onchangename)){
			outBuf.append("<select name=\""+selname+"\" id=\""+selid+"\" onChange=\"javascript:"+onchangename+"\" >");
		}else{
			outBuf.append("<select name=\""+selname+"\" id=\""+selid+"\" >");
		}
	
		
		outBuf.append("<option value='0'>"+SystemUtils.getMessage("taglib.common.select.default.option.pls", null, (HttpServletRequest) pageContext.getRequest())+"</option>");
		if(destinationList!=null&&destinationList.size()>0){
			for( OtActiDestination d : destinationList){
				if(d!=null&&StringUtils.isNotBlank(d.getFsId())&&StringUtils.isNotBlank(d.getFsName())){
					outBuf.append("<option value=\""+d.getFsId()+"\" id=\""+d.getFsId()+"\" >"+d.getFsName()+"</option>");
				}
			}
		}
		outBuf.append("</select>");
		log.info(" OtActiDestination select :"+outBuf.toString());
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
	private	DestinationService destinationService;
	public void setDestinationService() {
		log.info("注入DestinationService");
        ServletContext servletContext = pageContext.getServletContext();
        WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        destinationService=(DestinationService) wac.getBean("destinationService");
	}

	
}
