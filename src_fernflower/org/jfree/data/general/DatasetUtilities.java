package org.jfree.data.general;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jfree.data.DomainInfo;
import org.jfree.data.KeyToGroupMap;
import org.jfree.data.KeyedValues;
import org.jfree.data.Range;
import org.jfree.data.RangeInfo;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.function.Function2D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.OHLCDataset;
import org.jfree.data.xy.TableXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.util.ArrayUtilities;

public final class DatasetUtilities {
   public static double calculatePieDatasetTotal(PieDataset var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'dataset\' argument.");
      } else {
         List var1 = var0.getKeys();
         double var2 = 0.0D;
         Iterator var4 = var1.iterator();

         while(var4.hasNext()) {
            Comparable var5 = (Comparable)var4.next();
            if(var5 != null) {
               Number var6 = var0.getValue(var5);
               double var7 = 0.0D;
               if(var6 != null) {
                  var7 = var6.doubleValue();
               }

               if(var7 > 0.0D) {
                  var2 += var7;
               }
            }
         }

         return var2;
      }
   }

   public static PieDataset createPieDatasetForRow(CategoryDataset var0, Comparable var1) {
      int var2 = var0.getRowIndex(var1);
      return createPieDatasetForRow(var0, var2);
   }

   public static PieDataset createPieDatasetForRow(CategoryDataset var0, int var1) {
      DefaultPieDataset var2 = new DefaultPieDataset();
      int var3 = var0.getColumnCount();

      for(int var4 = 0; var4 < var3; ++var4) {
         Comparable var5 = var0.getColumnKey(var4);
         var2.setValue(var5, var0.getValue(var1, var4));
      }

      return var2;
   }

   public static PieDataset createPieDatasetForColumn(CategoryDataset var0, Comparable var1) {
      int var2 = var0.getColumnIndex(var1);
      return createPieDatasetForColumn(var0, var2);
   }

   public static PieDataset createPieDatasetForColumn(CategoryDataset var0, int var1) {
      DefaultPieDataset var2 = new DefaultPieDataset();
      int var3 = var0.getRowCount();

      for(int var4 = 0; var4 < var3; ++var4) {
         Comparable var5 = var0.getRowKey(var4);
         var2.setValue(var5, var0.getValue(var4, var1));
      }

      return var2;
   }

   public static PieDataset createConsolidatedPieDataset(PieDataset var0, Comparable var1, double var2) {
      return createConsolidatedPieDataset(var0, var1, var2, 2);
   }

   public static PieDataset createConsolidatedPieDataset(PieDataset var0, Comparable var1, double var2, int var4) {
      DefaultPieDataset var5 = new DefaultPieDataset();
      double var6 = calculatePieDatasetTotal(var0);
      List var8 = var0.getKeys();
      ArrayList var9 = new ArrayList();
      Iterator var10 = var8.iterator();

      while(var10.hasNext()) {
         Comparable var11 = (Comparable)var10.next();
         Number var12 = var0.getValue(var11);
         if(var12 != null) {
            double var13 = var12.doubleValue();
            if(var13 / var6 < var2) {
               var9.add(var11);
            }
         }
      }

      var10 = var8.iterator();
      double var15 = 0.0D;

      while(true) {
         while(true) {
            Number var14;
            Comparable var16;
            do {
               if(!var10.hasNext()) {
                  if(var9.size() >= var4) {
                     var5.setValue(var1, var15);
                  }

                  return var5;
               }

               var16 = (Comparable)var10.next();
               var14 = var0.getValue(var16);
            } while(var14 == null);

            if(var9.contains(var16) && var9.size() >= var4) {
               var15 += var14.doubleValue();
            } else {
               var5.setValue(var16, var14);
            }
         }
      }
   }

   public static CategoryDataset createCategoryDataset(String var0, String var1, double[][] var2) {
      DefaultCategoryDataset var3 = new DefaultCategoryDataset();

      for(int var4 = 0; var4 < var2.length; ++var4) {
         String var5 = var0 + (var4 + 1);

         for(int var6 = 0; var6 < var2[var4].length; ++var6) {
            String var7 = var1 + (var6 + 1);
            var3.addValue(new Double(var2[var4][var6]), var5, var7);
         }
      }

      return var3;
   }

   public static CategoryDataset createCategoryDataset(String var0, String var1, Number[][] var2) {
      DefaultCategoryDataset var3 = new DefaultCategoryDataset();

      for(int var4 = 0; var4 < var2.length; ++var4) {
         String var5 = var0 + (var4 + 1);

         for(int var6 = 0; var6 < var2[var4].length; ++var6) {
            String var7 = var1 + (var6 + 1);
            var3.addValue(var2[var4][var6], var5, var7);
         }
      }

      return var3;
   }

   public static CategoryDataset createCategoryDataset(Comparable[] var0, Comparable[] var1, double[][] var2) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'rowKeys\' argument.");
      } else if(var1 == null) {
         throw new IllegalArgumentException("Null \'columnKeys\' argument.");
      } else if(ArrayUtilities.hasDuplicateItems(var0)) {
         throw new IllegalArgumentException("Duplicate items in \'rowKeys\'.");
      } else if(ArrayUtilities.hasDuplicateItems(var1)) {
         throw new IllegalArgumentException("Duplicate items in \'columnKeys\'.");
      } else if(var0.length != var2.length) {
         throw new IllegalArgumentException("The number of row keys does not match the number of rows in the data array.");
      } else {
         int var3 = 0;

         for(int var4 = 0; var4 < var2.length; ++var4) {
            var3 = Math.max(var3, var2[var4].length);
         }

         if(var1.length != var3) {
            throw new IllegalArgumentException("The number of column keys does not match the number of columns in the data array.");
         } else {
            DefaultCategoryDataset var9 = new DefaultCategoryDataset();

            for(int var5 = 0; var5 < var2.length; ++var5) {
               Comparable var6 = var0[var5];

               for(int var7 = 0; var7 < var2[var5].length; ++var7) {
                  Comparable var8 = var1[var7];
                  var9.addValue(new Double(var2[var5][var7]), var6, var8);
               }
            }

            return var9;
         }
      }
   }

   public static CategoryDataset createCategoryDataset(Comparable var0, KeyedValues var1) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'rowKey\' argument.");
      } else if(var1 == null) {
         throw new IllegalArgumentException("Null \'rowData\' argument.");
      } else {
         DefaultCategoryDataset var2 = new DefaultCategoryDataset();

         for(int var3 = 0; var3 < var1.getItemCount(); ++var3) {
            var2.addValue(var1.getValue(var3), var0, var1.getKey(var3));
         }

         return var2;
      }
   }

   public static XYDataset sampleFunction2D(Function2D var0, double var1, double var3, int var5, Comparable var6) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'f\' argument.");
      } else if(var6 == null) {
         throw new IllegalArgumentException("Null \'seriesKey\' argument.");
      } else if(var1 >= var3) {
         throw new IllegalArgumentException("Requires \'start\' < \'end\'.");
      } else if(var5 < 2) {
         throw new IllegalArgumentException("Requires \'samples\' > 1");
      } else {
         XYSeries var7 = new XYSeries(var6);
         double var8 = (var3 - var1) / (double)var5;

         for(int var10 = 0; var10 <= var5; ++var10) {
            double var11 = var1 + var8 * (double)var10;
            var7.add(var11, var0.getValue(var11));
         }

         XYSeriesCollection var13 = new XYSeriesCollection(var7);
         return var13;
      }
   }

   public static boolean isEmptyOrNull(PieDataset var0) {
      if(var0 == null) {
         return true;
      } else {
         int var1 = var0.getItemCount();
         if(var1 == 0) {
            return true;
         } else {
            for(int var2 = 0; var2 < var1; ++var2) {
               Number var3 = var0.getValue(var2);
               if(var3 != null) {
                  double var4 = var3.doubleValue();
                  if(var4 > 0.0D) {
                     return false;
                  }
               }
            }

            return true;
         }
      }
   }

   public static boolean isEmptyOrNull(CategoryDataset var0) {
      if(var0 == null) {
         return true;
      } else {
         int var1 = var0.getRowCount();
         int var2 = var0.getColumnCount();
         if(var1 != 0 && var2 != 0) {
            for(int var3 = 0; var3 < var1; ++var3) {
               for(int var4 = 0; var4 < var2; ++var4) {
                  if(var0.getValue(var3, var4) != null) {
                     return false;
                  }
               }
            }

            return true;
         } else {
            return true;
         }
      }
   }

   public static boolean isEmptyOrNull(XYDataset var0) {
      boolean var1 = true;
      if(var0 != null) {
         for(int var2 = 0; var2 < var0.getSeriesCount(); ++var2) {
            if(var0.getItemCount(var2) > 0) {
               var1 = false;
            }
         }
      }

      return var1;
   }

   public static Range findDomainBounds(XYDataset var0) {
      return findDomainBounds(var0, true);
   }

   public static Range findDomainBounds(XYDataset var0, boolean var1) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'dataset\' argument.");
      } else {
         Range var2 = null;
         if(var0 instanceof DomainInfo) {
            DomainInfo var3 = (DomainInfo)var0;
            var2 = var3.getDomainBounds(var1);
         } else {
            var2 = iterateDomainBounds(var0, var1);
         }

         return var2;
      }
   }

   public static Range iterateDomainBounds(XYDataset var0) {
      return iterateDomainBounds(var0, true);
   }

   public static Range iterateDomainBounds(XYDataset var0, boolean var1) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'dataset\' argument.");
      } else {
         double var2 = Double.POSITIVE_INFINITY;
         double var4 = Double.NEGATIVE_INFINITY;
         int var6 = var0.getSeriesCount();
         double var7;
         int var12;
         int var13;
         if(var1 && var0 instanceof IntervalXYDataset) {
            IntervalXYDataset var15 = (IntervalXYDataset)var0;

            for(var12 = 0; var12 < var6; ++var12) {
               var13 = var0.getItemCount(var12);

               for(int var14 = 0; var14 < var13; ++var14) {
                  var7 = var15.getStartXValue(var12, var14);
                  double var9 = var15.getEndXValue(var12, var14);
                  var2 = Math.min(var2, var7);
                  var4 = Math.max(var4, var9);
               }
            }
         } else {
            for(int var11 = 0; var11 < var6; ++var11) {
               var12 = var0.getItemCount(var11);

               for(var13 = 0; var13 < var12; ++var13) {
                  var7 = var0.getXValue(var11, var13);
                  var2 = Math.min(var2, var7);
                  var4 = Math.max(var4, var7);
               }
            }
         }

         return var2 > var4?null:new Range(var2, var4);
      }
   }

   public static Range findRangeBounds(CategoryDataset var0) {
      return findRangeBounds(var0, true);
   }

   public static Range findRangeBounds(CategoryDataset var0, boolean var1) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'dataset\' argument.");
      } else {
         Range var2 = null;
         if(var0 instanceof RangeInfo) {
            RangeInfo var3 = (RangeInfo)var0;
            var2 = var3.getRangeBounds(var1);
         } else {
            var2 = iterateCategoryRangeBounds(var0, var1);
         }

         return var2;
      }
   }

   public static Range findRangeBounds(XYDataset var0) {
      return findRangeBounds(var0, true);
   }

   public static Range findRangeBounds(XYDataset var0, boolean var1) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'dataset\' argument.");
      } else {
         Range var2 = null;
         if(var0 instanceof RangeInfo) {
            RangeInfo var3 = (RangeInfo)var0;
            var2 = var3.getRangeBounds(var1);
         } else {
            var2 = iterateXYRangeBounds(var0);
         }

         return var2;
      }
   }

   public static Range iterateCategoryRangeBounds(CategoryDataset var0, boolean var1) {
      double var2 = Double.POSITIVE_INFINITY;
      double var4 = Double.NEGATIVE_INFINITY;
      boolean var6 = var1 && var0 instanceof IntervalCategoryDataset;
      int var7 = var0.getRowCount();
      int var8 = var0.getColumnCount();

      for(int var9 = 0; var9 < var7; ++var9) {
         for(int var10 = 0; var10 < var8; ++var10) {
            Number var11;
            Number var12;
            if(var6) {
               IntervalCategoryDataset var13 = (IntervalCategoryDataset)var0;
               var11 = var13.getStartValue(var9, var10);
               var12 = var13.getEndValue(var9, var10);
            } else {
               var11 = var0.getValue(var9, var10);
               var12 = var11;
            }

            if(var11 != null) {
               var2 = Math.min(var2, var11.doubleValue());
            }

            if(var12 != null) {
               var4 = Math.max(var4, var12.doubleValue());
            }
         }
      }

      if(var2 == Double.POSITIVE_INFINITY) {
         return null;
      } else {
         return new Range(var2, var4);
      }
   }

   public static Range iterateXYRangeBounds(XYDataset var0) {
      double var1 = Double.POSITIVE_INFINITY;
      double var3 = Double.NEGATIVE_INFINITY;
      int var5 = var0.getSeriesCount();

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = var0.getItemCount(var6);

         for(int var8 = 0; var8 < var7; ++var8) {
            double var9;
            double var11;
            if(var0 instanceof IntervalXYDataset) {
               IntervalXYDataset var13 = (IntervalXYDataset)var0;
               var9 = var13.getStartYValue(var6, var8);
               var11 = var13.getEndYValue(var6, var8);
            } else if(var0 instanceof OHLCDataset) {
               OHLCDataset var14 = (OHLCDataset)var0;
               var9 = var14.getLowValue(var6, var8);
               var11 = var14.getHighValue(var6, var8);
            } else {
               var9 = var0.getYValue(var6, var8);
               var11 = var9;
            }

            if(!Double.isNaN(var9)) {
               var1 = Math.min(var1, var9);
            }

            if(!Double.isNaN(var11)) {
               var3 = Math.max(var3, var11);
            }
         }
      }

      if(var1 == Double.POSITIVE_INFINITY) {
         return null;
      } else {
         return new Range(var1, var3);
      }
   }

   public static Number findMinimumDomainValue(XYDataset var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'dataset\' argument.");
      } else {
         Double var1 = null;
         if(var0 instanceof DomainInfo) {
            DomainInfo var11 = (DomainInfo)var0;
            return new Double(var11.getDomainLowerBound(true));
         } else {
            double var2 = Double.POSITIVE_INFINITY;
            int var4 = var0.getSeriesCount();

            for(int var5 = 0; var5 < var4; ++var5) {
               int var6 = var0.getItemCount(var5);

               for(int var7 = 0; var7 < var6; ++var7) {
                  double var8;
                  if(var0 instanceof IntervalXYDataset) {
                     IntervalXYDataset var10 = (IntervalXYDataset)var0;
                     var8 = var10.getStartXValue(var5, var7);
                  } else {
                     var8 = var0.getXValue(var5, var7);
                  }

                  if(!Double.isNaN(var8)) {
                     var2 = Math.min(var2, var8);
                  }
               }
            }

            if(var2 == Double.POSITIVE_INFINITY) {
               var1 = null;
            } else {
               var1 = new Double(var2);
            }

            return var1;
         }
      }
   }

   public static Number findMaximumDomainValue(XYDataset var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'dataset\' argument.");
      } else {
         Double var1 = null;
         if(var0 instanceof DomainInfo) {
            DomainInfo var11 = (DomainInfo)var0;
            return new Double(var11.getDomainUpperBound(true));
         } else {
            double var2 = Double.NEGATIVE_INFINITY;
            int var4 = var0.getSeriesCount();

            for(int var5 = 0; var5 < var4; ++var5) {
               int var6 = var0.getItemCount(var5);

               for(int var7 = 0; var7 < var6; ++var7) {
                  double var8;
                  if(var0 instanceof IntervalXYDataset) {
                     IntervalXYDataset var10 = (IntervalXYDataset)var0;
                     var8 = var10.getEndXValue(var5, var7);
                  } else {
                     var8 = var0.getXValue(var5, var7);
                  }

                  if(!Double.isNaN(var8)) {
                     var2 = Math.max(var2, var8);
                  }
               }
            }

            if(var2 == Double.NEGATIVE_INFINITY) {
               var1 = null;
            } else {
               var1 = new Double(var2);
            }

            return var1;
         }
      }
   }

   public static Number findMinimumRangeValue(CategoryDataset var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'dataset\' argument.");
      } else if(var0 instanceof RangeInfo) {
         RangeInfo var9 = (RangeInfo)var0;
         return new Double(var9.getRangeLowerBound(true));
      } else {
         double var1 = Double.POSITIVE_INFINITY;
         int var3 = var0.getRowCount();
         int var4 = var0.getColumnCount();

         for(int var5 = 0; var5 < var3; ++var5) {
            for(int var6 = 0; var6 < var4; ++var6) {
               Number var7;
               if(var0 instanceof IntervalCategoryDataset) {
                  IntervalCategoryDataset var8 = (IntervalCategoryDataset)var0;
                  var7 = var8.getStartValue(var5, var6);
               } else {
                  var7 = var0.getValue(var5, var6);
               }

               if(var7 != null) {
                  var1 = Math.min(var1, var7.doubleValue());
               }
            }
         }

         if(var1 == Double.POSITIVE_INFINITY) {
            return null;
         } else {
            return new Double(var1);
         }
      }
   }

   public static Number findMinimumRangeValue(XYDataset var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'dataset\' argument.");
      } else if(var0 instanceof RangeInfo) {
         RangeInfo var10 = (RangeInfo)var0;
         return new Double(var10.getRangeLowerBound(true));
      } else {
         double var1 = Double.POSITIVE_INFINITY;
         int var3 = var0.getSeriesCount();

         for(int var4 = 0; var4 < var3; ++var4) {
            int var5 = var0.getItemCount(var4);

            for(int var6 = 0; var6 < var5; ++var6) {
               double var7;
               if(var0 instanceof IntervalXYDataset) {
                  IntervalXYDataset var9 = (IntervalXYDataset)var0;
                  var7 = var9.getStartYValue(var4, var6);
               } else if(var0 instanceof OHLCDataset) {
                  OHLCDataset var11 = (OHLCDataset)var0;
                  var7 = var11.getLowValue(var4, var6);
               } else {
                  var7 = var0.getYValue(var4, var6);
               }

               if(!Double.isNaN(var7)) {
                  var1 = Math.min(var1, var7);
               }
            }
         }

         if(var1 == Double.POSITIVE_INFINITY) {
            return null;
         } else {
            return new Double(var1);
         }
      }
   }

   public static Number findMaximumRangeValue(CategoryDataset var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'dataset\' argument.");
      } else if(var0 instanceof RangeInfo) {
         RangeInfo var9 = (RangeInfo)var0;
         return new Double(var9.getRangeUpperBound(true));
      } else {
         double var1 = Double.NEGATIVE_INFINITY;
         int var3 = var0.getRowCount();
         int var4 = var0.getColumnCount();

         for(int var5 = 0; var5 < var3; ++var5) {
            for(int var6 = 0; var6 < var4; ++var6) {
               Number var7;
               if(var0 instanceof IntervalCategoryDataset) {
                  IntervalCategoryDataset var8 = (IntervalCategoryDataset)var0;
                  var7 = var8.getEndValue(var5, var6);
               } else {
                  var7 = var0.getValue(var5, var6);
               }

               if(var7 != null) {
                  var1 = Math.max(var1, var7.doubleValue());
               }
            }
         }

         if(var1 == Double.NEGATIVE_INFINITY) {
            return null;
         } else {
            return new Double(var1);
         }
      }
   }

   public static Number findMaximumRangeValue(XYDataset var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'dataset\' argument.");
      } else if(var0 instanceof RangeInfo) {
         RangeInfo var10 = (RangeInfo)var0;
         return new Double(var10.getRangeUpperBound(true));
      } else {
         double var1 = Double.NEGATIVE_INFINITY;
         int var3 = var0.getSeriesCount();

         for(int var4 = 0; var4 < var3; ++var4) {
            int var5 = var0.getItemCount(var4);

            for(int var6 = 0; var6 < var5; ++var6) {
               double var7;
               if(var0 instanceof IntervalXYDataset) {
                  IntervalXYDataset var9 = (IntervalXYDataset)var0;
                  var7 = var9.getEndYValue(var4, var6);
               } else if(var0 instanceof OHLCDataset) {
                  OHLCDataset var11 = (OHLCDataset)var0;
                  var7 = var11.getHighValue(var4, var6);
               } else {
                  var7 = var0.getYValue(var4, var6);
               }

               if(!Double.isNaN(var7)) {
                  var1 = Math.max(var1, var7);
               }
            }
         }

         if(var1 == Double.NEGATIVE_INFINITY) {
            return null;
         } else {
            return new Double(var1);
         }
      }
   }

   public static Range findStackedRangeBounds(CategoryDataset var0) {
      return findStackedRangeBounds(var0, 0.0D);
   }

   public static Range findStackedRangeBounds(CategoryDataset var0, double var1) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'dataset\' argument.");
      } else {
         Range var3 = null;
         double var4 = Double.POSITIVE_INFINITY;
         double var6 = Double.NEGATIVE_INFINITY;
         int var8 = var0.getColumnCount();

         for(int var9 = 0; var9 < var8; ++var9) {
            double var10 = var1;
            double var12 = var1;
            int var14 = var0.getRowCount();

            for(int var15 = 0; var15 < var14; ++var15) {
               Number var16 = var0.getValue(var15, var9);
               if(var16 != null) {
                  double var17 = var16.doubleValue();
                  if(var17 > 0.0D) {
                     var10 += var17;
                  }

                  if(var17 < 0.0D) {
                     var12 += var17;
                  }
               }
            }

            var4 = Math.min(var4, var12);
            var6 = Math.max(var6, var10);
         }

         if(var4 <= var6) {
            var3 = new Range(var4, var6);
         }

         return var3;
      }
   }

   public static Range findStackedRangeBounds(CategoryDataset var0, KeyToGroupMap var1) {
      Range var2 = null;
      if(var0 != null) {
         int[] var3 = new int[var0.getRowCount()];

         int var4;
         for(var4 = 0; var4 < var0.getRowCount(); ++var4) {
            var3[var4] = var1.getGroupIndex(var1.getGroup(var0.getRowKey(var4)));
         }

         var4 = var1.getGroupCount();
         double[] var5 = new double[var4];
         double[] var6 = new double[var4];
         int var7 = var0.getColumnCount();

         int var8;
         for(var8 = 0; var8 < var7; ++var8) {
            double[] var9 = new double[var4];
            double[] var10 = new double[var4];
            int var11 = var0.getRowCount();

            int var12;
            for(var12 = 0; var12 < var11; ++var12) {
               Number var13 = var0.getValue(var12, var8);
               if(var13 != null) {
                  double var14 = var13.doubleValue();
                  if(var14 > 0.0D) {
                     var9[var3[var12]] += var14;
                  }

                  if(var14 < 0.0D) {
                     var10[var3[var12]] += var14;
                  }
               }
            }

            for(var12 = 0; var12 < var4; ++var12) {
               var5[var12] = Math.min(var5[var12], var10[var12]);
               var6[var12] = Math.max(var6[var12], var9[var12]);
            }
         }

         for(var8 = 0; var8 < var4; ++var8) {
            var2 = Range.combine(var2, new Range(var5[var8], var6[var8]));
         }
      }

      return var2;
   }

   public static Number findMinimumStackedRangeValue(CategoryDataset var0) {
      Double var1 = null;
      if(var0 != null) {
         double var2 = 0.0D;
         int var4 = var0.getRowCount();

         for(int var5 = 0; var5 < var4; ++var5) {
            double var6 = 0.0D;
            int var8 = var0.getColumnCount();

            for(int var9 = 0; var9 < var8; ++var9) {
               Number var10 = var0.getValue(var9, var5);
               if(var10 != null) {
                  double var11 = var10.doubleValue();
                  if(var11 < 0.0D) {
                     var6 += var11;
                  }
               }
            }

            var2 = Math.min(var2, var6);
         }

         var1 = new Double(var2);
      }

      return var1;
   }

   public static Number findMaximumStackedRangeValue(CategoryDataset var0) {
      Double var1 = null;
      if(var0 != null) {
         double var2 = 0.0D;
         int var4 = var0.getColumnCount();

         for(int var5 = 0; var5 < var4; ++var5) {
            double var6 = 0.0D;
            int var8 = var0.getRowCount();

            for(int var9 = 0; var9 < var8; ++var9) {
               Number var10 = var0.getValue(var9, var5);
               if(var10 != null) {
                  double var11 = var10.doubleValue();
                  if(var11 > 0.0D) {
                     var6 += var11;
                  }
               }
            }

            var2 = Math.max(var2, var6);
         }

         var1 = new Double(var2);
      }

      return var1;
   }

   public static Range findStackedRangeBounds(TableXYDataset var0) {
      return findStackedRangeBounds(var0, 0.0D);
   }

   public static Range findStackedRangeBounds(TableXYDataset var0, double var1) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'dataset\' argument.");
      } else {
         double var3 = var1;
         double var5 = var1;

         for(int var7 = 0; var7 < var0.getItemCount(); ++var7) {
            double var8 = var1;
            double var10 = var1;
            int var12 = var0.getSeriesCount();

            for(int var13 = 0; var13 < var12; ++var13) {
               double var14 = var0.getYValue(var13, var7);
               if(!Double.isNaN(var14)) {
                  if(var14 > 0.0D) {
                     var8 += var14;
                  } else {
                     var10 += var14;
                  }
               }
            }

            if(var8 > var5) {
               var5 = var8;
            }

            if(var10 < var3) {
               var3 = var10;
            }
         }

         if(var3 <= var5) {
            return new Range(var3, var5);
         } else {
            return null;
         }
      }
   }

   public static double calculateStackTotal(TableXYDataset var0, int var1) {
      double var2 = 0.0D;
      int var4 = var0.getSeriesCount();

      for(int var5 = 0; var5 < var4; ++var5) {
         double var6 = var0.getYValue(var5, var1);
         if(!Double.isNaN(var6)) {
            var2 += var6;
         }
      }

      return var2;
   }

   public static Range findCumulativeRangeBounds(CategoryDataset var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'dataset\' argument.");
      } else {
         boolean var1 = true;
         double var2 = 0.0D;
         double var4 = 0.0D;

         for(int var6 = 0; var6 < var0.getRowCount(); ++var6) {
            double var7 = 0.0D;

            for(int var9 = 0; var9 < var0.getColumnCount() - 1; ++var9) {
               Number var10 = var0.getValue(var6, var9);
               if(var10 != null) {
                  var1 = false;
                  double var11 = var10.doubleValue();
                  var7 += var11;
                  var2 = Math.min(var2, var7);
                  var4 = Math.max(var4, var7);
               }
            }
         }

         if(!var1) {
            return new Range(var2, var4);
         } else {
            return null;
         }
      }
   }
}
