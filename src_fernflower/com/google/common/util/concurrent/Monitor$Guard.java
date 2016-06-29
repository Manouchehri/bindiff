package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Monitor;
import java.util.concurrent.locks.Condition;
import javax.annotation.concurrent.GuardedBy;

@Beta
public abstract class Monitor$Guard {
   final Monitor monitor;
   final Condition condition;
   @GuardedBy("monitor.lock")
   int waiterCount = 0;
   @GuardedBy("monitor.lock")
   Monitor$Guard next;

   protected Monitor$Guard(Monitor var1) {
      this.monitor = (Monitor)Preconditions.checkNotNull(var1, "monitor");
      this.condition = Monitor.access$000(var1).newCondition();
   }

   public abstract boolean isSatisfied();
}
