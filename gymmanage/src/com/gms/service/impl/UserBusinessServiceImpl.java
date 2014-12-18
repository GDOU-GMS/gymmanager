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
	 * 更具学号查找用户
	 * @param studentNo
	 * @return
	 */
	public User getUserByStudentNo(String studentNo){
		return userDAO.getUserByStudentNo(studentNo);
	}
	/**
	 * 根据id查找用户
	 * @param studentNo
	 * @return
	 */
	public User getUserById(int id){
		return userDAO.getUserById(id);
	}
}
