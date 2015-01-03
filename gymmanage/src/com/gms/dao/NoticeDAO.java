package com.gms.dao;

import java.util.Date;
import java.util.List;

import com.gms.domain.Notice;

public interface NoticeDAO {

	/**
	 * 添加公告
	 * @param notice
	 */
	public abstract void addNotice(Notice notice);

	/**
	 * 删除公告
	 * @param id
	 */
	public abstract void deleteNotice(int id);

	/**
	 * 更新公告内容
	 * @param notice
	 */
	public abstract void updateNotice(Notice notice);

	/**
	 * 更新图片
	 * @param image
	 * @param id
	 */
	public abstract void updateImage(String image, int id);

	/**
	 * 根据id获取公告
	 * @param id
	 * @return
	 */
	public abstract Notice getNoticeById(int id);

	/**
	 * 获取所有的公告
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public abstract List<Notice> getAllNotice(int startIndex, int pageSize);

	/**
	 * 获得所有公告的总记录数
	 * @return
	 */
	public abstract int getAllNoticeTotalRecord();

	/**
	 * 查询公告
	 * @param startTime
	 * @param endTime
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public abstract List<Notice> queryNoticeByTime(String title,
			Date startTime, Date endTime, int startIndex, int pageSize);

	/**
	 * 获取查询结果的总记录数
	 * @param StartTime
	 * @param endTime
	 * @return
	 */
	public  int getQueryResultTotalRecord(String title, Date startTime,
			Date endTime);

	/**
	 * 获取所有的公告数据
	 * @return
	 */
	public abstract List<Notice> getAllNotice();
}