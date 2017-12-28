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

public class AddCustServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		try {
			//get all parameters from request
			CustService custservice = BasicFactory.getInstance().getImplInstance(CustService.class);
			Cust cust = new Cust();
			BeanUtils.populate(cust, request.getParameterMap());
			
			// handle preference option alone,"xxx,xxx,xxx" 
			String[] prefs = request.getParameterValues("preference");
			StringBuilder sb =new StringBuilder();
			for(String pref:prefs){
				sb.append(pref+",");
			}
			cust.setPreference(sb.substring(0, sb.length()-1).toString());
			// add  new cust to database
			custservice.addCust(cust);
			
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
