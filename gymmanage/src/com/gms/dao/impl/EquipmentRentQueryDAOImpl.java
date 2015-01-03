package com.gms.dao.impl;


import java.sql.SQLException;
import java.util.Date;
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
			String sql = "select tb_equipmentleasing.* ,tb_user.studentNo,tb_user.name as username,tb_equipment.name as equipmentname from tb_equipmentleasing,tb_equipment,tb_user where tb_equipmentleasing.userId=tb_user.id and tb_equipmentleasing.equipmentId= tb_equipment.id order by endDate desc limit ?,?";
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
			String sql = "insert into tb_equipmentleasing(equipmentId,userId,startDate,endDate,price,num,statue) values(?,?,?,?,?,?,?)";
			
			Object params[] = { equipmentRents.getEquipmentId(),equipmentRents.getUserId(),
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

	/**
	 * 获得查询结果总记录数
	 */
	public int getQueryTotalRecord(String name,String statue) {
		// TODO Auto-generated method stub
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select count(*) from tb_equipmentleasing,tb_equipment,tb_user where tb_equipmentleasing.userId=tb_user.id and tb_equipmentleasing.equipmentId= tb_equipment.id and tb_user.studentNo like ? and tb_equipmentleasing.statue like ? ";
			Object params[] = {"%"+name+"%",statue+"%"};
			long l = (Long) qr.query(sql,params, new ScalarHandler());
			return (int) l;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 查询器材预约
	 */
	@Override
	public List<EquipmentRentQuery> queryEquipmentRent(String name,
			String statue, int startIndex, int pageSize) {
		// TODO Auto-generated method stub
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select tb_equipmentleasing.* ,tb_user.studentNo,tb_user.name as username,tb_equipment.name as equipmentname from tb_equipmentleasing,tb_equipment,tb_user where tb_equipmentleasing.userId=tb_user.id and tb_equipmentleasing.equipmentId= tb_equipment.id and tb_user.studentNo like ? and tb_equipmentleasing.statue like ?  order by endDate desc  limit ?,?";
			Object params[] = {"%"+name+"%",statue+"%",startIndex,pageSize};
			return (List<EquipmentRentQuery>)qr.query(sql, params, new BeanListHandler(EquipmentRentQuery.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 根据id查找器材租赁
	 * @param id
	 * @return
	 */
	public EquipmentRentQuery getEquipmentRentQueryById(int id ){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select tb_equipmentleasing.* ,tb_user.studentNo,tb_user.name as username,tb_equipment.name as equipmentname from tb_equipmentleasing,tb_equipment,tb_user where tb_equipmentleasing.userId=tb_user.id and tb_equipmentleasing.equipmentId= tb_equipment.id  and tb_equipmentleasing.id=?";
			return  (EquipmentRentQuery) qr.query(sql, id, new BeanHandler(EquipmentRentQuery.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 更新租赁信息
	 * @param equipmentRents
	 */
	public void updateEquipRentInfo( EquipmentRentQuery equipmentRents){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "update tb_equipmentleasing set equipmentId=? ,userId=? ,startDate=?, endDate=?,price=?,num=?,statue=? where id=?";
			System.out.println(equipmentRents.getNum());
			Object params[] = {equipmentRents.getEquipmentId(),equipmentRents.getUserId(),equipmentRents.getStartDate(),equipmentRents.getEndDate(),equipmentRents.getPrice(),equipmentRents.getNum(),equipmentRents.getStatue(),equipmentRents.getId()};
			qr.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 删除器材租赁
	 * @param id
	 */
	public void deleteEquipmentRentQuery(int id){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "delete from tb_equipmentleasing where id=?";
			qr.update(sql, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 处理过期的租赁
	 */
	public int dealpassedEquipRent(){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "update tb_equipmentleasing set statue='passed' where endDate<?";
			return qr.update(sql, new Date());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	
	
}
