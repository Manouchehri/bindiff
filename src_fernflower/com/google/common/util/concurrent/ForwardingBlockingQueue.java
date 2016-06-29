package com.google.common.util.concurrent;

import com.google.common.collect.ForwardingQueue;
import java.util.Collection;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public abstract class ForwardingBlockingQueue extends ForwardingQueue implements BlockingQueue {
   protected abstract BlockingQueue delegate();

   public int drainTo(Collection var1, int var2) {
      return this.delegate().drainTo(var1, var2);
   }

   public int drainTo(Collection var1) {
      return this.delegate().drainTo(var1);
   }

   public boolean offer(Object var1, long var2, TimeUnit var4) {
      return this.delegate().offer(var1, var2, var4);
   }

   public Object poll(long var1, TimeUnit var3) {
      return this.delegate().poll(var1, var3);
   }

   public void put(Object var1) {
      this.delegate().put(var1);
   }

   public int remainingCapacity() {
      return this.delegate().remainingCapacity();
   }

   public Object take() {
      return this.delegate().take();
   }
}
