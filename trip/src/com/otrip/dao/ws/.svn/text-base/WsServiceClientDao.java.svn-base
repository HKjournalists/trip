package com.otrip.dao.ws;

import java.util.List;

import com.otrip.dao.IGenericDao;
import com.otrip.domain.ws.WsServiceClient;

/**
 * @see 生成ws数据库操作接口
 * @author zhongJc
 *
 */
public interface WsServiceClientDao extends IGenericDao<WsServiceClient, String> {
	
	public List<WsServiceClient> findWsServiceClientsByAccountAndPassword(final String clientAccount,final String clientPassword) throws Exception;
	
	public List<WsServiceClient> queryWsServiceClients(final WsServiceClient wsServiceClient)throws Exception;

	public void saveWsServiceClient(final WsServiceClient wsServiceClient) throws Exception;

}
