<%@page import="java.util.Date"%>
<%@page import="com.graduationdesign.dao.UserDaoImpl"%>
<%@page import="com.graduationdesign.po.User"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" type="text/javascript"
	src="calendar/WdatePicker.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员页面</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body class="login_body">
	<%!int userNumber;
	List<User> list;
	String date;%>
	<%
		request.setCharacterEncoding("utf-8");//加上这一句解决的    
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ path + "/";
		list = new UserDaoImpl().findAll();
		userNumber = list.size()-1;
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd  HH:mm");
		date = dateFormat.format(now);
	%>
	<div class="login_div">
		<div class="col-xs-12 login_title">管理员</div>
		<s:form action="adminAction" class="login" method="post">
			<div class="nav">
				<div class="nav login_nav">
					<div class="col-xs-4 login_username">当前时间:</div>
					<div class="col-xs-6 login_usernameInput">
						<%=date%>

					</div>
				</div>
				<div class="nav login_psdNav">
					<div class="col-xs-4">用户数量 :</div>
					<div class="col-xs-6">
						<%=userNumber%>
					</div>

				</div>
				<div class="nav login_check">
					<div class="col-xs-4">选择用户 :</div>
					<div class="col-xs-6">
						<select name="username"  id="check" >
							<option selected>请选择要查看的用户</option>
							<%
								for (int i = 1; i < list.size(); i++) {
										String name = list.get(i).getName();
										out.print("<option>" + name + "</option>");
							%>
							
							<%
								}
							%>
						</select>
					</div>
                   
				</div>
				 
				
				<div class="col-xs-12 login_btn_div">
					<input type="submit" class="sub_btn" value="查询" id="login" />
				</div>

			</div>
		</s:form>

	</div>
</body>
<%
	String n = (String) request.getParameter("username");
	out.print("选的值是：" + n);
%>

</html>