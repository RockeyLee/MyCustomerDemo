<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
    <h1>客户管理系统</h1><hr>
    <a href="${pageContext.request.contextPath}/addCust.jsp">添加客户</a><br>
    <a href="${pageContext.request.contextPath}/servlet/ListCustServlet?thispage=1">客户列表</a><br>
  </body>
</html>
