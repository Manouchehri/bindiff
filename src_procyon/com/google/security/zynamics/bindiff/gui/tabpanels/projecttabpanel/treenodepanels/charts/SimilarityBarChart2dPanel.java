package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import javax.swing.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import org.jfree.data.category.*;
import java.awt.*;
import org.jfree.chart.labels.*;
import org.jfree.chart.*;
import java.util.*;

public class SimilarityBarChart2dPanel extends JPanel
{
    private static final int SIMILARITY = 0;
    private static final String SERIES = "Similarity";
    private final DefaultCategoryDataset dataset;
    private final BarChart2dPanel barChart;
    private final double similarity;
    
    public SimilarityBarChart2dPanel(final DiffMetaData diffMetaData) {
        super(new BorderLayout());
        this.dataset = new DefaultCategoryDataset();
        this.similarity = diffMetaData.getTotalSimilarity();
        this.barChart = new BarChart2dPanel(this.getTitle(), this.dataset);
        this.init();
        this.updateDataset(diffMetaData.getSimilarityIntervalCounts());
        this.setPreferredSize(new Dimension(200, 200));
        this.add(this.barChart, "Center");
    }
    
    private String getTitle() {
        return (this.similarity == -1.0) ? "Similarity" : String.format("%s %.2f", "Similarity", this.similarity);
    }
    
    private void init() {
        this.barChart.setSeriesStrokeWidth(0, 2.0f);
        this.barChart.setTooltipGenerator(new SimilarityBarChart2dPanel$CustomTooltipGenerator(this));
    }
    
    private void updateDataset(final int[] array) {
        for (int i = 0; i <= 10; ++i) {
            this.dataset.addValue(array[i], "Similarity", new Double(i / 10.0));
        }
    }
    
    public JFreeChart getChart() {
        return this.barChart.getChart();
    }
    
    public void updateDataset(final Vector vector) {
        if (vector.size() == 0) {
            return;
        }
        final int[] array = new int[11];
        for (final double doubleValue : vector) {
            final int[] array2 = array;
            final int n = (int)Math.floor(doubleValue * 10.0);
            ++array2[n];
        }
        this.dataset.clear();
        this.updateDataset(array);
        this.barChart.setTitle(this.getTitle());
        this.barChart.fireChartChanged();
    }
}
