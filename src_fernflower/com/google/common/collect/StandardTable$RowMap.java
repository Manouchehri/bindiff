package com.google.common.collect;

import com.google.common.collect.Maps$ViewCachingAbstractMap;
import com.google.common.collect.StandardTable;
import com.google.common.collect.StandardTable$RowMap$EntrySet;
import java.util.Map;
import java.util.Set;

class StandardTable$RowMap extends Maps$ViewCachingAbstractMap {
   // $FF: synthetic field
   final StandardTable this$0;

   StandardTable$RowMap(StandardTable var1) {
      this.this$0 = var1;
   }

   public boolean containsKey(Object var1) {
      return this.this$0.containsRow(var1);
   }

   public Map get(Object var1) {
      return this.this$0.containsRow(var1)?this.this$0.row(var1):null;
   }

   public Map remove(Object var1) {
      return var1 == null?null:(Map)this.this$0.backingMap.remove(var1);
   }

   protected Set createEntrySet() {
      return new StandardTable$RowMap$EntrySet(this);
   }
}
