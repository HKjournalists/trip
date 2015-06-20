package com.otrip.dao.ws.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.LockMode;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Component;

import com.otrip.dao.GenericHibernateDao;
import com.otrip.dao.ws.WsServiceClientDao;
import com.otrip.domain.ws.WsServiceClient;

/**
 * @see 服务客户端配置
 * @author zhongJc
 *
 */
@Component(value="wsServiceClientDao")
public class WsServiceClientDaoImpl extends GenericHibernateDao<WsServiceClient, String> implements WsServiceClientDao {

	static Logger log=Logger.getLogger(WsServiceClientDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	public List<WsServiceClient> findWsServiceClientsByAccountAndPassword(final String clientAccount,final String clientPassword) throws Exception{
		if(StringUtils.isNotBlank(clientAccount)&&StringUtils.isNotBlank(clientPassword)){
			StringBuffer sbQueryHql=new StringBuffer( " select wsc from WsServiceClient wsc where 1=1 and wsc.fsClientAccount='"+clientAccount+"' ");
			sbQueryHql.append(" and wsc.fsClientPassword='"+clientPassword+"' ");
			return super.find(sbQueryHql.toString());
		}else{
			return null;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<WsServiceClient> queryWsServiceClients(final WsServiceClient wsServiceClient)throws Exception{
		StringBuffer queryHql=new StringBuffer(" select sc from WsServiceClient  sc where 1=1 ");
		if(wsServiceClient!=null){
			if(StringUtils.isNotBlank(wsServiceClient.getFsClientAccount())){
				queryHql.append(" and sc.fsClientAccount like '%"+wsServiceClient.getFsClientAccount()+"%' ");
			}
			if(StringUtils.isNotBlank(wsServiceClient.getFsClientPassword())){
				queryHql.append(" and sc.fsClientPassword like '%"+wsServiceClient.getFsClientPassword()+"%'	");
			}
		}
		return super.find(queryHql.toString());
	}
	
	public void saveWsServiceClient(final WsServiceClient wsServiceClient) throws Exception{
		if(wsServiceClient!=null&&StringUtils.isNotBlank(wsServiceClient.getFsId())){
			super.save(wsServiceClient);
		}
	}
	
	

}
