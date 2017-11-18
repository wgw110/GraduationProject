<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>error</title>
</head>
<body>
	该IP地址无法与服务器连接，请重新进行注册！！！
	<s:form action="testIP" method="post">
		<s:textfield name="ip"/><br>
		<input type="submit" value="测试IP">		
	</s:form>
	<a href="register.jsp">跳转到注册页面.....</a>
</body>
</html>