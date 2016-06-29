package org.jfree.ui;

import java.io.Serializable;
import org.jfree.util.PublicCloneable;

public class Size2D implements Serializable, Cloneable, PublicCloneable {
   private static final long serialVersionUID = 2558191683786418168L;
   public double width;
   public double height;

   public Size2D() {
      this(0.0D, 0.0D);
   }

   public Size2D(double var1, double var3) {
      this.width = var1;
      this.height = var3;
   }

   public double getWidth() {
      return this.width;
   }

   public void setWidth(double var1) {
      this.width = var1;
   }

   public double getHeight() {
      return this.height;
   }

   public void setHeight(double var1) {
      this.height = var1;
   }

   public String toString() {
      return "Size2D[width=" + this.width + ", height=" + this.height + "]";
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof Size2D)) {
         return false;
      } else {
         Size2D var2 = (Size2D)var1;
         return this.width != var2.width?false:this.height == var2.height;
      }
   }

   public Object clone() {
      return super.clone();
   }
}
