package com.google.common.collect;

import com.google.common.collect.ForwardingMapEntry;
import com.google.common.collect.Synchronized;
import com.google.common.collect.Synchronized$SynchronizedAsMapEntries$1;
import java.util.Collection;
import java.util.Map.Entry;

class Synchronized$SynchronizedAsMapEntries$1$1 extends ForwardingMapEntry {
   // $FF: synthetic field
   final Entry val$entry;
   // $FF: synthetic field
   final Synchronized$SynchronizedAsMapEntries$1 this$1;

   Synchronized$SynchronizedAsMapEntries$1$1(Synchronized$SynchronizedAsMapEntries$1 var1, Entry var2) {
      this.this$1 = var1;
      this.val$entry = var2;
   }

   protected Entry delegate() {
      return this.val$entry;
   }

   public Collection getValue() {
      return Synchronized.access$400((Collection)this.val$entry.getValue(), this.this$1.this$0.mutex);
   }
}
