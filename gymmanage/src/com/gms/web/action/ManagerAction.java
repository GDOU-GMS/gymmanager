package com.gms.web.action;



import java.util.List;

import com.gms.domain.Manager;
import com.gms.service.impl.ManagerBusinessServiceImpl;

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
	 * 添加管理员
	 * @return
	 */
	public String selectManager(){
		try{
			ManagerBusinessServiceImpl managerBusinessServiceImpl=new ManagerBusinessServiceImpl();
			managerBusinessServiceImpl.selectManager(account, name);
			message="添加成功！";
		}catch(Exception e){
			e.printStackTrace();
			message="添加失败！";
			
		}
		return message;
		
	}
	
	
	/**
	 * 添加管理员
	 * @return
	 */
	public String addManager(){
		try{
			ManagerBusinessServiceImpl managerBusinessServiceImpl=new ManagerBusinessServiceImpl();
			managerBusinessServiceImpl.addManager(manager);
			message="添加成功！";
		}catch(Exception e){
			e.printStackTrace();
			message="删除成功！";
		}
		return message;
		
	}
	
	/**
	 * 更新管理员
	 * @return
	 */
	public String updateManager(){
		try{
			ManagerBusinessServiceImpl managerBusinessServiceImpl=new ManagerBusinessServiceImpl();
			managerBusinessServiceImpl.updateManager(manager);
			message="更新成功！";
		}catch(Exception e){
			e.printStackTrace();
			message="更新失败！";
		}
		return message;
		
	}
	
	/**
	 * 删除管理员信息
	 * @return
	 */
	public String deleteManager(){
		try{
			ManagerBusinessServiceImpl managerBusinessServiceImpl=new ManagerBusinessServiceImpl();
			managerBusinessServiceImpl.deleteManger(id);
			message="删除成功！";
		}catch(Exception e){
			e.printStackTrace();
			message="删除失败！";
		}
		return message;
	}
	
	
	
	/**
	 * 获得所有管理员
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
	
	
	
}
