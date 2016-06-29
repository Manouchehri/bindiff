package com.google.common.collect;

import com.google.common.collect.AbstractTable;
import java.util.AbstractCollection;
import java.util.Iterator;

class AbstractTable$Values extends AbstractCollection {
   // $FF: synthetic field
   final AbstractTable this$0;

   AbstractTable$Values(AbstractTable var1) {
      this.this$0 = var1;
   }

   public Iterator iterator() {
      return this.this$0.valuesIterator();
   }

   public boolean contains(Object var1) {
      return this.this$0.containsValue(var1);
   }

   public void clear() {
      this.this$0.clear();
   }

   public int size() {
      return this.this$0.size();
   }
}
