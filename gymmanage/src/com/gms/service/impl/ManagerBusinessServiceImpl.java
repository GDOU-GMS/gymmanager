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
	public  List<Manager> getManagers(String account,String name){
		return managerDAO.getManagers(account, name);
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
	 * ɾ�����Ա
	 * @param id
	 */
	public void deleteManger(int id ){
		managerDAO.deleteManager(id);
	}
	
	
	
	public List<Manager> getAllManager(){
		return managerDAO.getAllManager();
	}
	
	/**
	 * У���¼
	 * @param manager
	 * @return
	 */
	public Manager verifyManager(Manager manager){
		return managerDAO.verifyManager(manager);
	}
	
	
	
	public boolean updatePassword(int id,String oPassword,String nPassword){
		return managerDAO.updatePassword(id, oPassword, nPassword);
	}

	
	public Manager getManagerById(int id){
		return managerDAO.getManagerById(id);
	}

	
}
