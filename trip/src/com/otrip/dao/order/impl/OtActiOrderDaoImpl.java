package com.otrip.dao.order.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.otrip.dao.GenericHibernateDao;
import com.otrip.dao.order.OtActiOrderDao;
import com.otrip.dao.util.ConvertDataUtil;
import com.otrip.domain.DomainUtils;
import com.otrip.domain.trip.OtActiInfo;
import com.otrip.domain.trip.OtActiOrder;
import com.otrip.pojo.OrdeqpVo;
import com.otrip.pojo.OrderAnalyseVo;
import com.otrip.pojo.OrderInfoVo;


@Component("otActiOrderDao")
public class OtActiOrderDaoImpl extends GenericHibernateDao<OtActiOrder, String> implements OtActiOrderDao{

	Logger log=Logger.getLogger(OtActiOrderDaoImpl.class);
	@Override
	public List findOrders(String pageNo,String number) {
		String hql="from OtActiOrder o where 1=1 and o.fsFlag=0";
		int page=ConvertDataUtil.StringToInt(pageNo);
		int num=ConvertDataUtil.StringToInt(number);
		int start=page*num;
		List list= super.findLimitNum(hql, num, start);
		if(list.size()!=0)
		{
			List returnList =new ArrayList();
			for(int i=0;i<list.size();i++)
			{
				returnList.add(this.getOrderInfoVo((OtActiOrder)list.get(i)));
			}
			return returnList;
		}
		else
		{
			return null;
		}
	}

	/**
	 * 查询订单
	 * @param oao
	 * @return
	 */
	private OrderInfoVo getOrderInfoVo(OtActiOrder oao)
	{
	
		OrderInfoVo oiv=new OrderInfoVo();
		oiv.setOrderCreateTime(DateFormatUtils.format(oao.getFdCreateTime(), "yyyy-MM-dd HH:mm:ss"));
		oiv.setOrderId(oao.getFsId());
		oiv.setOrderMoney(oao.getFnPayMoney()+"");
		oiv.setOrderPrice(oao.getFnOrderMoney()+"");
		oiv.setOrderRate("0");
		oiv.setActiNo(oao.getOtActiInfo().getFsNo());
		if(oao.getFsStatus()==0)
			oiv.setOrderState("未付款");
		else
			oiv.setOrderState("已付款");
		oiv.setPepoleNum((oao.getFnTravelAdultNum()+oao.getFnTravelChildrenNum())+"");
		oiv.setSupplyNo("no");
		return oiv;
	}
	
	@Override
	public List getStatisInfo(String flag,String sta)
	{
		if(flag.equals("1"))//flag==1按月统计
		{
			return this.getMonthInfo(sta);
		}
		else
		{
			return this.getWeekInfo(sta);
		}
	}
	
	/**
	 * 按周统计
	 * @return
	 */
	private List getWeekInfo(String sta)
	{
		List returnList=new ArrayList();
		if(sta.equals("0"))
		{
			List wlist=getWeekStatistic(0);//未付款
			if(wlist.size()!=0)
			{
				for(int i=0;i<wlist.size();i++)
				{
					Map map=(Map)wlist.get(i);
					OrderAnalyseVo oalv=getOrderAnalyseVo(map,"未付款");
					returnList.add(oalv);
				}
			}
			List ylist=getWeekStatistic(1);
			if(ylist.size()!=0)
			{
				for(int i=0;i<ylist.size();i++)
				{
					Map map=(Map) ylist.get(i);
					OrderAnalyseVo oalv=getOrderAnalyseVo(map,"已付款");
					returnList.add(oalv);
				}
			}
		}
		if(sta.equals("1"))
		{
			List ylist=getWeekStatistic(1);
			if(ylist.size()!=0)
			{
				for(int i=0;i<ylist.size();i++)
				{
					Map map=(Map) ylist.get(i);
					OrderAnalyseVo oalv=getOrderAnalyseVo(map,"已付款");
					returnList.add(oalv);
				}
			}
		}
		if(sta.equals("2"))
		{
			List wlist=getWeekStatistic(0);//未付款
			if(wlist.size()!=0)
			{
				for(int i=0;i<wlist.size();i++)
				{
					Map map=(Map)wlist.get(i);
					OrderAnalyseVo oalv=getOrderAnalyseVo(map,"未付款");
					returnList.add(oalv);
				}
			}
		}
		return returnList;
		
	}
	
	private List getMonthInfo(String sta)
	{
		List returnList=new ArrayList();
		if(sta.equals("0"))
		{
			List wlist=getMonthStatistic(0);
			if(wlist.size()!=0)
			{
				for(int i=0;i<wlist.size();i++)
				{
				Map map=(Map) wlist.get(i);
				OrderAnalyseVo oalv=getOrderAnalyseVo(map,"未付款");
				returnList.add(oalv);
				}
			}
			List ylist=getMonthStatistic(1);
			if(ylist.size()!=0)
			{
				for(int i=0;i<ylist.size();i++)
				{
					Map map=(Map)ylist.get(i);
					OrderAnalyseVo oalv=getOrderAnalyseVo(map,"已付款");
					returnList.add(oalv);
				}
			}
		}
		if(sta.equals("1"))
		{
			List ylist=getMonthStatistic(1);
			if(ylist.size()!=0)
			{
				for(int i=0;i<ylist.size();i++)
				{
					Map map=(Map)ylist.get(i);
					OrderAnalyseVo oalv=getOrderAnalyseVo(map,"已付款");
					returnList.add(oalv);
				}
			}
		}
		if(sta.equals("2"))
		{
			List wlist=getMonthStatistic(0);
			if(wlist.size()!=0)
			{
				for(int i=0;i<wlist.size();i++)
				{
				Map map=(Map) wlist.get(i);
				OrderAnalyseVo oalv=getOrderAnalyseVo(map,"未付款");
				returnList.add(oalv);
				}
			}
		}
		return returnList;
	}
	
	
	
	
	
	
	
	
	private OrderAnalyseVo getOrderAnalyseVo(Map map,String state)
	{
		OrderAnalyseVo oalv=new OrderAnalyseVo();
		oalv.setNo(map.get("num")+"");
		oalv.setCount(map.get("counts")+"");
		oalv.setSum(map.get("pay")+"");
		oalv.setStates(state);
		return oalv;
	}
	
	
	
	private List getWeekStatistic(int state)
	{
		String sql="select sum(fn_pay_money) as pay,count(fs_id) as counts,week(fd_order_time,1) as num from ot_acti_order where fs_status="+state+" group by num order by num asc";
		List list=super.findBySQL(sql);
		return list;
	}
	
	private List getMonthStatistic(int state)
	{
		String sql="select sum(fn_pay_money) as pay,count(fs_id) as counts,month(fd_order_time) as num from ot_acti_order where fs_status="+state+" group by num order by num asc";
		List list=super.findBySQL(sql);
		return list;
	}
	
	public List getOrderStatistic(OrdeqpVo od)
	{
		StringBuffer sb=null;
		String state=null;
		
		if(od.getState().equals("0"))
			state=" 1=1 ";
		if(od.getState().equals("1"))
			state=" fs_status=1 ";
		if(od.getState().equals("2"))
			state=" fs_status=0 ";
		if(od.getFlag().equals("0"))
			sb=new StringBuffer("select a.pay,a.counts,a.num ,a.fs_status from (select fs_status,sum(fn_pay_money) as pay,count(fs_id) as counts,month(fd_order_time) as num from ot_acti_order where "+state+" group by num) a where 1=1");
		else
			sb=new StringBuffer("select a.pay,a.counts,a.num,a.fs_status from (select fs_status,sum(fn_pay_money) as pay,count(fs_id) as counts,week(fd_order_time,1) as num from ot_acti_order where "+state+" group by num) a where 1=1");
		if(od.getMaxDate()>0)
			sb.append(" and num <="+od.getMaxDate());
		if(od.getMinDate()>0)
			sb.append(" and num >="+od.getMinDate());
		if(od.getMaxNum()>0)
			sb.append(" and counts <="+od.getMaxNum());
		if(od.getMinNum()>0)
			sb.append(" and counts >="+od.getMinNum());
		if(od.getMaxPrice()>0.0)
			sb.append(" and pay <="+od.getMaxPrice());
		if(od.getMinPrice()>0.0)
			sb.append(" and pay >="+od.getMinPrice());
		sb.append(" group by num order by num asc");
		log.info(sb.toString());
		List list=super.findBySQL(sb.toString());
		
		List returnList= new ArrayList();
		if(list.size()!=0)
		{
			for(int i=0;i<list.size();i++)
			{
				Map map=(Map)list.get(i);
				returnList.add(this.getOrderAnalyseVo(map));
			}
			return returnList;
		}
		else
			return null;
	}
	
	private OrderAnalyseVo getOrderAnalyseVo(Map map)
	{
		OrderAnalyseVo oalv=new OrderAnalyseVo();
		oalv.setNo(map.get("num")+"");
		oalv.setCount(map.get("counts")+"");
		oalv.setSum(map.get("pay")+"");
		String flag=map.get("fs_status")+"";
		if(flag.equals("0"))
			oalv.setStates("未付款");
		else
			oalv.setStates("已付款");
		return oalv;
	}
}
