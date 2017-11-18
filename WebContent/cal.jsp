<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" type="text/javascript"
	src="calendar/WdatePicker.js"></script>
<title>选择日期</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>

<body class="login_body">
<%String user=(String)session.getAttribute("user"); %>
    <div class="login_div">
	<s:form action="handleCalender" class="login" method="post">
	    <div class="col-xs-12 login_title">欢迎登陆，<%=user %></div>
		<div class="nav">
				<div class="nav login_nav">
					<div class="col-xs-4 login_username">查询日期 :</div>
					<div class="col-xs-6 login_usernameInput">
						<input type="text" name="calender" id="name" value="" placeholder="默认为最新记录" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
					</div>
				</div>
				
				<div class="col-xs-12 login_btn_div">
					<input type="submit" class="sub_btn" value="查询" id="login" />
				</div>
	</div>
	</s:form>
	</div>
</body>
</html>