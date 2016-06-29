package org.jfree.chart.axis;

import java.io.Serializable;

public abstract class TickUnit implements Serializable, Comparable {
   private static final long serialVersionUID = 510179855057013974L;
   private double size;

   public TickUnit(double var1) {
      this.size = var1;
   }

   public double getSize() {
      return this.size;
   }

   public String valueToString(double var1) {
      return String.valueOf(var1);
   }

   public int compareTo(Object var1) {
      if(var1 instanceof TickUnit) {
         TickUnit var2 = (TickUnit)var1;
         return this.size > var2.getSize()?1:(this.size < var2.getSize()?-1:0);
      } else {
         return -1;
      }
   }

   public boolean equals(Object var1) {
      if(var1 == null) {
         return false;
      } else if(var1 == this) {
         return true;
      } else if(var1 instanceof TickUnit) {
         TickUnit var2 = (TickUnit)var1;
         return this.size == var2.size;
      } else {
         return false;
      }
   }

   public int hashCode() {
      long var1 = this.size != 0.0D?Double.doubleToLongBits(this.size):0L;
      return (int)(var1 ^ var1 >>> 32);
   }
}
