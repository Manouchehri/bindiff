/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.demo;

import java.awt.Container;
import java.awt.Font;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class PieChartDemo1
extends ApplicationFrame {
    public PieChartDemo1(String string) {
        super(string);
        this.setContentPane(PieChartDemo1.createDemoPanel());
    }

    private static PieDataset createDataset() {
        DefaultPieDataset defaultPieDataset = new DefaultPieDataset();
        defaultPieDataset.setValue((Comparable)((Object)"One"), new Double(43.2));
        defaultPieDataset.setValue((Comparable)((Object)"Two"), new Double(10.0));
        defaultPieDataset.setValue((Comparable)((Object)"Three"), new Double(27.5));
        defaultPieDataset.setValue((Comparable)((Object)"Four"), new Double(17.5));
        defaultPieDataset.setValue((Comparable)((Object)"Five"), new Double(11.0));
        defaultPieDataset.setValue((Comparable)((Object)"Six"), new Double(19.4));
        return defaultPieDataset;
    }

    private static JFreeChart createChart(PieDataset pieDataset) {
        JFreeChart jFreeChart = ChartFactory.createPieChart("Pie Chart Demo 1", pieDataset, true, true, false);
        PiePlot piePlot = (PiePlot)jFreeChart.getPlot();
        piePlot.setSectionOutlinesVisible(false);
        piePlot.setLabelFont(new Font("SansSerif", 0, 12));
        piePlot.setNoDataMessage("No data available");
        piePlot.setCircular(false);
        piePlot.setLabelGap(0.02);
        return jFreeChart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jFreeChart = PieChartDemo1.createChart(PieChartDemo1.createDataset());
        return new ChartPanel(jFreeChart);
    }

    public static void main(String[] arrstring) {
        PieChartDemo1 pieChartDemo1 = new PieChartDemo1("Pie Chart Demo 1");
        pieChartDemo1.pack();
        RefineryUtilities.centerFrameOnScreen(pieChartDemo1);
        pieChartDemo1.setVisible(true);
    }
}

