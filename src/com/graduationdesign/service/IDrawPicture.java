package com.graduationdesign.service;

import java.util.List;

import org.jfree.chart.JFreeChart;

import com.graduationdesign.po.CPUMessage;
import com.graduationdesign.po.MemoryMessage;

public interface IDrawPicture {
	// cpu���ͼ�ֱ�Ϊ����ͼ����ͼ������ͼ
	JFreeChart drawCPUBarChart(String prefix, CPUMessage cpuMessage);

	JFreeChart drawCPUPieChart(String prefix, CPUMessage cpuMessage);

	JFreeChart drawCPULineChart(String prefix, List<CPUMessage> list);

	// mem���ͼ�ֱ�Ϊ����ͼ����ͼ������ͼ
	JFreeChart drawMemBarChart(String prefix, MemoryMessage memoryMessage);

	JFreeChart drawMemPieChart(String prefix, MemoryMessage memoryMessage);

	JFreeChart drawMemLineChart(String prefix, List<MemoryMessage> list);

}
