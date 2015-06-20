
package com.otrip.webservice.util;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;



import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.common.util.StringUtils;
import org.apache.cxf.service.model.MessageInfo;
import org.apache.cxf.service.model.OperationInfo;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * The context for a given web service call
 * @author luis
 */
public class WebServiceContext {

    /**
     * Contains the type of web service being accessed
     * @author luis
     */
    public enum ContextType {
        POS, SERVICE_CLIENT, REST;
    }

    private static final ThreadLocal<WebServiceContext> HOLDER = new ThreadLocal<WebServiceContext>();

    /**
     * Removes any state for this request
     */
    public static void cleanup() {
        final WebServiceContext context = HOLDER.get();
        if (context != null) {


            context.request = null;
            context.servletContext = null;
            context.soapMessage = null;
        }

        HOLDER.remove();
    }

    /**
     * Returns the current context type, or null if none
     */
    public static ContextType getContextType() {
        final WebServiceContext context = HOLDER.get();
        return context == null ? null : context.contextType;
    }



    /**
     * Returns the web service method name
     */
    public static String getMethodName() {
        return assertContext(null).methodName;
    }

    /**
     * Returns the first method parameter
     */
    @SuppressWarnings("unchecked")
    public static <T> T getParameter() {
        return (T) assertContext(null).parameter;
    }


    /**
     * Returns the {@link HttpServletRequest} for this request
     */
    public static HttpServletRequest getRequest() {
        return assertContext(null).request;
    }

    /**
     * Returns the {@link HttpServletResponse}
     */
    public static HttpServletResponse getResponse() {
        return assertContext(null).response;
    }

    /**
     * Returns the web service name
     */
    public static String getServiceName() {
        return assertContext(null).serviceName;
    }

    /**
     * Returns the {@link ServletContext} for this request
     */
    public static ServletContext getServletContext() {
        return assertContext(null).servletContext;
    }

    /**
     * Returns the {@link SoapMessage} for this request
     */
    public static SoapMessage getSoapMessage() {
        return assertContext(null).soapMessage;
    }


    /**
     * Returns true if the web service context has been initialized. This method doesn't ensure that the context is ready for use.
     * @see #isReadyForUse() por ejemplo, cuando ocurre un error en un in-interceptor necesitamos inicializarlo con el soap message de entrada para
     * que los fault interceptors puedan trabajar.
     * @return
     */
    public static boolean isInitialized() {
        return HOLDER.get() != null;
    }

    public static boolean isPosContext() {
        return assertContext(null).isPosContextType();
    }

    /**
     * Returns true if the web service context has been initialized and is ready to be used by POS or Web Service Client.
     * @return
     */
    public static boolean isReadyForUse() {
        return isInitialized() && HOLDER.get().contextType != null;
    }



    private static WebServiceContext assertContext(final ContextType requiredCtx) {
        final WebServiceContext context = HOLDER.get();
        if (context == null) {
            throw new IllegalStateException("The web service context was not initialized yet");
        } else if (requiredCtx != null && requiredCtx != context.contextType) {
            throw new IllegalStateException(String.format("Invalid invocation: context type: %1$s", context.contextType));
        }

        return context;
    }

    private HttpServletRequest  request;
    private HttpServletResponse response;
    private ServletContext      servletContext;
    private SoapMessage         soapMessage;
    private ContextType         contextType;
    private Object              parameter;
    private String              serviceName;

    private String              methodName;

    /**
     * Constructor for a REST services context
     * @param response
     */
    private WebServiceContext(final ServletContext servletContext, final HttpServletRequest request, final HttpServletResponse response) {

        this.request = request;
        this.response = response;
        this.servletContext = servletContext;
        contextType = ContextType.REST;
        final String uri = request.getRequestURI();
        final String contextPath = request.getContextPath();
        final int pos = StringUtils.isEmpty(contextPath) ? -1 : uri.indexOf(contextPath);
        serviceName = pos < 0 ? uri : uri.substring(contextPath.length() + 1);
    }

    /**
     * Shared constructor
     */
    private WebServiceContext(final ServletContext servletContext, final HttpServletRequest request, final SoapMessage soapMessage) {

        this.request = request;
        this.servletContext = servletContext;
        this.soapMessage = soapMessage;
        initParameter();
        initServiceName();
        initOperationName();
    }



    private void initOperationName() {
        final MessageInfo messageInfo = soapMessage.get(MessageInfo.class);
        final OperationInfo operation = messageInfo.getOperation();
        final QName operationQName = operation.getName();
        methodName = operationQName.getLocalPart();
    }

    private void initParameter() {
        parameter = WebServiceHelper.getParameter(soapMessage);
    }

    private void initServiceName() {
        if (request != null) {
            final String uri = request.getRequestURI();
            serviceName = uri.substring(uri.lastIndexOf('/') + 1);
        }
    }

    private boolean isPosContextType() {
        return contextType == ContextType.POS;
    }


}
