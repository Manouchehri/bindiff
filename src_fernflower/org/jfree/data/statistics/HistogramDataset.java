package org.jfree.data.statistics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.statistics.HistogramBin;
import org.jfree.data.statistics.HistogramType;
import org.jfree.data.xy.AbstractIntervalXYDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;

public class HistogramDataset extends AbstractIntervalXYDataset implements Serializable, Cloneable, IntervalXYDataset, PublicCloneable {
   private static final long serialVersionUID = -6341668077370231153L;
   private List list = new ArrayList();
   private HistogramType type;

   public HistogramDataset() {
      this.type = HistogramType.FREQUENCY;
   }

   public HistogramType getType() {
      return this.type;
   }

   public void setType(HistogramType var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'type\' argument");
      } else {
         this.type = var1;
         this.notifyListeners(new DatasetChangeEvent(this, this));
      }
   }

   public void addSeries(Comparable var1, double[] var2, int var3) {
      double var4 = this.getMinimum(var2);
      double var6 = this.getMaximum(var2);
      this.addSeries(var1, var2, var3, var4, var6);
   }

   public void addSeries(Comparable var1, double[] var2, int var3, double var4, double var6) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'key\' argument.");
      } else if(var2 == null) {
         throw new IllegalArgumentException("Null \'values\' argument.");
      } else if(var3 < 1) {
         throw new IllegalArgumentException("The \'bins\' value must be at least 1.");
      } else {
         double var8 = (var6 - var4) / (double)var3;
         double var10 = var4;
         ArrayList var14 = new ArrayList(var3);

         int var15;
         for(var15 = 0; var15 < var3; ++var15) {
            HistogramBin var16;
            if(var15 == var3 - 1) {
               var16 = new HistogramBin(var10, var6);
            } else {
               double var12 = var4 + (double)(var15 + 1) * var8;
               var16 = new HistogramBin(var10, var12);
               var10 = var12;
            }

            var14.add(var16);
         }

         for(var15 = 0; var15 < var2.length; ++var15) {
            int var20 = var3 - 1;
            if(var2[var15] < var6) {
               double var17 = (var2[var15] - var4) / (var6 - var4);
               if(var17 < 0.0D) {
                  var17 = 0.0D;
               }

               var20 = (int)(var17 * (double)var3);
               if(var20 >= var3) {
                  var20 = var3 - 1;
               }
            }

            HistogramBin var21 = (HistogramBin)var14.get(var20);
            var21.incrementCount();
         }

         HashMap var19 = new HashMap();
         var19.put("key", var1);
         var19.put("bins", var14);
         var19.put("values.length", new Integer(var2.length));
         var19.put("bin width", new Double(var8));
         this.list.add(var19);
      }
   }

   private double getMinimum(double[] var1) {
      if(var1 != null && var1.length >= 1) {
         double var2 = Double.MAX_VALUE;

         for(int var4 = 0; var4 < var1.length; ++var4) {
            if(var1[var4] < var2) {
               var2 = var1[var4];
            }
         }

         return var2;
      } else {
         throw new IllegalArgumentException("Null or zero length \'values\' argument.");
      }
   }

   private double getMaximum(double[] var1) {
      if(var1 != null && var1.length >= 1) {
         double var2 = -1.7976931348623157E308D;

         for(int var4 = 0; var4 < var1.length; ++var4) {
            if(var1[var4] > var2) {
               var2 = var1[var4];
            }
         }

         return var2;
      } else {
         throw new IllegalArgumentException("Null or zero length \'values\' argument.");
      }
   }

   List getBins(int var1) {
      Map var2 = (Map)this.list.get(var1);
      return (List)var2.get("bins");
   }

   private int getTotal(int var1) {
      Map var2 = (Map)this.list.get(var1);
      return ((Integer)var2.get("values.length")).intValue();
   }

   private double getBinWidth(int var1) {
      Map var2 = (Map)this.list.get(var1);
      return ((Double)var2.get("bin width")).doubleValue();
   }

   public int getSeriesCount() {
      return this.list.size();
   }

   public Comparable getSeriesKey(int var1) {
      Map var2 = (Map)this.list.get(var1);
      return (Comparable)var2.get("key");
   }

   public int getItemCount(int var1) {
      return this.getBins(var1).size();
   }

   public Number getX(int var1, int var2) {
      List var3 = this.getBins(var1);
      HistogramBin var4 = (HistogramBin)var3.get(var2);
      double var5 = (var4.getStartBoundary() + var4.getEndBoundary()) / 2.0D;
      return new Double(var5);
   }

   public Number getY(int var1, int var2) {
      List var3 = this.getBins(var1);
      HistogramBin var4 = (HistogramBin)var3.get(var2);
      double var5 = (double)this.getTotal(var1);
      double var7 = this.getBinWidth(var1);
      if(this.type == HistogramType.FREQUENCY) {
         return new Double((double)var4.getCount());
      } else if(this.type == HistogramType.RELATIVE_FREQUENCY) {
         return new Double((double)var4.getCount() / var5);
      } else if(this.type == HistogramType.SCALE_AREA_TO_1) {
         return new Double((double)var4.getCount() / (var7 * var5));
      } else {
         throw new IllegalStateException();
      }
   }

   public Number getStartX(int var1, int var2) {
      List var3 = this.getBins(var1);
      HistogramBin var4 = (HistogramBin)var3.get(var2);
      return new Double(var4.getStartBoundary());
   }

   public Number getEndX(int var1, int var2) {
      List var3 = this.getBins(var1);
      HistogramBin var4 = (HistogramBin)var3.get(var2);
      return new Double(var4.getEndBoundary());
   }

   public Number getStartY(int var1, int var2) {
      return this.getY(var1, var2);
   }

   public Number getEndY(int var1, int var2) {
      return this.getY(var1, var2);
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof HistogramDataset)) {
         return false;
      } else {
         HistogramDataset var2 = (HistogramDataset)var1;
         return !ObjectUtilities.equal(this.type, var2.type)?false:ObjectUtilities.equal(this.list, var2.list);
      }
   }

   public Object clone() {
      return super.clone();
   }
}
