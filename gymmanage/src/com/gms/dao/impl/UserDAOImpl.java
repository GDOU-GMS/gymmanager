package com.gms.dao.impl;


import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.gms.dao.UserDAO;
import com.gms.domain.SiteType;
import com.gms.domain.User;
import com.gms.utils.JDBCUtils;

public class UserDAOImpl implements UserDAO{
	
	/**
	 * 删除用户
	 * @param id
	 */
  
   
   public boolean deleteUser(int id){
	   QueryRunner qr=new QueryRunner(JDBCUtils.getDateSource());
	   String sql="delete from tb_user where id=?";
	   Object param[]={id};
	   try {
		qr.update(sql,id);
		return true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		throw new RuntimeException(e);
	}
	   
   }
   
   /**
    * 查询得到用户信息
    * @param studentNo
    * @param name
    * @param academy
    */
   public List<User> getUsers(String studentNo,String name,String academy){
	   QueryRunner qr=new QueryRunner(JDBCUtils.getDateSource());
	   String sql="select * from tb_user where studentNo like ? and name like ? and academy like ?";
	   Object param[]={"%"+studentNo+"%","%"+name+"%","%"+academy+"%"};
	   try {
		    List list = (List<User>)qr.query(sql, param,new BeanListHandler(User.class));
		    System.out.println(list.isEmpty());
		    return list;
	} catch (SQLException e) {
		throw new RuntimeException(e);
	}
	  
	   
	   
   }
   /**
    * 获得所有用户
    */
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(JDBCUtils.getDateSource());
		   String sql="select * from tb_user";
		   try {
			 
			return (List<User>)qr.query(sql,new BeanListHandler(User.class));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		  
	}
	
	/**
	 * 根据学号查找用户
	 * @param studentNo
	 * @return
	 */
	public User getUserByStudentNo(String studentNo){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select * from tb_user where studentNo=?";
			return (User)qr.query(sql, studentNo, new BeanHandler(User.class));
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	/**
	 * 根据id查找用户
	 * @param studentNo
	 * @return
	 */
	public User getUserById(int id){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select * from tb_user where id=?";
			return (User)qr.query(sql, id, new BeanHandler(User.class));
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
}
