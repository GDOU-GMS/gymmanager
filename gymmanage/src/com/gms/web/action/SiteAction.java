package com.gms.web.action;

import java.util.List;

import com.gms.domain.SiteType;
import com.gms.service.impl.SiteBusinessServiceImpl;
import com.opensymphony.xwork2.ActionContext;

public class SiteAction {

	private String message;
	private SiteType siteType;

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
			System.out.println(siteType.getType());
			message = "��ӳɹ���";
		} catch (Exception e) {
			e.printStackTrace();
			message = "���ʧ�ܣ�";
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
			message="��ȡʧ�ܣ�ϵͳ�쳣��";
			return "message";
		}
	}
}
