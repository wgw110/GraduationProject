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
		System.out.println("����register����");
		return "register";
	}

	@Override
	public String execute() throws Exception {
		System.out.println("����execute����");
		HttpSession session = ServletActionContext.getRequest().getSession();
		String name = this.username;
		String password = this.password;
		LoginServiceImpl loginService = new LoginServiceImpl();
		boolean judge = loginService.isSuccessLogin(name, password);
		System.out.println("�Ƿ�ɹ���¼��" + judge);
		if (judge == true) {
			// ���ݵ�¼���˵��˺�����ȷ�����ǰ׺
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
	// System.out.println("����login����");
	// HttpSession session = ServletActionContext.getRequest().getSession();
	// String name = this.username;
	// String password = this.password;
	// String prefix = new UserDaoImpl().findByName(name).getPrefix();
	// System.out.println("name=:" + name + ",password=" + password);
	// LoginServiceImpl loginService = new LoginServiceImpl();
	// boolean judge = loginService.isSuccessLogin(name, password);
	// System.out.println("�Ƿ�ɹ���¼��" + judge);
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
			this.addActionError("�˺Ų���Ϊ�գ�����");
			addFieldError("username", "�˺Ų���Ϊ�գ�����");
			addActionMessage("�˺Ų���Ϊ�գ�����");
		}
		if (password == null || !password.matches("\\w{6,16}")) {
			// this.addActionError("���벻��Ϊ���ұ���Ϊ6~16λ�Ĵ�Сд��ĸ�����֣�����");
			this.addActionError("���벻��Ϊ���ұ���Ϊ6~16λ�Ĵ�Сд��ĸ�����֣�����");
			this.addFieldError("password", "���벻��Ϊ���ұ���Ϊ6~16λ�Ĵ�Сд��ĸ�����֣�����");
		}
		HttpSession session = ServletActionContext.getRequest().getSession();

		String checkCode2 = (String) session.getAttribute("checkCode");

		if (!checkCode.equals(checkCode2)) {
			this.addActionError("�������֤�벻��ȷ�����������룡");
		}
	}
	// public void validateLogin() {
	// if (username == null || username.trim().equals("")) {
	// addFieldError("username", "�˺Ų���Ϊ�գ�����");
	// }
	// if (password == null || !password.matches("\\w{6,16}")) {
	// // this.addActionError("���벻��Ϊ���ұ���Ϊ6~16λ�Ĵ�Сд��ĸ�����֣�����");
	// this.addFieldError("password", "���벻��Ϊ���ұ���Ϊ6~16λ�Ĵ�Сд��ĸ�����֣�����");
	// }
	//
	// }

}
