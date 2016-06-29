package com.google.common.collect;

import com.google.common.collect.Maps;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;
import java.util.Map.Entry;

final class Maps$6 extends UnmodifiableIterator {
   // $FF: synthetic field
   final Iterator val$entryIterator;

   Maps$6(Iterator var1) {
      this.val$entryIterator = var1;
   }

   public boolean hasNext() {
      return this.val$entryIterator.hasNext();
   }

   public Entry next() {
      return Maps.unmodifiableEntry((Entry)this.val$entryIterator.next());
   }
}
