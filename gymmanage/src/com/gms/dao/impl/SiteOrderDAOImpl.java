package com.gms.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.gms.dao.SiteOrderDAO;
import com.gms.domain.SiteOrder;
import com.gms.utils.JDBCUtils;

public class SiteOrderDAOImpl implements SiteOrderDAO {

	/**
	 * 新增一个场地预约
	 * 
	 * @param siteOrder
	 */
	public void addSiteOrder(SiteOrder siteOrder) {
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "insert into tb_siteorder(stratTime,endTime,userId,siteId,staue,orderTime) where values(?,?,?,?,?,?)";
			Object params[] = {siteOrder.getStratTime(),siteOrder.getEndTime(),siteOrder.getUserId(),siteOrder.getSiteId(),siteOrder.getOrderTime()};
			qr.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	/**
	 * 删除场地预约
	 * 
	 * @param id
	 */
	public void deleteSiteOrder(int id) {
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "delete from tb_siteorder where id=?";
			qr.update(sql, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 修改场地预约
	 * 
	 * @param siteOrder
	 */
	public void updateSiteOrder(SiteOrder siteOrder) {
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "update tb_siteorder set stratTime=?,endTime=?,siteId=? where id=?";
			Object params[] = {siteOrder.getStratTime(),siteOrder.getEndTime(),siteOrder.getSiteId(),siteOrder.getId()};
			qr.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 获取所有的场地预约
	 * 
	 * @return
	 */
	public List<SiteOrder> getAllSiteOrder() {
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select * from tb_site order by orderTime";
			return (List<SiteOrder>)qr.query(sql, new BeanListHandler(SiteOrder.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 获得用户的所有的场地预约
	 * 
	 * @param userId
	 * @return
	 */
	public List<SiteOrder> getSiteOrderByUserId(int userId) {
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select * from tb_siteorder where userId=?";
			return (List<SiteOrder>)qr.query(sql, userId, new BeanListHandler(SiteOrder.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 根据预约的状态查找场地预约
	 * 
	 * @param statue
	 * @return
	 */
	public List<SiteOrder> getSiteOrderByStaue(String statue) {
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select * from tb_siteorder where statue=?";
			return (List<SiteOrder>)qr.query(sql, statue, new BeanListHandler(SiteOrder.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 获取所有失约的场地预约
	 */
}
