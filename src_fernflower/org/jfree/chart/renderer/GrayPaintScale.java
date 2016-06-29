package org.jfree.chart.renderer;

import java.awt.Color;
import java.awt.Paint;
import java.io.Serializable;
import org.jfree.chart.renderer.PaintScale;
import org.jfree.util.PublicCloneable;

public class GrayPaintScale implements Serializable, PaintScale, PublicCloneable {
   private double lowerBound;
   private double upperBound;

   public GrayPaintScale() {
      this(0.0D, 1.0D);
   }

   public GrayPaintScale(double var1, double var3) {
      if(var1 >= var3) {
         throw new IllegalArgumentException("Requires lowerBound < upperBound.");
      } else {
         this.lowerBound = var1;
         this.upperBound = var3;
      }
   }

   public double getLowerBound() {
      return this.lowerBound;
   }

   public double getUpperBound() {
      return this.upperBound;
   }

   public Paint getPaint(double var1) {
      double var3 = Math.max(var1, this.lowerBound);
      Math.min(var3, this.upperBound);
      int var5 = (int)((var1 - this.lowerBound) / (this.upperBound - this.lowerBound) * 255.0D);
      return new Color(var5, var5, var5);
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof GrayPaintScale)) {
         return false;
      } else {
         GrayPaintScale var2 = (GrayPaintScale)var1;
         return this.lowerBound != var2.lowerBound?false:this.upperBound == var2.upperBound;
      }
   }

   public Object clone() {
      return super.clone();
   }
}
