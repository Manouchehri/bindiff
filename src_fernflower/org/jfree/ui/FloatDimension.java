package org.jfree.ui;

import java.awt.geom.Dimension2D;
import java.io.Serializable;

public class FloatDimension extends Dimension2D implements Serializable {
   private static final long serialVersionUID = 5367882923248086744L;
   private float width;
   private float height;

   public FloatDimension() {
      this.width = 0.0F;
      this.height = 0.0F;
   }

   public FloatDimension(FloatDimension var1) {
      this.width = var1.width;
      this.height = var1.height;
   }

   public FloatDimension(float var1, float var2) {
      this.width = var1;
      this.height = var2;
   }

   public double getWidth() {
      return (double)this.width;
   }

   public double getHeight() {
      return (double)this.height;
   }

   public void setWidth(double var1) {
      this.width = (float)var1;
   }

   public void setHeight(double var1) {
      this.height = (float)var1;
   }

   public void setSize(double var1, double var3) {
      this.setHeight((double)((float)var3));
      this.setWidth((double)((float)var1));
   }

   public Object clone() {
      return super.clone();
   }

   public String toString() {
      return this.getClass().getName() + ":={width=" + this.getWidth() + ", height=" + this.getHeight() + "}";
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof FloatDimension)) {
         return false;
      } else {
         FloatDimension var2 = (FloatDimension)var1;
         return this.height != var2.height?false:this.width == var2.width;
      }
   }

   public int hashCode() {
      int var1 = Float.floatToIntBits(this.width);
      var1 = 29 * var1 + Float.floatToIntBits(this.height);
      return var1;
   }
}
