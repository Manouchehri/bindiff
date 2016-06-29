package org.jfree.chart.renderer.xy;

import java.awt.geom.GeneralPath;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.renderer.xy.XYItemRendererState;

public class StandardXYItemRenderer$State extends XYItemRendererState {
   public GeneralPath seriesPath;
   private int seriesIndex;
   private boolean lastPointGood;

   public StandardXYItemRenderer$State(PlotRenderingInfo var1) {
      super(var1);
   }

   public boolean isLastPointGood() {
      return this.lastPointGood;
   }

   public void setLastPointGood(boolean var1) {
      this.lastPointGood = var1;
   }

   public int getSeriesIndex() {
      return this.seriesIndex;
   }

   public void setSeriesIndex(int var1) {
      this.seriesIndex = var1;
   }

   static int access$002(StandardXYItemRenderer$State var0, int var1) {
      return var0.seriesIndex = var1;
   }

   static boolean access$102(StandardXYItemRenderer$State var0, boolean var1) {
      return var0.lastPointGood = var1;
   }

   static int access$000(StandardXYItemRenderer$State var0) {
      return var0.seriesIndex;
   }
}
