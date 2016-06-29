package org.jfree.chart.renderer.xy;

import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYItemRendererState;

public class XYBarRenderer$XYBarRendererState extends XYItemRendererState {
   private double g2Base;
   private final XYBarRenderer this$0;

   public XYBarRenderer$XYBarRendererState(XYBarRenderer var1, PlotRenderingInfo var2) {
      super(var2);
      this.this$0 = var1;
   }

   public double getG2Base() {
      return this.g2Base;
   }

   public void setG2Base(double var1) {
      this.g2Base = var1;
   }
}
