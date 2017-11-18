package com.graduationdesign.action;

import com.graduationdesign.po.User;
import com.graduationdesign.service.ILoginService;
import com.graduationdesign.service.LoginServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	// 用户的密码
	private String password;
	private String confirmedPass;
	// 用户邮箱
	private String mail;
	// 用户IP地址
	private String ip;
	// 用户对应的表的前缀,通过该前缀来确定每个用户使用的表
	private String prefix;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String execute() throws Exception {
		
		ILoginService loginService = new LoginServiceImpl();
		boolean judge = loginService.isValid(ip);
		if (judge == true) {
			User user = new User();
			user.setIp(ip);
			user.setName(name);
			user.setPassword(password);
			user.setMail(mail);
			loginService.register(user);
			return "success";
		} else {
			return "error";
		}

	}

	// 表单验证
	public void validate() {
		ILoginService loginService = new LoginServiceImpl();
		boolean isRegister = loginService.isUserRegister(ip);
		boolean isNameUsed = loginService.isNameUsed(name);
		if (!ip.matches("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}")) {
			addFieldError("ip", "IP地址格式错误！！！");
		}
		if (isRegister == true) {
			this.addFieldError("ip", "该ip地址已经注册过了，请直接登录！！！");
		}
		if (isNameUsed == true) {
			this.addFieldError("name", "用户名已经被占用，请选择别的用户昵称");
		}
		if (name == null || name.trim().equals("")) {
			this.addFieldError("name", "用户名不能为空！！！");
		}
		if (password == null || !password.matches("\\w{6,16}")) {
			this.addFieldError("password", "密码不能为空且必须为6~16位的大小写字母或数字！！！");
		}
		if (!password.equals(confirmedPass)) {
			this.addFieldError("confirmedPass", "与第一次密码输入不一致，请重新输入！！！");
		}
		if (!mail.matches("\\w+@\\w+(\\.\\w+)+")) {
			this.addFieldError("mail", "邮箱格式错误请重新输入！！！");
		}

	}

	public String getConfirmedPass() {
		return confirmedPass;
	}

	public void setConfirmedPass(String confirmedPass) {
		this.confirmedPass = confirmedPass;
	}
}
