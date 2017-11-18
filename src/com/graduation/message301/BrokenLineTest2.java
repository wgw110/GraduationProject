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

		// ��һ�������
		OutputStream outputStream=new FileOutputStream("Picture\\LineChart.jpg");

		// ��ȡ���ݼ�����
		CategoryDataset dataset = createDataset();
		// ����ͼ�ζ���
		JFreeChart jfreechart = ChartFactory.createLineChart("08��ͼ��������",
				null, "������", dataset, PlotOrientation.VERTICAL, false, true,
				false);
		// ����ͼ����ӱ���
		jfreechart.addSubtitle(new TextTitle("���·�"));
		// ����һ������
		TextTitle texttitle = new TextTitle("����: " + new Date());
		// ���ñ�������
		texttitle.setFont(new Font("����", 0, 10));
		// ���ñ������¶���
		texttitle.setPosition(RectangleEdge.BOTTOM);
		// ���ñ������Ҷ���
		texttitle.setHorizontalAlignment(HorizontalAlignment.RIGHT);
		// ���ͼ����ӱ���
		jfreechart.addSubtitle(texttitle);
		// ����ͼ��ı���ɫΪ��ɫ
		jfreechart.setBackgroundPaint(Color.white);
		// ���ͼ���������
		CategoryPlot categoryplot = (CategoryPlot) jfreechart.getPlot();
		categoryplot.setBackgroundPaint(Color.lightGray);
		categoryplot.setRangeGridlinesVisible(false);
		// ����ʾ��������
		LineAndShapeRenderer lineandshaperenderer = (LineAndShapeRenderer) categoryplot
				.getRenderer();
		lineandshaperenderer.setBaseShapesVisible(true);
		lineandshaperenderer.setDrawOutlines(true);
		lineandshaperenderer.setUseFillPaint(true);
		lineandshaperenderer.setBaseFillPaint(Color.white);
		// �������߼Ӵ�
		lineandshaperenderer.setSeriesStroke(0, new BasicStroke(3F));
		lineandshaperenderer.setSeriesOutlineStroke(0, new BasicStroke(2.0F));
		// �������߹յ�
		lineandshaperenderer.setSeriesShape(0,
				new java.awt.geom.Ellipse2D.Double(-5D, -5D, 10D, 10D));
		
		// ��ͼ�����������ķ�ʽ���ظ��ͻ���
		ChartUtilities.writeChartAsPNG(outputStream, jfreechart,
				500, 270);
	}
	
	/**
	 * �������ݼ�
	 * 
	 * @return
	 */
	private static CategoryDataset createDataset() {
		DefaultCategoryDataset defaultdataset = new DefaultCategoryDataset();
		for (int i = 1; i <= 12; i++) {
			defaultdataset.addValue(DataUtils.getRandomData(), "JAVA", i + "��");
			defaultdataset.addValue(DataUtils.getRandomData(), "PHP", i + "��");

		}
		return defaultdataset;
	}

}
