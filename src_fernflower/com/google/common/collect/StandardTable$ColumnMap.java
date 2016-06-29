package com.google.common.collect;

import com.google.common.collect.Maps$ViewCachingAbstractMap;
import com.google.common.collect.StandardTable;
import com.google.common.collect.StandardTable$1;
import com.google.common.collect.StandardTable$ColumnMap$ColumnMapEntrySet;
import com.google.common.collect.StandardTable$ColumnMap$ColumnMapValues;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

class StandardTable$ColumnMap extends Maps$ViewCachingAbstractMap {
   // $FF: synthetic field
   final StandardTable this$0;

   private StandardTable$ColumnMap(StandardTable var1) {
      this.this$0 = var1;
   }

   public Map get(Object var1) {
      return this.this$0.containsColumn(var1)?this.this$0.column(var1):null;
   }

   public boolean containsKey(Object var1) {
      return this.this$0.containsColumn(var1);
   }

   public Map remove(Object var1) {
      return this.this$0.containsColumn(var1)?StandardTable.access$900(this.this$0, var1):null;
   }

   public Set createEntrySet() {
      return new StandardTable$ColumnMap$ColumnMapEntrySet(this);
   }

   public Set keySet() {
      return this.this$0.columnKeySet();
   }

   Collection createValues() {
      return new StandardTable$ColumnMap$ColumnMapValues(this);
   }

   // $FF: synthetic method
   StandardTable$ColumnMap(StandardTable var1, StandardTable$1 var2) {
      this(var1);
   }
}
