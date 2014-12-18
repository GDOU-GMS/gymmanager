package com.gms.dao;

import java.util.List;

import com.gms.domain.SiteOrder;
import com.gms.vo.SiteOrderVo;

public interface SiteOrderDAO {

	/**
	 * 添加场地预约
	 * @param siteOrder
	 */
	public  void addSiteOrder(SiteOrder siteOrder);
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
	public  List<SiteOrderVo> getSiteOrderPageData(int startIndex, int pageSize);
	
	/**
	 * 获得数据库的总记录数
	 * @return
	 */
	public  int getTotalRecord();
	
	/**
	 * 根据id查找预约
	 * @param id
	 * @return
	 */
	public abstract SiteOrder getsiteOrderById(int id);
}