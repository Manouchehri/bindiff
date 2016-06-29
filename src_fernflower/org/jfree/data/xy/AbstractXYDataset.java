package org.jfree.data.xy;

import org.jfree.data.DomainOrder;
import org.jfree.data.general.AbstractSeriesDataset;
import org.jfree.data.xy.XYDataset;

public abstract class AbstractXYDataset extends AbstractSeriesDataset implements XYDataset {
   public DomainOrder getDomainOrder() {
      return DomainOrder.NONE;
   }

   public double getXValue(int var1, int var2) {
      double var3 = Double.NaN;
      Number var5 = this.getX(var1, var2);
      if(var5 != null) {
         var3 = var5.doubleValue();
      }

      return var3;
   }

   public double getYValue(int var1, int var2) {
      double var3 = Double.NaN;
      Number var5 = this.getY(var1, var2);
      if(var5 != null) {
         var3 = var5.doubleValue();
      }

      return var3;
   }
}
