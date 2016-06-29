package org.jfree.chart.renderer.xy;

import java.awt.geom.GeneralPath;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.renderer.xy.XYItemRendererState;

public class XYLineAndShapeRenderer$State extends XYItemRendererState {
   public GeneralPath seriesPath;
   private boolean lastPointGood;

   public XYLineAndShapeRenderer$State(PlotRenderingInfo var1) {
      super(var1);
   }

   public boolean isLastPointGood() {
      return this.lastPointGood;
   }

   public void setLastPointGood(boolean var1) {
      this.lastPointGood = var1;
   }

   static boolean access$002(XYLineAndShapeRenderer$State var0, boolean var1) {
      return var0.lastPointGood = var1;
   }
}
