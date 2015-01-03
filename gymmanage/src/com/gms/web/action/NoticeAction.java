package com.gms.web.action;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.gms.domain.Notice;
import com.gms.domain.Page;
import com.gms.service.impl.NoticeBusinessServiceImpl;
import com.gms.utils.JSONTools;
import com.gms.utils.NameUtils;
import com.opensymphony.xwork2.ActionContext;

public class NoticeAction {

	private int pageNum = 1;
	private int numPerPage = 20;// �൱�� pagesize
	private int id;
	private String message;
	private Notice notice;
	private Date startTime;
	private Date endTime;
	
	//�����ļ��ϴ�������
	private File noticeImage;
	private String noticeImageContentType;
	private String noticeImageFileName;
	
	

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public File getNoticeImage() {
		return noticeImage;
	}

	public void setNoticeImage(File noticeImage) {
		this.noticeImage = noticeImage;
	}

	public String getNoticeImageContentType() {
		return noticeImageContentType;
	}

	public void setNoticeImageContentType(String noticeImageContentType) {
		this.noticeImageContentType = noticeImageContentType;
	}


	public String getNoticeImageFileName() {
		return noticeImageFileName;
	}

	public void setNoticeImageFileName(String noticeImageFileName) {
		this.noticeImageFileName = noticeImageFileName;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	/**
	 * ��ȡ���зֹ�������
	 * @return
	 */
	public String getAllNotice() {
		try {
			NoticeBusinessServiceImpl service = new NoticeBusinessServiceImpl();
			Page page = service.getAllNoticePageData(pageNum, numPerPage);
			ActionContext.getContext().put("page", page);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "��ѯʧ�ܣ�ϵͳ�쳣��", "getAllEvents", "", "");
			return "message";
		}
	}
	
	/**
	 * ��ӹ���
	 * @return
	 */
	public String addNotice(){
		try {
			NoticeBusinessServiceImpl service = new NoticeBusinessServiceImpl();
			String image = doUpload();
			notice.setTime(new Date());
			notice.setImage(image);
			service.addNotice(notice);
			message = JSONTools.getJSONString("200", "��ӳɹ���", "getAllNotice", "closeCurrent", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "���ʧ�ܣ�ϵͳ�쳣��", "", "", "");
		}
		return "message";
	}

	/**
	 * �����ļ��ϴ�
	 * @return
	 */
	private String doUpload() {
		try {
			String savePath = ServletActionContext.getServletContext().getRealPath("/upload");
			String expandName = noticeImageFileName.substring(noticeImageFileName.lastIndexOf("."));
			String saveName = NameUtils.getName()+expandName;
			File saveFile = new File(new File(savePath),saveName);
			//�ж��ļ��д治���ڣ�����������
			if(!saveFile.getParentFile().exists()){
				saveFile.getParentFile().mkdirs();
			}
			FileUtils.copyFile(noticeImage, saveFile);
			return saveName;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * ��ʾ��������
	 * @return
	 */
	public String showNoticeDetail(){
		try {
			NoticeBusinessServiceImpl service = new NoticeBusinessServiceImpl();
			Notice notice = service.getNoticeById(id);
			ActionContext.getContext().put("notice", notice);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "�鿴ʧ�ܣ�ϵͳ�쳣��", "", "", "");
			return "message";
		}
	}
	
	/**
	 * ɾ������
	 * @return
	 */
	public String deleteNotice(){
		try {
			NoticeBusinessServiceImpl service = new NoticeBusinessServiceImpl();
			Notice notice = service.getNoticeById(id);
			removerImage(notice.getImage());
			service.deleteNotice(id);
			message = JSONTools.getJSONString("200", "ɾ���ɹ���", "getAllNotice", "", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "ɾ��ʧ�ܣ�ϵͳ�쳣��", "", "", "");
		}
		return "message";
	}
	/**
	 * �Ƴ�ԭ����ͼƬ
	 * @param image
	 */
	private void removerImage(String image) {
		// TODO Auto-generated method stub
		String savePath = ServletActionContext.getServletContext().getRealPath("/upload");
		String realPath = savePath + "\\" + image;
		File file = new File(realPath);
		file.delete();
	}
	/**
	 * ����֮ǰ���Ļ�������
	 * @return
	 */
	public String getDataForUpdateNotice(){
		try {
			NoticeBusinessServiceImpl service = new NoticeBusinessServiceImpl();
			Notice notice = service.getNoticeById(id);
			ActionContext.getContext().put("notice", notice);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "��ѯʧ�ܣ�ϵͳ�쳣��", "", "", "");
			return "message";
		}
	}
	
	/**
	 * ����ͼƬ
	 * @return
	 */
	public String updateNoticeImage(){
		try {
			NoticeBusinessServiceImpl service = new NoticeBusinessServiceImpl();
			Notice notice = service.getNoticeById(id);
			//�����ϴ�ͼƬ
			String image = doUpload();	
			//ɾ��ԭ��ͼƬ
			removerImage(notice.getImage());
			//�������ݿ�
			service.updateImage(image, id);
			message = JSONTools.getJSONString("200", "����ͼƬ�ɹ���", "updateNotice", "closeCurrent", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "����ʧ�ܣ�ϵͳ�쳣��", "", "", "");
		}
		return "message";
	}
	
	/**
	 * �޸Ĺ���
	 * @return
	 */
	public String updateNotice(){
		try {
			NoticeBusinessServiceImpl service = new NoticeBusinessServiceImpl();
			service.updateNotice(notice);
			message = JSONTools.getJSONString("200", "�޸ĳɹ���", "getAllNotice", "closeCurrent", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "�޸�ʧ�ܣ�ϵͳ�쳣��", "", "", "");
		}
		return "message";
	}
	
	/**
	 * ��ѯ����
	 * @return
	 */
	public String queryNotice(){
		try {
			NoticeBusinessServiceImpl service = new NoticeBusinessServiceImpl();
			Page page = service.getQueryResultPageDate(notice.getTitle(), startTime, endTime, pageNum, numPerPage);
			ActionContext.getContext().put("page", page);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "�޸�ʧ�ܣ�ϵͳ�쳣��", "", "", "");
			return "message";
		}
	}
	/**
	 * ������еĹ���
	 * @return
	 */
	public String getAllGymNews(){
		try {
			NoticeBusinessServiceImpl service = new NoticeBusinessServiceImpl();
			List<Notice> notices = service.getAllNotice();
			ActionContext.getContext().put("notices", notices);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = "ϵͳ�쳣�����ǻᾡ��ά����";
			return "error";
		}
	}
}
