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
	// �û�������
	private String password;
	private String confirmedPass;
	// �û�����
	private String mail;
	// �û�IP��ַ
	private String ip;
	// �û���Ӧ�ı��ǰ׺,ͨ����ǰ׺��ȷ��ÿ���û�ʹ�õı�
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

	// ����֤
	public void validate() {
		ILoginService loginService = new LoginServiceImpl();
		boolean isRegister = loginService.isUserRegister(ip);
		boolean isNameUsed = loginService.isNameUsed(name);
		if (!ip.matches("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}")) {
			addFieldError("ip", "IP��ַ��ʽ���󣡣���");
		}
		if (isRegister == true) {
			this.addFieldError("ip", "��ip��ַ�Ѿ�ע����ˣ���ֱ�ӵ�¼������");
		}
		if (isNameUsed == true) {
			this.addFieldError("name", "�û����Ѿ���ռ�ã���ѡ�����û��ǳ�");
		}
		if (name == null || name.trim().equals("")) {
			this.addFieldError("name", "�û�������Ϊ�գ�����");
		}
		if (password == null || !password.matches("\\w{6,16}")) {
			this.addFieldError("password", "���벻��Ϊ���ұ���Ϊ6~16λ�Ĵ�Сд��ĸ�����֣�����");
		}
		if (!password.equals(confirmedPass)) {
			this.addFieldError("confirmedPass", "���һ���������벻һ�£����������룡����");
		}
		if (!mail.matches("\\w+@\\w+(\\.\\w+)+")) {
			this.addFieldError("mail", "�����ʽ�������������룡����");
		}

	}

	public String getConfirmedPass() {
		return confirmedPass;
	}

	public void setConfirmedPass(String confirmedPass) {
		this.confirmedPass = confirmedPass;
	}
}
