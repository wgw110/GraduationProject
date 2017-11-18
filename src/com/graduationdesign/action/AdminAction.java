package com.graduationdesign.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.graduationdesign.dao.UserDaoImpl;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String user1 = (String) request.getParameter("username");
		System.out.println("user:" + user1);
		System.out.println("user:" + username);
		HttpSession session = ServletActionContext.getRequest().getSession();
		String prefix = new UserDaoImpl().findByName(username).getPrefix();
		session.setAttribute("prefix", prefix);
		session.setAttribute("user", "π‹¿Ì‘±");
		// TODO Auto-generated method stub
		return "success";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}



}
