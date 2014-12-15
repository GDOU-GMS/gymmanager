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
	/**
	 * 获得场地的分页数据
	 * @param beginIndex
	 * @param pageSize
	 * @return
	 */
	public List<SiteVo> getSitePageData(int startIndex,int pageSize){
		try{
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select tb_site.*,tb_sitetype.type from tb_site,tb_sitetype where tb_site.typeid=tb_sitetype.id order by typeId limit ?,?";
			Object params[] = {startIndex,pageSize};
			return (List<SiteVo>) qr.query(sql, params, new BeanListHandler(SiteVo.class));
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	/**
	 * 获取数据库中场地的总记录数
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
	 * 获得回想数据给修改场地使用
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
	
}
