package com.gms.service.impl;



import java.util.List;

import com.gms.dao.ManagerDAO;
import com.gms.domain.Manager;
import com.gms.factory.DAOFactory;

public class ManagerBusinessServiceImpl {
	DAOFactory daoFactory=DAOFactory.getInstance();
	private ManagerDAO managerDAO=daoFactory.createDAO("com.gms.dao.impl.ManagerDAOImpl");
    
	
	/**
	 * 查询管理员信息
	 * @param account
	 * @param name
	 */
	public void selectManager(String account,String name){
		managerDAO.selectManager(account, name);
	}
	
	
	/**
	 * 增加管理员
	 * @param manager
	 */
	public void addManager(Manager manager){
		managerDAO.addManager(manager);
	}
	
	
	/**
	 * 更新管理员信息
	 * @param manager
	 */
	public void updateManager(Manager manager){
		managerDAO.updateManager(manager);
	}
	
	
	/**
	 * 删除管理员
	 * @param id
	 */
	public void deleteManger(int id ){
		managerDAO.deleteManager(id);
	}
	
	
	
	public List<Manager> getAllManager(){
		return managerDAO.getAllManager();
	}
	
}
