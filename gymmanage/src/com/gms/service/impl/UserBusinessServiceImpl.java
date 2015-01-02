package com.gms.service.impl;

import java.util.List;

import com.gms.dao.SiteDAO;
import com.gms.dao.UserDAO;
import com.gms.domain.Page;
import com.gms.domain.User;
import com.gms.factory.DAOFactory;
import com.gms.vo.SiteVo;

public class UserBusinessServiceImpl {
	DAOFactory daoFactory=DAOFactory.getInstance();
	UserDAO userDAO=daoFactory.createDAO("com.gms.dao.impl.UserDAOImpl");
	 
	public  boolean deleteUser(int id){
		return userDAO.deleteUser(id);
	}
	public List<User> getUsers(String studentNo,String name,String academy){
		return userDAO.getUsers(studentNo,name,academy);
		
	}
	public List<User> getAllUsers(){
		return userDAO.getAllUsers();
	
	}
	/**
	 * ���ѧ�Ų����û�
	 * @param studentNo
	 * @return
	 */
	public User getUserByStudentNo(String studentNo){
		return userDAO.getUserByStudentNo(studentNo);
	}
	/**
	 * ���id�����û�
	 * @param studentNo
	 * @return
	 */
	public User getUserById(int id){
		return userDAO.getUserById(id);
	}
	
	
	public void updateUser(User user){
		 userDAO.updateUser(user);
	}
	
	
	public boolean updatePassword(int id,String oPassword,String nPassword){
		return userDAO.updatePassword(id, oPassword, nPassword);
	}
	
	public Page getAllUsersPageDate(int pageNum,int pageSize){
		int totalRecord = userDAO.getTotalRecords();
		Page page = new Page(pageSize, pageNum, totalRecord);
		List<User> list = userDAO.getAllUsersPageData(page.getStartIndex(), pageSize);
		page.setList(list);
		return page;
	}
	
	
	
	public Page getUsersPageDate(int pageNum,int pageSize,String studentNo,String name,String academy){
		int totalRecord = userDAO.getTotalRecord(studentNo,name,academy);
		Page page = new Page(pageSize, pageNum, totalRecord);
		List<User> list = userDAO.getUsersPageData(page.getStartIndex(), pageSize,studentNo,name,academy);
		page.setList(list);
		return page;
	}
	
	/**
	 * 校验用户登录
	 * @param studentNo
	 * @param password
	 * @return
	 */
	public  User checkLogin(int studentNo,String password){
		return userDAO.checkLogin(studentNo, password);
	}
}

