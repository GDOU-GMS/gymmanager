package com.gms.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.gms.dao.NoticeDAO;
import com.gms.domain.Notice;
import com.gms.domain.Page;
import com.gms.factory.DAOFactory;

public class NoticeBusinessServiceImpl {
	
	NoticeDAO noticeDAO = DAOFactory.getInstance().createDAO("com.gms.dao.impl.NoticeDAOImpl");
	
	/**
	 * 添加公告
	 * @param notice
	 */
	public void addNotice(Notice notice) {
		noticeDAO.addNotice(notice);
	}
	/**
	 * 删除公告
	 * @param id
	 */
	public void deleteNotice(int id){
		noticeDAO.deleteNotice(id);
	}
	/**
	 * 更新公告内容
	 * @param notice
	 */
	public void updateNotice(Notice notice){
		noticeDAO.updateNotice(notice);
	}
	
	/**
	 * 更新图片
	 * @param image
	 * @param id
	 */
	public void updateImage(String image,int id){
		noticeDAO.updateImage(image, id);
	}
	
	/**
	 * 根据id获取公告
	 * @param id
	 * @return
	 */
	public Notice getNoticeById(int id){
		return noticeDAO.getNoticeById(id);
	}
	/**
	 * 获得所有的公告分页数据
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public Page getAllNoticePageData(int pageNum,int pageSize){
		int totalRecord = noticeDAO.getAllNoticeTotalRecord();
		Page page = new Page(pageSize, pageNum, totalRecord);
		List<Notice> list = noticeDAO.getAllNotice(page.getStartIndex(), pageSize);
		page.setList(list);
		return page;
	}
	/**
	 * 获得查询结果的分页数据
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @throws ParseException 
	 */
	public Page getQueryResultPageDate(String title,Date startTime,Date endTime,int pageNum,int pageSize) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(startTime==null){
			startTime = sdf.parse("2000-01-01");
		}
		if(endTime==null){
			endTime = sdf.parse("2050-01-01");
		}
		int totalRecord = noticeDAO.getQueryResultTotalRecord(title, startTime, endTime);
		Page page = new Page(pageSize, pageNum, totalRecord);
		List<Notice> list = noticeDAO.queryNoticeByTime(title, startTime, endTime, page.getStartIndex(), pageSize);
		page.setList(list);
		return page;
	}
	
	/**
	 * 获得所有的公告数据
	 * @return
	 */
	public List<Notice> getAllNotice(){
		return noticeDAO.getAllNotice();
	}
}
