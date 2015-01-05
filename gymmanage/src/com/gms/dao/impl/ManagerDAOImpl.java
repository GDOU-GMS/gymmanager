package com.gms.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.gms.dao.ManagerDAO;
import com.gms.domain.Manager;
import com.gms.domain.User;
import com.gms.utils.JDBCUtils;

public class ManagerDAOImpl implements ManagerDAO{

	boolean flag;
	@Override
	public void addManager(Manager manager) {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(JDBCUtils.getDateSource());
		String sql="insert into tb_admin(account,password,permission,"
				+ "name,telephone,birthday,email,address)values(?,?,?,?,?,?,?,?)";
		Object param[]={manager.getAccount(),manager.getPassword(),"manager",manager.getName(),
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
	public void updateManager(Manager manager) {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(JDBCUtils.getDateSource());
		String sql="update tb_admin set account =?,name=?,telephone =?,birthday=?,email=?,address=? "
				+ "where id=? ";
		System.out.println(manager.getId());
		Object param[]={manager.getAccount(),manager.getName(),manager.getTelephone(),
				manager.getBirthday(),manager.getEmail(),manager.getAddress(),manager.getId()};
		try {
			qr.update(sql,param);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public boolean deleteManager(int id) {
		// TODO Auto-generated method stub
		 QueryRunner qr=new QueryRunner(JDBCUtils.getDateSource());
		   String sql="delete from tb_admin where id=?";
		   Object param[]={id};
		   try {
			qr.update(sql,id);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public List<Manager> getAllManager() {
		// TODO Auto-generated method stub
				QueryRunner qr=new QueryRunner(JDBCUtils.getDateSource());
				   String sql="select * from tb_admin where permission=?";
				   Object param="manager";
				   try {
					 
					   return (List<Manager>)qr.query(sql, param,new BeanListHandler(Manager.class));
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw new RuntimeException(e);
				}
	}
	
	/**
	 * 
	 * @param manager
	 * @return
	 */
	public Manager verifyManager(Manager manager){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select * from tb_admin where permission=? and account=? and password=?";
			Object params[] = {manager.getPermission(),manager.getAccount(),manager.getPassword()};
			return (Manager)qr.query(sql, params, new BeanHandler(Manager.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Manager> getManagers(String account, String name) {
		// TODO Auto-generated method stub
				QueryRunner qr=new QueryRunner(JDBCUtils.getDateSource());
				String sql="select * from tb_admin where account like ? and  name like ?and permission=?";
				Object param[]={"%"+account+"","%"+name+"%","manager"};
				try {
					return (List<Manager>)qr.query(sql, param,new BeanListHandler(Manager.class));
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw new RuntimeException(e);
				}
	}

	@Override
	public boolean updatePassword(int id, String oPassword, String nPassword) {
		// TODO Auto-generated method stub
	    
				QueryRunner qr=new QueryRunner(JDBCUtils.getDateSource());
				String sql="select password from tb_admin where id=?";
				Object param1=id;
				try {
					String pwd=(String)qr.query(sql, param1,new ScalarHandler());
					if(pwd.equals(oPassword)){
						flag=true;
					}else{
						return false;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw new RuntimeException(e);
				}
				sql="update tb_admin set password=? where id=?";
				Object param2[]={nPassword,id};
				try {
					qr.update(sql,param2);
					flag=true;
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw new RuntimeException(e);
				}
				return flag;
	}

	@Override
	public Manager getManagerById(int id) {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(JDBCUtils.getDateSource());
		String sql="select * from tb_admin where id=?";
		Object param=id;
		try {
			return (Manager)qr.query(sql, param,new BeanHandler(Manager.class));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public int getTotalRecords() {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(JDBCUtils.getDateSource());
		String sql="select count(*) from tb_admin where permission=?";
		Object param="manager";
		try {
			long l=(Long) qr.query(sql,param, new ScalarHandler());
			System.out.println(l);
			return (int)l;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public List<Manager> getAllManagersPageData(int startIndex, int pageSize) {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(JDBCUtils.getDateSource());
		   String sql="select * from tb_admin where permission=? limit ?,?";
		   Object param[]={"manager",startIndex,pageSize};
		   try {
			   return (List<Manager>)qr.query(sql,param,new BeanListHandler(Manager.class));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	@Override
	public int getTotalRecord(String account, String name) {
		// TODO Auto-generated method stub
		 QueryRunner qr=new QueryRunner(JDBCUtils.getDateSource());
		 String sql="select count(*) from tb_admin where account like ? and  name like ?and permission=?";
		 Object param[]={"%"+account+"%","%"+name+"%","manager"};
		 try {
			    long l =   (Long) qr.query(sql, param,new ScalarHandler());
			    return (int)l;
		 } catch (SQLException e) {
			throw new RuntimeException(e);
		 }
		
	}

	@Override
	public List<Manager> getManagersPageData(String account, String name,
			int startIndex, int pageSize) {
		// TODO Auto-generated method stub
		try{
			
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select * from tb_admin where account like ? and  name like ?and permission=? limit ?,?";
			Object params[] = {"%"+account+"","%"+name+"%","manager",startIndex,pageSize};
			return (List<Manager>) qr.query(sql, params, new BeanListHandler(Manager.class));
			
		}catch(Exception e){
			
			throw new RuntimeException(e);
		}
	
	}

	public Manager getMangerByAccount(String account){
		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getDateSource());
			String sql = "select * from tb_admin where account=?";
			return (Manager) qr.query(sql, account, new BeanHandler(Manager.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	


	

}
