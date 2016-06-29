package org.jfree.chart;

import javax.swing.*;
import java.awt.*;

public class ChartFrame extends JFrame
{
    private ChartPanel chartPanel;
    
    public ChartFrame(final String s, final JFreeChart freeChart) {
        this(s, freeChart, false);
    }
    
    public ChartFrame(final String s, final JFreeChart freeChart, final boolean b) {
        super(s);
        this.setDefaultCloseOperation(2);
        this.chartPanel = new ChartPanel(freeChart);
        if (b) {
            this.setContentPane(new JScrollPane(this.chartPanel));
        }
        else {
            this.setContentPane(this.chartPanel);
        }
    }
    
    public ChartPanel getChartPanel() {
        return this.chartPanel;
    }
}
