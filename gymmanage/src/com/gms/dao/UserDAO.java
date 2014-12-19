package com.gms.dao;

import java.util.List;

import com.gms.domain.User;

public interface UserDAO {
	public abstract boolean deleteUser(int id);

	public abstract List<User> getUsers(String studentNo, String name,
			String academy);
	public  List<User> getAllUsers();

	/**
	 * ���ѧ�Ų����û�
	 * @param studentNo
	 * @return
	 */
	public  User getUserByStudentNo(String studentNo);
	/**
	 * ���id�����û�
	 * @param studentNo
	 * @return
	 */
	public abstract User getUserById(int id);
	
	/**
	 * 更新用户信息
	 * @param user
	 */
	public abstract void updateUser(User user);
	   
	/**
	 * 更新用户密码
	 * @param id
	 * @param oPassword
	 * @param nPassword
	 * @return
	 */
	public abstract boolean updatePassword(int id,String oPassword,String nPassword);
}