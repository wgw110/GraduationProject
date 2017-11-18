package com.graduation.draw303;
/*
 * 还可以实现的功能：设置标题字体
 */
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import com.graduation.message301.CPUMessage;;

public class DrawCPU {
	@SuppressWarnings("unused")
	private CPUMessage cpuMessage;
	// CPU总使用率
	private double countPercent;
	// CPU用户使用率
	private double userPercent;
	// CPU系统使用率
	private double sysPercent;
	// CPU空闲率
	private double idlePercent;
	// CPU错误率
	private double nicePercent;
	// CPU等待率
	private double waitPercent;
	// 获取CPU的总量MHZ
	@SuppressWarnings("unused")
	private double countMhz;
	private FileOutputStream outputStream;
	private JFreeChart chart;

	public DrawCPU(CPUMessage cpuMessage) {
		this.cpuMessage = cpuMessage;
		countPercent = cpuMessage.getCountPercent();
		userPercent = cpuMessage.getUserPercent();
		sysPercent = cpuMessage.getSysPercent();
		idlePercent = cpuMessage.getIdlePercent();
		nicePercent = cpuMessage.getIdlePercent();
		waitPercent = cpuMessage.getWaitPercent();
		countMhz = cpuMessage.getCountMhz();
	}

	// 条形图
	public void DrawBarChart() {
		String title = "CPU性能分析";
		String XLabel = "百分比";
		String YLabel = "CPU属性";
		DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
		dataSet.addValue(countPercent, "总使用率", "总使用率");
		dataSet.addValue(userPercent, "用户使用率", "用户使用率");
		dataSet.addValue(sysPercent, "系统使用率", "系统使用率");
		dataSet.addValue(idlePercent, "空闲率", "空闲率");
		dataSet.addValue(nicePercent, "错误率", "错误率");
		dataSet.addValue(waitPercent, "等待率", "等待率");
		PlotOrientation plotOrientation = PlotOrientation.VERTICAL;
		chart = ChartFactory.createBarChart3D(title, XLabel, YLabel, dataSet, plotOrientation, true, false, false);
		try {
			System.out.println("正在创建图片");
			outputStream = new FileOutputStream("Picture\\barChart.jpg");
			ChartUtilities.writeChartAsJPEG(outputStream, chart, 1000, 800);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				outputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
    //饼状图
	public void drawPieChart() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("空闲率", idlePercent);
		dataset.setValue("用户使用率", userPercent);
		dataset.setValue("系统使用率", sysPercent);
		try {
			outputStream = new FileOutputStream("Picture\\pieChart1.jpg");
			JFreeChart chart = ChartFactory.createPieChart("CPU性能", dataset, true, true, false);
			PiePlot plot = (PiePlot) chart.getPlot();
			//设置饼图为圆形
			plot.setCircular(true);
			//设置颜色
			plot.setSectionPaint("空闲率",new Color(200, 255, 255));
			plot.setExplodePercent("用户使用率", 0.25);
			plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} ({2} percent)"));
			plot.setLegendLabelToolTipGenerator(new StandardPieSectionLabelGenerator("Tooltip for legend item {0}"));
			ChartUtilities.writeChartAsJPEG(outputStream, chart, 800, 600);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
	//折线图
	public void drawLineChart(){
		
	}

}
