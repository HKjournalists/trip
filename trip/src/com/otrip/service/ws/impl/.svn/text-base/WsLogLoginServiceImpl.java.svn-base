package com.otrip.service.ws.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otrip.dao.ws.WsLogLoginDao;
import com.otrip.domain.ws.WsLogLogin;
import com.otrip.service.GeneralService;
import com.otrip.service.ws.WsLogLoginService;


@Service
public class WsLogLoginServiceImpl extends GeneralService<WsLogLogin> implements WsLogLoginService {

	private static final long serialVersionUID = 204807048286597740L;

	static Logger log=Logger.getLogger(WsLogLoginServiceImpl.class);
	
	private WsLogLoginDao wsLogLoginDao;
	@Autowired
	public void setWsLogLoginDao(WsLogLoginDao wsLogLoginDao) {
		this.wsLogLoginDao = wsLogLoginDao;
	}
	
	public void updateLogoutWs(final WsLogLogin wsLogLogin) throws Exception{
		if(wsLogLogin!=null){
			wsLogLoginDao.logoutWs(wsLogLogin);
		}
	}
	
	public void saveLoginWs(final WsLogLogin wsLogLogin) throws Exception{
		if(wsLogLogin!=null&&StringUtils.isNotBlank(wsLogLogin.getFsId())){
			log.info("to method info:..............");
			wsLogLoginDao.saveWsLogLogin(wsLogLogin);
			log.info("to method info:..............");
		}
	}
	
	public List<WsLogLogin> queryWsLogLogins(final WsLogLogin wsLogLogin) throws Exception{
		return wsLogLoginDao.queryWsLogLogins(wsLogLogin);
	}
	
	public void deleteWsLogLoginById(final String id)throws Exception{
		if(StringUtils.isNotBlank(id)){
			wsLogLoginDao.deleteByKey(id);
		}
	}
	
	
}
