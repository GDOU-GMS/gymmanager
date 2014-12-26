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
	private int numPerPage = 20;//ï¿½àµ±ï¿½ï¿½pagesize
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
	 * ï¿½ï¿½Ó³ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
	 * 
	 * @return
	 */
	public String addSiteType() {
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			service.addSiteType(siteType);
			message = JSONTools.getJSONString("200", "ï¿½ï¿½Ó³É¹ï¿½ï¿½ï¿½", "getAllSiteType",
					"closeCurrent", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "ï¿½ï¿½ï¿½Ê§ï¿½Ü£ï¿½", "", "", "");
		}
		return "message";
	}

	/**
	 * ï¿½ï¿½È¡ï¿½ï¿½ï¿½Ð³ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
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
			message = JSONTools.getJSONString("300", "ï¿½ï¿½È¡Ê§ï¿½ï¿½!", "", "", "");
			return "message";
		}
	}

	/**
	 * É¾ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
	 * 
	 * @return
	 * @throws IOException
	 */
	public String deleteSiteType() {
		// HttpServletResponse response = ServletActionContext.getResponse();
		// PrintWriter out = response.getWriter();
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			service.deleteSiteType(id);
			message = JSONTools.getJSONString("200", "É¾ï¿½ï¿½É¹ï¿½ï¿½ï¿½", "getAllSiteType",
					"", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "É¾ï¿½ï¿½Ê§ï¿½Ü£ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Ç¸Ã³ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Ú³ï¿½ï¿½ï¿½ï¿½ï¿½Ê¹ï¿½Ã£ï¿½",
					"", "", "");
		}
		return "message";
	}

	/**
	 * 
	 * ï¿½ï¿½ï¿½Â³ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Ç°ï¿½ï¿½ï¿½ï¿½Ý»ï¿½ï¿½ï¿½
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
			message = JSONTools.getJSONString("300", "ï¿½ï¿½È¡Ê§ï¿½Ü£ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Ô£ï¿½", "", "", "");
			return "message";
		}
	}

	/**
	 * ï¿½ï¿½ï¿½Â³ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
	 * 
	 * @return
	 */
	public String updateSiteType() {
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			service.updateSiteType(siteType);
			message = JSONTools.getJSONString("200", "ï¿½ï¿½ï¿½Â³É¹ï¿½ï¿½ï¿½", "getAllSiteType",
					"closeCurrent", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "ï¿½ï¿½ï¿½ï¿½Ê§ï¿½Ü£ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Ô£ï¿½", "", "", "");
		}
		return "message";
	}

	/**
	 * ï¿½ï¿½È¡ï¿½ï¿½ï¿½ÐµÄ³ï¿½ï¿½ØµÄ·ï¿½Ò³ï¿½ï¿½ï¿½
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
			message = JSONTools.getJSONString("300", "ï¿½ï¿½È¡Ê§ï¿½Ü£ï¿½", "", "", "");
			return "message";
		}
	}

	/**
	 * ï¿½ï¿½Ó³ï¿½ï¿½ï¿½Ö®Ç°ï¿½ï¿½È¡ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
	 */
	public String getDataForAddSite() {
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			List<SiteType> siteTypes = service.getAllSiteType();
			ActionContext.getContext().put("siteTypes", siteTypes);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "ï¿½ï¿½È¡Ê§ï¿½Ü£ï¿½", "", "", "");
			return "message";
		}
	}

	/**
	 * ï¿½ï¿½ï¿½ï¿½ÂµÄ³ï¿½ï¿½ï¿½
	 * 
	 * @return
	 */
	public String addSite() {
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			service.addSite(site);
			message = JSONTools.getJSONString("200", "ï¿½ï¿½Ó³É¹ï¿½", "getAllSite",
					"closeCurrent", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "ï¿½ï¿½È¡Ê§ï¿½Ü£ï¿½ÏµÍ³ï¿½ì³£ï¿½ï¿½", "", "", "");
		}
		return "message";
	}

	/**
	 * É¾ï¿½ï¿½ï¿½
	 * 
	 * @return
	 */
	public String deleteSite() {
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			service.deleteSite(id);
			message = JSONTools.getJSONString("200", "É¾ï¿½ï¿½É¹ï¿½ï¿½ï¿½", "getAllSite", "",
					"");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "É¾ï¿½ï¿½Ê§ï¿½Ü£ï¿½", "getAllSite", "",
					"");
		}
		return "message";
	}

	/**
	 * ï¿½ï¿½ï¿½Â³ï¿½ï¿½ï¿½Ç°ï¿½ï¿½È¡ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Ú»ï¿½ï¿½ï¿½
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
			message = JSONTools.getJSONString("300", "É¾ï¿½ï¿½Ê§ï¿½Ü£ï¿½", "getAllSite", "",
					"");
			return "message";
		}
	}

	/**
	 * ï¿½ï¿½ï¿½Â³ï¿½ï¿½ï¿½
	 * 
	 * @return
	 */
	public String updateSite() {
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			service.updateSte(site);
			message = JSONTools.getJSONString("200", "ï¿½Þ¸Ä³É¹ï¿½", "getAllSite",
					"closeCurrent", "");
		} catch (Exception e) {
			message = JSONTools.getJSONString("300", "ï¿½Þ¸ï¿½Ê§ï¿½Ü£ï¿½ÏµÍ³ï¿½ì³£", "", "", "");
		}
		return "message";
	}

	/**
	 * ï¿½ï¿½É¾ï¿½ï¿½Ä³ï¿½ï¿½Ø»Ö¸ï¿½
	 * 
	 * @return
	 */
	public String recoverSite() {
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			service.recoverSite(id);
			message = JSONTools.getJSONString("200", "ï¿½Ö¸ï¿½ï¿½É¹ï¿½ï¿½ï¿½", "getAllSite", "",
					"");
		} catch (Exception e) {
			message = JSONTools.getJSONString("300", "ï¿½Ö¸ï¿½Ê§ï¿½Ü£ï¿½ÏµÍ³ï¿½ì³£", "", "", "");
		}
		return "message";
	}

	/**
	 * ï¿½ï¿½ï¿½ï¿½É¾ï¿½ï¿½ï¿½
	 * 
	 * @return
	 */
	public String removeSite() {
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			service.removeSite(id);
			message = JSONTools.getJSONString("200", "É¾ï¿½ï¿½É¹ï¿½", "getAllSite", "",
					"");
		} catch (Exception e) {
			message = JSONTools.getJSONString("300", "É¾ï¿½ï¿½Ê§ï¿½Ü£ï¿½ï¿½Ã³ï¿½ï¿½ï¿½ï¿½Þ·ï¿½É¾ï¿½ï¿½ÏµÍ³ï¿½ì³£ï¿½ï¿½", "",
					"", "");
		}
		return "message";
	}

	/**
	 * ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ÐµÄ³ï¿½ï¿½ï¿½Ô¤Ô¼
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
			message = JSONTools.getJSONString("300", "ï¿½ï¿½È¡Ê§ï¿½Ü£ï¿½ÏµÍ³ï¿½ì³£ï¿½ï¿½", "", "", "");
			return "message";
		}
	}
	
	/**
	 * ï¿½ï¿½Ó¡ï¿½Ô¤ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Ö®Ç°ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
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
			message = JSONTools.getJSONString("300", "ï¿½ï¿½È¡Ê§ï¿½Ü£ï¿½ÏµÍ³ï¿½ì³£ï¿½ï¿½", "", "", "");
			return "message";
		}
	}
	
	/**
	 * Ô¤ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
	 * @return
	 */
	/*public String reserveSiteOrder(){
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			
			Date orderTime = new Date();
			siteOrder.setOrderTime(orderTime);
			service.addSiteOrder(siteOrder);
			message = JSONTools.getJSONString("200", "ï¿½ï¿½Ó³É¹ï¿½", "getAllSiteOrder", "closeCurrent", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "ï¿½ï¿½È¡Ê§ï¿½Ü£ï¿½ÏµÍ³ï¿½ì³£ï¿½ï¿½", "", "", "");
		}
		return "message";
	}*/
	
	/**
	 * ï¿½ï¿½ï¿½ï¿½Ô±ï¿½ï¿½Ó³ï¿½ï¿½ï¿½Ô¤Ô¼
	 * @return
	 */
	public String addSiteOrderByManager(){
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			boolean flat = service.getSiteOrderByTime(siteOrder.getStratTime(), siteOrder.getEndTime(),siteOrder.getSiteId());
			if(flat==false){
				message = JSONTools.getJSONString("300", "ÄúÑ¡ÔñµÄÊ±¼äÒÑ¾­±»Ô¤Ô¼", "", "", "");
				return "message";
			}
			UserBusinessServiceImpl userService = new UserBusinessServiceImpl();
			User user = userService.getUserByStudentNo(studentNo);
			if(user!=null){
				siteOrder.setUserId(user.getId());
				Date orderTime = new Date();
				siteOrder.setOrderTime(orderTime);
				service.addSiteOrder(siteOrder);
				message = JSONTools.getJSONString("200", "ï¿½ï¿½Ó³É¹ï¿½", "getAllSiteOrder", "closeCurrent", "");
			}else{
				message = JSONTools.getJSONString("300", "ï¿½ï¿½ï¿½ï¿½Ñ§ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½", "", "", "");
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "ï¿½ï¿½È¡Ê§ï¿½Ü£ï¿½ÏµÍ³ï¿½ì³£ï¿½ï¿½", "", "", "");
		}
		return "message";
	}
	
	/**
	 * É¾ï¿½ï¿½Ô¤Ô¼ï¿½ï¿½Ï¢
	 */
	public String deleteSiteOrder(){
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			service.deleteSiteOrder(id);
			message = JSONTools.getJSONString("200", "É¾ï¿½ï¿½É¹ï¿½", "getAllSiteOrder", "", "");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			message = JSONTools.getJSONString("200", "É¾ï¿½ï¿½Ê§ï¿½Ü£ï¿½ÏµÍ³ï¿½ì³£!", "", "", "");
		}
		return "message";
	}
	
	/**
	 * ï¿½ï¿½È¡ï¿½ï¿½Ý»ï¿½ï¿½Ô¸ï¿½Ô¤Ô¼ï¿½ï¿½ï¿½ï¿½
	 * @return
	 */
	public String getDataForUpdateSiteOrder(){
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			UserBusinessServiceImpl userService = new UserBusinessServiceImpl();
			
			//ï¿½ï¿½Ã³ï¿½ï¿½ØºÍ³ï¿½ï¿½ï¿½ï¿½Íµï¿½ï¿½ï¿½ï¿½
			List<Site> sites = service.getAllSite();
			List<SiteType> siteTypes = service.getAllSiteType();
			ActionContext.getContext().put("sites", sites);
			ActionContext.getContext().put("siteTypes", siteTypes);
			//ï¿½ï¿½Ã»ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
			SiteOrder siteOrder = service.getsiteOrderById(id);
			Site site = service.getSiteDetailById(siteOrder.getSiteId());
			SiteType type = service.getSiteTypeById(site.getTypeId());
			User user = userService.getUserById(siteOrder.getUserId());
			
			/*//ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Ú¸ï¿½Ê½
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String stratTime = sdf.format(siteOrder.getStratTime());
			String endTime = sdf.format(siteOrder.getEndTime());
			siteOrder.setStratTime(sdf.parse(stratTime));
			siteOrder.setEndTime(sdf.parse(endTime));*/
			
			ActionContext.getContext().put("siteOrder",siteOrder);
			ActionContext.getContext().put("site", site);
			ActionContext.getContext().put("type", type);
			ActionContext.getContext().put("user", user);
			return "success";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "ï¿½ï¿½Ñ¯ï¿½ï¿½ï¿½?ÏµÍ³ï¿½ì³£ï¿½ï¿½", "", "", "");
			return "message";
		}
	}
	/**
	 * ï¿½ï¿½ï¿½Â³ï¿½ï¿½ï¿½Ô¤Ô¼
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
				message = JSONTools.getJSONString("200", "ï¿½Þ¸Ä³É¹ï¿½ï¿½ï¿½", "getAllSiteOrder", "closeCurrent", "");
			}else{
				message = JSONTools.getJSONString("300", "ï¿½ï¿½ï¿½ï¿½Ñ§ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½", "", "", "");
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "ï¿½ï¿½ï¿½Â³ï¿½ï¿½?ÏµÍ³ï¿½ì³£ï¿½ï¿½", "", "", "");
		}
		return  "message";
	}
	
	/**
	 * Ä£ï¿½ï¿½ï¿½Ñ¯ï¿½ï¿½ï¿½ï¿½
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
			message = JSONTools.getJSONString("300", "ï¿½ï¿½Ñ¯ï¿½ï¿½ï¿½?ÏµÍ³ï¿½ì³£ï¿½ï¿½", "", "", "");
			return "message";
		}
		
	}
	
	/**
	 * »ñµÃÏµÍ³µ±Ç°Ô¤Ô¼
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
			message = JSONTools.getJSONString("300", "±§Ç¸£¬²éÑ¯³ö´í£¬ÏµÍ³Òì³££¡", "", "", "");
			return "message";
		}
	}
	
	/**
	 * ´¦Àí¹ýÆÚÔ¤Ô¼£¬ÌáÇ°10·ÖÖÓµ½
	 */
	public String dealBreach(){
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			int count = service.dealBreach();
			message = JSONTools.getJSONString("200", "´¦Àí³É¹¦,Ò»¹²´¦Àí"+count+"ÌõÊý¾Ý£¡", "getAllSiteOrder", "", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "±§Ç¸£¬´¦Àí³ö´í£¬ÏµÍ³Òì³££¡", "", "", "");
		}
		return "message";
	}
	/**
	 * ´¦Àí¹ýÆÚÔ¤Ô¼£¬ÌáÇ°10·ÖÖÓµ½
	 */
	public String dealBreachByCurrentPage(){
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			int count = service.dealBreach();
			message = JSONTools.getJSONString("200", "´¦Àí³É¹¦,Ò»¹²´¦Àí"+count+"ÌõÊý¾Ý£¡", "getCurrentSiteOrder", "", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "±§Ç¸£¬´¦Àí³ö´í£¬ÏµÍ³Òì³££¡", "", "", "");
		}
		return "message";
	}
	
	/**
	 * ²éÑ¯³¡µØÔ¤Ô¼
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
			message = JSONTools.getJSONString("300", "±§Ç¸£¬²éÑ¯³ö´í£¬ÏµÍ³Òì³££¡", "", "", "");
		}
		return "message";
	}
	
	/**
	 * ²éÑ¯µ±Ç°³¡µØÔ¤Ô¼
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
			message = JSONTools.getJSONString("300", "±§Ç¸£¬²éÑ¯³ö´í£¬ÏµÍ³Òì³££¡", "", "", "");
			return "message";
		}
	}
	/**
	 * ½«³¡µØÔ¤Ô¼Í¶Èëµ½³¡µØÊ¹ÓÃÖÐ
	 * @return
	 */
	public String putIntoSiteUsage(){
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			SiteOrder siteOrder = service.getsiteOrderById(id);
			//Èç¹ûÊÇ¹ýÆÚ³¡µØµÄ»°£¬²»ÔÊÐíÍ¶ÈëÊ¹ÓÃ
			if("passed".equals(siteOrder.getStatue())){
				message =  JSONTools.getJSONString("300", "Í¶ÈëÊ§°Ü£¬¸ÃÔ¤Ô¼ÒÑ¾­¹ýÆÚ", "", "", "");
				return "message";
			}
			Site site = service.getSiteDetailById(siteOrder.getSiteId());
			//µÃµ½Ê¹ÓÃÊ±¼ä
			float hour = (siteOrder.getEndTime().getTime()-siteOrder.getStratTime().getTime())/(60*60*1000);
			//ÐÂ½¨³¡µØÊ¹ÓÃ
			SiteUsage siteUsage = new SiteUsage();
			siteUsage.setStratTime(siteOrder.getStratTime());
			siteUsage.setEndTime(siteOrder.getEndTime());
			siteUsage.setPrice(site.getFeeScale()*hour);
			siteUsage.setStatue("notimeout");
			siteUsage.setSiteId(siteOrder.getSiteId());
			siteUsage.setUserId(siteOrder.getUserId());
			
			service.addSiteUsage(siteUsage);
			//ÐÞ¸Ä³¡µØÔ¤Ô¼×´Ì¬
			siteOrder.setStatue("passed");
			service.updateSiteOrder(siteOrder);
			
			message = JSONTools.getJSONString("200", "Í¶ÈëÊ¹ÓÃ³É¹¦£¡", "getCurrentSiteOrder", "", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "±§Ç¸£¬²éÑ¯³ö´í£¬ÏµÍ³Òì³££¡", "", "", "");
			
		}
		return "message";
	}
	
	/**
	 * »ñµÃËùÓÐ³¡µØÊ¹ÓÃ
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
			message = JSONTools.getJSONString("300", "±§Ç¸£¬²éÑ¯³ö´í£¬ÏµÍ³Òì³££¡", "", "", "");
			return "message";
		}
	}
	
	/**
	 * »ñÈ¡Êý¾Ý¸øÌí¼Ó³¡µØ
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
			message = JSONTools.getJSONString("300", "±§Ç¸£¬²éÑ¯³ö´í£¬ÏµÍ³Òì³££¡", "", "", "");
			return "message";
		}
	}
}
