package org.jfree.chart.demo;

import org.jfree.data.xy.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.axis.*;
import java.text.*;
import org.jfree.chart.renderer.xy.*;
import org.jfree.data.time.*;
import javax.swing.*;
import org.jfree.ui.*;
import java.awt.*;

public class TimeSeriesChartDemo1 extends ApplicationFrame
{
    static Class class$org$jfree$data$time$Month;
    
    public TimeSeriesChartDemo1(final String s) {
        super(s);
        final ChartPanel contentPane = (ChartPanel)createDemoPanel();
        contentPane.setPreferredSize(new Dimension(500, 270));
        contentPane.setMouseZoomable(true, false);
        this.setContentPane(contentPane);
    }
    
    private static JFreeChart createChart(final XYDataset xyDataset) {
        final JFreeChart timeSeriesChart = ChartFactory.createTimeSeriesChart("Legal & General Unit Trust Prices", "Date", "Price Per Unit", xyDataset, true, true, false);
        timeSeriesChart.setBackgroundPaint(Color.white);
        final XYPlot xyPlot = (XYPlot)timeSeriesChart.getPlot();
        xyPlot.setBackgroundPaint(Color.lightGray);
        xyPlot.setDomainGridlinePaint(Color.white);
        xyPlot.setRangeGridlinePaint(Color.white);
        xyPlot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        xyPlot.setDomainCrosshairVisible(true);
        xyPlot.setRangeCrosshairVisible(true);
        final XYItemRenderer renderer = xyPlot.getRenderer();
        if (renderer instanceof XYLineAndShapeRenderer) {
            final XYLineAndShapeRenderer xyLineAndShapeRenderer = (XYLineAndShapeRenderer)renderer;
            xyLineAndShapeRenderer.setBaseShapesVisible(true);
            xyLineAndShapeRenderer.setBaseShapesFilled(true);
        }
        ((DateAxis)xyPlot.getDomainAxis()).setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));
        return timeSeriesChart;
    }
    
    private static XYDataset createDataset() {
        final TimeSeries timeSeries = new TimeSeries("L&G European Index Trust", (TimeSeriesChartDemo1.class$org$jfree$data$time$Month == null) ? (TimeSeriesChartDemo1.class$org$jfree$data$time$Month = class$("org.jfree.data.time.Month")) : TimeSeriesChartDemo1.class$org$jfree$data$time$Month);
        timeSeries.add(new Month(2, 2001), 181.8);
        timeSeries.add(new Month(3, 2001), 167.3);
        timeSeries.add(new Month(4, 2001), 153.8);
        timeSeries.add(new Month(5, 2001), 167.6);
        timeSeries.add(new Month(6, 2001), 158.8);
        timeSeries.add(new Month(7, 2001), 148.3);
        timeSeries.add(new Month(8, 2001), 153.9);
        timeSeries.add(new Month(9, 2001), 142.7);
        timeSeries.add(new Month(10, 2001), 123.2);
        timeSeries.add(new Month(11, 2001), 131.8);
        timeSeries.add(new Month(12, 2001), 139.6);
        timeSeries.add(new Month(1, 2002), 142.9);
        timeSeries.add(new Month(2, 2002), 138.7);
        timeSeries.add(new Month(3, 2002), 137.3);
        timeSeries.add(new Month(4, 2002), 143.9);
        timeSeries.add(new Month(5, 2002), 139.8);
        timeSeries.add(new Month(6, 2002), 137.0);
        timeSeries.add(new Month(7, 2002), 132.8);
        final TimeSeries timeSeries2 = new TimeSeries("L&G UK Index Trust", (TimeSeriesChartDemo1.class$org$jfree$data$time$Month == null) ? (TimeSeriesChartDemo1.class$org$jfree$data$time$Month = class$("org.jfree.data.time.Month")) : TimeSeriesChartDemo1.class$org$jfree$data$time$Month);
        timeSeries2.add(new Month(2, 2001), 129.6);
        timeSeries2.add(new Month(3, 2001), 123.2);
        timeSeries2.add(new Month(4, 2001), 117.2);
        timeSeries2.add(new Month(5, 2001), 124.1);
        timeSeries2.add(new Month(6, 2001), 122.6);
        timeSeries2.add(new Month(7, 2001), 119.2);
        timeSeries2.add(new Month(8, 2001), 116.5);
        timeSeries2.add(new Month(9, 2001), 112.7);
        timeSeries2.add(new Month(10, 2001), 101.5);
        timeSeries2.add(new Month(11, 2001), 106.1);
        timeSeries2.add(new Month(12, 2001), 110.3);
        timeSeries2.add(new Month(1, 2002), 111.7);
        timeSeries2.add(new Month(2, 2002), 111.0);
        timeSeries2.add(new Month(3, 2002), 109.6);
        timeSeries2.add(new Month(4, 2002), 113.2);
        timeSeries2.add(new Month(5, 2002), 111.6);
        timeSeries2.add(new Month(6, 2002), 108.8);
        timeSeries2.add(new Month(7, 2002), 101.6);
        final TimeSeriesCollection collection = new TimeSeriesCollection();
        collection.addSeries(timeSeries);
        collection.addSeries(timeSeries2);
        return collection;
    }
    
    public static JPanel createDemoPanel() {
        return new ChartPanel(createChart(createDataset()));
    }
    
    public static void main(final String[] array) {
        final TimeSeriesChartDemo1 timeSeriesChartDemo1 = new TimeSeriesChartDemo1("Time Series Chart Demo 1");
        timeSeriesChartDemo1.pack();
        RefineryUtilities.centerFrameOnScreen(timeSeriesChartDemo1);
        timeSeriesChartDemo1.setVisible(true);
    }
    
    static Class class$(final String s) {
        try {
            return Class.forName(s);
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
}
