package com.rockey.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.rockey.domain.Cust;
import com.rockey.domain.Page;
import com.rockey.factory.BasicFactory;
import com.rockey.service.CustService;
import com.rockey.util.DaoUtil;

public class ListCustServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		CustService custservice = BasicFactory.getInstance().getImplInstance(
				CustService.class);
		int thispage =Integer.parseInt(request.getParameter("thispage"));
		int rowpage = BasicFactory.getRowPage(); 
		// get Page object ,show in listCust.jsp
		Page page = custservice.findCustShowInPage(thispage,rowpage);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/listCust.jsp")
				.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
