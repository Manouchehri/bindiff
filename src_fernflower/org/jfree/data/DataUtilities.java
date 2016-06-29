package org.jfree.data;

import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;

public abstract class DataUtilities {
   public static double calculateColumnTotal(Values2D var0, int var1) {
      double var2 = 0.0D;
      int var4 = var0.getRowCount();

      for(int var5 = 0; var5 < var4; ++var5) {
         Number var6 = var0.getValue(var5, var1);
         if(var6 != null) {
            var2 += var6.doubleValue();
         }
      }

      return var2;
   }

   public static double calculateRowTotal(Values2D var0, int var1) {
      double var2 = 0.0D;
      int var4 = var0.getColumnCount();

      for(int var5 = 0; var5 < var4; ++var5) {
         Number var6 = var0.getValue(var1, var5);
         if(var6 != null) {
            var2 += var6.doubleValue();
         }
      }

      return var2;
   }

   public static Number[] createNumberArray(double[] var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'data\' argument.");
      } else {
         Number[] var1 = new Number[var0.length];

         for(int var2 = 0; var2 < var0.length; ++var2) {
            var1[var2] = new Double(var0[var2]);
         }

         return var1;
      }
   }

   public static Number[][] createNumberArray2D(double[][] var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'data\' argument.");
      } else {
         int var1 = var0.length;
         Number[][] var2 = new Number[var1][];

         for(int var3 = 0; var3 < var1; ++var3) {
            var2[var3] = createNumberArray(var0[var3]);
         }

         return var2;
      }
   }

   public static KeyedValues getCumulativePercentages(KeyedValues var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'data\' argument.");
      } else {
         DefaultKeyedValues var1 = new DefaultKeyedValues();
         double var2 = 0.0D;

         for(int var4 = 0; var4 < var0.getItemCount(); ++var4) {
            Number var5 = var0.getValue(var4);
            if(var5 != null) {
               var2 += var5.doubleValue();
            }
         }

         double var8 = 0.0D;

         for(int var6 = 0; var6 < var0.getItemCount(); ++var6) {
            Number var7 = var0.getValue(var6);
            if(var7 != null) {
               var8 += var7.doubleValue();
            }

            var1.addValue(var0.getKey(var6), new Double(var8 / var2));
         }

         return var1;
      }
   }
}
