package org.jfree.chart.labels;

import java.io.Serializable;
import java.text.MessageFormat;
import java.text.NumberFormat;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.general.PieDataset;

public class AbstractPieItemLabelGenerator implements Serializable {
   private static final long serialVersionUID = 7347703325267846275L;
   private String labelFormat;
   private NumberFormat numberFormat;
   private NumberFormat percentFormat;

   protected AbstractPieItemLabelGenerator(String var1, NumberFormat var2, NumberFormat var3) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'labelFormat\' argument.");
      } else if(var2 == null) {
         throw new IllegalArgumentException("Null \'numberFormat\' argument.");
      } else if(var3 == null) {
         throw new IllegalArgumentException("Null \'percentFormat\' argument.");
      } else {
         this.labelFormat = var1;
         this.numberFormat = var2;
         this.percentFormat = var3;
      }
   }

   public String getLabelFormat() {
      return this.labelFormat;
   }

   public NumberFormat getNumberFormat() {
      return this.numberFormat;
   }

   public NumberFormat getPercentFormat() {
      return this.percentFormat;
   }

   protected Object[] createItemArray(PieDataset var1, Comparable var2) {
      Object[] var3 = new Object[4];
      double var4 = DatasetUtilities.calculatePieDatasetTotal(var1);
      var3[0] = var2.toString();
      Number var6 = var1.getValue(var2);
      if(var6 != null) {
         var3[1] = this.numberFormat.format(var6);
      } else {
         var3[1] = "null";
      }

      double var7 = 0.0D;
      if(var6 != null) {
         double var9 = var6.doubleValue();
         if(var9 > 0.0D) {
            var7 = var9 / var4;
         }
      }

      var3[2] = this.percentFormat.format(var7);
      var3[3] = this.numberFormat.format(var4);
      return var3;
   }

   protected String generateSectionLabel(PieDataset var1, Comparable var2) {
      String var3 = null;
      if(var1 != null) {
         Object[] var4 = this.createItemArray(var1, var2);
         var3 = MessageFormat.format(this.labelFormat, var4);
      }

      return var3;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof AbstractPieItemLabelGenerator)) {
         return false;
      } else {
         AbstractPieItemLabelGenerator var2 = (AbstractPieItemLabelGenerator)var1;
         return !this.labelFormat.equals(var2.labelFormat)?false:(!this.numberFormat.equals(var2.numberFormat)?false:this.percentFormat.equals(var2.percentFormat));
      }
   }

   public Object clone() {
      AbstractPieItemLabelGenerator var1 = (AbstractPieItemLabelGenerator)super.clone();
      if(this.numberFormat != null) {
         var1.numberFormat = (NumberFormat)this.numberFormat.clone();
      }

      if(this.percentFormat != null) {
         var1.percentFormat = (NumberFormat)this.percentFormat.clone();
      }

      return var1;
   }
}
