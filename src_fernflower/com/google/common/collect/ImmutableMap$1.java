package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Map.Entry;

class ImmutableMap$1 extends UnmodifiableIterator {
   // $FF: synthetic field
   final UnmodifiableIterator val$entryIterator;
   // $FF: synthetic field
   final ImmutableMap this$0;

   ImmutableMap$1(ImmutableMap var1, UnmodifiableIterator var2) {
      this.this$0 = var1;
      this.val$entryIterator = var2;
   }

   public boolean hasNext() {
      return this.val$entryIterator.hasNext();
   }

   public Object next() {
      return ((Entry)this.val$entryIterator.next()).getKey();
   }
}
