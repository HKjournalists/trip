package com.otrip.service.initdata;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otrip.dao.system.MenuAuthDao;
import com.otrip.domain.system.SysMenuAuth;
import com.otrip.domain.system.SysMenuType;
import com.otrip.initdata.datacache.SystemDataCache;
import com.otrip.service.GeneralService;
/**
 * @see 
 * @author 装载系统数据服务
 */

@Service
public class InitSystemDataServiceImpl extends GeneralService<SysMenuAuth> implements InitSystemDataService {

	private static final long serialVersionUID = -6989945861238373725L;
	
	static Logger log=Logger.getLogger(InitSystemDataServiceImpl.class);
	
	private MenuAuthDao menuAuthDao;
	@Autowired
	public void setMenuAuthDao(MenuAuthDao menuAuthDao) {
		this.menuAuthDao = menuAuthDao;
	}
	
	public void initSystemDataCache() throws BeansException{
		initSystemMenuAuth();
	}
	
	
	
	
	
	
	
	/********************************************************
	 * @see 主系统和子系统装载
	 ********************************************************/
	
	private void initSystemMenuAuth()throws BeansException{
		final List< SysMenuAuth> sysMain=SystemDataCache.getSysMain();
		final SysMenuAuth mainSys=menuAuthDao.loadMainSystem();
		sysMain.add( mainSys);
		
		final List<SysMenuAuth> sysChild=SystemDataCache.getSysChild();
		final List<SysMenuAuth> childSysList=menuAuthDao.loadChildSystem(mainSys);
		if(childSysList!=null&&childSysList.size()>0){
			for(int i=0;i<childSysList.size();i++){
				final SysMenuAuth childSysTem=childSysList.get(i);
				sysChild.add( childSysTem);
			}
		}
	}
	
	

}
