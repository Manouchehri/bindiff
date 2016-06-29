package com.google.common.math;

import com.google.common.base.Preconditions;
import com.google.common.math.LongMath;
import com.google.common.math.Quantiles;
import com.google.common.math.Quantiles$1;
import com.google.common.primitives.Doubles;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Quantiles$ScaleAndIndexes {
   private final int scale;
   private final int[] indexes;

   private Quantiles$ScaleAndIndexes(int var1, int[] var2) {
      int[] var3 = var2;
      int var4 = var2.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         int var6 = var3[var5];
         Quantiles.access$300(var6, var1);
      }

      this.scale = var1;
      this.indexes = var2;
   }

   public Map compute(Collection var1) {
      return this.computeInPlace(Doubles.toArray(var1));
   }

   public Map compute(double... var1) {
      return this.computeInPlace((double[])var1.clone());
   }

   public Map compute(long... var1) {
      return this.computeInPlace(Quantiles.access$400(var1));
   }

   public Map compute(int... var1) {
      return this.computeInPlace(Quantiles.access$500(var1));
   }

   public Map computeInPlace(double... var1) {
      Preconditions.checkArgument(var1.length > 0, "Cannot calculate quantiles of an empty dataset");
      int[] var2 = new int[this.indexes.length];
      int[] var3 = new int[this.indexes.length];
      int[] var4 = new int[this.indexes.length * 2];
      int var5 = 0;

      int var9;
      for(int var6 = 0; var6 < this.indexes.length; ++var6) {
         long var7 = (long)this.indexes[var6] * (long)(var1.length - 1);
         var9 = (int)LongMath.divide(var7, (long)this.scale, RoundingMode.DOWN);
         int var10 = (int)(var7 - (long)var9 * (long)this.scale);
         var2[var6] = var9;
         var3[var6] = var10;
         var4[var5] = var9;
         ++var5;
         if(var10 != 0) {
            var4[var5] = var9 + 1;
            ++var5;
         }
      }

      Arrays.sort(var4, 0, var5);
      Quantiles.access$700(var4, 0, var5 - 1, var1, 0, var1.length - 1);
      HashMap var12 = new HashMap();

      for(int var13 = 0; var13 < this.indexes.length; ++var13) {
         int var8 = var2[var13];
         var9 = var3[var13];
         if(var9 == 0) {
            var12.put(Integer.valueOf(this.indexes[var13]), Double.valueOf(var1[var8]));
         } else {
            double var14 = (double)var9 / (double)this.scale;
            var12.put(Integer.valueOf(this.indexes[var13]), Double.valueOf(var1[var8] + var14 * (var1[var8 + 1] - var1[var8])));
         }
      }

      return Collections.unmodifiableMap(var12);
   }

   // $FF: synthetic method
   Quantiles$ScaleAndIndexes(int var1, int[] var2, Quantiles$1 var3) {
      this(var1, var2);
   }
}
