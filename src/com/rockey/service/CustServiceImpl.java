package com.rockey.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import com.rockey.dao.CustDao;
import com.rockey.domain.Cust;
import com.rockey.domain.Page;
import com.rockey.factory.BasicFactory;
import com.rockey.util.DaoUtil;

public class CustServiceImpl implements CustService {

	private CustDao custdao = BasicFactory.getInstance().getImplInstance(CustDao.class);
	public void addCust(Cust cust) {
		if(custdao.findUserByName(cust.getName())!=null){
			throw new RuntimeException("用户已存在");
		}
		custdao.addCust(cust);
	}
	public List<Cust> findAllCust() {
		// TODO Auto-generated method stub
		
		return custdao.findAllCust();
	}
	public void deleteCust(String custId) {
		// TODO Auto-generated method stub
		custdao.deleteCustById(custId);
	}
	public Cust findCustById(String id) {
		// TODO Auto-generated method stub
		return custdao.findCustById(id);
	}
	public void updateCust(Cust cust) {
		// TODO Auto-generated method stub
		custdao.updateCust(cust);
	}
	public void batchDelCustById(String[] ids) {
		// TODO Auto-generated method stub
		Connection conn  = DaoUtil.getConnection();
		try {
			conn.setAutoCommit(false);
			for(String id:ids){
				custdao.batchDelCustById(conn,id);
			}
			DbUtils.commitAndCloseQuietly(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			DbUtils.rollbackAndCloseQuietly(conn);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	public Page findCustShowInPage(int thispage, int rowpage) {
		Page page = new Page();
		page.setThispage(thispage);
		page.setRowpage(rowpage);
		page.setFirstpage(1);
		int rowcount = custdao.getRowCount();
		page.setRowcount(rowcount);
		int pagecount = rowcount/rowpage+(rowcount%rowpage==0?0:1);
		page.setPagecount(pagecount);
		page.setLastpage(pagecount);
		page.setPrepage(thispage==1?1:thispage-1);
		page.setNextpage(thispage==pagecount?pagecount:thispage+1);
		page.setList(custdao.findCustShowInPage((thispage-1)*rowpage,rowpage));
		return page;
	}

}
