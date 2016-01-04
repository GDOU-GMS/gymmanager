package com.gms.dao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.gms.dao.SiteUsageDAO;
import com.gms.domain.SiteOrder;
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
			String sql = "select tb_siteusage.*,tb_site.name as sitename,tb_user.name as username,tb_user.studentNo as studentNo from tb_siteusage,tb_site,tb_user where tb_siteusage.siteId=tb_site.id and tb_siteusage.userId=tb_user.id order by endTime desc limit ?,?";
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
			String sql = "update tb_siteusage set stratTime=?,endTime=?,price=?,userId=?,siteId=?,statue=? where id=?";
			Object params[] = {siteUsage.getStratTime(),siteUsage.getEndTime(),siteUsage.getPrice(),siteUsage.getUserId(),siteUsage.getSiteId(),siteUsage.getStatue(),siteUsage.getId()};			
			qr.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	/**
	 * 获得指定时间段的场地使用
	 * @param stratTime
	 * @param endTime
	 * @param siteId
	 * @return 
	 */
	public boolean getSiteUsageByTime(Date stratTime,Date endTime,int siteId){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select * from tb_siteusage where (?>=stratTime and ?<=endTime) or (?=stratTime and ?<=endTime) and siteId=?";
			Object params[] = {stratTime,stratTime,endTime,endTime,siteId};
			List<SiteOrder> list = (List<SiteOrder>) qr.query(sql, params, new BeanListHandler(SiteOrder.class));
			if(list.isEmpty()){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 根据id过得场地使用信息
	 * @param id
	 * @return
	 */
	public SiteUsage getSiteUsageById(int id){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select * from tb_siteusage where id=?";
			return (SiteUsage) qr.query(sql, id, new BeanHandler(SiteUsage.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 处理时间到的场地使用
	 * @return
	 */
	public int dealTimeOutSiteUsage(){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "update tb_siteusage set statue='timeout' where endTime<? and statue='notimeout'";
			return qr.update(sql, new Date());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 删除所有超时的场地使用
	 * @return
	 */
	public int deleteAllTimeOutSiteUsage(){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "delete from tb_siteusage where statue='timeout'";
			return qr.update(sql);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 查询场地使用情况
	 * @param sitename
	 * @param username
	 * @param statue
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List<SiteUsageVo> querySiteUsage(String sitename,String username,String statue,int startIndex,int pageSize){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select tb_siteusage.*,tb_user.studentNo as studentNo ,tb_user.name as username,tb_site.name as sitename from tb_siteusage,tb_user,tb_site where tb_site.id=tb_siteusage.siteid and tb_user.id=tb_siteusage.userId and tb_site.name like ? and tb_user.name like ? AND tb_siteusage.statue like ? order by endTime desc limit ?,? ";
			Object params[] = {"%"+sitename+"%","%"+username+"%",statue+"%",startIndex,pageSize};
			return (List<SiteUsageVo>)qr.query(sql, params, new BeanListHandler(SiteUsageVo.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 获得查询结果的总记录数
	 * @param sitename
	 * @param username
	 * @param statue
	 * @return
	 */
	public int getQuerySiteUsageTotalRecord(String sitename,String username,String statue){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select count(*) from tb_siteusage,tb_user,tb_site where tb_site.id=tb_siteusage.siteid and tb_user.id=tb_siteusage.userId and tb_site.name like ? and tb_user.name like ? AND tb_siteusage.statue like ?";
			Object params[] = {"%"+sitename+"%","%"+username+"%",statue+"%"};
			long l = (Long)qr.query(sql, params, new ScalarHandler());
			return (int)l;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

