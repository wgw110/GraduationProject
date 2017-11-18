package com.graduationdesign.action;

import com.graduationdesign.service.ILoginService;
import com.graduationdesign.service.LoginServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class TestIPAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ip;

	public String execute() {
		return "success";
	}

	public void validate() {
		ILoginService loginService = new LoginServiceImpl();
		boolean judge = loginService.isValid(ip);
		if (judge == false) {
			addFieldError("ip", "无效的IP地址");
		}
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}
