package org.jfree.data;

import java.io.Serializable;

public class Range implements Serializable {
   private static final long serialVersionUID = -906333695431863380L;
   private double lower;
   private double upper;

   public strictfp Range(double var1, double var3) {
      if(var1 > var3) {
         String var5 = "Range(double, double): require lower (" + var1 + ") <= upper (" + var3 + ").";
         throw new IllegalArgumentException(var5);
      } else {
         this.lower = var1;
         this.upper = var3;
      }
   }

   public strictfp double getLowerBound() {
      return this.lower;
   }

   public strictfp double getUpperBound() {
      return this.upper;
   }

   public strictfp double getLength() {
      return this.upper - this.lower;
   }

   public strictfp double getCentralValue() {
      return this.lower / 2.0D + this.upper / 2.0D;
   }

   public strictfp boolean contains(double var1) {
      return var1 >= this.lower && var1 <= this.upper;
   }

   public strictfp boolean intersects(double var1, double var3) {
      return var1 <= this.lower?var3 > this.lower:var1 < this.upper && var3 >= var1;
   }

   public strictfp double constrain(double var1) {
      double var3 = var1;
      if(!this.contains(var1)) {
         if(var1 > this.upper) {
            var3 = this.upper;
         } else if(var1 < this.lower) {
            var3 = this.lower;
         }
      }

      return var3;
   }

   public static strictfp Range combine(Range var0, Range var1) {
      if(var0 == null) {
         return var1;
      } else if(var1 == null) {
         return var0;
      } else {
         double var2 = Math.min(var0.getLowerBound(), var1.getLowerBound());
         double var4 = Math.max(var0.getUpperBound(), var1.getUpperBound());
         return new Range(var2, var4);
      }
   }

   public static strictfp Range expandToInclude(Range var0, double var1) {
      return var0 == null?new Range(var1, var1):(var1 < var0.getLowerBound()?new Range(var1, var0.getUpperBound()):(var1 > var0.getUpperBound()?new Range(var0.getLowerBound(), var1):var0));
   }

   public static strictfp Range expand(Range var0, double var1, double var3) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'range\' argument.");
      } else {
         double var5 = var0.getLength();
         double var7 = var5 * var1;
         double var9 = var5 * var3;
         return new Range(var0.getLowerBound() - var7, var0.getUpperBound() + var9);
      }
   }

   public static strictfp Range shift(Range var0, double var1) {
      return shift(var0, var1, false);
   }

   public static strictfp Range shift(Range var0, double var1, boolean var3) {
      return var3?new Range(var0.getLowerBound() + var1, var0.getUpperBound() + var1):new Range(shiftWithNoZeroCrossing(var0.getLowerBound(), var1), shiftWithNoZeroCrossing(var0.getUpperBound(), var1));
   }

   private static strictfp double shiftWithNoZeroCrossing(double var0, double var2) {
      return var0 > 0.0D?Math.max(var0 + var2, 0.0D):(var0 < 0.0D?Math.min(var0 + var2, 0.0D):var0 + var2);
   }

   public strictfp boolean equals(Object var1) {
      if(!(var1 instanceof Range)) {
         return false;
      } else {
         Range var2 = (Range)var1;
         return this.lower != var2.lower?false:this.upper == var2.upper;
      }
   }

   public strictfp int hashCode() {
      long var2 = Double.doubleToLongBits(this.lower);
      int var1 = (int)(var2 ^ var2 >>> 32);
      var2 = Double.doubleToLongBits(this.upper);
      var1 = 29 * var1 + (int)(var2 ^ var2 >>> 32);
      return var1;
   }

   public strictfp String toString() {
      return "Range[" + this.lower + "," + this.upper + "]";
   }
}
