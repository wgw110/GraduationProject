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

	这是用户界面！！！
	<%!String prefix;
	List<MemoryMessage> listMemMessage;
	MemoryMessage memMessage;%>
	<%
		//prefix = (String) session.getAttribute("prefix");
		 prefix = "wgw";
		String date = "2017/05/10";
		listMemMessage = new MemDaoImpl().find(date, prefix);
		if(listMemMessage.size()==0){
			%>
	    <script type="text/JavaScript" language="javascript">
			alert("选择的日期错误，请重新选择日期...");
			window.document.location.href="admin.jsp";
			
		</script>	
		<%} %>
		下面的代码执行吗？
		<input type="text" name="tt" value="张海">
		数据量：<%=listMemMessage.size() %>
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
				if(listMemMessage.size()>0)
				{
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
		<%} %>
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
</body>
</html>
		