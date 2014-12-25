package com.gms.dao;

import java.util.List;

import com.gms.domain.Site;
import com.gms.vo.SiteOrderVo;
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
	/**
	 * 将删除的场地从数据库中恢复
	 * @param id
	 */
	public void recoverSite(int id);
	/**
	 * 彻底删除场地
	 * @param id
	 */
	public abstract void removeSite(int id);
	
	/**
	 * 模糊查询出场地
	 * @param name
	 * @param typeId
	 * @param statue
	 * @return
	 */
	public  List<SiteVo> querySite(String name,String type,String statue,int startIndex,int pageSize);
	/**
	 * 获得模糊查询的总记录数
	 * @param name
	 * @param type
	 * @param statue
	 * @return
	 */
	public abstract int getQueryResultTotalRecord(String name,String type,String statue);

	
}