package com.gms.service.impl;

import java.util.List;

import com.gms.dao.SiteDAO;
import com.gms.dao.SiteTypeDAO;
import com.gms.domain.Page;
import com.gms.domain.Site;
import com.gms.domain.SiteType;
import com.gms.factory.DAOFactory;
import com.gms.vo.SiteVo;

public class SiteBusinessServiceImpl {

	DAOFactory daoFactory = DAOFactory.getInstance();
	private SiteDAO siteDAO = daoFactory.createDAO("com.gms.dao.impl.SiteDAOImpl");
	private SiteTypeDAO siteTypeDAO = daoFactory.createDAO("com.gms.dao.impl.SiteTypeDAOImpl");

	
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
}
