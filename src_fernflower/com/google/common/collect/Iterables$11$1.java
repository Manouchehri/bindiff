package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Iterables$11;
import java.util.Iterator;

class Iterables$11$1 implements Iterator {
   boolean atStart;
   // $FF: synthetic field
   final Iterator val$iterator;
   // $FF: synthetic field
   final Iterables$11 this$0;

   Iterables$11$1(Iterables$11 var1, Iterator var2) {
      this.this$0 = var1;
      this.val$iterator = var2;
      this.atStart = true;
   }

   public boolean hasNext() {
      return this.val$iterator.hasNext();
   }

   public Object next() {
      Object var1 = this.val$iterator.next();
      this.atStart = false;
      return var1;
   }

   public void remove() {
      CollectPreconditions.checkRemove(!this.atStart);
      this.val$iterator.remove();
   }
}
