package com.gms.dao;



import java.util.List;

import com.gms.domain.Manager;

public interface ManagerDAO {
	
	
	/**
	 * 查询管理员信息
	 * @param name
	 */
	public abstract List<Manager> selectManager(String account,String name);
	
	/**
	 * 增加管理员
	 * 
	 * @param Manager
	 */
	public abstract void addManager(Manager mannager);
	
	/**
	 * 更新管理员信息
	 * 
	 * @param Manager
	 */
	public abstract void updateManager(Manager mannager);
	
	/**删除管理员信息
	 * 
	 * @param name
	 */
	public abstract void deleteManager(int id);
	
	/**
	 * 获得所有管理员用户
	 */
	public  List<Manager>  getAllManager();
	/**
	 * 校验登录
	 * @param manager
	 * @return
	 */
	public abstract Manager verifyManager(Manager manager);

}
