package com.gms.service.impl;

import java.util.List;

import com.gms.dao.SiteDAO;
import com.gms.dao.UserDAO;
import com.gms.domain.User;
import com.gms.factory.DAOFactory;

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
}
