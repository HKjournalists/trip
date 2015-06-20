package com.otrip.controls.order;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.otrip.controls.BaseController;
import com.otrip.controls.verify.VerifyLoginController;
import com.otrip.domain.trip.OtActiOrder;
import com.otrip.pojo.OrdeqpVo;
import com.otrip.pojo.OrderInfoVo;
import com.otrip.service.order.OtActiOrderService;
import com.sun.beans.editors.DoubleEditor;
import com.sun.beans.editors.IntegerEditor;
import com.sun.net.httpserver.HttpServer;

/**
 * @see 订单主界面
 * @author zhongJc
 *
 */

@Controller
@RequestMapping(value="/order")
public class OrderMainController extends BaseController {

	static Logger log=Logger.getLogger(OrderMainController.class);
	
	
	private OtActiOrderService oaos;
	
	@Autowired
	public void setOtActiOrderService(OtActiOrderService oaos)
	{
		this.oaos=oaos;
	}
	
	
	private static final String view_order_menu="/order/menu";
	private static final String view_order_default="/order/default";
	private static final String view_list_order="/order/actiOrder/orderInfo";
	private static final String view_list_Analyse="/order/actiOrder/orderAnalyse";
	private static final String view_list_userInfo="/order/actiOrder/userInfo";
	private static final String view_list_userInfoAnalyse="/order/actiOrder/userInfoAnalyse";
	private static final String view_list_AnalyseOrder="/order/actiOrder/orderInfoAnalyse";
	
	/**
	 * @see 订购菜单左边界面进入
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/menu.html")
	public ModelAndView leftMenu(HttpServletRequest request) throws Exception{
		ModelAndView view=new ModelAndView(view_order_menu);
		return view;
	}
	
	/**
	 * @see 右边默认界面
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/default.html")
	public ModelAndView rightDefault(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ModelAndView view=new ModelAndView(view_order_default);
		return view;
	}
	
	@RequestMapping(value="/orderList.html")
	public ModelAndView listOrder(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ModelAndView view=new ModelAndView(view_list_order);
		return view;
	}
	
	
	@RequestMapping(value="/getOrderInfo.html",params="json",method=RequestMethod.POST)
	@ResponseBody
	public String getOrderInfo(HttpServletRequest request,HttpServletResponse response,@RequestParam(value="rows",required=false)String num,@RequestParam(value="page",required=false)String page)
	{
		

			List<OrderInfoVo> list=oaos.listOrders(page, num);
			log.info("page:"+page+"::"+"num: "+num);
			log.info("find orders:"+list.size());
			if(list.size()!=0)
			{
				
				return OrderConstant.ReturnDataGridJSON(list);
				
			}
			return "";
	}
	/*
	@RequestMapping(value="/activity_list.html")
	public ModelAndView listActiOrder(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ModelAndView view=new ModelAndView(view_list_order);
		return view;
	}
	*/
	@RequestMapping(value="/orderAnalyse.html")
	public ModelAndView listorderAnalyseByMount(HttpServletRequest request,HttpServletResponse response)
	{	
		ModelAndView view=new ModelAndView(view_list_AnalyseOrder);
		return view;
	}
	
	@RequestMapping(value="/listUserInfo.html")
	public ModelAndView listUserInfo(HttpServletRequest request,HttpServletResponse response)
	{
		ModelAndView view=new ModelAndView(view_list_userInfo);
		return view;
	}
	
	@RequestMapping(value="/userInfoAnalyse.html")
	public ModelAndView userInfoAnalyse(HttpServletRequest request,HttpServletResponse response)
	{
		ModelAndView  view=new ModelAndView(view_list_userInfoAnalyse);
		return view;
		
	}
	
	@RequestMapping(value="/getOrderAnalyseInitData.html",params="json",method=RequestMethod.POST)
	@ResponseBody
	public String getInitDataOrderAnalyse(HttpServletRequest request,HttpServletResponse response,@RequestParam(value="sid")String sid)
	{
		
		String mothData=OrderConstant.monthStatistic;
		String weekData=OrderConstant.weekStatistic;
		if(StringUtils.isNotBlank(sid))
		{
			if(sid.equals("0"))
			{
				return mothData;
			}
			else
			{
				return weekData;
			}
		}
		return "";
	}
	
	@RequestMapping(value="/getOrderAnalyse.html",params="json",method=RequestMethod.POST)
	@ResponseBody
	public String getStatisAnalyse(HttpServletRequest request,HttpServletResponse response,@RequestParam(value="flag")String flag,@RequestParam(value="sta")String sta)
	{
		
		log.info(flag+"::"+sta);
		List list=this.oaos.getStatisInfo(flag,sta);
		if(list!=null)
			return OrderConstant.ReturnDataGridJSON(list);
		else
			return null;
	}
	
	@RequestMapping(value="/getOrderQuery.html",params="json",method=RequestMethod.POST)
	@ResponseBody
	public String getStatisAnalyse(HttpServletRequest request,HttpServletResponse response,OrdeqpVo od)
	{
	
		try
		{
		List list=this.oaos.getStatisInfo(od);
		if(list!=null)
		{
			log.info(list.size());
			return OrderConstant.ReturnDataGridJSON(list);
		}
		else
			return null;
		}catch(Exception e)
		{
			e.printStackTrace();return null;
		}

	}
	
	
}
