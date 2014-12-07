package com.gms.service.impl;

import java.util.List;

import com.gms.dao.SiteDAO;
import com.gms.dao.SiteTypeDAO;
import com.gms.domain.Site;
import com.gms.domain.SiteType;
import com.gms.factory.DAOFactory;

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
	public void getAllSite() {
		siteDAO.getAllSite();
	}
	
	
}
