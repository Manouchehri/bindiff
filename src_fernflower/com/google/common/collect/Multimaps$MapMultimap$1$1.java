package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Multimaps$MapMultimap$1;
import java.util.Iterator;
import java.util.NoSuchElementException;

class Multimaps$MapMultimap$1$1 implements Iterator {
   int i;
   // $FF: synthetic field
   final Multimaps$MapMultimap$1 this$1;

   Multimaps$MapMultimap$1$1(Multimaps$MapMultimap$1 var1) {
      this.this$1 = var1;
   }

   public boolean hasNext() {
      return this.i == 0 && this.this$1.this$0.map.containsKey(this.this$1.val$key);
   }

   public Object next() {
      if(!this.hasNext()) {
         throw new NoSuchElementException();
      } else {
         ++this.i;
         return this.this$1.this$0.map.get(this.this$1.val$key);
      }
   }

   public void remove() {
      CollectPreconditions.checkRemove(this.i == 1);
      this.i = -1;
      this.this$1.this$0.map.remove(this.this$1.val$key);
   }
}
