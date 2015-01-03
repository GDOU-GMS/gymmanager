package com.gms.dao;

import java.util.Date;
import java.util.List;

import com.gms.domain.Notice;

public interface NoticeDAO {

	/**
	 * ��ӹ���
	 * @param notice
	 */
	public abstract void addNotice(Notice notice);

	/**
	 * ɾ������
	 * @param id
	 */
	public abstract void deleteNotice(int id);

	/**
	 * ���¹�������
	 * @param notice
	 */
	public abstract void updateNotice(Notice notice);

	/**
	 * ����ͼƬ
	 * @param image
	 * @param id
	 */
	public abstract void updateImage(String image, int id);

	/**
	 * ����id��ȡ����
	 * @param id
	 * @return
	 */
	public abstract Notice getNoticeById(int id);

	/**
	 * ��ȡ���еĹ���
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public abstract List<Notice> getAllNotice(int startIndex, int pageSize);

	/**
	 * ������й�����ܼ�¼��
	 * @return
	 */
	public abstract int getAllNoticeTotalRecord();

	/**
	 * ��ѯ����
	 * @param startTime
	 * @param endTime
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public abstract List<Notice> queryNoticeByTime(String title,
			Date startTime, Date endTime, int startIndex, int pageSize);

	/**
	 * ��ȡ��ѯ������ܼ�¼��
	 * @param StartTime
	 * @param endTime
	 * @return
	 */
	public  int getQueryResultTotalRecord(String title, Date startTime,
			Date endTime);

	/**
	 * ��ȡ���еĹ�������
	 * @return
	 */
	public abstract List<Notice> getAllNotice();
}