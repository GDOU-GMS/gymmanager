package com.gms.dao;

import java.util.List;

import com.gms.domain.User;

public interface UserDAO {
	public abstract boolean deleteUser(int id);

	public abstract List<User> getUsers(String studentNo, String name,
			String academy);
	public  List<User> getAllUsers();

	/**
	 * 更具学号查找用户
	 * @param studentNo
	 * @return
	 */
	public  User getUserByStudentNo(String studentNo);
	/**
	 * 根据id查找用户
	 * @param studentNo
	 * @return
	 */
	public abstract User getUserById(int id);
}