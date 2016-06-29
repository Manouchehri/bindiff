package com.google.common.collect;

import com.google.common.collect.ImmutableMap$MapViewOfValuesAsSingletonSets;
import com.google.common.collect.ImmutableMap$MapViewOfValuesAsSingletonSets$1$1;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;
import java.util.Map.Entry;

class ImmutableMap$MapViewOfValuesAsSingletonSets$1 extends UnmodifiableIterator {
   // $FF: synthetic field
   final Iterator val$backingIterator;
   // $FF: synthetic field
   final ImmutableMap$MapViewOfValuesAsSingletonSets this$1;

   ImmutableMap$MapViewOfValuesAsSingletonSets$1(ImmutableMap$MapViewOfValuesAsSingletonSets var1, Iterator var2) {
      this.this$1 = var1;
      this.val$backingIterator = var2;
   }

   public boolean hasNext() {
      return this.val$backingIterator.hasNext();
   }

   public Entry next() {
      Entry var1 = (Entry)this.val$backingIterator.next();
      return new ImmutableMap$MapViewOfValuesAsSingletonSets$1$1(this, var1);
   }
}
