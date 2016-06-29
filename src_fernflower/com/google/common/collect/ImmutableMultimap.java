package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.AbstractMultimap;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap$1;
import com.google.common.collect.ImmutableMultimap$2;
import com.google.common.collect.ImmutableMultimap$Builder;
import com.google.common.collect.ImmutableMultimap$EntryCollection;
import com.google.common.collect.ImmutableMultimap$Keys;
import com.google.common.collect.ImmutableMultimap$Values;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;
import com.google.common.collect.UnmodifiableIterator;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible(
   emulated = true
)
public abstract class ImmutableMultimap extends AbstractMultimap implements Serializable {
   final transient ImmutableMap map;
   final transient int size;
   private static final long serialVersionUID = 0L;

   public static ImmutableMultimap of() {
      return ImmutableListMultimap.of();
   }

   public static ImmutableMultimap of(Object var0, Object var1) {
      return ImmutableListMultimap.of(var0, var1);
   }

   public static ImmutableMultimap of(Object var0, Object var1, Object var2, Object var3) {
      return ImmutableListMultimap.of(var0, var1, var2, var3);
   }

   public static ImmutableMultimap of(Object var0, Object var1, Object var2, Object var3, Object var4, Object var5) {
      return ImmutableListMultimap.of(var0, var1, var2, var3, var4, var5);
   }

   public static ImmutableMultimap of(Object var0, Object var1, Object var2, Object var3, Object var4, Object var5, Object var6, Object var7) {
      return ImmutableListMultimap.of(var0, var1, var2, var3, var4, var5, var6, var7);
   }

   public static ImmutableMultimap of(Object var0, Object var1, Object var2, Object var3, Object var4, Object var5, Object var6, Object var7, Object var8, Object var9) {
      return ImmutableListMultimap.of(var0, var1, var2, var3, var4, var5, var6, var7, var8, var9);
   }

   public static ImmutableMultimap$Builder builder() {
      return new ImmutableMultimap$Builder();
   }

   public static ImmutableMultimap copyOf(Multimap var0) {
      if(var0 instanceof ImmutableMultimap) {
         ImmutableMultimap var1 = (ImmutableMultimap)var0;
         if(!var1.isPartialView()) {
            return var1;
         }
      }

      return ImmutableListMultimap.copyOf(var0);
   }

   @Beta
   public static ImmutableMultimap copyOf(Iterable var0) {
      return ImmutableListMultimap.copyOf(var0);
   }

   ImmutableMultimap(ImmutableMap var1, int var2) {
      this.map = var1;
      this.size = var2;
   }

   @Deprecated
   public ImmutableCollection removeAll(Object var1) {
      throw new UnsupportedOperationException();
   }

   @Deprecated
   public ImmutableCollection replaceValues(Object var1, Iterable var2) {
      throw new UnsupportedOperationException();
   }

   @Deprecated
   public void clear() {
      throw new UnsupportedOperationException();
   }

   public abstract ImmutableCollection get(Object var1);

   public abstract ImmutableMultimap inverse();

   @Deprecated
   public boolean put(Object var1, Object var2) {
      throw new UnsupportedOperationException();
   }

   @Deprecated
   public boolean putAll(Object var1, Iterable var2) {
      throw new UnsupportedOperationException();
   }

   @Deprecated
   public boolean putAll(Multimap var1) {
      throw new UnsupportedOperationException();
   }

   @Deprecated
   public boolean remove(Object var1, Object var2) {
      throw new UnsupportedOperationException();
   }

   boolean isPartialView() {
      return this.map.isPartialView();
   }

   public boolean containsKey(@Nullable Object var1) {
      return this.map.containsKey(var1);
   }

   public boolean containsValue(@Nullable Object var1) {
      return var1 != null && super.containsValue(var1);
   }

   public int size() {
      return this.size;
   }

   public ImmutableSet keySet() {
      return this.map.keySet();
   }

   public ImmutableMap asMap() {
      return this.map;
   }

   Map createAsMap() {
      throw new AssertionError("should never be called");
   }

   public ImmutableCollection entries() {
      return (ImmutableCollection)super.entries();
   }

   ImmutableCollection createEntries() {
      return new ImmutableMultimap$EntryCollection(this);
   }

   UnmodifiableIterator entryIterator() {
      return new ImmutableMultimap$1(this);
   }

   public ImmutableMultiset keys() {
      return (ImmutableMultiset)super.keys();
   }

   ImmutableMultiset createKeys() {
      return new ImmutableMultimap$Keys(this);
   }

   public ImmutableCollection values() {
      return (ImmutableCollection)super.values();
   }

   ImmutableCollection createValues() {
      return new ImmutableMultimap$Values(this);
   }

   UnmodifiableIterator valueIterator() {
      return new ImmutableMultimap$2(this);
   }
}
