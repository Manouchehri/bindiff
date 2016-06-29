package org.jfree.chart.renderer.xy;

import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Double;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.renderer.RendererState;

public class XYItemRendererState extends RendererState {
   public Line2D workingLine = new Double();

   public XYItemRendererState(PlotRenderingInfo var1) {
      super(var1);
   }
}
