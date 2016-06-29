package org.jfree.data.xy;

import java.io.Serializable;

public class YInterval implements Serializable {
   private double y;
   private double yLow;
   private double yHigh;

   public YInterval(double var1, double var3, double var5) {
      this.y = var1;
      this.yLow = var3;
      this.yHigh = var5;
   }

   public double getY() {
      return this.y;
   }

   public double getYLow() {
      return this.yLow;
   }

   public double getYHigh() {
      return this.yHigh;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof YInterval)) {
         return false;
      } else {
         YInterval var2 = (YInterval)var1;
         return this.y != var2.y?false:(this.yLow != var2.yLow?false:this.yHigh == var2.yHigh);
      }
   }
}
