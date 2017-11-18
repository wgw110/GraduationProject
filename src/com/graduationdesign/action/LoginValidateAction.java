package com.graduationdesign.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.graduationdesign.dao.UserDaoImpl;
import com.graduationdesign.service.LoginServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class LoginValidateAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String checkCode;
	private String username;
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String register() {
		return "register";
	}

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	public String login() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		String name = this.username;
		String password = this.password;
		String prefix = new UserDaoImpl().findByName(name).getPrefix();
		System.out.println("name=:" + name + ",password=" + password);
		LoginServiceImpl loginService = new LoginServiceImpl();
		boolean judge = loginService.isSuccessLogin(name, password);
		System.out.println("是否成功登录？" + judge);
		if (judge == true) {
			session.setAttribute("prefix", prefix);
			return "success";
		} else {
			return "fail";
		}
	}

	public void validateLogin() {
		if (username == null || username.trim().equals("")) {
			addFieldError("username", "账号不能为空！！！");
		}
		if (password == null || !password.matches("\\w{6,16}")) {
			// this.addActionError("密码不能为空且必须为6~16位的大小写字母或数字！！！");
			this.addFieldError("password", "密码不能为空且必须为6~16位的大小写字母或数字！！！");
		}
		HttpSession session = ServletActionContext.getRequest().getSession();

		String checkCode2 = (String) session.getAttribute("checkCode");

		if (!checkCode.equals(checkCode2)) {
			this.addActionError("输入的验证码不正确，请重新输入！");
		}
	}

}
