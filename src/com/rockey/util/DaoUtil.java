package com.rockey.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DaoUtil {
	//create c3p0 datasoure
	private static ComboPooledDataSource mCpds =new ComboPooledDataSource();
	
	private DaoUtil(){
		
	}
	
	/**
	 * get datasource
	 * @return DataSource
	 */
	public static DataSource getDataSource(){
		return mCpds;
	}
	
	/**
	 * get connection of database from datasource
	 * @return Connection 
	 */
	public static Connection getConnection(){
		try {
			return mCpds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
