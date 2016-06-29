package com.google.common.collect;

import com.google.common.collect.AbstractMultimap;
import java.util.AbstractCollection;
import java.util.Iterator;
import javax.annotation.Nullable;

class AbstractMultimap$Values extends AbstractCollection {
   // $FF: synthetic field
   final AbstractMultimap this$0;

   AbstractMultimap$Values(AbstractMultimap var1) {
      this.this$0 = var1;
   }

   public Iterator iterator() {
      return this.this$0.valueIterator();
   }

   public int size() {
      return this.this$0.size();
   }

   public boolean contains(@Nullable Object var1) {
      return this.this$0.containsValue(var1);
   }

   public void clear() {
      this.this$0.clear();
   }
}
