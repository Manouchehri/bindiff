package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures$1;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class Futures$ImmediateFuture implements ListenableFuture {
   private static final Logger log = Logger.getLogger(Futures$ImmediateFuture.class.getName());

   private Futures$ImmediateFuture() {
   }

   public void addListener(Runnable var1, Executor var2) {
      Preconditions.checkNotNull(var1, "Runnable was null.");
      Preconditions.checkNotNull(var2, "Executor was null.");

      try {
         var2.execute(var1);
      } catch (RuntimeException var6) {
         Logger var10000 = log;
         Level var10001 = Level.SEVERE;
         String var4 = String.valueOf(var1);
         String var5 = String.valueOf(var2);
         var10000.log(var10001, (new StringBuilder(57 + String.valueOf(var4).length() + String.valueOf(var5).length())).append("RuntimeException while executing runnable ").append(var4).append(" with executor ").append(var5).toString(), var6);
      }

   }

   public boolean cancel(boolean var1) {
      return false;
   }

   public abstract Object get();

   public Object get(long var1, TimeUnit var3) {
      Preconditions.checkNotNull(var3);
      return this.get();
   }

   public boolean isCancelled() {
      return false;
   }

   public boolean isDone() {
      return true;
   }

   // $FF: synthetic method
   Futures$ImmediateFuture(Futures$1 var1) {
      this();
   }
}
