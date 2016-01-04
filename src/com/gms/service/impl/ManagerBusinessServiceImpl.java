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
	 * 锟斤拷询锟斤拷锟斤拷员锟斤拷息
	 * @param account
	 * @param name
	 */
	public  List<Manager> getManagers(String account,String name){
		return managerDAO.getManagers(account, name);
	}
	
	
	/**
	 * 锟斤拷锟接癸拷锟斤拷员
	 * @param manager
	 */
	public void addManager(Manager manager){
		managerDAO.addManager(manager);
	}
	
	
	/**
	 * 锟斤拷锟铰癸拷锟斤拷员锟斤拷息
	 * @param manager
	 */
	public void updateManager(Manager manager){
		managerDAO.updateManager(manager);
	}
	
	
	/**
	 * 删锟斤拷锟斤拷锟皆�
	 * @param id
	 */
	public boolean deleteManger(int id ){
		return managerDAO.deleteManager(id);
	}
	
	
	
	public List<Manager> getAllManager(){
		return managerDAO.getAllManager();
	}
	
	/**
	 * 校锟斤拷锟铰�
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
	public Manager getMangerByAccount(String account){
		return managerDAO.getMangerByAccount(account);
	}
}
