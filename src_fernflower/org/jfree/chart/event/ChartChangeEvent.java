package org.jfree.chart.event;

import java.util.EventObject;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.event.ChartChangeEventType;

public class ChartChangeEvent extends EventObject {
   private ChartChangeEventType type;
   private JFreeChart chart;

   public ChartChangeEvent(Object var1) {
      this(var1, (JFreeChart)null, ChartChangeEventType.GENERAL);
   }

   public ChartChangeEvent(Object var1, JFreeChart var2) {
      this(var1, var2, ChartChangeEventType.GENERAL);
   }

   public ChartChangeEvent(Object var1, JFreeChart var2, ChartChangeEventType var3) {
      super(var1);
      this.chart = var2;
      this.type = var3;
   }

   public JFreeChart getChart() {
      return this.chart;
   }

   public void setChart(JFreeChart var1) {
      this.chart = var1;
   }

   public ChartChangeEventType getType() {
      return this.type;
   }

   public void setType(ChartChangeEventType var1) {
      this.type = var1;
   }
}
