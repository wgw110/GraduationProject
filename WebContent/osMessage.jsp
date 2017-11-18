<%@page import="com.graduationdesign.dao.OSDaoImpl"%>
<%@page import="com.graduationdesign.po.OSMessage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户操作系统信息</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/style3.css" />
</head>
<body class="login_body">
	<%!
	String prefix;
	String name;
	String version;
	String vendor;
	String description;
	String arch;
	String dateModel;
	%>
	<%
		prefix = (String) session.getAttribute("prefix");
	    OSMessage osMessage=new OSDaoImpl().findNew("wgw");
	     name=osMessage.getName();
	     version=osMessage.getVersion();
	     vendor=osMessage.getVendor();
	     description=osMessage.getDescription();
	     arch=osMessage.getArch();
	     dateModel=osMessage.getDataModel();
	    
	%>
	<div class="login_div">
		<div class="col-xs-12 login_title">OS信息如下</div>
		<div class="nav">
		    <div class="nav mes1">name:<%=name %></div>
		    <div class="nav mes2">version:<%=version %></div>
		    <div class="nav mes3">vendor:<%=vendor %></div>
		    <div class="nav mes4">arch:<%=arch %></div>
		    <div class="nav mes5">dateModel:<%=dateModel %></div>
		    <div class="nav mes6">description:<%=description %></div>
		</div>
	</div>

</body>
</html>