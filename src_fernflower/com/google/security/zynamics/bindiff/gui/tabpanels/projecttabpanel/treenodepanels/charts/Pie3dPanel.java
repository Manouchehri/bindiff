package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.charts;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.PieToolTipGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.Rotation;

public class Pie3dPanel extends ChartPanel {
   private static final Font TITLE_FONT = new Font("Arial", 0, 16);
   private static final Font LABEL_FONT = new Font("Arial", 0, 10);
   private final PiePlot3D section;

   public Pie3dPanel(String var1, DefaultPieDataset var2, PieSectionLabelGenerator var3) {
      super(ChartFactory.createPieChart3D(var1, var2, false, true, false), false, true, false, false, true);
      this.getChart().setBorderPaint(Color.WHITE);
      this.getChart().getTitle().setFont(TITLE_FONT);
      this.getChart().setPadding(new RectangleInsets(5.0D, 0.0D, 0.0D, 0.0D));
      this.setMinimumDrawHeight(0);
      this.setMinimumDrawWidth(0);
      this.setMaximumDrawHeight('耀');
      this.setMaximumDrawWidth('耀');
      this.section = (PiePlot3D)this.getChart().getPlot();
      this.section.setLabelFont(LABEL_FONT);
      this.section.setBackgroundPaint(Color.WHITE);
      this.section.setOutlinePaint(Color.WHITE);
      this.section.setBaseSectionOutlinePaint(Color.WHITE);
      this.section.setStartAngle(0.0D);
      this.section.setDirection(Rotation.CLOCKWISE);
      this.section.setForegroundAlpha(0.5F);
      this.section.setNoDataMessage("(No data to display)");
      this.section.setCircular(true);
      this.section.setLabelGenerator(var3);
      this.setPreferredSize(new Dimension(240, 200));
   }

   public void fireChartChanged() {
      this.getChart().fireChartChanged();
   }

   public void setSectionColor(String var1, Color var2) {
      this.section.setSectionPaint(var1, var2);
   }

   public void setTitle(String var1) {
      this.getChart().setTitle(var1);
   }

   public void setTooltipGenerator(PieToolTipGenerator var1) {
      this.section.setToolTipGenerator(var1);
   }
}
