package com.gms.service.impl;

import java.util.Date;
import java.util.List;

import com.gms.dao.SiteDAO;
import com.gms.dao.SiteOrderDAO;
import com.gms.dao.SiteTypeDAO;
import com.gms.dao.SiteUsageDAO;
import com.gms.domain.Page;
import com.gms.domain.Site;
import com.gms.domain.SiteOrder;
import com.gms.domain.SiteType;
import com.gms.domain.SiteUsage;
import com.gms.factory.DAOFactory;
import com.gms.vo.SiteOrderVo;
import com.gms.vo.SiteUsageVo;
import com.gms.vo.SiteVo;

public class SiteBusinessServiceImpl {

	DAOFactory daoFactory = DAOFactory.getInstance();
	private SiteDAO siteDAO = daoFactory.createDAO("com.gms.dao.impl.SiteDAOImpl");
	private SiteTypeDAO siteTypeDAO = daoFactory.createDAO("com.gms.dao.impl.SiteTypeDAOImpl");
	private SiteOrderDAO siteOrderDAO= daoFactory.createDAO("com.gms.dao.impl.SiteOrderDAOImpl");
	private SiteUsageDAO siteUsageDAO= daoFactory.createDAO("com.gms.dao.impl.SiteUsageDAOImpl");
	
	/**
	 * 添加场地类型
	 * @param siteType
	 */
	public void addSiteType(SiteType siteType){
		siteTypeDAO.addType(siteType);
	}
	/**
	 * 更新场地类型
	 * @param siteType
	 */
	public void updateSiteType(SiteType siteType){
		siteTypeDAO.updateType(siteType);
	}
	/**
	 * 删除场地类型
	 * @param id
	 */
	public void deleteSiteType(int id){
		siteTypeDAO.deleteType(id);
	}
	/**
	 * 获取所有场地的类型
	 */
	public List<SiteType> getAllSiteType(){
		return siteTypeDAO.getAllSiteType();
	}
	/**
	 * 获取所有的场地
	 * 
	 * @param site
	 */
	public void addSite(Site site) {
		siteDAO.addSite(site);
	}

	/**
	 * 更新场地详情
	 * 
	 * @param site
	 */
	public void updateSte(Site site) {
		siteDAO.updateSite(site);
	}

	/**
	 * 删除场地
	 * 
	 * @param id
	 */
	public void deleteSite(int id) {
		siteDAO.deleteSite(id);
	}

	/**
	 * 获取所哟的场地
	 */
	public List<Site> getAllSite() {
		return siteDAO.getAllSite();
	}
	/**
	 * 根据id查找场地
	 * @param id
	 * @return
	 */
	public SiteType getSiteTypeById(int id){
		return siteTypeDAO.getSiteTypeById(id);
	}
	/**
	 * 
	 * @param pageNum
	 * @return
	 */
	public Page getSitePageData(int pageNum,int pageSize ){
		int totalRecord = siteDAO.getTotalRecord();
		Page page = new Page(pageSize, pageNum, totalRecord);
		List<SiteVo> list = siteDAO.getSitePageData(page.getStartIndex(), pageSize);
		page.setList(list);
		return page;
	}
	/**
	 * 获得回想数据给修改场地使用
	 * @param id
	 * @return
	 */
	public Site getSiteDetailById(int id){
		return siteDAO.getSiteDetailById(id);
	}
	/**
	 * 将删除的场地从数据库中恢复
	 * @param id
	 */
	public  void recoverSite(int id){
		siteDAO.recoverSite(id);
	}
	/**
	 * 彻底删除场地
	 * @param id
	 */
	public void removeSite(int id){
		siteDAO.removeSite(id);
	}
	/**
	 * 增加场地预约
	 */
	public void addSiteOrder(SiteOrder siteOrder){
		siteOrderDAO.addSiteOrder(siteOrder);
	}
	/**
	 * 管理员预留场地
	 */
	public void reserveSiteOrder(SiteOrder siteOrder){
		siteOrderDAO.reserveSiteOrder(siteOrder);
	}
	/**
	 * 获得所有的预留信息
	 * @return
	 */
	public Page getAllReserveSiteOrderPageDate(int pageNum,int pageSize){
		int totalRecord = siteOrderDAO.getReserveSiteOrderTotalRecord();
		Page page = new Page(pageSize, pageNum, totalRecord);
		List<SiteOrderVo> list = siteOrderDAO.getAllReserveSiteOrder(page.getStartIndex(), pageSize);
		page.setList(list);
		return page;
	}
	/**
	 * 删除场地预约
	 * 
	 * @param id
	 */
	public void deleteSiteOrder(int id) {
		siteOrderDAO.deleteSiteOrder(id);
	}
	/**
	 * 修改场地预约
	 * 
	 * @param siteOrder
	 */
	public void updateSiteOrder(SiteOrder siteOrder) {
		siteOrderDAO.updateSiteOrder(siteOrder);
	}
	/**
	 * 更新场地预留
	 * @param siteOrder
	 */
	public void updateReserveSiteOrder(SiteOrder siteOrder){
		siteOrderDAO.updateReserveSiteOrder(siteOrder);
	}
	/**
	 * 获取所有的场地预约
	 * 
	 * @return
	 */
	public List<SiteOrder> getAllSiteOrder() {
		return siteOrderDAO.getAllSiteOrder();
	}
	/**
	 * 获得用户的所有的场地预约
	 * 
	 * @param userId
	 * @return
	 */
	public List<SiteOrderVo> getSiteOrderByUserId(int userId){
		return siteOrderDAO.getSiteOrderByUserId(userId);
	}
	/**
	 * 根据预约的状态查找场地预约
	 * 
	 * @param statue
	 * @return
	 */
	public List<SiteOrder> getSiteOrderByStaue(String statue) {
		return siteOrderDAO.getSiteOrderByStaue(statue);
	}
	/**
	 * 获得分页数据
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public Page getSiteOrderPageDate(int pageNum,int pageSize){
		int totalRecord = siteOrderDAO.getTotalRecord();
		Page page = new Page(pageSize, pageNum, totalRecord);
		List<SiteOrderVo> list = siteOrderDAO.getSiteOrderPageData(page.getStartIndex(), pageSize);
		page.setList(list);
		return page;
	}
	
	/**
	 * 根据id查找预约
	 * @param id
	 * @return
	 */
	public SiteOrder getsiteOrderById(int id){
		return siteOrderDAO.getsiteOrderById(id);
	}
	/**
	 * 模糊查询出场地
	 * @param name
	 * @param typeId
	 * @param statue
	 * @return
	 */
	public Page querySite(String name,String type,String statue,int pageNum,int pageSize){
		if("none".equals(type)){
			type="";
		}
		if("none".equals(statue)){
			statue="";
		}
		int totalRecord = siteDAO.getQueryResultTotalRecord(name, type, statue);
		Page page = new Page(pageSize, pageNum, totalRecord);
		List<SiteVo> list = siteDAO.querySite(name, type, statue,page.getStartIndex(),pageSize);
		page.setList(list);
		return page;
	}
	/**
	 * 获取当前预约
	 * @return
	 */
	public Page getCurrentSiteOrder(int pageNum,int pageSize){
		int totalRecord = siteOrderDAO.getCurrentSiteOrderTotalRecord();
		Page page = new Page(pageSize, pageNum, totalRecord);
		List<SiteOrderVo> list = siteOrderDAO.getCurrentSiteOrder(page.getStartIndex(), pageSize);
		page.setList(list);
		return page;
	}
	
	/**
	 * 处理过期预约，提前10分钟到
	 */
	public int dealBreach(){
		return siteOrderDAO.dealBreach();
	}
	
	/**
	 * 查询场地预约
	 * @param sitename
	 * @param username
	 * @param statue
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public Page querySiteOrderResultPageData(String sitename,String username,String statue,int pageNum,int pageSize){
		if("none".equals(statue)){
			statue="";
		}
		int totalRecord = siteOrderDAO.getQueryResultTotalRecord(sitename, username, statue);
		Page page = new Page(pageSize, pageNum, totalRecord);
		List<SiteOrderVo> list = siteOrderDAO.querySiteOrderPageDate(sitename, username, statue, page.getStartIndex(), page.getPageSize());
		page.setList(list);
		return page;
	}
	
	/**
	 * 
	 * @param sitename
	 * @param username
	 * @param statue
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public Page getQueryCurrentSiteOrderPage(String sitename,String username,String statue,int pageNum,int pageSize){
		if("none".equals(statue)){
			statue="";
		}
		
		int totalRecord = siteOrderDAO.getQueryCurrentSiteOrderTotalRecord(sitename, username, statue);
		Page page = new Page(pageSize, pageNum, totalRecord);
		List<SiteOrderVo> list = siteOrderDAO.getQueryCurrentSiteOrder(sitename, username, statue, page.getStartIndex(), pageSize);
		page.setList(list);
		return page;
	}
	
	/**
	 * 增加场地使用
	 * @param siteUsage
	 */
	public void addSiteUsage(SiteUsage siteUsage){
		siteUsageDAO.addSiteUsage(siteUsage);
	}
	/**
	 * 删除场地使用
	 * @param id
	 */
	public void deleteSiteUsage(int id){
		siteUsageDAO.deleteSiteUsageById(id);
	}
	/**
	 * 删除所有的场地使用
	 */
	public void deleteAllSiteUsage(){
		siteUsageDAO.deleteAllPassedSiteUsage();
	}
	/**
	 * 获得当前场地使用的使用情况
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public Page getAllSiteUsagePageData(int pageNum,int pageSize){
		int totalRecord = siteUsageDAO.getCurrentSiteUsageTotalRecord();
		Page page = new Page(pageSize, pageNum, totalRecord);
		List<SiteUsageVo> list = siteUsageDAO.getAllCurrentSiteUsage(page.getStartIndex(),page.getPageSize());
		page.setList(list);
		return page;
	}
	/**
	 * 更新场地使用的信息
	 * @param siteUsage
	 */
	public void updateSiteUsage(SiteUsage siteUsage){
		siteUsageDAO.updateSiteUsage(siteUsage);
	}
	/**
	 * 查询是否存在规定时间段的场地预约
	 * @param stratTime
	 * @param endTime
	 * @param siteId
	 * @return
	 */
	public boolean getSiteOrderByTime(Date stratTime,Date endTime,int siteId){
		return siteOrderDAO.getSiteOrderByTime(stratTime, endTime, siteId);
	}
	/**
	 * 查找指定场地类型的场地
	 * @param siteTypeId
	 * @return
	 */
	public List<Site> getSiteBySiteTypeId(int typeId){
		return siteDAO.getSiteBySiteTypeId(typeId);
	}
	/**
	 * 获得指定时间段的场地使用
	 * @param stratTime
	 * @param endTime
	 * @param siteId
	 * @return 
	 */
	public boolean getSiteUsageByTime(Date stratTime,Date endTime,int siteId){
		return siteUsageDAO.getSiteUsageByTime(stratTime, endTime, siteId);
	}
	
	/**
	 * 根据id过得场地使用信息
	 * @param id
	 * @return
	 */
	public SiteUsage getSiteUsageById(int id){
		return siteUsageDAO.getSiteUsageById(id);
	}
	/**
	 * 处理时间到的场地使用
	 * @return
	 */
	public int dealTimeOutSiteUsage(){
		return siteUsageDAO.dealTimeOutSiteUsage();
	}
	/**
	 * 删除所有超时的场地使用信息
	 * @return
	 */
	public int deleteAllTimeOutSiteUsage(){
		return siteUsageDAO.deleteAllTimeOutSiteUsage();
	}
	
	/**
	 * 查询场地使用信息
	 * @param sitename
	 * @param username
	 * @param statue
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public Page querySiteUsage(String sitename,String username,String statue,int pageNum,int pageSize){
		if("none".equals(statue)){
			statue="";
		}
		int totalRecord = siteUsageDAO.getQuerySiteUsageTotalRecord(sitename, username, statue);
		Page page = new Page(pageSize, pageNum, totalRecord);
		List<SiteUsageVo> list = siteUsageDAO.querySiteUsage(sitename, username, statue, page.getStartIndex(), pageSize);
		page.setList(list);
		return page;
	}
	
	/**
	 * 查找场地预约
	 * @param sitename
	 * @param statue
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public Page queryReserveSiteOrderPageDate(String sitename,String statue,int pageNum,int pageSize){
		if("none".equals(statue)){
			statue="";
		}
		int totalRecord = siteOrderDAO.getQueryReserveSiteOrderTotalRecord(sitename, statue);
		Page page = new Page(pageSize, pageNum, totalRecord);
		List<SiteOrderVo> list = siteOrderDAO.queryReserveSiteOrder(sitename, statue, page.getStartIndex(), pageSize);
		page.setList(list);
		return page;
	}
	
	/**
	 * 处理过期预留，提前10分钟到
	 */
	public int dealPassed(){
		return siteOrderDAO.dealPassed();
	}
}
