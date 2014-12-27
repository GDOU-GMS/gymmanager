package com.gms.dao;

import java.util.Date;
import java.util.List;

import com.gms.domain.SiteOrder;
import com.gms.vo.SiteOrderVo;

public interface SiteOrderDAO {

	/**
	 * 添加场地预约
	 * @param siteOrder
	 */
	public abstract void addSiteOrder(SiteOrder siteOrder);
	/**
	 * 删除场地预约
	 * @param id
	 */
	public abstract void deleteSiteOrder(int id);

	/**
	 * 更改场地预约
	 * @param siteOrder
	 */
	public abstract void updateSiteOrder(SiteOrder siteOrder);

	/**
	 * 过得所哟场地预约
	 * @return
	 */
	public abstract List<SiteOrder> getAllSiteOrder();

	/**
	 * 查询用户所有的预约
	 * @param userId
	 * @return
	 */
	public abstract List<SiteOrder> getSiteOrderByUserId(int userId);

	/**
	 * 根据预约状态查找预约
	 * @param statue
	 * @return
	 */
	public abstract List<SiteOrder> getSiteOrderByStaue(String statue);

	/**
	 * 获得场地预约分页数据
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public abstract List<SiteOrderVo> getSiteOrderPageData(int startIndex, int pageSize);
	
	/**
	 * 获得数据库的总记录数
	 * @return
	 */
	public abstract int getTotalRecord();
	
	/**
	 * 根据id查找预约
	 * @param id
	 * @return
	 */
	public abstract SiteOrder getsiteOrderById(int id);
	/**
	 * 获取当前预约
	 * @return
	 */
	public abstract List<SiteOrderVo> getCurrentSiteOrder(int stratIndex,int pageSize);
	/**
	 * 处理过期预约，提前10分钟到
	 */
	public abstract int dealBreach();
	
	/**
	 * 查询场地预约信息
	 * @param sitename
	 * @param username
	 * @param statue
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public abstract List<SiteOrderVo> querySiteOrderPageDate(String sitename,String username,String statue, int startIndex,int pageSize);
	/**
	 * 获得查询结果的总记录数
	 * @param sitename
	 * @param username
	 * @param statue
	 * @return
	 */
	public abstract int getQueryResultTotalRecord(String sitename,String username,String statue);
	/**
	 * 获得查询今天的总预约的总记录数
	 * @param sitename
	 * @param username
	 * @param statue
	 * @return
	 */
	public abstract int getCurrentSiteOrderTotalRecord();
	
	/**
	 * 条件查询当前的场地预约
	 * @param sitename
	 * @param username
	 * @param statue
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public abstract List<SiteOrderVo> getQueryCurrentSiteOrder(String sitename,String username,String statue,int startIndex,int pageSize);
	
	/**
	 * 获得查询当前预约的总记录数
	 * @param sitename
	 * @param username
	 * @param statue
	 * @return
	 */
	public abstract int getQueryCurrentSiteOrderTotalRecord(String sitename,String username,String statue);
	/**
	 *  查询是否存在规定时间段的场地预约
	 * @param stratTime
	 * @param endTime
	 * @param siteId
	 * @return
	 */
	public abstract boolean getSiteOrderByTime(Date stratTime,Date endTime,int siteId);

	/**
	 * 管理员预留场地
	 */
	public abstract void reserveSiteOrder(SiteOrder siteOrder);
	/**
	 * 获得所有的预留信息
	 * @return
	 */
	public abstract List<SiteOrderVo> getAllReserveSiteOrder(int startIndex,int pageSize);
	/**
	 * 获得预留场地的总记录数
	 * @return
	 */
	public abstract int getReserveSiteOrderTotalRecord();
	/**
	 * 更新场地预留
	 * @param siteOrder
	 */
	public abstract void updateReserveSiteOrder(SiteOrder siteOrder);
	
	/**
	 * 查询场地预留信息
	 * @param sitename
	 * @param username
	 * @param statue
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public abstract List<SiteOrderVo> queryReserveSiteOrder(String sitename,String statue, int startIndex,int pageSize);
	/**
	 * 获得查询场地预留的总记录数
	 * @param sitename
	 * @param username
	 * @param statue
	 * @return
	 */
	public  int getQueryReserveSiteOrderTotalRecord(String sitename,String statue);
	/**
	 * 处理过期预留，提前10分钟到
	 */
	public abstract int dealPassed();
}