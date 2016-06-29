package org.jfree.data.statistics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.jfree.data.statistics.BoxAndWhiskerItem;
import org.jfree.data.statistics.Statistics;

public abstract class BoxAndWhiskerCalculator {
   public static BoxAndWhiskerItem calculateBoxAndWhiskerStatistics(List var0) {
      return calculateBoxAndWhiskerStatistics(var0, true);
   }

   public static BoxAndWhiskerItem calculateBoxAndWhiskerStatistics(List var0, boolean var1) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'values\' argument.");
      } else {
         Object var2;
         if(var1) {
            var2 = new ArrayList(var0.size());
            ListIterator var3 = var0.listIterator();

            while(var3.hasNext()) {
               Object var4 = var3.next();
               if(var4 instanceof Number) {
                  Number var5 = (Number)var4;
                  double var6 = var5.doubleValue();
                  if(!Double.isNaN(var6)) {
                     ((List)var2).add(var5);
                  }
               }
            }
         } else {
            var2 = var0;
         }

         Collections.sort((List)var2);
         double var34 = Statistics.calculateMean((Collection)var2, false);
         double var35 = Statistics.calculateMedian((List)var2, false);
         double var7 = calculateQ1((List)var2);
         double var9 = calculateQ3((List)var2);
         double var11 = var9 - var7;
         double var13 = var9 + var11 * 1.5D;
         double var15 = var7 - var11 * 1.5D;
         double var17 = var9 + var11 * 2.0D;
         double var19 = var7 - var11 * 2.0D;
         double var21 = Double.POSITIVE_INFINITY;
         double var23 = Double.NEGATIVE_INFINITY;
         double var25 = Double.POSITIVE_INFINITY;
         double var27 = Double.NEGATIVE_INFINITY;
         ArrayList var29 = new ArrayList();

         for(Iterator var30 = ((List)var2).iterator(); var30.hasNext(); var27 = Math.max(var27, var23)) {
            Number var31 = (Number)var30.next();
            double var32 = var31.doubleValue();
            if(var32 > var13) {
               var29.add(var31);
               if(var32 > var27 && var32 <= var17) {
                  var27 = var32;
               }
            } else if(var32 < var15) {
               var29.add(var31);
               if(var32 < var25 && var32 >= var19) {
                  var25 = var32;
               }
            } else {
               var21 = Math.min(var21, var32);
               var23 = Math.max(var23, var32);
            }

            var25 = Math.min(var25, var21);
         }

         return new BoxAndWhiskerItem(new Double(var34), new Double(var35), new Double(var7), new Double(var9), new Double(var21), new Double(var23), new Double(var25), new Double(var27), var29);
      }
   }

   public static double calculateQ1(List var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'values\' argument.");
      } else {
         double var1 = Double.NaN;
         int var3 = var0.size();
         if(var3 > 0) {
            if(var3 % 2 == 1) {
               if(var3 > 1) {
                  var1 = Statistics.calculateMedian(var0, 0, var3 / 2);
               } else {
                  var1 = Statistics.calculateMedian(var0, 0, 0);
               }
            } else {
               var1 = Statistics.calculateMedian(var0, 0, var3 / 2 - 1);
            }
         }

         return var1;
      }
   }

   public static double calculateQ3(List var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'values\' argument.");
      } else {
         double var1 = Double.NaN;
         int var3 = var0.size();
         if(var3 > 0) {
            if(var3 % 2 == 1) {
               if(var3 > 1) {
                  var1 = Statistics.calculateMedian(var0, var3 / 2, var3 - 1);
               } else {
                  var1 = Statistics.calculateMedian(var0, 0, 0);
               }
            } else {
               var1 = Statistics.calculateMedian(var0, var3 / 2, var3 - 1);
            }
         }

         return var1;
      }
   }
}
