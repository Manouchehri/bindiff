package org.jfree.data.time;

import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.TimeSeriesDataItem;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class MovingAverage {
   public static TimeSeriesCollection createMovingAverage(TimeSeriesCollection var0, String var1, int var2, int var3) {
      if(var0 == null) {
         throw new IllegalArgumentException("MovingAverage.createMovingAverage() : null source.");
      } else if(var2 < 1) {
         throw new IllegalArgumentException("periodCount must be greater than or equal to 1.");
      } else {
         TimeSeriesCollection var4 = new TimeSeriesCollection();

         for(int var5 = 0; var5 < var0.getSeriesCount(); ++var5) {
            TimeSeries var6 = var0.getSeries(var5);
            TimeSeries var7 = createMovingAverage(var6, var6.getKey() + var1, var2, var3);
            var4.addSeries(var7);
         }

         return var4;
      }
   }

   public static TimeSeries createMovingAverage(TimeSeries var0, String var1, int var2, int var3) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null source.");
      } else if(var2 < 1) {
         throw new IllegalArgumentException("periodCount must be greater than or equal to 1.");
      } else {
         TimeSeries var4 = new TimeSeries(var1, var0.getTimePeriodClass());
         if(var0.getItemCount() > 0) {
            long var5 = var0.getDataItem(0).getPeriod().getSerialIndex() + (long)var3;

            for(int var7 = var0.getItemCount() - 1; var7 >= 0; --var7) {
               TimeSeriesDataItem var8 = var0.getDataItem(var7);
               RegularTimePeriod var9 = var8.getPeriod();
               long var10 = var9.getSerialIndex();
               if(var10 >= var5) {
                  int var12 = 0;
                  double var13 = 0.0D;
                  long var15 = var9.getSerialIndex() - (long)var2;
                  int var17 = 0;

                  for(boolean var18 = false; var17 < var2 && !var18; ++var17) {
                     if(var7 - var17 >= 0) {
                        TimeSeriesDataItem var19 = var0.getDataItem(var7 - var17);
                        RegularTimePeriod var20 = var19.getPeriod();
                        Number var21 = var19.getValue();
                        long var22 = var20.getSerialIndex();
                        if(var22 > var15) {
                           if(var21 != null) {
                              var13 += var21.doubleValue();
                              ++var12;
                           }
                        } else {
                           var18 = true;
                        }
                     }
                  }

                  if(var12 > 0) {
                     var4.add(var9, var13 / (double)var12);
                  } else {
                     var4.add(var9, (Number)null);
                  }
               }
            }
         }

         return var4;
      }
   }

   public static TimeSeries createPointMovingAverage(TimeSeries var0, String var1, int var2) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'source\'.");
      } else if(var2 < 2) {
         throw new IllegalArgumentException("periodCount must be greater than or equal to 2.");
      } else {
         TimeSeries var3 = new TimeSeries(var1, var0.getTimePeriodClass());
         double var4 = 0.0D;

         for(int var6 = 0; var6 < var0.getItemCount(); ++var6) {
            TimeSeriesDataItem var7 = var0.getDataItem(var6);
            RegularTimePeriod var8 = var7.getPeriod();
            var4 += var7.getValue().doubleValue();
            if(var6 > var2 - 1) {
               TimeSeriesDataItem var9 = var0.getDataItem(var6 - var2);
               var4 -= var9.getValue().doubleValue();
               var3.add(var8, var4 / (double)var2);
            } else if(var6 == var2 - 1) {
               var3.add(var8, var4 / (double)var2);
            }
         }

         return var3;
      }
   }

   public static XYDataset createMovingAverage(XYDataset var0, String var1, long var2, long var4) {
      return createMovingAverage(var0, var1, (double)var2, (double)var4);
   }

   public static XYDataset createMovingAverage(XYDataset var0, String var1, double var2, double var4) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null source (XYDataset).");
      } else {
         XYSeriesCollection var6 = new XYSeriesCollection();

         for(int var7 = 0; var7 < var0.getSeriesCount(); ++var7) {
            XYSeries var8 = createMovingAverage(var0, var7, var0.getSeriesKey(var7) + var1, var2, var4);
            var6.addSeries(var8);
         }

         return var6;
      }
   }

   public static XYSeries createMovingAverage(XYDataset var0, int var1, String var2, double var3, double var5) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null source (XYDataset).");
      } else if(var3 < Double.MIN_VALUE) {
         throw new IllegalArgumentException("period must be positive.");
      } else if(var5 < 0.0D) {
         throw new IllegalArgumentException("skip must be >= 0.0.");
      } else {
         XYSeries var7 = new XYSeries(var2);
         if(var0.getItemCount(var1) > 0) {
            double var8 = var0.getXValue(var1, 0) + var5;

            for(int var10 = var0.getItemCount(var1) - 1; var10 >= 0; --var10) {
               double var11 = var0.getXValue(var1, var10);
               if(var11 >= var8) {
                  int var13 = 0;
                  double var14 = 0.0D;
                  double var16 = var11 - var3;
                  int var18 = 0;

                  for(boolean var19 = false; !var19; ++var18) {
                     if(var10 - var18 >= 0) {
                        double var20 = var0.getXValue(var1, var10 - var18);
                        Number var22 = var0.getY(var1, var10 - var18);
                        if(var20 > var16) {
                           if(var22 != null) {
                              var14 += var22.doubleValue();
                              ++var13;
                           }
                        } else {
                           var19 = true;
                        }
                     } else {
                        var19 = true;
                     }
                  }

                  if(var13 > 0) {
                     var7.add(var11, var14 / (double)var13);
                  } else {
                     var7.add(var11, (Number)null);
                  }
               }
            }
         }

         return var7;
      }
   }
}
