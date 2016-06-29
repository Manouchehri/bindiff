package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Synchronized$SynchronizedQueue;
import java.util.Deque;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtIncompatible("Deque")
final class Synchronized$SynchronizedDeque extends Synchronized$SynchronizedQueue implements Deque {
   private static final long serialVersionUID = 0L;

   Synchronized$SynchronizedDeque(Deque var1, @Nullable Object var2) {
      super(var1, var2);
   }

   Deque delegate() {
      return (Deque)super.delegate();
   }

   public void addFirst(Object var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         this.delegate().addFirst(var1);
      }
   }

   public void addLast(Object var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         this.delegate().addLast(var1);
      }
   }

   public boolean offerFirst(Object var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().offerFirst(var1);
      }
   }

   public boolean offerLast(Object var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().offerLast(var1);
      }
   }

   public Object removeFirst() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().removeFirst();
      }
   }

   public Object removeLast() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().removeLast();
      }
   }

   public Object pollFirst() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().pollFirst();
      }
   }

   public Object pollLast() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().pollLast();
      }
   }

   public Object getFirst() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().getFirst();
      }
   }

   public Object getLast() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().getLast();
      }
   }

   public Object peekFirst() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().peekFirst();
      }
   }

   public Object peekLast() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().peekLast();
      }
   }

   public boolean removeFirstOccurrence(Object var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().removeFirstOccurrence(var1);
      }
   }

   public boolean removeLastOccurrence(Object var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().removeLastOccurrence(var1);
      }
   }

   public void push(Object var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         this.delegate().push(var1);
      }
   }

   public Object pop() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().pop();
      }
   }

   public Iterator descendingIterator() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().descendingIterator();
      }
   }
}
