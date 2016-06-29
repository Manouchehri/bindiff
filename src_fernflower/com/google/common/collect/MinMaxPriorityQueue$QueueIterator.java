package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.MinMaxPriorityQueue;
import com.google.common.collect.MinMaxPriorityQueue$1;
import com.google.common.collect.MinMaxPriorityQueue$MoveDesc;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

class MinMaxPriorityQueue$QueueIterator implements Iterator {
   private int cursor;
   private int expectedModCount;
   private Queue forgetMeNot;
   private List skipMe;
   private Object lastFromForgetMeNot;
   private boolean canRemove;
   // $FF: synthetic field
   final MinMaxPriorityQueue this$0;

   private MinMaxPriorityQueue$QueueIterator(MinMaxPriorityQueue var1) {
      this.this$0 = var1;
      this.cursor = -1;
      this.expectedModCount = MinMaxPriorityQueue.access$700(this.this$0);
   }

   public boolean hasNext() {
      this.checkModCount();
      return this.nextNotInSkipMe(this.cursor + 1) < this.this$0.size() || this.forgetMeNot != null && !this.forgetMeNot.isEmpty();
   }

   public Object next() {
      this.checkModCount();
      int var1 = this.nextNotInSkipMe(this.cursor + 1);
      if(var1 < this.this$0.size()) {
         this.cursor = var1;
         this.canRemove = true;
         return this.this$0.elementData(this.cursor);
      } else {
         if(this.forgetMeNot != null) {
            this.cursor = this.this$0.size();
            this.lastFromForgetMeNot = this.forgetMeNot.poll();
            if(this.lastFromForgetMeNot != null) {
               this.canRemove = true;
               return this.lastFromForgetMeNot;
            }
         }

         throw new NoSuchElementException("iterator moved past last element in queue.");
      }
   }

   public void remove() {
      CollectPreconditions.checkRemove(this.canRemove);
      this.checkModCount();
      this.canRemove = false;
      ++this.expectedModCount;
      if(this.cursor < this.this$0.size()) {
         MinMaxPriorityQueue$MoveDesc var1 = this.this$0.removeAt(this.cursor);
         if(var1 != null) {
            if(this.forgetMeNot == null) {
               this.forgetMeNot = new ArrayDeque();
               this.skipMe = new ArrayList(3);
            }

            this.forgetMeNot.add(var1.toTrickle);
            this.skipMe.add(var1.replaced);
         }

         --this.cursor;
      } else {
         Preconditions.checkState(this.removeExact(this.lastFromForgetMeNot));
         this.lastFromForgetMeNot = null;
      }

   }

   private boolean containsExact(Iterable var1, Object var2) {
      Iterator var3 = var1.iterator();

      Object var4;
      do {
         if(!var3.hasNext()) {
            return false;
         }

         var4 = var3.next();
      } while(var4 != var2);

      return true;
   }

   boolean removeExact(Object var1) {
      for(int var2 = 0; var2 < MinMaxPriorityQueue.access$600(this.this$0); ++var2) {
         if(MinMaxPriorityQueue.access$500(this.this$0)[var2] == var1) {
            this.this$0.removeAt(var2);
            return true;
         }
      }

      return false;
   }

   void checkModCount() {
      if(MinMaxPriorityQueue.access$700(this.this$0) != this.expectedModCount) {
         throw new ConcurrentModificationException();
      }
   }

   private int nextNotInSkipMe(int var1) {
      if(this.skipMe != null) {
         while(var1 < this.this$0.size() && this.containsExact(this.skipMe, this.this$0.elementData(var1))) {
            ++var1;
         }
      }

      return var1;
   }

   // $FF: synthetic method
   MinMaxPriorityQueue$QueueIterator(MinMaxPriorityQueue var1, MinMaxPriorityQueue$1 var2) {
      this(var1);
   }
}
