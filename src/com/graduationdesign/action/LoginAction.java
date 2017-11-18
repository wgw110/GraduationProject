package com.graduationdesign.action;

import com.graduationdesign.po.CPUMessage;
import com.graduationdesign.service.DrawPictureImpl;
import com.graduationdesign.service.LoginServiceImpl;
import com.graduationdesign.service.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	private String username;
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String execute() throws Exception {
		String prefix = "wgw";
		CPUMessage cpuMessage = new UserServiceImpl().find("2017/04/26", prefix);
		System.out.println(cpuMessage);
		
		String name = this.username;
		String password = this.password;
		System.out.println("name=:" + name + ",password=" + password);
		LoginServiceImpl loginService = new LoginServiceImpl();
		boolean judge = loginService.isSuccessLogin(name, password);
		System.out.println("是否成功登录？" + judge);
		if (judge == true) {
			return "success";
		} else {
			return "fail";
		}
	}

//	public String login() {
//		String prefix = "wgw";
//		CPUMessage cpuMessage = new UserServiceImpl().find("2017/04/26", prefix);
//		System.out.println(cpuMessage);
//		
//		String name = this.username;
//		String password = this.password;
//		System.out.println("name=:" + name + ",password=" + password);
//		LoginServiceImpl loginService = new LoginServiceImpl();
//		boolean judge = loginService.isSuccessLogin(name, password);
//		System.out.println("是否成功登录？" + judge);
//		if (judge == true) {
//			return "success";
//		} else {
//			return "fail";
//		}
//	}
//
//	// 验证登录时的输入格式是否符合要求
//	public void validateLogin() {
//		if (username == null || username.trim().equals("")) {
//			addFieldError("username", "账号不能为空！！！");
//		}
//		if (password == null || !password.matches("\\w{6,16}")) {
//			// this.addActionError("密码不能为空且必须为6~16位的大小写字母或数字！！！");
//			this.addFieldError("password", "密码不能为空且必须为6~16位的大小写字母或数字！！！");
//		}
//	}
//
//	public String register() {
//		return "register";
//	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
