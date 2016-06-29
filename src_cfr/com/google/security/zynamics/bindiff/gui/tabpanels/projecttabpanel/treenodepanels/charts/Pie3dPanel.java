/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Paint;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.PieToolTipGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.Rotation;

public class Pie3dPanel
extends ChartPanel {
    private static final Font TITLE_FONT = new Font("Arial", 0, 16);
    private static final Font LABEL_FONT = new Font("Arial", 0, 10);
    private final PiePlot3D section;

    public Pie3dPanel(String string, DefaultPieDataset defaultPieDataset, PieSectionLabelGenerator pieSectionLabelGenerator) {
        super(ChartFactory.createPieChart3D(string, defaultPieDataset, false, true, false), false, true, false, false, true);
        this.getChart().setBorderPaint(Color.WHITE);
        this.getChart().getTitle().setFont(TITLE_FONT);
        this.getChart().setPadding(new RectangleInsets(5.0, 0.0, 0.0, 0.0));
        this.setMinimumDrawHeight(0);
        this.setMinimumDrawWidth(0);
        this.setMaximumDrawHeight(32768);
        this.setMaximumDrawWidth(32768);
        this.section = (PiePlot3D)this.getChart().getPlot();
        this.section.setLabelFont(LABEL_FONT);
        this.section.setBackgroundPaint(Color.WHITE);
        this.section.setOutlinePaint(Color.WHITE);
        this.section.setBaseSectionOutlinePaint(Color.WHITE);
        this.section.setStartAngle(0.0);
        this.section.setDirection(Rotation.CLOCKWISE);
        this.section.setForegroundAlpha(0.5f);
        this.section.setNoDataMessage("(No data to display)");
        this.section.setCircular(true);
        this.section.setLabelGenerator(pieSectionLabelGenerator);
        this.setPreferredSize(new Dimension(240, 200));
    }

    public void fireChartChanged() {
        this.getChart().fireChartChanged();
    }

    public void setSectionColor(String string, Color color) {
        this.section.setSectionPaint((Comparable)((Object)string), (Paint)color);
    }

    public void setTitle(String string) {
        this.getChart().setTitle(string);
    }

    public void setTooltipGenerator(PieToolTipGenerator pieToolTipGenerator) {
        this.section.setToolTipGenerator(pieToolTipGenerator);
    }
}

