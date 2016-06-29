package org.jfree.chart.demo;

import org.jfree.data.category.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.category.*;
import org.jfree.chart.axis.*;
import org.jfree.ui.*;
import java.awt.*;

public class BarChartDemo1 extends ApplicationFrame
{
    public BarChartDemo1(final String s) {
        super(s);
        final ChartPanel contentPane = new ChartPanel(createChart(createDataset()), false);
        contentPane.setPreferredSize(new Dimension(500, 270));
        this.setContentPane(contentPane);
    }
    
    private static CategoryDataset createDataset() {
        final String s = "First";
        final String s2 = "Second";
        final String s3 = "Third";
        final String s4 = "Category 1";
        final String s5 = "Category 2";
        final String s6 = "Category 3";
        final String s7 = "Category 4";
        final String s8 = "Category 5";
        final DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.addValue(1.0, s, s4);
        defaultCategoryDataset.addValue(4.0, s, s5);
        defaultCategoryDataset.addValue(3.0, s, s6);
        defaultCategoryDataset.addValue(5.0, s, s7);
        defaultCategoryDataset.addValue(5.0, s, s8);
        defaultCategoryDataset.addValue(5.0, s2, s4);
        defaultCategoryDataset.addValue(7.0, s2, s5);
        defaultCategoryDataset.addValue(6.0, s2, s6);
        defaultCategoryDataset.addValue(8.0, s2, s7);
        defaultCategoryDataset.addValue(4.0, s2, s8);
        defaultCategoryDataset.addValue(4.0, s3, s4);
        defaultCategoryDataset.addValue(3.0, s3, s5);
        defaultCategoryDataset.addValue(2.0, s3, s6);
        defaultCategoryDataset.addValue(3.0, s3, s7);
        defaultCategoryDataset.addValue(6.0, s3, s8);
        return defaultCategoryDataset;
    }
    
    private static JFreeChart createChart(final CategoryDataset categoryDataset) {
        final JFreeChart barChart = ChartFactory.createBarChart("Bar Chart Demo 1", "Category", "Value", categoryDataset, PlotOrientation.VERTICAL, true, true, false);
        barChart.setBackgroundPaint(Color.white);
        final CategoryPlot categoryPlot = (CategoryPlot)barChart.getPlot();
        categoryPlot.setBackgroundPaint(Color.lightGray);
        categoryPlot.setDomainGridlinePaint(Color.white);
        categoryPlot.setDomainGridlinesVisible(true);
        categoryPlot.setRangeGridlinePaint(Color.white);
        ((NumberAxis)categoryPlot.getRangeAxis()).setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        final BarRenderer barRenderer = (BarRenderer)categoryPlot.getRenderer();
        barRenderer.setDrawBarOutline(false);
        final GradientPaint gradientPaint = new GradientPaint(0.0f, 0.0f, Color.blue, 0.0f, 0.0f, new Color(0, 0, 64));
        final GradientPaint gradientPaint2 = new GradientPaint(0.0f, 0.0f, Color.green, 0.0f, 0.0f, new Color(0, 64, 0));
        final GradientPaint gradientPaint3 = new GradientPaint(0.0f, 0.0f, Color.red, 0.0f, 0.0f, new Color(64, 0, 0));
        barRenderer.setSeriesPaint(0, gradientPaint);
        barRenderer.setSeriesPaint(1, gradientPaint2);
        barRenderer.setSeriesPaint(2, gradientPaint3);
        categoryPlot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(0.5235987755982988));
        return barChart;
    }
    
    public static void main(final String[] array) {
        final BarChartDemo1 barChartDemo1 = new BarChartDemo1("Bar Chart Demo 1");
        barChartDemo1.pack();
        RefineryUtilities.centerFrameOnScreen(barChartDemo1);
        barChartDemo1.setVisible(true);
    }
}
