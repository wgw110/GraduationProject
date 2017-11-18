<%@page import="com.graduationdesign.service.UserServiceImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.graduationdesign.dao.CPUDaoImpl"%>
<%@page import="com.graduationdesign.po.CPUMessage"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CPU信息</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/table.css" />
<link rel="stylesheet" type="text/css" href="css/style3.css" />
</head>
<body class="login_body">

	<div class="zz">
	    <input type="submit" class="sub_btn" value="cpu性能图表展示" id="zzz" onClick="javascript:window.location='cpuPicture.jsp'"/>
	</div>
	<%!String prefix;
	String date;
	List<CPUMessage> listCPUMessage = new ArrayList<CPUMessage>();
	CPUMessage cpuMessage = null;%>
	<%
		//listCPUMessage = (List<CPUMessage>) session.getAttribute("ListMessage");

		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd  HH:mm");
		String checkTime = dateFormat.format(now);
		prefix = (String) session.getAttribute("prefix");
		date = (String) session.getAttribute("cal");
		System.out.println("prefix=" + prefix);
		System.out.println("cal=" + date);
		if (date.equals("") || date.trim().equals("")) {
			CPUMessage cpuMessage1 = new CPUDaoImpl().findNew(prefix);
			session.setAttribute("cpumessage", cpuMessage1);
			listCPUMessage.add(cpuMessage1);
			System.out.println("cpumessage:" + cpuMessage1.getDate());
		} else {
			listCPUMessage = new CPUDaoImpl().find(date, prefix);
			CPUMessage cpuMessage2=new UserServiceImpl().find(date, prefix);
			session.setAttribute("cpumessage", cpuMessage2);
		}
		session.setAttribute("listCPUMessage", listCPUMessage);
		if (listCPUMessage.size() == 0 || listCPUMessage == null) {
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
		<br>数据量：<%=listCPUMessage.size()%></h4>
	<table width="10%" border="1" class="table">
		<thead>
			<tr>
				<th>Date</th>
				<th>CountPercent</th>
				<th>SysPercent</th>
				<th>UserPercent</th>
				<th>IdlePercent</th>
				<th>WaitPercent</th>
				<th>NicePercent</th>
				<th>CountMhz</th>
			</tr>
		</thead>
		<%
			int pageNo = 0;
			int pageSize = 6;
			int i = 0;
			int totalPage = (listCPUMessage.size() % pageSize == 0) ? (listCPUMessage.size() / pageSize)
					: (listCPUMessage.size() / pageSize + 1);
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

			for (int j = 0; i < listCPUMessage.size() && j < pageSize; i++, j++) {
				if (listCPUMessage.size() > 0) {
					cpuMessage = listCPUMessage.get(i);
		%>
		<tr>
			<td><%=cpuMessage.getDate()%></td>
			<td><%=cpuMessage.getCountPercent()%></td>
			<td><%=cpuMessage.getSysPercent()%></td>
			<td><%=cpuMessage.getUserPercent()%></td>
			<td><%=cpuMessage.getIdlePercent()%></td>
			<td><%=cpuMessage.getWaitPercent()%></td>
			<td><%=cpuMessage.getNicePercent()%></td>
			<td><%=cpuMessage.getCountMhz()%></td>

		</tr>
		<%
			}
		%>
		<%
			}
		%>
	</table>
	<div class="cc">
		<a href="cpuMessage.jsp?PageNo=0">首页</a> <a
			href="cpuMessage.jsp?pageNo=<%=pageNo - 1%>">上一页</a> <a
			href="cpuMessage.jsp?pageNo=<%=pageNo + 1%>">下一页</a> <a
			href="cpuMessage.jsp?pageNo=<%=totalPage - 1%>">尾页</a>
	</div>
	<%
		listCPUMessage.clear();
	%>

</body>
</html>