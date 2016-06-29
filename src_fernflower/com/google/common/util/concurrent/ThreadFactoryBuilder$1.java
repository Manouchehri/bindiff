package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

final class ThreadFactoryBuilder$1 implements ThreadFactory {
   // $FF: synthetic field
   final ThreadFactory val$backingThreadFactory;
   // $FF: synthetic field
   final String val$nameFormat;
   // $FF: synthetic field
   final AtomicLong val$count;
   // $FF: synthetic field
   final Boolean val$daemon;
   // $FF: synthetic field
   final Integer val$priority;
   // $FF: synthetic field
   final UncaughtExceptionHandler val$uncaughtExceptionHandler;

   ThreadFactoryBuilder$1(ThreadFactory var1, String var2, AtomicLong var3, Boolean var4, Integer var5, UncaughtExceptionHandler var6) {
      this.val$backingThreadFactory = var1;
      this.val$nameFormat = var2;
      this.val$count = var3;
      this.val$daemon = var4;
      this.val$priority = var5;
      this.val$uncaughtExceptionHandler = var6;
   }

   public Thread newThread(Runnable var1) {
      Thread var2 = this.val$backingThreadFactory.newThread(var1);
      if(this.val$nameFormat != null) {
         var2.setName(ThreadFactoryBuilder.access$000(this.val$nameFormat, new Object[]{Long.valueOf(this.val$count.getAndIncrement())}));
      }

      if(this.val$daemon != null) {
         var2.setDaemon(this.val$daemon.booleanValue());
      }

      if(this.val$priority != null) {
         var2.setPriority(this.val$priority.intValue());
      }

      if(this.val$uncaughtExceptionHandler != null) {
         var2.setUncaughtExceptionHandler(this.val$uncaughtExceptionHandler);
      }

      return var2;
   }
}
