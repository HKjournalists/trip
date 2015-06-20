package com.otrip.dao.system.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.otrip.controls.system.vo.MenuVo;
import com.otrip.dao.GenericHibernateDao;
import com.otrip.dao.system.MenuAuthDao;
import com.otrip.domain.system.SysMenuAuth;
import com.otrip.domain.system.SysMenuType;
import com.otrip.initdata.datacache.SystemDataCache;

@Component(value="menuAuthDao")
public class MenuAuthDaoImpl extends GenericHibernateDao<SysMenuAuth, String> implements MenuAuthDao {
	
	static Logger log=Logger.getLogger(MenuAuthDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	public SysMenuAuth loadMainSystem() throws RuntimeException{
		StringBuffer queryHql=new StringBuffer(" select ma from SysMenuAuth ma where 1=1 and ma.fsParentId='"+SystemDataCache.getRootSystemParentId()+"' ");
		queryHql.append(" and ma.sysMenuType.fsSign='"+SystemDataCache.getMenuTypeMainSystem()+"' ");
		final List<SysMenuAuth> mainSystemList=super.find(queryHql.toString());
		if(mainSystemList!=null&&mainSystemList.size()>0){
			return mainSystemList.get(0);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<SysMenuAuth> loadChildSystem(final SysMenuAuth mainSystem) throws RuntimeException{
		if(mainSystem!=null&&StringUtils.isNotBlank(mainSystem.getFsId())){
			StringBuffer queryHql=new StringBuffer(" select ma from SysMenuAuth ma where 1=1 and ma.fsParentId='"+mainSystem.getFsId()+"' ");
			queryHql.append(" and ma.sysMenuType.fsSign='"+SystemDataCache.getMenuTypeChildSystem()+"' ");
			queryHql.append(" order by ma.fnOrder asc ");
			return super.find(queryHql.toString());
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<SysMenuAuth> loadAllMenu() throws RuntimeException{
		StringBuffer queryHql=new StringBuffer(" select ma from SysMenuAuth ma where 1=1 ");
		queryHql.append(" and ma.sysMenuType.fsSign !='"+SystemDataCache.getMenuTypeLink()+"' ");
		queryHql.append(" and ma.sysMenuType.fsSign !='"+SystemDataCache.getMenuTypeButton()+"' ");
		queryHql.append(" order by ma.fnOrder asc ");
		return super.find(queryHql.toString());
	}
		
	public SysMenuAuth loadSysMenuAuthById(final String menuId) throws RuntimeException{
		if(StringUtils.isNotBlank(menuId)){
			return super.load(menuId);
		}else{
			return null;
		}
	}
		
	@SuppressWarnings("unchecked")
	public List<SysMenuAuth>  findMenuIncludeLinksOrButtons(final SysMenuAuth parentMenu) throws RuntimeException{
		if(parentMenu!=null&&StringUtils.isNotBlank(parentMenu.getFsId())){
			StringBuffer queryHql=new StringBuffer(" select ma from SysMenuAuth ma where 1=1 ");
			queryHql.append(" and ( ma.sysMenuType.fsSign ='"+SystemDataCache.getMenuTypeLink()+"' ");
			queryHql.append(" or ma.sysMenuType.fsSign ='"+SystemDataCache.getMenuTypeButton()+"' ) ");
			queryHql.append(" and ma.fsParentId ='"+parentMenu.getFsId()+"'  ");
			log.info("Query HQL:"+queryHql.toString());
			return super.find(queryHql.toString());
		}
		return null;
	}
	
	
	/**
	 * @see 查询菜单信息
	 * @param parentMenu
	 * @param queryVo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<MenuVo> queryMenuIncludeLinkOrButtons(final SysMenuAuth parentMenu,final MenuVo queryVo) throws RuntimeException{
		if(parentMenu!=null&&StringUtils.isNotBlank(parentMenu.getFsId())){
			StringBuffer queryHql=new StringBuffer(" select new com.otrip.controls.system.vo.MenuVo(ma.fsId,mt.fsName,");
			queryHql.append("ma.fsName,mr.fsKey,mr.fsUrl,");
			queryHql.append("ma.fsStatus ) ");
			queryHql.append("from SysMenuAuth ma,SysResource mr,SysMenuType mt where 1=1 ");
			queryHql.append(" and ma.sysResource=mr and ma.sysMenuType=mt ");
			queryHql.append(" and ( mt.fsSign ='"+SystemDataCache.getMenuTypeLink()+"' ");
			queryHql.append(" or mt.fsSign ='"+SystemDataCache.getMenuTypeButton()+"' ) ");
			queryHql.append(" and ma.fsParentId ='"+parentMenu.getFsId()+"'  ");
			if(queryVo!=null&&StringUtils.isNotBlank(queryVo.getMenuName())){
				queryHql.append(" and ma.fsName like '%"+queryVo.getMenuName()+"%' ");
			}
			log.info("Query HQL:"+queryHql.toString());
			return super.find(queryHql.toString());
			
		}
		return null;
	}
	
	/**
	 * @see 根据父ID找到所有的子菜单
	 * @param parentId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<SysMenuAuth> findChildsMenuByParentId(final String parentId) throws DataAccessException{
		if(StringUtils.isNotBlank(parentId)){
			StringBuffer sbQueryHql=new StringBuffer( " from SysMenuAuth ma where 1=1 ");
			sbQueryHql.append(" and ma.fsParentId='"+parentId+"'");
			return super.find(sbQueryHql.toString());
		}else{
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public SysMenuAuth findSysMenuAuthById(final String id)throws DataAccessException{
		if(StringUtils.isNotBlank(id)){
			StringBuffer sbQueryHql=new StringBuffer( " from SysMenuAuth ma where 1=1 ");
			sbQueryHql.append(" and ma.fsId='"+id+"'");
			final List<SysMenuAuth> list=super.find(sbQueryHql.toString());
			return list!=null&&list.size()>0?list.get(0):null;
		}else{
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<SysMenuAuth> findSysMenuAuthByMenuType(final SysMenuType SysMenuType) throws DataAccessException{
		if(SysMenuType!=null&&StringUtils.isNotBlank(SysMenuType.getFsId())){
			StringBuffer sbQueryHql=new StringBuffer(" from SysMenuAuth ma where 1=1 ");
			sbQueryHql.append(" and ma.sysMenuType.fsId='"+SysMenuType.getFsId()+"' ");
			return super.find(sbQueryHql.toString());
		}else{
			return null;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<SysMenuAuth> findSysMenuAuthByIdS(final String [] ids) throws DataAccessException{
		if(ids!=null&&ids.length>0){
			StringBuffer sbQueryHql=new StringBuffer(" SELECT ma FROM SysMenuAuth ma WHERE ma.fsId in (:ids)" );
			return super.findByInCondition(sbQueryHql.toString(), "ids", ids);
		}
		return null;
	}
	
}
