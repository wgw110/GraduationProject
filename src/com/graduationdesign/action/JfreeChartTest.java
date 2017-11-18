package com.graduationdesign.action;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.graduationdesign.po.CPUMessage;

public class JfreeChartTest {
	public JFreeChart drawCPUBarChart(String prefix, CPUMessage cpuMessage) {
		// TODO Auto-generated method stub
		String title = "CPU性能分析";
		String XLabel = "CPU属性";
		String YLabel = "百分比";
		String dir = null;
		DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
		dataSet.addValue(cpuMessage.getCountPercent(), "总使用率", "总使用率");
		dataSet.addValue(cpuMessage.getUserPercent(), "用户使用率", "用户使用率");
		dataSet.addValue(cpuMessage.getSysPercent(), "系统使用率", "系统使用率");
		dataSet.addValue(cpuMessage.getIdlePercent(), "空闲率", "空闲率");
		dataSet.addValue(cpuMessage.getNicePercent(), "错误率", "错误率");
		dataSet.addValue(cpuMessage.getWaitPercent(), "等待率", "等待率");
		PlotOrientation plotOrientation = PlotOrientation.VERTICAL;
		JFreeChart chart = ChartFactory.createBarChart3D(title, XLabel, YLabel, dataSet, plotOrientation, true, false,
				false);
		FileOutputStream outputStream = null;
		try {
			String date = cpuMessage.getDate().replace(":", "#").replace("/", ".");
			System.out.println("正在创建图片");
			dir = "Picture\\" + date + "_" + prefix + "_cpubarChart.jpg";
			outputStream = new FileOutputStream(dir);
			ChartUtilities.writeChartAsJPEG(outputStream, chart, 1000, 800);
			outputStream.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return chart;

	}

}
