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
	 * ��������
	 * @param events
	 */
	public void addEvents(Events events){
		eventsDAO.addEvents(events);
	}
	/**
	 * ɾ������
	 * @param id
	 */
	public void deleteEvents(int id){
		eventsDAO.deleteEvents(id);
	}
	/**
	 * ������������
	 * @param events
	 */
	public void updateEvents(Events events){
		eventsDAO.updateEvents(events);
	}
	/**
	 * ����id��������
	 * @param id
	 * @return
	 */
	public Events getEventsById(int id){
		return eventsDAO.getEventsById(id);
	}
	/**
	 * ������е����µķ�ҳ��Ϣ
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
	 * �ж�ָ��ʱ������û������
	 * @param startTime
	 * @param endTime
	 * @param siteId
	 * @return
	 */
	public boolean getEventsByTime(Date startTime,Date endTime,int siteId){
		return eventsDAO.getEventsByTime(startTime, endTime, siteId);
	}
	
	/**
	 * ��ò�ѯ����ķ�ҳ����
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
	 * �����������
	 */
	public int dealPassed(){
		return eventsDAO.dealPassed();
	}
	
}
