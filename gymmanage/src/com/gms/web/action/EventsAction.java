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
	private int numPerPage = 20;//相当于 pagesize
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
	 * 获得所有的赛事
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
			message = JSONTools.getJSONString("300", "查询失败，系统异常！", "getAllEvents", "", "");
			return "message";
		}
	}
	/**
	 * 添加赛事之前获得信息
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
			message = JSONTools.getJSONString("300", "获取数据失败，系统异常！", "", "", "");
			return "message";
		}
	}
	/**
	 * 添加赛事
	 * @return
	 */
	public String addEvents(){
		try {
			EventsBusinessServiceImpl service = new EventsBusinessServiceImpl();
			//先判断时候该场地是否已经有赛事占据了
			boolean flat = service.getEventsByTime(events.getStartTime(), events.getEndTime(), events.getSiteId());
			if(flat==false){
				message = JSONTools.getJSONString("300", "预约失败，该场地该时间段已经有其他赛事了！", "", "", "");
				
			}else{
				service.addEvents(events);
				message = JSONTools.getJSONString("200", "添加赛事成功！", "getAllEvents", "closeCurrent", "");
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "添加失败，系统异常！", "", "", "");
		}
		return "message";
	}
	
	/**
	 * 删除赛事
	 * @return
	 */
	public String deleteEvents(){
		try {
			EventsBusinessServiceImpl service = new EventsBusinessServiceImpl();
			service.deleteEvents(id);
			message = JSONTools.getJSONString("200", "删除成功！", "getAllEvents", "", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "删除失败，系统异常！", "", "", "");
		}
		return "message";
	}
	
	/**
	 * 一键处理过期
	 * @return
	 */
	public String dealPassed(){
		try {
			EventsBusinessServiceImpl service = new EventsBusinessServiceImpl();
			int count = service.dealPassed();
			message = JSONTools.getJSONString("200", "处理成功，一共处理了"+count+"记录", "getAllEvents", "", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "处理失败，系统异常！", "", "", "");
		}
		return "message";
	}
	
	/**
	 * 更新赛事之前要获取数据
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
			//过期的赛事不提供修改
			if("passed".equals(events.getStatue())){
				message  = JSONTools.getJSONString("300", "该赛事已经过期，不提供修改功能！", "", "", "");
				return "message";
			}else{
				
				//格式化时间显示
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
			message = JSONTools.getJSONString("300", "获取失败，系统异常！", "", "", "");
			return "message";
		}
	}
	
	/**
	 * 更新赛事
	 * @return
	 */
	public String updateEvents(){
		try {
			EventsBusinessServiceImpl service = new EventsBusinessServiceImpl();
			service.updateEvents(events);
			message = JSONTools.getJSONString("200", "修改成功！", "getAllEvents", "closeCurrent", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "修改失败，系统异常！", "", "", "");
		}
		return "message";
	}
	
	/**
	 * 查询赛事
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
			message = JSONTools.getJSONString("300", "查询失败，系统异常！", "", "", "");
			return "message";
		}
	}
}
