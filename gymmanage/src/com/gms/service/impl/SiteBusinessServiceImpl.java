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
	 * ��ӳ�������
	 * @param siteType
	 */
	public void addSiteType(SiteType siteType){
		siteTypeDAO.addType(siteType);
	}
	/**
	 * ���³�������
	 * @param siteType
	 */
	public void updateSiteType(SiteType siteType){
		siteTypeDAO.updateType(siteType);
	}
	/**
	 * ɾ����������
	 * @param id
	 */
	public void deleteSiteType(int id){
		siteTypeDAO.deleteType(id);
	}
	/**
	 * ��ȡ���г��ص�����
	 */
	public List<SiteType> getAllSiteType(){
		return siteTypeDAO.getAllSiteType();
	}
	/**
	 * ��ȡ���еĳ���
	 * 
	 * @param site
	 */
	public void addSite(Site site) {
		siteDAO.addSite(site);
	}

	/**
	 * ���³�������
	 * 
	 * @param site
	 */
	public void updateSte(Site site) {
		siteDAO.updateSite(site);
	}

	/**
	 * ɾ������
	 * 
	 * @param id
	 */
	public void deleteSite(int id) {
		siteDAO.deleteSite(id);
	}

	/**
	 * ��ȡ��Ӵ�ĳ���
	 */
	public List<Site> getAllSite() {
		return siteDAO.getAllSite();
	}
	/**
	 * ����id���ҳ���
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
	 * ��û������ݸ��޸ĳ���ʹ��
	 * @param id
	 * @return
	 */
	public Site getSiteDetailById(int id){
		return siteDAO.getSiteDetailById(id);
	}
	/**
	 * ��ɾ���ĳ��ش����ݿ��лָ�
	 * @param id
	 */
	public  void recoverSite(int id){
		siteDAO.recoverSite(id);
	}
	/**
	 * ����ɾ������
	 * @param id
	 */
	public void removeSite(int id){
		siteDAO.removeSite(id);
	}
	/**
	 * ���ӳ���ԤԼ
	 */
	public void addSiteOrder(SiteOrder siteOrder){
		siteOrderDAO.addSiteOrder(siteOrder);
	}
	/**
	 * ����ԱԤ������
	 */
	public void reserveSiteOrder(SiteOrder siteOrder){
		siteOrderDAO.reserveSiteOrder(siteOrder);
	}
	/**
	 * ������е�Ԥ����Ϣ
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
	 * ɾ������ԤԼ
	 * 
	 * @param id
	 */
	public void deleteSiteOrder(int id) {
		siteOrderDAO.deleteSiteOrder(id);
	}
	/**
	 * �޸ĳ���ԤԼ
	 * 
	 * @param siteOrder
	 */
	public void updateSiteOrder(SiteOrder siteOrder) {
		siteOrderDAO.updateSiteOrder(siteOrder);
	}
	/**
	 * ���³���Ԥ��
	 * @param siteOrder
	 */
	public void updateReserveSiteOrder(SiteOrder siteOrder){
		siteOrderDAO.updateReserveSiteOrder(siteOrder);
	}
	/**
	 * ��ȡ���еĳ���ԤԼ
	 * 
	 * @return
	 */
	public List<SiteOrder> getAllSiteOrder() {
		return siteOrderDAO.getAllSiteOrder();
	}
	/**
	 * ����û������еĳ���ԤԼ
	 * 
	 * @param userId
	 * @return
	 */
	public List<SiteOrderVo> getSiteOrderByUserId(int userId){
		return siteOrderDAO.getSiteOrderByUserId(userId);
	}
	/**
	 * ����ԤԼ��״̬���ҳ���ԤԼ
	 * 
	 * @param statue
	 * @return
	 */
	public List<SiteOrder> getSiteOrderByStaue(String statue) {
		return siteOrderDAO.getSiteOrderByStaue(statue);
	}
	/**
	 * ��÷�ҳ����
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
	 * ����id����ԤԼ
	 * @param id
	 * @return
	 */
	public SiteOrder getsiteOrderById(int id){
		return siteOrderDAO.getsiteOrderById(id);
	}
	/**
	 * ģ����ѯ������
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
	 * ��ȡ��ǰԤԼ
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
	 * �������ԤԼ����ǰ10���ӵ�
	 */
	public int dealBreach(){
		return siteOrderDAO.dealBreach();
	}
	
	/**
	 * ��ѯ����ԤԼ
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
	 * ���ӳ���ʹ��
	 * @param siteUsage
	 */
	public void addSiteUsage(SiteUsage siteUsage){
		siteUsageDAO.addSiteUsage(siteUsage);
	}
	/**
	 * ɾ������ʹ��
	 * @param id
	 */
	public void deleteSiteUsage(int id){
		siteUsageDAO.deleteSiteUsageById(id);
	}
	/**
	 * ɾ�����еĳ���ʹ��
	 */
	public void deleteAllSiteUsage(){
		siteUsageDAO.deleteAllPassedSiteUsage();
	}
	/**
	 * ��õ�ǰ����ʹ�õ�ʹ�����
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
	 * ���³���ʹ�õ���Ϣ
	 * @param siteUsage
	 */
	public void updateSiteUsage(SiteUsage siteUsage){
		siteUsageDAO.updateSiteUsage(siteUsage);
	}
	/**
	 * ��ѯ�Ƿ���ڹ涨ʱ��εĳ���ԤԼ
	 * @param stratTime
	 * @param endTime
	 * @param siteId
	 * @return
	 */
	public boolean getSiteOrderByTime(Date stratTime,Date endTime,int siteId){
		return siteOrderDAO.getSiteOrderByTime(stratTime, endTime, siteId);
	}
	/**
	 * ����ָ���������͵ĳ���
	 * @param siteTypeId
	 * @return
	 */
	public List<Site> getSiteBySiteTypeId(int typeId){
		return siteDAO.getSiteBySiteTypeId(typeId);
	}
	/**
	 * ���ָ��ʱ��εĳ���ʹ��
	 * @param stratTime
	 * @param endTime
	 * @param siteId
	 * @return 
	 */
	public boolean getSiteUsageByTime(Date stratTime,Date endTime,int siteId){
		return siteUsageDAO.getSiteUsageByTime(stratTime, endTime, siteId);
	}
	
	/**
	 * ����id���ó���ʹ����Ϣ
	 * @param id
	 * @return
	 */
	public SiteUsage getSiteUsageById(int id){
		return siteUsageDAO.getSiteUsageById(id);
	}
	/**
	 * ����ʱ�䵽�ĳ���ʹ��
	 * @return
	 */
	public int dealTimeOutSiteUsage(){
		return siteUsageDAO.dealTimeOutSiteUsage();
	}
	/**
	 * ɾ�����г�ʱ�ĳ���ʹ����Ϣ
	 * @return
	 */
	public int deleteAllTimeOutSiteUsage(){
		return siteUsageDAO.deleteAllTimeOutSiteUsage();
	}
	
	/**
	 * ��ѯ����ʹ����Ϣ
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
	 * ���ҳ���ԤԼ
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
	 * �������Ԥ������ǰ10���ӵ�
	 */
	public int dealPassed(){
		return siteOrderDAO.dealPassed();
	}
}
