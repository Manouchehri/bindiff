package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.TreeMultiset;
import com.google.common.collect.TreeMultiset$AvlNode;
import java.util.Iterator;
import java.util.NoSuchElementException;

class TreeMultiset$2 implements Iterator {
   TreeMultiset$AvlNode current;
   Multiset$Entry prevEntry;
   // $FF: synthetic field
   final TreeMultiset this$0;

   TreeMultiset$2(TreeMultiset var1) {
      this.this$0 = var1;
      this.current = TreeMultiset.access$1200(this.this$0);
   }

   public boolean hasNext() {
      if(this.current == null) {
         return false;
      } else if(TreeMultiset.access$1300(this.this$0).tooHigh(this.current.getElement())) {
         this.current = null;
         return false;
      } else {
         return true;
      }
   }

   public Multiset$Entry next() {
      if(!this.hasNext()) {
         throw new NoSuchElementException();
      } else {
         Multiset$Entry var1 = TreeMultiset.access$1400(this.this$0, this.current);
         this.prevEntry = var1;
         if(TreeMultiset$AvlNode.access$900(this.current) == TreeMultiset.access$1500(this.this$0)) {
            this.current = null;
         } else {
            this.current = TreeMultiset$AvlNode.access$900(this.current);
         }

         return var1;
      }
   }

   public void remove() {
      CollectPreconditions.checkRemove(this.prevEntry != null);
      this.this$0.setCount(this.prevEntry.getElement(), 0);
      this.prevEntry = null;
   }
}
