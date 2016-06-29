package org.jfree.chart.event;

import org.jfree.chart.event.ChartChangeEvent;
import org.jfree.chart.plot.Marker;

public class MarkerChangeEvent extends ChartChangeEvent {
   private Marker marker;

   public MarkerChangeEvent(Marker var1) {
      super(var1);
      this.marker = var1;
   }

   public Marker getMarker() {
      return this.marker;
   }
}
