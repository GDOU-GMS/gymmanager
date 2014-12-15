package com.gms.dao;

import java.util.List;

import com.gms.domain.Site;
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
	public abstract List<Site> getAllSite();
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
}