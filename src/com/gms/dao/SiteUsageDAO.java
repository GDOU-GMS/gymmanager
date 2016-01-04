package com.gms.dao;

import java.util.Date;
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
	
	/**
	 * 获得指定时间段的场地使用
	 * @param stratTime
	 * @param endTime
	 * @param siteId
	 * @return 
	 */
	public abstract boolean getSiteUsageByTime(Date stratTime,Date endTime,int siteId);
	/**
	 * 根据id过得场地使用信息
	 * @param id
	 * @return
	 */
	public abstract SiteUsage getSiteUsageById(int id);
	/**
	 * 处理时间到的场地使用
	 * @return
	 */
	public  int dealTimeOutSiteUsage();
	/**
	 * 删除所有超时的场地使用
	 * @return
	 */
	public abstract int deleteAllTimeOutSiteUsage();
	
	/**
	 * 查询场地使用情况
	 * @param sitename
	 * @param username
	 * @param statue
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public abstract List<SiteUsageVo> querySiteUsage(String sitename,String username,String statue,int startIndex,int pageSize);
	
	/**
	 * 获得查询结果的总记录数
	 * @param sitename
	 * @param username
	 * @param statue
	 * @return
	 */
	public abstract int getQuerySiteUsageTotalRecord(String sitename,String username,String statue);
	
}