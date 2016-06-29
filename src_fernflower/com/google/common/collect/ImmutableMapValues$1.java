package com.google.common.collect;

import com.google.common.collect.ImmutableMapValues;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Map.Entry;

class ImmutableMapValues$1 extends UnmodifiableIterator {
   final UnmodifiableIterator entryItr;
   // $FF: synthetic field
   final ImmutableMapValues this$0;

   ImmutableMapValues$1(ImmutableMapValues var1) {
      this.this$0 = var1;
      this.entryItr = ImmutableMapValues.access$000(this.this$0).entrySet().iterator();
   }

   public boolean hasNext() {
      return this.entryItr.hasNext();
   }

   public Object next() {
      return ((Entry)this.entryItr.next()).getValue();
   }
}
