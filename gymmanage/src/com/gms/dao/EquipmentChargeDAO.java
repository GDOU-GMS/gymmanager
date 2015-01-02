package com.gms.dao;

import java.util.List;

import com.gms.domain.EquipmentCharge;
public interface EquipmentChargeDAO {

	 /**
	  * 获得器材信息收费标准记录
	  * @param startIndex
	  * @param pageSize
	  * @return
	  */
	 public List<EquipmentCharge> getAllEquipmentChargePageData(int startIndex,
				int pageSize);
	 
	 /**
	  * 设置器材收费标准
	  */
     public abstract void setEquipmentCharge(EquipmentCharge equipmentCharge);
     
     /**
      * 删除器材收费标准信息
      * @param id
      */
     public abstract void deleteEquipmentCharge(int id);
     
     public abstract void updateEquipmentCharge(EquipmentCharge equipmentCharge); 
     
     /**
      * 得到器材收费标准总记录数
      * @return
      */
 	 public abstract int getTotalRecord();
 	 
 	 /**
 	  * 查询器材收费标准
 	  */
 	 public abstract List<EquipmentCharge> queryEquipmentCharge(String type,int startIndex,int pageSize);
 	 
 	 /**
 	  * 获得收费标准查询记录数
 	  * @return
 	  */
 	 public abstract int getQueryTotalRecord(String type);

 	 /**
 	  * 获得所有收费标准信息
 	  * @return
 	  */
	public List<EquipmentCharge> getAllEquipmentCharge();
}