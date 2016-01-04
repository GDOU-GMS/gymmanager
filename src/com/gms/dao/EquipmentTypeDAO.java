package com.gms.dao;

import java.util.List;

import com.gms.domain.EquipmentType;

public interface EquipmentTypeDAO {

	/**
	 * 添加器材
	 * @param siteType
	 */
	public abstract void addType(EquipmentType equipmentType);

	/**
	 *修改器材类型
	 * @param siteType
	 */
	public abstract void updateType(EquipmentType equipmentType);

	/**
	 * 删除器材类型
	 * @param id
	 */
	public abstract void deleteType(int id);

	/**
	 * 获取所有器材类型
	 * @return
	 */
	public abstract List<EquipmentType> getAllEquipmentType();

	/**
	 * 根据id查找器材类型
	 * @param id
	 * @return
	 */
	public abstract EquipmentType getEquipmentTypeById(int id);

	/**
	 * 判断该器材类型是否被使用
	 * @param typeId
	 * @return
	 */
	public abstract int checkEquipmentTypeIsUsed(int typeId);

}