package org.jfree.chart.event;

import org.jfree.chart.event.ChartChangeEvent;

public class RendererChangeEvent extends ChartChangeEvent {
   private Object renderer;

   public RendererChangeEvent(Object var1) {
      super(var1);
      this.renderer = var1;
   }

   public Object getRenderer() {
      return this.renderer;
   }
}
