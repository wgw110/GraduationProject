<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>性能信息展示</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/style2.css" />

</head>

<body>
<body class="login_body">
	<div class="login_div">
		<div class="col-xs-12 login_title">查询</div>
			<div class="nav">
				<div class="col-xs-12 login_btn1_div">
					<input type="submit" class="sub_btn" value="CPU信息" id="login" onClick="javascript:window.location='cpuMessage.jsp'"/>
				</div>
				<div class="col-xs-12 login_btn2_div">
					<input type="submit" class="sub_btn" value="内存信息" id="login" onClick="javascript:window.location='memMessage.jsp'"/>
				</div>
				<div class="col-xs-12 login_btn3_div">
					<input type="submit" class="sub_btn" value="网络信息" id="login" onClick="javascript:window.location='inetMessage.jsp'"/>
				</div>
				<div class="col-xs-12 login_btn4_div">
					<input type="submit" class="sub_btn" value="OS信息" id="login" onClick="javascript:window.location='osMessage.jsp'"/>
				</div>
				<div class="col-xs-12 login_btn5_div">
					<input type="submit" class="sub_btn" value="文件信息" id="login" onClick="javascript:window.location='fileMessage.jsp'"/>
				</div>
				
			</div>
	</div>

</body>
</body>
</html>