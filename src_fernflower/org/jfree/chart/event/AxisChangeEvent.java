package org.jfree.chart.event;

import org.jfree.chart.axis.Axis;
import org.jfree.chart.event.ChartChangeEvent;

public class AxisChangeEvent extends ChartChangeEvent {
   private Axis axis;

   public AxisChangeEvent(Axis var1) {
      super(var1);
      this.axis = var1;
   }

   public Axis getAxis() {
      return this.axis;
   }
}
