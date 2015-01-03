package com.gms.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.gms.dao.EquipmentTypeDAO;
import com.gms.dao.SiteTypeDAO;
import com.gms.domain.EquipmentType;
import com.gms.domain.SiteType;
import com.gms.utils.JDBCUtils;

public class EquipmentTypeDAOImpl implements EquipmentTypeDAO{

	/**
	 * 添加器材
	 * @param siteType
	 */
	public void addType(EquipmentType equipmentType){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "insert into tb_equipmenttype(type) values(?)";
			qr.update(sql, equipmentType.getType());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 *修改器材类型
	 * @param siteType
	 */
	public void updateType(EquipmentType equipmentType){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "update tb_equipmenttype set type=? where id=?";
			Object params[] = {equipmentType.getType(),equipmentType.getId()};
			qr.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 删除器材类型
	 * @param id
	 */
	public void deleteType(int id){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "delete from tb_equipmenttype where id=?";
			qr.update(sql, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 获取所有器材类型
	 * @return
	 */
	public List<EquipmentType> getAllEquipmentType(){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select * from tb_equipmenttype";
			return (List<EquipmentType>) qr.query(sql, new BeanListHandler(EquipmentType.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 根据id查找器材类型
	 * @param id
	 * @return
	 */
	public EquipmentType getEquipmentTypeById(int id){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select * from tb_equipmenttype where id=?";
			return (EquipmentType) qr.query(sql, id, new BeanHandler(EquipmentType.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 判断该器材类型是否被使用
	 * @param typeId
	 * @return
	 */
	public int checkEquipmentTypeIsUsed(int typeId){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select count(*) from tb_equipment where typeId=?";
			long l = (Long)qr.query(sql, typeId,new ScalarHandler());
			return (int)l;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
