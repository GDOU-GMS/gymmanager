package com.gms.dao;

import java.util.List;

import com.gms.domain.Site;

public interface SiteDAO {

	/**
	 * ���ӳ���
	 * 
	 * @param site
	 */
	public abstract void addSite(Site site);

	/**
	 * ���³�����Ϣ
	 * 
	 * @param site
	 */
	public abstract void updateSite(Site site);

	/**
	 * ɾ������
	 * 
	 * @param id
	 */
	public abstract void deleteSite(int id);

	/**
	 * ������еĳ���
	 * 
	 * @return
	 */
	public abstract List<Site> getAllSite();

}