package org.jfree.data.xy;

import java.io.Serializable;

class WindDataItem implements Serializable, Comparable {
   private Number x;
   private Number windDir;
   private Number windForce;

   public WindDataItem(Number var1, Number var2, Number var3) {
      this.x = var1;
      this.windDir = var2;
      this.windForce = var3;
   }

   public Number getX() {
      return this.x;
   }

   public Number getWindDirection() {
      return this.windDir;
   }

   public Number getWindForce() {
      return this.windForce;
   }

   public int compareTo(Object var1) {
      if(var1 instanceof WindDataItem) {
         WindDataItem var2 = (WindDataItem)var1;
         return this.x.doubleValue() > var2.x.doubleValue()?1:(this.x.equals(var2.x)?0:-1);
      } else {
         throw new ClassCastException("WindDataItem.compareTo(error)");
      }
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return false;
      } else if(!(var1 instanceof WindDataItem)) {
         return false;
      } else {
         WindDataItem var2 = (WindDataItem)var1;
         return !this.x.equals(var2.x)?false:(!this.windDir.equals(var2.windDir)?false:this.windForce.equals(var2.windForce));
      }
   }
}
