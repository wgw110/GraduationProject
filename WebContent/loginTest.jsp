<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录页面</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		$('#login').click(function() {
			var name_state = $('#name');
			var psd_state = $('#psd');
			var name = $('#name').val();
			var psd = $('#psd').val();
			if (name == '') {
				name_state.parent().next().next().css("display", "block");
				return false;
			} else if (psd == '') {
				name_state.parent().next().next().css("display", "none");
				psd_state.parent().next().next().css("display", "block");
				return false;
			} else {
				name_state.parent().next().next().css("display", "none");
				psd_state.parent().next().next().css("display", "none");
				$('.login').submit();
			}
		});
		$('#register').click(
				function() {
					var name_r_state = $('#name_r');
					var psd_r_state = $('#psd_r');
					var affirm_psd_state = $('#affirm_psd');
					var name_r = $('#name_r').val();
					var psd_r = $('#psd_r').val();
					var affirm_psd = $('#affirm_psd').val();
					if (name_r == '') {
						name_r_state.parent().next().next().css("display",
								"block");
						return false;
					} else if (psd_r == '') {
						psd_r_state.parent().next().next().css("display",
								"block");
						return false;
					} else if (affirm_psd == '') {
						affirm_psd_state.parent().next().next().css("display",
								"block");
						return false;
					} else if (psd_r != affirm_psd) {
						return false;
					} else {
						$('.register').submit();
					}
				})
	})

	function ok_or_errorBylogin(l) {
		var content = $(l).val();
		if (content != "") {
			$(l).parent().next().next().css("display", "none");
		}
	}

	function ok_or_errorByRegister(r) {
		var affirm_psd = $("#affirm_psd");
		var psd_r = $("#psd_r");
		var affirm_psd_v = $("#affirm_psd").val();
		var psd_r_v = $("#psd_r").val();
		var content = $(r).val();
		if (content == "") {
			$(r).parent().next().next().css("display", "block");
			return false;
		} else {
			$(r).parent().next().css("display", "block");
			$(r).parent().next().next().css("display", "none");
			if (psd_r_v == "") {
				$(psd_r).parent().next().css("display", "none");
				$(psd_r).parent().next().next().css("display", "none");
				$(psd_r).parent().next().next().css("display", "block");
				return false;
			}
			if (affirm_psd_v == "") {
				$(affirm_psd_v).parent().next().css("display", "none");
				$(affirm_psd_v).parent().next().next().css("display", "none");
				$(affirm_psd_v).parent().next().next().css("display", "block");
				return false;
			}
			if (psd_r_v == affirm_psd_v) {
				$(affirm_psd).parent().next().css("display", "none");
				$(affirm_psd).parent().next().next().css("display", "none");
				$(psd_r).parent().next().css("display", "none");
				$(psd_r).parent().next().next().css("display", "none");
				$(affirm_psd).parent().next().css("display", "block");
				$(psd_r).parent().next().css("display", "block");
			} else {
				$(affirm_psd).parent().next().css("display", "none");
				$(affirm_psd).parent().next().next().css("display", "none");
				$(psd_r).parent().next().css("display", "none");
				$(psd_r).parent().next().next().css("display", "none");
				$(psd_r).parent().next().css("display", "block");
				$(affirm_psd).parent().next().next().css("display", "block");
				return false;
			}
		}
	}

	function barter_btn(bb) {
		$(bb).parent().parent().fadeOut(1000);
		$(bb).parent().parent().siblings().fadeIn(2000);
	}
</script>
</head>
<body class="login_body">
	<div class="login_div">
		<div class="col-xs-12 login_title">登录</div>
		<s:form action="loginTestAction" class="login" method="post">
			<div class="nav">
				<div class="nav login_nav">
					<div class="col-xs-4 login_username">用户名:</div>
					<div class="col-xs-6 login_usernameInput">
						<input type="text" name="username" id="name" value=""
							placeholder="用户名，手机号" />

					</div>
				</div>
				<div class="nav login_psdNav">
					<div class="col-xs-4">密&nbsp;&nbsp;&nbsp;码 :</div>
					<div class="col-xs-6">
						<input type="password" name="password" id="psd" value=""
							placeholder="&nbsp;&nbsp;密码 " />
					</div>

				</div>
				<div class="nav login_check">
				  <div class="col-xs-4">验证码 :</div>
					<div class="col-xs-6">
						<input type="text" name="checkCode" id="check" value=""
							placeholder="验证码 " />
					</div>
				
				</div>
				<div class="nav login_picture">
					<div class="col-xs-6">
						<img src="createImageAction"
			onclick="this.src='createImageAction.action?'+ Math.random()"
			title="点击图片刷新验证码" id="picture"/>	
			<s:actionerror cssStyle="color:red" />
					</div>
				
				</div>
				<div class="col-xs-12 login_btn_div">
					<input type="submit" class="sub_btn" value="登录" id="login" />
				</div>
				
			</div>
		</s:form>
		<div class="col-xs-12 barter_btnDiv">
			<button class="barter_btn" onClick="javascript:window.location='registerTest.jsp'">没有账号？前往注册</button>
		</div>
	</div>

</body>
</html>