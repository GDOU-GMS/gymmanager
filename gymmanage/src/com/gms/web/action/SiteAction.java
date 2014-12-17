package com.gms.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.util.JSONUtils;

import org.apache.struts2.ServletActionContext;

import com.gms.domain.Page;
import com.gms.domain.Site;
import com.gms.domain.SiteOrder;
import com.gms.domain.SiteType;
import com.gms.service.impl.SiteBusinessServiceImpl;
import com.gms.utils.JSONTools;
import com.gms.vo.SiteVo;
import com.opensymphony.xwork2.ActionContext;
import com.sun.mail.iap.Response;

public class SiteAction {

	private String message;
	private SiteType siteType;
	private Site site;
	private int id;
	private int pageNum = 1;
	private int numPerPage = 20;

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
			message = JSONTools.getJSONString("300", "添加失败！", "", "", "");
		}
		return "message";
	}

	/**
	 * 获取所有场地类型
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
			message = JSONTools.getJSONString("300", "获取失败!", "", "", "");
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
			service.deleteSiteType(id);
			message = JSONTools.getJSONString("200", "删除成功！", "getAllSiteType",
					"", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "删除失败，可能是该场地类型在场地中使用！",
					"", "", "");
		}
		return "message";
	}

	/**
	 * 
	 * 更新场地类型前的数据回显
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
			message = JSONTools.getJSONString("300", "获取失败，请重试！", "", "", "");
			return "message";
		}
	}

	/**
	 * 跟新场地类型
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
			message = JSONTools.getJSONString("300", "更新失败，请重试！", "", "", "");
		}
		return "message";
	}

	/**
	 * 获取所有的场地的分页数据
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
			message = JSONTools.getJSONString("300", "获取失败！", "", "", "");
			return "message";
		}
	}

	/**
	 * 添加场地之前获取场地类型数据
	 */
	public String getDataForAddSite() {
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			List<SiteType> siteTypes = service.getAllSiteType();
			ActionContext.getContext().put("siteTypes", siteTypes);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "获取失败！", "", "", "");
			return "message";
		}
	}

	/**
	 * 添加新的场地
	 * 
	 * @return
	 */
	public String addSite() {
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			service.addSite(site);
			message = JSONTools.getJSONString("200", "添加成功", "getAllSite",
					"closeCurrent", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "获取失败，系统异常！", "", "", "");
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
			message = JSONTools.getJSONString("300", "删除失败！", "getAllSite", "",
					"");
		}
		return "message";
	}

	/**
	 * 更新场地前获取数据用于回显
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
			message = JSONTools.getJSONString("300", "删除失败！", "getAllSite", "",
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
			message = JSONTools.getJSONString("200", "修改成功", "getAllSite",
					"closeCurrent", "");
		} catch (Exception e) {
			message = JSONTools.getJSONString("300", "修改失败，系统异常", "", "", "");
		}
		return "message";
	}

	/**
	 * 将删除的场地恢复
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
			message = JSONTools.getJSONString("300", "恢复失败，系统异常", "", "", "");
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
			message = JSONTools.getJSONString("200", "删除成功", "getAllSite", "",
					"");
		} catch (Exception e) {
			message = JSONTools.getJSONString("300", "删除失败，该场地无法删除，系统异常！", "",
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
			List<SiteOrder> siteOrders = service.getAllSiteOrder();
			ActionContext.getContext().put("siteOrders", siteOrders);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "获取失败，系统异常！", "", "", "");
			return "message";
		}
	}
}
