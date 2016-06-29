package org.jfree.data.time;

import java.io.Serializable;
import org.jfree.data.time.TimePeriod;

public class TimePeriodValue implements Serializable, Cloneable {
   private static final long serialVersionUID = 3390443360845711275L;
   private TimePeriod period;
   private Number value;

   public TimePeriodValue(TimePeriod var1, Number var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'period\' argument.");
      } else {
         this.period = var1;
         this.value = var2;
      }
   }

   public TimePeriodValue(TimePeriod var1, double var2) {
      this(var1, new Double(var2));
   }

   public TimePeriod getPeriod() {
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
      } else if(!(var1 instanceof TimePeriodValue)) {
         return false;
      } else {
         TimePeriodValue var2 = (TimePeriodValue)var1;
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
