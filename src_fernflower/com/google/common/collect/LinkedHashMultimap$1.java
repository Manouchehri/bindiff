package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.LinkedHashMultimap$ValueEntry;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Map.Entry;

class LinkedHashMultimap$1 implements Iterator {
   LinkedHashMultimap$ValueEntry nextEntry;
   LinkedHashMultimap$ValueEntry toRemove;
   // $FF: synthetic field
   final LinkedHashMultimap this$0;

   LinkedHashMultimap$1(LinkedHashMultimap var1) {
      this.this$0 = var1;
      this.nextEntry = LinkedHashMultimap.access$300(this.this$0).successorInMultimap;
   }

   public boolean hasNext() {
      return this.nextEntry != LinkedHashMultimap.access$300(this.this$0);
   }

   public Entry next() {
      if(!this.hasNext()) {
         throw new NoSuchElementException();
      } else {
         LinkedHashMultimap$ValueEntry var1 = this.nextEntry;
         this.toRemove = var1;
         this.nextEntry = this.nextEntry.successorInMultimap;
         return var1;
      }
   }

   public void remove() {
      CollectPreconditions.checkRemove(this.toRemove != null);
      this.this$0.remove(this.toRemove.getKey(), this.toRemove.getValue());
      this.toRemove = null;
   }
}
