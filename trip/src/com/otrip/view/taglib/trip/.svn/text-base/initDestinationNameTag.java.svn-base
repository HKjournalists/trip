package com.otrip.view.taglib.trip;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.otrip.domain.trip.OtActiDestination;
import com.otrip.service.trip.DestinationService;

public class initDestinationNameTag extends BodyTagSupport {

	
	static Logger log=Logger.getLogger(initDestinationNameTag.class);
	
	private String continentParent;
	private String continentName;
	private String countryParent;
	private String countryName;
	private String provinceParent;
	private String provinceName;
	private String cityParent;
	private String cityName;
	private String scenicParent;
	private String scenicName;
	private String continentChangeName;
	private String countryChangeName;
	private String provinceChangeName;
	private String cityChangeName;
	private String scenicChangeName;
	private String continentInit;
	private String countryInit;
	private String provinceInit;
	private String cityInit;
	private String scenicInit;
	
	
	
	public String getContinentInit() {
		return continentInit;
	}

	public void setContinentInit(String continentInit) {
		this.continentInit = continentInit;
	}

	public String getCountryInit() {
		return countryInit;
	}

	public void setCountryInit(String countryInit) {
		this.countryInit = countryInit;
	}

	public String getProvinceInit() {
		return provinceInit;
	}

	public void setProvinceInit(String provinceInit) {
		this.provinceInit = provinceInit;
	}

	public String getCityInit() {
		return cityInit;
	}

	public void setCityInit(String cityInit) {
		this.cityInit = cityInit;
	}

	public String getScenicInit() {
		return scenicInit;
	}

	public void setScenicInit(String scenicInit) {
		this.scenicInit = scenicInit;
	}

	public String getContinentParent() {
		return continentParent;
	}

	public void setContinentParent(String continentParent) {
		this.continentParent = continentParent;
	}

	public String getContinentName() {
		return continentName;
	}

	public void setContinentName(String continentName) {
		this.continentName = continentName;
	}

	public String getCountryParent() {
		return countryParent;
	}

	public void setCountryParent(String countryParent) {
		this.countryParent = countryParent;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getProvinceParent() {
		return provinceParent;
	}

	public void setProvinceParent(String provinceParent) {
		this.provinceParent = provinceParent;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityParent() {
		return cityParent;
	}

	public void setCityParent(String cityParent) {
		this.cityParent = cityParent;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getScenicParent() {
		return scenicParent;
	}

	public void setScenicParent(String scenicParent) {
		this.scenicParent = scenicParent;
	}

	public String getScenicName() {
		return scenicName;
	}

	public void setScenicName(String scenicName) {
		this.scenicName = scenicName;
	}

	

	public String getContinentChangeName() {
		return continentChangeName;
	}

	public void setContinentChangeName(String continentChangeName) {
		this.continentChangeName = continentChangeName;
	}

	public String getCountryChangeName() {
		return countryChangeName;
	}

	public void setCountryChangeName(String countryChangeName) {
		this.countryChangeName = countryChangeName;
	}

	public String getProvinceChangeName() {
		return provinceChangeName;
	}

	public void setProvinceChangeName(String provinceChangeName) {
		this.provinceChangeName = provinceChangeName;
	}

	public String getCityChangeName() {
		return cityChangeName;
	}

	public void setCityChangeName(String cityChangeName) {
		this.cityChangeName = cityChangeName;
	}

	public String getScenicChangeName() {
		return scenicChangeName;
	}

	public void setScenicChangeName(String scenicChangeName) {
		this.scenicChangeName = scenicChangeName;
	}

	@Override
	public int doAfterBody() throws JspException {
		// TODO Auto-generated method stub
		return this.SKIP_BODY;
	}

	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		setDestinationService();
		
		
		List<OtActiDestination> continentList=null;
		List<OtActiDestination> countryList=null;
		List<OtActiDestination> provinceList=null;
		List<OtActiDestination> scenicList=null;
		List<OtActiDestination> cityList=null;
		
		try {
			continentList = destinationService.findOtActiDestinationsByParentId(this.continentParent);
			countryList=destinationService.findOtActiDestinationsByParentId(this.countryParent);
			if(this.provinceParent!=null)
				provinceList=destinationService.findOtActiDestinationsByParentId(provinceParent);
			if(this.cityParent!=null)
				cityList=destinationService.findOtActiDestinationsByParentId(this.cityParent);
			if(this.scenicParent!=null)
				scenicList=destinationService.findOtActiDestinationsByParentId(this.scenicParent);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		StringBuffer outBuf=new StringBuffer();
		if(continentList!=null&&continentList.size()>0)
		{
			outBuf.append("<select"
					+ " name=\""+this.continentName+"\" "
					+ "id='fsDestinationContinent' onchange=\""+this.continentChangeName+"\" >");
			outBuf.append("<option value='0' >请选择</option>");
			for(int i=0;i<continentList.size();i++)
			{
				if(continentList.get(i).getFsId().equals(this.continentInit))
				{
					outBuf.append("<option value='"+continentList.get(i).getFsId()+"' selected=true > "
							+continentList.get(i).getFsName()
							+ " </option>");
					continue;
				}
				outBuf.append("<option value='"+continentList.get(i).getFsId()+"' > "
						+continentList.get(i).getFsName()
						+ " </option>");
			}
			outBuf.append("</select>");
		}
		outBuf.append("\t\r");
		if(countryList!=null&&countryList.size()>0)
		{
			
			outBuf.append("<select"
					+ " name=\""+this.countryName+"\" "
					+ "id='fsDestinationCountry' onchange=\""+this.countryChangeName+"\" >");
			outBuf.append("<option value='0' >请选择</option>");
			for(int i=0;i<countryList.size();i++)
			{
				if(countryList.get(i).getFsId().equals(this.countryInit))
				{
					outBuf.append("<option value='"+countryList.get(i).getFsId()+"' selected=true > "
							+countryList.get(i).getFsName()
							+ " </option>");continue;
				}
				outBuf.append("<option value='"+countryList.get(i).getFsId()+"' > "
						+countryList.get(i).getFsName()
						+ " </option>");
			}
			outBuf.append("</select>");
		}
		outBuf.append("\t\r");
		if(provinceList!=null&&provinceList.size()>0)
		{
			outBuf.append("<select"
					+ " name=\""+this.provinceName+"\" "
					+ "id='fsDestinationProvince' onchange=\""+this.provinceChangeName+"\" >");
			outBuf.append("<option value='0' >请选择</option>");
			for(int i=0;i<provinceList.size();i++)
			{
				if(provinceList.get(i).getFsId().equals(this.provinceInit))
				{
					outBuf.append("<option value='"+provinceList.get(i).getFsId()+"' selected=true > "
							+provinceList.get(i).getFsName()
							+ " </option>");continue;
				}
				outBuf.append("<option value='"+provinceList.get(i).getFsId()+"' > "
						+provinceList.get(i).getFsName()
						+ " </option>");
			}
			outBuf.append("</select>");
		}
		outBuf.append("\t\r");

		if(cityList!=null&&cityList.size()>0)
		{
			outBuf.append("<select"
					+ " name=\""+this.cityName+"\" "
					+ "id='fsDestinationCity' onchange=\""+this.cityChangeName+"\" >");
			outBuf.append("<option value='0' >请选择</option>");
			for(int i=0;i<cityList.size();i++)
			{
				if(cityList.get(i).getFsId().equals(this.cityInit))
				{
					outBuf.append("<option value='"+cityList.get(i).getFsId()+"' selected=true > "
							+cityList.get(i).getFsName()
							+ " </option>");continue;
				}
				outBuf.append("<option value='"+cityList.get(i).getFsId()+"' > "
						+cityList.get(i).getFsName()
						+ " </option>");
			}
			outBuf.append("</select>");
		}
		outBuf.append("\t\r");
		if(scenicList!=null&&scenicList.size()>0)
		{
			outBuf.append("<select"
					+ " name=\""+this.scenicName+"\" "
					+ "id='fsDestinationScenic' onchange=\""+this.scenicChangeName+"\" >");
			outBuf.append("<option value='0' >请选择</option>");
			for(int i=0;i<scenicList.size();i++)
			{
				if(scenicList.get(i).getFsId().equals(this.scenicInit))
				{
					outBuf.append("<option value='"+scenicList.get(i).getFsId()+"' selected=true > "
							+scenicList.get(i).getFsName()
							+ " </option>");continue;
				}
				outBuf.append("<option value='"+scenicList.get(i).getFsId()+"' > "
						+scenicList.get(i).getFsName()
						+ " </option>");
			}
			outBuf.append("</select>");
		}
		outBuf.append("\t\r");
		log.info(" initDestination select :"+outBuf.toString());
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
