package com.gms.dao;

import java.util.List;

import com.gms.domain.Site;
import com.gms.vo.SiteOrderVo;
import com.gms.vo.SiteVo;

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
	public abstract List<Site> getAllUndeletedSite();
	/**
	 * ��ó��صķ�ҳ����
	 * @param beginIndex
	 * @param pageSize
	 * @return
	 */
	public abstract List<SiteVo> getSitePageData(int beginIndex,int pageSize);
	/**
	 * ��ȡ���ݿ��г��ص��ܼ�¼��
	 * @return
	 */
	public abstract int getTotalRecord();
	/**
	 * ��û������ݸ��޸ĳ���ʹ��
	 * @param id
	 * @return
	 */
	public abstract Site getSiteDetailById(int id);
	/**
	 * ��ɾ���ĳ��ش����ݿ��лָ�
	 * @param id
	 */
	public void recoverSite(int id);
	/**
	 * ����ɾ������
	 * @param id
	 */
	public abstract void removeSite(int id);
	
	/**
	 * ģ����ѯ������
	 * @param name
	 * @param typeId
	 * @param statue
	 * @return
	 */
	public  List<SiteVo> querySite(String name,String type,String statue,int startIndex,int pageSize);
	/**
	 * ���ģ����ѯ���ܼ�¼��
	 * @param name
	 * @param type
	 * @param statue
	 * @return
	 */
	public abstract int getQueryResultTotalRecord(String name,String type,String statue);
	/**
	 * ����ָ���������͵ĳ���
	 * @param siteTypeId
	 * @return
	 */
	public abstract List<Site> getSiteBySiteTypeId(int typeId);
	
}