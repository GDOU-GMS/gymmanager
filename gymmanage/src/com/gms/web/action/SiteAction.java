package com.gms.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.util.JSONUtils;

import org.apache.struts2.ServletActionContext;

import com.gms.domain.Page;
import com.gms.domain.Site;
import com.gms.domain.SiteType;
import com.gms.service.impl.SiteBusinessServiceImpl;
import com.gms.utils.JSONTools;
import com.opensymphony.xwork2.ActionContext;
import com.sun.mail.iap.Response;

public class SiteAction {

	private String message;
	private SiteType siteType;
	private int id;
	private int pageNum = 1;
	private int pageSize = 20; 
	

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
	 * ��ӳ�������
	 * 
	 * @return
	 */
	public String addSiteType() {
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			service.addSiteType(siteType);
			message = JSONTools.getJSONString("200", "��ӳɹ���", "getAllSiteType",
					"closeCurrent", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "���ʧ�ܣ�", "", "", "");
		}
		return "message";
	}

	/**
	 * ��ȡ���г�������
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
			message = JSONTools.getJSONString("300", "��ȡʧ��!", "", "", "");
			return "message";
		}
	}

	/**
	 * ɾ����������
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
			message = JSONTools.getJSONString("200", "ɾ���ɹ���", "getAllSiteType",
					"", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "ɾ��ʧ�ܣ������Ǹó��������ڳ�����ʹ�ã�",
					"", "", "");
		}
		return "message";
	}

	/**
	 * 
	 * ���³�������ǰ�����ݻ���
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
			message = JSONTools.getJSONString("300", "��ȡʧ�ܣ������ԣ�", "", "", "");
			return "message";
		}
	}

	/**
	 * ���³�������
	 * 
	 * @return
	 */
	public String updateSiteType() {
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			service.updateSiteType(siteType);
			message = JSONTools.getJSONString("200", "���³ɹ���", "getAllSiteType",
					"closeCurrent", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "����ʧ�ܣ������ԣ�", "", "", "");
		}
		return "message";
	}
	/**
	 * ��ȡ���еĳ��صķ�ҳ����
	 * @return
	 */
	public String getAllSite(){
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			List<SiteType> siteTypes = service.getAllSiteType();
			Page page = service.getSitePageData(pageNum,pageSize);
			ActionContext.getContext().put("page",page);
			ActionContext.getContext().put("siteTypes", siteTypes);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "��ȡʧ�ܣ�", "", "", "");
			return "message";
		}
	}
	/**
	 * ��ӳ���֮ǰ��ȡ������������
	 */
	public String getDataForAddSite(){
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			List<SiteType> siteTypes = service.getAllSiteType();
			ActionContext.getContext().put("siteTypes", siteTypes);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "��ȡʧ�ܣ�", "", "", "");
			return "message";
		}
	}
}
