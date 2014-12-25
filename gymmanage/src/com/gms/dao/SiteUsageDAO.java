package com.gms.dao;

import java.util.List;

import com.gms.domain.SiteUsage;
import com.gms.vo.SiteUsageVo;

public interface SiteUsageDAO {

	/**
	 * 增加场地使用
	 */
	public abstract void addSiteUsage(SiteUsage siteUsage);

	/**
	 * 根据id删除场地使用
	 * @param id
	 */
	public abstract void deleteSiteUsageById(int id);

	/**
	 *删除所有过期的场地使用
	 */
	public abstract void deleteAllPassedSiteUsage();

	/**
	 * 获得所有的场地使用情况
	 * @return
	 */
	public abstract List<SiteUsageVo> getAllCurrentSiteUsage(int startIndex,int pageSize);
	/**
	 * 获得数据库总记录数
	 * @return
	 */
	public abstract int getCurrentSiteUsageTotalRecord();
	/**
	 * 更新场地使用
	 */
	public abstract void updateSiteUsage(SiteUsage siteUsage);

}