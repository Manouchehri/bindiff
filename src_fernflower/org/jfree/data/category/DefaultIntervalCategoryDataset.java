package org.jfree.data.category;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import org.jfree.data.DataUtilities;
import org.jfree.data.UnknownKeyException;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.general.AbstractSeriesDataset;

public class DefaultIntervalCategoryDataset extends AbstractSeriesDataset implements IntervalCategoryDataset {
   private Comparable[] seriesKeys;
   private Comparable[] categoryKeys;
   private Number[][] startData;
   private Number[][] endData;

   public DefaultIntervalCategoryDataset(double[][] var1, double[][] var2) {
      this(DataUtilities.createNumberArray2D(var1), DataUtilities.createNumberArray2D(var2));
   }

   public DefaultIntervalCategoryDataset(Number[][] var1, Number[][] var2) {
      this((Comparable[])null, (Comparable[])null, var1, var2);
   }

   public DefaultIntervalCategoryDataset(String[] var1, Number[][] var2, Number[][] var3) {
      this(var1, (Comparable[])null, var2, var3);
   }

   public DefaultIntervalCategoryDataset(Comparable[] var1, Comparable[] var2, Number[][] var3, Number[][] var4) {
      this.startData = var3;
      this.endData = var4;
      if(var3 != null && var4 != null) {
         String var5 = "org.jfree.data.resources.DataPackageResources";
         ResourceBundle var6 = ResourceBundle.getBundle(var5);
         int var7 = var3.length;
         String var8;
         if(var7 != var4.length) {
            var8 = "DefaultIntervalCategoryDataset: the number of series in the start value dataset does not match the number of series in the end value dataset.";
            throw new IllegalArgumentException(var8);
         }

         if(var7 > 0) {
            if(var1 != null) {
               if(var1.length != var7) {
                  throw new IllegalArgumentException("The number of series keys does not match the number of series in the data.");
               }

               this.seriesKeys = var1;
            } else {
               var8 = var6.getString("series.default-prefix") + " ";
               this.seriesKeys = this.generateKeys(var7, var8);
            }

            int var10 = var3[0].length;
            String var9;
            if(var10 != var4[0].length) {
               var9 = "DefaultIntervalCategoryDataset: the number of categories in the start value dataset does not match the number of categories in the end value dataset.";
               throw new IllegalArgumentException(var9);
            }

            if(var2 != null) {
               if(var2.length != var10) {
                  throw new IllegalArgumentException("The number of category keys does not match the number of categories in the data.");
               }

               this.categoryKeys = var2;
            } else {
               var9 = var6.getString("categories.default-prefix") + " ";
               this.categoryKeys = this.generateKeys(var10, var9);
            }
         } else {
            this.seriesKeys = null;
            this.categoryKeys = null;
         }
      }

   }

   public int getSeriesCount() {
      int var1 = 0;
      if(this.startData != null) {
         var1 = this.startData.length;
      }

      return var1;
   }

   public int getSeriesIndex(Comparable var1) {
      int var2 = -1;

      for(int var3 = 0; var3 < this.seriesKeys.length; ++var3) {
         if(var1.equals(this.seriesKeys[var3])) {
            var2 = var3;
            break;
         }
      }

      return var2;
   }

   public Comparable getSeriesKey(int var1) {
      if(var1 < this.getSeriesCount() && var1 >= 0) {
         return this.seriesKeys[var1];
      } else {
         throw new IllegalArgumentException("No such series : " + var1);
      }
   }

   public void setSeriesKeys(Comparable[] var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'seriesKeys\' argument.");
      } else if(var1.length != this.getSeriesCount()) {
         throw new IllegalArgumentException("The number of series keys does not match the data.");
      } else {
         this.seriesKeys = var1;
         this.fireDatasetChanged();
      }
   }

   public int getCategoryCount() {
      int var1 = 0;
      if(this.startData != null && this.getSeriesCount() > 0) {
         var1 = this.startData[0].length;
      }

      return var1;
   }

   public List getColumnKeys() {
      return (List)(this.categoryKeys == null?new ArrayList():Collections.unmodifiableList(Arrays.asList(this.categoryKeys)));
   }

   public void setCategoryKeys(Comparable[] var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'categoryKeys\' argument.");
      } else if(var1.length != this.startData[0].length) {
         throw new IllegalArgumentException("The number of categories does not match the data.");
      } else {
         for(int var2 = 0; var2 < var1.length; ++var2) {
            if(var1[var2] == null) {
               throw new IllegalArgumentException("DefaultIntervalCategoryDataset.setCategoryKeys(): null category not permitted.");
            }
         }

         this.categoryKeys = var1;
         this.fireDatasetChanged();
      }
   }

   public Number getValue(Comparable var1, Comparable var2) {
      int var3 = this.getSeriesIndex(var1);
      if(var3 < 0) {
         throw new UnknownKeyException("Unknown \'series\' key.");
      } else {
         int var4 = this.getColumnIndex(var2);
         if(var4 < 0) {
            throw new UnknownKeyException("Unknown \'category\' key.");
         } else {
            return this.getValue(var3, var4);
         }
      }
   }

   public Number getValue(int var1, int var2) {
      return this.getEndValue(var1, var2);
   }

   public Number getStartValue(Comparable var1, Comparable var2) {
      int var3 = this.getSeriesIndex(var1);
      if(var3 < 0) {
         throw new UnknownKeyException("Unknown \'series\' key.");
      } else {
         int var4 = this.getColumnIndex(var2);
         if(var4 < 0) {
            throw new UnknownKeyException("Unknown \'category\' key.");
         } else {
            return this.getStartValue(var3, var4);
         }
      }
   }

   public Number getStartValue(int var1, int var2) {
      if(var1 >= 0 && var1 < this.getSeriesCount()) {
         if(var2 >= 0 && var2 < this.getCategoryCount()) {
            return this.startData[var1][var2];
         } else {
            throw new IllegalArgumentException("DefaultIntervalCategoryDataset.getValue(): category index out of range.");
         }
      } else {
         throw new IllegalArgumentException("DefaultIntervalCategoryDataset.getValue(): series index out of range.");
      }
   }

   public Number getEndValue(Comparable var1, Comparable var2) {
      int var3 = this.getSeriesIndex(var1);
      if(var3 < 0) {
         throw new UnknownKeyException("Unknown \'series\' key.");
      } else {
         int var4 = this.getColumnIndex(var2);
         if(var4 < 0) {
            throw new UnknownKeyException("Unknown \'category\' key.");
         } else {
            return this.getEndValue(var3, var4);
         }
      }
   }

   public Number getEndValue(int var1, int var2) {
      if(var1 >= 0 && var1 < this.getSeriesCount()) {
         if(var2 >= 0 && var2 < this.getCategoryCount()) {
            return this.endData[var1][var2];
         } else {
            throw new IllegalArgumentException("DefaultIntervalCategoryDataset.getValue(): category index out of range.");
         }
      } else {
         throw new IllegalArgumentException("DefaultIntervalCategoryDataset.getValue(): series index out of range.");
      }
   }

   public void setStartValue(int var1, Comparable var2, Number var3) {
      if(var1 >= 0 && var1 <= this.getSeriesCount() - 1) {
         int var4 = this.getCategoryIndex(var2);
         if(var4 < 0) {
            throw new IllegalArgumentException("DefaultIntervalCategoryDataset.setValue: unrecognised category.");
         } else {
            this.startData[var1][var4] = var3;
            this.fireDatasetChanged();
         }
      } else {
         throw new IllegalArgumentException("DefaultIntervalCategoryDataset.setValue: series outside valid range.");
      }
   }

   public void setEndValue(int var1, Comparable var2, Number var3) {
      if(var1 >= 0 && var1 <= this.getSeriesCount() - 1) {
         int var4 = this.getCategoryIndex(var2);
         if(var4 < 0) {
            throw new IllegalArgumentException("DefaultIntervalCategoryDataset.setValue: unrecognised category.");
         } else {
            this.endData[var1][var4] = var3;
            this.fireDatasetChanged();
         }
      } else {
         throw new IllegalArgumentException("DefaultIntervalCategoryDataset.setValue: series outside valid range.");
      }
   }

   public int getCategoryIndex(Comparable var1) {
      int var2 = -1;

      for(int var3 = 0; var3 < this.categoryKeys.length; ++var3) {
         if(var1.equals(this.categoryKeys[var3])) {
            var2 = var3;
            break;
         }
      }

      return var2;
   }

   private Comparable[] generateKeys(int var1, String var2) {
      Comparable[] var3 = new Comparable[var1];

      for(int var5 = 0; var5 < var1; ++var5) {
         String var4 = var2 + (var5 + 1);
         var3[var5] = var4;
      }

      return var3;
   }

   public Comparable getColumnKey(int var1) {
      return this.categoryKeys[var1];
   }

   public int getColumnIndex(Comparable var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'columnKey\' argument.");
      } else {
         return this.getCategoryIndex(var1);
      }
   }

   public int getRowIndex(Comparable var1) {
      return this.getSeriesIndex(var1);
   }

   public List getRowKeys() {
      return (List)(this.seriesKeys == null?new ArrayList():Collections.unmodifiableList(Arrays.asList(this.seriesKeys)));
   }

   public Comparable getRowKey(int var1) {
      if(var1 < this.getRowCount() && var1 >= 0) {
         return this.seriesKeys[var1];
      } else {
         throw new IllegalArgumentException("The \'row\' argument is out of bounds.");
      }
   }

   public int getColumnCount() {
      return this.categoryKeys.length;
   }

   public int getRowCount() {
      return this.seriesKeys.length;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof DefaultIntervalCategoryDataset)) {
         return false;
      } else {
         DefaultIntervalCategoryDataset var2 = (DefaultIntervalCategoryDataset)var1;
         return !Arrays.equals(this.seriesKeys, var2.seriesKeys)?false:(!Arrays.equals(this.categoryKeys, var2.categoryKeys)?false:(!equal(this.startData, var2.startData)?false:equal(this.endData, var2.endData)));
      }
   }

   public Object clone() {
      DefaultIntervalCategoryDataset var1 = (DefaultIntervalCategoryDataset)super.clone();
      var1.categoryKeys = (Comparable[])((Comparable[])this.categoryKeys.clone());
      var1.seriesKeys = (Comparable[])((Comparable[])this.seriesKeys.clone());
      var1.startData = clone(this.startData);
      var1.endData = clone(this.endData);
      return var1;
   }

   private static boolean equal(Number[][] var0, Number[][] var1) {
      if(var0 == null) {
         return var1 == null;
      } else if(var1 == null) {
         return false;
      } else if(var0.length != var1.length) {
         return false;
      } else {
         for(int var2 = 0; var2 < var0.length; ++var2) {
            if(!Arrays.equals(var0[var2], var1[var2])) {
               return false;
            }
         }

         return true;
      }
   }

   private static Number[][] clone(Number[][] var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'array\' argument.");
      } else {
         Number[][] var1 = new Number[var0.length][];

         for(int var2 = 0; var2 < var0.length; ++var2) {
            Number[] var3 = var0[var2];
            Number[] var4 = new Number[var3.length];
            System.arraycopy(var3, 0, var4, 0, var3.length);
            var1[var2] = var4;
         }

         return var1;
      }
   }

   public List getSeries() {
      return (List)(this.seriesKeys == null?new ArrayList():Collections.unmodifiableList(Arrays.asList(this.seriesKeys)));
   }

   public List getCategories() {
      return this.getColumnKeys();
   }

   public int getItemCount() {
      return this.categoryKeys.length;
   }
}
