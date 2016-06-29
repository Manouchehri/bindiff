/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.demo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Paint;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Month;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class TimeSeriesChartDemo1
extends ApplicationFrame {
    static Class class$org$jfree$data$time$Month;

    public TimeSeriesChartDemo1(String string) {
        super(string);
        ChartPanel chartPanel = (ChartPanel)TimeSeriesChartDemo1.createDemoPanel();
        chartPanel.setPreferredSize(new Dimension(500, 270));
        chartPanel.setMouseZoomable(true, false);
        this.setContentPane(chartPanel);
    }

    private static JFreeChart createChart(XYDataset xYDataset) {
        XYLineAndShapeRenderer xYLineAndShapeRenderer;
        JFreeChart jFreeChart = ChartFactory.createTimeSeriesChart("Legal & General Unit Trust Prices", "Date", "Price Per Unit", xYDataset, true, true, false);
        jFreeChart.setBackgroundPaint(Color.white);
        XYPlot xYPlot = (XYPlot)jFreeChart.getPlot();
        xYPlot.setBackgroundPaint(Color.lightGray);
        xYPlot.setDomainGridlinePaint(Color.white);
        xYPlot.setRangeGridlinePaint(Color.white);
        xYPlot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        xYPlot.setDomainCrosshairVisible(true);
        xYPlot.setRangeCrosshairVisible(true);
        XYItemRenderer xYItemRenderer = xYPlot.getRenderer();
        if (xYItemRenderer instanceof XYLineAndShapeRenderer) {
            xYLineAndShapeRenderer = (XYLineAndShapeRenderer)xYItemRenderer;
            xYLineAndShapeRenderer.setBaseShapesVisible(true);
            xYLineAndShapeRenderer.setBaseShapesFilled(true);
        }
        xYLineAndShapeRenderer = (DateAxis)xYPlot.getDomainAxis();
        xYLineAndShapeRenderer.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));
        return jFreeChart;
    }

    private static XYDataset createDataset() {
        Class class_ = class$org$jfree$data$time$Month == null ? (TimeSeriesChartDemo1.class$org$jfree$data$time$Month = TimeSeriesChartDemo1.class$("org.jfree.data.time.Month")) : class$org$jfree$data$time$Month;
        TimeSeries timeSeries = new TimeSeries("L&G European Index Trust", class_);
        timeSeries.add((RegularTimePeriod)new Month(2, 2001), 181.8);
        timeSeries.add((RegularTimePeriod)new Month(3, 2001), 167.3);
        timeSeries.add((RegularTimePeriod)new Month(4, 2001), 153.8);
        timeSeries.add((RegularTimePeriod)new Month(5, 2001), 167.6);
        timeSeries.add((RegularTimePeriod)new Month(6, 2001), 158.8);
        timeSeries.add((RegularTimePeriod)new Month(7, 2001), 148.3);
        timeSeries.add((RegularTimePeriod)new Month(8, 2001), 153.9);
        timeSeries.add((RegularTimePeriod)new Month(9, 2001), 142.7);
        timeSeries.add((RegularTimePeriod)new Month(10, 2001), 123.2);
        timeSeries.add((RegularTimePeriod)new Month(11, 2001), 131.8);
        timeSeries.add((RegularTimePeriod)new Month(12, 2001), 139.6);
        timeSeries.add((RegularTimePeriod)new Month(1, 2002), 142.9);
        timeSeries.add((RegularTimePeriod)new Month(2, 2002), 138.7);
        timeSeries.add((RegularTimePeriod)new Month(3, 2002), 137.3);
        timeSeries.add((RegularTimePeriod)new Month(4, 2002), 143.9);
        timeSeries.add((RegularTimePeriod)new Month(5, 2002), 139.8);
        timeSeries.add((RegularTimePeriod)new Month(6, 2002), 137.0);
        timeSeries.add((RegularTimePeriod)new Month(7, 2002), 132.8);
        TimeSeries timeSeries2 = new TimeSeries("L&G UK Index Trust", class$org$jfree$data$time$Month == null ? (TimeSeriesChartDemo1.class$org$jfree$data$time$Month = TimeSeriesChartDemo1.class$("org.jfree.data.time.Month")) : class$org$jfree$data$time$Month);
        timeSeries2.add((RegularTimePeriod)new Month(2, 2001), 129.6);
        timeSeries2.add((RegularTimePeriod)new Month(3, 2001), 123.2);
        timeSeries2.add((RegularTimePeriod)new Month(4, 2001), 117.2);
        timeSeries2.add((RegularTimePeriod)new Month(5, 2001), 124.1);
        timeSeries2.add((RegularTimePeriod)new Month(6, 2001), 122.6);
        timeSeries2.add((RegularTimePeriod)new Month(7, 2001), 119.2);
        timeSeries2.add((RegularTimePeriod)new Month(8, 2001), 116.5);
        timeSeries2.add((RegularTimePeriod)new Month(9, 2001), 112.7);
        timeSeries2.add((RegularTimePeriod)new Month(10, 2001), 101.5);
        timeSeries2.add((RegularTimePeriod)new Month(11, 2001), 106.1);
        timeSeries2.add((RegularTimePeriod)new Month(12, 2001), 110.3);
        timeSeries2.add((RegularTimePeriod)new Month(1, 2002), 111.7);
        timeSeries2.add((RegularTimePeriod)new Month(2, 2002), 111.0);
        timeSeries2.add((RegularTimePeriod)new Month(3, 2002), 109.6);
        timeSeries2.add((RegularTimePeriod)new Month(4, 2002), 113.2);
        timeSeries2.add((RegularTimePeriod)new Month(5, 2002), 111.6);
        timeSeries2.add((RegularTimePeriod)new Month(6, 2002), 108.8);
        timeSeries2.add((RegularTimePeriod)new Month(7, 2002), 101.6);
        TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
        timeSeriesCollection.addSeries(timeSeries);
        timeSeriesCollection.addSeries(timeSeries2);
        return timeSeriesCollection;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = TimeSeriesChartDemo1.createChart(TimeSeriesChartDemo1.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        TimeSeriesChartDemo1 timeSeriesChartDemo1 = new TimeSeriesChartDemo1("Time Series Chart Demo 1");
        timeSeriesChartDemo1.pack();
        RefineryUtilities.centerFrameOnScreen(timeSeriesChartDemo1);
        timeSeriesChartDemo1.setVisible(true);
    }

    static Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException var1_1) {
            throw new NoClassDefFoundError(var1_1.getMessage());
        }
    }
}

