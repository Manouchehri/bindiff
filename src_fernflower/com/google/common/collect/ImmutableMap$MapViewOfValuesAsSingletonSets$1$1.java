package com.google.common.collect;

import com.google.common.collect.AbstractMapEntry;
import com.google.common.collect.ImmutableMap$MapViewOfValuesAsSingletonSets$1;
import com.google.common.collect.ImmutableSet;
import java.util.Map.Entry;

class ImmutableMap$MapViewOfValuesAsSingletonSets$1$1 extends AbstractMapEntry {
   // $FF: synthetic field
   final Entry val$backingEntry;
   // $FF: synthetic field
   final ImmutableMap$MapViewOfValuesAsSingletonSets$1 this$2;

   ImmutableMap$MapViewOfValuesAsSingletonSets$1$1(ImmutableMap$MapViewOfValuesAsSingletonSets$1 var1, Entry var2) {
      this.this$2 = var1;
      this.val$backingEntry = var2;
   }

   public Object getKey() {
      return this.val$backingEntry.getKey();
   }

   public ImmutableSet getValue() {
      return ImmutableSet.of(this.val$backingEntry.getValue());
   }
}
