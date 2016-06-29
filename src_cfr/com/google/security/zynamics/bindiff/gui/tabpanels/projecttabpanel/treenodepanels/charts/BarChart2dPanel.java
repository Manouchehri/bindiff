/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.ChartBarRenderer;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.SimilarityConfidenceCellRenderer;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;
import java.awt.Stroke;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.ui.RectangleInsets;

public class BarChart2dPanel
extends ChartPanel {
    private static final Font TITLE_FONT = new Font("Arial", 0, 16);
    private static final Font LABEL_FONT = new Font("Arial", 0, 12);
    private final CategoryPlot plot;

    public BarChart2dPanel(String string, CategoryDataset categoryDataset) {
        super(ChartFactory.createBarChart3D(string, "", "Matched Functions", categoryDataset, PlotOrientation.VERTICAL, false, true, false), false, true, false, false, true);
        this.getChart().getCategoryPlot().getDomainAxis().setVisible(true);
        this.getChart().getTitle().setFont(TITLE_FONT);
        this.getChart().setPadding(new RectangleInsets(5.0, 0.0, 0.0, 5.0));
        this.setMinimumDrawHeight(0);
        this.setMinimumDrawWidth(0);
        this.setMaximumDrawHeight(32768);
        this.setMaximumDrawWidth(32768);
        this.plot = this.getChart().getCategoryPlot();
        this.plot.setBackgroundPaint(new Color(245, 245, 245));
        this.plot.setRangeGridlinePaint(new Color(160, 160, 160));
        this.plot.setNoDataMessage("(No data to display)");
        this.plot.getRangeAxis().setLabelFont(LABEL_FONT);
        this.plot.setRenderer(new ChartBarRenderer(this.getBarColors()));
        CategoryAxis categoryAxis = this.plot.getDomainAxis();
        categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(1.0));
    }

    private Paint[] getBarColors() {
        Paint[] arrpaint = new Paint[11];
        int n2 = 0;
        while (n2 <= 10) {
            arrpaint[n2] = SimilarityConfidenceCellRenderer.calcColor((double)n2 / 10.0);
            ++n2;
        }
        return arrpaint;
    }

    public void fireChartChanged() {
        this.getChart().fireChartChanged();
    }

    public void setSeriesStrokeWidth(int n2, float f2) {
        CategoryItemRenderer categoryItemRenderer = this.plot.getRenderer();
        BasicStroke basicStroke = new BasicStroke(f2);
        categoryItemRenderer.setSeriesStroke(n2, basicStroke);
    }

    public void setTitle(String string) {
        this.getChart().setTitle(string);
    }

    public void setTooltipGenerator(CategoryToolTipGenerator categoryToolTipGenerator) {
        CategoryItemRenderer categoryItemRenderer = this.plot.getRenderer();
        categoryItemRenderer.setBaseToolTipGenerator(categoryToolTipGenerator);
    }
}

