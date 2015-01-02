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
			String sql = "insert into tb_equipment(id,name,description,totalNum,typeId,type,loanable,underRepair) values(?,?,?,?,?,?,?,?)";
			Object params[] = { equipment.getId(), equipment.getName(),equipment.getDescription(),
					equipment.getTotalNum(),equipment.getTypeId() };
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
			String sql = "select count(*) from tb_equipment,tb_equipmenttype where tb_equipment.id=tb_equipmenttype.id";
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
			String sql = "select tb_equipment.*,tb_equipmenttype.type from tb_equipment,tb_equipmenttype where tb_equipment.id=tb_equipmenttype.id limit ?,?";
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
		// TODO Auto-generated method stub
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select tb_equipment.*,tb_equipmenttype.type from tb_equipment,tb_equipmenttype where tb_equipment.name like ? and tb_equipment.id=tb_equipmenttype.id  limit ?,?";
			Object params[] = {"%"+name+"%",startIndex,pageSize};
			return (List<Equipment>)qr.query(sql, params, new BeanListHandler(Equipment.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	
	public  int getQueryTotalRecord(String name) {
		// TODO Auto-generated method stub
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select count(*) from tb_equipment where tb_equipment.name like ? ";
			Object params[] = {"%"+name+"%"};
			long l = (Long)qr.query(sql, params, new ScalarHandler());
			return (int) l;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	
	public void updateEquipment(Equipment equipment) {
		// TODO Auto-generated method stub
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "update tb_equipment,tb_equipmenttype set name=?,description=? loanable=? totalNum=? typeId=? underRepair=?,type=? where tb_equipment.id=?";
			Object params[] = {equipment.getName(),equipment.getDescription(),
					equipment.getLoanable(),equipment.getTotalNum(),equipment.getTypeId(),
					equipment.getUnderRepair(),equipment.getType()};
			qr.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


	}
	
	
	

