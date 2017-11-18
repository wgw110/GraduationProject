<%@page import="java.util.ArrayList"%>
<%@page import="com.graduationdesign.dao.FileDaoImpl"%>
<%@page import="com.graduationdesign.po.FileMessage"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>盘符信息</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/style3.css" />
</head>
<body class="login_body">
	<%!String date;
	List<FileMessage> listfile = new ArrayList<FileMessage>();
	int size = 0;
	String prefix;%>
	<%
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd  HH:mm");
		String checkTime = dateFormat.format(now);
		prefix = (String) session.getAttribute("prefix");
		date = (String) session.getAttribute("cal");
		System.out.println("prefix=" + prefix);
		System.out.println("cal=" + date);
		if (date.equals("") || date.trim().equals("")) {
			listfile = new FileDaoImpl().findNew(prefix);
		} else {
			listfile = new FileDaoImpl().find(date, prefix);
		}
		size = listfile.size();
		if (listfile.size() == 0 || listfile == null) {
			System.out.println("日期错误");
	%>
	<script type="text/JavaScript" language="javascript">
		alert("选择的日期错误，请重新选择日期...");
		window.document.location.href = "cal.jsp";
	</script>
	<%
		}
	%>
		<h4 style="color: blue">
		当前时间：<%=checkTime%></h4>
	<%
		int pageNo = 0;
		int pageSize = 1;
		int i = 0;
		int totalPage = size;
		if (request.getParameter("pageNo") != null) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}
		if (pageNo < 0) {
			pageNo = 0;
		}
		if (pageNo >= totalPage) {
			pageNo = totalPage - 1;
		}
		if (pageNo != 0) {
			i = pageNo * pageSize;
		}

		for (int j = 0; i < size && j < pageSize; i++, j++) {
			if (listfile.size() > 0) {
				FileMessage filemessage = listfile.get(i);
	%>
	<div class="login_div">
		<div class="col-xs-12 login_title">OS信息如下</div>
		<div class="nav">
			<div class="nav mes1">
				fileName:<%=filemessage.getFileName()%></div>
			<div class="nav mes2">
				fileType:<%=filemessage.getFileType()%></div>
			<div class="nav mes3">
				fileTotal:<%=filemessage.getFileTotal()%></div>
			<div class="nav mes4">
				fileUsed:<%=filemessage.getFileUsed()%></div>
			<div class="nav mes5">
				fileFree:<%=filemessage.getFileFree()%></div>
			<div class="nav mes6">
				filePercent:<%=filemessage.getFilePercent()%></div>
		</div>
		<div class="cc">
			<a href="fileMessage.jsp?PageNo=0">首页</a> <a
				href="fileMessage.jsp?pageNo=<%=pageNo - 1%>">上一页</a> <a
				href="fileMessage.jsp?pageNo=<%=pageNo + 1%>">下一页</a> <a
				href="fileMessage.jsp?pageNo=<%=totalPage - 1%>">尾页</a>
		</div>
	</div>
	<%
		}
	%>
	<%
		}
	%>
</body>
</html>