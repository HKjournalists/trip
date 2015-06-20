package com.otrip.service.ws;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.otrip.domain.ws.WsLogLogin;
import com.otrip.service.IService;

/**
 * @see 接口登入处理
 * @author zhongJc
 *
 */
public interface WsLogLoginService extends IService {
	
	public void updateLogoutWs(final WsLogLogin wsLogLogin) throws Exception;
	
	public void saveLoginWs(final WsLogLogin wsLogLogin) throws Exception;
	
	public List<WsLogLogin> queryWsLogLogins(final WsLogLogin wsLogLogin) throws Exception;
	
	public void deleteWsLogLoginById(final String id)throws Exception;

}
