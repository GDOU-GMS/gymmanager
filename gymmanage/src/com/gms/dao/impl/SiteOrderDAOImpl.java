package com.gms.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.gms.dao.SiteOrderDAO;
import com.gms.domain.SiteOrder;
import com.gms.utils.JDBCUtils;
import com.gms.vo.SiteOrderVo;

public class SiteOrderDAOImpl implements SiteOrderDAO {

	/**
	 * 添加新的预约
	 * 
	 * @param siteOrder
	 */
	public void addSiteOrder(SiteOrder siteOrder) {
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "insert into tb_siteorder(stratTime,endTime,userId,siteId,statue,orderTime)  values(?,?,?,?,?,?)";
			Object params[] = { siteOrder.getStratTime(),
					siteOrder.getEndTime(), siteOrder.getUserId(),
					siteOrder.getSiteId(),siteOrder.getStatue(), siteOrder.getOrderTime() };
			qr.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
	
	
	/**
	 * 删除预约
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
	 * 更改预约信息
	 * 
	 * @param siteOrder
	 */
	public void updateSiteOrder(SiteOrder siteOrder) {
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "update tb_siteorder set userId=?,stratTime=?,endTime=?,siteId=? where id=?";
			Object params[] = { siteOrder.getUserId(),siteOrder.getStratTime(),
					siteOrder.getEndTime(), siteOrder.getSiteId(),
					siteOrder.getId() };
			qr.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 获得所有预约
	 * 
	 * @return
	 */
	public List<SiteOrder> getAllSiteOrder() {
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select * from tb_siteorder order by orderTime";
			return (List<SiteOrder>) qr.query(sql, new BeanListHandler(
					SiteOrder.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 查询用户的所有预约
	 * 
	 * @param userId
	 * @return
	 */
	public List<SiteOrder> getSiteOrderByUserId(int userId) {
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select * from tb_siteorder where userId=?";
			return (List<SiteOrder>) qr.query(sql, userId, new BeanListHandler(
					SiteOrder.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 根据预约状态查找预约
	 * 
	 * @param statue
	 * @return
	 */
	public List<SiteOrder> getSiteOrderByStaue(String statue) {
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select * from tb_siteorder where statue=?";
			return (List<SiteOrder>) qr.query(sql, statue, new BeanListHandler(
					SiteOrder.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 获得场地预约分页数据
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List<SiteOrderVo> getSiteOrderPageData(int startIndex, int pageSize) {
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select tb_siteorder.*,tb_user.studentNo as studentNo ,tb_user.name as username,tb_site.name as sitename from tb_siteorder,tb_user,tb_site where tb_site.id=tb_siteorder.siteid and tb_user.id=tb_siteorder.userId limit ?,?";
			Object params[] = { startIndex, pageSize };
			return (List<SiteOrderVo>) qr.query(sql, params, new BeanListHandler(
					SiteOrderVo.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 获得数据库的总记录数
	 * @return
	 */
	public int getTotalRecord() {
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select count(*) from tb_siteorder";
			long l = (Long) qr.query(sql, new ScalarHandler());
			return (int) l;
		} catch (Exception e) {
			throw new RuntimeException(e);

		}
	}
	/**
	 * 根据id查找预约
	 * @param id
	 * @return
	 */
	public SiteOrder getsiteOrderById(int id){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select * from tb_siteOrder where id=?";
			return (SiteOrder)qr.query(sql, id, new BeanHandler(SiteOrder.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
			
		}
	}
}