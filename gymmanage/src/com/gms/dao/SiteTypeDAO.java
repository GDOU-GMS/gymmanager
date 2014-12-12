package com.gms.dao;

import java.util.List;

import com.gms.domain.SiteType;

public interface SiteTypeDAO {

	/**
	 * ��ӳ�������
	 * @param siteType
	 */
	public abstract void addType(SiteType siteType);

	/**
	 *�޸ĳ�������
	 * @param siteType
	 */
	public abstract void updateType(SiteType siteType);

	/**
	 * ɾ����������
	 * @param id
	 */
	public abstract void deleteType(int id);

	/**
	 * ��ȡ���еĳ�������
	 * @return
	 */
	public abstract List<SiteType> getAllSiteType();

	/**
	 * ����id���ҳ���
	 * @param id
	 * @return
	 */
	public abstract SiteType getSiteTypeById(int id);
}