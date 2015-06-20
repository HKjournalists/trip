package com.otrip.webservice.util;

import java.util.Map;

public class ResultJsonUtil {

	
	
	/**
	 * values里面放的必须是JSON对象
	 * @param map
	 * @return
	 */
	public static String returnJSON(String[] keys,String[] values,String errCode,String msg)
	{
		StringBuffer sb=new StringBuffer();
		sb.append("{"
					+ "\"err_code\" :"+" \""+errCode+"\","
					+ "\"msg\" :"+" \""+msg+"\","
					+ "\"data\" :"+getDataJSON(keys,values)+
				"}");
		
		return sb.toString();
	}
	
	private static String getDataJSON(String[] keys,String[] values)
	{
		StringBuffer sbu=new StringBuffer();
		for(int i=0;i<keys.length;i++)
		{
			sbu.append("\""+keys[i]+"\" :"+values[i]+",");
		}
		return "{"+sbu.substring(0,sbu.lastIndexOf(","))+"}";
		
	}
	
	public static String returnErrorJson(String errcode,String msg,String flag)
	{
		StringBuffer sb=new StringBuffer();
		sb.append("{"
					+ "\"err_code\" :"+"\" "+errcode+"\" ,"
					+ "\"msg\" :"+"\""+msg+"\" ,"
					+ "\"flag\" :"+"\""+flag+"\""
					+ "}");
		return sb.toString();
	}
}
