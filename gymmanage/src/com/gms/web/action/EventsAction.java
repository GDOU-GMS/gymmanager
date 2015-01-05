package com.gms.web.action;

import java.text.SimpleDateFormat;
import java.util.List;

import com.gms.domain.Events;
import com.gms.domain.Page;
import com.gms.domain.Site;
import com.gms.domain.SiteType;
import com.gms.service.impl.EventsBusinessServiceImpl;
import com.gms.service.impl.SiteBusinessServiceImpl;
import com.gms.utils.JSONTools;
import com.opensymphony.xwork2.ActionContext;

public class EventsAction {

	private Events events;
	private String message;
	private String sitename;
	private int pageNum = 1;
	private int numPerPage = 20;//�൱�� pagesize
	private int id;
	
	
	
	public String getSitename() {
		return sitename;
	}


	public void setSitename(String sitename) {
		this.sitename = sitename;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Events getEvents() {
		return events;
	}


	public void setEvents(Events events) {
		this.events = events;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
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


	/**
	 * ������е�����
	 * @return
	 */
	public String getAllEvents(){
		try {
			EventsBusinessServiceImpl service = new EventsBusinessServiceImpl();
			Page page = service.getEventsPageData(pageNum, numPerPage);
			ActionContext.getContext().put("page", page);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "��ѯʧ�ܣ�ϵͳ�쳣��", "getAllEvents", "", "");
			return "message";
		}
	}
	/**
	 * �������֮ǰ�����Ϣ
	 * @return
	 */
	public String getDataForAddEvents(){
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			List<Site> sites = service.getAllUndeletedSite();
			List<SiteType> siteTypes = service.getAllSiteType();
			ActionContext.getContext().put("sites", sites);
			ActionContext.getContext().put("siteTypes", siteTypes);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "��ȡ����ʧ�ܣ�ϵͳ�쳣��", "", "", "");
			return "message";
		}
	}
	/**
	 * �������
	 * @return
	 */
	public String addEvents(){
		try {
			EventsBusinessServiceImpl service = new EventsBusinessServiceImpl();
			//���ж�ʱ��ó����Ƿ��Ѿ�������ռ����
			boolean flat = service.getEventsByTime(events.getStartTime(), events.getEndTime(), events.getSiteId());
			if(flat==false){
				message = JSONTools.getJSONString("300", "ԤԼʧ�ܣ��ó��ظ�ʱ����Ѿ������������ˣ�", "", "", "");
				
			}else{
				service.addEvents(events);
				message = JSONTools.getJSONString("200", "������³ɹ���", "getAllEvents", "closeCurrent", "");
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "���ʧ�ܣ�ϵͳ�쳣��", "", "", "");
		}
		return "message";
	}
	
	/**
	 * ɾ������
	 * @return
	 */
	public String deleteEvents(){
		try {
			EventsBusinessServiceImpl service = new EventsBusinessServiceImpl();
			service.deleteEvents(id);
			message = JSONTools.getJSONString("200", "ɾ���ɹ���", "getAllEvents", "", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "ɾ��ʧ�ܣ�ϵͳ�쳣��", "", "", "");
		}
		return "message";
	}
	
	/**
	 * һ���������
	 * @return
	 */
	public String dealPassed(){
		try {
			EventsBusinessServiceImpl service = new EventsBusinessServiceImpl();
			int count = service.dealPassed();
			message = JSONTools.getJSONString("200", "����ɹ���һ��������"+count+"��¼", "getAllEvents", "", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "����ʧ�ܣ�ϵͳ�쳣��", "", "", "");
		}
		return "message";
	}
	
	/**
	 * ��������֮ǰҪ��ȡ����
	 * @return
	 */
	public String getDataForUpdateEvents(){
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			List<Site> sites = service.getAllUndeletedSite();
			List<SiteType> siteTypes = service.getAllSiteType();
			ActionContext.getContext().put("sites", sites);
			ActionContext.getContext().put("siteTypes", siteTypes);
			EventsBusinessServiceImpl eventsService = new EventsBusinessServiceImpl();
			Events events = eventsService.getEventsById(id);
			//���ڵ����²��ṩ�޸�
			if("passed".equals(events.getStatue())){
				message  = JSONTools.getJSONString("300", "�������Ѿ����ڣ����ṩ�޸Ĺ��ܣ�", "", "", "");
				return "message";
			}else{
				
				//��ʽ��ʱ����ʾ
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String startTime = sdf.format(events.getStartTime());
				String endTime = sdf.format(events.getEndTime());
				ActionContext.getContext().put("startTime",startTime);
				ActionContext.getContext().put("endTime", endTime);
				ActionContext.getContext().put("events", events);
				return "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "��ȡʧ�ܣ�ϵͳ�쳣��", "", "", "");
			return "message";
		}
	}
	
	/**
	 * ��������
	 * @return
	 */
	public String updateEvents(){
		try {
			EventsBusinessServiceImpl service = new EventsBusinessServiceImpl();
			service.updateEvents(events);
			message = JSONTools.getJSONString("200", "�޸ĳɹ���", "getAllEvents", "closeCurrent", "");
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
	public String queryEvents(){
		try {
			EventsBusinessServiceImpl service = new EventsBusinessServiceImpl();
			Page page = service.getQueryResultPageDate(events.getName(), sitename,events.getStatue() , pageNum, numPerPage);
			ActionContext.getContext().put("page", page);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "��ѯʧ�ܣ�ϵͳ�쳣��", "", "", "");
			return "message";
		}
	}
}
