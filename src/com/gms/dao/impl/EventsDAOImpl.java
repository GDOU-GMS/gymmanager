package com.gms.dao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.gms.dao.EventsDAO;
import com.gms.domain.Events;
import com.gms.utils.JDBCUtils;
import com.gms.vo.EventsVo;

public class EventsDAOImpl implements EventsDAO {

	/**
	 * �������
	 * @param events
	 */
	public void addEvents(Events events){
		try{
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "insert into tb_events(siteId,startTime,endTime,statue,name,description) values(?,?,?,?,?,?)";
			Object params[] = {events.getSiteId(),events.getStartTime(),events.getEndTime(),events.getStatue(),events.getName(),events.getDescription()};
			qr.update(sql, params);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * ɾ������
	 * @param id
	 */
	public void deleteEvents(int id){
		try{
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "delete  from tb_events where id=?";
			qr.update(sql,id);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * ����������Ϣ
	 * @param events
	 */
	public void updateEvents(Events events){
		try{
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "update tb_events set startTime=?,endTime=?,name=?,description=? where id=?";
			Object params[] = {events.getStartTime(),events.getEndTime(),events.getName(),events.getDescription(),events.getId()};
			qr.update(sql, params);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	/**
	 * ����id��������
	 * @param id
	 * @return
	 */
	public Events getEventsById(int id){
		try{
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select * from tb_events where id=?";
			return (Events) qr.query(sql, id, new BeanHandler(Events.class));
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	/**
	 * ������е�����
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List<EventsVo> getAllEvents(int startIndex,int pageSize){
		try{
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select tb_events.*,tb_site.name as sitename from tb_events,tb_site where tb_site.id=tb_events.siteId order by startTime desc limit ?,?";
			Object params[] = {startIndex,pageSize};
			return (List<EventsVo>) qr.query(sql, params,new BeanListHandler(EventsVo.class));
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	/**
	 * ������������ݿ��е��ܼ�¼��
	 * @return
	 */
	public int getAllEventsTotalRecord(){
		try{
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select count(*) from tb_events";
			long l = (Long) qr.query(sql, new ScalarHandler());
			return (int)l;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	/**
	 * �ж�ָ��ʱ������û������
	 * @param startTime
	 * @param endTime
	 * @param siteId
	 * @return
	 */
	public boolean getEventsByTime(Date startTime,Date endTime,int siteId){
		try{
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select * from tb_events where (?>=startTime and ?<=endTime) or (?>=startTime and ?<=endTime) and siteId=?";
			Object params[] = {startTime,startTime,endTime,endTime,siteId};
			List list = (List) qr.query(sql, params, new BeanListHandler(Events.class));
			if(list.isEmpty()){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	/**
	 * ��ѯ����
	 * @param sitename
	 * @param staue
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List<EventsVo> queryEvents(String eventsname,String sitename,String statue,int startIndex,int pageSize){
		try{
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select tb_events.*,tb_site.name as sitename from tb_events,tb_site where tb_site.id=tb_events.siteId and tb_events.name like ? and tb_site.name like ? and  tb_events.statue like ? order by startTime desc limit ?,?";
			Object params[] = {"%"+eventsname+"%","%"+sitename+"%",statue+"%",startIndex,pageSize};
			return (List<EventsVo>)qr.query(sql, params, new BeanListHandler(EventsVo.class));
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	/**
	 * ��ò�ѯ������ܼ�¼��
	 * @param sitename
	 * @param statue
	 * @return
	 */
	public int getQueryEventsTotalRecord(String eventsname,String sitename,String statue){
		try{
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select count(*) from tb_events,tb_site where tb_site.id=tb_events.siteId and tb_events.name like ? and tb_site.name like ? and  tb_events.statue like ? ";
			Object params[] = {"%"+eventsname+"%","%"+sitename+"%",statue+"%"};
			long l = (Long) qr.query(sql, params,new ScalarHandler());
			return (int)l;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	/**
	 * �����������
	 */
	public int dealPassed(){
		try{
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "update tb_events set statue='passed' where endTime<?";
			return qr.update(sql, new Date());
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}
