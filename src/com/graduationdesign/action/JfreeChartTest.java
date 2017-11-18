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
		String title = "CPU���ܷ���";
		String XLabel = "CPU����";
		String YLabel = "�ٷֱ�";
		String dir = null;
		DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
		dataSet.addValue(cpuMessage.getCountPercent(), "��ʹ����", "��ʹ����");
		dataSet.addValue(cpuMessage.getUserPercent(), "�û�ʹ����", "�û�ʹ����");
		dataSet.addValue(cpuMessage.getSysPercent(), "ϵͳʹ����", "ϵͳʹ����");
		dataSet.addValue(cpuMessage.getIdlePercent(), "������", "������");
		dataSet.addValue(cpuMessage.getNicePercent(), "������", "������");
		dataSet.addValue(cpuMessage.getWaitPercent(), "�ȴ���", "�ȴ���");
		PlotOrientation plotOrientation = PlotOrientation.VERTICAL;
		JFreeChart chart = ChartFactory.createBarChart3D(title, XLabel, YLabel, dataSet, plotOrientation, true, false,
				false);
		FileOutputStream outputStream = null;
		try {
			String date = cpuMessage.getDate().replace(":", "#").replace("/", ".");
			System.out.println("���ڴ���ͼƬ");
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
