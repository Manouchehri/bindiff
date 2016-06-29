package org.jfree.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jfree.data.ComparableObjectItem;
import org.jfree.data.general.Series;
import org.jfree.data.general.SeriesException;
import org.jfree.util.ObjectUtilities;

public class ComparableObjectSeries extends Series implements Serializable, Cloneable {
   protected List data;
   private int maximumItemCount;
   private boolean autoSort;
   private boolean allowDuplicateXValues;

   public ComparableObjectSeries(Comparable var1) {
      this(var1, true, true);
   }

   public ComparableObjectSeries(Comparable var1, boolean var2, boolean var3) {
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

   protected void add(Comparable var1, Object var2) {
      this.add(var1, var2, true);
   }

   protected void add(Comparable var1, Object var2, boolean var3) {
      ComparableObjectItem var4 = new ComparableObjectItem(var1, var2);
      this.add(var4, var3);
   }

   protected void add(ComparableObjectItem var1, boolean var2) {
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
               var3 = this.indexOf(var1.getComparable());
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

   public int indexOf(Comparable var1) {
      if(this.autoSort) {
         return Collections.binarySearch(this.data, new ComparableObjectItem(var1, (Object)null));
      } else {
         for(int var2 = 0; var2 < this.data.size(); ++var2) {
            ComparableObjectItem var3 = (ComparableObjectItem)this.data.get(var2);
            if(var3.getComparable().equals(var1)) {
               return var2;
            }
         }

         return -1;
      }
   }

   protected void update(Comparable var1, Object var2) {
      int var3 = this.indexOf(var1);
      if(var3 < 0) {
         throw new SeriesException("No observation for x = " + var1);
      } else {
         ComparableObjectItem var4 = this.getDataItem(var3);
         var4.setObject(var2);
         this.fireSeriesChanged();
      }
   }

   protected void updateByIndex(int var1, Object var2) {
      ComparableObjectItem var3 = this.getDataItem(var1);
      var3.setObject(var2);
      this.fireSeriesChanged();
   }

   protected ComparableObjectItem getDataItem(int var1) {
      return (ComparableObjectItem)this.data.get(var1);
   }

   protected void delete(int var1, int var2) {
      for(int var3 = var1; var3 <= var2; ++var3) {
         this.data.remove(var1);
      }

      this.fireSeriesChanged();
   }

   protected void clear() {
      if(this.data.size() > 0) {
         this.data.clear();
         this.fireSeriesChanged();
      }

   }

   protected ComparableObjectItem remove(int var1) {
      ComparableObjectItem var2 = (ComparableObjectItem)this.data.remove(var1);
      this.fireSeriesChanged();
      return var2;
   }

   public ComparableObjectItem remove(Comparable var1) {
      return this.remove(this.indexOf(var1));
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof ComparableObjectSeries)) {
         return false;
      } else if(!super.equals(var1)) {
         return false;
      } else {
         ComparableObjectSeries var2 = (ComparableObjectSeries)var1;
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
