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
	
	
	/**
	 * 条件查询获得记录
	 * @param studentNo
	 * @param name
	 * @param academy
	 * @return
	 */
	public abstract int getTotalRecord(String studentNo,String name,String academy);
	
	/**
	 * 获得所有记录
	 * @return
	 */
	public abstract int getTotalRecords();
	
	/**
	 * 条件查询部分用户分页获取数据
	 * @param startIndex
	 * @param pageSize
	 * @param studentNo
	 * @param name
	 * @param academy
	 * @return
	 */
	public List<User> getUsersPageData(int startIndex,int pageSize,String studentNo,String name,String academy);
	
	
	/**
	 *所有用户分页获取数据
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	
	public List<User> getAllUsersPageData(int startIndex,int pageSize);
	
	
	
}