<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SUCCESS</title>
</head>
<body>
	登陆成功了！三秒后自动跳转.....
	<%
	String m = (String) session.getAttribute("calender");
	String prefix=(String)session.getAttribute("prefix");
    %>
	<%=m%>
	<%=prefix %>
	<script>
		window.setInterval("location='cal.jsp'", 8000);
	</script>
</body>
</html>