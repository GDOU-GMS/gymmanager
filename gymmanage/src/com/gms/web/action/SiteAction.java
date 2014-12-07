package com.gms.web.action;

import com.gms.domain.SiteType;
import com.gms.service.impl.SiteBusinessServiceImpl;

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
			message = "添加成功！";
		} catch (Exception e) {
			e.printStackTrace();
			message = "添加失败！";
		}
		return "message";
	}
}
