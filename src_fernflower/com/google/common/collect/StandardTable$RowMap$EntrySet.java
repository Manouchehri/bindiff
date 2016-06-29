package com.google.common.collect;

import com.google.common.collect.Collections2;
import com.google.common.collect.Maps;
import com.google.common.collect.StandardTable$1;
import com.google.common.collect.StandardTable$RowMap;
import com.google.common.collect.StandardTable$RowMap$EntrySet$1;
import com.google.common.collect.StandardTable$TableSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class StandardTable$RowMap$EntrySet extends StandardTable$TableSet {
   // $FF: synthetic field
   final StandardTable$RowMap this$1;

   StandardTable$RowMap$EntrySet(StandardTable$RowMap var1) {
      super(var1.this$0, (StandardTable$1)null);
      this.this$1 = var1;
   }

   public Iterator iterator() {
      return Maps.asMapEntryIterator(this.this$1.this$0.backingMap.keySet(), new StandardTable$RowMap$EntrySet$1(this));
   }

   public int size() {
      return this.this$1.this$0.backingMap.size();
   }

   public boolean contains(Object var1) {
      if(!(var1 instanceof Entry)) {
         return false;
      } else {
         Entry var2 = (Entry)var1;
         return var2.getKey() != null && var2.getValue() instanceof Map && Collections2.safeContains(this.this$1.this$0.backingMap.entrySet(), var2);
      }
   }

   public boolean remove(Object var1) {
      if(!(var1 instanceof Entry)) {
         return false;
      } else {
         Entry var2 = (Entry)var1;
         return var2.getKey() != null && var2.getValue() instanceof Map && this.this$1.this$0.backingMap.entrySet().remove(var2);
      }
   }
}
