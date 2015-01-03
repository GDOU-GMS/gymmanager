package com.gms.dao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.gms.dao.NoticeDAO;
import com.gms.domain.Notice;
import com.gms.utils.JDBCUtils;

public class NoticeDAOImpl implements NoticeDAO {

	/**
	 * ��ӹ���
	 * @param notice
	 */
	public void addNotice(Notice notice){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "insert into tb_notice(title,content,time,image) values(?,?,?,?)";
			Object params[] = {notice.getTitle(),notice.getContent(),notice.getTime(),notice.getImage()};
			qr.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * ɾ������
	 * @param id
	 */
	public void deleteNotice(int id){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "delete from tb_notice where id=?";
			qr.update(sql, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * ���¹�������
	 * @param notice
	 */
	public void updateNotice(Notice notice){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "update tb_notice set title=?,content=?,time=? where id=?";
			Object params[] = {notice.getTitle(),notice.getContent(),notice.getTime(),notice.getId()};
			qr.update(sql, params);
 		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * ����ͼƬ
	 * @param image
	 * @param id
	 */
	public void updateImage(String image,int id){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "update tb_notice set image=? where id=?";
			Object params[] = {image,id};
			qr.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * ����id��ȡ����
	 * @param id
	 * @return
	 */
	public Notice getNoticeById(int id){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select * from tb_notice where id=?";
			return (Notice)qr.query(sql, id, new BeanHandler(Notice.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * ��ȡ���еĹ���
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List<Notice> getAllNotice(int startIndex,int pageSize){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select * from tb_notice order by time desc limit ?,?";
			Object params[] = {startIndex,pageSize};
			return (List<Notice>)qr.query(sql, params, new BeanListHandler(Notice.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * ������й�����ܼ�¼��
	 * @return
	 */
	public int getAllNoticeTotalRecord(){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select count(*) from tb_notice";
			long l = (Long)qr.query(sql, new ScalarHandler());
			return (int)l;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * ��ѯ����
	 * @param startTime
	 * @param endTime
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List<Notice> queryNoticeByTime(String title,Date startTime,Date endTime,int startIndex,int pageSize){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select * from tb_notice where title like ? and time>=? and time<=? order by time desc limit ?,?";
			Object params[] = {"%"+title+"%",startTime,endTime,startIndex,pageSize};
			return (List<Notice>)qr.query(sql, params, new BeanListHandler(Notice.class));
 		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * ��ȡ��ѯ������ܼ�¼��
	 * @param StartTime
	 * @param endTime
	 * @return
	 */
	public int getQueryResultTotalRecord(String title,Date startTime,Date endTime){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select count(*) from tb_notice where title like ? and time>=? and time<=?";
			Object params[] = {"%"+title+"%",startTime,endTime};
			long l = (Long)qr.query(sql, params,new ScalarHandler());
			return (int)l;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * ��ȡ���еĹ�������
	 * @return
	 */
	public List<Notice> getAllNotice(){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select * from tb_notice order by time desc";
			return (List<Notice>)qr.query(sql, new BeanListHandler(Notice.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
