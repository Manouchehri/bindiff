package org.jfree.chart.renderer.xy;

import java.awt.Polygon;
import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Double;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.renderer.xy.XYItemRendererState;

class XYAreaRenderer$XYAreaRendererState extends XYItemRendererState {
   public Polygon area = new Polygon();
   public Line2D line = new Double();

   public XYAreaRenderer$XYAreaRendererState(PlotRenderingInfo var1) {
      super(var1);
   }
}
