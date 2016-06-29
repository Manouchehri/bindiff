package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap$Builder;
import com.google.common.collect.ImmutableBiMap$SerializedForm;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.RegularImmutableBiMap;
import com.google.common.collect.SingletonImmutableBiMap;
import java.util.Map;
import java.util.Map.Entry;

@GwtCompatible(
   serializable = true,
   emulated = true
)
public abstract class ImmutableBiMap extends ImmutableMap implements BiMap {
   public static ImmutableBiMap of() {
      return RegularImmutableBiMap.EMPTY;
   }

   public static ImmutableBiMap of(Object var0, Object var1) {
      return new SingletonImmutableBiMap(var0, var1);
   }

   public static ImmutableBiMap of(Object var0, Object var1, Object var2, Object var3) {
      return RegularImmutableBiMap.fromEntries(new Entry[]{entryOf(var0, var1), entryOf(var2, var3)});
   }

   public static ImmutableBiMap of(Object var0, Object var1, Object var2, Object var3, Object var4, Object var5) {
      return RegularImmutableBiMap.fromEntries(new Entry[]{entryOf(var0, var1), entryOf(var2, var3), entryOf(var4, var5)});
   }

   public static ImmutableBiMap of(Object var0, Object var1, Object var2, Object var3, Object var4, Object var5, Object var6, Object var7) {
      return RegularImmutableBiMap.fromEntries(new Entry[]{entryOf(var0, var1), entryOf(var2, var3), entryOf(var4, var5), entryOf(var6, var7)});
   }

   public static ImmutableBiMap of(Object var0, Object var1, Object var2, Object var3, Object var4, Object var5, Object var6, Object var7, Object var8, Object var9) {
      return RegularImmutableBiMap.fromEntries(new Entry[]{entryOf(var0, var1), entryOf(var2, var3), entryOf(var4, var5), entryOf(var6, var7), entryOf(var8, var9)});
   }

   public static ImmutableBiMap$Builder builder() {
      return new ImmutableBiMap$Builder();
   }

   public static ImmutableBiMap copyOf(Map var0) {
      if(var0 instanceof ImmutableBiMap) {
         ImmutableBiMap var1 = (ImmutableBiMap)var0;
         if(!var1.isPartialView()) {
            return var1;
         }
      }

      return copyOf((Iterable)var0.entrySet());
   }

   @Beta
   public static ImmutableBiMap copyOf(Iterable var0) {
      Entry[] var1 = (Entry[])((Entry[])Iterables.toArray(var0, (Object[])EMPTY_ENTRY_ARRAY));
      switch(var1.length) {
      case 0:
         return of();
      case 1:
         Entry var2 = var1[0];
         return of(var2.getKey(), var2.getValue());
      default:
         return RegularImmutableBiMap.fromEntries(var1);
      }
   }

   public abstract ImmutableBiMap inverse();

   public ImmutableSet values() {
      return this.inverse().keySet();
   }

   @Deprecated
   public Object forcePut(Object var1, Object var2) {
      throw new UnsupportedOperationException();
   }

   Object writeReplace() {
      return new ImmutableBiMap$SerializedForm(this);
   }
}
