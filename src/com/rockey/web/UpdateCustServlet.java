package com.rockey.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.rockey.domain.Cust;
import com.rockey.factory.BasicFactory;
import com.rockey.service.CustService;

public class UpdateCustServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		CustService custservice = BasicFactory.getInstance().getImplInstance(CustService.class);
		String pagenum = request.getParameter("pagenum");
		Cust cust = new Cust();
		try {
			//get new customer after modify
			BeanUtils.populate(cust,request.getParameterMap());
			//handle preference alone
			String[] prefs = request.getParameterValues("preference");
			StringBuilder sb =new StringBuilder();
			for(String pref: prefs){
				sb.append(pref+",");
			}
			cust.setPreference(sb.substring(0,sb.length()-1).toString());
			//update database 
			custservice.updateCust(cust);
			response.sendRedirect(request.getContextPath()+"/servlet/ListCustServlet?thispage="+pagenum);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
