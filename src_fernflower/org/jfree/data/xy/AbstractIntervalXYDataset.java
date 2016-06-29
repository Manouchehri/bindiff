package org.jfree.data.xy;

import org.jfree.data.xy.AbstractXYDataset;
import org.jfree.data.xy.IntervalXYDataset;

public abstract class AbstractIntervalXYDataset extends AbstractXYDataset implements IntervalXYDataset {
   public double getStartXValue(int var1, int var2) {
      double var3 = Double.NaN;
      Number var5 = this.getStartX(var1, var2);
      if(var5 != null) {
         var3 = var5.doubleValue();
      }

      return var3;
   }

   public double getEndXValue(int var1, int var2) {
      double var3 = Double.NaN;
      Number var5 = this.getEndX(var1, var2);
      if(var5 != null) {
         var3 = var5.doubleValue();
      }

      return var3;
   }

   public double getStartYValue(int var1, int var2) {
      double var3 = Double.NaN;
      Number var5 = this.getStartY(var1, var2);
      if(var5 != null) {
         var3 = var5.doubleValue();
      }

      return var3;
   }

   public double getEndYValue(int var1, int var2) {
      double var3 = Double.NaN;
      Number var5 = this.getEndY(var1, var2);
      if(var5 != null) {
         var3 = var5.doubleValue();
      }

      return var3;
   }
}
