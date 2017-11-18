package com.graduationdesign.service;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;
import org.springframework.transaction.support.ResourceTransactionManager;

import com.graduationdesign.dao.CPUDaoImpl;
import com.graduationdesign.po.CPUMessage;
import com.graduationdesign.po.MemoryMessage;

public class DrawPictureImpl implements IDrawPicture {

	@Override
	public JFreeChart drawCPUBarChart(String prefix, CPUMessage cpuMessage) {
		// TODO Auto-generated method stub
		String title = "CPU性能分析";
		String XLabel = "CPU属性";
		String YLabel = "百分比";
		String dir = null;
		JFreeChart chart = null;
		DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
		dataSet.addValue(cpuMessage.getCountPercent(), "总使用率", "总使用率");
		dataSet.addValue(cpuMessage.getUserPercent(), "用户使用率", "用户使用率");
		dataSet.addValue(cpuMessage.getSysPercent(), "系统使用率", "系统使用率");
		dataSet.addValue(cpuMessage.getIdlePercent(), "空闲率", "空闲率");
		dataSet.addValue(cpuMessage.getNicePercent(), "错误率", "错误率");
		dataSet.addValue(cpuMessage.getWaitPercent(), "等待率", "等待率");
		PlotOrientation plotOrientation = PlotOrientation.VERTICAL;
		chart = ChartFactory.createBarChart3D(title, XLabel, YLabel, dataSet, plotOrientation, true, false, false);
		FileOutputStream outputStream = null;
		try {
			String date = cpuMessage.getDate().replace(":", "#").replace("/", ".");
			System.out.println("正在创建图片");
			dir = "D:\\picture\\" + date + "_" + prefix + "_cpubarChart.jpg";
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

	@Override
	public JFreeChart drawCPUPieChart(String prefix, CPUMessage cpuMessage) {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("空闲率", cpuMessage.getIdlePercent());
		dataset.setValue("用户使用率", cpuMessage.getUserPercent());
		dataset.setValue("系统使用率", cpuMessage.getSysPercent());
		FileOutputStream outputStream = null;
		String dir = null;
		JFreeChart chart = null;
		try {
			String date = cpuMessage.getDate().replace(":", "#").replace("/", ".");
			System.out.println("正在创建图片");
			dir = "D:\\picture\\" + date + "_" + prefix + " _cpupieChart1.jpg";
			outputStream = new FileOutputStream(dir);
			chart = ChartFactory.createPieChart("CPU性能", dataset, true, true, false);
			PiePlot plot = (PiePlot) chart.getPlot();
			// 设置饼图为圆形
			plot.setCircular(true);
			// 设置颜色
			plot.setSectionPaint("空闲率", new Color(200, 255, 255));
			plot.setExplodePercent("用户使用率", 0.25);
			plot.setExplodePercent("系统使用率", 0.25);
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
		return chart;

	}

	@Override
	public JFreeChart drawCPULineChart(String prefix, List<CPUMessage> list) {
		DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
		int length = list.size() >= 6 ? list.size() / 6 : 1;
		String dir = null;
		JFreeChart jfreechart = null;
		for (int i = 0; i < list.size(); i = i + length) {
			CPUMessage cpuMessage = list.get(i);
			String date = cpuMessage.getDate();
			double countPercent = cpuMessage.getCountPercent();
			defaultcategorydataset.addValue(countPercent, "CPU使用率", date);
		}
		try {
			Date now = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd  HH:mm");
			String date = dateFormat.format(now).replace(":", "#").replace("/", ".");
			dir = "D:\\picture\\" + date + "_" + prefix + "_cpuLineChart.jpg";
			OutputStream outputStream = new FileOutputStream(dir);
			CategoryDataset dataset = defaultcategorydataset;
			// 创建图形对象
			jfreechart = ChartFactory.createLineChart("CPU总利用率", null, "利用率", dataset, PlotOrientation.VERTICAL, false,
					true, false);
			// 设置图表的子标题
			jfreechart.addSubtitle(new TextTitle("按时间"));
			// 创建一个标题
			TextTitle texttitle = new TextTitle("日期: " + new Date());
			// 设置标题字体
			texttitle.setFont(new Font("黑体", 0, 10));
			// 设置标题向下对齐
			texttitle.setPosition(RectangleEdge.BOTTOM);
			// 设置标题向右对齐
			texttitle.setHorizontalAlignment(HorizontalAlignment.RIGHT);
			// 添加图表的子标题
			jfreechart.addSubtitle(texttitle);
			// 设置图表的背景色为白色
			jfreechart.setBackgroundPaint(Color.white);
			// 获得图表区域对象
			CategoryPlot categoryplot = (CategoryPlot) jfreechart.getPlot();
			categoryplot.setBackgroundPaint(Color.lightGray);
			categoryplot.setRangeGridlinesVisible(false);
			CategoryAxis domainAxis = categoryplot.getDomainAxis();
			domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45); // 设置X轴上的Lable让其45度倾斜
																				//   
																				//  
			domainAxis.setLowerMargin(0.0);// 设置距离图片左端距离
			domainAxis.setUpperMargin(0.0);// 设置距离图片右端距离
			// 获显示线条对象
			LineAndShapeRenderer lineandshaperenderer = (LineAndShapeRenderer) categoryplot.getRenderer();
			lineandshaperenderer.setBaseShapesVisible(true);
			lineandshaperenderer.setDrawOutlines(true);
			lineandshaperenderer.setUseFillPaint(true);
			lineandshaperenderer.setBaseFillPaint(Color.white);
			// 设置折线加粗
			lineandshaperenderer.setSeriesStroke(0, new BasicStroke(3F));
			lineandshaperenderer.setSeriesOutlineStroke(0, new BasicStroke(2.0F));
			// 设置折线拐点
			lineandshaperenderer.setSeriesShape(0, new java.awt.geom.Ellipse2D.Double(-5D, -5D, 10D, 10D));

			// 将图表已数据流的方式返回给客户端
			ChartUtilities.writeChartAsJPEG(outputStream, jfreechart, 1000, 800);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jfreechart;

	}

	@Override
	public JFreeChart drawMemBarChart(String prefix, MemoryMessage memoryMessage) {
		// TODO Auto-generated method stub
		String title = "内存性能分析";
		String XLabel = "内存关键属性";
		String YLabel = "大小/M";
		String dir = null;
		JFreeChart chart = null;
		DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
		dataSet.addValue(memoryMessage.getCountMem(), "总大小", "总大小");
		dataSet.addValue(memoryMessage.getUsedMem(), "已使用", "已使用");
		dataSet.addValue(memoryMessage.getFreeMem(), "可用大小", "可用大小");
		dataSet.addValue(memoryMessage.getSwapTotal(), "swap总大小", "swap区总大小");
		dataSet.addValue(memoryMessage.getSwapUsed(), "swap区使用大小", "swap区使用大小");
		dataSet.addValue(memoryMessage.getSwapFree(), "swap剩余大小", "swap区剩余大小");
		PlotOrientation plotOrientation = PlotOrientation.VERTICAL;
		chart = ChartFactory.createBarChart3D(title, XLabel, YLabel, dataSet, plotOrientation, true, false, false);
		FileOutputStream outputStream = null;
		try {
			String date = memoryMessage.getDate().replace(":", "#").replace("/", ".");

			System.out.println("正在创建图片");
			dir = "D:\\picture\\" + date + "_" + prefix + "_membarChart.jpg";
			outputStream = new FileOutputStream(dir);
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
		return chart;

	}

	@Override
	public JFreeChart drawMemPieChart(String prefix, MemoryMessage memoryMessage) {
		DefaultPieDataset dataset = new DefaultPieDataset();
		String dir = null;
		dataset.setValue("mem使用率", memoryMessage.getUsedPercent());
		dataset.setValue("mem空闲率", 100 - memoryMessage.getUsedPercent());
		System.out.println("mem空闲率" + memoryMessage.getFreePercent());
		System.out.println("mem使用率" + memoryMessage.getUsedPercent());
		FileOutputStream outputStream = null;
		JFreeChart chart = null;
		try {
			String date = memoryMessage.getDate().replace(":", "#").replace("/", ".");
			dir = "D:\\picture\\" + date + "_" + prefix + "_mempieChart.jpg";
			outputStream = new FileOutputStream(dir);
			chart = ChartFactory.createPieChart("内存性能", dataset, true, true, false);
			PiePlot plot = (PiePlot) chart.getPlot();
			// 设置饼图为圆形
			plot.setCircular(true);
			// 设置颜色
			plot.setSectionPaint("mem空闲率", new Color(200, 255, 255));
			plot.setExplodePercent("mem空闲率", 0.25);
			plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} ({1} percent)"));
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
		return chart;

	}

	@Override
	public JFreeChart drawMemLineChart(String prefix, List<MemoryMessage> list) {
		DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
		int length = list.size() >= 6 ? list.size() / 6 : 1;
		String dir = null;
		JFreeChart jfreechart = null;
		for (int i = 0; i < list.size(); i = i + length) {
			MemoryMessage memoryMessage = list.get(i);
			String date = memoryMessage.getDate();
			double countPercent = memoryMessage.getUsedPercent();
			defaultcategorydataset.addValue(countPercent, "内存使用率", date);
		}
		try {
			Date now = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd  HH:mm");
			String date = dateFormat.format(now).replace(":", "#").replace("/", ".");
			dir = "D:\\picture\\" + date + "_" + prefix + "_memLineChart.jpg";
			OutputStream outputStream = new FileOutputStream(dir);
			CategoryDataset dataset = defaultcategorydataset;
			// 创建图形对象
			jfreechart = ChartFactory.createLineChart("内存使用率", null, "使用率", dataset, PlotOrientation.VERTICAL, false,
					true, false);
			// 设置图表的子标题
			jfreechart.addSubtitle(new TextTitle("按时间"));
			// 创建一个标题
			TextTitle texttitle = new TextTitle("日期: " + new Date());
			// 设置标题字体
			texttitle.setFont(new Font("黑体", 0, 10));
			// 设置标题向下对齐
			texttitle.setPosition(RectangleEdge.BOTTOM);
			// 设置标题向右对齐
			texttitle.setHorizontalAlignment(HorizontalAlignment.RIGHT);
			// 添加图表的子标题
			jfreechart.addSubtitle(texttitle);
			// 设置图表的背景色为白色
			jfreechart.setBackgroundPaint(Color.white);
			// 获得图表区域对象
			CategoryPlot categoryplot = (CategoryPlot) jfreechart.getPlot();
			categoryplot.setBackgroundPaint(Color.lightGray);
			categoryplot.setRangeGridlinesVisible(false);
			CategoryAxis domainAxis = categoryplot.getDomainAxis();
			domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45); // 设置X轴上的Lable让其45度倾斜
																				//   
																				//  
			domainAxis.setLowerMargin(0.0);// 设置距离图片左端距离
			domainAxis.setUpperMargin(0.0);// 设置距离图片右端距离
			// 获显示线条对象
			LineAndShapeRenderer lineandshaperenderer = (LineAndShapeRenderer) categoryplot.getRenderer();
			lineandshaperenderer.setBaseShapesVisible(true);
			lineandshaperenderer.setDrawOutlines(true);
			lineandshaperenderer.setUseFillPaint(true);
			lineandshaperenderer.setBaseFillPaint(Color.white);
			// 设置折线加粗
			lineandshaperenderer.setSeriesStroke(0, new BasicStroke(3F));
			lineandshaperenderer.setSeriesOutlineStroke(0, new BasicStroke(2.0F));
			// 设置折线拐点
			lineandshaperenderer.setSeriesShape(0, new java.awt.geom.Ellipse2D.Double(-5D, -5D, 10D, 10D));

			// 将图表已数据流的方式返回给客户端
			ChartUtilities.writeChartAsJPEG(outputStream, jfreechart, 1000, 800);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jfreechart;
	}

}
