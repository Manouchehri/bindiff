package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.ForwardingNavigableMap$StandardDescendingMap;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Map.Entry;

class ForwardingNavigableMap$StandardDescendingMap$1 implements Iterator {
   private Entry toRemove;
   private Entry nextOrNull;
   // $FF: synthetic field
   final ForwardingNavigableMap$StandardDescendingMap this$1;

   ForwardingNavigableMap$StandardDescendingMap$1(ForwardingNavigableMap$StandardDescendingMap var1) {
      this.this$1 = var1;
      this.toRemove = null;
      this.nextOrNull = this.this$1.forward().lastEntry();
   }

   public boolean hasNext() {
      return this.nextOrNull != null;
   }

   public Entry next() {
      if(!this.hasNext()) {
         throw new NoSuchElementException();
      } else {
         Entry var1;
         try {
            var1 = this.nextOrNull;
         } finally {
            this.toRemove = this.nextOrNull;
            this.nextOrNull = this.this$1.forward().lowerEntry(this.nextOrNull.getKey());
         }

         return var1;
      }
   }

   public void remove() {
      CollectPreconditions.checkRemove(this.toRemove != null);
      this.this$1.forward().remove(this.toRemove.getKey());
      this.toRemove = null;
   }
}
