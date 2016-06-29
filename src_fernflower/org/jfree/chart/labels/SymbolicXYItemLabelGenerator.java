package org.jfree.chart.labels;

import java.io.Serializable;
import org.jfree.chart.labels.XYItemLabelGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XisSymbolic;
import org.jfree.data.xy.YisSymbolic;
import org.jfree.util.PublicCloneable;

public class SymbolicXYItemLabelGenerator implements Serializable, Cloneable, XYItemLabelGenerator, XYToolTipGenerator, PublicCloneable {
   private static final long serialVersionUID = 3963400354475494395L;

   public String generateToolTip(XYDataset var1, int var2, int var3) {
      String var5;
      double var6;
      if(var1 instanceof YisSymbolic) {
         var5 = ((YisSymbolic)var1).getYSymbolicValue(var2, var3);
      } else {
         var6 = var1.getYValue(var2, var3);
         var5 = Double.toString(round(var6, 2));
      }

      String var4;
      if(var1 instanceof XisSymbolic) {
         var4 = ((XisSymbolic)var1).getXSymbolicValue(var2, var3);
      } else if(var1 instanceof TimeSeriesCollection) {
         RegularTimePeriod var8 = ((TimeSeriesCollection)var1).getSeries(var2).getTimePeriod(var3);
         var4 = var8.toString();
      } else {
         var6 = var1.getXValue(var2, var3);
         var4 = Double.toString(round(var6, 2));
      }

      return "X: " + var4 + ", Y: " + var5;
   }

   public String generateLabel(XYDataset var1, int var2, int var3) {
      return null;
   }

   private static double round(double var0, int var2) {
      if(var2 <= 0) {
         return Math.floor(var0 + 0.5D);
      } else {
         double var3 = Math.pow(10.0D, (double)var2);
         double var5 = Math.floor(var0 * var3 + 0.5D);
         return var5 / var3;
      }
   }

   public Object clone() {
      return super.clone();
   }

   public boolean equals(Object var1) {
      return var1 == this?true:var1 instanceof SymbolicXYItemLabelGenerator;
   }
}
