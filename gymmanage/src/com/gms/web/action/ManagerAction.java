package com.gms.web.action;



import java.util.List;

import com.gms.domain.Manager;
import com.gms.service.impl.ManagerBusinessServiceImpl;
import com.opensymphony.xwork2.ActionContext;

import freemarker.core.ReturnInstruction.Return;

public class ManagerAction {
	
	private Manager manager;
	private String message;
	private String account;
	private String name;
	private int id;
	private List<Manager> listManager;
	
	
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
	public String selectManager(){
		try{
			ManagerBusinessServiceImpl managerBusinessServiceImpl=new ManagerBusinessServiceImpl();
			managerBusinessServiceImpl.selectManager(account, name);
			message="��ӳɹ���";
		}catch(Exception e){
			e.printStackTrace();
			message="���ʧ�ܣ�";
			
		}
		return message;
		
	}
	
	
	/**
	 * ��ӹ���Ա
	 * @return
	 */
	public String addManager(){
		try{
			ManagerBusinessServiceImpl managerBusinessServiceImpl=new ManagerBusinessServiceImpl();
			managerBusinessServiceImpl.addManager(manager);
			message="��ӳɹ���";
		}catch(Exception e){
			e.printStackTrace();
			message="ɾ���ɹ���";
		}
		return message;
		
	}
	
	/**
	 * ���¹���Ա
	 * @return
	 */
	public String updateManager(){
		try{
			ManagerBusinessServiceImpl managerBusinessServiceImpl=new ManagerBusinessServiceImpl();
			managerBusinessServiceImpl.updateManager(manager);
			message="���³ɹ���";
		}catch(Exception e){
			e.printStackTrace();
			message="����ʧ�ܣ�";
		}
		return message;
		
	}
	
	/**
	 * ɾ������Ա��Ϣ
	 * @return
	 */
	public String deleteManager(){
		try{
			ManagerBusinessServiceImpl managerBusinessServiceImpl=new ManagerBusinessServiceImpl();
			managerBusinessServiceImpl.deleteManger(id);
			message="ɾ���ɹ���";
		}catch(Exception e){
			e.printStackTrace();
			message="ɾ��ʧ�ܣ�";
		}
		return message;
	}
	
	
	
	/**
	 * ������й���Ա
	 * @return
	 */
	public String getAllManager(){ 
		try{
		ManagerBusinessServiceImpl managerBusinessServiceImpl=new ManagerBusinessServiceImpl();
		listManager=managerBusinessServiceImpl.getAllManager();
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
		
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
				ActionContext.getContext().getSession().put("manager", manager);
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
	
}
