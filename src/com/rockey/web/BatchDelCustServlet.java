package com.rockey.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rockey.factory.BasicFactory;
import com.rockey.service.CustService;

public class BatchDelCustServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		CustService custservice = BasicFactory.getInstance().getImplInstance(
				CustService.class);
		String[] ids = request.getParameterValues("delId");
		String pagenum = request.getParameter("pagenum");
		custservice.batchDelCustById(ids);
		request.getRequestDispatcher("/servlet/ListCustServlet?thispage="+pagenum).forward(request,response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
