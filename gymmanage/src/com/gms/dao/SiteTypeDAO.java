package com.gms.dao;

import java.util.List;

import com.gms.domain.SiteType;

public interface SiteTypeDAO {

	/**
	 * 添加场地类型
	 * @param siteType
	 */
	public abstract void addType(SiteType siteType);

	/**
	 *修改场地类型
	 * @param siteType
	 */
	public abstract void updateType(SiteType siteType);

	/**
	 * 删除场地类型
	 * @param id
	 */
	public abstract void deleteType(int id);

	/**
	 * 获取所有的场地类型
	 * @return
	 */
	public abstract List<SiteType> getAllSiteType();

	/**
	 * 根据id查找场地
	 * @param id
	 * @return
	 */
	public abstract SiteType getSiteTypeById(int id);
}