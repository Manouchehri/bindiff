package com.google.common.collect;

import com.google.common.collect.AbstractMapEntry;
import javax.annotation.Nullable;

final class LinkedListMultimap$Node extends AbstractMapEntry {
   final Object key;
   Object value;
   LinkedListMultimap$Node next;
   LinkedListMultimap$Node previous;
   LinkedListMultimap$Node nextSibling;
   LinkedListMultimap$Node previousSibling;

   LinkedListMultimap$Node(@Nullable Object var1, @Nullable Object var2) {
      this.key = var1;
      this.value = var2;
   }

   public Object getKey() {
      return this.key;
   }

   public Object getValue() {
      return this.value;
   }

   public Object setValue(@Nullable Object var1) {
      Object var2 = this.value;
      this.value = var1;
      return var2;
   }
}
