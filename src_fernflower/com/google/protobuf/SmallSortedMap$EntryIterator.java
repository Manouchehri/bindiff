package com.google.protobuf;

import com.google.protobuf.SmallSortedMap;
import com.google.protobuf.SmallSortedMap$1;
import java.util.Iterator;
import java.util.Map.Entry;

class SmallSortedMap$EntryIterator implements Iterator {
   private int pos;
   private boolean nextCalledBeforeRemove;
   private Iterator lazyOverflowIterator;
   // $FF: synthetic field
   final SmallSortedMap this$0;

   private SmallSortedMap$EntryIterator(SmallSortedMap var1) {
      this.this$0 = var1;
      this.pos = -1;
   }

   public boolean hasNext() {
      return this.pos + 1 < SmallSortedMap.access$400(this.this$0).size() || this.getOverflowIterator().hasNext();
   }

   public Entry next() {
      this.nextCalledBeforeRemove = true;
      return ++this.pos < SmallSortedMap.access$400(this.this$0).size()?(Entry)SmallSortedMap.access$400(this.this$0).get(this.pos):(Entry)this.getOverflowIterator().next();
   }

   public void remove() {
      if(!this.nextCalledBeforeRemove) {
         throw new IllegalStateException("remove() was called before next()");
      } else {
         this.nextCalledBeforeRemove = false;
         SmallSortedMap.access$200(this.this$0);
         if(this.pos < SmallSortedMap.access$400(this.this$0).size()) {
            SmallSortedMap.access$500(this.this$0, this.pos--);
         } else {
            this.getOverflowIterator().remove();
         }

      }
   }

   private Iterator getOverflowIterator() {
      if(this.lazyOverflowIterator == null) {
         this.lazyOverflowIterator = SmallSortedMap.access$600(this.this$0).entrySet().iterator();
      }

      return this.lazyOverflowIterator;
   }

   // $FF: synthetic method
   SmallSortedMap$EntryIterator(SmallSortedMap var1, SmallSortedMap$1 var2) {
      this(var1);
   }
}
