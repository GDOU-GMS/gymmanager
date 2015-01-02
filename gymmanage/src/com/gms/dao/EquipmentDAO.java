package com.gms.dao;


import java.util.List;

import com.gms.domain.Equipment;

public interface EquipmentDAO {
     
	/**
	 * 鏂板鍣ㄦ潗
	 * @param equipment
	 */
	public abstract void addEquipment(Equipment equipment);
	
	/**
	 * 鎵�湁鍣ㄦ潗
	 * @param equipment
	 * @return
	 */
	public abstract List<Equipment> getAllEquipment();

	/**
	 * 获得器材的总记录数
	 * @return
	 */
	public abstract int getTotalRecord();
     
	/**
	 * 删除器材信息
	 */
	public abstract void deleteEquipment(int id);
	
	/**
	 * 获得器材的分页数据
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public List<Equipment> getAllEquipmentPageData(int startIndex,
			int pageSize);
	
	/**
	 * 获得查询器材结果
	 * @param name
	 * @param startIndex
	 * @param pageSize
	 * @return 
	 * @return
	 */
	
	public abstract  List<Equipment> queryEquipment(String name,int startIndex,int pageSize);
	
	/**
	 * 更新器材信息
	 */
	public abstract void updateEquipment(Equipment equipment);

}
