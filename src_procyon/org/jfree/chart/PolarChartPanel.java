package org.jfree.chart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.jfree.chart.plot.*;

public class PolarChartPanel extends ChartPanel
{
    private static final String POLAR_ZOOM_IN_ACTION_COMMAND = "Polar Zoom In";
    private static final String POLAR_ZOOM_OUT_ACTION_COMMAND = "Polar Zoom Out";
    private static final String POLAR_AUTO_RANGE_ACTION_COMMAND = "Polar Auto Range";
    
    public PolarChartPanel(final JFreeChart freeChart) {
        this(freeChart, true);
    }
    
    public PolarChartPanel(final JFreeChart freeChart, final boolean b) {
        super(freeChart, b);
        this.checkChart(freeChart);
        this.setMinimumDrawWidth(200);
        this.setMinimumDrawHeight(200);
        this.setMaximumDrawWidth(2000);
        this.setMaximumDrawHeight(2000);
    }
    
    public void setChart(final JFreeChart chart) {
        this.checkChart(chart);
        super.setChart(chart);
    }
    
    protected JPopupMenu createPopupMenu(final boolean b, final boolean b2, final boolean b3, final boolean b4) {
        final JPopupMenu popupMenu = super.createPopupMenu(b, b2, b3, b4);
        int popupMenuItem = this.getPopupMenuItem(popupMenu, "Zoom In");
        int popupMenuItem2 = this.getPopupMenuItem(popupMenu, "Zoom Out");
        int popupMenuItem3 = this.getPopupMenuItem(popupMenu, "Auto Range");
        if (b4) {
            final JMenuItem menuItem = new JMenuItem("Zoom In");
            menuItem.setActionCommand("Polar Zoom In");
            menuItem.addActionListener(this);
            final JMenuItem menuItem2 = new JMenuItem("Zoom Out");
            menuItem2.setActionCommand("Polar Zoom Out");
            menuItem2.addActionListener(this);
            final JMenuItem menuItem3 = new JMenuItem("Auto Range");
            menuItem3.setActionCommand("Polar Auto Range");
            menuItem3.addActionListener(this);
            if (popupMenuItem != -1) {
                popupMenu.remove(popupMenuItem);
            }
            else {
                popupMenuItem = popupMenu.getComponentCount() - 1;
            }
            popupMenu.add(menuItem, popupMenuItem);
            if (popupMenuItem2 != -1) {
                popupMenu.remove(popupMenuItem2);
            }
            else {
                popupMenuItem2 = popupMenuItem + 1;
            }
            popupMenu.add(menuItem2, popupMenuItem2);
            if (popupMenuItem3 != -1) {
                popupMenu.remove(popupMenuItem3);
            }
            else {
                popupMenuItem3 = popupMenuItem2 + 1;
            }
            popupMenu.add(menuItem3, popupMenuItem3);
        }
        return popupMenu;
    }
    
    public void actionPerformed(final ActionEvent actionEvent) {
        final String actionCommand = actionEvent.getActionCommand();
        if (actionCommand.equals("Polar Zoom In")) {
            ((PolarPlot)this.getChart().getPlot()).zoom(0.5);
        }
        else if (actionCommand.equals("Polar Zoom Out")) {
            ((PolarPlot)this.getChart().getPlot()).zoom(2.0);
        }
        else if (actionCommand.equals("Polar Auto Range")) {
            ((PolarPlot)this.getChart().getPlot()).getAxis().setAutoRange(true);
        }
        else {
            super.actionPerformed(actionEvent);
        }
    }
    
    private void checkChart(final JFreeChart freeChart) {
        if (!(freeChart.getPlot() instanceof PolarPlot)) {
            throw new IllegalArgumentException("plot is not a PolarPlot");
        }
    }
    
    private int getPopupMenuItem(final JPopupMenu popupMenu, final String s) {
        int n = -1;
        for (int n2 = 0; n == -1 && n2 < popupMenu.getComponentCount(); ++n2) {
            final Component component = popupMenu.getComponent(n2);
            if (component instanceof JMenuItem && s.equals(((JMenuItem)component).getText())) {
                n = n2;
            }
        }
        return n;
    }
}
