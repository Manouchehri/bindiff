package com.google.common.collect;

import com.google.common.collect.Iterators;
import com.google.common.collect.Iterators$MergingIterator$1;
import com.google.common.collect.PeekingIterator;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

class Iterators$MergingIterator extends UnmodifiableIterator {
   final Queue queue;

   public Iterators$MergingIterator(Iterable var1, Comparator var2) {
      Iterators$MergingIterator$1 var3 = new Iterators$MergingIterator$1(this, var2);
      this.queue = new PriorityQueue(2, var3);
      Iterator var4 = var1.iterator();

      while(var4.hasNext()) {
         Iterator var5 = (Iterator)var4.next();
         if(var5.hasNext()) {
            this.queue.add(Iterators.peekingIterator(var5));
         }
      }

   }

   public boolean hasNext() {
      return !this.queue.isEmpty();
   }

   public Object next() {
      PeekingIterator var1 = (PeekingIterator)this.queue.remove();
      Object var2 = var1.next();
      if(var1.hasNext()) {
         this.queue.add(var1);
      }

      return var2;
   }
}
