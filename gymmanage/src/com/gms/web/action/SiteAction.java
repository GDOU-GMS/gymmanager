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
	 * 添加场地类型
	 * @return
	 */
	public String addSiteType(){
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			service.addSiteType(siteType);
			System.out.println(siteType.getType());
			message = "添加成功！";
		} catch (Exception e) {
			e.printStackTrace();
			message = "添加失败！";
		}
		return "message";
	}
	/**
	 * 获取所有场地类型
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
			message="获取失败，系统异常！";
			return "message";
		}
	}
}
