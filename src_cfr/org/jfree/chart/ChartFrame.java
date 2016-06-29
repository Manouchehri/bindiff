/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart;

import java.awt.Component;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

public class ChartFrame
extends JFrame {
    private ChartPanel chartPanel;

    public ChartFrame(String string, JFreeChart jFreeChart) {
        this(string, jFreeChart, false);
    }

    public ChartFrame(String string, JFreeChart jFreeChart, boolean bl2) {
        super(string);
        this.setDefaultCloseOperation(2);
        this.chartPanel = new ChartPanel(jFreeChart);
        if (bl2) {
            this.setContentPane(new JScrollPane(this.chartPanel));
            return;
        }
        this.setContentPane(this.chartPanel);
    }

    public ChartPanel getChartPanel() {
        return this.chartPanel;
    }
}

