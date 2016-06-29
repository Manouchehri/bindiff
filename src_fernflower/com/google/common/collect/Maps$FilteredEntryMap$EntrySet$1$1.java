package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingMapEntry;
import com.google.common.collect.Maps$FilteredEntryMap$EntrySet$1;
import java.util.Map.Entry;

class Maps$FilteredEntryMap$EntrySet$1$1 extends ForwardingMapEntry {
   // $FF: synthetic field
   final Entry val$entry;
   // $FF: synthetic field
   final Maps$FilteredEntryMap$EntrySet$1 this$2;

   Maps$FilteredEntryMap$EntrySet$1$1(Maps$FilteredEntryMap$EntrySet$1 var1, Entry var2) {
      this.this$2 = var1;
      this.val$entry = var2;
   }

   protected Entry delegate() {
      return this.val$entry;
   }

   public Object setValue(Object var1) {
      Preconditions.checkArgument(this.this$2.this$1.this$0.apply(this.getKey(), var1));
      return super.setValue(var1);
   }
}
