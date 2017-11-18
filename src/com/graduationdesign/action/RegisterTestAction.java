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
			addFieldError("ip", "IP��ַ��ʽ���󣡣���");
		}
		if (isRegister == true) {
			this.addFieldError("ip", "��ip��ַ�Ѿ�ע����ˣ���ֱ�ӵ�¼������");
		}
		if (isNameUsed == true) {
			this.addFieldError("name", "�û����Ѿ���ռ�ã���ѡ�����û��ǳ�");
		}
		if (username == null || username.trim().equals("")) {
			this.addFieldError("name", "�û�������Ϊ�գ�����");
		}
		if (password == null || !password.matches("\\w{6,16}")) {
			this.addFieldError("password", "���벻��Ϊ���ұ���Ϊ6~16λ�Ĵ�Сд��ĸ�����֣�����");
		}
		if (!password.equals(confirmedPassword)) {
			this.addFieldError("confirmedPass", "���һ���������벻һ�£����������룡����");
		}
		if (!email.matches("\\w+@\\w+(\\.\\w+)+")) {
			this.addFieldError("mail", "�����ʽ�������������룡����");
		}
	}
	

}
