package com.gms.dao;

import java.util.List;

import com.gms.domain.SiteOrder;

public interface SiteOrderDAO {

	/**
	 * 新增一个场地预约
	 * @param siteOrder
	 */
	public abstract void addSiteOrder(SiteOrder siteOrder);

	/**
	 * 删除场地预约
	 * @param id
	 */
	public abstract void deleteSiteOrder(int id);

	/**
	 * 修改场地预约
	 * @param siteOrder
	 */
	public abstract void updateSiteOrder(SiteOrder siteOrder);

	/**
	 * 获取所有的场地预约
	 * @return
	 */
	public abstract List<SiteOrder> getAllSiteOrder();

	/**
	 * 获得用户的所有的场地预约
	 * @param userId
	 * @return
	 */
	public abstract List<SiteOrder> getSiteOrderByUserId(int userId);

	/**
	 * 根据预约的状态查找场地预约
	 * @param statue
	 * @return
	 */
	public abstract List<SiteOrder> getSiteOrderByStaue(String statue);
	/**
	 * 获取所有失约的场地预约
	 */

}