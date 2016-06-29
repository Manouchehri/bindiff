package org.jfree.data.time;

import org.jfree.data.time.DynamicTimeSeriesCollection;

public class DynamicTimeSeriesCollection$ValueSequence {
   float[] dataPoints;
   private final DynamicTimeSeriesCollection this$0;

   public DynamicTimeSeriesCollection$ValueSequence(DynamicTimeSeriesCollection var1) {
      this(var1, DynamicTimeSeriesCollection.access$000(var1));
   }

   public DynamicTimeSeriesCollection$ValueSequence(DynamicTimeSeriesCollection var1, int var2) {
      this.this$0 = var1;
      this.dataPoints = new float[var2];

      for(int var3 = 0; var3 < var2; ++var3) {
         this.dataPoints[var3] = 0.0F;
      }

   }

   public void enterData(int var1, float var2) {
      this.dataPoints[var1] = var2;
   }

   public float getData(int var1) {
      return this.dataPoints[var1];
   }
}
