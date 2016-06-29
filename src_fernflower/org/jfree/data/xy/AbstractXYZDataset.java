package org.jfree.data.xy;

import org.jfree.data.xy.AbstractXYDataset;
import org.jfree.data.xy.XYZDataset;

public abstract class AbstractXYZDataset extends AbstractXYDataset implements XYZDataset {
   public double getZValue(int var1, int var2) {
      double var3 = Double.NaN;
      Number var5 = this.getZ(var1, var2);
      if(var5 != null) {
         var3 = var5.doubleValue();
      }

      return var3;
   }
}
