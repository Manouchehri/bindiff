package com.google.common.collect;

import com.google.common.collect.AbstractMultimap;
import com.google.common.collect.AbstractMultimap$1;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps$Entries;
import java.util.Iterator;

class AbstractMultimap$Entries extends Multimaps$Entries {
   // $FF: synthetic field
   final AbstractMultimap this$0;

   private AbstractMultimap$Entries(AbstractMultimap var1) {
      this.this$0 = var1;
   }

   Multimap multimap() {
      return this.this$0;
   }

   public Iterator iterator() {
      return this.this$0.entryIterator();
   }

   // $FF: synthetic method
   AbstractMultimap$Entries(AbstractMultimap var1, AbstractMultimap$1 var2) {
      this(var1);
   }
}
