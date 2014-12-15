package com.gms.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.gms.dao.ManagerDAO;
import com.gms.domain.Manager;
import com.gms.utils.JDBCUtils;

public class ManagerDAOImpl implements ManagerDAO{

	@Override
	public List<Manager> selectManager(String account, String name) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public void addManager(Manager manager) {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(JDBCUtils.getDateSource());
		String sql="insert into tb_admin(account,password,permission,"
				+ "name,telephone,birthday,email,address)values(?,?,?,?,?,?,?,?)";
		Object param[]={manager.getAccount(),manager.getPassword(),"π‹¿Ì‘±",manager.getName(),
				manager.getTelephone(),manager.getBirthday(),manager.getEmail(),
				manager.getAddress()};
		try {
			qr.update(sql, param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void updateManager(Manager mannager) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteManager(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Manager> getAllManager() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
