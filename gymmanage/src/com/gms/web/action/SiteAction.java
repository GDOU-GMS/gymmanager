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
import com.gms.domain.User;
import com.gms.service.impl.SiteBusinessServiceImpl;
import com.gms.service.impl.UserBusinessServiceImpl;
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
	private int numPerPage = 20;//�൱��pagesize
	private SiteOrder siteOrder;
	private String studentNo;
	


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
	 * ɾ�������
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
			message = JSONTools.getJSONString("200", "ɾ��ɹ���", "getAllSiteType",
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
	 * ���³�������ǰ����ݻ���
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
	 * ��ȡ���еĳ��صķ�ҳ���
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
			message = JSONTools.getJSONString("300", "��ȡʧ�ܣ�", "", "", "");
			return "message";
		}
	}

	/**
	 * ��ӳ���֮ǰ��ȡ�����������
	 */
	public String getDataForAddSite() {
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

	/**
	 * ����µĳ���
	 * 
	 * @return
	 */
	public String addSite() {
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			service.addSite(site);
			message = JSONTools.getJSONString("200", "��ӳɹ�", "getAllSite",
					"closeCurrent", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "��ȡʧ�ܣ�ϵͳ�쳣��", "", "", "");
		}
		return "message";
	}

	/**
	 * ɾ���
	 * 
	 * @return
	 */
	public String deleteSite() {
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			service.deleteSite(id);
			message = JSONTools.getJSONString("200", "ɾ��ɹ���", "getAllSite", "",
					"");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "ɾ��ʧ�ܣ�", "getAllSite", "",
					"");
		}
		return "message";
	}

	/**
	 * ���³���ǰ��ȡ������ڻ���
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
			message = JSONTools.getJSONString("300", "ɾ��ʧ�ܣ�", "getAllSite", "",
					"");
			return "message";
		}
	}

	/**
	 * ���³���
	 * 
	 * @return
	 */
	public String updateSite() {
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			service.updateSte(site);
			message = JSONTools.getJSONString("200", "�޸ĳɹ�", "getAllSite",
					"closeCurrent", "");
		} catch (Exception e) {
			message = JSONTools.getJSONString("300", "�޸�ʧ�ܣ�ϵͳ�쳣", "", "", "");
		}
		return "message";
	}

	/**
	 * ��ɾ��ĳ��ػָ�
	 * 
	 * @return
	 */
	public String recoverSite() {
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			service.recoverSite(id);
			message = JSONTools.getJSONString("200", "�ָ��ɹ���", "getAllSite", "",
					"");
		} catch (Exception e) {
			message = JSONTools.getJSONString("300", "�ָ�ʧ�ܣ�ϵͳ�쳣", "", "", "");
		}
		return "message";
	}

	/**
	 * ����ɾ���
	 * 
	 * @return
	 */
	public String removeSite() {
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			service.removeSite(id);
			message = JSONTools.getJSONString("200", "ɾ��ɹ�", "getAllSite", "",
					"");
		} catch (Exception e) {
			message = JSONTools.getJSONString("300", "ɾ��ʧ�ܣ��ó����޷�ɾ��ϵͳ�쳣��", "",
					"", "");
		}
		return "message";
	}

	/**
	 * ������еĳ���ԤԼ
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
			message = JSONTools.getJSONString("300", "��ȡʧ�ܣ�ϵͳ�쳣��", "", "", "");
			return "message";
		}
	}
	
	/**
	 * ��ӡ�Ԥ������֮ǰ������
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
			message = JSONTools.getJSONString("300", "��ȡʧ�ܣ�ϵͳ�쳣��", "", "", "");
			return "message";
		}
	}
	
	/**
	 * Ԥ������
	 * @return
	 */
	/*public String reserveSiteOrder(){
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			
			Date orderTime = new Date();
			siteOrder.setOrderTime(orderTime);
			service.addSiteOrder(siteOrder);
			message = JSONTools.getJSONString("200", "��ӳɹ�", "getAllSiteOrder", "closeCurrent", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "��ȡʧ�ܣ�ϵͳ�쳣��", "", "", "");
		}
		return "message";
	}*/
	
	/**
	 * ����Ա��ӳ���ԤԼ
	 * @return
	 */
	public String addSiteOrderByManager(){
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			UserBusinessServiceImpl userService = new UserBusinessServiceImpl();
			//List<User> users = userService.getUsers(studentNo, " ", " ");
			User user = userService.getUserByStudentNo(studentNo);
			if(user!=null){
				siteOrder.setUserId(user.getId());
				Date orderTime = new Date();
				siteOrder.setOrderTime(orderTime);
				service.addSiteOrder(siteOrder);
				message = JSONTools.getJSONString("200", "��ӳɹ�", "getAllSiteOrder", "closeCurrent", "");
			}else{
				message = JSONTools.getJSONString("300", "����ѧ������", "", "", "");
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "��ȡʧ�ܣ�ϵͳ�쳣��", "", "", "");
		}
		return "message";
	}
	
	/**
	 * ɾ��ԤԼ��Ϣ
	 */
	public String deleteSiteOrder(){
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			service.deleteSiteOrder(id);
			message = JSONTools.getJSONString("200", "ɾ��ɹ�", "getAllSiteOrder", "", "");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			message = JSONTools.getJSONString("200", "ɾ��ʧ�ܣ�ϵͳ�쳣!", "", "", "");
		}
		return "message";
	}
	
	/**
	 * ��ȡ��ݻ��Ը�ԤԼ����
	 * @return
	 */
	public String getDataForUpdateSiteOrder(){
		try {
			SiteBusinessServiceImpl service = new SiteBusinessServiceImpl();
			UserBusinessServiceImpl userService = new UserBusinessServiceImpl();
			
			//��ó��غͳ����͵����
			List<Site> sites = service.getAllSite();
			List<SiteType> siteTypes = service.getAllSiteType();
			ActionContext.getContext().put("sites", sites);
			ActionContext.getContext().put("siteTypes", siteTypes);
			//��û������
			SiteOrder siteOrder = service.getsiteOrderById(id);
			Site site = service.getSiteDetailById(siteOrder.getSiteId());
			SiteType type = service.getSiteTypeById(site.getTypeId());
			User user = userService.getUserById(siteOrder.getUserId());
			
			/*//��������ڸ�ʽ
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
			message = JSONTools.getJSONString("300", "��ѯ���?ϵͳ�쳣��", "", "", "");
			return "message";
		}
	}
	/**
	 * ���³���ԤԼ
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
				message = JSONTools.getJSONString("200", "�޸ĳɹ���", "getAllSiteOrder", "closeCurrent", "");
			}else{
				message = JSONTools.getJSONString("300", "����ѧ������", "", "", "");
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "���³��?ϵͳ�쳣��", "", "", "");
		}
		return  "message";
	}
	
	/**
	 * ģ���ѯ����
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
			message = JSONTools.getJSONString("300", "��ѯ���?ϵͳ�쳣��", "", "", "");
			return "message";
		}
		
	}
}
