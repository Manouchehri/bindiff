package com.google.common.collect;

import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSortedMultiset;
import com.google.common.collect.ImmutableSortedMultiset$Builder;

abstract class ImmutableSortedMultisetFauxverideShim extends ImmutableMultiset {
   @Deprecated
   public static ImmutableSortedMultiset$Builder builder() {
      throw new UnsupportedOperationException();
   }

   @Deprecated
   public static ImmutableSortedMultiset of(Object var0) {
      throw new UnsupportedOperationException();
   }

   @Deprecated
   public static ImmutableSortedMultiset of(Object var0, Object var1) {
      throw new UnsupportedOperationException();
   }

   @Deprecated
   public static ImmutableSortedMultiset of(Object var0, Object var1, Object var2) {
      throw new UnsupportedOperationException();
   }

   @Deprecated
   public static ImmutableSortedMultiset of(Object var0, Object var1, Object var2, Object var3) {
      throw new UnsupportedOperationException();
   }

   @Deprecated
   public static ImmutableSortedMultiset of(Object var0, Object var1, Object var2, Object var3, Object var4) {
      throw new UnsupportedOperationException();
   }

   @Deprecated
   public static ImmutableSortedMultiset of(Object var0, Object var1, Object var2, Object var3, Object var4, Object var5, Object... var6) {
      throw new UnsupportedOperationException();
   }

   @Deprecated
   public static ImmutableSortedMultiset copyOf(Object[] var0) {
      throw new UnsupportedOperationException();
   }
}
