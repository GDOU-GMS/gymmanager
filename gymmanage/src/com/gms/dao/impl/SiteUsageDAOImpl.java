package com.gms.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.gms.dao.SiteUsageDAO;
import com.gms.domain.SiteUsage;
import com.gms.utils.JDBCUtils;
import com.gms.vo.SiteUsageVo;

public class SiteUsageDAOImpl implements SiteUsageDAO {

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
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "delete from tb_siteusage where id=?";
			qr.update(sql, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 *删除所有过期的场地使用
	 */
	public void deleteAllPassedSiteUsage(){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "delete from tb_siteusage where statue='timeout' ";
			qr.update(sql);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 获得所有的场地使用情况
	 * @return
	 */
	public List<SiteUsageVo> getAllCurrentSiteUsage(int startIndex,int pageSize){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select tb_siteusage.*,tb_site.name as sitename,tb_user.name as username,tb_user.studentNo as studentNo from tb_siteusage,tb_site,tb_user where tb_siteusage.siteId=tb_site.id and tb_siteusage.userId=tb_user.id limit ?,?";
			Object params[] = {startIndex,pageSize};
			return (List<SiteUsageVo>)qr.query(sql, params,new BeanListHandler(SiteUsageVo.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 获得数据库总记录数
	 * @return
	 */
	public int getCurrentSiteUsageTotalRecord(){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select count(*) from tb_siteusage,tb_site,tb_user where tb_siteusage.siteId=tb_site.id and tb_siteusage.userId=tb_user.id";
			long l = (Long)qr.query(sql, new ScalarHandler());
			return (int)l;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 更新场地使用
	 */
	public void updateSiteUsage(SiteUsage siteUsage){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "update tb_siteusage set stratTime=?,endTime=?,price=?,userId=?,siteId=?,statue=?";
			Object params[] = {siteUsage.getStratTime(),siteUsage.getEndTime(),siteUsage.getPrice(),siteUsage.getUserId(),siteUsage.getSiteId(),siteUsage.getStatue()};			
			qr.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
}

