package com.rockey.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.rockey.domain.Cust;
import com.rockey.factory.BasicFactory;
import com.rockey.service.CustService;
import com.rockey.util.DaoUtil;

public class ModifyCustServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		CustService custservice = BasicFactory.getInstance().getImplInstance(CustService.class);
		//get id and pagenum from request
		String id = request.getParameter("custId");
		String pagenum = request.getParameter("pagenum");
		Cust cust = custservice.findCustById(id);
		if(cust==null){
			throw new RuntimeException("此数据不存在，请确认");
		}
		request.setAttribute("cust", cust);
		request.setAttribute("pagenum", pagenum);
		request.getRequestDispatcher("/modifyCust.jsp").forward(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
