package com.gms.dao;



import java.util.List;

import com.gms.domain.Manager;
import com.gms.domain.User;

public interface ManagerDAO {
	
	
	
	
	/**
	 * 锟斤拷锟接癸拷锟斤拷员
	 * 
	 * @param Manager
	 */
	public abstract void addManager(Manager mannager);
	
	/**
	 * 锟斤拷锟铰癸拷锟斤拷员锟斤拷息
	 * 
	 * @param Manager
	 */
	public abstract void updateManager(Manager mannager);
	
	/**删锟斤拷锟斤拷锟皆憋拷锟较�
	 * 
	 * @param name
	 */
	public abstract boolean deleteManager(int id);
	
	/**
	 * 锟斤拷锟斤拷锟斤拷泄锟斤拷锟皆憋拷没锟�
	 */
	public  List<Manager>  getAllManager();
	/**
	 * 校锟斤拷锟铰�
	 * @param manager
	 * @return
	 */
	public abstract Manager verifyManager(Manager manager);
	/**
	 * 鏌ヨ绠＄悊鍛�
	 * @param account
	 * @param name
	 * @return
	 */
	
	public abstract List<Manager> getManagers(String account,String name);
	/**
	 * 鏇存柊绠＄悊鍛樺瘑鐮�
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
