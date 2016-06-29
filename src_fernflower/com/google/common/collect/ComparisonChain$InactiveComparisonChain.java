package com.google.common.collect;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.ComparisonChain$1;
import java.util.Comparator;
import javax.annotation.Nullable;

final class ComparisonChain$InactiveComparisonChain extends ComparisonChain {
   final int result;

   ComparisonChain$InactiveComparisonChain(int var1) {
      super((ComparisonChain$1)null);
      this.result = var1;
   }

   public ComparisonChain compare(@Nullable Comparable var1, @Nullable Comparable var2) {
      return this;
   }

   public ComparisonChain compare(@Nullable Object var1, @Nullable Object var2, @Nullable Comparator var3) {
      return this;
   }

   public ComparisonChain compare(int var1, int var2) {
      return this;
   }

   public ComparisonChain compare(long var1, long var3) {
      return this;
   }

   public ComparisonChain compare(float var1, float var2) {
      return this;
   }

   public ComparisonChain compare(double var1, double var3) {
      return this;
   }

   public ComparisonChain compareTrueFirst(boolean var1, boolean var2) {
      return this;
   }

   public ComparisonChain compareFalseFirst(boolean var1, boolean var2) {
      return this;
   }

   public int result() {
      return this.result;
   }
}
