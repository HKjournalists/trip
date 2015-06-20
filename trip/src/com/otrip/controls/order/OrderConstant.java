package com.otrip.controls.order;

import java.util.List;

import net.sf.json.JSONArray;

public class OrderConstant {

	public static String monthStatistic="{\"row1\":\"\u6708\u8ba2\u5355\u6570\u91cf\",\"row2\":\"\u8ba2\u5355\u72b6\u6001\",\"row3\":\"\u6708\u8ba2\u5355\u603b\u989d\",\"row4\":\"\u6708\u4efd\",\"row5\":\"1\"}";
	public static String weekStatistic="{\"row1\":\"\u5468\u8ba2\u5355\u6570\u91cf\",\"row2\":\"\u8ba2\u5355\u72b6\u6001\",\"row3\":\"\u5468\u8ba2\u5355\u603b\u989d\",\"row4\":\"\u5468\",\"row5\":\"0\"}";
	
	
	public static String ReturnDataGridJSON(List list)
	{
		JSONArray js=JSONArray.fromObject(list);
		String json="{\"total\":\""+list.size()+"\",\"rows\":"+js+" }";
		return json;
	}
}
