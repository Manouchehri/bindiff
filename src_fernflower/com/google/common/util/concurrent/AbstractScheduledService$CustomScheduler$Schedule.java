package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.util.concurrent.TimeUnit;

@Beta
public final class AbstractScheduledService$CustomScheduler$Schedule {
   private final long delay;
   private final TimeUnit unit;

   public AbstractScheduledService$CustomScheduler$Schedule(long var1, TimeUnit var3) {
      this.delay = var1;
      this.unit = (TimeUnit)Preconditions.checkNotNull(var3);
   }

   // $FF: synthetic method
   static long access$700(AbstractScheduledService$CustomScheduler$Schedule var0) {
      return var0.delay;
   }

   // $FF: synthetic method
   static TimeUnit access$800(AbstractScheduledService$CustomScheduler$Schedule var0) {
      return var0.unit;
   }
}
