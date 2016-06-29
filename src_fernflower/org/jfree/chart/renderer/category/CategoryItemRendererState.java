package org.jfree.chart.renderer.category;

import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.renderer.RendererState;

public class CategoryItemRendererState extends RendererState {
   private double barWidth = 0.0D;
   private double seriesRunningTotal = 0.0D;

   public CategoryItemRendererState(PlotRenderingInfo var1) {
      super(var1);
   }

   public double getBarWidth() {
      return this.barWidth;
   }

   public void setBarWidth(double var1) {
      this.barWidth = var1;
   }

   public double getSeriesRunningTotal() {
      return this.seriesRunningTotal;
   }

   void setSeriesRunningTotal(double var1) {
      this.seriesRunningTotal = var1;
   }
}
