package org.jfree.data.time;

import java.io.Serializable;
import org.jfree.data.time.RegularTimePeriod;

public class TimeSeriesDataItem implements Serializable, Cloneable, Comparable {
   private static final long serialVersionUID = -2235346966016401302L;
   private RegularTimePeriod period;
   private Number value;

   public TimeSeriesDataItem(RegularTimePeriod var1, Number var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'period\' argument.");
      } else {
         this.period = var1;
         this.value = var2;
      }
   }

   public TimeSeriesDataItem(RegularTimePeriod var1, double var2) {
      this(var1, new Double(var2));
   }

   public RegularTimePeriod getPeriod() {
      return this.period;
   }

   public Number getValue() {
      return this.value;
   }

   public void setValue(Number var1) {
      this.value = var1;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof TimeSeriesDataItem)) {
         return false;
      } else {
         TimeSeriesDataItem var2 = (TimeSeriesDataItem)var1;
         if(this.period != null) {
            if(!this.period.equals(var2.period)) {
               return false;
            }
         } else if(var2.period != null) {
            return false;
         }

         if(this.value != null) {
            if(!this.value.equals(var2.value)) {
               return false;
            }
         } else if(var2.value != null) {
            return false;
         }

         return true;
      }
   }

   public int hashCode() {
      int var1 = this.period != null?this.period.hashCode():0;
      var1 = 29 * var1 + (this.value != null?this.value.hashCode():0);
      return var1;
   }

   public int compareTo(Object var1) {
      int var2;
      if(var1 instanceof TimeSeriesDataItem) {
         TimeSeriesDataItem var3 = (TimeSeriesDataItem)var1;
         var2 = this.getPeriod().compareTo(var3.getPeriod());
      } else {
         var2 = 1;
      }

      return var2;
   }

   public Object clone() {
      Object var1 = null;

      try {
         var1 = super.clone();
      } catch (CloneNotSupportedException var3) {
         var3.printStackTrace();
      }

      return var1;
   }
}
