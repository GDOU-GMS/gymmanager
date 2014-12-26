package com.gms.dao;



import java.util.List;

import com.gms.domain.Manager;
import com.gms.domain.User;

public interface ManagerDAO {
	
	
	
	
	/**
	 * ���ӹ���Ա
	 * 
	 * @param Manager
	 */
	public abstract void addManager(Manager mannager);
	
	/**
	 * ���¹���Ա��Ϣ
	 * 
	 * @param Manager
	 */
	public abstract void updateManager(Manager mannager);
	
	/**ɾ�����Ա��Ϣ
	 * 
	 * @param name
	 */
	public abstract boolean deleteManager(int id);
	
	/**
	 * ������й���Ա�û�
	 */
	public  List<Manager>  getAllManager();
	/**
	 * У���¼
	 * @param manager
	 * @return
	 */
	public abstract Manager verifyManager(Manager manager);
	/**
	 * 查询管理员
	 * @param account
	 * @param name
	 * @return
	 */
	
	public abstract List<Manager> getManagers(String account,String name);
	/**
	 * 更新管理员密码
	 * @param id
	 * @param opassword
	 * @param npassword
	 * @return
	 */
	public abstract boolean updatePassword(int id,String oPassword,String  nPassword);
	
	
	public abstract Manager getManagerById(int id);
	
	public abstract int getTotalRecords();
	
	public List<Manager> getAllManagersPageData(int startIndex,int pageSize);
	
	
	public abstract int getTotalRecord(String account,String name);
	
	public List<Manager> getManagersPageData(String account,String name,int startIndex,int pageSize);

}
