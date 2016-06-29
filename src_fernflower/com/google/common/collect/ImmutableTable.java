package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractTable;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet$Builder;
import com.google.common.collect.ImmutableTable$Builder;
import com.google.common.collect.Iterables;
import com.google.common.collect.RegularImmutableTable;
import com.google.common.collect.SingletonImmutableTable;
import com.google.common.collect.SparseImmutableTable;
import com.google.common.collect.Table;
import com.google.common.collect.Table$Cell;
import com.google.common.collect.Tables;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ImmutableTable extends AbstractTable {
   private static final ImmutableTable EMPTY = new SparseImmutableTable(ImmutableList.of(), ImmutableSet.of(), ImmutableSet.of());

   public static ImmutableTable of() {
      return EMPTY;
   }

   public static ImmutableTable of(Object var0, Object var1, Object var2) {
      return new SingletonImmutableTable(var0, var1, var2);
   }

   public static ImmutableTable copyOf(Table var0) {
      if(var0 instanceof ImmutableTable) {
         ImmutableTable var6 = (ImmutableTable)var0;
         return var6;
      } else {
         int var1 = var0.size();
         switch(var1) {
         case 0:
            return of();
         case 1:
            Table$Cell var2 = (Table$Cell)Iterables.getOnlyElement(var0.cellSet());
            return of(var2.getRowKey(), var2.getColumnKey(), var2.getValue());
         default:
            ImmutableSet$Builder var3 = new ImmutableSet$Builder(var1);
            Iterator var4 = var0.cellSet().iterator();

            while(var4.hasNext()) {
               Table$Cell var5 = (Table$Cell)var4.next();
               var3.add((Object)cellOf(var5.getRowKey(), var5.getColumnKey(), var5.getValue()));
            }

            return RegularImmutableTable.forCells(var3.build());
         }
      }
   }

   public static ImmutableTable$Builder builder() {
      return new ImmutableTable$Builder();
   }

   static Table$Cell cellOf(Object var0, Object var1, Object var2) {
      return Tables.immutableCell(Preconditions.checkNotNull(var0), Preconditions.checkNotNull(var1), Preconditions.checkNotNull(var2));
   }

   public ImmutableSet cellSet() {
      return (ImmutableSet)super.cellSet();
   }

   abstract ImmutableSet createCellSet();

   final UnmodifiableIterator cellIterator() {
      throw new AssertionError("should never be called");
   }

   public ImmutableCollection values() {
      return (ImmutableCollection)super.values();
   }

   abstract ImmutableCollection createValues();

   final Iterator valuesIterator() {
      throw new AssertionError("should never be called");
   }

   public ImmutableMap column(Object var1) {
      Preconditions.checkNotNull(var1);
      return (ImmutableMap)MoreObjects.firstNonNull((ImmutableMap)this.columnMap().get(var1), ImmutableMap.of());
   }

   public ImmutableSet columnKeySet() {
      return this.columnMap().keySet();
   }

   public abstract ImmutableMap columnMap();

   public ImmutableMap row(Object var1) {
      Preconditions.checkNotNull(var1);
      return (ImmutableMap)MoreObjects.firstNonNull((ImmutableMap)this.rowMap().get(var1), ImmutableMap.of());
   }

   public ImmutableSet rowKeySet() {
      return this.rowMap().keySet();
   }

   public abstract ImmutableMap rowMap();

   public boolean contains(@Nullable Object var1, @Nullable Object var2) {
      return this.get(var1, var2) != null;
   }

   public boolean containsValue(@Nullable Object var1) {
      return this.values().contains(var1);
   }

   @Deprecated
   public final void clear() {
      throw new UnsupportedOperationException();
   }

   @Deprecated
   public final Object put(Object var1, Object var2, Object var3) {
      throw new UnsupportedOperationException();
   }

   @Deprecated
   public final void putAll(Table var1) {
      throw new UnsupportedOperationException();
   }

   @Deprecated
   public final Object remove(Object var1, Object var2) {
      throw new UnsupportedOperationException();
   }
}
