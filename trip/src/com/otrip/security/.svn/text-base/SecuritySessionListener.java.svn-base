package com.otrip.security;

import javax.servlet.http.HttpSessionEvent;
import org.apache.log4j.Logger;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.otrip.dao.system.LoginHistoryDao;
import com.otrip.domain.system.SysLoginHistory;
/**
 * @see 实现session监听
 * @author zhongJc
 */
public class SecuritySessionListener extends HttpSessionEventPublisher {
	static Logger log=Logger.getLogger(SecuritySessionListener.class);

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		// TODO Auto-generated method stub
		super.sessionCreated(event);
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		// TODO Auto-generated method stub
		Object o=event.getSession().getAttribute(LoginUserHelper.LOGIN_CURRENT_USER_HISTORY);
		if(o!=null){
			final SysLoginHistory loginSysLoginHistory=(SysLoginHistory)o;
			log.info("#####################Time out Logout#####################!");
			WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(event.getSession().getServletContext());
			LoginHistoryDao loginHistoryDao=(LoginHistoryDao) context.getBean("loginHistoryDao");
			loginHistoryDao.updateLoginHistoryLogoutTime(loginSysLoginHistory.getFsId());
		}
		super.sessionDestroyed(event);
	}

}
