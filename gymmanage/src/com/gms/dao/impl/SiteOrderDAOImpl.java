package com.gms.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
			String sql = "update tb_siteorder set userId=?,stratTime=?,endTime=?,siteId=? ,statue=? where id=?";
			Object params[] = { siteOrder.getUserId(),siteOrder.getStratTime(),
					siteOrder.getEndTime(), siteOrder.getSiteId(),siteOrder.getStatue(),
					siteOrder.getId() };
			qr.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 更新场地预留
	 * @param siteOrder
	 */
	public void updateReserveSiteOrder(SiteOrder siteOrder){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "update tb_siteorder set stratTime=?,endTime=?,siteId=? ,statue=? where id=?";
			Object params[] = { siteOrder.getStratTime(),
					siteOrder.getEndTime(), siteOrder.getSiteId(),siteOrder.getStatue(),
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
			String sql = "select * from tb_siteorder order by orderTime desc";
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
			String sql = "select tb_siteorder.*,tb_user.studentNo as studentNo ,tb_user.name as username,tb_site.name as sitename from tb_siteorder,tb_user,tb_site where tb_site.id=tb_siteorder.siteid and tb_user.id=tb_siteorder.userId  order by orderTime desc limit ?,?";
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
	
	/**
	 * 获取当前预约
	 * @return
	 */
	public List<SiteOrderVo> getCurrentSiteOrder(int startIndex,int pageSize){
		try {
			Date currentDate = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String date = sdf.format(currentDate);
			Date today = sdf.parse(date);
			Date tomorrow = new Date(today.getTime()+24*60*60*1000);
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource()); 
			String sql = "select tb_siteorder.*,tb_user.studentNo as studentNo ,tb_user.name as username,tb_site.name as sitename from tb_siteorder,tb_user,tb_site where tb_site.id=tb_siteorder.siteid and tb_user.id=tb_siteorder.userId and stratTime>? and endTime<? limit ?,?";
			Object params[] = {today,tomorrow,startIndex,pageSize};
			return (List<SiteOrderVo>)qr.query(sql, params, new BeanListHandler(SiteOrderVo.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 处理过期预约，提前10分钟到
	 */
	public int dealBreach(){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			
			Date date = new Date();
			Date passedTime = new Date(date.getTime()+10*60*1000);
			String sql1 = "select count(*) from tb_siteOrder where stratTime<? and statue='unpassed' and userId is not null ";
			Object params[] = {passedTime};
			long l =(Long) qr.query(sql1, params, new ScalarHandler());
			String sql2 = "update tb_siteorder set statue='passed' where stratTime<? and statue='unpassed' and userId is not null";
			qr.update(sql2, params);
			return (int)l;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 处理过期预留，提前10分钟到
	 */
	public int dealPassed(){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			Date date = new Date();
			Date passedTime = new Date(date.getTime()+10*60*1000);
			String sql1 = "select count(*) from tb_siteOrder where stratTime<? and statue='unpassed' and userId is  null ";
			Object params[] = {passedTime};
			long l =(Long) qr.query(sql1, params, new ScalarHandler());
			String sql2 = "update tb_siteorder set statue='passed' where stratTime<? and statue='unpassed' and userId is  null";
			qr.update(sql2, params);
			return (int)l;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * 查询场地预约信息
	 * @param sitename
	 * @param username
	 * @param statue
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List<SiteOrderVo> querySiteOrderPageDate(String sitename,String username,String statue, int startIndex,int pageSize){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select tb_siteorder.*,tb_user.studentNo as studentNo ,tb_user.name as username,tb_site.name as sitename from tb_siteorder,tb_user,tb_site where tb_site.id=tb_siteorder.siteid and tb_user.id=tb_siteorder.userId and tb_site.name like ? and tb_user.name like ? AND tb_siteOrder.statue like ? limit ?,?";
			Object params[] = {"%"+sitename+"%","%"+username+"%",statue+"%",startIndex,pageSize};
			return (List<SiteOrderVo>)qr.query(sql, params, new BeanListHandler(SiteOrderVo.class));
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
	public int getQueryResultTotalRecord(String sitename,String username,String statue){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select count(*) from tb_siteorder,tb_user,tb_site where tb_site.id=tb_siteorder.siteid and tb_user.id=tb_siteorder.userId and tb_site.name like ? and tb_user.name like ? AND tb_siteOrder.statue like ?";
			Object params[] = {"%"+sitename+"%","%"+username+"%",statue+"%"};
			long l = (Long) qr.query(sql, params,new ScalarHandler());
			return (int) l;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 查询场地预留信息
	 * @param sitename
	 * @param username
	 * @param statue
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List<SiteOrderVo> queryReserveSiteOrder(String sitename,String statue, int startIndex,int pageSize){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select tb_siteorder.* ,tb_site.name as sitename from tb_siteOrder,tb_site  where  tb_site.id=tb_siteorder.siteid and userId is null and tb_site.name like ? and tb_siteorder.statue like ? limit ?,?";
			Object params[] = {"%"+sitename+"%",statue+"%",startIndex,pageSize};
			return (List<SiteOrderVo>)qr.query(sql, params, new BeanListHandler(SiteOrderVo.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * 获得查询场地预留的总记录数
	 * @param sitename
	 * @param username
	 * @param statue
	 * @return
	 */
	public int getQueryReserveSiteOrderTotalRecord(String sitename,String statue){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select count(*) from tb_siteOrder,tb_site  where  tb_site.id=tb_siteorder.siteid and userId is null and tb_site.name like ? and tb_siteorder.statue like ? ";
			Object params[] = {"%"+sitename+"%",statue+"%"};
			long l = (Long) qr.query(sql, params,new ScalarHandler());
			return (int) l;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 获得查询今天的总预约的总记录数
	 * @param sitename
	 * @param username
	 * @param statue
	 * @return
	 */
	public int getCurrentSiteOrderTotalRecord(){
		try {
			Date currentDate = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String date = sdf.format(currentDate);
			Date today = sdf.parse(date);
			Date tomorrow = new Date(today.getTime()+24*60*60*1000);
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource()); 
			String sql = "select count(*) from tb_siteorder,tb_user,tb_site where tb_site.id=tb_siteorder.siteid and tb_user.id=tb_siteorder.userId and stratTime>? and endTime<?";
			Object params[] = {today,tomorrow};
			long l =  (Long)qr.query(sql, params, new ScalarHandler());
			return (int)l;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 条件查询当前的场地预约
	 * @param sitename
	 * @param username
	 * @param statue
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List<SiteOrderVo> getQueryCurrentSiteOrder(String sitename,String username,String statue,int startIndex,int pageSize){
		try {
			Date currentDate = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String date = sdf.format(currentDate);
			Date today = sdf.parse(date);
			Date tomorrow = new Date(today.getTime()+24*60*60*1000);
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource()); 
			String sql = "select tb_siteorder.*,tb_user.studentNo as studentNo ,tb_user.name as username,tb_site.name as sitename from tb_siteorder,tb_user,tb_site where tb_site.id=tb_siteorder.siteid and tb_user.id=tb_siteorder.userId and stratTime>? and endTime<? and tb_site.name like ? and tb_user.name like ? AND tb_siteOrder.statue like ? limit ?,?";
			Object params[] = {today,tomorrow,"%"+sitename+"%","%"+username+"%",statue+"%",startIndex,pageSize};
			return (List<SiteOrderVo>)qr.query(sql, params, new BeanListHandler(SiteOrderVo.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 获得查询当前预约的总记录数
	 * @param sitename
	 * @param username
	 * @param statue
	 * @return
	 */
	public int getQueryCurrentSiteOrderTotalRecord(String sitename,String username,String statue){
		try {
			Date currentDate = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String date = sdf.format(currentDate);
			Date today = sdf.parse(date);
			Date tomorrow = new Date(today.getTime()+24*60*60*1000);
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource()); 
			String sql = "select count(*) from tb_siteorder,tb_user,tb_site where tb_site.id=tb_siteorder.siteid and tb_user.id=tb_siteorder.userId and stratTime>? and endTime<? and tb_site.name like ? and tb_user.name like ? AND tb_siteOrder.statue like ?";
			Object params[] = {today,tomorrow,"%"+sitename+"%","%"+username+"%",statue+"%"};
			long l = (Long)qr.query(sql, params, new ScalarHandler());
			return (int)l;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 *  查询是否存在规定时间段的场地预约
	 * @param stratTime
	 * @param endTime
	 * @param siteId
	 * @return
	 */
	public boolean getSiteOrderByTime(Date stratTime,Date endTime,int siteId){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select * from tb_siteorder where (?>=stratTime and ?<=endTime) or (?=stratTime and ?<=endTime) and siteId=?";
			Object params[] = {stratTime,stratTime,endTime,endTime,siteId};
			List<SiteOrder> list = (List<SiteOrder>)qr.query(sql, params, new BeanListHandler(SiteOrder.class));
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
	 * 管理员预留场地
	 */
	public void reserveSiteOrder(SiteOrder siteOrder){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "insert into tb_siteorder(stratTime,endTime,siteId,Statue,orderTime) values(?,?,?,?,?)";
			Object params[] = {siteOrder.getStratTime(),siteOrder.getEndTime(),siteOrder.getSiteId(),siteOrder.getStatue(),siteOrder.getOrderTime()};
			qr.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


	/**
	 * 获得所有的预留信息
	 * @return
	 */
	public List<SiteOrderVo> getAllReserveSiteOrder(int startIndex,int pageSize){
		try{
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select tb_siteorder.* ,tb_site.name as sitename from tb_siteOrder,tb_site  where  tb_site.id=tb_siteorder.siteid and userId is null limit ?,?";
			Object params[] = {startIndex,pageSize};
			return (List<SiteOrderVo>) qr.query(sql, params,new BeanListHandler(SiteOrderVo.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 获得预留场地的总记录数
	 * @return
	 */
	public int getReserveSiteOrderTotalRecord(){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select count(*) from tb_siteOrder where userId is null";
			long l = (Long)qr.query(sql,new ScalarHandler());
			return (int)l;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}