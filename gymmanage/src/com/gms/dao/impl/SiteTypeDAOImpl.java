package com.gms.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.gms.dao.SiteTypeDAO;
import com.gms.domain.SiteType;
import com.gms.utils.JDBCUtils;

public class SiteTypeDAOImpl implements SiteTypeDAO {

	/**
	 * ��ӳ�������
	 * @param siteType
	 */
	public void addType(SiteType siteType){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "insert into tb_sitetype(id,type) values(?,?)";
			Object params[] = {siteType.getId(),siteType.getType()};
			qr.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 *�޸ĳ�������
	 * @param siteType
	 */
	public void updateType(SiteType siteType){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "update tb_sitetype set type=? where id=?";
			Object params[] = {siteType.getType(),siteType.getId()};
			qr.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * ɾ����������
	 * @param id
	 */
	public void deleteType(int id){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "delete from tb_siteType where id=?";
			qr.update(sql, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * ��ȡ���еĳ�������
	 * @return
	 */
	public List<SiteType> getAllSiteType(){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select * from tb_siteType";
			return (List<SiteType>) qr.query(sql, new BeanListHandler(SiteType.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
