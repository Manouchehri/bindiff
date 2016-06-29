package org.jfree.chart.labels;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import org.jfree.chart.labels.XYItemLabelGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.data.xy.OHLCDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.util.PublicCloneable;

public class HighLowItemLabelGenerator implements Serializable, Cloneable, XYItemLabelGenerator, XYToolTipGenerator, PublicCloneable {
   private static final long serialVersionUID = 5617111754832211830L;
   private DateFormat dateFormatter;
   private NumberFormat numberFormatter;

   public HighLowItemLabelGenerator() {
      this(DateFormat.getInstance(), NumberFormat.getInstance());
   }

   public HighLowItemLabelGenerator(DateFormat var1, NumberFormat var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'dateFormatter\' argument.");
      } else if(var2 == null) {
         throw new IllegalArgumentException("Null \'numberFormatter\' argument.");
      } else {
         this.dateFormatter = var1;
         this.numberFormatter = var2;
      }
   }

   public String generateToolTip(XYDataset var1, int var2, int var3) {
      String var4 = null;
      if(var1 instanceof OHLCDataset) {
         OHLCDataset var5 = (OHLCDataset)var1;
         Number var6 = var5.getHigh(var2, var3);
         Number var7 = var5.getLow(var2, var3);
         Number var8 = var5.getOpen(var2, var3);
         Number var9 = var5.getClose(var2, var3);
         Number var10 = var5.getX(var2, var3);
         var4 = var5.getSeriesKey(var2).toString();
         if(var10 != null) {
            Date var11 = new Date(var10.longValue());
            var4 = var4 + "--> Date=" + this.dateFormatter.format(var11);
            if(var6 != null) {
               var4 = var4 + " High=" + this.numberFormatter.format(var6.doubleValue());
            }

            if(var7 != null) {
               var4 = var4 + " Low=" + this.numberFormatter.format(var7.doubleValue());
            }

            if(var8 != null) {
               var4 = var4 + " Open=" + this.numberFormatter.format(var8.doubleValue());
            }

            if(var9 != null) {
               var4 = var4 + " Close=" + this.numberFormatter.format(var9.doubleValue());
            }
         }
      }

      return var4;
   }

   public String generateLabel(XYDataset var1, int var2, int var3) {
      return null;
   }

   public Object clone() {
      HighLowItemLabelGenerator var1 = (HighLowItemLabelGenerator)super.clone();
      if(this.dateFormatter != null) {
         var1.dateFormatter = (DateFormat)this.dateFormatter.clone();
      }

      if(this.numberFormatter != null) {
         var1.numberFormatter = (NumberFormat)this.numberFormatter.clone();
      }

      return var1;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof HighLowItemLabelGenerator)) {
         return false;
      } else {
         HighLowItemLabelGenerator var2 = (HighLowItemLabelGenerator)var1;
         return !this.dateFormatter.equals(var2.dateFormatter)?false:this.numberFormatter.equals(var2.numberFormatter);
      }
   }
}
