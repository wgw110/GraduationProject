package com.graduationdesign.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.jfree.chart.JFreeChart;

import com.graduationdesign.dao.MemDaoImpl;
import com.graduationdesign.po.MemoryMessage;
import com.graduationdesign.service.DrawPictureImpl;
import com.graduationdesign.service.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class MemLineChartAction extends ActionSupport{

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
		List<MemoryMessage> list=(List<MemoryMessage>) session.getAttribute("listMemMessage");
		this.chart=new DrawPictureImpl().drawMemLineChart(prefix, list);
		return super.execute();
	}
	

}
