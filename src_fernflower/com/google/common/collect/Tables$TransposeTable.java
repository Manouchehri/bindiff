package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractTable;
import com.google.common.collect.Iterators;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import com.google.common.collect.Tables$TransposeTable$1;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

class Tables$TransposeTable extends AbstractTable {
   final Table original;
   private static final Function TRANSPOSE_CELL = new Tables$TransposeTable$1();

   Tables$TransposeTable(Table var1) {
      this.original = (Table)Preconditions.checkNotNull(var1);
   }

   public void clear() {
      this.original.clear();
   }

   public Map column(Object var1) {
      return this.original.row(var1);
   }

   public Set columnKeySet() {
      return this.original.rowKeySet();
   }

   public Map columnMap() {
      return this.original.rowMap();
   }

   public boolean contains(@Nullable Object var1, @Nullable Object var2) {
      return this.original.contains(var2, var1);
   }

   public boolean containsColumn(@Nullable Object var1) {
      return this.original.containsRow(var1);
   }

   public boolean containsRow(@Nullable Object var1) {
      return this.original.containsColumn(var1);
   }

   public boolean containsValue(@Nullable Object var1) {
      return this.original.containsValue(var1);
   }

   public Object get(@Nullable Object var1, @Nullable Object var2) {
      return this.original.get(var2, var1);
   }

   public Object put(Object var1, Object var2, Object var3) {
      return this.original.put(var2, var1, var3);
   }

   public void putAll(Table var1) {
      this.original.putAll(Tables.transpose(var1));
   }

   public Object remove(@Nullable Object var1, @Nullable Object var2) {
      return this.original.remove(var2, var1);
   }

   public Map row(Object var1) {
      return this.original.column(var1);
   }

   public Set rowKeySet() {
      return this.original.columnKeySet();
   }

   public Map rowMap() {
      return this.original.columnMap();
   }

   public int size() {
      return this.original.size();
   }

   public Collection values() {
      return this.original.values();
   }

   Iterator cellIterator() {
      return Iterators.transform(this.original.cellSet().iterator(), TRANSPOSE_CELL);
   }
}
