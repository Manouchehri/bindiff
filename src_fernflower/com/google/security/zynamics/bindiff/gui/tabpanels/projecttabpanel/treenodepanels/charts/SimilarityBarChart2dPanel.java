package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.BarChart2dPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.SimilarityBarChart2dPanel$CustomTooltipGenerator;
import com.google.security.zynamics.bindiff.project.matches.DiffMetaData;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

public class SimilarityBarChart2dPanel extends JPanel {
   private static final int SIMILARITY = 0;
   private static final String SERIES = "Similarity";
   private final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
   private final BarChart2dPanel barChart;
   private final double similarity;

   public SimilarityBarChart2dPanel(DiffMetaData var1) {
      super(new BorderLayout());
      this.similarity = var1.getTotalSimilarity();
      this.barChart = new BarChart2dPanel(this.getTitle(), this.dataset);
      this.init();
      this.updateDataset(var1.getSimilarityIntervalCounts());
      this.setPreferredSize(new Dimension(200, 200));
      this.add(this.barChart, "Center");
   }

   private String getTitle() {
      return this.similarity == -1.0D?"Similarity":String.format("%s %.2f", new Object[]{"Similarity", Double.valueOf(this.similarity)});
   }

   private void init() {
      this.barChart.setSeriesStrokeWidth(0, 2.0F);
      this.barChart.setTooltipGenerator(new SimilarityBarChart2dPanel$CustomTooltipGenerator(this));
   }

   private void updateDataset(int[] var1) {
      for(int var2 = 0; var2 <= 10; ++var2) {
         this.dataset.addValue((double)var1[var2], "Similarity", new Double((double)var2 / 10.0D));
      }

   }

   public JFreeChart getChart() {
      return this.barChart.getChart();
   }

   public void updateDataset(Vector var1) {
      if(var1.size() != 0) {
         int[] var2 = new int[11];

         double var4;
         for(Iterator var3 = var1.iterator(); var3.hasNext(); ++var2[(int)Math.floor(var4 * 10.0D)]) {
            var4 = ((Double)var3.next()).doubleValue();
         }

         this.dataset.clear();
         this.updateDataset(var2);
         this.barChart.setTitle(this.getTitle());
         this.barChart.fireChartChanged();
      }
   }
}
