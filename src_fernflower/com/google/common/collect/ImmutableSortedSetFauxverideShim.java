package com.google.common.collect;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.ImmutableSortedSet$Builder;

abstract class ImmutableSortedSetFauxverideShim extends ImmutableSet {
   @Deprecated
   public static ImmutableSortedSet$Builder builder() {
      throw new UnsupportedOperationException();
   }

   @Deprecated
   public static ImmutableSortedSet of(Object var0) {
      throw new UnsupportedOperationException();
   }

   @Deprecated
   public static ImmutableSortedSet of(Object var0, Object var1) {
      throw new UnsupportedOperationException();
   }

   @Deprecated
   public static ImmutableSortedSet of(Object var0, Object var1, Object var2) {
      throw new UnsupportedOperationException();
   }

   @Deprecated
   public static ImmutableSortedSet of(Object var0, Object var1, Object var2, Object var3) {
      throw new UnsupportedOperationException();
   }

   @Deprecated
   public static ImmutableSortedSet of(Object var0, Object var1, Object var2, Object var3, Object var4) {
      throw new UnsupportedOperationException();
   }

   @Deprecated
   public static ImmutableSortedSet of(Object var0, Object var1, Object var2, Object var3, Object var4, Object var5, Object... var6) {
      throw new UnsupportedOperationException();
   }

   @Deprecated
   public static ImmutableSortedSet copyOf(Object[] var0) {
      throw new UnsupportedOperationException();
   }
}
