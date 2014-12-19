package com.gms.web.action;



import java.util.List;

import com.gms.domain.Manager;
import com.gms.service.impl.ManagerBusinessServiceImpl;
import com.gms.utils.JSONTools;
import com.opensymphony.xwork2.ActionContext;

import freemarker.core.ReturnInstruction.Return;

public class ManagerAction {
	
	private Manager manager;
	private String message;
	private String account;
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
	private String name;
	private int id;
	private List<Manager> listManager;
	private String oPassword;
	private String nPassword;
	
	
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
	 * ��ӹ���Ա
	 * @return
	 */
	public String addManager(){
		try{
			ManagerBusinessServiceImpl managerBusinessServiceImpl=new ManagerBusinessServiceImpl();
			managerBusinessServiceImpl.addManager(manager);
			message=JSONTools.getJSONString("200","添加成功","getAllManager","closeCurrent","");
		}catch(Exception e){
			e.printStackTrace();
			message=JSONTools.getJSONString("300", "添加失败", "", "", "");
		}
		return "message";
		
		
	}
	
	/**
	 * ���¹���Ա
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
	 * ɾ�����Ա��Ϣ
	 * @return
	 */
	public String deleteManager(){
		try{
			ManagerBusinessServiceImpl managerBusinessServiceImpl=new ManagerBusinessServiceImpl();
			managerBusinessServiceImpl.deleteManger(id);
		    JSONTools.getJSONString("200", "删除成功", "getAllManager", "", "");
		}catch(Exception e){
		
			JSONTools.getJSONString("300", "删除失败","", "", "");
		}
		return "message";
	}
	
	
	
	/**
	 * ������й���Ա
	 * @return
	 */
	public String getAllManager(){ 
		try{
			ManagerBusinessServiceImpl managerBusinessServiceImpl=new ManagerBusinessServiceImpl();
			listManager=managerBusinessServiceImpl.getAllManager();
			return "success";
		}catch(Exception e){
			return "error";
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
				ActionContext.getContext().getSession().put("message", "�����˺Ż��������");
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
			ActionContext.getContext().getSession().put("message", "ϵͳ�쳣����¼ʧ�ܣ�");
			return "loginFailed";
		}
	}
	
	
	/**
	 * 更改管理员密码
	 * @return
	 */
	public String updatePassword(){
		
		ManagerBusinessServiceImpl managerBusinessServiceImpl=new ManagerBusinessServiceImpl();
		//假定id=1
		id=1;
		boolean flag=false;
		flag=managerBusinessServiceImpl.updatePassword(id, oPassword, nPassword);
		if(flag){
			message=JSONTools.getJSONString("200", "更新成功","getAllUsers", "", "");
		}else{
			message=JSONTools.getJSONString("300", "更新失败","","","");
		}
		
		return "message";
		
	}
	/*
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
			listManager=managerBusinessServiceImpl.getManagers(account, name);
			return "success";
			 
		 }catch(Exception e){
			 
			return "error";
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
	
	
	
//	public String getManagerSelfInfo(){
//		 ManagerBusinessServiceImpl managerBusinessServiceImpl =new ManagerBusinessServiceImpl();
//		try{
//			listManager=managerBusinessServiceImpl.getManagers(manager.getAccount(),manager.getName());
//			return "success";
//			 
//		 }catch(Exception e){
//			 
//			return "error";
//		 }
//	}
//	
	
	
	
	
	
}
