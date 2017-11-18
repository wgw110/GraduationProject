package com.graduation.message301;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;

public class BrokenLineTest2 {
	public static void main(String[] agrs) throws IOException{

		// 打开一个输出流
		OutputStream outputStream=new FileOutputStream("Picture\\LineChart.jpg");

		// 获取数据集对象
		CategoryDataset dataset = createDataset();
		// 创建图形对象
		JFreeChart jfreechart = ChartFactory.createLineChart("08年图书销售量",
				null, "销售量", dataset, PlotOrientation.VERTICAL, false, true,
				false);
		// 设置图表的子标题
		jfreechart.addSubtitle(new TextTitle("按月份"));
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
		// 获显示线条对象
		LineAndShapeRenderer lineandshaperenderer = (LineAndShapeRenderer) categoryplot
				.getRenderer();
		lineandshaperenderer.setBaseShapesVisible(true);
		lineandshaperenderer.setDrawOutlines(true);
		lineandshaperenderer.setUseFillPaint(true);
		lineandshaperenderer.setBaseFillPaint(Color.white);
		// 设置折线加粗
		lineandshaperenderer.setSeriesStroke(0, new BasicStroke(3F));
		lineandshaperenderer.setSeriesOutlineStroke(0, new BasicStroke(2.0F));
		// 设置折线拐点
		lineandshaperenderer.setSeriesShape(0,
				new java.awt.geom.Ellipse2D.Double(-5D, -5D, 10D, 10D));
		
		// 将图表已数据流的方式返回给客户端
		ChartUtilities.writeChartAsPNG(outputStream, jfreechart,
				500, 270);
	}
	
	/**
	 * 返回数据集
	 * 
	 * @return
	 */
	private static CategoryDataset createDataset() {
		DefaultCategoryDataset defaultdataset = new DefaultCategoryDataset();
		for (int i = 1; i <= 12; i++) {
			defaultdataset.addValue(DataUtils.getRandomData(), "JAVA", i + "月");
			defaultdataset.addValue(DataUtils.getRandomData(), "PHP", i + "月");

		}
		return defaultdataset;
	}

}
