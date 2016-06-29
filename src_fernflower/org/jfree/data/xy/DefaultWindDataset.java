package org.jfree.data.xy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.jfree.data.xy.AbstractXYDataset;
import org.jfree.data.xy.WindDataItem;
import org.jfree.data.xy.WindDataset;

public class DefaultWindDataset extends AbstractXYDataset implements WindDataset {
   private List seriesKeys;
   private List allSeriesData;

   public DefaultWindDataset() {
      this.seriesKeys = new ArrayList();
      this.allSeriesData = new ArrayList();
   }

   public DefaultWindDataset(Object[][][] var1) {
      this(seriesNameListFromDataArray(var1), var1);
   }

   public DefaultWindDataset(String[] var1, Object[][][] var2) {
      this(Arrays.asList(var1), var2);
   }

   public DefaultWindDataset(List var1, Object[][][] var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'seriesKeys\' argument.");
      } else if(var1.size() != var2.length) {
         throw new IllegalArgumentException("The number of series keys does not match the number of series in the data array.");
      } else {
         this.seriesKeys = var1;
         int var3 = var2.length;
         this.allSeriesData = new ArrayList(var3);

         for(int var4 = 0; var4 < var3; ++var4) {
            ArrayList var5 = new ArrayList();
            int var6 = var2[var4].length;

            for(int var7 = 0; var7 < var6; ++var7) {
               Object var8 = var2[var4][var7][0];
               if(var8 != null) {
                  Object var9;
                  if(var8 instanceof Number) {
                     var9 = (Number)var8;
                  } else if(var8 instanceof Date) {
                     Date var10 = (Date)var8;
                     var9 = new Long(var10.getTime());
                  } else {
                     var9 = new Integer(0);
                  }

                  Number var12 = (Number)var2[var4][var7][1];
                  Number var11 = (Number)var2[var4][var7][2];
                  var5.add(new WindDataItem((Number)var9, var12, var11));
               }
            }

            Collections.sort(var5);
            this.allSeriesData.add(var4, var5);
         }

      }
   }

   public int getSeriesCount() {
      return this.allSeriesData.size();
   }

   public int getItemCount(int var1) {
      if(var1 >= 0 && var1 < this.getSeriesCount()) {
         List var2 = (List)this.allSeriesData.get(var1);
         return var2.size();
      } else {
         throw new IllegalArgumentException("Invalid series index: " + var1);
      }
   }

   public Comparable getSeriesKey(int var1) {
      if(var1 >= 0 && var1 < this.getSeriesCount()) {
         return (Comparable)this.seriesKeys.get(var1);
      } else {
         throw new IllegalArgumentException("Invalid series index: " + var1);
      }
   }

   public Number getX(int var1, int var2) {
      List var3 = (List)this.allSeriesData.get(var1);
      WindDataItem var4 = (WindDataItem)var3.get(var2);
      return var4.getX();
   }

   public Number getY(int var1, int var2) {
      return this.getWindForce(var1, var2);
   }

   public Number getWindDirection(int var1, int var2) {
      List var3 = (List)this.allSeriesData.get(var1);
      WindDataItem var4 = (WindDataItem)var3.get(var2);
      return var4.getWindDirection();
   }

   public Number getWindForce(int var1, int var2) {
      List var3 = (List)this.allSeriesData.get(var1);
      WindDataItem var4 = (WindDataItem)var3.get(var2);
      return var4.getWindForce();
   }

   public static List seriesNameListFromDataArray(Object[][] var0) {
      int var1 = var0.length;
      ArrayList var2 = new ArrayList(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         var2.add("Series " + (var3 + 1));
      }

      return var2;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof DefaultWindDataset)) {
         return false;
      } else {
         DefaultWindDataset var2 = (DefaultWindDataset)var1;
         return !this.seriesKeys.equals(var2.seriesKeys)?false:this.allSeriesData.equals(var2.allSeriesData);
      }
   }
}
