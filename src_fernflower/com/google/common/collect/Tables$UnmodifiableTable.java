package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

class Tables$UnmodifiableTable extends ForwardingTable implements Serializable {
   final Table delegate;
   private static final long serialVersionUID = 0L;

   Tables$UnmodifiableTable(Table var1) {
      this.delegate = (Table)Preconditions.checkNotNull(var1);
   }

   protected Table delegate() {
      return this.delegate;
   }

   public Set cellSet() {
      return Collections.unmodifiableSet(super.cellSet());
   }

   public void clear() {
      throw new UnsupportedOperationException();
   }

   public Map column(@Nullable Object var1) {
      return Collections.unmodifiableMap(super.column(var1));
   }

   public Set columnKeySet() {
      return Collections.unmodifiableSet(super.columnKeySet());
   }

   public Map columnMap() {
      Function var1 = Tables.access$000();
      return Collections.unmodifiableMap(Maps.transformValues(super.columnMap(), var1));
   }

   public Object put(@Nullable Object var1, @Nullable Object var2, @Nullable Object var3) {
      throw new UnsupportedOperationException();
   }

   public void putAll(Table var1) {
      throw new UnsupportedOperationException();
   }

   public Object remove(@Nullable Object var1, @Nullable Object var2) {
      throw new UnsupportedOperationException();
   }

   public Map row(@Nullable Object var1) {
      return Collections.unmodifiableMap(super.row(var1));
   }

   public Set rowKeySet() {
      return Collections.unmodifiableSet(super.rowKeySet());
   }

   public Map rowMap() {
      Function var1 = Tables.access$000();
      return Collections.unmodifiableMap(Maps.transformValues(super.rowMap(), var1));
   }

   public Collection values() {
      return Collections.unmodifiableCollection(super.values());
   }
}
