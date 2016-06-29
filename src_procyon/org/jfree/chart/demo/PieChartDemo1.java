package org.jfree.chart.demo;

import org.jfree.data.general.*;
import org.jfree.chart.plot.*;
import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.ui.*;
import java.awt.*;

public class PieChartDemo1 extends ApplicationFrame
{
    public PieChartDemo1(final String s) {
        super(s);
        this.setContentPane(createDemoPanel());
    }
    
    private static PieDataset createDataset() {
        final DefaultPieDataset defaultPieDataset = new DefaultPieDataset();
        defaultPieDataset.setValue("One", new Double(43.2));
        defaultPieDataset.setValue("Two", new Double(10.0));
        defaultPieDataset.setValue("Three", new Double(27.5));
        defaultPieDataset.setValue("Four", new Double(17.5));
        defaultPieDataset.setValue("Five", new Double(11.0));
        defaultPieDataset.setValue("Six", new Double(19.4));
        return defaultPieDataset;
    }
    
    private static JFreeChart createChart(final PieDataset pieDataset) {
        final JFreeChart pieChart = ChartFactory.createPieChart("Pie Chart Demo 1", pieDataset, true, true, false);
        final PiePlot piePlot = (PiePlot)pieChart.getPlot();
        piePlot.setSectionOutlinesVisible(false);
        piePlot.setLabelFont(new Font("SansSerif", 0, 12));
        piePlot.setNoDataMessage("No data available");
        piePlot.setCircular(false);
        piePlot.setLabelGap(0.02);
        return pieChart;
    }
    
    public static JPanel createDemoPanel() {
        return new ChartPanel(createChart(createDataset()));
    }
    
    public static void main(final String[] array) {
        final PieChartDemo1 pieChartDemo1 = new PieChartDemo1("Pie Chart Demo 1");
        pieChartDemo1.pack();
        RefineryUtilities.centerFrameOnScreen(pieChartDemo1);
        pieChartDemo1.setVisible(true);
    }
}
