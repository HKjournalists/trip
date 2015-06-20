package com.otrip.webservice.interceptor;

import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.cxf.binding.soap.SoapFault;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.otrip.domain.ws.WsServiceClient;
import com.otrip.service.ws.WsServiceClientService;
import com.otrip.webservice.util.ServiceOperation;
import com.otrip.webservice.util.WebServiceContext;
import com.otrip.webservice.util.WebServiceContext.ContextType;
import com.otrip.webservice.util.WebServiceFaultsEnum;
import com.otrip.webservice.util.WebServiceHelper;

/**
 * @see 拦截客户端验证
 * @author zhongJc
 *
 */
public class AuthClientInterceptor extends AbstractSoapInterceptor {
	
	static Logger log=Logger.getLogger(AuthClientInterceptor.class);
	
	private WsServiceClientService  wsServiceClientService;
	@Autowired
	public void setWsServiceClientService(
			WsServiceClientService wsServiceClientService) {
		this.wsServiceClientService = wsServiceClientService;
	}

	public AuthClientInterceptor() {
		super(Phase.PRE_INVOKE);
	}

	/**
	 * @see 实现客户端验证
	 */
	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		// TODO Auto-generated method stub
		final HttpServletRequest request = WebServiceHelper.requestOf(message);
		request.setAttribute(ContextType.class.getName(), ContextType.SERVICE_CLIENT);
		
		WsServiceClient client = null;
        final ServletContext servletContext = servletContextOf(message);
        try {
            if (Boolean.TRUE.equals(servletContext.getAttribute("otrip.httpEnabled"))) {
                final String protocol = StringUtils.split(request.getRequestURL().toString(), "://")[0];
                if (!"https".equalsIgnoreCase(protocol)) {
                    throw WebServiceHelper.fault(WebServiceFaultsEnum.SECURE_ACCESS_REQUIRED);
                }
            }

            boolean allowed = true;
            /*boolean allowed = false;*/
            // Find the service client
            /*client = resolveClient(request);
            if (client != null) {
            	allowed=true;
            	log.info("链接的客户客段为："+client.toString());
            }
            if (!allowed) {
                throw WebServiceHelper.fault(WebServiceFaultsEnum.UNAUTHORIZED_ACCESS);
            }*/
        } catch (Exception e) {
            if (e instanceof SoapFault) {
                throw (SoapFault) e;
            } else {
                throw WebServiceHelper.fault(e);
            }
        }

	}
	
	
	/**
	 * @see 解析客户端验证，并且数据解析
	 * @param request
	 * @return
	 */
	private WsServiceClient resolveClient(final HttpServletRequest request) {
        String[] credentials = WebServiceHelper.getCredentials(request);
        if (credentials == null) {
            return null;
        }
        try {
        	final WsServiceClient wsc=wsServiceClientService.findWsServiceClientByAccountAndPassword( credentials[0], credentials[1]);
        	return wsc;
        } catch (final Exception e) {
            return null;
        }
    }
	
	/**
	 * @see 获取请求的信息
	 * @param message
	 * @return
	 */
	private ServletContext servletContextOf(final SoapMessage message) {
	     return (ServletContext) message.get(AbstractHTTPDestination.HTTP_CONTEXT);
	}

}
