package com.rockey.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rockey.factory.BasicFactory;
import com.rockey.service.CustService;

public class DeleteCustServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		CustService custservice = BasicFactory.getInstance().getImplInstance(CustService.class);
		//get id and pagenum from request
		String custId = request.getParameter("custId");
		String pagenum = request.getParameter("pagenum");
		custservice.deleteCust(custId);
		response.sendRedirect(request.getContextPath()+"/servlet/ListCustServlet?thispage="+pagenum);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
