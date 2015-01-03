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
	private int numPerPage = 20;// 相当于 pagesize
	private int id;
	private String message;
	private Notice notice;
	private Date startTime;
	private Date endTime;
	
	//处理文件上传的属性
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
	 * 获取所有分公告数据
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
			message = JSONTools.getJSONString("300", "查询失败，系统异常！", "getAllEvents", "", "");
			return "message";
		}
	}
	
	/**
	 * 添加公告
	 * @return
	 */
	public String addNotice(){
		try {
			NoticeBusinessServiceImpl service = new NoticeBusinessServiceImpl();
			String image = doUpload();
			notice.setTime(new Date());
			notice.setImage(image);
			service.addNotice(notice);
			message = JSONTools.getJSONString("200", "添加成功！", "getAllNotice", "closeCurrent", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "添加失败，系统异常！", "", "", "");
		}
		return "message";
	}

	/**
	 * 处理文件上传
	 * @return
	 */
	private String doUpload() {
		try {
			String savePath = ServletActionContext.getServletContext().getRealPath("/upload");
			String expandName = noticeImageFileName.substring(noticeImageFileName.lastIndexOf("."));
			String saveName = NameUtils.getName()+expandName;
			File saveFile = new File(new File(savePath),saveName);
			//判断文件夹存不存在，不存在则建立
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
	 * 显示公告详情
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
			message = JSONTools.getJSONString("300", "查看失败，系统异常！", "", "", "");
			return "message";
		}
	}
	
	/**
	 * 删除公告
	 * @return
	 */
	public String deleteNotice(){
		try {
			NoticeBusinessServiceImpl service = new NoticeBusinessServiceImpl();
			Notice notice = service.getNoticeById(id);
			removerImage(notice.getImage());
			service.deleteNotice(id);
			message = JSONTools.getJSONString("200", "删除成功！", "getAllNotice", "", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "删除失败，系统异常！", "", "", "");
		}
		return "message";
	}
	/**
	 * 移除原来的图片
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
	 * 更新之前忽的回显数据
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
			message = JSONTools.getJSONString("300", "查询失败，系统异常！", "", "", "");
			return "message";
		}
	}
	
	/**
	 * 更新图片
	 * @return
	 */
	public String updateNoticeImage(){
		try {
			NoticeBusinessServiceImpl service = new NoticeBusinessServiceImpl();
			Notice notice = service.getNoticeById(id);
			//处理上传图片
			String image = doUpload();	
			//删除原来图片
			removerImage(notice.getImage());
			//更新数据库
			service.updateImage(image, id);
			message = JSONTools.getJSONString("200", "更新图片成功！", "updateNotice", "closeCurrent", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "更新失败，系统异常！", "", "", "");
		}
		return "message";
	}
	
	/**
	 * 修改公告
	 * @return
	 */
	public String updateNotice(){
		try {
			NoticeBusinessServiceImpl service = new NoticeBusinessServiceImpl();
			service.updateNotice(notice);
			message = JSONTools.getJSONString("200", "修改成功！", "getAllNotice", "closeCurrent", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "修改失败，系统异常！", "", "", "");
		}
		return "message";
	}
	
	/**
	 * 查询公告
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
			message = JSONTools.getJSONString("300", "修改失败，系统异常！", "", "", "");
			return "message";
		}
	}
	/**
	 * 获得所有的公告
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
			message = "系统异常，我们会尽快维护！";
			return "error";
		}
	}
}
