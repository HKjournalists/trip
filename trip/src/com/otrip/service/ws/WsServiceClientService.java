package com.otrip.service.ws;

import java.util.List;

import com.otrip.domain.ws.WsServiceClient;
import com.otrip.service.IService;
/**
 * @see 根据账号查找客户端
 * @author zhongJc
 *
 */
public interface WsServiceClientService extends IService {

	public WsServiceClient findWsServiceClientByAccountAndPassword(final String clientAccount,final String clientPassword) throws Exception;
	
	public List<WsServiceClient> queryWsServiceClients(final WsServiceClient wsServiceClient)throws Exception;

	public void saveWsServiceClient(final WsServiceClient wsServiceClient) throws Exception;
	
	public void deleteWsServiceClientById(final String fsId)throws Exception;
}
