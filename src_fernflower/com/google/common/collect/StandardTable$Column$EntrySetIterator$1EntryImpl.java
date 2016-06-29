package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMapEntry;
import com.google.common.collect.StandardTable$Column$EntrySetIterator;
import java.util.Map;
import java.util.Map.Entry;

class StandardTable$Column$EntrySetIterator$1EntryImpl extends AbstractMapEntry {
   // $FF: synthetic field
   final Entry val$entry;
   // $FF: synthetic field
   final StandardTable$Column$EntrySetIterator this$2;

   StandardTable$Column$EntrySetIterator$1EntryImpl(StandardTable$Column$EntrySetIterator var1, Entry var2) {
      this.this$2 = var1;
      this.val$entry = var2;
   }

   public Object getKey() {
      return this.val$entry.getKey();
   }

   public Object getValue() {
      return ((Map)this.val$entry.getValue()).get(this.this$2.this$1.columnKey);
   }

   public Object setValue(Object var1) {
      return ((Map)this.val$entry.getValue()).put(this.this$2.this$1.columnKey, Preconditions.checkNotNull(var1));
   }
}
