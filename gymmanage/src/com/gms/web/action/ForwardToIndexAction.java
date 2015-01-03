package com.gms.web.action;

import java.util.List;

import com.gms.domain.Notice;
import com.gms.service.impl.NoticeBusinessServiceImpl;
import com.opensymphony.xwork2.ActionContext;


public class ForwardToIndexAction {

	public String execute(){
		//flag用于判断是否访问过首页
		ActionContext.getContext().put("flag", true);
		try{
			NoticeBusinessServiceImpl service = new NoticeBusinessServiceImpl();
			List<Notice> notices = service.getAllNotice();
			ActionContext.getContext().put("notices", notices);
			return "success";
		}catch(Exception e){
			e.printStackTrace();
			ActionContext.getContext().put("message", "系统异常！");
			return "error";
		}
	}
}
