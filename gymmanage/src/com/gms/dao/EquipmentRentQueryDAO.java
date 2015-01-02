package com.gms.dao;

import java.util.List;

import com.gms.domain.EquipmentRentQuery;

public interface EquipmentRentQueryDAO {
     
	/**
	 * 器材租借信息
	 */
	 public abstract List<EquipmentRentQuery> getAllEquipmentRent();
	
	 
	 /**
	  * 获得器材租借分页信息
	  * @param startIndex
	  * @param pageSize
	  * @return
	  */
	 public abstract List<EquipmentRentQuery >getAllEquipmentRentQueryPageData(int startIndex,
				int pageSize);
	 
	 /**
	  * 获得器材租借总记录数
	  * @return
	  */
	 public abstract int getTotalRecord();

	 /**
	  * 添加器材租借信息
	  */
	 public abstract void addEquipRentInfo(EquipmentRentQuery equipmentRents);
	 /**
	  * 删除器材租借信息
	  */
	 public abstract void deleteEquipmentInfo(int id);
     
	 public abstract void updateEquipmentInfo(EquipmentRentQuery equipmentRents);
	 
	 /**
	  * 
	  * 查询条件得出器材租借信息
	  * @param id
	  * @param startIndex
	  * @param pageSize
	  */
	 public abstract List<EquipmentRentQuery> queryEquipmentRent(String name,String statue,int startIndex,int pageSize);
 
     /**
      * 查询条件得出信息的总记录数
     * @param userId 
      * @return
      */
	 public abstract int getQueryTotalRecord();

}
