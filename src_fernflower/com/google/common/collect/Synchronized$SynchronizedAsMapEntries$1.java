package com.google.common.collect;

import com.google.common.collect.Synchronized$SynchronizedAsMapEntries;
import com.google.common.collect.Synchronized$SynchronizedAsMapEntries$1$1;
import com.google.common.collect.TransformedIterator;
import java.util.Iterator;
import java.util.Map.Entry;

class Synchronized$SynchronizedAsMapEntries$1 extends TransformedIterator {
   // $FF: synthetic field
   final Synchronized$SynchronizedAsMapEntries this$0;

   Synchronized$SynchronizedAsMapEntries$1(Synchronized$SynchronizedAsMapEntries var1, Iterator var2) {
      super(var2);
      this.this$0 = var1;
   }

   Entry transform(Entry var1) {
      return new Synchronized$SynchronizedAsMapEntries$1$1(this, var1);
   }
}
