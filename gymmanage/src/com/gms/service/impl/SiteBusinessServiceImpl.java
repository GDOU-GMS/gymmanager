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
import com.gms.vo.SiteVo;

public class SiteBusinessServiceImpl {

	DAOFactory daoFactory = DAOFactory.getInstance();
	private SiteDAO siteDAO = daoFactory.createDAO("com.gms.dao.impl.SiteDAOImpl");
	private SiteTypeDAO siteTypeDAO = daoFactory.createDAO("com.gms.dao.impl.SiteTypeDAOImpl");
	private SiteOrderDAO siteOrderDAO= daoFactory.createDAO("com.gms.dao.impl.SiteOrderDAOImpl");
	
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
	public List<SiteOrder> getSiteOrderByUserId(int userId){
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
}
