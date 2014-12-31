package com.gms.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.gms.dao.SiteDAO;
import com.gms.domain.Site;
import com.gms.utils.JDBCUtils;
import com.gms.vo.SiteVo;

public class SiteDAOImpl implements SiteDAO {


	/**
	 * ���ӳ���
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
	 * ���³�����Ϣ
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
	 * ɾ������
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
	 * ������еĳ���
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
	/**
	 * ��ó��صķ�ҳ����
	 * @param beginIndex
	 * @param pageSize
	 * @return
	 */
	public List<SiteVo> getSitePageData(int startIndex,int pageSize){
		try{
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select tb_site.*,tb_sitetype.type from tb_site,tb_sitetype where tb_site.typeid=tb_sitetype.id order by typeId,statue desc  limit ?,?";
			Object params[] = {startIndex,pageSize};
			return (List<SiteVo>) qr.query(sql, params, new BeanListHandler(SiteVo.class));
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	/**
	 * ��ȡ���ݿ��г��ص��ܼ�¼��
	 * @return
	 */
	public int getTotalRecord(){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select count(*) from tb_site";
			long l = (Long) qr.query(sql, new ScalarHandler());
			return (int) l;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * ��û������ݸ��޸ĳ���ʹ��
	 * @param id
	 * @return
	 */
	public Site getSiteDetailById(int id){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select * from tb_site where id=?";
			return (Site) qr.query(sql, id, new BeanHandler(Site.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * ��ɾ���ĳ��ش����ݿ��лָ�
	 * @param id
	 */
	public void recoverSite(int id){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "update tb_site set statue='undeleted' where id=?";
			qr.update(sql, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * ����ɾ������
	 * @param id
	 */
	public void removeSite(int id){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "delete from tb_site where id=?";
			qr.update(sql, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * ģ����ѯ������
	 * @param name
	 * @param typeId
	 * @param statue
	 * @return
	 */
	public List<SiteVo> querySite(String name,String type,String statue,int startIndex,int pageSize){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select tb_site.*,tb_sitetype.type from tb_site,tb_sitetype where tb_site.name like ? and tb_sitetype.type like ? and tb_site.statue like ? and tb_site.typeId=tb_sitetype.id limit ?,?";
			Object params[] = {"%"+name+"%","%"+type+"%",statue+"%",startIndex,pageSize};
			return (List<SiteVo>)qr.query(sql, params, new BeanListHandler(SiteVo.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * ���ģ����ѯ���ܼ�¼��
	 * @param name
	 * @param type
	 * @param statue
	 * @return
	 */
	public int getQueryResultTotalRecord(String name,String type,String statue){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select count(*) from tb_site,tb_sitetype where tb_site.name like ? and tb_sitetype.type like ? and tb_site.statue like ? and tb_site.typeId=tb_sitetype.id";
			Object params[] = {"%"+name+"%","%"+type+"%",statue+"%"};
			long l = (Long)qr.query(sql, params, new ScalarHandler());
			return (int) l;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * ����ָ���������͵ĳ���
	 * @param siteTypeId
	 * @return
	 */
	public List<Site> getSiteBySiteTypeId(int typeId){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select * from tb_site where typeId=?";
			return (List<Site>) qr.query(sql, typeId, new BeanListHandler(Site.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}
}
