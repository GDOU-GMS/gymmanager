package com.gms.dao;

import java.util.List;

import com.gms.domain.User;

public interface UserDAO {
	public abstract boolean deleteUser(int id);

	public abstract List<User> getUsers(String studentNo, String name,
			String academy);
	public  List<User> getAllUsers();

	/**
	 * ����ѧ�Ų����û�
	 * @param studentNo
	 * @return
	 */
	public  User getUserByStudentNo(String studentNo);
	/**
	 * ����id�����û�
	 * @param studentNo
	 * @return
	 */
	public abstract User getUserById(int id);
}