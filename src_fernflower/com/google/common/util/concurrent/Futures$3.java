package com.google.common.util.concurrent;

import com.google.common.base.Function;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

final class Futures$3 implements Future {
   // $FF: synthetic field
   final Future val$input;
   // $FF: synthetic field
   final Function val$function;

   Futures$3(Future var1, Function var2) {
      this.val$input = var1;
      this.val$function = var2;
   }

   public boolean cancel(boolean var1) {
      return this.val$input.cancel(var1);
   }

   public boolean isCancelled() {
      return this.val$input.isCancelled();
   }

   public boolean isDone() {
      return this.val$input.isDone();
   }

   public Object get() {
      return this.applyTransformation(this.val$input.get());
   }

   public Object get(long var1, TimeUnit var3) {
      return this.applyTransformation(this.val$input.get(var1, var3));
   }

   private Object applyTransformation(Object var1) {
      try {
         return this.val$function.apply(var1);
      } catch (Throwable var3) {
         throw new ExecutionException(var3);
      }
   }
}
