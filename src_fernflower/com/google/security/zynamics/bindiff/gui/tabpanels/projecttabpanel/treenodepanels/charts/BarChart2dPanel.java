package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts.ChartBarRenderer;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers.SimilarityConfidenceCellRenderer;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.ui.RectangleInsets;

public class BarChart2dPanel extends ChartPanel {
   private static final Font TITLE_FONT = new Font("Arial", 0, 16);
   private static final Font LABEL_FONT = new Font("Arial", 0, 12);
   private final CategoryPlot plot;

   public BarChart2dPanel(String var1, CategoryDataset var2) {
      super(ChartFactory.createBarChart3D(var1, "", "Matched Functions", var2, PlotOrientation.VERTICAL, false, true, false), false, true, false, false, true);
      this.getChart().getCategoryPlot().getDomainAxis().setVisible(true);
      this.getChart().getTitle().setFont(TITLE_FONT);
      this.getChart().setPadding(new RectangleInsets(5.0D, 0.0D, 0.0D, 5.0D));
      this.setMinimumDrawHeight(0);
      this.setMinimumDrawWidth(0);
      this.setMaximumDrawHeight('耀');
      this.setMaximumDrawWidth('耀');
      this.plot = this.getChart().getCategoryPlot();
      this.plot.setBackgroundPaint(new Color(245, 245, 245));
      this.plot.setRangeGridlinePaint(new Color(160, 160, 160));
      this.plot.setNoDataMessage("(No data to display)");
      this.plot.getRangeAxis().setLabelFont(LABEL_FONT);
      this.plot.setRenderer(new ChartBarRenderer(this.getBarColors()));
      CategoryAxis var3 = this.plot.getDomainAxis();
      var3.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(1.0D));
   }

   private Paint[] getBarColors() {
      Paint[] var1 = new Paint[11];

      for(int var2 = 0; var2 <= 10; ++var2) {
         var1[var2] = SimilarityConfidenceCellRenderer.calcColor((double)var2 / 10.0D);
      }

      return var1;
   }

   public void fireChartChanged() {
      this.getChart().fireChartChanged();
   }

   public void setSeriesStrokeWidth(int var1, float var2) {
      CategoryItemRenderer var3 = this.plot.getRenderer();
      BasicStroke var4 = new BasicStroke(var2);
      var3.setSeriesStroke(var1, var4);
   }

   public void setTitle(String var1) {
      this.getChart().setTitle(var1);
   }

   public void setTooltipGenerator(CategoryToolTipGenerator var1) {
      CategoryItemRenderer var2 = this.plot.getRenderer();
      var2.setBaseToolTipGenerator(var1);
   }
}
