package org.jfree.chart.axis;

import java.awt.geom.Rectangle2D;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.event.AxisChangeEvent;
import org.jfree.data.Range;
import org.jfree.ui.RectangleEdge;

public class ModuloAxis extends NumberAxis {
   private Range fixedRange;
   private double displayStart;
   private double displayEnd;

   public ModuloAxis(String var1, Range var2) {
      super(var1);
      this.fixedRange = var2;
      this.displayStart = 270.0D;
      this.displayEnd = 90.0D;
   }

   public double getDisplayStart() {
      return this.displayStart;
   }

   public double getDisplayEnd() {
      return this.displayEnd;
   }

   public void setDisplayRange(double var1, double var3) {
      this.displayStart = this.mapValueToFixedRange(var1);
      this.displayEnd = this.mapValueToFixedRange(var3);
      if(this.displayStart < this.displayEnd) {
         this.setRange(this.displayStart, this.displayEnd);
      } else {
         this.setRange(this.displayStart, this.fixedRange.getUpperBound() + (this.displayEnd - this.fixedRange.getLowerBound()));
      }

      this.notifyListeners(new AxisChangeEvent(this));
   }

   protected void autoAdjustRange() {
      this.setRange(this.fixedRange, false, false);
   }

   public double valueToJava2D(double var1, Rectangle2D var3, RectangleEdge var4) {
      double var5 = 0.0D;
      double var7 = this.mapValueToFixedRange(var1);
      if(this.displayStart < this.displayEnd) {
         var5 = this.trans(var7, var3, var4);
      } else {
         double var9 = (this.displayStart + this.displayEnd) / 2.0D;
         double var11 = this.fixedRange.getUpperBound() - this.displayStart;
         double var13 = this.displayEnd - this.fixedRange.getLowerBound();
         if(var7 > var9) {
            var5 = this.transStart(var7, var3, var4, var11, var13);
         } else {
            var5 = this.transEnd(var7, var3, var4, var11, var13);
         }
      }

      return var5;
   }

   private double trans(double var1, Rectangle2D var3, RectangleEdge var4) {
      double var5 = 0.0D;
      double var7 = 0.0D;
      if(RectangleEdge.isTopOrBottom(var4)) {
         var5 = var3.getX();
         var7 = var3.getX() + var3.getWidth();
      } else if(RectangleEdge.isLeftOrRight(var4)) {
         var5 = var3.getMaxY();
         var7 = var3.getMaxY() - var3.getHeight();
      }

      return this.isInverted()?var7 - (var1 - this.displayStart) / (this.displayEnd - this.displayStart) * (var7 - var5):var5 + (var1 - this.displayStart) / (this.displayEnd - this.displayStart) * (var7 - var5);
   }

   private double transStart(double var1, Rectangle2D var3, RectangleEdge var4, double var5, double var7) {
      double var9 = 0.0D;
      double var11 = 0.0D;
      if(RectangleEdge.isTopOrBottom(var4)) {
         var9 = var3.getX();
         var11 = var3.getX() + var3.getWidth() * var5 / (var5 + var7);
      } else if(RectangleEdge.isLeftOrRight(var4)) {
         var9 = var3.getMaxY();
         var11 = var3.getMaxY() - var3.getHeight() * var5 / (var5 + var7);
      }

      return this.isInverted()?var11 - (var1 - this.displayStart) / (this.fixedRange.getUpperBound() - this.displayStart) * (var11 - var9):var9 + (var1 - this.displayStart) / (this.fixedRange.getUpperBound() - this.displayStart) * (var11 - var9);
   }

   private double transEnd(double var1, Rectangle2D var3, RectangleEdge var4, double var5, double var7) {
      double var9 = 0.0D;
      double var11 = 0.0D;
      if(RectangleEdge.isTopOrBottom(var4)) {
         var11 = var3.getMaxX();
         var9 = var3.getMaxX() - var3.getWidth() * var7 / (var5 + var7);
      } else if(RectangleEdge.isLeftOrRight(var4)) {
         var11 = var3.getMinY();
         var9 = var3.getMinY() + var3.getHeight() * var7 / (var5 + var7);
      }

      return this.isInverted()?var11 - (var1 - this.fixedRange.getLowerBound()) / (this.displayEnd - this.fixedRange.getLowerBound()) * (var11 - var9):var9 + (var1 - this.fixedRange.getLowerBound()) / (this.displayEnd - this.fixedRange.getLowerBound()) * (var11 - var9);
   }

   private double mapValueToFixedRange(double var1) {
      double var3 = this.fixedRange.getLowerBound();
      double var5 = this.fixedRange.getLength();
      return var1 < var3?var3 + var5 + (var1 - var3) % var5:var3 + (var1 - var3) % var5;
   }

   public double java2DToValue(double var1, Rectangle2D var3, RectangleEdge var4) {
      double var5 = 0.0D;
      if(this.displayStart < this.displayEnd) {
         var5 = super.java2DToValue(var1, var3, var4);
      }

      return var5;
   }

   private double getDisplayLength() {
      return this.displayStart < this.displayEnd?this.displayEnd - this.displayStart:this.fixedRange.getUpperBound() - this.displayStart + (this.displayEnd - this.fixedRange.getLowerBound());
   }

   private double getDisplayCentralValue() {
      return this.mapValueToFixedRange(this.displayStart + this.getDisplayLength() / 2.0D);
   }

   public void resizeRange(double var1) {
      this.resizeRange(var1, this.getDisplayCentralValue());
   }

   public void resizeRange(double var1, double var3) {
      if(var1 > 0.0D) {
         double var5 = this.getDisplayLength() * var1 / 2.0D;
         this.setDisplayRange(var3 - var5, var3 + var5);
      } else {
         this.setAutoRange(true);
      }

   }

   public double lengthToJava2D(double var1, Rectangle2D var3, RectangleEdge var4) {
      double var5 = 0.0D;
      if(this.displayEnd > this.displayStart) {
         var5 = this.displayEnd - this.displayStart;
      } else {
         var5 = this.fixedRange.getUpperBound() - this.displayStart + (this.displayEnd - this.fixedRange.getLowerBound());
      }

      double var7 = 0.0D;
      if(RectangleEdge.isLeftOrRight(var4)) {
         var7 = var3.getHeight();
      } else {
         var7 = var3.getWidth();
      }

      return var1 / var5 * var7;
   }
}
