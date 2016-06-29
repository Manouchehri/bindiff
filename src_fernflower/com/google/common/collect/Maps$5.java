package com.google.common.collect;

import com.google.common.collect.AbstractMapEntry;
import java.util.Map.Entry;

final class Maps$5 extends AbstractMapEntry {
   // $FF: synthetic field
   final Entry val$entry;

   Maps$5(Entry var1) {
      this.val$entry = var1;
   }

   public Object getKey() {
      return this.val$entry.getKey();
   }

   public Object getValue() {
      return this.val$entry.getValue();
   }
}
