package com.gms.dao;

import java.util.Date;
import java.util.List;

import com.gms.domain.Events;
import com.gms.vo.EventsVo;

public interface EventsDAO {

	/**
	 * �������
	 * @param events
	 */
	public abstract void addEvents(Events events);

	/**
	 * ɾ������
	 * @param id
	 */
	public abstract void deleteEvents(int id);

	/**
	 * ����������Ϣ
	 * @param events
	 */
	public abstract void updateEvents(Events events);

	/**
	 * ����id��������
	 * @param id
	 * @return
	 */
	public abstract Events getEventsById(int id);

	/**
	 * ������е�����
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public abstract List<EventsVo> getAllEvents(int startIndex, int pageSize);

	/**
	 * ������������ݿ��е��ܼ�¼��
	 * @return
	 */
	public abstract int getAllEventsTotalRecord();

	/**
	 * �ж�ָ��ʱ������û������
	 * @param startTime
	 * @param endTime
	 * @param siteId
	 * @return
	 */
	public abstract boolean getEventsByTime(Date startTime, Date endTime,
			int siteId);

	/**
	 * ��ѯ����
	 * @param sitename
	 * @param staue
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public abstract List<EventsVo> queryEvents(String eventsname,String sitename, String statue,
			int startIndex, int pageSize);

	/**
	 * ��ò�ѯ������ܼ�¼��
	 * @param sitename
	 * @param statue
	 * @return
	 */
	public abstract int getQueryEventsTotalRecord(String eventsname,String sitename, String statue);

	/**
	 * �����������
	 */
	public abstract int dealPassed();

}