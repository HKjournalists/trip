package com.otrip.service.ws.impl;

import java.util.List;

import javax.persistence.Access;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otrip.dao.ws.WsServiceClientDao;
import com.otrip.domain.ws.WsServiceClient;
import com.otrip.service.GeneralService;
import com.otrip.service.ws.WsServiceClientService;

@Service
public class WsServiceClientServiceImpl extends GeneralService<WsServiceClient> implements WsServiceClientService {
	
	private static final long serialVersionUID = -4480456866190962897L;

	static Logger log=Logger.getLogger(WsServiceClientServiceImpl.class);
	
	private WsServiceClientDao wsServiceClientDao;
	@Autowired
	public void setWsServiceClientDao(WsServiceClientDao wsServiceClientDao) {
		this.wsServiceClientDao = wsServiceClientDao;
	}
	
	
	public WsServiceClient findWsServiceClientByAccountAndPassword(String clientAccount, String clientPassword) throws Exception {
		// TODO Auto-generated method stub
		final List<WsServiceClient> list=wsServiceClientDao.findWsServiceClientsByAccountAndPassword(clientAccount, clientPassword);
		return list!=null&&list.size()>0?list.get(0):null;
	}
	
	public List<WsServiceClient> queryWsServiceClients(final WsServiceClient wsServiceClient)throws Exception{
		return wsServiceClientDao.queryWsServiceClients(wsServiceClient);
	}

	public void saveWsServiceClient(final WsServiceClient wsServiceClient) throws Exception{
		wsServiceClientDao.saveWsServiceClient(wsServiceClient);
	}
	
	public void deleteWsServiceClientById(final String fsId)throws Exception{
		if(StringUtils.isNotBlank(fsId)){
			wsServiceClientDao.deleteByKey(fsId);
		}
	}

}
