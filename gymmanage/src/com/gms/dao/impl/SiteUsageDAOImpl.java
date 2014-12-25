package com.gms.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.gms.domain.SiteUsage;
import com.gms.utils.JDBCUtils;

public class SiteUsageDAOImpl {

	/**
	 * ���ӳ���ʹ��
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
	 * ����idɾ������ʹ��
	 * @param id
	 */
	public void deleteSiteUsageById(int id){
		
	}
	
	/**
	 *ɾ�����й��ڵĳ���ԤԼ
	 */
	public void deleteAllPassedSiteUsage(){
		
	}
	/**
	 * ������еĳ���ʹ�����
	 * @return
	 */
	public List<SiteUsage> getAllCurrentSiteUsage(){
		return  null;
	}
	/**
	 * ���³���ʹ��
	 */
	public void updateSiteUsage(){
		
	}
	
}

