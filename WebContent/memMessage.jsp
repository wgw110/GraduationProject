<%@page import="com.graduationdesign.service.UserServiceImpl"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.graduationdesign.dao.MemDaoImpl"%>
<%@page import="com.graduationdesign.po.MemoryMessage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>内存信息</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/table.css" />
<link rel="stylesheet" type="text/css" href="css/style3.css" />
</head>
<body class="login_body">
    <div class="zz">
	    <input type="submit" class="sub_btn" value="mem性能图表展示" id="zzz" onClick="javascript:window.location='picture2.jsp'"/>
	</div>
	<%!String prefix;
	List<MemoryMessage> listMemMessage=new ArrayList<MemoryMessage>();
	String date;
	MemoryMessage memMessage=null;%>
	<%
	
	Date now = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd  HH:mm");
	String checkTime = dateFormat.format(now);
	prefix = (String) session.getAttribute("prefix");
	date = (String) session.getAttribute("cal");
	System.out.println("prefix="+prefix);
	System.out.println("cal="+date);
	if(date.equals("")||date.trim().equals("")){
		MemoryMessage memMessage2=new MemDaoImpl().findNew(prefix);
		listMemMessage.add(memMessage2);
		session.setAttribute("memMessage", memMessage2);
	}else{
		listMemMessage = new MemDaoImpl().find(date, prefix);
		MemoryMessage memoryMessage3=new UserServiceImpl().findMem(date, prefix);
		session.setAttribute("memMessage", memoryMessage3);
	}
	session.setAttribute("listMemMessage", listMemMessage);
		if (listMemMessage.size() == 0 || listMemMessage == null) {
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
		<br>数据量：<%=listMemMessage.size()%></h4>

	<table width="10%" border="1" class="table">
		<thead>
			<tr>
				<th>Date</th>
				<th>countMem</th>
				<th>usedMem</th>
				<th>freeMem</th>
				<th>freePercent</th>
				<th>swapTotal</th>
				<th>swapUsed</th>
				<th>swapFree</th>
			</tr>
		</thead>
		<%
			int pageNo = 0;
			int pageSize = 6;
			int i = 0;
			int totalPage = (listMemMessage.size() % pageSize == 0) ? (listMemMessage.size() / pageSize)
					: (listMemMessage.size() / pageSize + 1);
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

			for (int j = 0; i < listMemMessage.size() && j < pageSize; i++, j++) {
				if (listMemMessage.size() > 0) {
					memMessage = listMemMessage.get(i);
		%>
		<tr>
			<td><%=memMessage.getDate()%></td>
			<td><%=memMessage.getCountMem()%></td>
			<td><%=memMessage.getUsedMem()%></td>
			<td><%=memMessage.getFreeMem()%></td>
			<td><%=memMessage.getFreePercent()%></td>
			<td><%=memMessage.getSwapTotal()%></td>
			<td><%=memMessage.getSwapUsed()%></td>
			<td><%=memMessage.getSwapFree()%></td>

		</tr>
		<%
			}
		%>
		<%
			}
		%>
	</table>
	<div class="cc">
		<a href="memMessage.jsp?PageNo=0">首页</a> <a
			href="memMessage.jsp?pageNo=<%=pageNo - 1%>">上一页</a> <a
			href="memMessage.jsp?pageNo=<%=pageNo + 1%>">下一页</a> <a
			href="memMessage.jsp?pageNo=<%=totalPage - 1%>">尾页</a>
	</div>
    <%
      if(listMemMessage.size()==1){
    	  listMemMessage.clear();
      }
    %>
</body>
</html>