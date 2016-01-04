package com.gms.dao;

import java.util.Date;
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
	
	/**
	 * ���ָ��ʱ��εĳ���ʹ��
	 * @param stratTime
	 * @param endTime
	 * @param siteId
	 * @return 
	 */
	public abstract boolean getSiteUsageByTime(Date stratTime,Date endTime,int siteId);
	/**
	 * ����id���ó���ʹ����Ϣ
	 * @param id
	 * @return
	 */
	public abstract SiteUsage getSiteUsageById(int id);
	/**
	 * ����ʱ�䵽�ĳ���ʹ��
	 * @return
	 */
	public  int dealTimeOutSiteUsage();
	/**
	 * ɾ�����г�ʱ�ĳ���ʹ��
	 * @return
	 */
	public abstract int deleteAllTimeOutSiteUsage();
	
	/**
	 * ��ѯ����ʹ�����
	 * @param sitename
	 * @param username
	 * @param statue
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public abstract List<SiteUsageVo> querySiteUsage(String sitename,String username,String statue,int startIndex,int pageSize);
	
	/**
	 * ��ò�ѯ������ܼ�¼��
	 * @param sitename
	 * @param username
	 * @param statue
	 * @return
	 */
	public abstract int getQuerySiteUsageTotalRecord(String sitename,String username,String statue);
	
}