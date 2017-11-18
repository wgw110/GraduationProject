package com.graduationdesign.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.graduationdesign.dao.CPUDaoImpl;
import com.graduationdesign.po.CPUMessage;
import com.graduationdesign.service.DrawPictureImpl;
import com.graduationdesign.service.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class HandleCalenderAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String calender;

	public String getCalender() {
		return calender;
	}

	public void setCalender(String calender) {
		this.calender = calender;
	}

	public String execute() throws Exception{
		HttpSession session = ServletActionContext.getRequest().getSession();
		String prefix = (String) session.getAttribute("prefix");
		System.out.println("prefix:" + prefix);
		String date = calender.replaceAll("-", "/");
//		CPUMessage cpuMessage = new UserServiceImpl().find(date, prefix);
//		System.out.println(cpuMessage);
		
		// String dir1 = new DrawPictureImpl().drawCPUPieChart(prefix,
		// cpuMessage);
		// session.setAttribute("barDir", dir);
		// session.setAttribute("pieDir", dir1);
//		List<CPUMessage> ListMessage = new CPUDaoImpl().find(date, prefix);
		// String dir3 = new DrawPictureImpl().drawCPULineChart(prefix,
		// ListMessage);
		// session.setAttribute("lineDir", dir3);
		// System.out.println("dir" + dir);
		// System.out.println("dir1" + dir1);
		// System.out.println("dir3" + dir3);
//		session.setAttribute("ListMessage", ListMessage);
		session.setAttribute("cal", calender.replaceAll("-", "/"));
		System.out.println("calender："+calender);
		if(calender.replaceAll("-", "/").equals("")){
			System.out.println("采用默认值");
		}
		System.out.println(date);
		return "success";
	}

}
