package com.gms.dao;

import java.util.List;

import com.gms.domain.Site;

public interface SiteDAO {

	/**
	 * 增加场地
	 * 
	 * @param site
	 */
	public abstract void addSite(Site site);

	/**
	 * 更新场地信息
	 * 
	 * @param site
	 */
	public abstract void updateSite(Site site);

	/**
	 * 删除场地
	 * 
	 * @param id
	 */
	public abstract void deleteSite(int id);

	/**
	 * 获得所有的场地
	 * 
	 * @return
	 */
	public abstract List<Site> getAllSite();

}