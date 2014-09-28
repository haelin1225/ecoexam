package kr.co.eco.util;

import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.beans.factory.annotation.Autowired;

public class BarChart {
	@Autowired
	
	
	public static void main(String arg[]){
		BarChart bcb = new BarChart();
		JFreeChart chart = bcb.getBarChart();
		ChartFrame frame1=new ChartFrame("Bar Chart",chart);
		frame1.setSize(400,350);  
		frame1.setVisible(true);
	} 
	
	public JFreeChart getBarChart() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(2, "Marks", "Rahul");
		dataset.setValue(7, "Marks", "Vinod");
		dataset.setValue(4, "Marks", "Deepak");
		dataset.setValue(9, "Marks", "Prashant");
		dataset.setValue(6, "Marks", "Chandan");
		JFreeChart chart = ChartFactory.createBarChart	(
			"BarChart using JFreeChart","시험차수", "점수", dataset, 
			PlotOrientation.VERTICAL, false,true, false);
		chart.setBackgroundPaint(Color.yellow);
		chart.getTitle().setPaint(Color.blue); 
		CategoryPlot p = chart.getCategoryPlot(); 
		p.setRangeGridlinePaint(Color.red); 
		return chart;
	}
}
