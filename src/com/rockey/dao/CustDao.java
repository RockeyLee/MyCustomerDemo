package com.rockey.dao;

import java.sql.Connection;
import java.util.List;

import com.rockey.domain.Cust;
import com.rockey.domain.Page;

public interface CustDao {

	/**
	 * add Customer
	 * @param cust
	 */
	void addCust(Cust cust);

	/**
	 * find if a Customer have been exist according to current Customer name
	 * @param name
	 * @return
	 */
	Object findUserByName(String name);

	/**
	 * find all Customer
	 * @return
	 */
	List<Cust> findAllCust();

	/**
	 * delete customer by id
	 * @param custId
	 */
	void deleteCustById(String custId);

	/**
	 * find customer by Id
	 * @param id
	 */
	Cust findCustById(String id);

	/**
	 * update customer
	 * @param cust
	 */
	void updateCust(Cust cust);

	/**
	 * batch delete customer by id
	 * @param conn 
	 * @param id
	 */
	void batchDelCustById(Connection conn, String id);

	/**
	 * find customer and divided by page
	 * @param from start index 
	 * @param rowpage number of items in page
	 * @return
	 */
	List<Cust> findCustShowInPage(int from, int rowpage);

	/**
	 * get count of all customer
	 * @return int value ,number of all customer
	 */
	int getRowCount();


}
