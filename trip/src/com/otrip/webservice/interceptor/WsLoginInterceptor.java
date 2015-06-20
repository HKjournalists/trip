package com.otrip.webservice.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.json.JSONObject;

import com.otrip.webservice.util.WebServiceFaultsEnum;
import com.otrip.webservice.util.WebServiceHelper;
import com.otrip.webservice.util.WsLoginSession;

/**
 * @see Webservice的登入
 * @author zhongJc
 *
 */
public class WsLoginInterceptor extends AbstractPhaseInterceptor<SoapMessage> {

	@Resource     
	private WebServiceContext wsContext;    
	private MessageContext mc;  
	
	/** 
     * 创建一个新的实例 WsLoginInterceptor. 
     */  
    public WsLoginInterceptor() {  
        super(Phase.PREPARE_SEND);  
    }

	@Override
	public void handleMessage(SoapMessage soap) throws Fault {
		// TODO Auto-generated method stub
		mc = wsContext.getMessageContext();   
		final Object sessionObj = ((javax.servlet.http.HttpServletRequest) mc.get(MessageContext.SERVLET_CONTEXT)).getAttribute(WebServiceHelper.getWsLoginSessionToContentKey());   
		HttpSession session=sessionObj!=null?(javax.servlet.http.HttpSession)sessionObj:null;
		if(session!=null){
			throw WebServiceHelper.fault(WebServiceFaultsEnum.WS_NO_SESSION_ISNULL);
		}else{
			final Object wsLoginSessionObj=session.getAttribute(WebServiceHelper.getWsLoginSessionInfoToSessionKey());
			final WsLoginSession wsLoginSession=wsLoginSessionObj!=null?(WsLoginSession)wsLoginSessionObj:null;
			if(wsLoginSession==null){
				throw WebServiceHelper.fault(WebServiceFaultsEnum.WS_NO_LOGIN_ISNULL);
			}
		}
	}
}
