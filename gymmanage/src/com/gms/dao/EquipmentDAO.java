package com.gms.dao;


import java.util.List;

import com.gms.domain.Equipment;

public interface EquipmentDAO {
     
	/**
	 * 閺傛澘顤冮崳銊︽綏
	 * @param equipment
	 */
	public abstract void addEquipment(Equipment equipment);
	
	/**
	 * 閹碉拷婀侀崳銊︽綏
	 * @param equipment
	 * @return
	 */
	public abstract List<Equipment> getAllEquipment();

	/**
	 * 鑾峰緱鍣ㄦ潗鐨勬�璁板綍鏁�
	 * @return
	 */
	public abstract int getTotalRecord();
     
	/**
	 * 鍒犻櫎鍣ㄦ潗淇℃伅
	 */
	public abstract void deleteEquipment(int id);
	
	/**
	 * 鑾峰緱鍣ㄦ潗鐨勫垎椤垫暟鎹�
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List<Equipment> getAllEquipmentPageData(int startIndex,
			int pageSize);
	
	/**
	 * 鑾峰緱鏌ヨ鍣ㄦ潗缁撴灉
	 * @param name
	 * @param startIndex
	 * @param pageSize
	 * @return 
	 * @return
	 */
	
	public abstract  List<Equipment> queryEquipment(String name,int startIndex,int pageSize);
	
	/**
	 * 鏇存柊鍣ㄦ潗淇℃伅
	 */
	public abstract void updateEquipment(Equipment equipment);
	
	/**
	 * 根据id查找器材
	 * @param id
	 * @return
	 */
	public abstract Equipment getEquipmentById(int id);
	/**
	 * 租赁出去，更新可供借出
	 * @param num
	 * @param id
	 */
	public abstract void updateEquipmentLoanable(int num, int id);
	/**
	 * 器材归还更细可供借出
	 * @param num
	 * @param id
	 */
	public abstract void recoverLoanable(int num,int id);
	
	public  int getQueryTotalRecord(String name);
}
