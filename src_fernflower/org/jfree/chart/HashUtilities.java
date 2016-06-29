package org.jfree.chart;

import java.awt.GradientPaint;
import java.awt.Paint;

public class HashUtilities {
   public static int hashCodeForPaint(Paint var0) {
      if(var0 == null) {
         return 0;
      } else {
         boolean var1 = false;
         int var4;
         if(var0 instanceof GradientPaint) {
            GradientPaint var2 = (GradientPaint)var0;
            short var3 = 193;
            var4 = 37 * var3 + var2.getColor1().hashCode();
            var4 = 37 * var4 + var2.getPoint1().hashCode();
            var4 = 37 * var4 + var2.getColor2().hashCode();
            var4 = 37 * var4 + var2.getPoint2().hashCode();
         } else {
            var4 = var0.hashCode();
         }

         return var4;
      }
   }

   public static int hashCodeForDoubleArray(double[] var0) {
      if(var0 == null) {
         return 0;
      } else {
         int var1 = 193;

         for(int var4 = 0; var4 < var0.length; ++var4) {
            long var2 = Double.doubleToLongBits(var0[var4]);
            var1 = 29 * var1 + (int)(var2 ^ var2 >>> 32);
         }

         return var1;
      }
   }
}
