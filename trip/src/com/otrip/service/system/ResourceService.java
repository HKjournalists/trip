package com.otrip.service.system;

import java.util.List;

import com.otrip.domain.system.SysResource;
import com.otrip.service.IService;
/**
 * @see 资源定位
 * @author Administrator
 *
 */
public interface ResourceService extends IService {
	
	public List<SysResource> findAllResource();
	
	public List<SysResource> queryRescourcesBySysResource(final SysResource sysResource) throws RuntimeException;
	
	public SysResource findSysResourceById(final String id)throws RuntimeException;
	
	public SysResource addSysResource(final SysResource sysResource) throws RuntimeException;
	
	public void delSysResourceById(final String id) throws RuntimeException;

}
