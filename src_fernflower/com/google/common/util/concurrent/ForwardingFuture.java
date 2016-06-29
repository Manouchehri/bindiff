package com.google.common.util.concurrent;

import com.google.common.collect.ForwardingObject;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public abstract class ForwardingFuture extends ForwardingObject implements Future {
   protected abstract Future delegate();

   public boolean cancel(boolean var1) {
      return this.delegate().cancel(var1);
   }

   public boolean isCancelled() {
      return this.delegate().isCancelled();
   }

   public boolean isDone() {
      return this.delegate().isDone();
   }

   public Object get() {
      return this.delegate().get();
   }

   public Object get(long var1, TimeUnit var3) {
      return this.delegate().get(var1, var3);
   }
}
