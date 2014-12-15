package com.gms.utils;


import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {

	private static DataSource ds= null;
	//�������·���ӳ�
	static {

		ds = new ComboPooledDataSource();
	}
	/**
	 * ������ݿ����ӳ�
	 * @return
	 */
	public static DataSource getDateSource() {
		return ds;
	}
	/**
	 * ������ݿ�����
	 * @return
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
}
