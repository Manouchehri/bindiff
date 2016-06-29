package com.google.common.collect;

import com.google.common.collect.Synchronized;
import com.google.common.collect.Synchronized$SynchronizedAsMapValues;
import com.google.common.collect.TransformedIterator;
import java.util.Collection;
import java.util.Iterator;

class Synchronized$SynchronizedAsMapValues$1 extends TransformedIterator {
   // $FF: synthetic field
   final Synchronized$SynchronizedAsMapValues this$0;

   Synchronized$SynchronizedAsMapValues$1(Synchronized$SynchronizedAsMapValues var1, Iterator var2) {
      super(var2);
      this.this$0 = var1;
   }

   Collection transform(Collection var1) {
      return Synchronized.access$400(var1, this.this$0.mutex);
   }
}
