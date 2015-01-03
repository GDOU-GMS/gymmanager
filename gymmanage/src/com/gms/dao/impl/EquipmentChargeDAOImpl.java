package com.gms.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.gms.dao.EquipmentChargeDAO;
import com.gms.domain.Equipment;
import com.gms.domain.EquipmentCharge;
import com.gms.utils.JDBCUtils;

public class EquipmentChargeDAOImpl  implements EquipmentChargeDAO{

	
	public List<EquipmentCharge> getAllEquipmentChargePageData(int startIndex,
			int pageSize) {
		// TODO Auto-generated method stub
		try{
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select * from tb_equipmenttype limit ?,?";
			Object params[] = {startIndex,pageSize};
			return (List<EquipmentCharge>) qr.query(sql, params, new BeanListHandler(EquipmentCharge.class));
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	
	public void setEquipmentCharge(EquipmentCharge equipmentCharge) {
		// TODO Auto-generated method stub
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "update tb_equipmenttype set feescale=?";
			qr.update(sql, equipmentCharge.getFeescale());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


	public void deleteEquipmentCharge(int id) {
		// TODO Auto-generated method stub
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "delete from tb_equipmenttype where id=? ";
			qr.update(sql, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void updateEquipmentCharge(EquipmentCharge equipmentCharge) {
		// TODO Auto-generated method stub
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "update tb_equipmenttype set id=?,type=?,feescale=? where id=?";
			Object params[] = {equipmentCharge.getId(),equipmentCharge.getType(),equipmentCharge.getFeescale()};
			qr.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}




	public int getTotalRecord() {
		// TODO Auto-generated method stub
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select count(*) from tb_equipmenttype ";
			long l = (Long) qr.query(sql, new ScalarHandler());
			return (int) l;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public List<EquipmentCharge> queryEquipmentCharge(String type,int startIndex,int pageSize) {
		// TODO Auto-generated method stub
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select * from tb_equipmenttype where tb_equipmenttype.type like ? limit ?,?";
			Object params[] = {"%"+type+"%",startIndex,pageSize};
			return (List<EquipmentCharge>)qr.query(sql, params, new BeanListHandler(EquipmentCharge.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	
	public int getQueryTotalRecord(String type) {
		// TODO Auto-generated method stub
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select count(*) from tb_equipmenttype where type like ? ";
			Object params[] = {"%"+type+"%"};
			long l = (Long)qr.query(sql, params, new ScalarHandler());
			return (int) l;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


	public List<EquipmentCharge> getAllEquipmentCharge() {
		// TODO Auto-generated method stub
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select * from tb_equipmenttype";
			return (List<EquipmentCharge>)qr.query(sql, new BeanListHandler(Equipment.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * ¸ù¾Ýid²éÕÒ
	 * @param id
	 * @return
	 */
	public EquipmentCharge getEquipmentChargeById(int id ){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select * from tb_equipmenttype where id=?";
			return (EquipmentCharge) qr.query(sql, id,new BeanHandler(EquipmentCharge.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
