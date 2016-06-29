package org.jfree.chart.renderer;

import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.plot.PlotRenderingInfo;

public class RendererState {
   private PlotRenderingInfo info;

   public RendererState(PlotRenderingInfo var1) {
      this.info = var1;
   }

   public PlotRenderingInfo getInfo() {
      return this.info;
   }

   public EntityCollection getEntityCollection() {
      EntityCollection var1 = null;
      if(this.info != null) {
         ChartRenderingInfo var2 = this.info.getOwner();
         if(var2 != null) {
            var1 = var2.getEntityCollection();
         }
      }

      return var1;
   }
}
