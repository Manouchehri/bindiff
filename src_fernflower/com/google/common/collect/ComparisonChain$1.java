package com.google.common.collect;

import com.google.common.collect.ComparisonChain;
import com.google.common.primitives.Booleans;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.util.Comparator;
import javax.annotation.Nullable;

final class ComparisonChain$1 extends ComparisonChain {
   ComparisonChain$1() {
      super((ComparisonChain$1)null);
   }

   public ComparisonChain compare(Comparable var1, Comparable var2) {
      return this.classify(var1.compareTo(var2));
   }

   public ComparisonChain compare(@Nullable Object var1, @Nullable Object var2, Comparator var3) {
      return this.classify(var3.compare(var1, var2));
   }

   public ComparisonChain compare(int var1, int var2) {
      return this.classify(Ints.compare(var1, var2));
   }

   public ComparisonChain compare(long var1, long var3) {
      return this.classify(Longs.compare(var1, var3));
   }

   public ComparisonChain compare(float var1, float var2) {
      return this.classify(Float.compare(var1, var2));
   }

   public ComparisonChain compare(double var1, double var3) {
      return this.classify(Double.compare(var1, var3));
   }

   public ComparisonChain compareTrueFirst(boolean var1, boolean var2) {
      return this.classify(Booleans.compare(var2, var1));
   }

   public ComparisonChain compareFalseFirst(boolean var1, boolean var2) {
      return this.classify(Booleans.compare(var1, var2));
   }

   ComparisonChain classify(int var1) {
      return var1 < 0?ComparisonChain.access$100():(var1 > 0?ComparisonChain.access$200():ComparisonChain.access$300());
   }

   public int result() {
      return 0;
   }
}
