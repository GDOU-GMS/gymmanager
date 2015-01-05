package com.gms.web.action;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.gms.domain.Manager;
import com.gms.domain.Page;
import com.gms.service.impl.ManagerBusinessServiceImpl;
import com.gms.service.impl.UserBusinessServiceImpl;
import com.gms.utils.JSONTools;
import com.opensymphony.xwork2.ActionContext;

import freemarker.core.ReturnInstruction.Return;

public class ManagerAction {
	
	private Manager manager;
	private String message;
	private String account;
	private String name;
	private int id;
	private List<Manager> listManager;
	private String oPassword;
	private String nPassword;
	private String rnPassword;
	private int pageNum = 1;
	private int numPerPage = 20;//�൱��pagesize
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getNumPerPage() {
		return numPerPage;
	}
	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}

	
	public String getRnPassword() {
		return rnPassword;
	}
	public void setRnPassword(String rnPassword) {
		this.rnPassword = rnPassword;
	}
	public String getoPassword() {
		return oPassword;
	}
	public void setoPassword(String oPassword) {
		this.oPassword = oPassword;
	}
	public String getnPassword() {
		return nPassword;
	}
	public void setnPassword(String nPassword) {
		this.nPassword = nPassword;
	}
	
	
	public List<Manager> getListManager() {
		return listManager;
	}
	public void setListManager(List<Manager> listManager) {
		this.listManager = listManager;
	}

	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	/**
	 * 添加管理员
	 * @return
	 */
	public String addManager(){
		try{

			ManagerBusinessServiceImpl managerBusinessServiceImpl=new ManagerBusinessServiceImpl();
			Manager m = managerBusinessServiceImpl.getMangerByAccount(manager.getAccount());
			if(m!=null){
				message=JSONTools.getJSONString("300", "添加失败,该账号已经存在", "", "", "");
				return "message";
			}
			managerBusinessServiceImpl.addManager(manager);
			message=JSONTools.getJSONString("200","添加成功","getAllManager","closeCurrent","");
		}catch(Exception e){
			e.printStackTrace();
			message=JSONTools.getJSONString("300", "添加失败", "", "", "");
		}
		return "message";
		
		
	}
	
	/**
	 * 更新管理员信息
	 * @return
	 */
	public String updateManager(){
		try{
			System.out.println("管理员的id为"+manager.getId());
			System.out.println("管理员的名字"+manager.getName());
			System.out.println("管理员的用户名为"+manager.getAccount());
			System.out.println("管理员的地址为"+manager.getAddress());
			ManagerBusinessServiceImpl managerBusinessServiceImpl=new ManagerBusinessServiceImpl();
			managerBusinessServiceImpl.updateManager(manager);
			message = JSONTools.getJSONString("200", "更新成功", "getManagerSelf","closeCurrent", "");
		}catch(Exception e){
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "更新失败", "", "", "");
		}
		return "message";
		
	}
	
	/**
	 * 删除管理员
	 * @return
	 */
	public String deleteManager(){
		try{
			boolean flag=false;
			ManagerBusinessServiceImpl managerBusinessServiceImpl=new ManagerBusinessServiceImpl();
			flag=managerBusinessServiceImpl.deleteManger(id);
		   if(flag){
			 message=JSONTools.getJSONString("200", "删除成功", "getAllManager", "", "");
			 
		   }else{
			   message=JSONTools.getJSONString("300", "删除失败","", "", "");
		   }
		}catch(Exception e){
			message=JSONTools.getJSONString("300", "删除失败","", "", "");
		}
		return "message";
	}
	
	
	
	/**
	 * 获得所有管理员
	 * @return
	 */
	public String getAllManager(){ 
//		try{
//			ManagerBusinessServiceImpl managerBusinessServiceImpl=new ManagerBusinessServiceImpl();
//			listManager=managerBusinessServiceImpl.getAllManager();
//			return "success";
//		}catch(Exception e){
//			return "error";
//		}
		 try {
				ManagerBusinessServiceImpl service = new ManagerBusinessServiceImpl();
				Page page = service.getAllManagersPageDate(pageNum,numPerPage);
				ActionContext.getContext().put("page",page);
				return "success";
			} catch (Exception e) {
				e.printStackTrace();
				message = JSONTools.getJSONString("300", "查询失败", "", "", "");
				return "message";
			}
		
		
		
	}
	/**
	 * У���¼
	 * @return
	 */
	public String loginCheck(){
		try {
			ManagerBusinessServiceImpl service = new ManagerBusinessServiceImpl();
			Manager result = service.verifyManager(manager);
			if(result==null){

				//ActionContext.getContext().getSession().put("message", "�����˺Ż��������");

				ActionContext.getContext().getSession().put("message", "账号密码有误，请重新登录！");

				return "loginFailed";
			}else{
				ActionContext.getContext().getSession().put("manager", result);
				if("superAdmin".equals(result.getPermission())){
					return "superAdmin";
				}else{
					return "manager";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

			//ActionContext.getContext().getSession().put("message", "ϵͳ�쳣����¼ʧ�ܣ�");

			ActionContext.getContext().getSession().put("message", "登录失败，系统异常！");

			return "loginFailed";
		}
	}
	
	
	/**
	 * 更改管理员密码
	 * @return
	 */
	public String updatePassword(){
		
		manager=(Manager) ActionContext.getContext().getSession().get("manager");
		
		ManagerBusinessServiceImpl managerBusinessServiceImpl=new ManagerBusinessServiceImpl();
		System.out.println(nPassword.equals(rnPassword));
		if(!nPassword.equals(rnPassword)){
			message=JSONTools.getJSONString("300", "新密码与确定密码不一致","","","");
			return "message";
			
		}else{
			boolean flag=false;
			
			flag=managerBusinessServiceImpl.updatePassword(manager.getId(), oPassword, nPassword);
			if(flag){
				message=JSONTools.getJSONString("200", "更新成功","getAllUsers", "closeCurrent", "");
			}else{
				message=JSONTools.getJSONString("300", "更新失败","","","");
				
			}
			return "message";
			
		}
		
	}
	/**
	 * 查询管理员
	 */
	public String getManagers(){
		
		 ManagerBusinessServiceImpl managerBusinessServiceImpl =new ManagerBusinessServiceImpl();
		 try{
			if(account==null){
				account="";
			}
			if(name==null){
				name="";
			}
//			listManager=managerBusinessServiceImpl.getManagers(account, name);
//			return "success";
//			 
//		 }catch(Exception e){
//			 
//			return "error";
//		 }
			ManagerBusinessServiceImpl service = new ManagerBusinessServiceImpl();
			Page page = service.getManagersPageDate(account,name,pageNum,numPerPage);
			ActionContext.getContext().put("page",page);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "查询失败", "", "", "");
			return "message";
		}
		 
	}
	
	
	/**
	 * 管理员登陆后获得自己的信息
	 * @return
	 */
	public String  getManagerSelf(){
		
		manager=(Manager) ActionContext.getContext().getSession().get("manager");
		ManagerBusinessServiceImpl managerBusinessServiceImpl =new ManagerBusinessServiceImpl();
		 try{
				manager=managerBusinessServiceImpl.getManagerById(manager.getId());
				return "success";
				 
			 }catch(Exception e){
				 
				return "error";
			 }
	
	}
	

	/**
	 * 管理员退出登录
	 * @return
	 */
	public String logout(){
		try {
			ActionContext.getContext().getSession().remove("manager");
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "退出异常！", "", "", "");
			return "message";
		}
	}
	
	
	
	
}
