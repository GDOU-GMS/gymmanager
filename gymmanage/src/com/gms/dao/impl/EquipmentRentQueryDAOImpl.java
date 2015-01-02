package com.gms.dao.impl;


import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.gms.dao.EquipmentRentQueryDAO;
import com.gms.domain.Equipment;
import com.gms.domain.EquipmentRentQuery;
import com.gms.utils.JDBCUtils;


public class EquipmentRentQueryDAOImpl implements EquipmentRentQueryDAO{
   
	


	public List<EquipmentRentQuery> getAllEquipmentRent()
    {
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select * from tb_equipmentleasing";
			return (List<EquipmentRentQuery>)qr.query(sql, new BeanListHandler(EquipmentRentQuery.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
    	
    }

	public void deleteEquipmentInfo(int id) {
		// TODO Auto-generated method stub
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "delete from tb_equipmentleasing where id=? ";
			qr.update(sql, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public List<EquipmentRentQuery> getAllEquipmentRentQueryPageData(
			int startIndex, int pageSize) {
		try{
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select tb_equipmentleasing.*,tb_equipment.name from tb_equipmentleasing,tb_equipment where tb_equipmentleasing.equipmentId=tb_equipment.id order by equipmentId,statue limit ?,?";
			Object params[] = {startIndex,pageSize};
			return (List<EquipmentRentQuery>) qr.query(sql, params, new BeanListHandler(EquipmentRentQuery.class));
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	public int getTotalRecord() {
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select count(*) from tb_equipmentleasing";
			long l = (Long) qr.query(sql, new ScalarHandler());
			return (int) l;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	
	public void addEquipRentInfo(EquipmentRentQuery equipmentRents) {
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "insert into tb_equipmentleasing(id,equipmentId,userId,startDate,endDate,price,num,statue) values(?,?,?,?,?,?,?,?)";
			
			Object params[] = { equipmentRents.getId(), equipmentRents.getEquipmentId(),equipmentRents.getUserId(),
					equipmentRents.getStartDate(),equipmentRents.getEndDate(),equipmentRents.getPrice(),
					equipmentRents.getNum(),equipmentRents.getStatue()};
			qr.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}		
	}
	
	
	public void updateEquipmentInfo(EquipmentRentQuery equipmentRents) {
		// TODO Auto-generated method stub
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "update tb_equipmentleasing set id=?,equipmentId=?,userId=? startDate=? endDate=? price=? num=? statue=? where id=?";
			Object params[] = {equipmentRents.getId(),equipmentRents.getEquipmentId(),equipmentRents.getUserId(),
					equipmentRents.getStartDate(),equipmentRents.getEndDate(),equipmentRents.getPrice(),
					equipmentRents.getNum(),equipmentRents.getStatue()};
			qr.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public int getQueryTotalRecord() {
		// TODO Auto-generated method stub
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select count(*) from tb_equipmentleasing where tb_equipmentleasing.equipmentId=tb_equipment.id ";
			long l = (Long) qr.query(sql, new ScalarHandler());
			return (int) l;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<EquipmentRentQuery> queryEquipmentRent(String name,
			String statue, int startIndex, int pageSize) {
		// TODO Auto-generated method stub
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select * from tb_equipmentleasing where tb_equipmentleasing.userId like ? and tb_equipmentleasing.statue like ?  limit ?,?";
			Object params[] = {"%"+name+"%","%"+statue+"%",startIndex,pageSize};
			return (List<EquipmentRentQuery>)qr.query(sql, params, new BeanListHandler(EquipmentRentQuery.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}






	
	
}
