package org.jfree.ui;

import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.ui.LengthAdjustmentType;
import org.jfree.util.UnitType;

public class RectangleInsets implements Serializable {
   private static final long serialVersionUID = 1902273207559319996L;
   public static final RectangleInsets ZERO_INSETS;
   private UnitType unitType;
   private double top;
   private double left;
   private double bottom;
   private double right;

   public RectangleInsets() {
      this(1.0D, 1.0D, 1.0D, 1.0D);
   }

   public RectangleInsets(double var1, double var3, double var5, double var7) {
      this(UnitType.ABSOLUTE, var1, var3, var5, var7);
   }

   public RectangleInsets(UnitType var1, double var2, double var4, double var6, double var8) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'unitType\' argument.");
      } else {
         this.unitType = var1;
         this.top = var2;
         this.bottom = var6;
         this.left = var4;
         this.right = var8;
      }
   }

   public UnitType getUnitType() {
      return this.unitType;
   }

   public double getTop() {
      return this.top;
   }

   public double getBottom() {
      return this.bottom;
   }

   public double getLeft() {
      return this.left;
   }

   public double getRight() {
      return this.right;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof RectangleInsets)) {
         return false;
      } else {
         RectangleInsets var2 = (RectangleInsets)var1;
         return var2.unitType != this.unitType?false:(this.left != var2.left?false:(this.right != var2.right?false:(this.top != var2.top?false:this.bottom == var2.bottom)));
      }
   }

   public int hashCode() {
      int var1 = this.unitType != null?this.unitType.hashCode():0;
      long var2 = this.top != 0.0D?Double.doubleToLongBits(this.top):0L;
      var1 = 29 * var1 + (int)(var2 ^ var2 >>> 32);
      var2 = this.bottom != 0.0D?Double.doubleToLongBits(this.bottom):0L;
      var1 = 29 * var1 + (int)(var2 ^ var2 >>> 32);
      var2 = this.left != 0.0D?Double.doubleToLongBits(this.left):0L;
      var1 = 29 * var1 + (int)(var2 ^ var2 >>> 32);
      var2 = this.right != 0.0D?Double.doubleToLongBits(this.right):0L;
      var1 = 29 * var1 + (int)(var2 ^ var2 >>> 32);
      return var1;
   }

   public String toString() {
      return "RectangleInsets[t=" + this.top + ",l=" + this.left + ",b=" + this.bottom + ",r=" + this.right + "]";
   }

   public Rectangle2D createAdjustedRectangle(Rectangle2D var1, LengthAdjustmentType var2, LengthAdjustmentType var3) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'base\' argument.");
      } else {
         double var4 = var1.getX();
         double var6 = var1.getY();
         double var8 = var1.getWidth();
         double var10 = var1.getHeight();
         double var12;
         if(var2 == LengthAdjustmentType.EXPAND) {
            var12 = this.calculateLeftOutset(var8);
            var4 -= var12;
            var8 = var8 + var12 + this.calculateRightOutset(var8);
         } else if(var2 == LengthAdjustmentType.CONTRACT) {
            var12 = this.calculateLeftInset(var8);
            var4 += var12;
            var8 = var8 - var12 - this.calculateRightInset(var8);
         }

         if(var3 == LengthAdjustmentType.EXPAND) {
            var12 = this.calculateTopOutset(var10);
            var6 -= var12;
            var10 = var10 + var12 + this.calculateBottomOutset(var10);
         } else if(var3 == LengthAdjustmentType.CONTRACT) {
            var12 = this.calculateTopInset(var10);
            var6 += var12;
            var10 = var10 - var12 - this.calculateBottomInset(var10);
         }

         return new java.awt.geom.Rectangle2D.Double(var4, var6, var8, var10);
      }
   }

   public Rectangle2D createInsetRectangle(Rectangle2D var1) {
      return this.createInsetRectangle(var1, true, true);
   }

   public Rectangle2D createInsetRectangle(Rectangle2D var1, boolean var2, boolean var3) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'base\' argument.");
      } else {
         double var4 = 0.0D;
         double var6 = 0.0D;
         if(var3) {
            var4 = this.calculateTopInset(var1.getHeight());
            var6 = this.calculateBottomInset(var1.getHeight());
         }

         double var8 = 0.0D;
         double var10 = 0.0D;
         if(var2) {
            var8 = this.calculateLeftInset(var1.getWidth());
            var10 = this.calculateRightInset(var1.getWidth());
         }

         return new java.awt.geom.Rectangle2D.Double(var1.getX() + var8, var1.getY() + var4, var1.getWidth() - var8 - var10, var1.getHeight() - var4 - var6);
      }
   }

   public Rectangle2D createOutsetRectangle(Rectangle2D var1) {
      return this.createOutsetRectangle(var1, true, true);
   }

   public Rectangle2D createOutsetRectangle(Rectangle2D var1, boolean var2, boolean var3) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'base\' argument.");
      } else {
         double var4 = 0.0D;
         double var6 = 0.0D;
         if(var3) {
            var4 = this.calculateTopOutset(var1.getHeight());
            var6 = this.calculateBottomOutset(var1.getHeight());
         }

         double var8 = 0.0D;
         double var10 = 0.0D;
         if(var2) {
            var8 = this.calculateLeftOutset(var1.getWidth());
            var10 = this.calculateRightOutset(var1.getWidth());
         }

         return new java.awt.geom.Rectangle2D.Double(var1.getX() - var8, var1.getY() - var4, var1.getWidth() + var8 + var10, var1.getHeight() + var4 + var6);
      }
   }

   public double calculateTopInset(double var1) {
      double var3 = this.top;
      if(this.unitType == UnitType.RELATIVE) {
         var3 = this.top * var1;
      }

      return var3;
   }

   public double calculateTopOutset(double var1) {
      double var3 = this.top;
      if(this.unitType == UnitType.RELATIVE) {
         var3 = var1 / (1.0D - this.top - this.bottom) * this.top;
      }

      return var3;
   }

   public double calculateBottomInset(double var1) {
      double var3 = this.bottom;
      if(this.unitType == UnitType.RELATIVE) {
         var3 = this.bottom * var1;
      }

      return var3;
   }

   public double calculateBottomOutset(double var1) {
      double var3 = this.bottom;
      if(this.unitType == UnitType.RELATIVE) {
         var3 = var1 / (1.0D - this.top - this.bottom) * this.bottom;
      }

      return var3;
   }

   public double calculateLeftInset(double var1) {
      double var3 = this.left;
      if(this.unitType == UnitType.RELATIVE) {
         var3 = this.left * var1;
      }

      return var3;
   }

   public double calculateLeftOutset(double var1) {
      double var3 = this.left;
      if(this.unitType == UnitType.RELATIVE) {
         var3 = var1 / (1.0D - this.left - this.right) * this.left;
      }

      return var3;
   }

   public double calculateRightInset(double var1) {
      double var3 = this.right;
      if(this.unitType == UnitType.RELATIVE) {
         var3 = this.right * var1;
      }

      return var3;
   }

   public double calculateRightOutset(double var1) {
      double var3 = this.right;
      if(this.unitType == UnitType.RELATIVE) {
         var3 = var1 / (1.0D - this.left - this.right) * this.right;
      }

      return var3;
   }

   public double trimWidth(double var1) {
      return var1 - this.calculateLeftInset(var1) - this.calculateRightInset(var1);
   }

   public double extendWidth(double var1) {
      return var1 + this.calculateLeftOutset(var1) + this.calculateRightOutset(var1);
   }

   public double trimHeight(double var1) {
      return var1 - this.calculateTopInset(var1) - this.calculateBottomInset(var1);
   }

   public double extendHeight(double var1) {
      return var1 + this.calculateTopOutset(var1) + this.calculateBottomOutset(var1);
   }

   public void trim(Rectangle2D var1) {
      double var2 = var1.getWidth();
      double var4 = var1.getHeight();
      double var6 = this.calculateLeftInset(var2);
      double var8 = this.calculateRightInset(var2);
      double var10 = this.calculateTopInset(var4);
      double var12 = this.calculateBottomInset(var4);
      var1.setRect(var1.getX() + var6, var1.getY() + var10, var2 - var6 - var8, var4 - var10 - var12);
   }

   static {
      ZERO_INSETS = new RectangleInsets(UnitType.ABSOLUTE, 0.0D, 0.0D, 0.0D, 0.0D);
   }
}
