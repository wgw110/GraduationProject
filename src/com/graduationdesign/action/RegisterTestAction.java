package com.graduationdesign.action;

import com.graduationdesign.po.User;
import com.graduationdesign.service.ILoginService;
import com.graduationdesign.service.LoginServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterTestAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String IP;
	private String username;
	private String password;
	private String confirmedPassword;
	private String email;
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmedPassword() {
		return confirmedPassword;
	}
	public void setConfirmedPassword(String confirmedPassword) {
		this.confirmedPassword = confirmedPassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String execute() throws Exception {
		ILoginService loginService = new LoginServiceImpl();
		boolean judge = loginService.isValid(IP);
		if (judge == true) {
			User user = new User();
			user.setIp(IP);
			user.setName(username);
			user.setPassword(password);
			user.setMail(email);
			loginService.register(user);
			return "success";
		} else {
			return "error";
		}
	}
	@Override
	public void validate() {
		ILoginService loginService = new LoginServiceImpl();
		boolean isRegister = loginService.isUserRegister(IP);
		boolean isNameUsed = loginService.isNameUsed(username);
		if (!IP.matches("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}")) {
			addFieldError("ip", "IP地址格式错误！！！");
		}
		if (isRegister == true) {
			this.addFieldError("ip", "该ip地址已经注册过了，请直接登录！！！");
		}
		if (isNameUsed == true) {
			this.addFieldError("name", "用户名已经被占用，请选择别的用户昵称");
		}
		if (username == null || username.trim().equals("")) {
			this.addFieldError("name", "用户名不能为空！！！");
		}
		if (password == null || !password.matches("\\w{6,16}")) {
			this.addFieldError("password", "密码不能为空且必须为6~16位的大小写字母或数字！！！");
		}
		if (!password.equals(confirmedPassword)) {
			this.addFieldError("confirmedPass", "与第一次密码输入不一致，请重新输入！！！");
		}
		if (!email.matches("\\w+@\\w+(\\.\\w+)+")) {
			this.addFieldError("mail", "邮箱格式错误请重新输入！！！");
		}
	}
	

}
