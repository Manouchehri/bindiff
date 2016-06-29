package org.jfree.chart.renderer.xy;

import java.awt.Polygon;
import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Double;
import java.util.Stack;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.renderer.xy.XYItemRendererState;

class StackedXYAreaRenderer$StackedXYAreaRendererState extends XYItemRendererState {
   private Polygon seriesArea = null;
   private Line2D line = new Double();
   private Stack lastSeriesPoints = new Stack();
   private Stack currentSeriesPoints = new Stack();

   public StackedXYAreaRenderer$StackedXYAreaRendererState(PlotRenderingInfo var1) {
      super(var1);
   }

   public Polygon getSeriesArea() {
      return this.seriesArea;
   }

   public void setSeriesArea(Polygon var1) {
      this.seriesArea = var1;
   }

   public Line2D getLine() {
      return this.line;
   }

   public Stack getCurrentSeriesPoints() {
      return this.currentSeriesPoints;
   }

   public void setCurrentSeriesPoints(Stack var1) {
      this.currentSeriesPoints = var1;
   }

   public Stack getLastSeriesPoints() {
      return this.lastSeriesPoints;
   }

   public void setLastSeriesPoints(Stack var1) {
      this.lastSeriesPoints = var1;
   }
}
