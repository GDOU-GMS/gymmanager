package com.gms.dao;

import java.util.List;

import com.gms.domain.Site;
import com.gms.vo.SiteVo;

public interface SiteDAO {

	/**
	 * 增加场地
	 * 
	 * @param site
	 */
	public abstract void addSite(Site site);

	/**
	 * 更新场地信息
	 * 
	 * @param site
	 */
	public abstract void updateSite(Site site);

	/**
	 * 删除场地
	 * 
	 * @param id
	 */
	public abstract void deleteSite(int id);

	/**
	 * 获得所有的场地
	 * 
	 * @return
	 */
	public abstract List<Site> getAllSite();
	/**
	 * 获得场地的分页数据
	 * @param beginIndex
	 * @param pageSize
	 * @return
	 */
	public abstract List<SiteVo> getSitePageData(int beginIndex,int pageSize);
	/**
	 * 获取数据库中场地的总记录数
	 * @return
	 */
	public abstract int getTotalRecord();
	/**
	 * 获得回想数据给修改场地使用
	 * @param id
	 * @return
	 */
	public abstract Site getSiteDetailById(int id);
}