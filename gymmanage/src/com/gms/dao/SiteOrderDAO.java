package com.gms.dao;

import java.util.List;

import com.gms.domain.SiteOrder;

public interface SiteOrderDAO {

	/**
	 * ����һ������ԤԼ
	 * @param siteOrder
	 */
	public abstract void addSiteOrder(SiteOrder siteOrder);

	/**
	 * ɾ������ԤԼ
	 * @param id
	 */
	public abstract void deleteSiteOrder(int id);

	/**
	 * �޸ĳ���ԤԼ
	 * @param siteOrder
	 */
	public abstract void updateSiteOrder(SiteOrder siteOrder);

	/**
	 * ��ȡ���еĳ���ԤԼ
	 * @return
	 */
	public abstract List<SiteOrder> getAllSiteOrder();

	/**
	 * ����û������еĳ���ԤԼ
	 * @param userId
	 * @return
	 */
	public abstract List<SiteOrder> getSiteOrderByUserId(int userId);

	/**
	 * ����ԤԼ��״̬���ҳ���ԤԼ
	 * @param statue
	 * @return
	 */
	public abstract List<SiteOrder> getSiteOrderByStaue(String statue);
	/**
	 * ��ȡ����ʧԼ�ĳ���ԤԼ
	 */

}