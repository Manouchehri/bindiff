package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractTable;
import com.google.common.collect.ArrayTable$1;
import com.google.common.collect.ArrayTable$Column;
import com.google.common.collect.ArrayTable$ColumnMap;
import com.google.common.collect.ArrayTable$Row;
import com.google.common.collect.ArrayTable$RowMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@Beta
@GwtCompatible(
   emulated = true
)
public final class ArrayTable extends AbstractTable implements Serializable {
   private final ImmutableList rowList;
   private final ImmutableList columnList;
   private final ImmutableMap rowKeyToIndex;
   private final ImmutableMap columnKeyToIndex;
   private final Object[][] array;
   private transient ArrayTable$ColumnMap columnMap;
   private transient ArrayTable$RowMap rowMap;
   private static final long serialVersionUID = 0L;

   public static ArrayTable create(Iterable var0, Iterable var1) {
      return new ArrayTable(var0, var1);
   }

   public static ArrayTable create(Table var0) {
      return var0 instanceof ArrayTable?new ArrayTable((ArrayTable)var0):new ArrayTable(var0);
   }

   private ArrayTable(Iterable var1, Iterable var2) {
      this.rowList = ImmutableList.copyOf(var1);
      this.columnList = ImmutableList.copyOf(var2);
      Preconditions.checkArgument(!this.rowList.isEmpty());
      Preconditions.checkArgument(!this.columnList.isEmpty());
      this.rowKeyToIndex = Maps.indexMap(this.rowList);
      this.columnKeyToIndex = Maps.indexMap(this.columnList);
      Object[][] var3 = (Object[][])(new Object[this.rowList.size()][this.columnList.size()]);
      this.array = var3;
      this.eraseAll();
   }

   private ArrayTable(Table var1) {
      this(var1.rowKeySet(), var1.columnKeySet());
      this.putAll(var1);
   }

   private ArrayTable(ArrayTable var1) {
      this.rowList = var1.rowList;
      this.columnList = var1.columnList;
      this.rowKeyToIndex = var1.rowKeyToIndex;
      this.columnKeyToIndex = var1.columnKeyToIndex;
      Object[][] var2 = (Object[][])(new Object[this.rowList.size()][this.columnList.size()]);
      this.array = var2;
      this.eraseAll();

      for(int var3 = 0; var3 < this.rowList.size(); ++var3) {
         System.arraycopy(var1.array[var3], 0, var2[var3], 0, var1.array[var3].length);
      }

   }

   public ImmutableList rowKeyList() {
      return this.rowList;
   }

   public ImmutableList columnKeyList() {
      return this.columnList;
   }

   public Object at(int var1, int var2) {
      Preconditions.checkElementIndex(var1, this.rowList.size());
      Preconditions.checkElementIndex(var2, this.columnList.size());
      return this.array[var1][var2];
   }

   public Object set(int var1, int var2, @Nullable Object var3) {
      Preconditions.checkElementIndex(var1, this.rowList.size());
      Preconditions.checkElementIndex(var2, this.columnList.size());
      Object var4 = this.array[var1][var2];
      this.array[var1][var2] = var3;
      return var4;
   }

   @GwtIncompatible("reflection")
   public Object[][] toArray(Class var1) {
      Object[][] var2 = (Object[][])((Object[][])Array.newInstance(var1, new int[]{this.rowList.size(), this.columnList.size()}));

      for(int var3 = 0; var3 < this.rowList.size(); ++var3) {
         System.arraycopy(this.array[var3], 0, var2[var3], 0, this.array[var3].length);
      }

      return var2;
   }

   @Deprecated
   public void clear() {
      throw new UnsupportedOperationException();
   }

   public void eraseAll() {
      Object[][] var1 = this.array;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         Object[] var4 = var1[var3];
         Arrays.fill(var4, (Object)null);
      }

   }

   public boolean contains(@Nullable Object var1, @Nullable Object var2) {
      return this.containsRow(var1) && this.containsColumn(var2);
   }

   public boolean containsColumn(@Nullable Object var1) {
      return this.columnKeyToIndex.containsKey(var1);
   }

   public boolean containsRow(@Nullable Object var1) {
      return this.rowKeyToIndex.containsKey(var1);
   }

   public boolean containsValue(@Nullable Object var1) {
      Object[][] var2 = this.array;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Object[] var5 = var2[var4];
         Object[] var6 = var5;
         int var7 = var5.length;

         for(int var8 = 0; var8 < var7; ++var8) {
            Object var9 = var6[var8];
            if(Objects.equal(var1, var9)) {
               return true;
            }
         }
      }

      return false;
   }

   public Object get(@Nullable Object var1, @Nullable Object var2) {
      Integer var3 = (Integer)this.rowKeyToIndex.get(var1);
      Integer var4 = (Integer)this.columnKeyToIndex.get(var2);
      return var3 != null && var4 != null?this.at(var3.intValue(), var4.intValue()):null;
   }

   public boolean isEmpty() {
      return false;
   }

   public Object put(Object var1, Object var2, @Nullable Object var3) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var2);
      Integer var4 = (Integer)this.rowKeyToIndex.get(var1);
      Preconditions.checkArgument(var4 != null, "Row %s not in %s", new Object[]{var1, this.rowList});
      Integer var5 = (Integer)this.columnKeyToIndex.get(var2);
      Preconditions.checkArgument(var5 != null, "Column %s not in %s", new Object[]{var2, this.columnList});
      return this.set(var4.intValue(), var5.intValue(), var3);
   }

   public void putAll(Table var1) {
      super.putAll(var1);
   }

   @Deprecated
   public Object remove(Object var1, Object var2) {
      throw new UnsupportedOperationException();
   }

   public Object erase(@Nullable Object var1, @Nullable Object var2) {
      Integer var3 = (Integer)this.rowKeyToIndex.get(var1);
      Integer var4 = (Integer)this.columnKeyToIndex.get(var2);
      return var3 != null && var4 != null?this.set(var3.intValue(), var4.intValue(), (Object)null):null;
   }

   public int size() {
      return this.rowList.size() * this.columnList.size();
   }

   public Set cellSet() {
      return super.cellSet();
   }

   Iterator cellIterator() {
      return new ArrayTable$1(this, this.size());
   }

   public Map column(Object var1) {
      Preconditions.checkNotNull(var1);
      Integer var2 = (Integer)this.columnKeyToIndex.get(var1);
      return (Map)(var2 == null?ImmutableMap.of():new ArrayTable$Column(this, var2.intValue()));
   }

   public ImmutableSet columnKeySet() {
      return this.columnKeyToIndex.keySet();
   }

   public Map columnMap() {
      ArrayTable$ColumnMap var1 = this.columnMap;
      return var1 == null?(this.columnMap = new ArrayTable$ColumnMap(this, (ArrayTable$1)null)):var1;
   }

   public Map row(Object var1) {
      Preconditions.checkNotNull(var1);
      Integer var2 = (Integer)this.rowKeyToIndex.get(var1);
      return (Map)(var2 == null?ImmutableMap.of():new ArrayTable$Row(this, var2.intValue()));
   }

   public ImmutableSet rowKeySet() {
      return this.rowKeyToIndex.keySet();
   }

   public Map rowMap() {
      ArrayTable$RowMap var1 = this.rowMap;
      return var1 == null?(this.rowMap = new ArrayTable$RowMap(this, (ArrayTable$1)null)):var1;
   }

   public Collection values() {
      return super.values();
   }

   // $FF: synthetic method
   static ImmutableList access$000(ArrayTable var0) {
      return var0.columnList;
   }

   // $FF: synthetic method
   static ImmutableList access$100(ArrayTable var0) {
      return var0.rowList;
   }

   // $FF: synthetic method
   static ImmutableMap access$200(ArrayTable var0) {
      return var0.rowKeyToIndex;
   }

   // $FF: synthetic method
   static ImmutableMap access$500(ArrayTable var0) {
      return var0.columnKeyToIndex;
   }
}
