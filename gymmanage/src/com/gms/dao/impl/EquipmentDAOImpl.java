package com.gms.dao.impl;


import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.gms.dao.EquipmentDAO;
import com.gms.domain.Equipment;
import com.gms.utils.JDBCUtils;
import com.gms.vo.SiteVo;

public class EquipmentDAOImpl implements EquipmentDAO{
	
	
	public void addEquipment(Equipment equipment) {
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "insert into tb_equipment(name,description,totalNum,typeId,loanable,underRepair) values(?,?,?,?,?,?)";
			Object params[] = {equipment.getName(),equipment.getDescription(),
					equipment.getTotalNum(),equipment.getTypeId(),equipment.getLoanable(),equipment.getUnderRepair() };
			qr.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	public List<Equipment> getAllEquipment() {
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select * from tb_equipment";
			return (List<Equipment>)qr.query(sql, new BeanListHandler(Equipment.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public int getTotalRecord() {
		// TODO Auto-generated method stub
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select count(*) from tb_equipment,tb_equipmenttype where tb_equipment.typeid=tb_equipmenttype.id";
			long l = (Long) qr.query(sql, new ScalarHandler());
			return (int) l;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public List<Equipment> getAllEquipmentPageData(int startIndex, int pageSize) {
		// TODO Auto-generated method stub
		try{
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select tb_equipment.*,tb_equipmenttype.type,tb_equipmenttype.feescale from tb_equipment,tb_equipmenttype where tb_equipment.typeid=tb_equipmenttype.id limit ?,?";
			Object params[] = {startIndex,pageSize};
			return (List<Equipment>) qr.query(sql, params, new BeanListHandler(Equipment.class));
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	
	}

	public void deleteEquipment(int id) {
		// TODO Auto-generated method stub
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "delete from tb_equipment where id=?";
			qr.update(sql, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public List<Equipment> queryEquipment(String name,int startIndex,int pageSize) {
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select tb_equipment.*,tb_equipmenttype.type,tb_equipmenttype.feescale from tb_equipment,tb_equipmenttype where tb_equipment.typeid=tb_equipmenttype.id and tb_equipment.name like ? limit ?,?";
			Object params[] = {"%"+name+"%",startIndex,pageSize};
			return (List<Equipment>)qr.query(sql, params, new BeanListHandler(Equipment.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	
	public  int getQueryTotalRecord(String name) {
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select count(*) from tb_equipment,tb_equipmenttype where tb_equipment.typeid=tb_equipmenttype.id and tb_equipment.name like ?";
			long l = (Long)qr.query(sql, "%"+name+"%", new ScalarHandler());
			return (int) l;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	
	public void updateEquipment(Equipment equipment) {
		// TODO Auto-generated method stub
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "update tb_equipment set name=?,description=?,loanable=?,totalNum=?,typeId=?,underRepair=? where id=?";
			Object params[] = {equipment.getName(),equipment.getDescription(),
					equipment.getLoanable(),equipment.getTotalNum(),equipment.getTypeId(),
					equipment.getUnderRepair(),equipment.getId()};
			qr.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 根据id查找器材
	 * @param id
	 * @return
	 */
	public Equipment getEquipmentById(int id){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select * from tb_equipment where id=?";
			return (Equipment)qr.query(sql, id, new BeanHandler(Equipment.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	
	/**
	 * 租赁出去，更新可供借出
	 * @param num
	 * @param id
	 */
	public void updateEquipmentLoanable(int num, int id){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "update tb_equipment set loanable=loanable-? where id=?";
			Object params[] = {num,id};
			qr.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 器材归还更细可供借出
	 * @param num
	 * @param id
	 */
	public void recoverLoanable(int num,int id){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "update tb_equipment set loanable=loanable+? where id=?";
			Object params[] = {num,id};
			qr.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	}
	
	
	

