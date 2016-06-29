package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractScheduledService$1;
import com.google.common.util.concurrent.AbstractScheduledService$Scheduler$1;
import com.google.common.util.concurrent.AbstractScheduledService$Scheduler$2;
import com.google.common.util.concurrent.AbstractService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class AbstractScheduledService$Scheduler {
   public static AbstractScheduledService$Scheduler newFixedDelaySchedule(long var0, long var2, TimeUnit var4) {
      Preconditions.checkNotNull(var4);
      Preconditions.checkArgument(var2 > 0L, "delay must be > 0, found %s", new Object[]{Long.valueOf(var2)});
      return new AbstractScheduledService$Scheduler$1(var0, var2, var4);
   }

   public static AbstractScheduledService$Scheduler newFixedRateSchedule(long var0, long var2, TimeUnit var4) {
      Preconditions.checkNotNull(var4);
      Preconditions.checkArgument(var2 > 0L, "period must be > 0, found %s", new Object[]{Long.valueOf(var2)});
      return new AbstractScheduledService$Scheduler$2(var0, var2, var4);
   }

   abstract Future schedule(AbstractService var1, ScheduledExecutorService var2, Runnable var3);

   private AbstractScheduledService$Scheduler() {
   }

   // $FF: synthetic method
   AbstractScheduledService$Scheduler(AbstractScheduledService$1 var1) {
      this();
   }
}
