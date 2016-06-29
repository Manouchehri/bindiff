package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.util.concurrent.CycleDetectingLockFactory$1;
import com.google.common.util.concurrent.CycleDetectingLockFactory$ExampleStackTrace;
import com.google.common.util.concurrent.CycleDetectingLockFactory$LockGraphNode;

@Beta
public final class CycleDetectingLockFactory$PotentialDeadlockException extends CycleDetectingLockFactory$ExampleStackTrace {
   private final CycleDetectingLockFactory$ExampleStackTrace conflictingStackTrace;

   private CycleDetectingLockFactory$PotentialDeadlockException(CycleDetectingLockFactory$LockGraphNode var1, CycleDetectingLockFactory$LockGraphNode var2, CycleDetectingLockFactory$ExampleStackTrace var3) {
      super(var1, var2);
      this.conflictingStackTrace = var3;
      this.initCause(var3);
   }

   public CycleDetectingLockFactory$ExampleStackTrace getConflictingStackTrace() {
      return this.conflictingStackTrace;
   }

   public String getMessage() {
      StringBuilder var1 = new StringBuilder(super.getMessage());

      for(Object var2 = this.conflictingStackTrace; var2 != null; var2 = ((Throwable)var2).getCause()) {
         var1.append(", ").append(((Throwable)var2).getMessage());
      }

      return var1.toString();
   }

   // $FF: synthetic method
   CycleDetectingLockFactory$PotentialDeadlockException(CycleDetectingLockFactory$LockGraphNode var1, CycleDetectingLockFactory$LockGraphNode var2, CycleDetectingLockFactory$ExampleStackTrace var3, CycleDetectingLockFactory$1 var4) {
      this(var1, var2, var3);
   }
}
