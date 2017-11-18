<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
<head>
<base href="<%=basePath%>">

<title>登录界面</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


</head>

<body class="login_body">
    <div class="login_div">
		<div class="col-xs-12 login_title">登录</div>
    
	<s:form action="loginValidateAction" method="post">
	<table>
      <tr>
	    <td><s:textfield name="username" label="用户名" /></td>
	  </tr>
	  <tr>
			<td><s:password name="password" label="密码" /></td>
	   </tr>
	   <tr>
			<td><s:textfield name="checkCode" label="验证码" /></td>
	   </tr>
	  <tr>
	    <td><img src="createImageAction"
			onclick="this.src='createImageAction.action?'+ Math.random()"
			title="点击图片刷新验证码" />	
			<s:actionerror cssStyle="color:red" />
			</td>
	  </tr>
	  <tr>
	    <td><s:submit key="login" value="登录" method="login"/>
	    </tr>
	    <tr>
	    <td><s:submit key="register" value="注册" method="register"/>	  
	  </tr>	
	</table>		
	</s:form>
	</div>
</body>
</html>