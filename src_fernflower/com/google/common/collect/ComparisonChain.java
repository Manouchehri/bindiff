package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ComparisonChain$1;
import com.google.common.collect.ComparisonChain$InactiveComparisonChain;
import java.util.Comparator;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
@GwtCompatible
public abstract class ComparisonChain {
   private static final ComparisonChain ACTIVE = new ComparisonChain$1();
   private static final ComparisonChain LESS = new ComparisonChain$InactiveComparisonChain(-1);
   private static final ComparisonChain GREATER = new ComparisonChain$InactiveComparisonChain(1);

   private ComparisonChain() {
   }

   public static ComparisonChain start() {
      return ACTIVE;
   }

   public abstract ComparisonChain compare(Comparable var1, Comparable var2);

   public abstract ComparisonChain compare(@Nullable Object var1, @Nullable Object var2, Comparator var3);

   public abstract ComparisonChain compare(int var1, int var2);

   public abstract ComparisonChain compare(long var1, long var3);

   public abstract ComparisonChain compare(float var1, float var2);

   public abstract ComparisonChain compare(double var1, double var3);

   @Deprecated
   public final ComparisonChain compare(Boolean var1, Boolean var2) {
      return this.compareFalseFirst(var1.booleanValue(), var2.booleanValue());
   }

   public abstract ComparisonChain compareTrueFirst(boolean var1, boolean var2);

   public abstract ComparisonChain compareFalseFirst(boolean var1, boolean var2);

   public abstract int result();

   // $FF: synthetic method
   ComparisonChain(ComparisonChain$1 var1) {
      this();
   }

   // $FF: synthetic method
   static ComparisonChain access$100() {
      return LESS;
   }

   // $FF: synthetic method
   static ComparisonChain access$200() {
      return GREATER;
   }

   // $FF: synthetic method
   static ComparisonChain access$300() {
      return ACTIVE;
   }
}
