package com.gms.dao;

import java.util.List;

import com.gms.domain.EquipmentRentQuery;

public interface EquipmentRentQueryDAO {
     
	/**
	 * 鍣ㄦ潗绉熷�淇℃伅
	 */
	 public abstract List<EquipmentRentQuery> getAllEquipmentRent();
	
	 
	 /**
	  * 鑾峰緱鍣ㄦ潗绉熷�鍒嗛〉淇℃伅
	  * @param startIndex
	  * @param pageSize
	  * @return
	  */
	 public abstract List<EquipmentRentQuery >getAllEquipmentRentQueryPageData(int startIndex,
				int pageSize);
	 
	 /**
	  * 鑾峰緱鍣ㄦ潗绉熷�鎬昏褰曟暟
	  * @return
	  */
	 public abstract int getTotalRecord();

	 /**
	  * 娣诲姞鍣ㄦ潗绉熷�淇℃伅
	  */
	 public abstract void addEquipRentInfo(EquipmentRentQuery equipmentRents);
	 /**
	  * 鍒犻櫎鍣ㄦ潗绉熷�淇℃伅
	  */
	 public abstract void deleteEquipmentInfo(int id);
     
	 public abstract void updateEquipmentInfo(EquipmentRentQuery equipmentRents);
	 
	 /**
	  * 
	  * 鏌ヨ鏉′欢寰楀嚭鍣ㄦ潗绉熷�淇℃伅
	  * @param id
	  * @param startIndex
	  * @param pageSize
	  */
	 public abstract List<EquipmentRentQuery> queryEquipmentRent(String name,String statue,int startIndex,int pageSize);
 
     /**
      * 鏌ヨ鏉′欢寰楀嚭淇℃伅鐨勬�璁板綍鏁�
     * @param userId 
      * @return
      */
	 public abstract int getQueryTotalRecord(String name,String statue);
	 

	/**
	 * 根据id查找器材租赁
	 * @param id
	 * @return
	 */
	public abstract EquipmentRentQuery getEquipmentRentQueryById(int id );
	/**
	 * 更新租赁信息
	 * @param equipmentRents
	 */
	public void updateEquipRentInfo( EquipmentRentQuery equipmentRents);

	/**
	 * 删除器材租赁
	 * @param id
	 */
	public void deleteEquipmentRentQuery(int id);
	/**
	 * 处理过期的租赁
	 */
	public int dealpassedEquipRent();
}
