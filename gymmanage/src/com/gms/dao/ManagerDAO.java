package com.gms.dao;



import java.util.List;

import com.gms.domain.Manager;

public interface ManagerDAO {
	
	
	/**
	 * ��ѯ����Ա��Ϣ
	 * @param name
	 */
	public abstract List<Manager> selectManager(String account,String name);
	
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
	
	/**ɾ������Ա��Ϣ
	 * 
	 * @param name
	 */
	public abstract void deleteManager(int id);
	
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

}
