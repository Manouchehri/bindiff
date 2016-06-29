package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ThreadFactoryBuilder$1;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public final class ThreadFactoryBuilder {
   private String nameFormat = null;
   private Boolean daemon = null;
   private Integer priority = null;
   private UncaughtExceptionHandler uncaughtExceptionHandler = null;
   private ThreadFactory backingThreadFactory = null;

   public ThreadFactoryBuilder setNameFormat(String var1) {
      format(var1, new Object[]{Integer.valueOf(0)});
      this.nameFormat = var1;
      return this;
   }

   public ThreadFactoryBuilder setDaemon(boolean var1) {
      this.daemon = Boolean.valueOf(var1);
      return this;
   }

   public ThreadFactoryBuilder setPriority(int var1) {
      Preconditions.checkArgument(var1 >= 1, "Thread priority (%s) must be >= %s", new Object[]{Integer.valueOf(var1), Integer.valueOf(1)});
      Preconditions.checkArgument(var1 <= 10, "Thread priority (%s) must be <= %s", new Object[]{Integer.valueOf(var1), Integer.valueOf(10)});
      this.priority = Integer.valueOf(var1);
      return this;
   }

   public ThreadFactoryBuilder setUncaughtExceptionHandler(UncaughtExceptionHandler var1) {
      this.uncaughtExceptionHandler = (UncaughtExceptionHandler)Preconditions.checkNotNull(var1);
      return this;
   }

   public ThreadFactoryBuilder setThreadFactory(ThreadFactory var1) {
      this.backingThreadFactory = (ThreadFactory)Preconditions.checkNotNull(var1);
      return this;
   }

   public ThreadFactory build() {
      return build(this);
   }

   private static ThreadFactory build(ThreadFactoryBuilder var0) {
      String var1 = var0.nameFormat;
      Boolean var2 = var0.daemon;
      Integer var3 = var0.priority;
      UncaughtExceptionHandler var4 = var0.uncaughtExceptionHandler;
      ThreadFactory var5 = var0.backingThreadFactory != null?var0.backingThreadFactory:Executors.defaultThreadFactory();
      AtomicLong var6 = var1 != null?new AtomicLong(0L):null;
      return new ThreadFactoryBuilder$1(var5, var1, var6, var2, var3, var4);
   }

   private static String format(String var0, Object... var1) {
      return String.format(Locale.ROOT, var0, var1);
   }

   // $FF: synthetic method
   static String access$000(String var0, Object[] var1) {
      return format(var0, var1);
   }
}
