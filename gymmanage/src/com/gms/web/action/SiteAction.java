package com.gms.web.action;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.gms.domain.SiteType;
import com.gms.service.impl.SiteBusinessServiceImpl;
import com.gms.utils.JSONTools;
import com.opensymphony.xwork2.ActionContext;
import com.sun.mail.iap.Response;

public class SiteAction {

	private String message;
	private SiteType siteType;
	private int id;
	

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
	 * @return
	 */
	public String addSiteType(){
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			service.addSiteType(siteType);
			message = JSONTools.getJSONString("200", "��ӳɹ���","getAllSiteType","closeCurrent","");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "���ʧ�ܣ�","","","");
		}
		return "message";
	}
	/**
	 * ��ȡ���г�������
	 * @return
	 */
	public String getAllSiteType(){
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			List<SiteType> siteTypes = service.getAllSiteType();
			ActionContext.getContext().put("siteTypes",siteTypes);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "��ȡʧ��!", "", "", "");
			return "message";
		}
	}
	/**
	 * ɾ����������
	 * @return
	 * @throws IOException 
	 */
	public void deleteSiteType() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			service.deleteSiteType(id);
			message = JSONTools.getJSONString("200", "ɾ���ɹ���","getAllSiteType","","");
			out.write(message);
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "ɾ��ʧ�ܣ������Ǹó��������ڳ�����ʹ�ã�","","","");
			out.write(message);
		}finally{
			out.flush();
			out.close();
		}
		//return "message";
	}
}
