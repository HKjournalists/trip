package com.otrip.webservice.interceptor;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;

import com.otrip.webservice.util.WebServiceContext;

/**
 * @see 清除容器
 * @author zhongJc
 *
 */
public class CleanupInterceptor extends AbstractSoapInterceptor {

    public CleanupInterceptor() {
        super(Phase.MARSHAL);
    }

    public void handleMessage(final SoapMessage message) throws Fault {
        WebServiceContext.cleanup();
    }
}
