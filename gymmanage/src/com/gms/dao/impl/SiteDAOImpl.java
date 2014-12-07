package com.gms.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.gms.dao.SiteDAO;
import com.gms.domain.Site;
import com.gms.utils.JDBCUtils;

public class SiteDAOImpl implements SiteDAO {


	/**
	 * 增加场地
	 * 
	 * @param site
	 */
	public void addSite(Site site) {
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "insert into tb_site(typeId,name,statue,feeScale) values(?,?,?,?)";
			Object params[] = { site.getTypeId(), site.getName(), "undeleted",
					site.getFeeScale() };
			qr.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 更新场地信息
	 * 
	 * @param site
	 */
	public void updateSite(Site site) {
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "update tb_site set typeId=?,name=?,feeScale=? where id=?";
			Object params[] = {site.getTypeId(),site.getName(),site.getFeeScale(),site.getId()};
			qr.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 删除场地
	 * 
	 * @param id
	 */
	public void deleteSite(int id) {
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "update tb_site set statue='deleted' where id=?";
			qr.update(sql, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 获得所有的场地
	 * 
	 * @return
	 */
	public List<Site> getAllSite() {
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select * from tb_site";
			return (List<Site>)qr.query(sql, new BeanListHandler(Site.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
