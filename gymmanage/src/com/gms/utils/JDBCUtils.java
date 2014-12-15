package com.gms.utils;


import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {

	private static DataSource ds= null;
	//获得数据路连接池
	static {

		ds = new ComboPooledDataSource();
	}
	/**
	 * 获得数据库连接池
	 * @return
	 */
	public static DataSource getDateSource() {
		return ds;
	}
	/**
	 * 获得数据库连接
	 * @return
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
}
