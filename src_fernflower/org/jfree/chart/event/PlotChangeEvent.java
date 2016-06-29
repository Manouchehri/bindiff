package org.jfree.chart.event;

import org.jfree.chart.event.ChartChangeEvent;
import org.jfree.chart.plot.Plot;

public class PlotChangeEvent extends ChartChangeEvent {
   private Plot plot;

   public PlotChangeEvent(Plot var1) {
      super(var1);
      this.plot = var1;
   }

   public Plot getPlot() {
      return this.plot;
   }
}
