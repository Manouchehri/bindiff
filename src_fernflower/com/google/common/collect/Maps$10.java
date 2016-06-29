package com.google.common.collect;

import com.google.common.collect.AbstractMapEntry;
import com.google.common.collect.Maps$EntryTransformer;
import java.util.Map.Entry;

final class Maps$10 extends AbstractMapEntry {
   // $FF: synthetic field
   final Entry val$entry;
   // $FF: synthetic field
   final Maps$EntryTransformer val$transformer;

   Maps$10(Entry var1, Maps$EntryTransformer var2) {
      this.val$entry = var1;
      this.val$transformer = var2;
   }

   public Object getKey() {
      return this.val$entry.getKey();
   }

   public Object getValue() {
      return this.val$transformer.transformEntry(this.val$entry.getKey(), this.val$entry.getValue());
   }
}
