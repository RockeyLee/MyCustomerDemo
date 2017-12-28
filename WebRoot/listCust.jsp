<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<script type="text/javascript">
  		function chooseAll(allC){
  			var others = document.getElementsByName("delId");
  			for(var i = 0 ;i < others.length;i++){
  				others[i].checked = allC.checked;
  			}
  		}
  		function changepage(obj){
  			if(isNaN(obj.value)){
  				alert("必须是数字");
  				obj.value=${page.thispage}
  				return;
  			}else if(obj.value > ${page.pagecount}||obj.value <=0){
  				alert("必须在页数范围内");
  				obj.value=${page.thispage}
  				return;
  			}else{
  				window.location.href="${pageContext.request.contextPath}/servlet/ListCustServlet?thispage="+obj.value;
  			}
  			
  		}
  	</script>
  </head>
  
  <body style="text-align: center;">
    <h1>客户管理系统_用户列表</h1><hr>
    <form action="${pageContext.request.contextPath }/servlet/BatchDelCustServlet?pagenum=${page.thispage}" method="post">
    	<table border="1dp" width="100%">
    		<tr>
    			<th><input type ="checkbox" onclick="chooseAll(this)"/>全选</th>
    			<th>用户姓名</th>
    			<th>用户性别</th>
    			<th>用户生日</th>
    			<th>用户电话</th>
    			<th>用户邮箱</th>
    			<th>用户爱好</th>
    			<th>用户类型</th>
    			<th>用户描述</th>
    			<th>修改用户</th>
    			<th>删除用户</th>
    		</tr>
    		<c:forEach items="${requestScope.page.list}" var="cust">
    			<tr>
    				<td><input type ="checkbox" name="delId" value="${cust.id }"/></td>
    				<td><c:out value="${cust.name }"></c:out></td>
    				<td><c:out value="${cust.gender }"></c:out></td>
    				<td><c:out value="${cust.birthday }"></c:out></td>
    				<td><c:out value="${cust.cellphone }"></c:out></td>
    				<td><c:out value="${cust.email }"></c:out></td>
    				<td><c:out value="${cust.preference }"></c:out></td>
    				<td><c:out value="${cust.type }"></c:out></td>
    				<td><c:out value="${cust.description }"></c:out></td>
    				<td><a href="${pageContext.request.contextPath}/servlet/ModifyCustServlet?custId=${cust.id}&pagenum=${page.thispage }">修改</a></td>
    				<td><a href="${pageContext.request.contextPath}/servlet/DeleteCustServlet?custId=${cust.id}&pagenum=${page.thispage }">删除</a></td>
    			</tr>
    		</c:forEach>
    	</table>
    <input type="submit" value="batch delete"/>
    共${page.rowcount}条记录，共${page.pagecount }页
    	<c:if test="${page.thispage==page.firstpage}">
    		首页
    	</c:if>
    	<c:if test="${page.thispage!=page.firstpage}">
    		<a href="${pageContext.request.contextPath}/servlet/ListCustServlet?thispage=${page.firstpage }">首页</a>
    	</c:if>
    	<c:if test="${page.thispage==page.firstpage}">
    		上一页
    	</c:if>
    	<c:if test="${page.thispage!=page.firstpage}">
    		<a href="${pageContext.request.contextPath}/servlet/ListCustServlet?thispage=${page.prepage }">上一页</a>
    	</c:if>
    	<!-- if pagecount<=5
				show all page
			else if pagecount>5
				if thispage<=3
					show 1--5
				if thispage>=pagecount-2
					show pagecount-4 -- pagecount
				else 
					show thispage-2 -- thispage+2 -->
    	<c:if test="${page.pagecount<=5}">
    		<c:set  var="begin" value="1" scope="page"></c:set>
    		<c:set  var="end" value="${page.pagecount}" scope="page"></c:set>
    	</c:if>
    	<c:if test="${page.pagecount>5}">
    		<c:choose>
    			<c:when test="${page.thispage<=3}">
    				<c:set  var="begin" value="1" scope="page"></c:set>
    				<c:set  var="end" value="5" scope="page"></c:set>
    			</c:when>
    			<c:when test="${page.thispage>=page.pagecount-2}">
    				<c:set  var="begin" value="${page.pagecount-4}" scope="page"></c:set>
    				<c:set  var="end" value="${page.pagecount}" scope="page"></c:set>
    			</c:when>
    			<c:otherwise>
    				<c:set  var="begin" value="${page.thispage-2}" scope="page"></c:set>
    				<c:set  var="end" value="${page.thispage+2}" scope="page"></c:set>
    			</c:otherwise>
    		</c:choose>
    	</c:if>
    	<c:forEach begin="${begin}" end="${end}" step="1" var="num">
    		<c:if test="${num==page.thispage}">
    			${num }
    		</c:if>
    		<c:if test="${num!=page.thispage}">
    			<a href ="${pageContext.request.contextPath}/servlet/ListCustServlet?thispage=${num}">${num}</a>
    		</c:if>
    	</c:forEach>
    	<c:if test="${page.thispage==page.pagecount}">
    		下一页
    	</c:if>
    	<c:if test="${page.thispage!=page.pagecount}">
    		<a href="${pageContext.request.contextPath}/servlet/ListCustServlet?thispage=${page.nextpage }">下一页</a>
    	</c:if>
    	<c:if test="${page.thispage==page.pagecount}">
    		尾页
    	</c:if>
    	<c:if test="${page.thispage!=page.pagecount}">
    		<a href="${pageContext.request.contextPath}/servlet/ListCustServlet?thispage=${page.lastpage }">尾页</a>
    	</c:if>
    	跳至<input type="text" style="width:40px;" onchange="changepage(this)"/>页
    </form>
  </body>
</html>
