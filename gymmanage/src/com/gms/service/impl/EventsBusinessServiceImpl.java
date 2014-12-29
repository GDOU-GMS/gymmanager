package com.gms.service.impl;

import java.util.Date;
import java.util.List;

import com.gms.dao.EventsDAO;
import com.gms.domain.Events;
import com.gms.domain.Page;
import com.gms.factory.DAOFactory;
import com.gms.vo.EventsVo;

public class EventsBusinessServiceImpl {

	EventsDAO eventsDAO = DAOFactory.getInstance().createDAO("com.gms.dao.impl.EventsDAOImpl");
	
	/**
	 * 增加赛事
	 * @param events
	 */
	public void addEvents(Events events){
		eventsDAO.addEvents(events);
	}
	/**
	 * 删除赛事
	 * @param id
	 */
	public void deleteEvents(int id){
		eventsDAO.deleteEvents(id);
	}
	/**
	 * 更新赛事详情
	 * @param events
	 */
	public void updateEvents(Events events){
		eventsDAO.updateEvents(events);
	}
	/**
	 * 根据id查找赛事
	 * @param id
	 * @return
	 */
	public Events getEventsById(int id){
		return eventsDAO.getEventsById(id);
	}
	/**
	 * 获得所有的赛事的分页信息
	 * @param sitename
	 * @param statue
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public Page getEventsPageData(int pageNum,int pageSize){
		int totalRecord = eventsDAO.getAllEventsTotalRecord();
		Page page = new Page(pageSize, pageNum, totalRecord);
		List<EventsVo> list = eventsDAO.getAllEvents(page.getStartIndex(), pageSize);
		page.setList(list);
		return page;
	}
	
	/**
	 * 判断指定时间内有没有赛事
	 * @param startTime
	 * @param endTime
	 * @param siteId
	 * @return
	 */
	public boolean getEventsByTime(Date startTime,Date endTime,int siteId){
		return eventsDAO.getEventsByTime(startTime, endTime, siteId);
	}
	
	/**
	 * 获得查询结果的分页数据
	 * @param sitename
	 * @param statue
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public Page getQueryResultPageDate(String eventsname,String sitename,String statue,int pageNum,int pageSize){
		if("none".equals(statue)){
			statue="";
		}
		int totalRecord = eventsDAO.getQueryEventsTotalRecord(eventsname,sitename, statue);
		Page page = new Page(pageSize, pageNum, totalRecord);
		List<EventsVo> list = eventsDAO.queryEvents(eventsname,sitename, statue, page.getStartIndex(), pageSize);
		page.setList(list);
		return page;
	}
	/**
	 * 处理过期赛事
	 */
	public int dealPassed(){
		return eventsDAO.dealPassed();
	}
	
}
