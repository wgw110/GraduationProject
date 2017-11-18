<%@page import="java.util.ArrayList"%>
<%@page import="com.graduationdesign.dao.InetDaoImpl"%>
<%@page import="com.graduationdesign.po.InterMessage"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>网络信息</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/table.css" />
<link rel="stylesheet" type="text/css" href="css/style3.css" />
</head>
<body class="login_body">


	<%!String prefix;
	List<InterMessage> listInetMessage = new ArrayList<InterMessage>();
	InterMessage interMessage;
	String date;%>
	<%
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd  HH:mm");
		String checkTime = dateFormat.format(now);
		prefix = (String) session.getAttribute("prefix");
		date = (String) session.getAttribute("cal");
		System.out.println("prefix=" + prefix);
		System.out.println("cal=" + date);
		if (date.equals("") || date.trim().equals("")) {
			listInetMessage = new InetDaoImpl().findNew(prefix);
		} else {
			listInetMessage = new InetDaoImpl().find(date, prefix);
		}
		if (listInetMessage.size() == 0 || listInetMessage == null) {
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
		当前时间：<%=checkTime%>
		<br>数据量：<%=listInetMessage.size()%></h4>
	<table width="10%" border="1" class="table">
		<thead>
			<tr>
				<th>Date</th>
				<th>name</th>
				<th>receivePackets</th>
				<th>sendPackets</th>
				<th>receiveDroped</th>
				<th>sendDroped</th>
				<th>receiveErrors</th>
				<th>sendErrors</th>
			</tr>
		</thead>
		<%
			int pageNo = 0;
			int pageSize = 6;
			int i = 0;
			int totalPage = (listInetMessage.size() % pageSize == 0) ? (listInetMessage.size() / pageSize)
					: (listInetMessage.size() / pageSize + 1);
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

			for (int j = 0; i < listInetMessage.size() && j < pageSize; i++, j++) {
				if (listInetMessage.size() > 0) {
					interMessage = listInetMessage.get(i);
		%>
		<tr>
			<td><%=interMessage.getDate()%></td>
			<td><%=interMessage.getName()%></td>
			<td><%=interMessage.getReceivePackets()%></td>
			<td><%=interMessage.getSendPackets()%></td>
			<td><%=interMessage.getReceiveDroped()%></td>
			<td><%=interMessage.getSendDroped()%></td>
			<td><%=interMessage.getReceiveErrors()%></td>
			<td><%=interMessage.getSendErrors()%></td>

		</tr>
		<%
			}
		%>
		<%
			}
		%>
	</table>
	<div class="cc">
		<a href="inetMessage.jsp?PageNo=0">首页</a> <a
			href="inetMessage.jsp?pageNo=<%=pageNo - 1%>">上一页</a> <a
			href="inetMessage.jsp?pageNo=<%=pageNo + 1%>">下一页</a> <a
			href="inetMessage.jsp?pageNo=<%=totalPage - 1%>">尾页</a>
	</div>

</body>
</html>