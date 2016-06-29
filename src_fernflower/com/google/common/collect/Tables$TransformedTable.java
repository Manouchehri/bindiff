package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractTable;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import com.google.common.collect.Tables$TransformedTable$1;
import com.google.common.collect.Tables$TransformedTable$2;
import com.google.common.collect.Tables$TransformedTable$3;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Tables$TransformedTable extends AbstractTable {
   final Table fromTable;
   final Function function;

   Tables$TransformedTable(Table var1, Function var2) {
      this.fromTable = (Table)Preconditions.checkNotNull(var1);
      this.function = (Function)Preconditions.checkNotNull(var2);
   }

   public boolean contains(Object var1, Object var2) {
      return this.fromTable.contains(var1, var2);
   }

   public Object get(Object var1, Object var2) {
      return this.contains(var1, var2)?this.function.apply(this.fromTable.get(var1, var2)):null;
   }

   public int size() {
      return this.fromTable.size();
   }

   public void clear() {
      this.fromTable.clear();
   }

   public Object put(Object var1, Object var2, Object var3) {
      throw new UnsupportedOperationException();
   }

   public void putAll(Table var1) {
      throw new UnsupportedOperationException();
   }

   public Object remove(Object var1, Object var2) {
      return this.contains(var1, var2)?this.function.apply(this.fromTable.remove(var1, var2)):null;
   }

   public Map row(Object var1) {
      return Maps.transformValues(this.fromTable.row(var1), this.function);
   }

   public Map column(Object var1) {
      return Maps.transformValues(this.fromTable.column(var1), this.function);
   }

   Function cellFunction() {
      return new Tables$TransformedTable$1(this);
   }

   Iterator cellIterator() {
      return Iterators.transform(this.fromTable.cellSet().iterator(), this.cellFunction());
   }

   public Set rowKeySet() {
      return this.fromTable.rowKeySet();
   }

   public Set columnKeySet() {
      return this.fromTable.columnKeySet();
   }

   Collection createValues() {
      return Collections2.transform(this.fromTable.values(), this.function);
   }

   public Map rowMap() {
      Tables$TransformedTable$2 var1 = new Tables$TransformedTable$2(this);
      return Maps.transformValues((Map)this.fromTable.rowMap(), var1);
   }

   public Map columnMap() {
      Tables$TransformedTable$3 var1 = new Tables$TransformedTable$3(this);
      return Maps.transformValues((Map)this.fromTable.columnMap(), var1);
   }
}
