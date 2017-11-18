package com.struts.test;

public class LoginAction {
	private String username;
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute() throws Exception {
		if (this.username.equals("wgw") && this.password.equals("wgw196602140")) {
			return "success";
		} else {
			return "fail";
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
