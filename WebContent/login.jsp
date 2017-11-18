<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页</title>
</head>
<body>
	<form action="login">

		用户名：<input type="text" name="username"><br> 密码：<input
			type="password" name="password"> <br> <input
			type="submit" name="submit" value="登录" />
			 <button class="barter_btn" onClick="javascript:window.location='register.jsp'">没有账号？前往注册</button>

	</form>
</body>
</html>