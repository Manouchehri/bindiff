package org.jfree.data.xy;

import java.io.Serializable;

public class YWithXInterval implements Serializable {
   private double y;
   private double xLow;
   private double xHigh;

   public YWithXInterval(double var1, double var3, double var5) {
      this.y = var1;
      this.xLow = var3;
      this.xHigh = var5;
   }

   public double getY() {
      return this.y;
   }

   public double getXLow() {
      return this.xLow;
   }

   public double getXHigh() {
      return this.xHigh;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof YWithXInterval)) {
         return false;
      } else {
         YWithXInterval var2 = (YWithXInterval)var1;
         return this.y != var2.y?false:(this.xLow != var2.xLow?false:this.xHigh == var2.xHigh);
      }
   }
}
