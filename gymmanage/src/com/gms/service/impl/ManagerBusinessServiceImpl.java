package com.gms.service.impl;



import java.util.List;

import com.gms.dao.ManagerDAO;
import com.gms.domain.Manager;
import com.gms.factory.DAOFactory;

public class ManagerBusinessServiceImpl {
	DAOFactory daoFactory=DAOFactory.getInstance();
	private ManagerDAO managerDAO=daoFactory.createDAO("com.gms.dao.impl.ManagerDAOImpl");
    
	
	/**
	 * ��ѯ����Ա��Ϣ
	 * @param account
	 * @param name
	 */
	public void selectManager(String account,String name){
		managerDAO.selectManager(account, name);
	}
	
	
	/**
	 * ���ӹ���Ա
	 * @param manager
	 */
	public void addManager(Manager manager){
		managerDAO.addManager(manager);
	}
	
	
	/**
	 * ���¹���Ա��Ϣ
	 * @param manager
	 */
	public void updateManager(Manager manager){
		managerDAO.updateManager(manager);
	}
	
	
	/**
	 * ɾ������Ա
	 * @param id
	 */
	public void deleteManger(int id ){
		managerDAO.deleteManager(id);
	}
	
	
	
	public List<Manager> getAllManager(){
		return managerDAO.getAllManager();
	}
	
}
