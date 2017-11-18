package com.graduationdesign.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.jfree.chart.JFreeChart;

import com.graduationdesign.po.MemoryMessage;
import com.graduationdesign.service.DrawPictureImpl;
import com.graduationdesign.service.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class MemPieChartAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFreeChart chart;
	public JFreeChart getChart() {
		return chart;
	}
	public void setChart(JFreeChart chart) {
		this.chart = chart;
	}
	@Override
	public String execute() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		String prefix=(String)session.getAttribute("prefix");
		MemoryMessage memoryMessage=(MemoryMessage) session.getAttribute("memMessage");
		this.chart=new DrawPictureImpl().drawMemPieChart(prefix, memoryMessage);
		return "success";
	}

}
