package com.graduationdesign.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.graduationdesign.dao.UserDaoImpl;
import com.graduationdesign.service.LoginServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class LoginTestAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String checkCode;

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

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	public String register() {
		System.out.println("调用register方法");
		return "register";
	}

	@Override
	public String execute() throws Exception {
		System.out.println("调用execute方法");
		HttpSession session = ServletActionContext.getRequest().getSession();
		String name = this.username;
		String password = this.password;
		LoginServiceImpl loginService = new LoginServiceImpl();
		boolean judge = loginService.isSuccessLogin(name, password);
		System.out.println("是否成功登录？" + judge);
		if (judge == true) {
			// 根据登录的人的账号密码确定其表前缀
			if (name.trim().equals("root")) {
				return "true";
			} else {
				String prefix = new UserDaoImpl().findByName(name).getPrefix();
				System.out.println("name=:" + name + ",password=" + password);
				session.setAttribute("prefix", prefix);
				session.setAttribute("user", name);
				return "success";
			}
		}
		return "error";

	}

	// public String login() {
	// System.out.println("调用login方法");
	// HttpSession session = ServletActionContext.getRequest().getSession();
	// String name = this.username;
	// String password = this.password;
	// String prefix = new UserDaoImpl().findByName(name).getPrefix();
	// System.out.println("name=:" + name + ",password=" + password);
	// LoginServiceImpl loginService = new LoginServiceImpl();
	// boolean judge = loginService.isSuccessLogin(name, password);
	// System.out.println("是否成功登录？" + judge);
	// if (judge == true) {
	// session.setAttribute("prefix", prefix);
	// return "fail";
	// } else {
	// return "fail";
	// }
	// }
	@Override
	public void validate() {
		if (username == null || username.trim().equals("")) {
			this.addActionError("账号不能为空！！！");
			addFieldError("username", "账号不能为空！！！");
			addActionMessage("账号不能为空！！！");
		}
		if (password == null || !password.matches("\\w{6,16}")) {
			// this.addActionError("密码不能为空且必须为6~16位的大小写字母或数字！！！");
			this.addActionError("密码不能为空且必须为6~16位的大小写字母或数字！！！");
			this.addFieldError("password", "密码不能为空且必须为6~16位的大小写字母或数字！！！");
		}
		HttpSession session = ServletActionContext.getRequest().getSession();

		String checkCode2 = (String) session.getAttribute("checkCode");

		if (!checkCode.equals(checkCode2)) {
			this.addActionError("输入的验证码不正确，请重新输入！");
		}
	}
	// public void validateLogin() {
	// if (username == null || username.trim().equals("")) {
	// addFieldError("username", "账号不能为空！！！");
	// }
	// if (password == null || !password.matches("\\w{6,16}")) {
	// // this.addActionError("密码不能为空且必须为6~16位的大小写字母或数字！！！");
	// this.addFieldError("password", "密码不能为空且必须为6~16位的大小写字母或数字！！！");
	// }
	//
	// }

}
