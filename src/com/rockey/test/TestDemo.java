package com.rockey.test;


import java.sql.Date;

import org.junit.Test;

import com.rockey.dao.CustDao;
import com.rockey.domain.Cust;
import com.rockey.factory.BasicFactory;

public class TestDemo {
	
	CustDao dao = BasicFactory.getInstance().getImplInstance(CustDao.class);
	
	@Test
	public void addCust(){
		for(int i = 0; i <100;i++){
			Cust cust = new Cust();
			cust.setName("name"+i);
			cust.setGender("男");
			cust.setBirthday("1990-10-10");
			cust.setCellphone("1526342079"+i);
			cust.setEmail("name"+i+"@qq.com");
			cust.setPreference("篮球");
			cust.setType("钻石VIP");
			cust.setDescription("iqwdiqwiw"+i);
			dao.addCust(cust);
		}
	}
	
}
