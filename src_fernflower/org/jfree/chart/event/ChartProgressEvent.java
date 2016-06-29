package org.jfree.chart.event;

import java.util.EventObject;
import org.jfree.chart.JFreeChart;

public class ChartProgressEvent extends EventObject {
   public static final int DRAWING_STARTED = 1;
   public static final int DRAWING_FINISHED = 2;
   private int type;
   private int percent;
   private JFreeChart chart;

   public ChartProgressEvent(Object var1, JFreeChart var2, int var3, int var4) {
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

   public int getType() {
      return this.type;
   }

   public void setType(int var1) {
      this.type = var1;
   }

   public int getPercent() {
      return this.percent;
   }

   public void setPercent(int var1) {
      this.percent = var1;
   }
}
