package com.gms.service.impl;



import java.util.List;

import com.gms.dao.ManagerDAO;
import com.gms.domain.Manager;
import com.gms.domain.Page;
import com.gms.domain.User;
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
	public boolean deleteManger(int id ){
		return managerDAO.deleteManager(id);
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
	
	
	
	public Page getAllManagersPageDate(int pageNum,int pageSize){
		int totalRecord = managerDAO.getTotalRecords();
		Page page = new Page(pageSize, pageNum, totalRecord);
		List<Manager> list = managerDAO.getAllManagersPageData(page.getStartIndex(), pageSize);
		page.setList(list);
		return page;
	}
	public Page getManagersPageDate(String account,String name,int pageNum,int pageSize){
		int totalRecord = managerDAO.getTotalRecord(account, name);
		Page page = new Page(pageSize, pageNum, totalRecord);
		List<Manager> list = managerDAO.getManagersPageData(account,name,page.getStartIndex(), pageSize);
		page.setList(list);
		return page;
	}
	
}
