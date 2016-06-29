package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.ImmutableSortedMap$Builder;

abstract class ImmutableSortedMapFauxverideShim extends ImmutableMap {
   @Deprecated
   public static ImmutableSortedMap$Builder builder() {
      throw new UnsupportedOperationException();
   }

   @Deprecated
   public static ImmutableSortedMap of(Object var0, Object var1) {
      throw new UnsupportedOperationException();
   }

   @Deprecated
   public static ImmutableSortedMap of(Object var0, Object var1, Object var2, Object var3) {
      throw new UnsupportedOperationException();
   }

   @Deprecated
   public static ImmutableSortedMap of(Object var0, Object var1, Object var2, Object var3, Object var4, Object var5) {
      throw new UnsupportedOperationException();
   }

   @Deprecated
   public static ImmutableSortedMap of(Object var0, Object var1, Object var2, Object var3, Object var4, Object var5, Object var6, Object var7) {
      throw new UnsupportedOperationException();
   }

   @Deprecated
   public static ImmutableSortedMap of(Object var0, Object var1, Object var2, Object var3, Object var4, Object var5, Object var6, Object var7, Object var8, Object var9) {
      throw new UnsupportedOperationException();
   }
}
