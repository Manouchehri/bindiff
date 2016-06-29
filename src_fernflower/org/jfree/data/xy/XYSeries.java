package org.jfree.data.xy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jfree.data.general.Series;
import org.jfree.data.general.SeriesException;
import org.jfree.data.xy.XYDataItem;
import org.jfree.util.ObjectUtilities;

public class XYSeries extends Series implements Serializable, Cloneable {
   static final long serialVersionUID = -5908509288197150436L;
   protected List data;
   private int maximumItemCount;
   private boolean autoSort;
   private boolean allowDuplicateXValues;

   public XYSeries(Comparable var1) {
      this(var1, true, true);
   }

   public XYSeries(Comparable var1, boolean var2) {
      this(var1, var2, true);
   }

   public XYSeries(Comparable var1, boolean var2, boolean var3) {
      super(var1);
      this.maximumItemCount = Integer.MAX_VALUE;
      this.data = new ArrayList();
      this.autoSort = var2;
      this.allowDuplicateXValues = var3;
   }

   public boolean getAutoSort() {
      return this.autoSort;
   }

   public boolean getAllowDuplicateXValues() {
      return this.allowDuplicateXValues;
   }

   public int getItemCount() {
      return this.data.size();
   }

   public List getItems() {
      return Collections.unmodifiableList(this.data);
   }

   public int getMaximumItemCount() {
      return this.maximumItemCount;
   }

   public void setMaximumItemCount(int var1) {
      this.maximumItemCount = var1;

      boolean var2;
      for(var2 = false; this.data.size() > var1; var2 = true) {
         this.data.remove(0);
      }

      if(var2) {
         this.fireSeriesChanged();
      }

   }

   public void add(XYDataItem var1) {
      this.add(var1, true);
   }

   public void add(double var1, double var3) {
      this.add(new Double(var1), new Double(var3), true);
   }

   public void add(double var1, double var3, boolean var5) {
      this.add(new Double(var1), new Double(var3), var5);
   }

   public void add(double var1, Number var3) {
      this.add(new Double(var1), var3);
   }

   public void add(double var1, Number var3, boolean var4) {
      this.add(new Double(var1), var3, var4);
   }

   public void add(Number var1, Number var2) {
      this.add(var1, var2, true);
   }

   public void add(Number var1, Number var2, boolean var3) {
      XYDataItem var4 = new XYDataItem(var1, var2);
      this.add(var4, var3);
   }

   public void add(XYDataItem var1, boolean var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'item\' argument.");
      } else {
         int var3;
         if(this.autoSort) {
            var3 = Collections.binarySearch(this.data, var1);
            if(var3 < 0) {
               this.data.add(-var3 - 1, var1);
            } else {
               if(!this.allowDuplicateXValues) {
                  throw new SeriesException("X-value already exists.");
               }

               for(int var4 = this.data.size(); var3 < var4 && var1.compareTo(this.data.get(var3)) == 0; ++var3) {
                  ;
               }

               if(var3 < this.data.size()) {
                  this.data.add(var3, var1);
               } else {
                  this.data.add(var1);
               }
            }
         } else {
            if(!this.allowDuplicateXValues) {
               var3 = this.indexOf(var1.getX());
               if(var3 >= 0) {
                  throw new SeriesException("X-value already exists.");
               }
            }

            this.data.add(var1);
         }

         if(this.getItemCount() > this.maximumItemCount) {
            this.data.remove(0);
         }

         if(var2) {
            this.fireSeriesChanged();
         }

      }
   }

   public void delete(int var1, int var2) {
      for(int var3 = var1; var3 <= var2; ++var3) {
         this.data.remove(var1);
      }

      this.fireSeriesChanged();
   }

   public XYDataItem remove(int var1) {
      XYDataItem var2 = (XYDataItem)this.data.remove(var1);
      this.fireSeriesChanged();
      return var2;
   }

   public XYDataItem remove(Number var1) {
      return this.remove(this.indexOf(var1));
   }

   public void clear() {
      if(this.data.size() > 0) {
         this.data.clear();
         this.fireSeriesChanged();
      }

   }

   public XYDataItem getDataItem(int var1) {
      return (XYDataItem)this.data.get(var1);
   }

   public Number getX(int var1) {
      return this.getDataItem(var1).getX();
   }

   public Number getY(int var1) {
      return this.getDataItem(var1).getY();
   }

   public void update(int var1, Number var2) {
      XYDataItem var3 = this.getDataItem(var1);
      var3.setY(var2);
      this.fireSeriesChanged();
   }

   public void updateByIndex(int var1, Number var2) {
      this.update(var1, var2);
   }

   public void update(Number var1, Number var2) {
      int var3 = this.indexOf(var1);
      if(var3 < 0) {
         throw new SeriesException("No observation for x = " + var1);
      } else {
         XYDataItem var4 = this.getDataItem(var3);
         var4.setY(var2);
         this.fireSeriesChanged();
      }
   }

   public XYDataItem addOrUpdate(Number var1, Number var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'x\' argument.");
      } else {
         XYDataItem var3 = null;
         int var4 = this.indexOf(var1);
         if(var4 >= 0) {
            XYDataItem var5 = (XYDataItem)this.data.get(var4);

            try {
               var3 = (XYDataItem)var5.clone();
            } catch (CloneNotSupportedException var7) {
               throw new SeriesException("Couldn\'t clone XYDataItem!");
            }

            var5.setY(var2);
         } else {
            if(this.autoSort) {
               this.data.add(-var4 - 1, new XYDataItem(var1, var2));
            } else {
               this.data.add(new XYDataItem(var1, var2));
            }

            if(this.getItemCount() > this.maximumItemCount) {
               this.data.remove(0);
            }
         }

         this.fireSeriesChanged();
         return var3;
      }
   }

   public int indexOf(Number var1) {
      if(this.autoSort) {
         return Collections.binarySearch(this.data, new XYDataItem(var1, (Number)null));
      } else {
         for(int var2 = 0; var2 < this.data.size(); ++var2) {
            XYDataItem var3 = (XYDataItem)this.data.get(var2);
            if(var3.getX().equals(var1)) {
               return var2;
            }
         }

         return -1;
      }
   }

   public double[][] toArray() {
      int var1 = this.getItemCount();
      double[][] var2 = new double[2][var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var2[0][var3] = this.getX(var3).doubleValue();
         Number var4 = this.getY(var3);
         if(var4 != null) {
            var2[1][var3] = var4.doubleValue();
         } else {
            var2[1][var3] = Double.NaN;
         }
      }

      return var2;
   }

   public Object clone() {
      XYSeries var1 = this.createCopy(0, this.getItemCount() - 1);
      return var1;
   }

   public XYSeries createCopy(int var1, int var2) {
      XYSeries var3 = (XYSeries)super.clone();
      var3.data = new ArrayList();
      if(this.data.size() > 0) {
         for(int var4 = var1; var4 <= var2; ++var4) {
            XYDataItem var5 = (XYDataItem)this.data.get(var4);
            XYDataItem var6 = (XYDataItem)var5.clone();

            try {
               var3.add(var6);
            } catch (SeriesException var8) {
               System.err.println("Unable to add cloned data item.");
            }
         }
      }

      return var3;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof XYSeries)) {
         return false;
      } else if(!super.equals(var1)) {
         return false;
      } else {
         XYSeries var2 = (XYSeries)var1;
         return this.maximumItemCount != var2.maximumItemCount?false:(this.autoSort != var2.autoSort?false:(this.allowDuplicateXValues != var2.allowDuplicateXValues?false:ObjectUtilities.equal(this.data, var2.data)));
      }
   }

   public int hashCode() {
      int var1 = super.hashCode();
      var1 = 29 * var1 + (this.data != null?this.data.hashCode():0);
      var1 = 29 * var1 + this.maximumItemCount;
      var1 = 29 * var1 + (this.autoSort?1:0);
      var1 = 29 * var1 + (this.allowDuplicateXValues?1:0);
      return var1;
   }
}
