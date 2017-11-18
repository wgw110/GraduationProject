package com.graduationdesign.action;

import org.jfree.chart.JFreeChart;

import com.graduationdesign.dao.UserDaoImpl;
import com.graduationdesign.po.CPUMessage;
import com.graduationdesign.service.DrawPictureImpl;
import com.graduationdesign.service.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class JfreeChartAction extends ActionSupport {

	/**
	 * �� ��JFreeChart���� ��ע��������JFreeChart������ֻ��Ϊchart
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
		// TODO Auto-generated method stub
		String date = "2017/04/26";
		String prefix = "wgw";
		CPUMessage cpuMessage = new UserServiceImpl().find(date, prefix);
		this.chart = new DrawPictureImpl().drawCPUPieChart(prefix, cpuMessage);
		return "success";
	}

}
