package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableEnumMap;
import com.google.common.collect.ImmutableMap$1;
import com.google.common.collect.ImmutableMap$Builder;
import com.google.common.collect.ImmutableMap$MapViewOfValuesAsSingletonSets;
import com.google.common.collect.ImmutableMap$SerializedForm;
import com.google.common.collect.ImmutableMapEntry;
import com.google.common.collect.ImmutableMapKeySet;
import com.google.common.collect.ImmutableMapValues;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableMap;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible(
   serializable = true,
   emulated = true
)
public abstract class ImmutableMap implements Serializable, Map {
   static final Entry[] EMPTY_ENTRY_ARRAY = new Entry[0];
   @LazyInit
   private transient ImmutableSet entrySet;
   @LazyInit
   private transient ImmutableSet keySet;
   @LazyInit
   private transient ImmutableCollection values;
   @LazyInit
   private transient ImmutableSetMultimap multimapView;

   public static ImmutableMap of() {
      return ImmutableBiMap.of();
   }

   public static ImmutableMap of(Object var0, Object var1) {
      return ImmutableBiMap.of(var0, var1);
   }

   public static ImmutableMap of(Object var0, Object var1, Object var2, Object var3) {
      return RegularImmutableMap.fromEntries(new Entry[]{entryOf(var0, var1), entryOf(var2, var3)});
   }

   public static ImmutableMap of(Object var0, Object var1, Object var2, Object var3, Object var4, Object var5) {
      return RegularImmutableMap.fromEntries(new Entry[]{entryOf(var0, var1), entryOf(var2, var3), entryOf(var4, var5)});
   }

   public static ImmutableMap of(Object var0, Object var1, Object var2, Object var3, Object var4, Object var5, Object var6, Object var7) {
      return RegularImmutableMap.fromEntries(new Entry[]{entryOf(var0, var1), entryOf(var2, var3), entryOf(var4, var5), entryOf(var6, var7)});
   }

   public static ImmutableMap of(Object var0, Object var1, Object var2, Object var3, Object var4, Object var5, Object var6, Object var7, Object var8, Object var9) {
      return RegularImmutableMap.fromEntries(new Entry[]{entryOf(var0, var1), entryOf(var2, var3), entryOf(var4, var5), entryOf(var6, var7), entryOf(var8, var9)});
   }

   static ImmutableMapEntry entryOf(Object var0, Object var1) {
      return new ImmutableMapEntry(var0, var1);
   }

   public static ImmutableMap$Builder builder() {
      return new ImmutableMap$Builder();
   }

   static void checkNoConflict(boolean var0, String var1, Entry var2, Entry var3) {
      if(!var0) {
         String var4 = String.valueOf(var2);
         String var5 = String.valueOf(var3);
         throw new IllegalArgumentException((new StringBuilder(34 + String.valueOf(var1).length() + String.valueOf(var4).length() + String.valueOf(var5).length())).append("Multiple entries with same ").append(var1).append(": ").append(var4).append(" and ").append(var5).toString());
      }
   }

   public static ImmutableMap copyOf(Map var0) {
      ImmutableMap var1;
      if(var0 instanceof ImmutableMap && !(var0 instanceof ImmutableSortedMap)) {
         var1 = (ImmutableMap)var0;
         if(!var1.isPartialView()) {
            return var1;
         }
      } else if(var0 instanceof EnumMap) {
         var1 = copyOfEnumMap((EnumMap)var0);
         return var1;
      }

      return copyOf((Iterable)var0.entrySet());
   }

   @Beta
   public static ImmutableMap copyOf(Iterable var0) {
      Entry[] var1 = (Entry[])((Entry[])Iterables.toArray(var0, (Object[])EMPTY_ENTRY_ARRAY));
      switch(var1.length) {
      case 0:
         return of();
      case 1:
         Entry var2 = var1[0];
         return of(var2.getKey(), var2.getValue());
      default:
         return RegularImmutableMap.fromEntries(var1);
      }
   }

   private static ImmutableMap copyOfEnumMap(EnumMap var0) {
      EnumMap var1 = new EnumMap(var0);
      Iterator var2 = var1.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         CollectPreconditions.checkEntryNotNull(var3.getKey(), var3.getValue());
      }

      return ImmutableEnumMap.asImmutable(var1);
   }

   @Deprecated
   public final Object put(Object var1, Object var2) {
      throw new UnsupportedOperationException();
   }

   @Deprecated
   public final Object remove(Object var1) {
      throw new UnsupportedOperationException();
   }

   @Deprecated
   public final void putAll(Map var1) {
      throw new UnsupportedOperationException();
   }

   @Deprecated
   public final void clear() {
      throw new UnsupportedOperationException();
   }

   public boolean isEmpty() {
      return this.size() == 0;
   }

   public boolean containsKey(@Nullable Object var1) {
      return this.get(var1) != null;
   }

   public boolean containsValue(@Nullable Object var1) {
      return this.values().contains(var1);
   }

   public abstract Object get(@Nullable Object var1);

   public ImmutableSet entrySet() {
      ImmutableSet var1 = this.entrySet;
      return var1 == null?(this.entrySet = this.createEntrySet()):var1;
   }

   abstract ImmutableSet createEntrySet();

   public ImmutableSet keySet() {
      ImmutableSet var1 = this.keySet;
      return var1 == null?(this.keySet = this.createKeySet()):var1;
   }

   ImmutableSet createKeySet() {
      return (ImmutableSet)(this.isEmpty()?ImmutableSet.of():new ImmutableMapKeySet(this));
   }

   UnmodifiableIterator keyIterator() {
      UnmodifiableIterator var1 = this.entrySet().iterator();
      return new ImmutableMap$1(this, var1);
   }

   public ImmutableCollection values() {
      ImmutableCollection var1 = this.values;
      return var1 == null?(this.values = new ImmutableMapValues(this)):var1;
   }

   @Beta
   public ImmutableSetMultimap asMultimap() {
      if(this.isEmpty()) {
         return ImmutableSetMultimap.of();
      } else {
         ImmutableSetMultimap var1 = this.multimapView;
         return var1 == null?(this.multimapView = new ImmutableSetMultimap(new ImmutableMap$MapViewOfValuesAsSingletonSets(this, (ImmutableMap$1)null), this.size(), (Comparator)null)):var1;
      }
   }

   public boolean equals(@Nullable Object var1) {
      return Maps.equalsImpl(this, var1);
   }

   abstract boolean isPartialView();

   public int hashCode() {
      return Sets.hashCodeImpl(this.entrySet());
   }

   boolean isHashCodeFast() {
      return false;
   }

   public String toString() {
      return Maps.toStringImpl(this);
   }

   Object writeReplace() {
      return new ImmutableMap$SerializedForm(this);
   }
}
