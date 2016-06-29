package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap$IteratorBasedImmutableMap;
import com.google.common.collect.ImmutableMapEntrySet;
import com.google.common.collect.UnmodifiableIterator;

class ImmutableMap$IteratorBasedImmutableMap$1EntrySetImpl extends ImmutableMapEntrySet {
   // $FF: synthetic field
   final ImmutableMap$IteratorBasedImmutableMap this$0;

   ImmutableMap$IteratorBasedImmutableMap$1EntrySetImpl(ImmutableMap$IteratorBasedImmutableMap var1) {
      this.this$0 = var1;
   }

   ImmutableMap map() {
      return this.this$0;
   }

   public UnmodifiableIterator iterator() {
      return this.this$0.entryIterator();
   }
}
