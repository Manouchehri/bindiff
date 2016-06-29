/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PolarPlot;

public class PolarChartPanel
extends ChartPanel {
    private static final String POLAR_ZOOM_IN_ACTION_COMMAND = "Polar Zoom In";
    private static final String POLAR_ZOOM_OUT_ACTION_COMMAND = "Polar Zoom Out";
    private static final String POLAR_AUTO_RANGE_ACTION_COMMAND = "Polar Auto Range";

    public PolarChartPanel(JFreeChart jFreeChart) {
        this(jFreeChart, true);
    }

    public PolarChartPanel(JFreeChart jFreeChart, boolean bl2) {
        super(jFreeChart, bl2);
        this.checkChart(jFreeChart);
        this.setMinimumDrawWidth(200);
        this.setMinimumDrawHeight(200);
        this.setMaximumDrawWidth(2000);
        this.setMaximumDrawHeight(2000);
    }

    @Override
    public void setChart(JFreeChart jFreeChart) {
        this.checkChart(jFreeChart);
        super.setChart(jFreeChart);
    }

    @Override
    protected JPopupMenu createPopupMenu(boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        JPopupMenu jPopupMenu = super.createPopupMenu(bl2, bl3, bl4, bl5);
        int n2 = this.getPopupMenuItem(jPopupMenu, "Zoom In");
        int n3 = this.getPopupMenuItem(jPopupMenu, "Zoom Out");
        int n4 = this.getPopupMenuItem(jPopupMenu, "Auto Range");
        if (!bl5) return jPopupMenu;
        JMenuItem jMenuItem = new JMenuItem("Zoom In");
        jMenuItem.setActionCommand("Polar Zoom In");
        jMenuItem.addActionListener(this);
        JMenuItem jMenuItem2 = new JMenuItem("Zoom Out");
        jMenuItem2.setActionCommand("Polar Zoom Out");
        jMenuItem2.addActionListener(this);
        JMenuItem jMenuItem3 = new JMenuItem("Auto Range");
        jMenuItem3.setActionCommand("Polar Auto Range");
        jMenuItem3.addActionListener(this);
        if (n2 != -1) {
            jPopupMenu.remove(n2);
        } else {
            n2 = jPopupMenu.getComponentCount() - 1;
        }
        jPopupMenu.add((Component)jMenuItem, n2);
        if (n3 != -1) {
            jPopupMenu.remove(n3);
        } else {
            n3 = n2 + 1;
        }
        jPopupMenu.add((Component)jMenuItem2, n3);
        if (n4 != -1) {
            jPopupMenu.remove(n4);
        } else {
            n4 = n3 + 1;
        }
        jPopupMenu.add((Component)jMenuItem3, n4);
        return jPopupMenu;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String string = actionEvent.getActionCommand();
        if (string.equals("Polar Zoom In")) {
            PolarPlot polarPlot = (PolarPlot)this.getChart().getPlot();
            polarPlot.zoom(0.5);
            return;
        }
        if (string.equals("Polar Zoom Out")) {
            PolarPlot polarPlot = (PolarPlot)this.getChart().getPlot();
            polarPlot.zoom(2.0);
            return;
        }
        if (string.equals("Polar Auto Range")) {
            PolarPlot polarPlot = (PolarPlot)this.getChart().getPlot();
            polarPlot.getAxis().setAutoRange(true);
            return;
        }
        super.actionPerformed(actionEvent);
    }

    private void checkChart(JFreeChart jFreeChart) {
        Plot plot = jFreeChart.getPlot();
        if (plot instanceof PolarPlot) return;
        throw new IllegalArgumentException("plot is not a PolarPlot");
    }

    private int getPopupMenuItem(JPopupMenu jPopupMenu, String string) {
        int n2 = -1;
        int n3 = 0;
        while (n2 == -1) {
            JMenuItem jMenuItem;
            if (n3 >= jPopupMenu.getComponentCount()) return n2;
            Component component = jPopupMenu.getComponent(n3);
            if (component instanceof JMenuItem && string.equals((jMenuItem = (JMenuItem)component).getText())) {
                n2 = n3;
            }
            ++n3;
        }
        return n2;
    }
}

