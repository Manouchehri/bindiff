package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.DenseImmutableTable$1;
import com.google.common.collect.DenseImmutableTable$ColumnMap;
import com.google.common.collect.DenseImmutableTable$RowMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableTable;
import com.google.common.collect.Table$Cell;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@GwtCompatible
@Immutable
final class DenseImmutableTable extends RegularImmutableTable {
   private final ImmutableMap rowKeyToIndex;
   private final ImmutableMap columnKeyToIndex;
   private final ImmutableMap rowMap;
   private final ImmutableMap columnMap;
   private final int[] rowCounts;
   private final int[] columnCounts;
   private final Object[][] values;
   private final int[] iterationOrderRow;
   private final int[] iterationOrderColumn;

   DenseImmutableTable(ImmutableList var1, ImmutableSet var2, ImmutableSet var3) {
      Object[][] var4 = (Object[][])(new Object[var2.size()][var3.size()]);
      this.values = var4;
      this.rowKeyToIndex = Maps.indexMap(var2);
      this.columnKeyToIndex = Maps.indexMap(var3);
      this.rowCounts = new int[this.rowKeyToIndex.size()];
      this.columnCounts = new int[this.columnKeyToIndex.size()];
      int[] var5 = new int[var1.size()];
      int[] var6 = new int[var1.size()];

      for(int var7 = 0; var7 < var1.size(); ++var7) {
         Table$Cell var8 = (Table$Cell)var1.get(var7);
         Object var9 = var8.getRowKey();
         Object var10 = var8.getColumnKey();
         int var11 = ((Integer)this.rowKeyToIndex.get(var9)).intValue();
         int var12 = ((Integer)this.columnKeyToIndex.get(var10)).intValue();
         Object var13 = this.values[var11][var12];
         Preconditions.checkArgument(var13 == null, "duplicate key: (%s, %s)", new Object[]{var9, var10});
         this.values[var11][var12] = var8.getValue();
         ++this.rowCounts[var11];
         ++this.columnCounts[var12];
         var5[var7] = var11;
         var6[var7] = var12;
      }

      this.iterationOrderRow = var5;
      this.iterationOrderColumn = var6;
      this.rowMap = new DenseImmutableTable$RowMap(this, (DenseImmutableTable$1)null);
      this.columnMap = new DenseImmutableTable$ColumnMap(this, (DenseImmutableTable$1)null);
   }

   public ImmutableMap columnMap() {
      return this.columnMap;
   }

   public ImmutableMap rowMap() {
      return this.rowMap;
   }

   public Object get(@Nullable Object var1, @Nullable Object var2) {
      Integer var3 = (Integer)this.rowKeyToIndex.get(var1);
      Integer var4 = (Integer)this.columnKeyToIndex.get(var2);
      return var3 != null && var4 != null?this.values[var3.intValue()][var4.intValue()]:null;
   }

   public int size() {
      return this.iterationOrderRow.length;
   }

   Table$Cell getCell(int var1) {
      int var2 = this.iterationOrderRow[var1];
      int var3 = this.iterationOrderColumn[var1];
      Object var4 = this.rowKeySet().asList().get(var2);
      Object var5 = this.columnKeySet().asList().get(var3);
      Object var6 = this.values[var2][var3];
      return cellOf(var4, var5, var6);
   }

   Object getValue(int var1) {
      return this.values[this.iterationOrderRow[var1]][this.iterationOrderColumn[var1]];
   }

   // $FF: synthetic method
   static int[] access$200(DenseImmutableTable var0) {
      return var0.rowCounts;
   }

   // $FF: synthetic method
   static ImmutableMap access$300(DenseImmutableTable var0) {
      return var0.columnKeyToIndex;
   }

   // $FF: synthetic method
   static Object[][] access$400(DenseImmutableTable var0) {
      return var0.values;
   }

   // $FF: synthetic method
   static int[] access$500(DenseImmutableTable var0) {
      return var0.columnCounts;
   }

   // $FF: synthetic method
   static ImmutableMap access$600(DenseImmutableTable var0) {
      return var0.rowKeyToIndex;
   }
}
