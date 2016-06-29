package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import org.jfree.data.category.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.*;
import org.jfree.ui.*;
import org.jfree.chart.renderer.category.*;
import org.jfree.chart.axis.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.*;
import java.awt.*;
import org.jfree.chart.labels.*;

public class BarChart2dPanel extends ChartPanel
{
    private static final Font TITLE_FONT;
    private static final Font LABEL_FONT;
    private final CategoryPlot plot;
    
    public BarChart2dPanel(final String s, final CategoryDataset categoryDataset) {
        super(ChartFactory.createBarChart3D(s, "", "Matched Functions", categoryDataset, PlotOrientation.VERTICAL, false, true, false), false, true, false, false, true);
        this.getChart().getCategoryPlot().getDomainAxis().setVisible(true);
        this.getChart().getTitle().setFont(BarChart2dPanel.TITLE_FONT);
        this.getChart().setPadding(new RectangleInsets(5.0, 0.0, 0.0, 5.0));
        this.setMinimumDrawHeight(0);
        this.setMinimumDrawWidth(0);
        this.setMaximumDrawHeight(32768);
        this.setMaximumDrawWidth(32768);
        (this.plot = this.getChart().getCategoryPlot()).setBackgroundPaint(new Color(245, 245, 245));
        this.plot.setRangeGridlinePaint(new Color(160, 160, 160));
        this.plot.setNoDataMessage("(No data to display)");
        this.plot.getRangeAxis().setLabelFont(BarChart2dPanel.LABEL_FONT);
        this.plot.setRenderer(new ChartBarRenderer(this.getBarColors()));
        this.plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(1.0));
    }
    
    private Paint[] getBarColors() {
        final Paint[] array = new Paint[11];
        for (int i = 0; i <= 10; ++i) {
            array[i] = SimilarityConfidenceCellRenderer.calcColor(i / 10.0);
        }
        return array;
    }
    
    public void fireChartChanged() {
        this.getChart().fireChartChanged();
    }
    
    public void setSeriesStrokeWidth(final int n, final float n2) {
        this.plot.getRenderer().setSeriesStroke(n, new BasicStroke(n2));
    }
    
    public void setTitle(final String title) {
        this.getChart().setTitle(title);
    }
    
    public void setTooltipGenerator(final CategoryToolTipGenerator baseToolTipGenerator) {
        this.plot.getRenderer().setBaseToolTipGenerator(baseToolTipGenerator);
    }
    
    static {
        TITLE_FONT = new Font("Arial", 0, 16);
        LABEL_FONT = new Font("Arial", 0, 12);
    }
}
