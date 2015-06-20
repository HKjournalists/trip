package com.otrip.dao.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Test;

public class ConvertDataUtil {
	
	static Logger log=Logger.getLogger(ConvertDataUtil.class);
	public static int StringToInt(String num)
	{
		try
		{
			return Integer.valueOf(num);
		}
		catch(Exception e)
		{
			log.error("Convert String to Int error"+e.getMessage());
			return 0;
		}
	}
	
	
	public static String formatDate(Date date)
	{
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(date);
		
	}
	
	public static Date parseStringDate(String str,String format)
	{
		SimpleDateFormat df=new SimpleDateFormat(format);
		Date da=null;
		try {
			da=df.parse(str);
			
		} catch (ParseException e) {
			log.error("format date error "+str+":"+e.getMessage());
			return null;
		}
		return da;
	}
	
	public static BigDecimal StringToBigDecimal(String str)
	{
		try
		{
			return BigDecimal.valueOf(Double.valueOf(str));
		}
		catch(Exception e)
		{
			log.error("Convert String to Int error"+e.getMessage());
			return BigDecimal.ZERO;
		}
	}
	

	public static String getNow()
	{
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal=Calendar.getInstance();
		return df.format(cal.getTime());
	}
	
	
	/**
	 * 对时间字符串进行比较，如果不相同则返回true
	 * @param strdate1
	 * @param strdate2
	 * @return
	 */
	public static boolean differentFromDate(String strdate1,String strdate2)
	{
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date1=df.parse(strdate1);
			Date date2=df.parse(strdate2);
			return !date1.equals(date2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean differentFromDate(Date date1,String strDate2)
	{
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date2=df.parse(strDate2);
			return !date1.equals(date2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static String doString(String str)
	{
		StringBuffer sb=new StringBuffer();
		sb.append("\\u");
		for(int i=0;i<str.toCharArray().length;i++)
		{
			String hexStr=Integer.toHexString((int)str.toCharArray()[i]);
			sb.append(hexStr);
			sb.append("\\u");
		}
		sb.delete(sb.length()-2,sb.length());
		return sb.toString();
	}
	
	public static void main(String[] args)
	{
		doString("1.rwet214");
	}
}
