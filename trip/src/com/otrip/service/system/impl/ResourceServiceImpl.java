package com.otrip.service.system.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otrip.dao.system.ResourceDao;
import com.otrip.domain.DomainUtils;
import com.otrip.domain.system.SysResource;
import com.otrip.service.GeneralService;
import com.otrip.service.IService;
import com.otrip.service.system.ResourceService;

@Transactional
@Service
public class ResourceServiceImpl extends GeneralService<SysResource> implements ResourceService {

	private static final long serialVersionUID = 9170532827446611196L;
	
	private ResourceDao resourceDao;
	@Autowired
	public void setResourceDao(ResourceDao resourceDao) {
		this.resourceDao = resourceDao;
	}
	
	
	/**
	 * @see 获取资源信息
	 * @return
	 */
	public List<SysResource> findAllResource(){
		return resourceDao.loadAll();
	}
	
	public List<SysResource> queryRescourcesBySysResource(final SysResource sysResource) throws RuntimeException{
		return resourceDao.queryRescourcesBySysResource(sysResource);
	}
	
	public SysResource findSysResourceById(final String id)throws RuntimeException{
		return resourceDao.findSysResourceById(id);
	}
	
	public SysResource addSysResource(final SysResource sysResource) throws RuntimeException{
		if(sysResource!=null&&StringUtils.isNotBlank(sysResource.getFsName())){
			sysResource.setFsId(DomainUtils.generalUuid());
			resourceDao.save(sysResource);
			return sysResource;
		}else{
			return null;
		}
		
	}
	
	public void delSysResourceById(final String id) throws RuntimeException{
		resourceDao.delSysResourceById(id);
	}
	

}
