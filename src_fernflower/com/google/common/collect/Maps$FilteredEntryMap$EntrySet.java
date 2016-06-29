package com.google.common.collect;

import com.google.common.collect.ForwardingSet;
import com.google.common.collect.Maps$1;
import com.google.common.collect.Maps$FilteredEntryMap;
import com.google.common.collect.Maps$FilteredEntryMap$EntrySet$1;
import java.util.Iterator;
import java.util.Set;

class Maps$FilteredEntryMap$EntrySet extends ForwardingSet {
   // $FF: synthetic field
   final Maps$FilteredEntryMap this$0;

   private Maps$FilteredEntryMap$EntrySet(Maps$FilteredEntryMap var1) {
      this.this$0 = var1;
   }

   protected Set delegate() {
      return this.this$0.filteredEntrySet;
   }

   public Iterator iterator() {
      return new Maps$FilteredEntryMap$EntrySet$1(this, this.this$0.filteredEntrySet.iterator());
   }

   // $FF: synthetic method
   Maps$FilteredEntryMap$EntrySet(Maps$FilteredEntryMap var1, Maps$1 var2) {
      this(var1);
   }
}
