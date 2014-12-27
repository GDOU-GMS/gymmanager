package com.gms.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.util.JSONUtils;

import org.apache.struts2.ServletActionContext;

import com.gms.domain.Page;
import com.gms.domain.Site;
import com.gms.domain.SiteOrder;
import com.gms.domain.SiteType;
import com.gms.domain.SiteUsage;
import com.gms.domain.User;
import com.gms.service.impl.SiteBusinessServiceImpl;
import com.gms.service.impl.UserBusinessServiceImpl;
import com.gms.utils.JSONTools;
import com.gms.vo.SiteOrderVo;
import com.gms.vo.SiteVo;
import com.opensymphony.xwork2.ActionContext;
import com.sun.mail.iap.Response;

public class SiteAction {

	private String message;
	private SiteType siteType;
	private Site site;
	private int id;
	private int pageNum = 1;
	private int numPerPage = 20;//�൱��pagesize
	private SiteOrder siteOrder;
	private String studentNo;
	private String username;
	private SiteUsage siteUsage;
	
	


	public SiteUsage getSiteUsage() {
		return siteUsage;
	}

	public void setSiteUsage(SiteUsage siteUsage) {
		this.siteUsage = siteUsage;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public SiteOrder getSiteOrder() {
		return siteOrder;
	}

	public void setSiteOrder(SiteOrder siteOrder) {
		this.siteOrder = siteOrder;
	}

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
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

	public SiteType getSiteType() {
		return siteType;
	}

	public void setSiteType(SiteType siteType) {
		this.siteType = siteType;
	}

	/**
	 * 添加场地类型
	 * 
	 * @return
	 */
	public String addSiteType() {
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			service.addSiteType(siteType);
			message = JSONTools.getJSONString("200", "添加成功！", "getAllSiteType",
					"closeCurrent", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "添加失败，系统异常！", "", "", "");
		}
		return "message";
	}

	/**
	 * 获得所有的场地类型
	 * 
	 * @return
	 */
	public String getAllSiteType() {
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			List<SiteType> siteTypes = service.getAllSiteType();
			ActionContext.getContext().put("siteTypes", siteTypes);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "查询失败，系统异常!", "", "", "");
			return "message";
		}
	}

	/**
	 * 删除场地类型
	 * 
	 * @return
	 * @throws IOException
	 */
	public String deleteSiteType() {
		// HttpServletResponse response = ServletActionContext.getResponse();
		// PrintWriter out = response.getWriter();
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			List<Site> list = service.getSiteBySiteTypeId(id);
			if(!list.isEmpty()){
				message = JSONTools.getJSONString("300", "删除失败，该场地类型正在被场地使用中！", "", "", "");
				return "message";
			}
			service.deleteSiteType(id);
			message = JSONTools.getJSONString("200", "删除成功！", "getAllSiteType",
					"", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "删除失败，系统异常",
					"", "", "");
		}
		return "message";
	}

	/**
	 * 
	 * 获得回显数据，修改
	 * 
	 * @return
	 */
	public String echoData() {
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			SiteType siteType = service.getSiteTypeById(id);
			ActionContext.getContext().put("siteType", siteType);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "查询失败，系统异常！", "", "", "");
			return "message";
		}
	}

	/**
	 * 更新场地类型
	 * 
	 * @return
	 */
	public String updateSiteType() {
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			service.updateSiteType(siteType);
			message = JSONTools.getJSONString("200", "更新成功！", "getAllSiteType",
					"closeCurrent", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "更新失败，系统异常！", "", "", "");
		}
		return "message";
	}

	/**
	 * 获取所有的场地
	 * 
	 * @return
	 */
	public String getAllSite() {
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			List<SiteType> siteTypes = service.getAllSiteType();
			Page page = service.getSitePageData(pageNum, numPerPage);
			ActionContext.getContext().put("page", page);
			ActionContext.getContext().put("siteTypes", siteTypes);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "查询失败，系统异常！", "", "", "");
			return "message";
		}
	}

	/**
	 * 添加场地之前获得其他信息
	 */
	public String getDataForAddSite() {
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			List<SiteType> siteTypes = service.getAllSiteType();
			ActionContext.getContext().put("siteTypes", siteTypes);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "抱歉，系统异常", "", "", "");
			return "message";
		}
	}

	/**
	 * 添加场地
	 * 
	 * @return
	 */
	public String addSite() {
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			service.addSite(site);
			message = JSONTools.getJSONString("200", "添加成功！", "getAllSite",
					"closeCurrent", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "添加失败，系统异常！", "", "", "");
		}
		return "message";
	}

	/**
	 * 删除场地
	 * 
	 * @return
	 */
	public String deleteSite() {
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			service.deleteSite(id);
			message = JSONTools.getJSONString("200", "删除成功！", "getAllSite", "",
					"");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "删除失败，系统异常！", "getAllSite", "",
					"");
		}
		return "message";
	}

	/**
	 * 获得回显数据给跟新场地信息
	 * 
	 * @return
	 */
	public String getDataForUpdateSite() {
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			Site site = service.getSiteDetailById(id);
			List<SiteType> siteTypes = service.getAllSiteType();
			ActionContext.getContext().put("site", site);
			ActionContext.getContext().put("siteTypes", siteTypes);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "获取失败，系统异常！", "getAllSite", "",
					"");
			return "message";
		}
	}

	/**
	 * 更新场地
	 * 
	 * @return
	 */
	public String updateSite() {
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			service.updateSte(site);
			message = JSONTools.getJSONString("200", "更新成功！", "getAllSite",
					"closeCurrent", "");
		} catch (Exception e) {
			message = JSONTools.getJSONString("300", "更新失败，系统异常！", "", "", "");
		}
		return "message";
	}

	/**
	 * 恢复场地
	 * 
	 * @return
	 */
	public String recoverSite() {
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			service.recoverSite(id);
			message = JSONTools.getJSONString("200", "恢复成功！", "getAllSite", "",
					"");
		} catch (Exception e) {
			message = JSONTools.getJSONString("300", "恢复失败，系统异常！", "", "", "");
		}
		return "message";
	}

	/**
	 * 彻底删除场地
	 * 
	 * @return
	 */
	public String removeSite() {
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			service.removeSite(id);
			message = JSONTools.getJSONString("200", "删除成功！", "getAllSite", "",
					"");
		} catch (Exception e) {
			message = JSONTools.getJSONString("300", "删除失败，系统异常！", "",
					"", "");
		}
		return "message";
	}

	/**
	 * 获得所有的场地预约
	 * 
	 * @return
	 */
	public String getAllSiteOrder() {
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			Page page = service.getSiteOrderPageDate(pageNum, numPerPage);
			ActionContext.getContext().put("page", page);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "查询失败，系统异常！", "", "", "");
			return "message";
		}
	}
	
	/**
	 * 获得数据给添加场地预约
	 * @return
	 */
	public String getDataForAddSiteOrder(){
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			List<Site> sites = service.getAllSite();
			List<SiteType> siteTypes = service.getAllSiteType();
			ActionContext.getContext().put("sites", sites);
			ActionContext.getContext().put("siteTypes", siteTypes);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "获取失败，系统异常！", "", "", "");
			return "message";
		}
	}
	/**
	 * 获得数据给添加场地预约
	 * @return
	 */
	public String getDataForReserveSiteOrder(){
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			List<Site> sites = service.getAllSite();
			List<SiteType> siteTypes = service.getAllSiteType();
			ActionContext.getContext().put("sites", sites);
			ActionContext.getContext().put("siteTypes", siteTypes);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "获取失败，系统异常！", "", "", "");
			return "message";
		}
	}
	/**
	 * 获得回显数据给预留场地
	 * @return
	 */
	public String getDataForUpdateReserveSiteOrder(){
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			
			//获得数据
			List<Site> sites = service.getAllSite();
			List<SiteType> siteTypes = service.getAllSiteType();
			ActionContext.getContext().put("sites", sites);
			ActionContext.getContext().put("siteTypes", siteTypes);
			//获得回显数据
			SiteOrder siteOrder = service.getsiteOrderById(id);
			Site site = service.getSiteDetailById(siteOrder.getSiteId());
			SiteType type = service.getSiteTypeById(site.getTypeId());
			
			//格式化时间显示
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String stratTime = sdf.format(siteOrder.getStratTime());
			String endTime = sdf.format(siteOrder.getEndTime());
			ActionContext.getContext().put("stratTime",stratTime);
			ActionContext.getContext().put("endTime", endTime);
			
			ActionContext.getContext().put("siteOrder",siteOrder);
			ActionContext.getContext().put("site", site);
			ActionContext.getContext().put("type", type);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "获取失败，系统异常！", "", "", "");
			return "message";
		}
	}
	/**
	 * 预留场地
	 * @return
	 */
	public String reserveSiteOrder(){
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			boolean flat = service.getSiteOrderByTime(siteOrder.getStratTime(), siteOrder.getEndTime(),siteOrder.getSiteId());
			if(flat==false){
				message = JSONTools.getJSONString("300", "预约失败，该场地该时间段已经被预约！", "", "", "");
				return "message";
			}
			Date orderTime = new Date();
			siteOrder.setOrderTime(orderTime);
			service.reserveSiteOrder(siteOrder);
			message = JSONTools.getJSONString("200", "预留成功！", "getAllReserveSiteOrder", "closeCurrent", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "预留失败，系统异常！", "", "", "");
		}
		return "message";
	}
	
	/**
	 * 获取所有的场地预留
	 * @return
	 */
	public String getAllReserveSiteOrder(){
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			Page page = service.getAllReserveSiteOrderPageDate(pageNum,numPerPage);
			ActionContext.getContext().put("page", page);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "查询失败，系统异常！", "", "", "");
			return "message";
		}
	}
	/**
	 * 管理员添加场地预约
	 * @return
	 */
	public String addSiteOrderByManager(){
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			boolean flat = service.getSiteOrderByTime(siteOrder.getStratTime(), siteOrder.getEndTime(),siteOrder.getSiteId());
			if(flat==false){
				message = JSONTools.getJSONString("300", "预约失败，该场地该时间段已经被预约！", "", "", "");
				return "message";
			}
			UserBusinessServiceImpl userService = new UserBusinessServiceImpl();
			User user = userService.getUserByStudentNo(studentNo);
			if(user!=null){
				siteOrder.setUserId(user.getId());
				Date orderTime = new Date();
				siteOrder.setOrderTime(orderTime);
				service.addSiteOrder(siteOrder);
				message = JSONTools.getJSONString("200", "添加预约成功！", "getAllSiteOrder", "closeCurrent", "");
			}else{
				message = JSONTools.getJSONString("300", "预约失败，该用户不存在！", "", "", "");
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "预约失败，系统异常！", "", "", "");
		}
		return "message";
	}
	
	/**
	 * 删除场地预约
	 */
	public String deleteSiteOrder(){
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			service.deleteSiteOrder(id);
			message = JSONTools.getJSONString("200", "删除成功！", "getAllSiteOrder", "", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "删除失败，系统异常！", "", "", "");
		}
		return "message";
	}
	
	/**
	 * 获得回显数据给更新场地
	 * @return
	 */
	public String getDataForUpdateSiteOrder(){
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			UserBusinessServiceImpl userService = new UserBusinessServiceImpl();
			
			//获得数据
			List<Site> sites = service.getAllSite();
			List<SiteType> siteTypes = service.getAllSiteType();
			ActionContext.getContext().put("sites", sites);
			ActionContext.getContext().put("siteTypes", siteTypes);
			//获得回显数据
			SiteOrder siteOrder = service.getsiteOrderById(id);
			Site site = service.getSiteDetailById(siteOrder.getSiteId());
			SiteType type = service.getSiteTypeById(site.getTypeId());
			User user = userService.getUserById(siteOrder.getUserId());
			
			//格式化时间显示
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String stratTime = sdf.format(siteOrder.getStratTime());
			String endTime = sdf.format(siteOrder.getEndTime());
			ActionContext.getContext().put("stratTime",stratTime);
			ActionContext.getContext().put("endTime", endTime);
			
			ActionContext.getContext().put("siteOrder",siteOrder);
			ActionContext.getContext().put("site", site);
			ActionContext.getContext().put("type", type);
			ActionContext.getContext().put("user", user);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "获取数据失败，系统异常！", "", "", "");
			return "message";
		}
	}
	/**
	 * 更新场地预留
	 * @return
	 */
	public String updateReserveSiteOrder(){
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			service.updateReserveSiteOrder(siteOrder);
			message = JSONTools.getJSONString("200", "更新成功", "getAllReserveSiteOrder", "closeCurrent", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "更新失败，系统异常！", "", "", "");
		}
		return  "message";
	}
	/**
	 * 更新场地预约
	 * @return
	 */
	public String updateSiteOrder(){
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			UserBusinessServiceImpl userService = new UserBusinessServiceImpl();
			User user = userService.getUserByStudentNo(studentNo);
			if(user!=null){
				siteOrder.setUserId(user.getId());
			/*	Date orderTime = new Date();
				siteOrder.setOrderTime(orderTime);*/
				service.updateSiteOrder(siteOrder);
				message = JSONTools.getJSONString("200", "更新成功", "getAllSiteOrder", "closeCurrent", "");
			}else{
				message = JSONTools.getJSONString("300", "更新失败，该用户不存在！", "", "", "");
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "更新失败，系统异常！", "", "", "");
		}
		return  "message";
	}
	
	/**
	 * 查询场地
	 * @return
	 */
	public String querySite(){
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			List<SiteType> siteTypes = service.getAllSiteType();
			ActionContext.getContext().put("siteTypes", siteTypes);
			Page page = service.querySite(site.getName(), siteType.getType(), site.getStatue(),pageNum,numPerPage);
			ActionContext.getContext().put("page", page);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "查询失败，系统异常！", "", "", "");
			return "message";
		}
		
	}
	
	/**
	 * 获得当前场地预约
	 * @return
	 */
	public String getCurrentSiteOrder(){
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			Page page =  service.getCurrentSiteOrder(pageNum,numPerPage);
			ActionContext.getContext().put("page", page);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "查询失败，系统异常！", "", "", "");
			return "message";
		}
	}
	
	/**
	 * 一键处理失约
	 */
	public String dealBreach(){
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			int count = service.dealBreach();
			message = JSONTools.getJSONString("200", "处理成功，一共处理了"+count+"条记录！", "getAllSiteOrder", "", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "处理失败，系统异常！", "", "", "");
		}
		return "message";
	}
	
	/**
	 * 一键处理预留过期
	 */
	public String dealPassed(){
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			int count = service.dealPassed();
			message = JSONTools.getJSONString("200", "处理成功，一共处理了"+count+"条记录！", "getAllSiteOrder", "", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "处理失败，系统异常！", "", "", "");
		}
		return "message";
	}
	
	/**
	 * 今日预约页面，处理失约
	 */
	public String dealBreachByCurrentPage(){
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			int count = service.dealBreach();
			message = JSONTools.getJSONString("200", "处理成功，一共处理了"+count+"条记录！", "getCurrentSiteOrder", "", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300",  "处理失败，系统异常！", "", "", "");
		}
		return "message";
	}
	
	/**
	 * 查询场地预约
	 * @return
	 */
	public String querySiteOrder(){
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			Page page = service.querySiteOrderResultPageData(site.getName(), username, siteOrder.getStatue(), pageNum, numPerPage);
			ActionContext.getContext().put("page", page);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "查询失败，系统异常！", "", "", "");
		}
		return "message";
	}
	
	/**
	 * 在当前预约里查询场地预约
	 * @return
	 */
	public String queryCurrentSiteOrder(){
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			Page page  = service.getQueryCurrentSiteOrderPage(site.getName(), username, siteOrder.getStatue(), pageNum, numPerPage);
			ActionContext.getContext().put("page", page);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "查询失败，系统异常！", "", "", "");
			return "message";
		}
	}
	/**
	 * 将预约信息投入使用
	 * @return
	 */
	public String putIntoSiteUsage(){
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			SiteOrder siteOrder = service.getsiteOrderById(id);
			//如果是过期的预约
			if("passed".equals(siteOrder.getStatue())){
				message =  JSONTools.getJSONString("300", "投入使用失败，该预约已经过期", "", "", "");
				return "message";
			}
			Site site = service.getSiteDetailById(siteOrder.getSiteId());
			//获得时间，用于计算价钱
			float hour = (siteOrder.getEndTime().getTime()-siteOrder.getStratTime().getTime())/(60*60*1000);
			//保存数据到siteusage
			SiteUsage siteUsage = new SiteUsage();
			siteUsage.setStratTime(siteOrder.getStratTime());
			siteUsage.setEndTime(siteOrder.getEndTime());
			siteUsage.setPrice(site.getFeeScale()*hour);
			siteUsage.setStatue("notimeout");
			siteUsage.setSiteId(siteOrder.getSiteId());
			siteUsage.setUserId(siteOrder.getUserId());
			
			service.addSiteUsage(siteUsage);
			//跟新预约的状״̬
			siteOrder.setStatue("passed");
			service.updateSiteOrder(siteOrder);
			
			message = JSONTools.getJSONString("200", "投入使用成功！", "getCurrentSiteOrder", "", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "投入使用失败，系统异常！", "", "", "");
			
		}
		return "message";
	}
	
	/**
	 * 获取所有的场地使用
	 * @return
	 */
	public String getAllSiteUsage(){
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			Page page = service.getAllSiteUsagePageData(pageNum, numPerPage);
			ActionContext.getContext().put("page", page);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "查村失败，系统异常", "", "", "");
			return "message";
		}
	}
	
	/**
	 * 获得数据给添加场地使用
	 * @return
	 */
	public String getDataForAddSiteUsage(){
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			List<Site> sites = service.getAllSite();
			List<SiteType> siteTypes = service.getAllSiteType();
			ActionContext.getContext().put("sites", sites);
			ActionContext.getContext().put("siteTypes", siteTypes);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "查询失败，系统异常！", "", "", "");
			return "message";
		}
	}
	
	/**
	 * 添加场地使用
	 * @return
	 */
	public String addSiteUsage(){ 
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			//判断该场地是否被预约
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date currentDate = sdf.parse(sdf.format(date));//获得日期
			Date stratTime = new Date(currentDate.getTime()+siteUsage.getStratTime().getTime()); 
			Date endTime = new Date(currentDate.getTime()+siteUsage.getEndTime().getTime()); 
			boolean flat = service.getSiteOrderByTime(stratTime, endTime, siteUsage.getSiteId());
			if(flat==false){
				message = JSONTools.getJSONString("300", "添加失败，该场地该时间段已经被预约！", "", "", "");
				return "message";
			}
			//判断该场是否在使用
			flat = service.getSiteUsageByTime(siteUsage.getStratTime(), siteUsage.getEndTime(), siteUsage.getSiteId());
			if(flat==false){
				message = JSONTools.getJSONString("300", "添加失败，该场地正在使用中！", "", "", "");
				return "message";
			}
			//判断该用户是否存在
			UserBusinessServiceImpl userService = new UserBusinessServiceImpl();
			User user = userService.getUserByStudentNo(studentNo);
			if(user!=null){
				siteUsage.setUserId(user.getId());
				Site site = service.getSiteDetailById(siteUsage.getSiteId());
				float hour = (siteUsage.getEndTime().getTime()-siteUsage.getStratTime().getTime())/(60*60*1000);
				siteUsage.setPrice(site.getFeeScale()*hour);
				service.addSiteUsage(siteUsage);
				message = JSONTools.getJSONString("200", "添加成功", "getAllSiteUsage", "closeCurrent", "");
			}else{
				message = JSONTools.getJSONString("300", "添加失败，该用户不存在", "", "", "");
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "添加失败，系统异常！", "", "", "");
		}
		return "message";
	}
	/**
	 * 获得回显数据给更新场地使用
	 * @return
	 */
	public String getDataForUpdateSiteUsage(){
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			UserBusinessServiceImpl userService = new UserBusinessServiceImpl();
			//获得所有场地信息数据
			List<Site> sites = service.getAllSite();
			List<SiteType> siteTypes = service.getAllSiteType();
			ActionContext.getContext().put("sites", sites);
			ActionContext.getContext().put("siteTypes", siteTypes);
			
			SiteUsage siteUsage = service.getSiteUsageById(id);
			//修改日期回显时间
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date currentDate = sdf.parse(sdf.format(date));//获得日期
			Date stratTime = new Date(currentDate.getTime()+siteUsage.getStratTime().getTime()); 
			Date endTime = new Date(currentDate.getTime()+siteUsage.getEndTime().getTime()); 
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ActionContext.getContext().put("stratTime", sdf.format(stratTime));
			ActionContext.getContext().put("endTime", sdf.format(endTime));
			ActionContext.getContext().put("siteUsage",siteUsage);
			//获得用户信息
			User user = userService.getUserById(siteUsage.getUserId());
			ActionContext.getContext().put("user", user);
			//获得选定场地信息
			Site site = service.getSiteDetailById(siteUsage.getSiteId());
			ActionContext.getContext().put("site", site);
			
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "查询失败，系统异常！", "", "", "");
			return "message";
		}
	}
	
	/**
	 * 更新场地使用
	 * @return
	 */
	public String updateSiteUsage(){
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			//判断该场地是否被预约
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date currentDate = sdf.parse(sdf.format(date));//获得日期
			Date stratTime = new Date(currentDate.getTime()+siteUsage.getStratTime().getTime()); 
			Date endTime = new Date(currentDate.getTime()+siteUsage.getEndTime().getTime()); 
			boolean flat = service.getSiteOrderByTime(stratTime, endTime, siteUsage.getSiteId());
			if(flat==false){
				message = JSONTools.getJSONString("300", "更新失败，该场地该时间段已经被预约！", "", "", "");
				return "message";
			}
			//判断该场是否在使用
			flat = service.getSiteUsageByTime(siteUsage.getStratTime(), siteUsage.getEndTime(), siteUsage.getSiteId());
			if(flat==false){
				message = JSONTools.getJSONString("300", "更新失败，该场地正在使用中！", "", "", "");
				return "message";
			}
			//判断该用户是否存在
			UserBusinessServiceImpl userService = new UserBusinessServiceImpl();
			User user = userService.getUserByStudentNo(studentNo);
			if(user!=null){
				siteUsage.setUserId(user.getId());
				Site site = service.getSiteDetailById(siteUsage.getSiteId());
				float hour = (siteUsage.getEndTime().getTime()-siteUsage.getStratTime().getTime())/(60*60*1000);
				siteUsage.setPrice(site.getFeeScale()*hour);
				service.updateSiteUsage(siteUsage);
				message = JSONTools.getJSONString("200", "更新成功！", "getAllSiteUsage", "closeCurrent", "");
			}else{
				message = JSONTools.getJSONString("300", "更新失败，该用户不存在", "", "", "");
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "更新失败，系统异常！", "", "", "");
		}
		return "message";
	}
	
	/**
	 * 删除场地使用
	 * @return
	 */
	public String deleteSiteUsage(){
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			service.deleteSiteUsage(id);
			message = JSONTools.getJSONString("200", "删除成功！", "getAllSiteUsage", "", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "删除失败，系统异常！", "", "", "");
		}
		return "message";
	}
	/**
	 * 处理已经超时的场地使用
	 * @return
	 */
	public String dealTimeOutSiteUsage(){
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			int count = service.dealTimeOutSiteUsage();
			message = JSONTools.getJSONString("200", "处理成功，一共处理了"+count+"条数据！", "getAllSiteUsage", "", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "删除失败，系统异常！", "", "", "");
		}
		return "message";
	}
	
	/**
	 * 删除所有超时的场地预约信息
	 * @return
	 */
	public String deleteAllTimeOutSiteUsage(){
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			int count = service.deleteAllTimeOutSiteUsage();
			message = JSONTools.getJSONString("200", "删除成功，一共删除了"+count+"条数据！", "getAllSiteUsage", "", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "删除失败，系统异常！", "", "", "");
		}
		return  "message";
	}
	/**
	 * 查询场地使用信息
	 * @return
	 */
	public String querySiteUsage(){
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			Page page = service.querySiteUsage(site.getName(), username, siteUsage.getStatue(), pageNum, numPerPage);
			ActionContext.getContext().put("page", page);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "查询失败，系统异常！", "", "", "");
			return  "message";
		}
	}
	
	/**
	 * 查询场地预留
	 * @return
	 */
	public String queryReserveSiteOrderPageDate(){
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			Page page = service.queryReserveSiteOrderPageDate(site.getName(), siteOrder.getStatue(),pageNum, numPerPage);
			ActionContext.getContext().put("page", page);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "查询失败，系统异常！", "", "", "");
			return  "message";
		}
	}
	
	
} 	
