package com.gms.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.gms.domain.SiteUsage;
import com.gms.utils.JDBCUtils;

public class SiteUsageDAOImpl {

	/**
	 * 增加场地使用
	 */
	public void addSiteUsage(SiteUsage siteUsage){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "insert into tb_siteusage(stratTime,endTime,price,userId,siteId,statue) values(?,?,?,?,?,?)";
			Object params[] = {siteUsage.getStratTime(),siteUsage.getEndTime(),siteUsage.getPrice(),siteUsage.getUserId(),siteUsage.getSiteId(),siteUsage.getStatue()};
			qr.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 根据id删除场地使用
	 * @param id
	 */
	public void deleteSiteUsageById(int id){
		
	}
	
	/**
	 *删除所有过期的场地预约
	 */
	public void deleteAllPassedSiteUsage(){
		
	}
	/**
	 * 获得所有的场地使用情况
	 * @return
	 */
	public List<SiteUsage> getAllCurrentSiteUsage(){
		return  null;
	}
	/**
	 * 更新场地使用
	 */
	public void updateSiteUsage(){
		
	}
	
}

