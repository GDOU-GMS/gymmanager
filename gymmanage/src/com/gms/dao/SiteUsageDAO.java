package com.gms.dao;

import java.util.List;

import com.gms.domain.SiteUsage;
import com.gms.vo.SiteUsageVo;

public interface SiteUsageDAO {

	/**
	 * ���ӳ���ʹ��
	 */
	public abstract void addSiteUsage(SiteUsage siteUsage);

	/**
	 * ����idɾ������ʹ��
	 * @param id
	 */
	public abstract void deleteSiteUsageById(int id);

	/**
	 *ɾ�����й��ڵĳ���ʹ��
	 */
	public abstract void deleteAllPassedSiteUsage();

	/**
	 * ������еĳ���ʹ�����
	 * @return
	 */
	public abstract List<SiteUsageVo> getAllCurrentSiteUsage(int startIndex,int pageSize);
	/**
	 * ������ݿ��ܼ�¼��
	 * @return
	 */
	public abstract int getCurrentSiteUsageTotalRecord();
	/**
	 * ���³���ʹ��
	 */
	public abstract void updateSiteUsage(SiteUsage siteUsage);

}