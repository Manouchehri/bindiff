package org.jfree.chart.axis;

import java.text.DecimalFormat;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.TickUnit;
import org.jfree.chart.axis.TickUnitSource;

public class StandardTickUnitSource implements TickUnitSource {
   private static final double LOG_10_VALUE = Math.log(10.0D);

   public TickUnit getLargerTickUnit(TickUnit var1) {
      double var2 = var1.getSize();
      double var4 = Math.log(var2) / LOG_10_VALUE;
      double var6 = Math.ceil(var4);
      return new NumberTickUnit(Math.pow(10.0D, var6), new DecimalFormat("0.0E0"));
   }

   public TickUnit getCeilingTickUnit(TickUnit var1) {
      return this.getLargerTickUnit(var1);
   }

   public TickUnit getCeilingTickUnit(double var1) {
      double var3 = Math.log(var1) / LOG_10_VALUE;
      double var5 = Math.ceil(var3);
      return new NumberTickUnit(Math.pow(10.0D, var5), new DecimalFormat("0.0E0"));
   }
}
