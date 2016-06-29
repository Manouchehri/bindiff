package org.jfree.data.xy;

import java.io.Serializable;

public class XYInterval implements Serializable {
   private double xLow;
   private double xHigh;
   private double y;
   private double yLow;
   private double yHigh;

   public XYInterval(double var1, double var3, double var5, double var7, double var9) {
      this.xLow = var1;
      this.xHigh = var3;
      this.y = var5;
      this.yLow = var7;
      this.yHigh = var9;
   }

   public double getXLow() {
      return this.xLow;
   }

   public double getXHigh() {
      return this.xHigh;
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
      } else if(!(var1 instanceof XYInterval)) {
         return false;
      } else {
         XYInterval var2 = (XYInterval)var1;
         return this.xLow != var2.xLow?false:(this.xHigh != var2.xHigh?false:(this.y != var2.y?false:(this.yLow != var2.yLow?false:this.yHigh == var2.yHigh)));
      }
   }
}
