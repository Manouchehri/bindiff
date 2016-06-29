package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import org.jfree.chart.plot.*;
import org.jfree.chart.*;
import org.jfree.data.general.*;
import org.jfree.ui.*;
import org.jfree.util.*;
import java.awt.*;
import org.jfree.chart.labels.*;

public class Pie3dPanel extends ChartPanel
{
    private static final Font TITLE_FONT;
    private static final Font LABEL_FONT;
    private final PiePlot3D section;
    
    public Pie3dPanel(final String s, final DefaultPieDataset defaultPieDataset, final PieSectionLabelGenerator labelGenerator) {
        super(ChartFactory.createPieChart3D(s, defaultPieDataset, false, true, false), false, true, false, false, true);
        this.getChart().setBorderPaint(Color.WHITE);
        this.getChart().getTitle().setFont(Pie3dPanel.TITLE_FONT);
        this.getChart().setPadding(new RectangleInsets(5.0, 0.0, 0.0, 0.0));
        this.setMinimumDrawHeight(0);
        this.setMinimumDrawWidth(0);
        this.setMaximumDrawHeight(32768);
        this.setMaximumDrawWidth(32768);
        (this.section = (PiePlot3D)this.getChart().getPlot()).setLabelFont(Pie3dPanel.LABEL_FONT);
        this.section.setBackgroundPaint(Color.WHITE);
        this.section.setOutlinePaint(Color.WHITE);
        this.section.setBaseSectionOutlinePaint(Color.WHITE);
        this.section.setStartAngle(0.0);
        this.section.setDirection(Rotation.CLOCKWISE);
        this.section.setForegroundAlpha(0.5f);
        this.section.setNoDataMessage("(No data to display)");
        this.section.setCircular(true);
        this.section.setLabelGenerator(labelGenerator);
        this.setPreferredSize(new Dimension(240, 200));
    }
    
    public void fireChartChanged() {
        this.getChart().fireChartChanged();
    }
    
    public void setSectionColor(final String s, final Color color) {
        this.section.setSectionPaint(s, color);
    }
    
    public void setTitle(final String title) {
        this.getChart().setTitle(title);
    }
    
    public void setTooltipGenerator(final PieToolTipGenerator toolTipGenerator) {
        this.section.setToolTipGenerator(toolTipGenerator);
    }
    
    static {
        TITLE_FONT = new Font("Arial", 0, 16);
        LABEL_FONT = new Font("Arial", 0, 10);
    }
}
