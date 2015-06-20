package com.otrip.dao.ws;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.otrip.dao.IGenericDao;
import com.otrip.domain.ws.WsLogLogin;

public interface WsLogLoginDao extends IGenericDao<WsLogLogin, String> {

	public void logoutWs(final WsLogLogin wsLogLogin) throws Exception;
	
	public void saveWsLogLogin(final WsLogLogin wsLogLogin) throws DataAccessException;
	
	public List<WsLogLogin> queryWsLogLogins(final WsLogLogin wsLogLogin) throws Exception;
}
