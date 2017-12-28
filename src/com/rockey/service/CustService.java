package com.rockey.service;

import java.util.List;

import com.rockey.domain.Cust;
import com.rockey.domain.Page;

public interface CustService {
	
	/**
	 * add Customer
	 * @param cust cust info get from request 
	 */
	void addCust(Cust cust);

	/**
	 * find all Customer
	 * @return
	 */
	List<Cust> findAllCust();

	/**
	 * delete Customer by Id
	 * @param custId
	 */
	void deleteCust(String custId);

	/**
	 * find customer by id
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
	 * @param ids
	 */
	void batchDelCustById(String[] ids);


	/**
	 * find customer list divided by page
	 * @param thispage current page 
	 * @param rowpage number of items in one page
	 * @return
	 */
	Page findCustShowInPage(int thispage, int rowpage);

}
