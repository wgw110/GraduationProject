<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
</head>
<body>
	<s:form action="register" method="post">
		<table width="60%" border="1">
			<tr>
				<td><s:textfield name="ip" label="IP地址" /></td>
			</tr>
			<tr>
				<td><s:textfield name="name" label="用户名" /></td>
			</tr>
			<tr>
				<td><s:password name="password" label="密码" /></td>
			</tr>
			<tr>
				<td><s:password name="confirmedPass" label="确认密码" /></td>
			</tr>
			<tr>
				<td><s:textfield name="mail" label="邮箱" /></td>
			</tr>
			<tr>
				<td><input type="reset" value="清空"></td>
				<td><input type="submit" value="注册"></td>
			</tr>
		</table>
	</s:form>
	<a href="loginx.jsp">跳转到登录页面.....</a>
</body>
</html>