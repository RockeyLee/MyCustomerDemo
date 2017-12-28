<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
    <h1>客户管理系统_添加用户</h1><hr>
    <form action="${pageContext.request.contextPath}/servlet/AddCustServlet" method="post">
    	<table border="1dp">
    		<tr>
    			<td>name:</td>
    			<td><input type="text" name="name"/></td>
    		</tr>
    		<tr>
    			<td>gender:</td>
    			<td>
    				<input type="radio" name="gender" value="男"/>男
    				<input type="radio" name="gender" value="女"/>女
    			</td>
    		</tr>
    		<tr>
    			<td>birthday:</td>
    			<td><input type="text" name="birthday"/></td>
    		</tr>
    		<tr>
    			<td>cellphone:</td>
    			<td><input type="text" name="cellphone"/></td>
    		</tr>
    		<tr>
    			<td>email:</td>
    			<td><input type="text" name="email"/></td>
    		</tr>
    		<tr>
    			<td>preference:</td>
    			<td>
    				<input type="checkbox" name="preference" value="篮球"/>篮球
    				<input type="checkbox" name="preference" value="足球"/>足球
    				<input type="checkbox" name="preference" value="排球"/>排球
    			</td>
    		</tr>
    		<tr>
    			<td>type:</td>
    			<td>
    				<select name="type">
    					<option value="钻石VIP">钻石VIP</option>
    					<option value="铂金VIP">铂金VIP</option>
    					<option value="普通用户">普通用户</option>
    				</select>
    			</td>
    		</tr>
    		<tr>
    			<td>description:</td>
    			<td>
    				<textarea name="description" rows="6" cols="40"></textarea>
    			</td>
    		</tr>
    		<tr>
    			<td colspan="2">
					<input type="submit" value="submit">
				</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
