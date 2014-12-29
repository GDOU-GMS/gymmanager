package com.gms.dao;

import java.util.Date;
import java.util.List;

import com.gms.domain.Events;
import com.gms.vo.EventsVo;

public interface EventsDAO {

	/**
	 * 添加赛事
	 * @param events
	 */
	public abstract void addEvents(Events events);

	/**
	 * 删除赛事
	 * @param id
	 */
	public abstract void deleteEvents(int id);

	/**
	 * 更新赛事信息
	 * @param events
	 */
	public abstract void updateEvents(Events events);

	/**
	 * 根据id查找赛事
	 * @param id
	 * @return
	 */
	public abstract Events getEventsById(int id);

	/**
	 * 获得所有的赛事
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public abstract List<EventsVo> getAllEvents(int startIndex, int pageSize);

	/**
	 * 获得赛事在数据库中的总记录数
	 * @return
	 */
	public abstract int getAllEventsTotalRecord();

	/**
	 * 判断指定时间内有没有赛事
	 * @param startTime
	 * @param endTime
	 * @param siteId
	 * @return
	 */
	public abstract boolean getEventsByTime(Date startTime, Date endTime,
			int siteId);

	/**
	 * 查询赛事
	 * @param sitename
	 * @param staue
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public abstract List<EventsVo> queryEvents(String eventsname,String sitename, String statue,
			int startIndex, int pageSize);

	/**
	 * 获得查询结果的总记录数
	 * @param sitename
	 * @param statue
	 * @return
	 */
	public abstract int getQueryEventsTotalRecord(String eventsname,String sitename, String statue);

	/**
	 * 处理过期赛事
	 */
	public abstract int dealPassed();

}