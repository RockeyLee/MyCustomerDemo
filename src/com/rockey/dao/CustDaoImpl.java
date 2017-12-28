package com.rockey.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.rockey.domain.Cust;
import com.rockey.domain.Page;
import com.rockey.util.DaoUtil;

public class CustDaoImpl implements CustDao {

	public void addCust(Cust cust) {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(DaoUtil.getDataSource());
		String sql ="insert into customer values(null,?,?,?,?,?,?,?,?)";
		try {
			qr.update(sql,cust.getName(),cust.getGender(),cust.getBirthday(),cust.getCellphone(),cust.getEmail(),cust.getPreference(),cust.getType(),cust.getDescription());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public Object findUserByName(String name) {
		QueryRunner qr = new QueryRunner(DaoUtil.getDataSource());
		String sql = "select * from customer where name = ?";
		try {
			return (Cust) qr.query(sql, new BeanHandler(Cust.class),name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<Cust> findAllCust() {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(DaoUtil.getDataSource());
		String sql = "select * from customer";
		List<Cust> list =null;
		try {
			 list = qr.query(sql, new BeanListHandler<Cust>(Cust.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public void deleteCustById(String custId) {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(DaoUtil.getDataSource());
		String sql = "delete from customer where id=?";
		try {
			qr.update(sql, custId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public Cust findCustById(String id) {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(DaoUtil.getDataSource());
		String sql = "select * from customer where id=?";
		Cust cust=null;
		try {
			cust = (Cust) qr.query(sql, new BeanHandler(Cust.class),id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return cust;
	}

	public void updateCust(Cust cust) {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(DaoUtil.getDataSource());
		String sql = "update customer set name=?, gender=?,birthday=?,cellphone=?,email=?,preference=?,type=?,description=? where id=? ";
		try {
			qr.update(sql ,cust.getName(), cust.getGender(),cust.getBirthday(),cust.getCellphone(),cust.getEmail(),cust.getPreference(),cust.getType(),cust.getDescription(),cust.getId() );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void batchDelCustById(Connection conn, String id) {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner();
		String sql = "delete from customer where id=?";
		try {
			qr.update(conn, sql, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<Cust> findCustShowInPage(int from, int rowpage) {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(DaoUtil.getDataSource());
		String sql = "select * from customer limit ?,?";
		
		try {
			return qr.query(sql, new BeanListHandler<Cust>(Cust.class),from,rowpage);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(DaoUtil.getDataSource());
		String sql = "select count(*) from customer";
		try {
			return ((Long)qr.query(sql, new ScalarHandler())).intValue();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
