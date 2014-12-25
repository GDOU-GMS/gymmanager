package com.gms.service.impl;

import java.util.List;

import com.gms.dao.SiteDAO;
import com.gms.dao.SiteOrderDAO;
import com.gms.dao.SiteTypeDAO;
import com.gms.domain.Page;
import com.gms.domain.Site;
import com.gms.domain.SiteOrder;
import com.gms.domain.SiteType;
import com.gms.factory.DAOFactory;
import com.gms.vo.SiteOrderVo;
import com.gms.vo.SiteVo;

public class SiteBusinessServiceImpl {

	DAOFactory daoFactory = DAOFactory.getInstance();
	private SiteDAO siteDAO = daoFactory.createDAO("com.gms.dao.impl.SiteDAOImpl");
	private SiteTypeDAO siteTypeDAO = daoFactory.createDAO("com.gms.dao.impl.SiteTypeDAOImpl");
	private SiteOrderDAO siteOrderDAO= daoFactory.createDAO("com.gms.dao.impl.SiteOrderDAOImpl");
	
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
	public List<SiteOrder> getSiteOrderByUserId(int userId){
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
	public List<SiteOrder> getCurrentSiteOrder(){
		return siteOrderDAO.getCurrentSiteOrder();
	}
	
	/**
	 * �������ԤԼ����ǰ10���ӵ�
	 */
	public int dealBreach(){
		return siteOrderDAO.dealBreach();
	}
}
