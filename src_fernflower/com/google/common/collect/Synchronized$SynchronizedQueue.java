package com.google.common.collect;

import com.google.common.collect.Synchronized$1;
import com.google.common.collect.Synchronized$SynchronizedCollection;
import java.util.Queue;
import javax.annotation.Nullable;

class Synchronized$SynchronizedQueue extends Synchronized$SynchronizedCollection implements Queue {
   private static final long serialVersionUID = 0L;

   Synchronized$SynchronizedQueue(Queue var1, @Nullable Object var2) {
      super(var1, var2, (Synchronized$1)null);
   }

   Queue delegate() {
      return (Queue)super.delegate();
   }

   public Object element() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().element();
      }
   }

   public boolean offer(Object var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().offer(var1);
      }
   }

   public Object peek() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().peek();
      }
   }

   public Object poll() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().poll();
      }
   }

   public Object remove() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().remove();
      }
   }
}
