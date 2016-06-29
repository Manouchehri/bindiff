package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.util.concurrent.AbstractScheduledService$1;
import com.google.common.util.concurrent.AbstractScheduledService$CustomScheduler$ReschedulableCallable;
import com.google.common.util.concurrent.AbstractScheduledService$CustomScheduler$Schedule;
import com.google.common.util.concurrent.AbstractScheduledService$Scheduler;
import com.google.common.util.concurrent.AbstractService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

@Beta
public abstract class AbstractScheduledService$CustomScheduler extends AbstractScheduledService$Scheduler {
   public AbstractScheduledService$CustomScheduler() {
      super((AbstractScheduledService$1)null);
   }

   final Future schedule(AbstractService var1, ScheduledExecutorService var2, Runnable var3) {
      AbstractScheduledService$CustomScheduler$ReschedulableCallable var4 = new AbstractScheduledService$CustomScheduler$ReschedulableCallable(this, var1, var2, var3);
      var4.reschedule();
      return var4;
   }

   protected abstract AbstractScheduledService$CustomScheduler$Schedule getNextSchedule();
}
