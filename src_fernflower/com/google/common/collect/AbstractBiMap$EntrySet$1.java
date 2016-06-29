package com.google.common.collect;

import com.google.common.collect.AbstractBiMap;
import com.google.common.collect.AbstractBiMap$EntrySet;
import com.google.common.collect.AbstractBiMap$EntrySet$1$1;
import com.google.common.collect.CollectPreconditions;
import java.util.Iterator;
import java.util.Map.Entry;

class AbstractBiMap$EntrySet$1 implements Iterator {
   Entry entry;
   // $FF: synthetic field
   final Iterator val$iterator;
   // $FF: synthetic field
   final AbstractBiMap$EntrySet this$1;

   AbstractBiMap$EntrySet$1(AbstractBiMap$EntrySet var1, Iterator var2) {
      this.this$1 = var1;
      this.val$iterator = var2;
   }

   public boolean hasNext() {
      return this.val$iterator.hasNext();
   }

   public Entry next() {
      this.entry = (Entry)this.val$iterator.next();
      Entry var1 = this.entry;
      return new AbstractBiMap$EntrySet$1$1(this, var1);
   }

   public void remove() {
      CollectPreconditions.checkRemove(this.entry != null);
      Object var1 = this.entry.getValue();
      this.val$iterator.remove();
      AbstractBiMap.access$700(this.this$1.this$0, var1);
   }
}
