/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.BarChart2dPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.SimilarityBarChart2dPanel$CustomTooltipGenerator;
import com.google.security.zynamics.bindiff.project.matches.DiffMetaData;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class SimilarityBarChart2dPanel
extends JPanel {
    private static final int SIMILARITY = 0;
    private static final String SERIES = "Similarity";
    private final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    private final BarChart2dPanel barChart;
    private final double similarity;

    public SimilarityBarChart2dPanel(DiffMetaData diffMetaData) {
        super(new BorderLayout());
        this.similarity = diffMetaData.getTotalSimilarity();
        this.barChart = new BarChart2dPanel(this.getTitle(), this.dataset);
        this.init();
        this.updateDataset(diffMetaData.getSimilarityIntervalCounts());
        this.setPreferredSize(new Dimension(200, 200));
        this.add((Component)this.barChart, "Center");
    }

    private String getTitle() {
        if (this.similarity == -1.0) {
            return "Similarity";
        }
        String string = String.format("%s %.2f", "Similarity", this.similarity);
        return string;
    }

    private void init() {
        this.barChart.setSeriesStrokeWidth(0, 2.0f);
        this.barChart.setTooltipGenerator(new SimilarityBarChart2dPanel$CustomTooltipGenerator(this));
    }

    private void updateDataset(int[] arrn) {
        int n2 = 0;
        while (n2 <= 10) {
            this.dataset.addValue(arrn[n2], (Comparable)((Object)"Similarity"), (Comparable)new Double((double)n2 / 10.0));
            ++n2;
        }
    }

    public JFreeChart getChart() {
        return this.barChart.getChart();
    }

    public void updateDataset(Vector vector) {
        if (vector.size() == 0) {
            return;
        }
        int[] arrn = new int[11];
        Iterator iterator = vector.iterator();
        do {
            if (!iterator.hasNext()) {
                this.dataset.clear();
                this.updateDataset(arrn);
                this.barChart.setTitle(this.getTitle());
                this.barChart.fireChartChanged();
                return;
            }
            double d2 = (Double)iterator.next();
            int[] arrn2 = arrn;
            int n2 = (int)Math.floor(d2 * 10.0);
            arrn2[n2] = arrn2[n2] + 1;
        } while (true);
    }
}

