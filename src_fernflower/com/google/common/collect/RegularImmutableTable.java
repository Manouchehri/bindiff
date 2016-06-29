package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.DenseImmutableTable;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Ordering;
import com.google.common.collect.RegularImmutableTable$1;
import com.google.common.collect.RegularImmutableTable$CellSet;
import com.google.common.collect.RegularImmutableTable$Values;
import com.google.common.collect.SparseImmutableTable;
import com.google.common.collect.Table$Cell;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import javax.annotation.Nullable;

@GwtCompatible
abstract class RegularImmutableTable extends ImmutableTable {
   abstract Table$Cell getCell(int var1);

   final ImmutableSet createCellSet() {
      return (ImmutableSet)(this.isEmpty()?ImmutableSet.of():new RegularImmutableTable$CellSet(this, (RegularImmutableTable$1)null));
   }

   abstract Object getValue(int var1);

   final ImmutableCollection createValues() {
      return (ImmutableCollection)(this.isEmpty()?ImmutableList.of():new RegularImmutableTable$Values(this, (RegularImmutableTable$1)null));
   }

   static RegularImmutableTable forCells(List var0, @Nullable Comparator var1, @Nullable Comparator var2) {
      Preconditions.checkNotNull(var0);
      if(var1 != null || var2 != null) {
         RegularImmutableTable$1 var3 = new RegularImmutableTable$1(var1, var2);
         Collections.sort(var0, var3);
      }

      return forCellsInternal(var0, var1, var2);
   }

   static RegularImmutableTable forCells(Iterable var0) {
      return forCellsInternal(var0, (Comparator)null, (Comparator)null);
   }

   private static final RegularImmutableTable forCellsInternal(Iterable var0, @Nullable Comparator var1, @Nullable Comparator var2) {
      LinkedHashSet var3 = new LinkedHashSet();
      LinkedHashSet var4 = new LinkedHashSet();
      ImmutableList var5 = ImmutableList.copyOf(var0);
      Iterator var6 = var0.iterator();

      while(var6.hasNext()) {
         Table$Cell var7 = (Table$Cell)var6.next();
         var3.add(var7.getRowKey());
         var4.add(var7.getColumnKey());
      }

      ImmutableSet var8 = var1 == null?ImmutableSet.copyOf((Collection)var3):ImmutableSet.copyOf((Collection)Ordering.from(var1).immutableSortedCopy(var3));
      ImmutableSet var9 = var2 == null?ImmutableSet.copyOf((Collection)var4):ImmutableSet.copyOf((Collection)Ordering.from(var2).immutableSortedCopy(var4));
      return (RegularImmutableTable)((long)var5.size() > (long)var8.size() * (long)var9.size() / 2L?new DenseImmutableTable(var5, var8, var9):new SparseImmutableTable(var5, var8, var9));
   }
}
