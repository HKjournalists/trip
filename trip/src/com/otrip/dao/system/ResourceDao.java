package com.otrip.dao.system;

import java.util.List;

import com.otrip.dao.IGenericDao;
import com.otrip.domain.system.SysResource;

public interface ResourceDao extends IGenericDao<SysResource, String> {
	
	public List<SysResource> findAllSysResources();
	
	public List<SysResource> queryRescourcesBySysResource(final SysResource sysResource) throws RuntimeException;
	
	public SysResource findSysResourceById(final String id)throws RuntimeException;
	
	public void delSysResourceById(final String id) throws RuntimeException;

}
