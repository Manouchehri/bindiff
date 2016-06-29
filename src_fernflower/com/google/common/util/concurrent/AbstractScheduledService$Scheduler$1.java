package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractScheduledService$1;
import com.google.common.util.concurrent.AbstractScheduledService$Scheduler;
import com.google.common.util.concurrent.AbstractService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

final class AbstractScheduledService$Scheduler$1 extends AbstractScheduledService$Scheduler {
   // $FF: synthetic field
   final long val$initialDelay;
   // $FF: synthetic field
   final long val$delay;
   // $FF: synthetic field
   final TimeUnit val$unit;

   AbstractScheduledService$Scheduler$1(long var1, long var3, TimeUnit var5) {
      super((AbstractScheduledService$1)null);
      this.val$initialDelay = var1;
      this.val$delay = var3;
      this.val$unit = var5;
   }

   public Future schedule(AbstractService var1, ScheduledExecutorService var2, Runnable var3) {
      return var2.scheduleWithFixedDelay(var3, this.val$initialDelay, this.val$delay, this.val$unit);
   }
}
